/**
 * Copyright 2014 eBusiness Information, Groupe Excilys (www.ebusinessinformation.fr)
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

	static {
		FORBIDDEN_PARAMS.add("doAsGroupId");
		FORBIDDEN_PARAMS.add("p_p_auth");
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


	private Map<String,String[]> filterParameters(Map<String,String[]> parameters) {
		Map<String,String[]> params = new HashMap<String, String[]>(parameters);
		for (String key : FORBIDDEN_PARAMS) {
			params.remove(key);
		}
		return params;
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
		/*
		 * Recording
		 */
		String infosRecorder = SessionParamUtil.getString(httpRequest, "GATLING_RECORD_STATE", null);
		if(infosRecorder != null) { 
			String[] infos = infosRecorder.split(",");

			if(session.getAttribute("recordURL") == null) { // if empty session recordURL create one
				session.setAttribute("recordURL", new ArrayList<String>());
			}
			// get the recorded Urls list
			List<RecordURL> recordURLs = (List<RecordURL>) session.getAttribute("recordURL");
			// cases (Java 6)
			if (infos[1].equalsIgnoreCase("RECORD")) { 
				if(httpRequest.getParameter("doAsGroupId") != null) {  // we only record request with doAsGroupId (= portlet tested)
					// get the parameters
					String params = HttpUtil.parameterMapToString(filterParameters(request.getParameterMap()));
					String requestURL = httpRequest.getRequestURI().replace(URL_CONTROL_PANEL, "");

					if(httpRequest.getMethod().equalsIgnoreCase("post")) {
						/*
						 * Get the content of multipart/form-data 
						 */
						Collection<Part> parts = null;
						try {
							parts = httpRequest.getParts();
						} catch(Exception e) {
							//do nothing
							LOG.info(e.getMessage());
						}
						if(parts != null && !parts.isEmpty()) {
							LOG.info("is MultipartContent "+parts.size());
							StringBuilder sb = new StringBuilder(params);
							for (Part part : parts) {
								String name = part.getName();
								BufferedReader reader = new BufferedReader(new InputStreamReader(part.getInputStream()));
								StringBuilder value = new StringBuilder();
								char[] buffer = new char[10240];
								for (int length = 0; (length = reader.read(buffer)) > 0;) {
									value.append(buffer, 0, length);
								}
								String input = value.toString();
								LOG.debug("\t"+name+" : "+input);
								sb.append("&").append(name).append("=").append(input);
							}
							params = sb.toString();
						}
						// Check if param doest NOT contain formDate (ie the form isn't recorded -> multipart didn't work ...)
						if(!params.contains("_formDate")) {
							//Create a cookie for error
							Cookie cookie = new Cookie("multipart-error", "true");
							CookieKeys.addCookie((HttpServletRequest) request, (HttpServletResponse)response, cookie);
						}
					}
					RecordURL record = new RecordURL(httpRequest.getMethod(), requestURL, params);
					// Display for debug
					LOG.info(record);
					// Save
					recordURLs.add(record);
					// Store it in the session
					session.setAttribute("recordURL", recordURLs);
				}
			} else if(infos[1].equalsIgnoreCase("STOP")) {
				// Remove from session
				session.removeAttribute("recordURL");
				// Check if we have something to record
				if(!recordURLs.isEmpty()) {
					LOG.info("Saving ...");
					try {
						//Save use case table
						String portletVersion = PortletLocalServiceUtil.getPortletById(infos[0]).getPluginPackage().getVersion();
						LOG.info("version de portlet "+portletVersion);
						Record record = RecordLocalServiceUtil.save(infos[2], infos[0], portletVersion);
						LOG.info("...1/2");
						//Save url table
						for (int i = 1; i < recordURLs.size(); i++) {
							String url = recordURLs.get(i).getUrl()+recordURLs.get(i).getParams();
							String type = recordURLs.get(i).getMethod();
							UrlRecordLocalServiceUtil.save(url, type, i, record.getRecordId());
							LOG.info("...");
						}
						LOG.info("...2/2");
					} catch (SystemException e) {
						LOG.error("Error saving use case ...\n"+e.getMessage());
					}
				}
			}
		}
		// pass the request along the filter chain

		chain.doFilter(request, response);
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
