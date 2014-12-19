package com.excilys.liferay.gatling.controller;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.ResourceMapping;

import com.excilys.liferay.gatling.GatlingPortlet;
import com.excilys.liferay.gatling.model.Simulation;
import com.excilys.liferay.gatling.service.SimulationLocalServiceUtil;
import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;

@Controller(value="SimulationController")
@RequestMapping("VIEW")
public class SimulationController {
	
	private static final Log LOG = LogFactoryUtil.getLog(GatlingPortlet.class);
	
	@ActionMapping(params="action=addScenario")
	public String addScenarioRenderRequest(ActionRequest request, ActionResponse response, Model model) throws SystemException {
		
		
		Simulation simulation = SimulationLocalServiceUtil.addSimulationFromRequest(request);
		if (simulation != null) {
			response.setRenderParameter("simulationId", Long.toString(simulation.getSimulation_id()));
			// If new simulation the redirect to add First scenario page else edit simulation page
			LOG.debug("Simulation added"); 
		} else {
			LOG.debug("Simulation fails to add");
		}		
		return "editSimulation";
	}
	
	@ActionMapping(params="action=editSimulation")
	public String editSimulationRenderRequest(ActionRequest request, ActionResponse response, Model model) throws SystemException, PortalException{
		
		long simulationId = ParamUtil.getLong(request, "simulationId");
		LOG.debug("edit Simulation with id : " + simulationId);
		Simulation simulation = SimulationLocalServiceUtil.getSimulation(simulationId);
		simulation.setName(ParamUtil.getString(request, "simulationName"));
		SimulationLocalServiceUtil.updateSimulation(simulation);
		response.setRenderParameter("simulationId", Long.toString(simulationId));
		
		return "editSimulation";
	}
	
	@ActionMapping(params="action=editFeeder")
	public String editFeederRenderRequest(ActionRequest request, ActionResponse response, Model model) throws SystemException, PortalException{
		long simulationId = ParamUtil.getLong(request, "simulationId");
		LOG.debug("Edit Feeder of simulationId "+simulationId);
		Simulation simulation = SimulationLocalServiceUtil.getSimulation(simulationId);
		// isAFile
		String radioOption = ParamUtil.getString(request, "option");
		boolean isAFile = radioOption.equals("content2");
		simulation.setIsFeederAFile(isAFile);
		// content
		String content = "manualUsers";
		if(isAFile) {
			content="fileUsers";
		}
		simulation.setFeederContent(ParamUtil.getString(request,content));
		SimulationLocalServiceUtil.updateSimulation(simulation);
		response.setRenderParameter("simulationId", Long.toString(simulationId));		
		return "editSimulation";
	}
	
	@ActionMapping(params="render=deleteScenario")
	public String deleteScenarioRenderRequest(RenderRequest request, RenderResponse response, Model model) throws SystemException, NoSuchModelException{
		long simulationId = ParamUtil.getLong(request, "simulationId");
		if (LOG.isDebugEnabled()) {
			LOG.debug("remove Simulation with id : " + simulationId);
		}
		SimulationLocalServiceUtil.removeSimulationCascade(simulationId);
		
		return "view";
	}
	
	@ResourceMapping(value="oneScript")
	public String serveOneScript(RenderRequest request, RenderResponse response, Model model){
		
		return "view";
	}
}