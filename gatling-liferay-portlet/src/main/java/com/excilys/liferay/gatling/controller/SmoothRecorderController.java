/**
 * Copyright 2015 Altendis, Groupe Excilys (www.altendis.fr)
 */
package com.excilys.liferay.gatling.controller;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;


/**
 * Controller linked to the default view
 */
@Controller(value = "ViewController")
@RequestMapping("VIEW")
public class SmoothRecorderController {

	private static final Log LOG = LogFactoryUtil.getLog(SmoothRecorderController.class);

	@RenderMapping(params = "render=renderRecorderView")
	public String renderRequest(final RenderRequest renderRequest,
			final RenderResponse renderResponse, final Model model) throws SystemException {
		LOG.debug("render View");
		
		
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		renderRequest.setAttribute("groupId", themeDisplay.getScopeGroupId());
		
		// Check state of recording
				String nextState;
				final String state = renderRequest.getParameter("recordState");
				LOG.debug("current state:"+state );
				if(state != null) {
					if(state.equals("RECORD")) {
						nextState ="STOP";
					} else {
						nextState = "RECORD";
					}
				} else {
					nextState = "RECORD";
				}
				LOG.debug("nextState is "+nextState);
				renderRequest.setAttribute("NEXT_STATE", nextState);
				
		return "smoothRecorderView";
	}
	
	@ActionMapping(params="action=toggleRecord2")
	public void toggleRecordAction(final ActionRequest request, final ActionResponse response, final Model model){
		final String recordState = ParamUtil.getString(request, "nextRecordState");
		LOG.debug("Toggle Record from smooth called");
		response.setRenderParameter("recordState", recordState);
		//hack, only work this way ....
		//response.setRenderParameter("p_p_state", "pop_up");
		PortalUtil.copyRequestParameters(request, response);
		response.setRenderParameter("render", "renderRecorderView");
		//Hide success message for this action
		
		//
		
		//request.setAttribute("NEXT_STATE", nextState);
		SessionMessages.add(request, PortalUtil.getPortletId(request)+SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_SUCCESS_MESSAGE);
	}

	/**
	 * Takes all the renders without param.
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 * @throws SystemException 
	 */
	@RenderMapping
	public String handleRenderRequest(final RenderRequest request,
			final RenderResponse response, final Model model) throws SystemException {
		return renderRequest(request, response, model);
	}
}
