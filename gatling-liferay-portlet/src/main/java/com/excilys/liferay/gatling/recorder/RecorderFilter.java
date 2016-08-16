/**
 * Copyright 2015 Altendis, Groupe Excilys (www.altendis.fr)
 */
package com.excilys.liferay.gatling.recorder;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;

import java.io.IOException;

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
	
	protected static final Log LOG = LogFactoryUtil.getLog(RecorderFilter.class);

	private static final String NAMESPACE = "_gatling_WAR_gatlingliferayportlet_";
	private static final String RECORDING_STATE = "RecordingState";
	
	public static final String TOGGLE_ADVANCED = "toggleAdvanced";
	public static final String TOGGLE_SMOOTHY = "toggleSmooty";
	public static final String TOGGLE_STOP = "toggleStop";
	public static final String TOGGLE_ACTION = "action";
	
	private RecorderManager advancedRecorderManager;
	private RecorderManager smoothRecorderManager;
	
	public static enum RecorderState {
		ADVANCED_RECORDING, SMOOTHY_RECORDING, ADVANCED_STOP, SMOOTHY_STOP, IDLE 
	}


	/**
	 * Default constructor. 
	 */
	public RecorderFilter() {
		advancedRecorderManager = new RecorderManager();
		smoothRecorderManager = new SmoothRecorderManager();
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
		switch(managerHandling(request)){
		case ADVANCED_RECORDING:
		case ADVANCED_STOP:
			advancedRecorderManager.record(request, response);
			break;
		case SMOOTHY_RECORDING:
		case SMOOTHY_STOP:
			smoothRecorderManager.record(request, response);
			break;
		}
		chain.doFilter(request, response);
	}
	
	
	public RecorderState managerHandling(ServletRequest request){
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpSession session = httpRequest.getSession();
		
		String actionToggle = ParamUtil.getString(httpRequest, NAMESPACE + TOGGLE_ACTION, "empty");
		
		RecorderState currentState = (RecorderState) session.getAttribute(RECORDING_STATE);
		
		if(actionToggle.equals(TOGGLE_ADVANCED)){
			session.setAttribute(RECORDING_STATE, RecorderState.ADVANCED_RECORDING);
			return RecorderState.ADVANCED_RECORDING;
		}
		else if(actionToggle.equals(TOGGLE_SMOOTHY)){
			session.setAttribute(RECORDING_STATE, RecorderState.SMOOTHY_RECORDING);
			return RecorderState.SMOOTHY_RECORDING;
		}
		else if(actionToggle.equals(TOGGLE_STOP) && currentState != null && currentState.equals(RecorderState.ADVANCED_RECORDING)){
			session.setAttribute(RECORDING_STATE, RecorderState.IDLE);
			return RecorderState.ADVANCED_STOP;
		}
		else if(actionToggle.equals(TOGGLE_STOP) && currentState != null && currentState.equals(RecorderState.SMOOTHY_RECORDING)){
			session.setAttribute(RECORDING_STATE, RecorderState.IDLE);
			return RecorderState.SMOOTHY_STOP;
		}
		else return RecorderState.SMOOTHY_STOP;
	}
	
}
