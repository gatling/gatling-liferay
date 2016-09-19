/**
 * Copyright 2015 Altendis, Groupe Excilys (www.altendis.fr)
 */
package io.gatling.liferay.controller;

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

import io.gatling.liferay.NoSuchScenarioException;
import io.gatling.liferay.dto.ProcessDTO;
import io.gatling.liferay.dto.ScenarioDTO;
import io.gatling.liferay.dto.mapper.ProcessDTOMapper;
import io.gatling.liferay.dto.mapper.ScenarioDTOMapper;
import io.gatling.liferay.model.Login;
import io.gatling.liferay.model.Process;
import io.gatling.liferay.model.ProcessScenarioLink;
import io.gatling.liferay.model.ProcessType;
import io.gatling.liferay.model.Scenario;
import io.gatling.liferay.model.Simulation;
import io.gatling.liferay.model.SiteMap;
import io.gatling.liferay.model.AST.SimulationAST;
import io.gatling.liferay.service.ASTService;
import io.gatling.liferay.service.LoginLocalServiceUtil;
import io.gatling.liferay.service.ProcessLocalServiceUtil;
import io.gatling.liferay.service.ProcessScenarioLinkLocalServiceUtil;
import io.gatling.liferay.service.ScenarioLocalServiceUtil;
import io.gatling.liferay.service.SimulationLocalServiceUtil;
import io.gatling.liferay.service.SiteMapLocalServiceUtil;
import io.gatling.liferay.service.impl.SimulationLocalServiceImpl;
import io.gatling.liferay.util.GatlingUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
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

	/**
	 * renderRequest is called before every rendering
	 * 
	 * the function prepares all the simulation data
	 * it retrieves the defautl simulation related elements and transmits them to the view
	 * 
	 */
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

		final ThemeDisplay themeDisplay = (ThemeDisplay)renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String portalURL = PortalUtil.getPortalURL(renderRequest);
		SiteMap defaultSiteMap = SiteMapLocalServiceUtil.siteMapCreation(themeDisplay, defaultScenario.getGroup_id(), portalURL);
		
		if(processes == null || processes.isEmpty()){
			Login defaultLogin = LoginLocalServiceUtil.createDefaultLogin();
			
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
		else {
			Process random = processes.get(1);
			random.setFeederId(defaultSiteMap.getSiteMapId());
			ProcessLocalServiceUtil.updateProcess(random);
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
		List<String> injectionsMode = Arrays.asList("ramp Over", "at Once");
		
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
		
		Integer panelNb = (Integer) renderRequest.getPortletSession().getAttribute("panelNb");
		if (panelNb==null) {
			panelNb =0;
		}
		
		/* Record the simulation and scenario data */
		renderRequest.setAttribute("panel1State", (panelNb==0 ? "open" : "collapsed"));
		renderRequest.setAttribute("panel2State", (panelNb==1 ? "open" : "collapsed"));
		renderRequest.setAttribute("panel3State", (panelNb==2 ? "open" : "collapsed"));
		renderRequest.setAttribute("panel4State", (panelNb==3 ? "open" : "collapsed"));
		
		renderRequest.setAttribute("simulationId", defaultSimulation.getSimulation_id());
		renderRequest.setAttribute("scenarios", scenariosDTO);
		renderRequest.setAttribute("numberOfUsers", defaultScenario.getNumberOfUsers());
		renderRequest.setAttribute("rampUp", defaultScenario.getDuration());
		renderRequest.setAttribute("injections", injectionsMode);
		renderRequest.setAttribute("currentInjection", currentInjection);
		renderRequest.setAttribute("feederContent", LoginLocalServiceUtil.findByName("_default_login_").getData());
		renderRequest.setAttribute("templates", templates);
		renderRequest.setAttribute("counter", counter);
		return "view";
	}
	

	
	
	/**
	 * Function called when the injection profile is saved
	 * 
	 * it updates all the injection data received from the view
	 */
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
		
		request.getPortletSession().setAttribute("panelNb", 2);
		response.setRenderParameter("render", "renderView");
	}
	
	
	/**
	 * Function called when the feeders are saved
	 * 
	 * It updates the _default_login_ received from the view
	 */
	@ActionMapping(params="action=saveFeeders")
	public void saveFeeders(final ActionRequest request, final ActionResponse response, final Model model) throws PortalException, SystemException{
		String feederContent = ParamUtil.getString(request, "feederContent");
		
		Login login = LoginLocalServiceUtil.findByName("_default_login_");
		login.setData(feederContent);
		login.persist();
		
		request.getPortletSession().setAttribute("panelNb", 3);
		response.setRenderParameter("render", "renderView");
	}

	/**
	 * Updates all the scenarios from the JSON send by the view
	 * 
	 * The JSON represent all the default simulation, it is mapped into dtos and persisted
	 */
	@ActionMapping(params="action=saveScenarios")
	public void saveMyScenarios(final ActionRequest request, final ActionResponse response, final Model model) throws SystemException, PortalException{
		String json = ParamUtil.getString(request, "JSON");
		LOG.debug("saveScenario called:");
		
		//LOG.debug(json);
		ObjectMapper mapper = new ObjectMapper();
		try {
			List<ScenarioDTO> dtos = mapper.readValue(json, mapper.getTypeFactory().constructCollectionType(List.class, ScenarioDTO.class));
			for (ScenarioDTO scenarioDTO : dtos) {
				//Persist the related scenario
				ScenarioDTOMapper.persistData(scenarioDTO);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// if the action is launched from a trashcan buton, deletes the related scenario
		String scenarioId = ParamUtil.getString(request, "scenarioId");
		if (!scenarioId.equals("notDefined")) {
			deleteScenario(Long.parseLong(scenarioId));
		}
		
		request.getPortletSession().setAttribute("panelNb", 1);
		response.setRenderParameter("render", "renderView");
	}
	

	private void deleteScenario(long scenarioId) throws SystemException, PortalException{
		
		List<ProcessScenarioLink> links = ProcessScenarioLinkLocalServiceUtil.findByscenarioId(scenarioId);
		for (ProcessScenarioLink processScenarioLink : links) {
			ProcessScenarioLinkLocalServiceUtil.deleteProcessScenarioLink(processScenarioLink.getPsl_id());
		}
		
		ScenarioLocalServiceUtil.deleteScenario(scenarioId);
	}

	/**
	 * Generate a zip file with the default simulation and the related elements
	 */
	@ResourceMapping(value="generateZip")	
	public void exportZippedEnvironment(final ResourceRequest request, final ResourceResponse response) throws ValidatorException, ReadOnlyException, IOException, SystemException, PortalException, Exception {
		LOG.debug("Generating zip file...");
		request.getPortletSession().setAttribute("panelNb", 0);
		
		Simulation simulation = SimulationLocalServiceUtil.getByName(SimulationLocalServiceImpl.DEFAULT_NAME);
		
		response.setContentType("application/zip");
		response.addProperty("Content-Disposition", "attachment; filename = GatlingSimulations.zip");
		
		// prepare the AST that will be used for the generation
		List<SimulationAST> scriptASTs = new ArrayList<>();
		scriptASTs.add(ASTService.computesSimulationAST(simulation.getSimulation_id(), PortalUtil.getPortalURL(request)));
		
		// Generate the zip
		GatlingUtil.zipMyEnvironment(response.getPortletOutputStream(), getClass().getClassLoader(), request, scriptASTs);

		response.addProperty(HttpHeaders.CACHE_CONTROL, "max-age=3600, must-revalidate");
		LOG.debug("Zip generated ...");
	}
	
	/**
	 * Creates a new scenario
	 */
	@ActionMapping(params="action=persistNewScenario")
	public void persistNewScenario(final ActionRequest request, final ActionResponse response, final Model model) throws SystemException, PortalException{
		LOG.debug("Action Triggered: Save Default Simulation");
		
		Simulation simulation = SimulationLocalServiceUtil.getByName(SimulationLocalServiceImpl.DEFAULT_NAME);
		//Scenario defaultScenario = ScenarioLocalServiceUtil.findBySimulationId(simulation.getSimulation_id()).get(0);
		Scenario scenario = ScenarioLocalServiceUtil.addScenario("MyScenario", simulation.getSimulation_id());
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
