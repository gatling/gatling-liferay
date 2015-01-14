package com.excilys.liferay.gatling.controller;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;


@Controller(value = "EditSimulationController")  
@RequestMapping("VIEW")
public class EditSimulationController {
	
	private static final Log LOG = LogFactoryUtil.getLog(EditSimulationController.class);
	
	@RenderMapping(params="page=editSimulation")
	public String handleRenderRequest(RenderRequest request,RenderResponse response,Model model){ 
		LOG.info("EditSimulation");
		model.addAttribute("page", "editSimulation");
		model.addAttribute("tabs1","scenarios");
		return "library";  
	}  
}
