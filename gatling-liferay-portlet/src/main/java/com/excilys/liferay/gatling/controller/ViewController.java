/**
 * Copyright 2015 Altendis, Groupe Excilys (www.altendis.fr)
 */
package com.excilys.liferay.gatling.controller;

import com.excilys.liferay.gatling.model.Simulation;
import com.excilys.liferay.gatling.util.GatlingUtil;
import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.HttpHeaders;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.ReadOnlyException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.ValidatorException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;
import org.springframework.web.portlet.bind.annotation.ResourceMapping;

@Controller(value = "ViewController")
@RequestMapping("VIEW")
public class ViewController {

	private static final Log LOG = LogFactoryUtil.getLog(ViewController.class);

	@RenderMapping(params = "render=renderView")
	public String renderRequest(final RenderRequest renderRequest,
			final RenderResponse renderResponse, final Model model) {
		LOG.debug("render View");
		return "view";
	}

	
	@ActionMapping(params="action=debugYann")
	public void debugYann(final ActionRequest request, final ActionResponse response, final Model model) throws SystemException, NoSuchModelException{
		LOG.debug("Debug Yann called");

		response.setRenderParameter("render", "renderView");
	}
	
	@ResourceMapping(value="generateZip")	
	public void serveManyScript(final ResourceRequest request, final ResourceResponse response) throws ValidatorException, ReadOnlyException, IOException, SystemException, PortalException, Exception {
		LOG.debug("Generating zip file...");
		String template = "/templateGatling2.X.X.mustache";
		//create and export only one file with scenario script for this simulation id
		Simulation simulation = null;
		//final Date date = new Date();		
		final long[] simulationsIds = ParamUtil.getLongValues(request, "export");
		
		response.setContentType("application/zip");
		response.addProperty("Content-Disposition", "attachment; filename = GatlingSimulations_it_works.zip");
		
		final ThemeDisplay themeDisplay =	(ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
		
		GatlingUtil.zipMyEnvironment(response.getPortletOutputStream(), getClass().getClassLoader(), themeDisplay, 20182);
		
		response.addProperty(HttpHeaders.CACHE_CONTROL, "max-age=3600, must-revalidate");
		LOG.debug("Zip generated ...");
	}

	
	@ActionMapping(params="action=debugNico")
	public void debugNico(final ActionRequest request, final ActionResponse response, final Model model) throws SystemException, NoSuchModelException{
		LOG.debug("Debug Nico called");
		response.setRenderParameter("render", "renderView");
	}
	
	
	
	
	/**
	 * Takes all the renders without param.
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RenderMapping
	public String handleRenderRequest(final RenderRequest request,
			final RenderResponse response, final Model model) {
		return renderRequest(request, response, model);
	}

}
