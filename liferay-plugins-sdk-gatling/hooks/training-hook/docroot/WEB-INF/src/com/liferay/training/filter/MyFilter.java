package com.liferay.training.filter;

import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class MyFilter implements Filter {
	public void destroy() {
		System.out.println("Called MyFilter.destroy()");
	}

	public void doFilter(ServletRequest servletRequest,
			ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {

		String uri = (String) servletRequest
				.getAttribute(WebKeys.INVOKER_FILTER_URI);

		System.out.println("Called MyFilter.doFilter( servlet Request: "
				+ servletRequest + ", servlet Response: " + servletResponse
				+ ", filter Chain: " + filterChain + ") for URI: " + uri);

		filterChain.doFilter(servletRequest, servletResponse);
	}

	public void init(FilterConfig filterConfig) {
		System.out.println("Called MyFilter.init(" + filterConfig
				+ ") where hello=" + filterConfig.getInitParameter("hello"));
	}
}
