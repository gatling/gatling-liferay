/**
 * Copyright 2016 Gatling Corp (www.gatling.io)
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
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;

import io.gatling.liferay.NoSuchProcessException;
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
	
	private static final int LOGIN = 0;
	private static final int LOGOUT = 1;
	private static final int RANDOM = 2;
	
	/**
	 * Represents a counter to count boxes.
	 * This is used to generate unique boxes id in the view.
	 */
	private class BoxCounter {
		int count;

		public BoxCounter(int count) {
			this.count = count;
		}

		public int getCount() {
			return count;
		}

		public void setCount(int count) {
			this.count = count;
		}
	}
	
	/**
	 * renderRequest is called before every rendering
	 * 
	 * the function prepares all the simulation data
	 * it retrieves the defautl simulation related elements and transmits them to the view
	 * @param renderRequest
	 * @param renderResponse
	 * @param model
	 * @return
	 * @throws SystemException
	 * @throws PortalException
	 */
	@RenderMapping(params = "render=renderView")
	public String renderRequest(final RenderRequest renderRequest,
			final RenderResponse renderResponse, final Model model) throws SystemException, PortalException {
		
		BoxCounter boxCounter = new BoxCounter(0);
		
		List<Process> defaultProcesses = createDefaultProcesses(renderRequest);
		
		List<ProcessDTO> templates = createLibraryProcessDTO(boxCounter);
		
		Simulation defaultSimulation = SimulationLocalServiceUtil.createDefaultSimulation();
		
		List<Scenario> scenarios = createScenarios(defaultSimulation, defaultProcesses);
		
		List<ScenarioDTO> scenariosDTO = convertScenariosToScenariosDTO(scenarios, boxCounter);
		
		List<String> injectionsMode = Arrays.asList("ramp Over", "at Once");
		String currentInjection = scenarios.get(0).getInjection();

		Integer panelNb = (Integer) renderRequest.getPortletSession().getAttribute("panelNb");
		if (panelNb==null) {
			panelNb = 0;
		}
		
		/* Record the simulation and scenario data */
		renderRequest.setAttribute("panel1State", (panelNb==0 ? "open" : "collapsed"));
		renderRequest.setAttribute("panel2State", (panelNb==1 ? "open" : "collapsed"));
		renderRequest.setAttribute("panel3State", (panelNb==2 ? "open" : "collapsed"));
		renderRequest.setAttribute("panel4State", (panelNb==3 ? "open" : "collapsed"));
		
		renderRequest.setAttribute("simulationId", defaultSimulation.getSimulation_id());
		renderRequest.setAttribute("scenarios", scenariosDTO);
		renderRequest.setAttribute("numberOfUsers", scenarios.get(0).getNumberOfUsers());
		renderRequest.setAttribute("rampUp", scenarios.get(0).getDuration());
		renderRequest.setAttribute("injections", injectionsMode);
		renderRequest.setAttribute("currentInjection", currentInjection);
		renderRequest.setAttribute("feederContent", LoginLocalServiceUtil.findByName("_default_login_").getData());
		renderRequest.setAttribute("templates", templates);
		renderRequest.setAttribute("counter", boxCounter.getCount());
		
		return "view";
	}
	
	/**
	 * Try to retrieve the list of the default processes if they exist,
	 * or create them else
	 * @param renderRequest The rendering request
	 * @return The list of these processes
	 * @throws SystemException If some services failed to retrieve or create the processes
	 */
	private List<Process> createDefaultProcesses(final RenderRequest renderRequest) throws SystemException{
		List<Process> processes = new ArrayList<>(3);
		processes.add(getDefaultLogin());
		processes.add(getDefaultLogout());
		processes.add(getdefaultRandom(renderRequest));
		return processes;
	}
	
	/**
	 * Try to retrieve the default login process. If it can't be find,
	 * the login process is created and persisted.
	 * @return The default login process
	 * @throws SystemException If some services failed to retrieve or create the process
	 */
	private Process getDefaultLogin() throws SystemException{
		Login defaultLogin = LoginLocalServiceUtil.createDefaultLogin();
		try {
			return ProcessLocalServiceUtil.findByName("Login");
		} catch (NoSuchProcessException e) {
			return ProcessLocalServiceUtil.createProcess("Login", ProcessType.LOGIN, defaultLogin.getPrimaryKey());
		}
	}
	
	/**
	 * Try to retrieve the default logout process. If it can't be find,
	 * the logotu process is created and persisted.
	 * @return The default logout process
	 * @throws SystemException If some services failed to retrieve or create the process
	 */
	private Process getDefaultLogout() throws SystemException {
		try {
			return ProcessLocalServiceUtil.findByName("Logout");
		} catch (NoSuchProcessException e) {
			return ProcessLocalServiceUtil.createProcess("Logout", ProcessType.LOGOUT, null);
		}
	}
	
	/**
	 * Try to retrieve the default random process. If it can't be find,
	 * the random process is created and persisted.
	 * @return The default random process
	 * @throws SystemException If some services failed to retrieve or create the process
	 */
	private Process getdefaultRandom(final RenderRequest renderRequest) throws SystemException {
		final ThemeDisplay themeDisplay = (ThemeDisplay)renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String portalURL = PortalUtil.getPortalURL(renderRequest);
		SiteMap defaultSiteMap = SiteMapLocalServiceUtil.siteMapCreation(themeDisplay, portalURL);
		Process random;
		try {			
			random = ProcessLocalServiceUtil.findByName("Random Page");
			random.setFeederId(defaultSiteMap.getSiteMapId());
			ProcessLocalServiceUtil.updateProcess(random);
		} catch (NoSuchProcessException e) {
			random = ProcessLocalServiceUtil.createProcess("Random Page", ProcessType.RANDOMPAGE,
					defaultSiteMap.getPrimaryKey());
		}
		return random;
	}
	
	/**
	 * Creates a list of ProcessDTO that will represents the different boxes
	 * present in the process library.
	 * @param boxCounter The BoxCounter that will be used to give ids to the boxes.
	 * 		boxCounter is updated by this function.
	 * @return The list of the library's processDTO 
	 * @throws SystemException If some services failed to retrieve or create processes
	 */
	private List<ProcessDTO> createLibraryProcessDTO(BoxCounter boxCounter) throws SystemException {
		int counter = boxCounter.getCount();
		List<Process> allProcesses = ProcessLocalServiceUtil.getProcesses(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		List<ProcessDTO> templates = new ArrayList<>(allProcesses.size());
		templates.add(new ProcessDTO( "Pause", String.valueOf(counter++),"Pause", "PAUSE", 3));
		for (Process process : allProcesses) {
			templates.add(ProcessDTOMapper.toDTO(process, String.valueOf(counter)));
			counter++;
		}
		Collections.sort(templates);
		boxCounter.setCount(counter);
		return templates;
	}

	/**
	 * Retrieve the scenarios contained by the given default simulation.
	 * If the simulation doesn't contain any scenrario, it creates a default scenario with
	 * the default processes, add it to the default simulation, persists it and return it as
	 * a single element in the list.
	 * @param defaultSimulation The default simulation
	 * @param defaultProcesses The default processes to use if no scenario exists in the default
	 * 		simulation
	 * @return The list of scenarios in the default simulation
	 * @throws SystemException If some services failed to retrieve or create the scenarios
	 */
	private List<Scenario> createScenarios(Simulation defaultSimulation, List<Process> defaultProcesses) throws SystemException {
		if(ScenarioLocalServiceUtil.countBySimulationId(defaultSimulation.getSimulation_id()) == 0){
			Scenario defaultScenario = ScenarioLocalServiceUtil.createDefaultScenario(defaultSimulation);
			long scenarioId = defaultScenario.getScenario_id();
			ScenarioLocalServiceUtil.addProcess(scenarioId, defaultProcesses.get(LOGIN).getProcess_id(), 0, 3);
			ScenarioLocalServiceUtil.addProcess(scenarioId, defaultProcesses.get(RANDOM).getProcess_id(), 1, 2);
			ScenarioLocalServiceUtil.addProcess(scenarioId, defaultProcesses.get(LOGOUT).getProcess_id(), 2, 0);
		}
		return ScenarioLocalServiceUtil.findBySimulationId(defaultSimulation.getSimulation_id());
	}
	
	/**
	 * Takes a list of scenarios and converts it into scenarioDTOs that will represent
	 * boxes in the view
	 * @param scenarios The scenarios to convert into scenariosDTOs
	 * @param boxCounter The BoxCounter that will be used to give ids to the boxes.
	 * 		boxCounter is updated by this function.
	 * @return The scenariosDTO converted from the given scenarios
	 * @throws SystemException If some service fail
	 * @throws PortalException If Portal services encounter a problem
	 */
	private List<ScenarioDTO> convertScenariosToScenariosDTO(List<Scenario> scenarios, BoxCounter boxCounter)
			throws SystemException, PortalException {
		int counter = boxCounter.getCount();
		List<ScenarioDTO> scenariosDTO = new ArrayList<>(scenarios.size());
		for (Scenario scenario : scenarios) {
			ScenarioDTO s = ScenarioDTOMapper.toDTO(scenario, counter);
			scenariosDTO.add(s);
			counter += s.getProcesses().size();
		}
		boxCounter.setCount(counter);
		return scenariosDTO;
	}
	
	
	
	
	
	/**
	 * Function called when the injection profile is saved
	 * 
	 * it updates all the injection data received from the view
	 * @param request
	 * @param response
	 * @param model
	 * @throws SystemException
	 * @throws NoSuchScenarioException
	 */
	@ActionMapping(params="action=saveInjectionProfile")
	public void saveInjectionProfile(final ActionRequest request, final ActionResponse response, final Model model) throws SystemException, NoSuchScenarioException{

		long simulationId = ParamUtil.getLong(request, "simulationId");
		long numberOfUsers = ParamUtil.getLong(request, "numberOfUsers");
		long rampUp = ParamUtil.getLong(request, "rampUp");
		String injection = ParamUtil.getString(request, "injectionMode");
		
		// Update scenario values
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
	 * @param request
	 * @param response
	 * @param model
	 * @throws PortalException
	 * @throws SystemException
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
	 * @param request
	 * @param response
	 * @param model
	 * @throws SystemException
	 * @throws PortalException
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
	 * @param request
	 * @param response
	 * @throws ValidatorException
	 * @throws ReadOnlyException
	 * @throws IOException
	 * @throws SystemException
	 * @throws PortalException
	 * @throws Exception
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
	 * @param request
	 * @param response
	 * @param model
	 * @throws SystemException
	 * @throws PortalException
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
