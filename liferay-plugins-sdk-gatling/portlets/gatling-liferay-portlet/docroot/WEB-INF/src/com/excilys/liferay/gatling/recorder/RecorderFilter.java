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

import com.excilys.liferay.gatling.model.Record;
import com.excilys.liferay.gatling.model.UrlRecord;
import com.excilys.liferay.gatling.service.RecordLocalServiceUtil;
import com.excilys.liferay.gatling.service.UrlRecordLocalServiceUtil;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.CookieKeys;
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
		//Cookie is only available for our portlet (scope)
		String cookie = CookieKeys.getCookie(httpRequest, "GATLING_RECORD_STATE");

		/*
		 * Recording
		 */
		if(cookie != null) { // if cookie (ie in our portlet)
			String[] infos = cookie.split(",");
			if(cookie != null && infos.length == 3) {  // size cookie correct [portletId,State,NameUsecase]
				HttpSession session = httpRequest.getSession();
				if(session.getAttribute("recordURL") == null) { // if empty session recordURL create one
					session.setAttribute("recordURL", new ArrayList<String>());
				}
				// get the recorded Urls list
				List<String> recordURLs = (List<String>) session.getAttribute("recordURL");
				// cases of cookie
				if (infos[1].equalsIgnoreCase("RECORD")) { 
					if(httpRequest.getParameter("doAsGroupId") != null) {  // we only record request with doAsGroupId (= portlet tested)
						// get the parameters
						String params = HttpUtil.parameterMapToString(request.getParameterMap());
						// Display for debug
						LOG.info("URL ("+httpRequest.getMethod()+") : "+params);
						// Save
						recordURLs.add(httpRequest.getMethod()+")"+params);
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
							//Save usecase table
							long primaryKeyRecord = CounterLocalServiceUtil.increment(Record.class.getName());
							Record record = RecordLocalServiceUtil.createRecord(primaryKeyRecord);
							record.setName(infos[2]);
							record.setPortletId(infos[0]);
							record.setVersionPortlet(1); //TODO get the real version
							record.persist();
							LOG.info("...1/2");
							//Save url table
							for (int i = 0; i < recordURLs.size(); i++) {
								String url = recordURLs.get(i).split("\\)")[1];
								String type = recordURLs.get(i).split("\\)")[0];
								long primaryKeyUrl = CounterLocalServiceUtil.increment(UrlRecord.class.getName());
								UrlRecord urlRecord = UrlRecordLocalServiceUtil.createUrlRecord(primaryKeyUrl);
								urlRecord.setUrl(url);
								urlRecord.setType(type);
								urlRecord.setOrder(i);
								urlRecord.setRecordId(record.getRecordId());
								urlRecord.persist();
								LOG.info("...");
							}
							LOG.info("...2/2");
						} catch (SystemException e) {
							LOG.error("Error saving use case ...\n"+e.getMessage());
						}
					}
				}
			}
		}
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

}
