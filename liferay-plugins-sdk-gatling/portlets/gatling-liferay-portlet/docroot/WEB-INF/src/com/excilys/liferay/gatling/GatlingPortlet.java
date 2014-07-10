package com.excilys.liferay.gatling;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.sample.model.Request;
import com.liferay.sample.model.Scenario;
import com.liferay.sample.model.Simulation;
import com.liferay.sample.service.RequestLocalServiceUtil;
import com.liferay.sample.service.ScenarioLocalServiceUtil;
import com.liferay.sample.service.SimulationLocalServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

/**
 * Portlet implementation class GatlingPortlet
 */
public class GatlingPortlet extends MVCPortlet {
 
	/**
	 * Adds a new Simulation to the database.
	 * 
	 */
	public void addSimulation(ActionRequest request, ActionResponse response)
			throws Exception {
		long primaryKey = CounterLocalServiceUtil.increment(Simulation.class.getName());	
		Simulation simulation = SimulationLocalServiceUtil.createSimulation(primaryKey);
		if(!ParamUtil.getString(request, "simulationName").isEmpty()) {
			simulation.setName(ParamUtil.getString(request, "simulationName"));
			SimulationLocalServiceUtil.addSimulation(simulation);
		}
		else {
			SessionErrors.add(request, "simulation-name-error");
			sendRedirect(request, response);
		}
	}	
	
	/**
	 * Adds a new Scenario to the database.
	 * 
	 */
	public void addScenario(ActionRequest request, ActionResponse response)
			throws Exception {
		Scenario scenario =ScenarioLocalServiceUtil.createScenario(0);
		scenario.setScenario_id(ParamUtil.getLong(request, "scenarioId"));
		scenario.setName(ParamUtil.getString(request, "scenarioName"));
		scenario.setSimulation_id(ParamUtil.getLong(request, "simulationId"));
		
		ScenarioLocalServiceUtil.addScenario(scenario);
		
	}
	
	/**
	 * Adds a new Request to the database.
	 * 
	 */
	public void addRequest(ActionRequest request, ActionResponse response)
			throws Exception {
		Request requestScenario = RequestLocalServiceUtil.createRequest(0);
		requestScenario.setRequest_id(ParamUtil.getLong(request, "requestId"));
		requestScenario.setScenario_id(ParamUtil.getLong(request, "scenarioId"));
		requestScenario.setUrl(ParamUtil.getString(request, "url"));
		requestScenario.setRate(ParamUtil.getInteger(request, "rate"));
		
		RequestLocalServiceUtil.addRequest(requestScenario);
	}
	
}
