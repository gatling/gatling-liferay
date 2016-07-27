/**
 * Copyright 2015 Altendis, Groupe Excilys (www.altendis.fr)
 */
package com.excilys.liferay.gatling.controller;

import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

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
	
	@ActionMapping(params="action=debugNico")
	public void debugNico(final ActionRequest request, final ActionResponse response, final Model model) throws SystemException, NoSuchModelException{
		LOG.debug("Debug Nico called");
		response.setRenderParameter("render", "renderView");
	}
	
	
	
	
	
	
	
	
	//TODO: Move me in a right way!
	// Get file loads a specific file from WEB-INF/classes
	// https://web.liferay.com/community/forums/-/message_boards/message/10307074
	private String getFile(String path) {

		StringBuilder result = new StringBuilder("");

		// Get file from resources folder
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource(path).getFile());

		// File f = new File(
		// getClass().getClassLoader().getResource("/file.txt").getFile());
		try (Scanner scanner = new Scanner(file)) {

			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				result.append(line).append("\n");
			}

			scanner.close();
			System.out.println(result);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return result.toString();

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
