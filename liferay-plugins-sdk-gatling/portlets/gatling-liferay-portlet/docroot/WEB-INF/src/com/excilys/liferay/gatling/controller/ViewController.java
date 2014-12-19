package com.excilys.liferay.gatling.controller;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;
import org.springframework.web.portlet.bind.annotation.ResourceMapping;

@Controller(value="ViewController")
@RequestMapping("VIEW")
public class ViewController {
	
	@RenderMapping(params="render=help")
	public String helpRenderRequest(RenderRequest request, RenderResponse response, Model model){
		
		return "view";
	}
	
	@ResourceMapping(value="manyScript")
	public String serveManyScript(RenderRequest request, RenderResponse response, Model model){
		
		return "view";
	}
}