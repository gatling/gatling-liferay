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
import com.liferay.portal.kernel.util.HttpUtil;
/**
 * Servlet Filter implementation class RecordFilter
 */
public class RecorderFilter implements Filter {
	private static final Log LOG = LogFactoryUtil.getLog(RecorderFilter.class);
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

		boolean recording = false;
		/*
		 * Recording
		 */
		if(recording) {
			HttpSession session = httpRequest.getSession();
			if(session.getAttribute("recordURL") == null) {
				session.setAttribute("recordURL", new ArrayList<String>());
			}
			List<String> recordURLs = (List<String>) session.getAttribute("recordURL");
			LOG.info("========================");
			String params = HttpUtil.parameterMapToString(request.getParameterMap());
			LOG.info("URL ("+httpRequest.getMethod()+") : "+params);
			recordURLs.add(params);
			LOG.info("========================");
			//Store it again
			session.setAttribute("recordURL", recordURLs);
		}
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

}
