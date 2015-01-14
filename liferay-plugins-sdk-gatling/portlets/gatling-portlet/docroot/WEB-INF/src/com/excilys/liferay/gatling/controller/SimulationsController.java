package com.excilys.liferay.gatling.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

import com.excilys.liferay.gatling.model.Simulation;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;


@Controller(value = "SimulationsController")  
@RequestMapping("VIEW")
public class SimulationsController {

	private static final Log LOG = LogFactoryUtil.getLog(SimulationsController.class);

	@RenderMapping
	public String handleRenderRequest(RenderRequest request,RenderResponse response,Model model){ 
		LOG.info("Simulations");
		List<Simulation> simulationList = new ArrayList<Simulation>();
		Map<Simulation, Integer[]> simulationMap = new HashMap<Simulation, Integer[]>();

		for (Simulation simulation : simulationList) {
			Integer[] simulationInfos = new Integer[3];
			simulationMap.put(simulation, simulationInfos);
		}

		final javax.portlet.PortletPreferences prefs = request.getPreferences();
		String gatlingVersionString;
		gatlingVersionString = prefs.getValue("gatlingVersion", null);

		request.setAttribute("gatlingVersion", gatlingVersionString);
		request.setAttribute("listSimulation", simulationList);
		request.setAttribute("MapSimulation", simulationMap);
		return "library";  
	}  
}
