package com.excilys.liferay.gatling;

import com.excilys.liferay.gatling.model.Request;
import com.excilys.liferay.gatling.model.Scenario;
import com.excilys.liferay.gatling.model.Simulation;
import com.excilys.liferay.gatling.mustache.ScriptGeneratorGatling;
import com.excilys.liferay.gatling.service.RequestLocalServiceUtil;
import com.excilys.liferay.gatling.service.ScenarioLocalServiceUtil;
import com.excilys.liferay.gatling.service.SimulationLocalServiceUtil;
import com.excilys.liferay.gatling.util.DisplayLayout;
import com.excilys.liferay.gatling.util.DisplayLayoutUtil;
import com.excilys.liferay.gatling.util.GatlingUtil;
import com.excilys.liferay.gatling.util.IdDisplayLayout;
import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import com.github.mustachejava.MustacheFactory;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.HttpHeaders;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.Layout;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.ReadOnlyException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.ValidatorException;

/**
 * Portlet implementation class GatlingPortlet.
 */
public class GatlingPortlet extends MVCPortlet {


	/**
	 * attribute mustacheFoctory.
	 */

	private MustacheFactory mf = new DefaultMustacheFactory();

	/**
	 * logging.
	 */
	private static final Log LOG = LogFactoryUtil.getLog(GatlingPortlet.class);

	/**
	 * pages of portlet.
	 */
	protected String jspListSimulation, jspEditSimulation, jspEditScenario, jspFormFirstScenario, jspHelp;

	/**
	 * get all name page and create the role 'gatling' on init portlet.
	 * @throws PortletException
	 */
	@Override
	public void init() throws PortletException {
		jspListSimulation = getInitParameter("list-simulation-jsp");
		jspEditSimulation = getInitParameter("edit-simulation-jsp");
		jspEditScenario = getInitParameter("edit-scenario-jsp");
		jspFormFirstScenario = getInitParameter("form-first-scenario-jsp");
		jspHelp = getInitParameter("help-jsp");
		super.init();
	}

	/**
	 * Adds a new Simulation to the database.
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public void addSimulation(final ActionRequest request, final ActionResponse response) throws Exception {
		Simulation simulation = SimulationLocalServiceUtil.addSimulationFromRequest(request, response);

		if (simulation != null) {
			int scenarioListSize = ScenarioLocalServiceUtil.countBySimulationId(simulation.getSimulation_id());
			response.setRenderParameter("simulationId", Long.toString(simulation.getSimulation_id()));
			// If new simulation the redirect to add First scenario page else edit simulation page
			LOG.info("Simulation added");
			response.setRenderParameter("page", scenarioListSize == 0 ? jspFormFirstScenario : jspEditSimulation); 
		} else {
			LOG.debug("Simulation fails to add");
			response.setRenderParameter("page", jspListSimulation);
		}
	}

	/**
	 * edit simulation method
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public void editSimulation(ActionRequest request, ActionResponse response) throws Exception {
		long simulationId = ParamUtil.getLong(request, "simulationId");
		LOG.info("edit Simulation with id : " + simulationId);
		Simulation simulation = SimulationLocalServiceUtil.getSimulation(simulationId);
		simulation.setName(ParamUtil.getString(request, "simulationName"));
		String variable = GatlingUtil.createVariableName("Simulation", ParamUtil.getString(request, "variableSimulationName"));
		simulation.setVariableName(variable);
		SimulationLocalServiceUtil.updateSimulation(simulation);
		response.setRenderParameter("simulationId", Long.toString(simulationId));
		response.setRenderParameter("page", jspEditSimulation);
	}

	/**
	 * remove simulation method
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public void removeSimulation(ActionRequest request, ActionResponse response) throws Exception {
		long simulationId = ParamUtil.getLong(request, "simulationId");
		if (LOG.isDebugEnabled()) {
			LOG.debug("remove Simulation with id : " + simulationId);
		}

		SimulationLocalServiceUtil.removeSimulationCascade(simulationId);
		response.setRenderParameter("page", jspListSimulation);
	}


	/**
	 * Add a new Scenario to the database.
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public void addScenario(final ActionRequest request, final ActionResponse response) throws Exception {
		Scenario scenario = ScenarioLocalServiceUtil.addScenarioFromRequest(request, response);
		String first = ParamUtil.getString(request, "first");
		if (scenario != null) {
			// redirect to editScenario
			response.setRenderParameter("scenarioId", Long.toString(scenario.getScenario_id()));
			response.setRenderParameter("page", jspEditScenario);
		} else {
			response.setRenderParameter("simulationId", Long.toString(ParamUtil.getLong(request, "simulationId")));
			response.setRenderParameter("page", !first.equals("") ? jspFormFirstScenario : jspEditSimulation);
			response.setRenderParameter("page", jspEditSimulation);
		}
	}

	/**
	 * edit scenario.
	 * 
	 * @param request
	 * @param response
	 * @throws SystemException
	 * @throws PortalException
	 */
	public void editScenario(final ActionRequest request, final ActionResponse response) throws SystemException, PortalException {
		LOG.debug("edit scenario controler");
		Scenario scenario = ScenarioLocalServiceUtil.editScenarioFromRequest(request, response);
		response.setRenderParameter("page", scenario != null ? jspEditSimulation : jspListSimulation);
		if (scenario != null) {
			response.setRenderParameter("simulationId", Long.toString(scenario.getSimulation_id()));
		}
	}

	/**
	 * Remove scenario from database.
	 * @param request
	 * @param response
	 * @throws PortalException
	 * @throws SystemException
	 */
	public void removeScenario(final ActionRequest request, final ActionResponse response)
			throws PortalException, SystemException {
		long scenarioId = ParamUtil.getLong(request, "scenarioId");
		long simulationId = ParamUtil.getLong(request, "simulationId");
		if (LOG.isDebugEnabled()){
			LOG.debug("remove Scenario with id : " + scenarioId);
		}
		// cascade delete
		ScenarioLocalServiceUtil.removeByIdCascade(scenarioId);
		response.setRenderParameter("simulationId", Long.toString(simulationId));
		response.setRenderParameter("page", jspEditSimulation);
	}


	/**
	 * Remove request from database.
	 * @param request
	 * @param response
	 * @throws PortalException
	 * @throws SystemException
	 */
	public void removeRequest(final ActionRequest request, final ActionResponse response) throws PortalException, SystemException {
		long requestId = Long.parseLong(request.getParameter("requestId"));
		RequestLocalServiceUtil.deleteRequest(requestId);
		LOG.debug("request deleted succefully ");
	}

	/**
	 * get the scenario state, if completed or not yet.
	 * @param scenario
	 * @return
	 */
	private int scenarioState(Scenario scenario) {
		try {
			int count = RequestLocalServiceUtil.countByScenarioIdAndUsed(scenario.getScenario_id());
			if (count != 0 && scenario.getDuration() != 0 && scenario.getUsers_per_seconds() != 0) {
				// completed scenario = case if all minimal information are
				// completed
				return 2;
			} else if (count != 0 && (scenario.getDuration() == 0 || scenario.getUsers_per_seconds() == 0)) {
				// incomplete scenario = case if one or more information detail of
				// scenario are not completed but there is request selected
				return 1;
			} else if ((count == 0)) {
				//case if not request selected to that scenario = empty scenario
				return 0;
			}
			// case if not request selected to that scenario = empty scenario
			return 0;
		} catch (SystemException e) {
			if (LOG.isErrorEnabled()){
				LOG.error("enable to determine Scenario state " + e.getMessage());
			}
			return 0;
		}
	}

	/**
	 * get the simulation state, if all scenario are completed or not yet.
	 * @param simulation
	 * @return
	 */
	public int simulationState(final Simulation simulation) {
		try {
			List<Scenario> scenariosList = ScenarioLocalServiceUtil.findBySimulationId(simulation.getSimulation_id());
			int checkNumberCompleted = 0;
			for (Scenario scenario : scenariosList) {
				if (scenarioState(scenario) == 2) {
					checkNumberCompleted++;
				}
			}
			if ((checkNumberCompleted == 0) || (scenariosList.size() == 0)) {
				//if no one scenario is completed = simulation empty
				return 0;
			} else if (checkNumberCompleted == scenariosList.size()) {
				//if all scenario completed = simulation complited
				return 2;
			} else {
				//other case = simulation incompleted
				return 1;
			}
		} catch (SystemException e) {
			if (LOG.isErrorEnabled()) {
				LOG.error("enable to determine Simulation state " + e.getMessage());
			}
			return 0;
		}
	}

	/**
	 * View method : redirect to requested page and send necessary parameters.
	 */

	@Override
	public void doView(final RenderRequest renderRequest, final RenderResponse renderResponse) throws IOException, PortletException {
		/* get the path  for next jsp or by  default jspListSimulation */
		String page = ParamUtil.get(renderRequest, "page", jspListSimulation);

		//view.jsp => list of the simulations
		if (page.equals(jspListSimulation)) {
			LOG.debug("DoView : List Simulation");
			List<Simulation> simulationList = new ArrayList<Simulation>();
			Map<Simulation, Integer[]> simulationMap = new HashMap<Simulation, Integer[]>();
			try {
				simulationList = SimulationLocalServiceUtil.getSimulations(0, SimulationLocalServiceUtil.getSimulationsCount());
				for (Simulation simulation : simulationList) {
					Integer[] simulationInfos = new Integer[2];
					List<Scenario> scenarioList = ScenarioLocalServiceUtil.findBySimulationId(simulation.getSimulation_id());
					simulationInfos[0] = scenarioList.size();
					simulationInfos[1] = simulationState(simulation);
					simulationMap.put(simulation, simulationInfos);
				}
			} catch (SystemException e) {
				throw new RuntimeException("error with getSimulation with localServiceUtil " + e.getMessage());
			}
			String JSListName = GatlingUtil.createJSListOfSimulationName(simulationList);
			final PortletPreferences prefs = renderRequest.getPreferences();
			String gatlingVersionString;
			gatlingVersionString = prefs.getValue("gatlingVersion", null);
			renderRequest.setAttribute("gatlingVersion", gatlingVersionString);
			renderRequest.setAttribute("listOfSimulationName", JSListName);
			renderRequest.setAttribute("listSimulation", simulationList);
			renderRequest.setAttribute("MapSimulation", simulationMap);
		} else if (page.equals(jspEditSimulation) || page.equals(jspFormFirstScenario)) {
			/*
			 * Edit simulation, get and send scenarios list to jsp page
			 */
			LOG.debug("DoView : Edit Simulation");
			Long id = (Long) ParamUtil.getLong(renderRequest, "simulationId");
			if(id==null)
				throw new NullPointerException("simulation id is null");

			Simulation simulation;
			try {
				simulation = SimulationLocalServiceUtil.getSimulation(id);
				renderRequest.setAttribute("simulation", simulation);
				// List of Scenario
				List<Scenario> scenarioList = ScenarioLocalServiceUtil.findBySimulationId(simulation.getSimulation_id());

				// map <scenario, scenarioInfo>
				Map<Scenario, Number[]> scenariosMap = new HashMap<Scenario, Number[]>();
				for (Scenario scenario : scenarioList) {
					Number[] info = new Number[3];
					info[2] = scenarioState(scenario);
					info[0] = RequestLocalServiceUtil.countByScenarioIdAndUsed(scenario.getScenario_id());
					info[1] = RequestLocalServiceUtil.countByScenarioId(scenario.getScenario_id());
					scenariosMap.put(scenario, info);
				}
				String JSListName = GatlingUtil.createJSListOfScenarioName(scenarioList);
				renderRequest.setAttribute("listOfScenarioName", JSListName);
				/*
				 * get list of simulation (for edit name)
				 */
				List<Simulation> listSimulations = SimulationLocalServiceUtil.getSimulations(0,
						SimulationLocalServiceUtil.getSimulationsCount());
				String JSListSimName = GatlingUtil.createJSListOfSimulationName(listSimulations);
				renderRequest.setAttribute("listOfSimulationName", JSListSimName);

				renderRequest.setAttribute("listScenario", scenarioList);
				renderRequest.setAttribute("MapScenario", scenariosMap);
			} catch (SystemException e) {
				throw new RuntimeException("error with get scenario list with localServiceUtil " + e.getMessage());
			} catch (PortalException  e) {
				throw new RuntimeException("error with get scenario list with localServiceUtil " + e.getMessage());

			}

			// List of Sites
			List<Group> listGroups = GatlingUtil.getListOfSites();
			renderRequest.setAttribute("listGroup", listGroups);
		}else if (page.equals(jspEditScenario)) {
			/*
			 * Edit scenario -> request list send to jsp page
			 */
			LOG.debug("DoView : Edit Scenario");
			if (ParamUtil.getLong(renderRequest, "scenarioId") == 0) {
				throw new NullPointerException("scenario id is null");
			}
			try {
				// get scenario
				Scenario scenario = ScenarioLocalServiceUtil.getScenario(ParamUtil.getLong(renderRequest, "scenarioId"));

				//get public layout list
				long groupId = scenario.getGroup_id();
				List<Layout> listPublicLayouts = LayoutLocalServiceUtil.getLayouts(groupId, false, 0);
				// and private layouts
				List<Layout> listPrivateLayouts = LayoutLocalServiceUtil.getLayouts(groupId, true, 0);

				//get site name
				String siteName = GroupLocalServiceUtil.getGroup(groupId).getName();

				//create DisplayLayoutList with actuel layout(public and private) of the site and old layout added from requests
				List<DisplayLayout> displayLayoutList = new ArrayList<DisplayLayout>();
				DisplayLayoutUtil.addLayoutToDisplayLayoutList(displayLayoutList, listPublicLayouts);
				DisplayLayoutUtil.addLayoutToDisplayLayoutList(displayLayoutList, listPrivateLayouts);

				// Get Hierachy (used to add a button if a row is a parent)
				Map<IdDisplayLayout, List<IdDisplayLayout>> hierachy = new LinkedHashMap<IdDisplayLayout, List<IdDisplayLayout>>();
				DisplayLayoutUtil.mapHierachy(displayLayoutList, hierachy);

				//get list of request to add the old page to DisplayLayout
				List<Request> listRequests = RequestLocalServiceUtil.findByScenarioId(ParamUtil.get(renderRequest, "scenarioId", 0));
				//Merge Layout and Request in DisplayLayout List
				displayLayoutList = DisplayLayoutUtil.addRequestToDisplayLayoutList(displayLayoutList, listRequests);

				// Get list of used names
				List<Scenario> scenariolist = ScenarioLocalServiceUtil.getScenarios(0, ScenarioLocalServiceUtil.getScenariosCount());
				String JSListName = GatlingUtil.createJSListOfScenarioName(scenariolist);

				//add private and public url of site
				String privateURL = scenario.getUrl_site().replace("web", "group");
				String publicURL = scenario.getUrl_site();

				//add request parameters
				renderRequest.setAttribute("scenario", scenario);
				renderRequest.setAttribute("listPages", displayLayoutList);
				renderRequest.setAttribute("hierachy", hierachy);
				renderRequest.setAttribute("siteName", siteName);
				renderRequest.setAttribute("privateURL", privateURL);
				renderRequest.setAttribute("publicURL", publicURL);
				renderRequest.setAttribute("listOfScenarioName", JSListName);

			} catch (SystemException e) {
				throw new RuntimeException("connot get layout list: " + e.getMessage());
			} catch (PortalException e) {
				throw new RuntimeException("connot get layout list: " + e .getMessage());
			}
		}

		/* redirect to jsp page */
		include(page, renderRequest, renderResponse);
	}

	/**
	 * 
	 */
	@Override
	public void serveResource(final ResourceRequest request, final ResourceResponse response) {
		/*
		 * Get template from version
		 */
		int gatlingVersion = ParamUtil.getInteger(request, "gatlingVersion");

		//add user preference
		final PortletPreferences prefs = request.getPreferences();
		try {
			prefs.setValue("gatlingVersion", Integer.toString(gatlingVersion));
			prefs.store();
		} catch (ReadOnlyException e) {
			throw new RuntimeException("connot add user preferences for gatling version " + e.getMessage());
		} catch (ValidatorException e) {
			throw new RuntimeException("connot add user preferences for gatling version " + e.getMessage());
		} catch (IOException e) {
			throw new RuntimeException("connot add user preferences for gatling version " + e.getMessage());
		}
		//scripting Gatling
		String template;
		switch (gatlingVersion) {
		case 1:
			template = "resources/templateGatling1.5.mustache";
			break;
		case 2:
			template = "resources/templateGatling2.0.mustache";
			break;
		default:
			template = "resources/templateGatling2.0.mustache";
			break;
		}
		/*
		 * Get simulations ids
		 */
		long[] simulationsIds = ParamUtil.getLongValues(request, "export");
		Simulation simulation;
		Date date = new Date();
		Mustache mustache = mf.compile(template);
		if (simulationsIds.length > 1) {
			response.setContentType("application/zip");
			response.addProperty("Content-Disposition", "attachment; filename = GatlingSimulations" + date.getTime() + ".zip");

			try {
				ZipOutputStream zipOutputStream = new ZipOutputStream(response.getPortletOutputStream());
				for (long id : simulationsIds) {
					if (id  > 0) {
						simulation = SimulationLocalServiceUtil.getSimulation(id);
						zipOutputStream.putNextEntry(new ZipEntry("Simulation" + simulation.getName() + date.getTime() + ".scala"));
						mustache.execute(new PrintWriter(zipOutputStream), new ScriptGeneratorGatling(id)).flush();
						zipOutputStream.closeEntry();
					}
				}
				zipOutputStream.close();
			} catch (Exception e) {
				throw new RuntimeException("connot export zip for scenario(s) " + e.getMessage());
			}

		} else if (simulationsIds.length == 1 && simulationsIds[0] > 0) {
			//create and export only one file with scenario script for this simulation id
			response.setContentType("application/x-wais-source");
			try {
				simulation = SimulationLocalServiceUtil.getSimulation(simulationsIds[0]);
				response.addProperty("Content-Disposition", "attachment; filename=Simulation"  + simulation.getName()  + date.getTime() + ".scala");
				OutputStream out = response.getPortletOutputStream();

				mustache.execute(new PrintWriter(out), new ScriptGeneratorGatling(simulationsIds[0])).flush();
				out.close();
			} catch (Exception e) {
				throw new RuntimeException("connot export script file " + e.getMessage());
			}
		} else {
			//if no one valide simulation id received then error
			throw new NullPointerException("nothing to export");
		}
		response.addProperty(HttpHeaders.CACHE_CONTROL, "max-age=3600, must-revalidate");
	}
}