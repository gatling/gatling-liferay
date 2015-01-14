package com.excilys.liferay.gatling.controller;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;
import org.springframework.web.portlet.bind.annotation.ResourceMapping;

import com.excilys.liferay.gatling.service.RequestLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

@Controller(value="RequestController")
@RequestMapping("VIEW")
public class RequestController {
	
	private static final Log LOG = LogFactoryUtil.getLog(RequestController.class);
	
	@RenderMapping(params="render=editRequest")
	public String editRequestRenderRequest(RenderRequest request, RenderResponse response, Model model){
		
		return "view";
	}
	
	@ActionMapping(params="render=deleteScenario")
	public String deleteSRequestRenderRequest(ActionRequest request, ActionResponse response, Model model) throws SystemException, PortalException {
		
		long requestId = Long.parseLong(request.getParameter("requestId"));
		RequestLocalServiceUtil.deleteRequest(requestId);
		LOG.debug("request deleted successfully ");
		response.setRenderParameter("scenarioId", request.getParameter("scenarioId"));
		return "editScenario";
	}
	
	@ActionMapping(params="render=addScenario")
	public String addRequestRenderRequest(RenderRequest request, RenderResponse response, Model model){
		
		return "view";
	}
	
	@ResourceMapping(value="oneScript")
	public String serveOneScript(RenderRequest request, RenderResponse response, Model model){
		
		return "view";
	}
}