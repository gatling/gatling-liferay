/**
 * Copyright 2015 Altendis, Groupe Excilys (www.altendis.fr)
 */
package com.excilys.liferay.gatling.recorder;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.MultipartConfig;


/**
 * Servlet Filter implementation class RecordFilter
 */
@MultipartConfig
public class RecorderFilter implements Filter {
	

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
		
		chain.doFilter(request, response);
	}
	
	
}
