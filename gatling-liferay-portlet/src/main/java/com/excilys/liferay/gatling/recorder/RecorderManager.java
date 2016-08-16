package com.excilys.liferay.gatling.recorder;

import com.excilys.liferay.gatling.model.Record;
import com.excilys.liferay.gatling.recorder.records.GetURL;
import com.excilys.liferay.gatling.recorder.records.PostMultipartURL;
import com.excilys.liferay.gatling.recorder.records.PostURL;
import com.excilys.liferay.gatling.recorder.records.RecordURL;
import com.excilys.liferay.gatling.service.RecordLocalServiceUtil;
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

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class RecorderManager {

	protected static final Log LOG = LogFactoryUtil.getLog(RecorderFilter.class);
	protected static final String NAMESPACE = "_gatling_WAR_gatlingliferayportlet_";
	protected static final String URL_CONTROL_PANEL = "/group/control_panel/manage";
	protected static final List<String> FORBIDDEN_PARAMS = new ArrayList<String>();

	static {
		FORBIDDEN_PARAMS.add("doAsGroupId");
	}
	
	public void record(ServletRequest request, ServletResponse response) throws IOException, ServletException{
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
			
			if (infos[1].equalsIgnoreCase("RECORD")) { 
				if(httpRequest.getParameter("doAsGroupId") != null) {  // we only record request with doAsGroupId (= portlet tested)
					saveURL(httpRequest, response, session, currentRecords);
					LOG.debug("Saving URL");
				}
			} else if(infos[1].equalsIgnoreCase("STOP")) {
				stopRecording(session, infos, currentRecords);
			}
		}
	}
	
	/**
	 * Toogle the record mode if the portlet action is valid.
	 * @param httpRequest The HTTP request
	 * @param session The current session
	 */
	protected void toogleRecord(HttpServletRequest httpRequest, HttpSession session){
		String actionToggleRecord = ParamUtil.getString(httpRequest, NAMESPACE+"javax.portlet.action",null);

		//Boolean isSmoothy = ParamUtil.getBoolean(httpRequest, NAMESPACE+"smoothy", false);
		//LOG.debug("isSmoothy"+isSmoothy);
		if(/*isSmoothy || */(actionToggleRecord != null && actionToggleRecord.equals("toggleRecord"))) {
			String recordState = ParamUtil.getString(httpRequest, NAMESPACE+"nextRecordState", null);
			String recordName = ParamUtil.getString(httpRequest, NAMESPACE+"useCaseRecordName", null);
			String portletId = ParamUtil.getString(httpRequest, NAMESPACE+"pagePortletId", null);
			LOG.debug("recordState: "+recordState+",\trecordeName: "+recordName+"\tportletId:"+portletId/*+"\tisSmoothy: "+isSmoothy*/);
			if(recordState != null && recordName != null && portletId != null) {
				session.setAttribute("GATLING_RECORD_STATE", portletId+","+recordState+","+recordName);
			}
			else if (/*isSmoothy && */recordState != null && recordName != null ) {
				session.setAttribute("GATLING_RECORD_STATE", "0"+","+recordState+","+recordName);
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
	protected void saveURL(HttpServletRequest request, ServletResponse response, HttpSession session, List<RecordURL> currentRecords) throws IOException{
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
				//TODO: Split the parameters!
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
	protected void stopRecording(HttpSession session, String[] infos, List<RecordURL> currentRecords){
		// Remove from session
		session.removeAttribute("recordURL");
		// Check if we have something to record
		if(!currentRecords.isEmpty()) {
			LOG.debug("Saving ...");
			try {
				//Save use case table
				String portletVersion = PortletLocalServiceUtil.getPortletById(infos[0]).getPluginPackage().getVersion();
				LOG.debug("version de portlet "+portletVersion);
				Record record = RecordLocalServiceUtil.save(infos[2], infos[0], portletVersion);
				LOG.debug("...1/2");
				//Save url table
				for (int i = 1; i < currentRecords.size(); i++) {
					currentRecords.get(i).saveURL(i, record.getRecordId());
					LOG.debug("...");
				}
				LOG.debug("...2/2");
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
	protected RecordURL computeDataFromMultiParts(HttpServletRequest request, String requestURL, String params) throws IOException{
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
	protected RecordURL computeParamsFromNormalForm(HttpServletRequest request, String RequestURL, String params){
		//TODO: split the form params
		return new PostURL(RequestURL, params);
	}
	
	
	/**
	 * Remove forbidden parameters from URL. We return a cleaner URL for Gatling Scripts
	 * @param parameters
	 * @return
	 */
	protected Map<String,String[]> filterParameters(Map<String,String[]> parameters) {
		Map<String,String[]> params = new HashMap<String, String[]>(parameters);
		for (String key : FORBIDDEN_PARAMS) {
			params.remove(key);
		}
		return params;
	}
	
}
