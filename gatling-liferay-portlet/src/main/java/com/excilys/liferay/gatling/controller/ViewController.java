/**
 * Copyright 2015 Altendis, Groupe Excilys (www.altendis.fr)
 */
package com.excilys.liferay.gatling.controller;

import com.excilys.liferay.gatling.NoSuchScenarioException;
import com.excilys.liferay.gatling.dto.ProcessDTO;
import com.excilys.liferay.gatling.dto.ScenarioDTO;
import com.excilys.liferay.gatling.dto.mapper.ProcessDTOMapper;
import com.excilys.liferay.gatling.dto.mapper.ScenarioDTOMapper;
import com.excilys.liferay.gatling.model.Login;
import com.excilys.liferay.gatling.model.Process;
import com.excilys.liferay.gatling.model.ProcessType;
import com.excilys.liferay.gatling.model.Scenario;
import com.excilys.liferay.gatling.model.Simulation;
import com.excilys.liferay.gatling.model.SiteMap;
import com.excilys.liferay.gatling.model.AST.SimulationAST;
import com.excilys.liferay.gatling.service.ASTService;
import com.excilys.liferay.gatling.service.LoginLocalServiceUtil;
import com.excilys.liferay.gatling.service.ProcessLocalServiceUtil;
import com.excilys.liferay.gatling.service.ScenarioLocalServiceUtil;
import com.excilys.liferay.gatling.service.SimulationLocalServiceUtil;
import com.excilys.liferay.gatling.service.SiteMapLocalServiceUtil;
import com.excilys.liferay.gatling.service.impl.SimulationLocalServiceImpl;
import com.excilys.liferay.gatling.service.persistence.ProcessUtil;
import com.excilys.liferay.gatling.service.persistence.ScenarioUtil;
import com.excilys.liferay.gatling.service.persistence.SimulationUtil;
import com.excilys.liferay.gatling.util.GatlingUtil;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.HttpHeaders;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Group;
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
/**
 * Controller linked to the default view
 */
@Controller(value = "ViewController")
@RequestMapping("VIEW")
public class ViewController {

	private static final Log LOG = LogFactoryUtil.getLog(ViewController.class);

	@RenderMapping(params = "render=renderView")
	public String renderRequest(final RenderRequest renderRequest,
			final RenderResponse renderResponse, final Model model) throws SystemException, PortalException {
		LOG.debug("render View");
		/* Record the sites list */
		
		List<Group> listGroups = GatlingUtil.getListOfSites();
		renderRequest.setAttribute("listGroup", listGroups);
		
		/* Initialize the simulation and the scenario if not existant */
		Simulation defaultSimulation = SimulationLocalServiceUtil.createDefaultSimulation();
		Scenario defaultScenario = ScenarioLocalServiceUtil.createDefaultScenario(defaultSimulation);
		
		List<Process> processes = ProcessLocalServiceUtil.findProcessFromScenarioId(defaultScenario.getScenario_id());
		
		if(processes == null || processes.isEmpty()){
			Login defaultLogin = LoginLocalServiceUtil.createDefaultLogin();
			
			final ThemeDisplay themeDisplay = (ThemeDisplay)renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
			SiteMap defaultSiteMap = SiteMapLocalServiceUtil.siteMapCreation(themeDisplay, defaultScenario.getGroup_id());
			
			Process login = ProcessLocalServiceUtil.createProcess("Login", ProcessType.LOGIN,
					defaultLogin.getPrimaryKey(), 2, 0);
			
			Process random = ProcessLocalServiceUtil.createProcess("Random Page", ProcessType.RANDOMPAGE,
					defaultSiteMap.getPrimaryKey(), 3, 1);
			
			Process logout = ProcessLocalServiceUtil.createProcess("Logout", ProcessType.LOGOUT, null, 1, 2);
			
			long scenarioId = defaultScenario.getScenario_id();
			
			ScenarioLocalServiceUtil.addProcess(scenarioId, login.getProcess_id(), 0, 2);
			ScenarioLocalServiceUtil.addProcess(scenarioId, random.getProcess_id(), 0, 2);
			ScenarioLocalServiceUtil.addProcess(scenarioId, logout.getProcess_id(), 0, 2);
			
		}

		List<Process> allProcesses = ProcessLocalServiceUtil.getProcesses(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		List<ProcessDTO> templates = new ArrayList<>(allProcesses.size());
		for (Process process : allProcesses) {
			templates.add(ProcessDTOMapper.toDTO(process));
		}
		
		/* Injection */
		List<String> injectionsMode = new ArrayList<>();
		injectionsMode.add("ramp Over");
		injectionsMode.add("at Once");
		
		/* Scenarios List */
		List<Scenario> scenarios = ScenarioLocalServiceUtil.findBySimulationId(defaultSimulation.getSimulation_id());
		List<ScenarioDTO> scenariosDTO = new ArrayList<>();
		for (Scenario scenario : scenarios) {
			scenariosDTO.add(ScenarioDTOMapper.toDTO(scenario));
		}
		
		/* Record the simulation and scenario data */
		renderRequest.setAttribute("simulationId", defaultSimulation.getSimulation_id());
		renderRequest.setAttribute("scenarioInjection", "ramp Over");
		renderRequest.setAttribute("scenarios", scenariosDTO);
		renderRequest.setAttribute("numberOfUsers", defaultScenario.getNumberOfUsers());
		renderRequest.setAttribute("rampUp", defaultScenario.getDuration());
		renderRequest.setAttribute("injections", injectionsMode);
		renderRequest.setAttribute("feederContent", defaultSimulation.getFeederContent());
		renderRequest.setAttribute("templates", templates);
		return "view";
	}
	
	@ActionMapping(params="action=saveDefaultSimulation")
	public void editFeederAction(final ActionRequest request, final ActionResponse response, final Model model) throws SystemException, PortalException{
		LOG.debug("Action Triggered : Save Default Simulation");
		
		long simulationId = ParamUtil.getLong(request, "simulationId");
		//long scenarioGroupId = ParamUtil.getLong(request, "scenarioGroupId");
		long numberOfUsers = ParamUtil.getLong(request, "numberOfUsers");
		long rampUp = ParamUtil.getLong(request, "rampUp");
		String injection = ParamUtil.getString(request, "injectionMode");
		
		String feederContent = ParamUtil.getString(request, "feederContent");
		
		Simulation simulation = SimulationLocalServiceUtil.getSimulation(simulationId);
		simulation.setFeederContent(feederContent);
		SimulationLocalServiceUtil.updateSimulation(simulation);

		List<Scenario> scenarios = ScenarioLocalServiceUtil.findBySimulationId(simulation.getSimulation_id());
		if(scenarios == null || scenarios.isEmpty()) {
			throw new NoSuchScenarioException();
		}
		
		for (Scenario scenario : scenarios) {
			//scenario.setGroup_id(scenarioGroupId);
			scenario.setInjection(injection);
			scenario.setNumberOfUsers(numberOfUsers);
			scenario.setDuration(rampUp);
			
			List<Process> processes = ProcessLocalServiceUtil.findProcessFromScenarioId(scenario.getScenario_id());
			for (Process process : processes) {
				int time = ParamUtil.getInteger(request, process.getProcess_id()+"");
				if(time != process.getPause()) {
					process.setPause(time);
					ProcessLocalServiceUtil.updateProcess(process);
				}
			}
			
			ScenarioLocalServiceUtil.updateScenario(scenario);
		}
		
		response.setRenderParameter("render", "renderView");
	}
	
	
	@ResourceMapping(value="generateZip")	
	public void exportZippedEnvironment(final ResourceRequest request, final ResourceResponse response) throws ValidatorException, ReadOnlyException, IOException, SystemException, PortalException, Exception {
		LOG.debug("Generating zip file...");

		// Saving datas
		
		//long[] simulationsIds = ParamUtil.getLongValues(request, "export");
		Simulation simulation = SimulationLocalServiceUtil.getByName("_default_simulation_");
		LOG.debug("SImulatioID="+(simulation==null?"null":simulation.getSimulation_id()));
		// Retreives the defaut scenario frim the simulation id (expected single result)
		List<Scenario> scenarios = ScenarioLocalServiceUtil.findBySimulationId(simulation.getSimulation_id());
		if(scenarios == null || scenarios.isEmpty()) {
			throw new NoSuchScenarioException();
		}
		
		long[] simulationsIds = new long[]{simulation.getSimulation_id()};

		response.setContentType("application/zip");
		response.addProperty("Content-Disposition", "attachment; filename = GatlingSimulations.zip");
		
		List<SimulationAST> scriptASTs = new ArrayList<>();
		for( long simulationId : simulationsIds) {
			scriptASTs.add(ASTService.computesSimulationAST(simulationId, PortalUtil.getPortalURL(request)));
		}
		
		GatlingUtil.zipMyEnvironment(response.getPortletOutputStream(), getClass().getClassLoader(), request, scriptASTs);

		response.addProperty(HttpHeaders.CACHE_CONTROL, "max-age=3600, must-revalidate");
		LOG.debug("Zip generated ...");
	}
	
	
	@ActionMapping(params="action=persistNewScenario")
	public void persistNewScenario(final ActionRequest request, final ActionResponse response, final Model model) throws SystemException, PortalException{
		LOG.debug("Action Triggered : Save Default Simulation");
		
		Simulation simulation = SimulationLocalServiceUtil.getByName(SimulationLocalServiceImpl.DEFAULT_NAME);
		long id = CounterLocalServiceUtil.getCounter(Scenario.class.getName()).getCurrentId() + 1;
		Scenario scenario = ScenarioLocalServiceUtil.createScenario("MyScenario" + id, simulation.getSimulation_id(), "ramp Over", 10, 5);
		
		ProcessLocalServiceUtil.findByName("LOGIN");
	}
	
	
	
	
	
	/**
	 * Takes all the renders without param.
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 * @throws SystemException 
	 * @throws PortalException 
	 */
	@RenderMapping
	public String handleRenderRequest(final RenderRequest request,
			final RenderResponse response, final Model model) throws SystemException, PortalException {
		return renderRequest(request, response, model);
	}

	
}
