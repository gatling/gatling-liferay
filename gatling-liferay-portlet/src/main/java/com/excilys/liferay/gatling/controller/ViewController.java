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
import com.excilys.liferay.gatling.model.ProcessScenarioLink;
import com.excilys.liferay.gatling.model.ProcessType;
import com.excilys.liferay.gatling.model.Scenario;
import com.excilys.liferay.gatling.model.Simulation;
import com.excilys.liferay.gatling.model.SiteMap;
import com.excilys.liferay.gatling.model.AST.SimulationAST;
import com.excilys.liferay.gatling.service.ASTService;
import com.excilys.liferay.gatling.service.LoginLocalServiceUtil;
import com.excilys.liferay.gatling.service.ProcessLocalServiceUtil;
import com.excilys.liferay.gatling.service.ProcessScenarioLinkLocalServiceUtil;
import com.excilys.liferay.gatling.service.ScenarioLocalServiceUtil;
import com.excilys.liferay.gatling.service.SimulationLocalServiceUtil;
import com.excilys.liferay.gatling.service.SiteMapLocalServiceUtil;
import com.excilys.liferay.gatling.service.impl.ScenarioLocalServiceImpl;
import com.excilys.liferay.gatling.service.impl.SimulationLocalServiceImpl;
import com.excilys.liferay.gatling.util.GatlingUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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
import java.util.Collections;
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
		
		/* The counter that will be use as cssId */
		int counter = 0;
		
		/* Initialize the simulation and the scenario if not existant */
		Simulation defaultSimulation = SimulationLocalServiceUtil.createDefaultSimulation();
		Scenario defaultScenario = ScenarioLocalServiceUtil.createDefaultScenario(defaultSimulation);
		
		List<Process> processes = ProcessLocalServiceUtil.findProcessFromScenarioId(defaultScenario.getScenario_id());
		
		if(processes == null || processes.isEmpty()){
			Login defaultLogin = LoginLocalServiceUtil.createDefaultLogin();
			
			final ThemeDisplay themeDisplay = (ThemeDisplay)renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
			SiteMap defaultSiteMap = SiteMapLocalServiceUtil.siteMapCreation(themeDisplay, defaultScenario.getGroup_id());
			
			Process login = ProcessLocalServiceUtil.createProcess("Login", ProcessType.LOGIN,
					defaultLogin.getPrimaryKey());
			
			Process random = ProcessLocalServiceUtil.createProcess("Random Page", ProcessType.RANDOMPAGE,
					defaultSiteMap.getPrimaryKey());
			
			Process logout = ProcessLocalServiceUtil.createProcess("Logout", ProcessType.LOGOUT, null);
			
			long scenarioId = defaultScenario.getScenario_id();
			
			ScenarioLocalServiceUtil.addProcess(scenarioId, login.getProcess_id(), 0, 5);
			ScenarioLocalServiceUtil.addProcess(scenarioId, random.getProcess_id(), 1, 10);
			ScenarioLocalServiceUtil.addProcess(scenarioId, logout.getProcess_id(), 2, 0);
			
		}
		
		/* Scenarios List */
		List<Scenario> scenarios = ScenarioLocalServiceUtil.findBySimulationId(defaultSimulation.getSimulation_id());
		List<ScenarioDTO> scenariosDTO = new ArrayList<>();
		for (Scenario scenario : scenarios) {
			ScenarioDTO s = ScenarioDTOMapper.toDTO(scenario, counter);
			scenariosDTO.add(s);
			counter += s.getProcesses().size();
		}
		
		// Injection modes
		List<String> injectionsMode = new ArrayList<>();
		injectionsMode.add("ramp Over");
		injectionsMode.add("at Once");
		
		//Current Injection
		String currentInjection = scenarios.get(0).getInjection();
		
		/* Library Scenarios */
		List<Process> allProcesses = ProcessLocalServiceUtil.getProcesses(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		List<ProcessDTO> templates = new ArrayList<>(allProcesses.size());
		templates.add(new ProcessDTO( "Pause", String.valueOf(counter++),"Pause", "PAUSE", 5));
		for (Process process : allProcesses) {
			templates.add(ProcessDTOMapper.toDTO(process, String.valueOf(counter)));
			counter++;
		}
		Collections.sort(templates);
		
		/* Record the simulation and scenario data */
		renderRequest.setAttribute("simulationId", defaultSimulation.getSimulation_id());
		renderRequest.setAttribute("scenarios", scenariosDTO);
		renderRequest.setAttribute("numberOfUsers", defaultScenario.getNumberOfUsers());
		renderRequest.setAttribute("rampUp", defaultScenario.getDuration());
		renderRequest.setAttribute("injections", injectionsMode);
		renderRequest.setAttribute("currentInjection", currentInjection);
		renderRequest.setAttribute("feederContent", defaultSimulation.getFeederContent());
		renderRequest.setAttribute("templates", templates);
		renderRequest.setAttribute("counter", counter);
		return "view";
	}
	
	@ActionMapping(params="action=saveInjectionProfile")
	public void saveInjectionProfile(final ActionRequest request, final ActionResponse response, final Model model) throws SystemException, NoSuchScenarioException{

		long simulationId = ParamUtil.getLong(request, "simulationId");
		long numberOfUsers = ParamUtil.getLong(request, "numberOfUsers");
		long rampUp = ParamUtil.getLong(request, "rampUp");
		String injection = ParamUtil.getString(request, "injectionMode");
		
		List<Scenario> scenarios = ScenarioLocalServiceUtil.findBySimulationId(simulationId);
		if(scenarios == null || scenarios.isEmpty()) {
			throw new NoSuchScenarioException();
		}
		
		for (Scenario scenario : scenarios) {
			scenario.setInjection(injection);
			scenario.setNumberOfUsers(numberOfUsers);
			scenario.setDuration(rampUp);
			ScenarioLocalServiceUtil.updateScenario(scenario);
		}
		
		response.setRenderParameter("render", "renderView");
	}
	
	
	
	@ActionMapping(params="action=saveFeeders")
	public void saveFeeders(final ActionRequest request, final ActionResponse response, final Model model) throws PortalException, SystemException{
		long simulationId = ParamUtil.getLong(request, "simulationId");
		String feederContent = ParamUtil.getString(request, "feederContent");
		
		Simulation simulation = SimulationLocalServiceUtil.getSimulation(simulationId);
		simulation.setFeederContent(feederContent);
		SimulationLocalServiceUtil.updateSimulation(simulation);
		
		response.setRenderParameter("render", "renderView");
	}

	
	@ActionMapping(params="action=saveScenarios")
	public void saveMyScenarios(final ActionRequest request, final ActionResponse response, final Model model) throws SystemException, PortalException{
		String json = ParamUtil.getString(request, "JSON");
		LOG.debug("saveScenario called:");
		
		LOG.debug(json);
		ObjectMapper mapper = new ObjectMapper();
		try {
			List<ScenarioDTO> dto = mapper.readValue(json, mapper.getTypeFactory().constructCollectionType(List.class, ScenarioDTO.class));
			for (ScenarioDTO scenarioDTO : dto) {
				ScenarioDTOMapper.persistData(scenarioDTO);
			}
			LOG.debug("Result dto: "+dto.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// if the action is launched from a trashcan buton, delete the related scenario
		String scenarioId = ParamUtil.getString(request, "scenarioId");
		if (!scenarioId.equals("notDefined")) {
			deleteScenarios(Long.parseLong(scenarioId));
		}
		
		response.setRenderParameter("render", "renderView");
	}
	
	private void deleteScenarios(long scenarioId) throws SystemException, PortalException{
		
		List<ProcessScenarioLink> links = ProcessScenarioLinkLocalServiceUtil.findByscenarioId(scenarioId);
		for (ProcessScenarioLink processScenarioLink : links) {
			ProcessScenarioLinkLocalServiceUtil.deleteProcessScenarioLink(processScenarioLink.getPsl_id());
		}
		
		ScenarioLocalServiceUtil.deleteScenario(scenarioId);
	}

	@ResourceMapping(value="generateZip")	
	public void exportZippedEnvironment(final ResourceRequest request, final ResourceResponse response) throws ValidatorException, ReadOnlyException, IOException, SystemException, PortalException, Exception {
		LOG.debug("Generating zip file...");

		// Saving datas
		
		//long[] simulationsIds = ParamUtil.getLongValues(request, "export");
		Simulation simulation = SimulationLocalServiceUtil.getByName(SimulationLocalServiceImpl.DEFAULT_NAME);
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
		Scenario scenario = ScenarioLocalServiceUtil.createScenario("MyScenario", simulation.getSimulation_id(), "ramp Over", 10, 5);
		Process login = ProcessLocalServiceUtil.findByName("LOGIN");
		ProcessScenarioLinkLocalServiceUtil.createLink(scenario.getScenario_id(), login.getProcess_id(), 0, 0);
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
