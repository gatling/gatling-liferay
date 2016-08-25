/**
 * Copyright 2015 Altendis, Groupe Excilys (www.altendis.fr)
 */
package com.excilys.liferay.gatling.controller;

import com.excilys.liferay.gatling.NoSuchScenarioException;
import com.excilys.liferay.gatling.model.Login;
import com.excilys.liferay.gatling.model.Scenario;
import com.excilys.liferay.gatling.model.Simulation;
import com.excilys.liferay.gatling.model.SiteMap;
import com.excilys.liferay.gatling.model.AST.SimulationAST;
import com.excilys.liferay.gatling.model.AST.feeder.UserFeederFileAST;
import com.excilys.liferay.gatling.service.ASTService;
import com.excilys.liferay.gatling.service.ProcessLocalServiceUtil;
import com.excilys.liferay.gatling.service.ScenarioLocalServiceUtil;
import com.excilys.liferay.gatling.service.SimulationLocalServiceUtil;
import com.excilys.liferay.gatling.service.mapper.ASTMapper;
import com.excilys.liferay.gatling.service.persistence.LoginUtil;
import com.excilys.liferay.gatling.service.persistence.ProcessUtil;
import com.excilys.liferay.gatling.service.persistence.ScenarioUtil;
import com.excilys.liferay.gatling.service.persistence.SimulationUtil;
import com.excilys.liferay.gatling.service.persistence.SiteMapUtil;
import com.excilys.liferay.gatling.util.GatlingUtil;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.HttpHeaders;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Group;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

import com.excilys.liferay.gatling.model.Process;
/**
 * Controller linked to the default view
 */
@Controller(value = "ViewController")
@RequestMapping("VIEW")
public class ViewController {

	private static final Log LOG = LogFactoryUtil.getLog(ViewController.class);

	@RenderMapping(params = "render=renderView")
	public String renderRequest(final RenderRequest renderRequest,
			final RenderResponse renderResponse, final Model model) throws SystemException {
		LOG.debug("render View");
		
		/* Record the sites list */
		
		List<Group> listGroups = GatlingUtil.getListOfSites();
		renderRequest.setAttribute("listGroup", listGroups);
		
		/* Initialize the simulation and the scenario if not existant */
		
		Simulation defaultSimulation = SimulationLocalServiceUtil.getByName("_default_simulation_");
		Scenario defaultScenario = null;
		
		if(defaultSimulation != null){
			List<Scenario> scenarios = ScenarioLocalServiceUtil.findBySimulationId(defaultSimulation.getSimulation_id());
			if(scenarios != null && !scenarios.isEmpty()){
				defaultScenario = scenarios.get(0);
			}
			else {
				final ThemeDisplay themeDisplay =	(ThemeDisplay)renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
				defaultScenario = createDefaultScenario(defaultSimulation, themeDisplay);
			}
		}
		else {
			defaultSimulation = createDefaultSimulation();
			final ThemeDisplay themeDisplay =	(ThemeDisplay)renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
			defaultScenario = createDefaultScenario(defaultSimulation, themeDisplay);
		}
		
		List<Process> processes = ProcessLocalServiceUtil.findProcessFromScenarioId(defaultScenario.getScenario_id());
		
		/* Record the simulation and scenario data */
		
		renderRequest.setAttribute("simulationId", defaultSimulation.getSimulation_id());
		renderRequest.setAttribute("scenarioGroupId", defaultScenario.getGroup_id());
		renderRequest.setAttribute("processes", processes);
		renderRequest.setAttribute("numberOfUsers", defaultScenario.getNumberOfUsers());
		renderRequest.setAttribute("rampUp", defaultScenario.getDuration());
		renderRequest.setAttribute("feederContent", defaultSimulation.getFeederContent());
		return "view";
	}
	
	
	/**
	 * Creates the empty default simulation, persists it and returns it.
	 * @return The fresh default simulation
	 * @throws SystemException If an error occures in services
	 */
	public static Simulation createDefaultSimulation() throws SystemException{
		Simulation simulation = SimulationUtil.create(CounterLocalServiceUtil.increment(Simulation.class.getName()));
		simulation.setName("_default_simulation_");
		simulation.setFeederContent("");
		simulation.setIsFeederAFile(false);
		simulation.persist();
		return simulation;
	}
	
	
	/**
	 * Creates the empty default scenario, persists it and returns it.
	 * @param simulation The simulation that contains the new scenario
	 * @param themeDisplay 
	 * @return The fresh default scenario
	 * @throws SystemException If an error occures in services
	 */
	public static Scenario createDefaultScenario(Simulation simulation, ThemeDisplay themeDisplay) throws SystemException {
		Scenario scenario = ScenarioUtil.create(CounterLocalServiceUtil.increment(Scenario.class.getName()));
		scenario.setName("_default_scenario_");
		List<Group> listGroups = GatlingUtil.getListOfSites();
		if (listGroups.isEmpty()) {
			scenario.setGroup_id(0);
		}
		else {
			scenario.setGroup_id(listGroups.get(0).getGroupId());
		}
		
		scenario.setSimulation_id(simulation.getSimulation_id());
		scenario.setNumberOfUsers(10);
		scenario.setDuration(5);
		scenario.persist();
	
		Login l = LoginUtil.create(CounterLocalServiceUtil.increment(Login.class.getName()));
		l.setName("_default_login_");
		l.setData("user1@liferay.com,user1Password\nuser2@liferay.com,user2Password");
		l.persist();
		
		Process login = ProcessUtil.create(CounterLocalServiceUtil.increment(Process.class.getName()));
		login.setName("Login");
		login.setType("LOGIN");
		login.setFeederId(l.getPrimaryKey());
		login.setPause(2);
		login.setOrder(0);
		login.setScenario_id(scenario.getScenario_id());
		login.persist();
		
		Process logout = ProcessUtil.create(CounterLocalServiceUtil.increment(Process.class.getName()));
		logout.setName("Logout");
		logout.setType("LOGOUT");
		logout.setPause(1);
		logout.setOrder(2);
		logout.setScenario_id(scenario.getScenario_id());
		logout.persist();	
		
		//SiteMap sm = SiteMapUtil.create(CounterLocalServiceUtil.increment(SiteMap.class.getName()));
		//sm.setName("_defaut_site_map_");
		
		long siteMapId = ASTService.siteMapCreation(themeDisplay, scenario.getGroup_id());
		Process random = ProcessUtil.create(CounterLocalServiceUtil.increment(Process.class.getName()));
		random.setName("Random Page");
		random.setType("RANDOMPAGE");
		random.setPause(3);
		random.setOrder(1);
		random.setFeederId(siteMapId);
		random.setScenario_id(scenario.getScenario_id());
		
		random.persist();	
		
		return scenario;
	}
	

	@ActionMapping(params="action=saveDefaultSimulation")
	public void editFeederAction(final ActionRequest request, final ActionResponse response, final Model model) throws SystemException, PortalException{
		LOG.debug("Action Triggered : Save Default Simulation");
		
		long simulationId = ParamUtil.getLong(request, "simulationId");
		long scenarioGroupId = ParamUtil.getLong(request, "scenarioGroupId");
		long numberOfUsers = ParamUtil.getLong(request, "numberOfUsers");
		long rampUp = ParamUtil.getLong(request, "rampUp");
		
		String feederContent = ParamUtil.getString(request, "feederContent");
		
		Simulation simulation = SimulationLocalServiceUtil.getSimulation(simulationId);
		List<Scenario> scenarios = ScenarioLocalServiceUtil.findBySimulationId(simulation.getSimulation_id());
		if(scenarios == null || scenarios.isEmpty()) {
			throw new NoSuchScenarioException();
		}
		Scenario scenario = scenarios.get(0);
		
		scenario.setGroup_id(scenarioGroupId);
		scenario.setNumberOfUsers(numberOfUsers);
		scenario.setDuration(rampUp);
		simulation.setFeederContent(feederContent);
	
		List<Process> processes = ProcessLocalServiceUtil.findProcessFromScenarioId(scenario.getScenario_id());
		for (Process process : processes) {
			int time = ParamUtil.getInteger(request, process.getProcess_id()+"");
			if(time != process.getPause()) {
				process.setPause(time);
				ProcessLocalServiceUtil.updateProcess(process);
			}
		}
		
		SimulationLocalServiceUtil.updateSimulation(simulation);
		ScenarioLocalServiceUtil.updateScenario(scenario);
		
		response.setRenderParameter("render", "renderView");
	}

	
	@ResourceMapping(value="generateZip")	
	public void exportZippedEnvironment(final ResourceRequest request, final ResourceResponse response) throws ValidatorException, ReadOnlyException, IOException, SystemException, PortalException, Exception {
		LOG.debug("Generating zip file...");

		//long[] simulationsIds = ParamUtil.getLongValues(request, "export");
		Simulation simulation = SimulationLocalServiceUtil.getByName("_default_simulation_");

		// Retreives the defaut scenario frim the simulation id (expected single result)
		List<Scenario> scenarios = ScenarioLocalServiceUtil.findBySimulationId(simulation.getSimulation_id());
		if(scenarios == null || scenarios.isEmpty()) {
			throw new NoSuchScenarioException();
		}
		Scenario scenario = scenarios.get(0);
		
		long[] simulationsIds = new long[]{simulation.getSimulation_id()};

		response.setContentType("application/zip");
		response.addProperty("Content-Disposition", "attachment; filename = GatlingSimulations.zip");
		
		List<SimulationAST> scriptASTs = new ArrayList<>();
		for( long simulationId : simulationsIds) {
			scriptASTs.add(ASTService.computesSimulationAST(simulationId, PortalUtil.getPortalURL(request)));
		}
		
		GatlingUtil.zipMyEnvironment(response.getPortletOutputStream(), getClass().getClassLoader(), request, scenario.getGroup_id(), scriptASTs);

		response.addProperty(HttpHeaders.CACHE_CONTROL, "max-age=3600, must-revalidate");
		LOG.debug("Zip generated ...");
	}
	
	
	/**
	 * Takes all the renders without param.
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 * @throws SystemException 
	 */
	@RenderMapping
	public String handleRenderRequest(final RenderRequest request,
			final RenderResponse response, final Model model) throws SystemException {
		return renderRequest(request, response, model);
	}

	
}
