/**
 * Copyright 2015 Altendis, Groupe Excilys (www.altendis.fr)
 */
package com.excilys.liferay.gatling.recorder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.excilys.liferay.gatling.model.Record;
import com.excilys.liferay.gatling.service.RecordLocalServiceUtil;
import com.excilys.liferay.gatling.service.UrlRecordLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.CookieKeys;
import com.liferay.portal.kernel.util.HttpUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.SessionParamUtil;
import com.liferay.portal.service.PortletLocalServiceUtil;


/**
 * Servlet Filter implementation class RecordFilter
 */
@MultipartConfig
public class RecorderFilter implements Filter {
	private static final Log LOG = LogFactoryUtil.getLog(RecorderFilter.class);
	private static final String NAMESPACE = "_gatling_WAR_gatlingliferayportlet_";
	private static final String URL_CONTROL_PANEL = "/group/control_panel/manage";
	private static final List<String> FORBIDDEN_PARAMS = new ArrayList<String>();
	
	/**
	 * The list of the currents URL that has been recorded
	 */
	private List<RecordURL> currentRecords;

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
		HttpServletRequest httpRequest = (HttpServletRequest)request;
		HttpSession session = httpRequest.getSession();
		
		toogleRecord(httpRequest, session);
		
		String infosRecorder = SessionParamUtil.getString(httpRequest, "GATLING_RECORD_STATE", null);
		if(infosRecorder != null) {
			String[] infos = infosRecorder.split(",");
			
			currentRecords = (List<RecordURL>) session.getAttribute("recordURL");
			if(currentRecords == null) { // if empty session recordURL create one
				currentRecords = new ArrayList<RecordURL>();
			}
			
			if (infos[1].equalsIgnoreCase("RECORD")) { 
				if(httpRequest.getParameter("doAsGroupId") != null) {  // we only record request with doAsGroupId (= portlet tested)
					saveURL(httpRequest, response, session);
				}
			} else if(infos[1].equalsIgnoreCase("STOP")) {
				stopRecording(session, infos);
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
		if(actionToggleRecord != null && actionToggleRecord.equals("toggleRecord")) {
			String recordState = ParamUtil.getString(httpRequest, NAMESPACE+"nextRecordState", null);
			String recordName = ParamUtil.getString(httpRequest, NAMESPACE+"useCaseRecordName", null);
			String portletId = ParamUtil.getString(httpRequest, NAMESPACE+"pagePortletId", null);
			if(recordState != null && recordName != null && portletId != null) {
				session.setAttribute("GATLING_RECORD_STATE", portletId+","+recordState+","+recordName);
			} else {
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
	 * @throws IOException If a buffering action failed
	 */
	private void saveURL(HttpServletRequest request, ServletResponse response, HttpSession session) throws IOException{
		Map<String, String[]> parametersMap = request.getParameterMap();
		String params = HttpUtil.parameterMapToString(filterParameters(request.getParameterMap()));
		String requestURL = request.getRequestURI().replace(URL_CONTROL_PANEL, "");
		
		if(request.getMethod().equalsIgnoreCase("post")) {
			
			//TODO: Find a way to remove silent exception throwing
			Collection<Part> parts = null;
			try {
				parts = request.getParts();
			} catch(Exception e) {
				LOG.error("Parts were not found");
				LOG.error(e.getMessage());
			}
			
			params = computeParametersFromMultiParts(params, parts, parametersMap.keySet());
			
			// Check if param contains "lifecycle=1" (processAction -> form) 
			// 		AND if param does NOT contain "formDate"(ie the form isn't recorded -> multipart didn't work ...)
			if(params.contains("lifecycle=1") && !params.contains("formDate")) {
				//Create a cookie for error
				Cookie cookie = new Cookie("multipart-error", "true");
				CookieKeys.addCookie((HttpServletRequest) request, (HttpServletResponse)response, cookie);
			}
		}
		RecordURL record = new RecordURL(request.getMethod(), requestURL, params);
		LOG.debug(record);
		currentRecords.add(record);
		session.setAttribute("recordURL", currentRecords);
	}
	
	
	/**
	 * Stop the recording by persisting the record and all the URLs.
	 * @param session The current session
	 * @param infos The record infos
	 */
	private void stopRecording(HttpSession session, String[] infos){
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
					String url = currentRecords.get(i).getUrl()+currentRecords.get(i).getParams();
					String type = currentRecords.get(i).getMethod();
					UrlRecordLocalServiceUtil.save(url, type, i, record.getRecordId());
					LOG.debug("...");
				}
				LOG.debug("...2/2");
			} catch (SystemException e) {
				LOG.error("Error saving use case ...\n"+e.getMessage());
			}
		}
	}
	
	/**
	 * Computes the String that will hold all the multiparts form parameters if those parts are valide.
	 * @param initialParameters The initial parameters that will be present in the final result
	 * @param parts The several parts of the form
	 * @param valideParameters A set that contains the names of all the valideParameters
	 * @return The computed parameters string
	 * @throws IOException If an error occurs while extracting parts content
	 */
	private static String computeParametersFromMultiParts(String initialParameters, Collection<Part> parts, Set<String> valideParameters) throws IOException{
		if(parts != null && !parts.isEmpty()) {
			LOG.debug("is MultipartContent "+parts.size());
			StringBuilder result = new StringBuilder(initialParameters);
			for (Part part : parts) {
				String name = part.getName();
				if(!name.equals("null") && !valideParameters.contains(name)) {
					BufferedReader reader = new BufferedReader(new InputStreamReader(part.getInputStream()));
					StringBuilder value = new StringBuilder();
					char[] buffer = new char[10240]; //TODO: Find why 10240
					for (int length = 0; (length = reader.read(buffer)) > 0;) {
						value.append(buffer, 0, length);
					}
					String input = value.toString();
					LOG.debug("\t"+name+" : "+input);
					result.append("&").append(name).append("=").append(input);
				}
			}
			return result.toString();
		}
		else {
			return initialParameters;
		}
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
	

	private class RecordURL {
		private final String method;
		private final String url;
		private final String params;

		public RecordURL(String method, String requestURL, String params) {
			this.method = method;
			this.url = requestURL;
			this.params = params;
		}

		public String getMethod() {
			return method;
		}

		public String getUrl() {
			return url;
		}

		public String getParams() {
			return params;
		}

		@Override
		public String toString() {
			return "RecordURL [method=" + method + ", url=" + url + ", params="
					+ params + "]";
		}
	}
}
