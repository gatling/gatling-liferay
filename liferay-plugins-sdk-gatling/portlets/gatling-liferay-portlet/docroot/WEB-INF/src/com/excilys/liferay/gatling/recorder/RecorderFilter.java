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
			if(state != null && infos.length == 3) {  // size cookie correct
				HttpSession session = httpRequest.getSession();
				// get the recorded Urls list
				if(session.getAttribute("recordURL") == null) {
					session.setAttribute("recordURL", new ArrayList<String>());
				}
				List<String> recordURLs = (List<String>) session.getAttribute("recordURL");
				switch (infos[1]) {
				case "RECORD": 
					if(httpRequest.getParameter("doAsGroupId") != null) {  // we only record request with doAsGroupId (= portlet tested)
						// get the parameters
						String params = HttpUtil.parameterMapToString(request.getParameterMap());
						// Display
						LOG.info("URL ("+httpRequest.getMethod()+") : "+params);
						// Save
						recordURLs.add(params);
						// Store it again
						session.setAttribute("recordURL", recordURLs);
					}
					break;
				case "STOP":
					session.setAttribute("recordURL", new ArrayList<String>());
					if(!recordURLs.isEmpty()) {
						LOG.info("Saving ...");
						try {
							long primaryKeyRecord;
							primaryKeyRecord = CounterLocalServiceUtil.increment(Record.class.getName());
							Record record = RecordLocalServiceUtil.createRecord(primaryKeyRecord);
							record.setName(infos[2]);
							record.setPortletId(infos[0]);
							record.setVersionPortlet(1); //TODO get the real version
							record.persist();
							LOG.info("... 1/2");
							for (int i = 0; i < recordURLs.size(); i++) {
								String url = recordURLs.get(i);
								long primaryKeyUrl = CounterLocalServiceUtil.increment(UrlRecord.class.getName());
								UrlRecord urlRecord = UrlRecordLocalServiceUtil.createUrlRecord(primaryKeyUrl);
								urlRecord.setUrl(url);
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
