package com.excilys.liferay.gatling.controller;

import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletPreferences;
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

import com.excilys.liferay.gatling.exception.EmptySimulation;
import com.excilys.liferay.gatling.model.Scenario;
import com.excilys.liferay.gatling.model.Simulation;
import com.excilys.liferay.gatling.mustache.ScriptGeneratorGatling;
import com.excilys.liferay.gatling.service.RequestLocalServiceUtil;
import com.excilys.liferay.gatling.service.ScenarioLocalServiceUtil;
import com.excilys.liferay.gatling.service.SimulationLocalServiceUtil;
import com.excilys.liferay.gatling.util.GatlingUtil;
import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.HttpHeaders;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.model.Group;
import com.liferay.portal.util.PortalUtil;
import com.samskivert.mustache.Mustache;
import com.samskivert.mustache.Template;

@Controller(value="SimulationController")
@RequestMapping("VIEW")
public class SimulationController {

	private static final Log LOG = LogFactoryUtil.getLog(SimulationController.class);

	@RenderMapping(params="render=renderSimulation")
	public String editSimulationRender(final RenderRequest renderRequest, final RenderResponse renderResponse) throws SystemException, PortalException, EmptySimulation {
		final Long id = Long.parseLong(renderRequest.getParameter("simulationId"));
		if(id==null) {
			throw new NullPointerException("simulation id is null");
		}
		final Simulation simulation = SimulationLocalServiceUtil.getSimulation(id);
		final int scenarioListSize = ScenarioLocalServiceUtil.countBySimulationId(simulation.getSimulation_id());
		renderRequest.setAttribute("simulation", simulation);
		// List of Sites
		final List<Group> listGroups = GatlingUtil.getListOfSites();
		renderRequest.setAttribute("listGroup", listGroups);
		// If empty go to form first scenario
		if(scenarioListSize == 0) {
			return "formAddFirstScenario";
		} 
		// List of Scenario
		final List<Scenario> scenarioList = ScenarioLocalServiceUtil.findBySimulationId(simulation.getSimulation_id());

		// map <scenario, scenarioInfo>
		final Map<Scenario, Number[]> scenariosMap = new HashMap<Scenario, Number[]>();
		for (final Scenario scenario : scenarioList) {
			final Number[] info = new Number[3];
			info[0] = RequestLocalServiceUtil.countByScenarioIdAndUsedAndIsNotPortlet(scenario.getScenario_id());
			info[1] = RequestLocalServiceUtil.countByScenarioIdAndIsNotPortlet(scenario.getScenario_id());
			info[2] = scenarioState(scenario);
			scenariosMap.put(scenario, info);
		}
		final String JSListName = GatlingUtil.createJSListOfScenarioName(scenarioList);
		renderRequest.setAttribute("listOfScenarioName", JSListName);
		/*
		 * get list of simulation (for edit name)
		 */
		final List<Simulation> listSimulations = SimulationLocalServiceUtil.getSimulations(0,
				SimulationLocalServiceUtil.getSimulationsCount());
		final String JSListSimName = GatlingUtil.createJSListOfSimulationName(listSimulations);

		renderRequest.setAttribute("listOfSimulationName", JSListSimName);
		renderRequest.setAttribute("listScenario", scenarioList);
		renderRequest.setAttribute("MapScenario", scenariosMap);
		return "editSimulation";

	}

	@ActionMapping(params="action=addSimulation")
	public void addScenarioAction(final ActionRequest request, final ActionResponse response) throws SystemException {


		final Simulation simulation = SimulationLocalServiceUtil.addSimulationFromRequest(request);
		LOG.info(simulation);
		if (simulation != null) {
			response.setRenderParameter("simulationId", Long.toString(simulation.getSimulation_id()));
			response.setRenderParameter("render", "renderSimulation");
			LOG.debug("Simulation added"); 
		} else {
			response.setRenderParameter("render", "renderView");
			LOG.debug("Simulation fails to add");
		}
	}

	@ActionMapping(params="action=editSimulation")
	public void editSimulationAction(final ActionRequest request, final ActionResponse response, final Model model) throws SystemException, PortalException{

		final long simulationId = ParamUtil.getLong(request, "simulationId");
		LOG.debug("edit Simulation with id : " + simulationId);
		final Simulation simulation = SimulationLocalServiceUtil.getSimulation(simulationId);
		simulation.setName(ParamUtil.getString(request, "simulationName"));
		SimulationLocalServiceUtil.updateSimulation(simulation);
		response.setRenderParameter("simulationId", Long.toString(simulationId));
		response.setRenderParameter("render", "renderSimulation");
		SessionMessages.add(request, "your-request-completed-successfully");
	}
	
	@ActionMapping(params="action=editFeeder")
	public void editFeederAction(final ActionRequest request, final ActionResponse response, final Model model) throws SystemException, PortalException{
		final long simulationId = ParamUtil.getLong(request, "simulationId");
		LOG.debug("Edit Feeder of simulationId "+simulationId);
		final Simulation simulation = SimulationLocalServiceUtil.getSimulation(simulationId);
		// isAFile
		final String radioOption = ParamUtil.getString(request, "option");
		final boolean isAFile = radioOption.equals("content2");
		simulation.setIsFeederAFile(isAFile);
		// content
		String content = "manualUsers";
		if(isAFile) {
			content="fileUsers";
		}
		simulation.setFeederContent(ParamUtil.getString(request,content));
		SimulationLocalServiceUtil.updateSimulation(simulation);
		response.setRenderParameter("simulationId", Long.toString(simulationId));
		response.setRenderParameter("render", "renderSimulation");
		SessionMessages.add(request, "your-request-completed-successfully");
	}

	@ActionMapping(params="action=deleteSimulation")
	public void deleteSimulationAction(final ActionRequest request, final ActionResponse response, final Model model) throws SystemException, NoSuchModelException{
		final long simulationId = ParamUtil.getLong(request, "simulationId");
		if (LOG.isDebugEnabled()) {
			LOG.debug("remove Simulation with id : " + simulationId);
		}
		SimulationLocalServiceUtil.removeSimulationCascade(simulationId);
		response.setRenderParameter("render", "renderView");
	}
	
	@ResourceMapping(value="oneScript")
	public void serveOneScript(final ResourceRequest request, final ResourceResponse response) throws IOException, ReadOnlyException, ValidatorException{

		final int gatlingVersion = ParamUtil.getInteger(request, "gatlingVersion");
		final PortletPreferences prefs = request.getPreferences();
		prefs.setValue("gatlingVersion", Integer.toString(gatlingVersion));
		prefs.store();

		//create and export only one file with scenario script for this simulation id
		Simulation simulation = null;
		final Date date = new Date();		
		String template;
		switch (gatlingVersion) {
		case 1:
			template = "/templateGatling1.5.mustache";
			break;
		case 2:
		default:
			template = "/templateGatling2.0.X.mustache";
			break;
		}
		final long simulationId = ParamUtil.getLong(request, "export");
		response.setContentType("application/x-wais-source");
		try {
			simulation = SimulationLocalServiceUtil.getSimulation(simulationId);
			response.addProperty("Content-Disposition", "attachment; filename=Simulation"  + simulation.getName()  + date.getTime() + ".scala");
			final OutputStream out = response.getPortletOutputStream();
			final String currentPath = request.getPortletSession().getPortletContext().getRealPath("/WEB-INF/src/resources") + template;
			final Template tmpl = Mustache.compiler().compile(new FileReader(currentPath));
			final String script = tmpl.execute(new ScriptGeneratorGatling(simulationId,PortalUtil.getPortalURL(request)));
			out.write(script.getBytes());
			out.flush();
			out.close();
		} catch (final Exception e) {
			throw new RuntimeException("cannot export script file " + e.getMessage());
		}
		response.addProperty(HttpHeaders.CACHE_CONTROL, "max-age=3600, must-revalidate");


	}


	/**
	 * get the scenario state, if completed or not yet.
	 * @param scenario
	 * @return
	 */
	private int scenarioState(final Scenario scenario) throws SystemException {
		final int count = RequestLocalServiceUtil.countByScenarioIdAndUsedAndIsNotPortlet(scenario.getScenario_id());
		if (count != 0 && scenario.isComplete()) {
			// completed scenario = case if all minimal information are
			// completed
			return 2;
		} else if (count != 0 && !scenario.isComplete()) {
			// incomplete scenario = case if one or more information detail of
			// scenario are not completed but there is request selected
			return 1;
		}
		// case if not request selected to that scenario = empty scenario
		return 0;
	}
}