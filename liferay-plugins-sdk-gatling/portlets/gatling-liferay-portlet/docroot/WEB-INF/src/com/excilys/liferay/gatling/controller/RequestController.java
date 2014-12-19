package com.excilys.liferay.gatling.controller;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;
import org.springframework.web.portlet.bind.annotation.ResourceMapping;

@Controller(value="RequestController")
@RequestMapping("VIEW")
public class RequestController {
	
	@RenderMapping(params="render=editRequest")
	public String editRequestRenderRequest(RenderRequest request, RenderResponse response, Model model){
		
		return "view";
	}
	
	@ActionMapping(params="render=deleteScenario")
	public String deleteSRequestRenderRequest(RenderRequest request, RenderResponse response, Model model){
		
		return "view";
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