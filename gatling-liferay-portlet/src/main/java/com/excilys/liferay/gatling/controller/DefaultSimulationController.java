/**
 * Copyright 2015 Altendis, Groupe Excilys (www.altendis.fr)
 */
package com.excilys.liferay.gatling.controller;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

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


	 // Get file loads a specific file from WEB-INF/classes 
	 // https://web.liferay.com/community/forums/-/message_boards/message/10307074
	 private String getFile(String path) {

			StringBuilder result = new StringBuilder("");

			//Get file from resources folder
			ClassLoader classLoader = getClass().getClassLoader();
			File file = new File(classLoader.getResource(path).getFile());
			
			//File f = new File( getClass().getClassLoader().getResource("/file.txt").getFile());
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
}

