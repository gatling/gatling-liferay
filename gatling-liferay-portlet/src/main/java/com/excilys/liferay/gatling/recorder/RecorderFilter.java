/**
 * Copyright 2015 Altendis, Groupe Excilys (www.altendis.fr)
 */
package com.excilys.liferay.gatling.recorder;

import com.excilys.liferay.gatling.model.Record;
import com.excilys.liferay.gatling.recorder.records.GetURL;
import com.excilys.liferay.gatling.recorder.records.PostMultipartURL;
import com.excilys.liferay.gatling.recorder.records.PostURL;
import com.excilys.liferay.gatling.recorder.records.RecordURL;
import com.excilys.liferay.gatling.service.RecordLocalServiceUtil;
import com.excilys.liferay.gatling.service.UrlRecordLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.HttpUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.SessionParamUtil;
import com.liferay.portal.service.PortletLocalServiceUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


/**
 * Servlet Filter implementation class RecordFilter
 */
@MultipartConfig
public class RecorderFilter implements Filter {
	private static final Log LOG = LogFactoryUtil.getLog(RecorderFilter.class);
	private static final String NAMESPACE = "_gatling_WAR_gatlingliferayportlet_";
	private static final String URL_CONTROL_PANEL = "/group/control_panel/manage";
	private static final List<String> FORBIDDEN_PARAMS = new ArrayList<String>();

	//When we are not focused on a portlet but we are on a page, we put the id to -1
	private static final String INEXISTANT_PORTLET_ID = "_default_";
	private static final String CURRENT_VERSION = "6.2";
	
	private static final int INFO_PORTLET_ID = 0;
	private static final int INFO_RECORD_STATE = 1;
	private static final int INFO_RECORD_NAME = 2;
	
	static {
		FORBIDDEN_PARAMS.add("doAsGroupId");
	}

	/**
	 * Default constructor. 
	 */
	public RecorderFilter() {
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
	}
	
	/**
	 * Gatling's recorder filter. It records all the url visited from the <i>Portlet Config</i> in the plugin <b>Gatling Liferay</b>.
	 * 
	 * It uses session to store all the visited URLs and next saves it in DB.
	 */
	@SuppressWarnings("unchecked")
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		LOG.debug("doFilterCalled");
		HttpServletRequest httpRequest = (HttpServletRequest)request;
		HttpSession session = httpRequest.getSession();
		
		toogleRecord(httpRequest, session);
		
		String infosRecorder = SessionParamUtil.getString(httpRequest, "GATLING_RECORD_STATE", null);
		if(infosRecorder != null) {
			String[] infos = infosRecorder.split(",");
			
			List<RecordURL> currentRecords = (List<RecordURL>) session.getAttribute("recordURL");
			if(currentRecords == null) { // if empty session recordURL create one
				currentRecords = new ArrayList<RecordURL>();
			}
			
			if (infos[INFO_RECORD_STATE].equalsIgnoreCase("RECORD")) { 
				saveURL(httpRequest, response, session, currentRecords);	
			} else if(infos[INFO_RECORD_STATE].equalsIgnoreCase("STOP")) {
				request.setAttribute("recordName", infos[INFO_RECORD_NAME]);
				stopRecording(session, infos, currentRecords);
			}
		}
		chain.doFilter(request, response);
	}
	
	
	/**
	 * Toogle the record mode if the portlet action is valid.
	 * @param httpRequest The HTTP request
	 * @param session The current session
	 */
	private static void toogleRecord(HttpServletRequest httpRequest, HttpSession session){
		String actionToggleRecord = ParamUtil.getString(httpRequest, NAMESPACE+"javax.portlet.action",null);
		
		if((actionToggleRecord != null && actionToggleRecord.equals("toggleRecord"))) {
			String recordState = ParamUtil.getString(httpRequest, NAMESPACE+"nextRecordState", null);
			String recordName = ParamUtil.getString(httpRequest, NAMESPACE+"useCaseRecordName", null);
			String portletId = ParamUtil.getString(httpRequest, NAMESPACE+"pagePortletId", null);
			LOG.debug("recordState: "+recordState+",\trecordeName: "+recordName+"\tportletId:"+portletId);
			if(recordState != null && recordName != null && portletId != null) {
				session.setAttribute("GATLING_RECORD_STATE", portletId+","+recordState+","+recordName);
			}
			else if (recordState != null && recordName != null ) {
				
				session.setAttribute("GATLING_RECORD_STATE", INEXISTANT_PORTLET_ID +","+recordState+","+recordName);
			}
			else {
				session.removeAttribute("GATLING_RECORD_STATE");
			}
		}
	}
	
	
	
	/**
	 * Save the URL of the request in the currentRecords and update the recordURL session attribute.
	 * If a form is invalid, the function stores an error in a cookie.
	 * @param request The HTTP request
	 * @param response The HTTP Response
	 * @param session The current session
	 * @param currentRecords The current recorded urls
	 * @throws IOException If a buffering action failed
	 */
	private static void saveURL(HttpServletRequest request, ServletResponse response, HttpSession session, List<RecordURL> currentRecords) throws IOException{
		
		LOG.info("Save the URL");
		
		Map<String, String[]> parametersMap = request.getParameterMap();
		String params = HttpUtil.parameterMapToString(filterParameters(parametersMap));
		String requestURL = request.getRequestURI().replace(URL_CONTROL_PANEL, "");
		
		RecordURL record = null;
		if(request.getMethod().equalsIgnoreCase("post")) {	
			if (request.getContentType() != null && request.getContentType().toLowerCase().contains("multipart/form-data")) {
				//Multipart Form case
				record = computeDataFromMultiParts(request, requestURL, params);
			}
			else {
				//Normal Form case
				record = computeParamsFromNormalForm(request, requestURL, params);
			}
		}
		else {
			//Get Case
			record = new GetURL(requestURL, params);
		} 
		
		LOG.debug(record);
		currentRecords.add(record);
		session.setAttribute("recordURL", currentRecords);
	}
	
	
	/**
	 * Stop the recording by persisting the record and all the URLs.
	 * @param session The current session
	 * @param infos The record infos
	 * @param currentRecords The current recorded urls
	 */
	private static void stopRecording(HttpSession session, String[] infos, List<RecordURL> currentRecords){
		// Remove from session
		session.removeAttribute("recordURL");
		// Check if we have something to record
		if(!currentRecords.isEmpty()) {
			try {
				
				Record record;
				
				if(infos[INFO_PORTLET_ID].equals(INEXISTANT_PORTLET_ID)){
					LOG.debug("Saving Smoothy record...");
					currentRecords.remove(0);
					
					//If the default record already exists, erase all his instances in BDD
					List<Record> records = RecordLocalServiceUtil.findByPortletId(INEXISTANT_PORTLET_ID);
					for (Record defaultRecord : records) {
						RecordLocalServiceUtil.deleteRecord(defaultRecord);
					}
					
					record = RecordLocalServiceUtil.save(infos[INFO_RECORD_NAME], INEXISTANT_PORTLET_ID, CURRENT_VERSION);
				}
				
				/* Advanced case */
				else {
					String portletVersion = PortletLocalServiceUtil.getPortletById(infos[INFO_PORTLET_ID]).getPluginPackage().getVersion();
					record = RecordLocalServiceUtil.save(infos[INFO_RECORD_NAME], infos[INFO_PORTLET_ID], portletVersion);
				}
				
				LOG.debug("Record saved !");
				for (int i = 1; i < currentRecords.size(); i++) {
					currentRecords.get(i).saveURL(i, record.getRecordId());
				}
				LOG.debug("Urls saved !");

			} catch (SystemException e) {
				LOG.error("Error saving use case ...\n"+e.getMessage());
			}
		}
	}
	
	/**
	 * Computes the record url that will hold all the multiparts form parameters.
	 * @param request The current HTTP request
	 * @return the current url as a post url with multiparts data
	 * @throws IOException If an error occurs while extracting parts content
	 */
	private static RecordURL computeDataFromMultiParts(HttpServletRequest request, String requestURL, String params) throws IOException{
		StringBuffer content = new StringBuffer();
		String line = null;
		BufferedReader reader = new BufferedReader(new InputStreamReader(request.getInputStream()));
		while( (line = reader.readLine()) != null){
			content.append(line).append("\n");
		}
		return new PostMultipartURL(requestURL, params, content.toString());
	}
	
	/**
	 * Computes the record url that will hold all the form parameters 
	 * @param request The current HTTP request
	 * @return the current url as a normal post url with his parameters
	 */
	private static RecordURL computeParamsFromNormalForm(HttpServletRequest request, String RequestURL, String params){
		
		//TODO: Yann: Substract from URL parameters, Thank You <3
		Map<String, String[]> form = request.getParameterMap();
		
		Map<String, String> formParams = new HashMap<>();
		return new PostURL(RequestURL, params, formParams);
	}
	
	
	
	/**
	 * Remove forbidden parameters from URL. We return a cleaner URL for Gatling Scripts
	 * @param parameters
	 * @return
	 */
	private static Map<String,String[]> filterParameters(Map<String,String[]> parameters) {
		Map<String,String[]> params = new HashMap<String, String[]>(parameters);
		for (String key : FORBIDDEN_PARAMS) {
			params.remove(key);
		}
		return params;
	}
	
}
