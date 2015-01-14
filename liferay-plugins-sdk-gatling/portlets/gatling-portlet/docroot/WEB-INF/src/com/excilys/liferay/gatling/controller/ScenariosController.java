package com.excilys.liferay.gatling.controller;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

@Controller(value = "ScenariosController")  
@RequestMapping("VIEW")
public class ScenariosController {
	
	private static final Log LOG = LogFactoryUtil.getLog(ScenariosController.class);
	
	@RenderMapping(params="tabs1=scenarios")
	public String handleRenderRequest(RenderRequest request,RenderResponse response,Model model){ 
		LOG.info("Scenarios");
		return "library";  
	}  
}
