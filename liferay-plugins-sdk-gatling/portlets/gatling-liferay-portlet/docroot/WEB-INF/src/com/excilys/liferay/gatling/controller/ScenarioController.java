package com.excilys.liferay.gatling.controller;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.ActionMapping;

import com.excilys.liferay.gatling.GatlingPortlet;
import com.excilys.liferay.gatling.model.Scenario;
import com.excilys.liferay.gatling.service.ScenarioLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;

@Controller(value="ScenarioController")
@RequestMapping("VIEW")
public class ScenarioController {
	
	private static final Log LOG = LogFactoryUtil.getLog(GatlingPortlet.class);
	
	@ActionMapping(params="action=editScenario")
	public String editScenarioRenderRequest(ActionRequest request, ActionResponse response, Model model) throws SystemException, PortalException {
		LOG.debug("edit scenario controller");
		Scenario scenario = ScenarioLocalServiceUtil.editScenarioFromRequest(request);
		if (scenario != null) {
			response.setRenderParameter("simulationId", Long.toString(scenario.getSimulation_id()));
			return "editSimulation";
		}
		return "listSimulation";
	}
	
	@ActionMapping(params="action=deleteScenario")
	public String deleteScenarioRenderRequest(ActionRequest request, ActionResponse response, Model model) throws PortalException, SystemException {
		long scenarioId = ParamUtil.getLong(request, "scenarioId");
		long simulationId = ParamUtil.getLong(request, "simulationId");
		if (LOG.isDebugEnabled()){
			LOG.debug("remove Scenario with id : " + scenarioId);
		}
		// cascade delete
		ScenarioLocalServiceUtil.removeByIdCascade(scenarioId);
		response.setRenderParameter("simulationId", Long.toString(simulationId));
		return "editSimulation";
	}
	
	@ActionMapping(params="action=addScenario")
	public String addScenarioRenderRequest(ActionRequest request, ActionResponse response, Model model) throws SystemException {

		Scenario scenario = ScenarioLocalServiceUtil.addScenarioFromRequest(request);
		if (scenario != null) {
			// redirect to editScenario
			response.setRenderParameter("scenarioId", Long.toString(scenario.getScenario_id()));
			return "editScenario";
		} else {
			response.setRenderParameter("simulationId", ParamUtil.getString(request, "simulationId"));
			return "editSimulation";
		}
	}
}