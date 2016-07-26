/**
 * Copyright 2015 Altendis, Groupe Excilys (www.altendis.fr)
 */
package com.excilys.liferay.gatling.controller;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

@Controller(value="DefaultSimulationController")
@RequestMapping("VIEW")
public class DefaultSimulationController {

	private static final Log LOG = LogFactoryUtil.getLog(DefaultSimulationController.class);

	@RenderMapping(params="render=seeOldPortlet")
	public String seeOldStuff(final RenderRequest renderRequest, final RenderResponse renderResponse) {
		LOG.debug("seeOldStuff called");
		return "oldView";
	}


}

