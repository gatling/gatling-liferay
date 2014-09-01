package com.excilys.liferay.gatling.recorder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.CookieKeys;
import com.liferay.portal.kernel.util.HttpUtil;
/**
 * Servlet Filter implementation class RecordFilter
 */
public class RecorderFilter implements Filter {
	private static final Log LOG = LogFactoryUtil.getLog(RecorderFilter.class);
	private static final String GATLING_PPID="gatling_WAR_gatlingliferayportlet";
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
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */

	@SuppressWarnings("unchecked")
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest)request;
		//Cookie is only available for our portlet (scope)
		String state = CookieKeys.getCookie(httpRequest, "GATLING_RECORD_STATE");
		
		/*
		 * Recording
		 */
		if(state != null) {
			String[] infos = state.split(",");
			String ppid = request.getParameter("p_p_id");
			// We do not record action on our own portlet
			if(state != null && infos.length == 3 // size cookie correct
					&& !infos[0].equals(GATLING_PPID) && !ppid.equals(GATLING_PPID)) { // not gatling action
				switch (infos[1]) {
				case "RECORD": 
					HttpSession session = httpRequest.getSession();
					// get the recorded Urls list
					if(session.getAttribute("recordURL") == null) {
						session.setAttribute("recordURL", new ArrayList<String>());
					}
					List<String> recordURLs = (List<String>) session.getAttribute("recordURL");
					
					// get the parameters
					String params = HttpUtil.parameterMapToString(request.getParameterMap());
					// Display
					LOG.info("======"+infos[2]+"======");
					LOG.info("URL ("+httpRequest.getMethod()+") : "+params);
					// Save
					recordURLs.add(params);
					// Store it again
					session.setAttribute("recordURL", recordURLs);
					break;
				case "STOP":
				default:
					LOG.info("Stopping ...");
					break;
				}
				
			}
		}
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

}
