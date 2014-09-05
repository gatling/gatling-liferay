/**
 * Copyright 2011-2014 eBusiness Information, Groupe Excilys (www.ebusinessinformation.fr)
 */
package com.excilys.liferay.gatling;


import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
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
import javax.servlet.http.Cookie;

import com.excilys.liferay.gatling.dto.RequestDTO;
import com.excilys.liferay.gatling.dto.LinkUsecaseRequestDTO;
import com.excilys.liferay.gatling.dto.PortletConfigDTO;
import com.excilys.liferay.gatling.dto.PortletConfigDTO.PortletConfigDTOBuilder;
import com.excilys.liferay.gatling.exception.EmptySimulation;
import com.excilys.liferay.gatling.model.Record;
import com.excilys.liferay.gatling.model.Request;
import com.excilys.liferay.gatling.model.Scenario;
import com.excilys.liferay.gatling.model.Simulation;
import com.excilys.liferay.gatling.model.UrlRecord;
import com.excilys.liferay.gatling.mustache.ListScript;
import com.excilys.liferay.gatling.mustache.ScriptGeneratorGatling;
import com.excilys.liferay.gatling.service.LinkUsecaseRequestLocalServiceUtil;
import com.excilys.liferay.gatling.service.RecordLocalServiceUtil;
import com.excilys.liferay.gatling.service.RequestLocalServiceUtil;
import com.excilys.liferay.gatling.service.ScenarioLocalServiceUtil;
import com.excilys.liferay.gatling.service.SimulationLocalServiceUtil;

import com.excilys.liferay.gatling.util.DisplayItemDTOUtil;
import com.excilys.liferay.gatling.service.UrlRecordLocalServiceUtil;

import com.excilys.liferay.gatling.util.GatlingUtil;
import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import com.github.mustachejava.MustacheFactory;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.HttpHeaders;
import com.liferay.portal.kernel.util.CookieKeys;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.Layout;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.portal.service.PortletLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;


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
	protected String jspListSimulation, jspEditSimulation, jspEditScenario, jspFormFirstScenario, jspHelp, jspEditPortlet, jspEditRecord;

	/**
	 * get all name page
	 * @throws PortletException
	 */
	@Override
	public void init() throws PortletException {
		jspListSimulation = getInitParameter("list-simulation-jsp");
		jspEditSimulation = getInitParameter("edit-simulation-jsp");
		jspEditScenario = getInitParameter("edit-scenario-jsp");
		jspFormFirstScenario = getInitParameter("form-first-scenario-jsp");
		jspHelp = getInitParameter("help-jsp");
		jspEditPortlet = "/html/gatling/popupPortlet/portletConfig.jsp";
		jspEditRecord="/html/gatling/popupPortlet/pages/editRecord.jsp";
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
		Simulation simulation = SimulationLocalServiceUtil.addSimulationFromRequest(request);

		if (simulation != null) {
			response.setRenderParameter("simulationId", Long.toString(simulation.getSimulation_id()));
			// If new simulation the redirect to add First scenario page else edit simulation page
			LOG.info("Simulation added");
			response.setRenderParameter("page", jspEditSimulation); 
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
		String variable = GatlingUtil.createVariableName("Simulation", GatlingUtil.createVariableName("simulation", simulation.getName()));
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
		Scenario scenario = ScenarioLocalServiceUtil.addScenarioFromRequest(request);
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
		Scenario scenario = ScenarioLocalServiceUtil.editScenarioFromRequest(request);
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
		response.setRenderParameter("scenarioId", request.getParameter("scenarioId"));
		response.setRenderParameter("page", jspEditScenario);
	}

	/**
	 * edit portlet sample.
	 * 
	 * @param request
	 * @param response
	 * @throws SystemException
	 * @throws PortalException
	 */
	public void editPortletSample(final ActionRequest request, final ActionResponse response) throws SystemException, PortalException {
		LOG.debug("editPortletSample");
		long requestId = ParamUtil.getLong(request, "requestId");
		long[] linkUsecaseRequestIds = ParamUtil.getLongValues(request, "idLink");
		long[] usecaseWeight = ParamUtil.getLongValues(request, "weightScenarioSample");
		long[] recordIds = ParamUtil.getLongValues(request, "recordId");
		boolean[] areSample = ParamUtil.getBooleanValues(request, "isSample");
		
		if(linkUsecaseRequestIds.length == usecaseWeight.length && usecaseWeight.length == areSample.length) {
			for(int i=0; i<linkUsecaseRequestIds.length;i++) {
				long id = linkUsecaseRequestIds[i];
				long weight = usecaseWeight[i];
				long recordId = recordIds[i];
				boolean isSample = areSample[i];
				LinkUsecaseRequestLocalServiceUtil.saveLinkUseCase(id, requestId, recordId, weight, isSample);
			}
		}

		response.setRenderParameter("page", jspEditPortlet);
		//hack, only work this way ....
		response.setRenderParameter("p_p_state", "pop_up");
		PortalUtil.copyRequestParameters(request, response);
	}

	/**
	 * 
	 * @param request
	 * @param response
	 * @throws SystemException
	 * @throws PortalException
	 */
	public void removeLinkUseCase(final ActionRequest request, final ActionResponse response) throws SystemException, PortalException{

		final Map<String, String[]> parameters = request.getParameterMap();
		long useCaseId = Long.parseLong(StringUtil.merge(parameters.get("useCaseId")));
		LinkUsecaseRequestLocalServiceUtil.deleteLinkUsecaseRequest(useCaseId);		

		//redirect
		response.setRenderParameter("page", jspEditPortlet);
		//hack, only work this way ....
		response.setRenderParameter("p_p_state", "pop_up");
		PortalUtil.copyRequestParameters(request, response);
	}
	
	/**
	 * 
	 * @param request
	 * @param response
	 * @throws SystemException
	 * @throws PortalException
	 */
	public void removeRecord(final ActionRequest request, final ActionResponse response) throws SystemException, PortalException{

		final Map<String, String[]> parameters = request.getParameterMap();
		long recordId = Long.parseLong(StringUtil.merge(parameters.get("recordId")));
		RecordLocalServiceUtil.deleteRecord(recordId);
		LinkUsecaseRequestLocalServiceUtil.removeByRecordId(recordId);
		//redirect
		response.setRenderParameter("page", jspEditPortlet);
		//hack, only work this way ....
		response.setRenderParameter("p_p_state", "pop_up");
		PortalUtil.copyRequestParameters(request, response);
	}
	
	/**
	 * 
	 * @param request
	 * @param response
	 * @throws SystemException
	 * @throws PortalException
	 */
	public void toggleRecord(final ActionRequest request, final ActionResponse response) throws SystemException, PortalException {
		String recordState = ParamUtil.getString(request, "nextRecordState");
		response.setRenderParameter("recordState", recordState);
		//hack, only work this way ....
		response.setRenderParameter("p_p_state", "pop_up");
		PortalUtil.copyRequestParameters(request, response);
	}

	/**
	 * get the scenario state, if completed or not yet.
	 * @param scenario
	 * @return
	 */
	private int scenarioState(Scenario scenario) {
		try {
			int count = RequestLocalServiceUtil.countByScenarioIdAndUsedAndIsNotPortlet(scenario.getScenario_id());
			if (count != 0 && scenario.getDuration() != 0 && scenario.getUsers_per_seconds() != 0) {
				// completed scenario = case if all minimal information are
				// completed
				return 2;
			} else if (count != 0 && (scenario.getDuration() == 0 || scenario.getUsers_per_seconds() == 0)) {
				// incomplete scenario = case if one or more information detail of
				// scenario are not completed but there is request selected
				return 1;
			}
		} catch (SystemException e) {
			if (LOG.isErrorEnabled()){
				LOG.error("enable to determine Scenario state " + e.getMessage());
			}
		}
		// case if not request selected to that scenario = empty scenario
		return 0;
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

		if (page.equals(jspListSimulation)) {
			/*
			 * 
			 * 
			 * ===== view.jsp => list of the simulations
			 * 
			 * 
			 */
			LOG.debug("DoView : List Simulation");
			List<Simulation> simulationList = new ArrayList<Simulation>();
			Map<Simulation, Integer[]> simulationMap = new HashMap<Simulation, Integer[]>();
			try {
				simulationList = SimulationLocalServiceUtil.getSimulations(0, SimulationLocalServiceUtil.getSimulationsCount());
				for (Simulation simulation : simulationList) {
					Integer[] simulationInfos = new Integer[2];
					simulationInfos[0] = ScenarioLocalServiceUtil.countBySimulationId(simulation.getSimulation_id());
					simulationInfos[1] = simulationState(simulation);
					simulationMap.put(simulation, simulationInfos);
				}
			} catch (SystemException e) {
				throw new RuntimeException("error with getSimulation with localServiceUtil " + e.getMessage());
			}
			String JSListName = GatlingUtil.createJSListOfSimulationName(simulationList);
			final javax.portlet.PortletPreferences prefs = renderRequest.getPreferences();
			String gatlingVersionString;
			gatlingVersionString = prefs.getValue("gatlingVersion", null);
			renderRequest.setAttribute("gatlingVersion", gatlingVersionString);
			renderRequest.setAttribute("listOfSimulationName", JSListName);
			renderRequest.setAttribute("listSimulation", simulationList);
			renderRequest.setAttribute("MapSimulation", simulationMap);
		} else if (page.equals(jspEditSimulation) || page.equals(jspFormFirstScenario)) {
			/*
			 * 
			 * 
			 * ===== Edit simulation, get and send scenarios list to jsp page
			 * 
			 * 
			 */
			LOG.debug("DoView : Edit Simulation");

			Long id = (Long) ParamUtil.getLong(renderRequest, "simulationId");
			if(id==null)
				throw new NullPointerException("simulation id is null");

			Simulation simulation;		

			try {
				simulation = SimulationLocalServiceUtil.getSimulation(id);
				int scenarioListSize = ScenarioLocalServiceUtil.countBySimulationId(simulation.getSimulation_id());
				renderRequest.setAttribute("simulation", simulation);
				// If empty go to form first scenario
				if(scenarioListSize == 0)
					throw new EmptySimulation();
				// List of Scenario
				List<Scenario> scenarioList = ScenarioLocalServiceUtil.findBySimulationId(simulation.getSimulation_id());

				// map <scenario, scenarioInfo>
				Map<Scenario, Number[]> scenariosMap = new HashMap<Scenario, Number[]>();
				for (Scenario scenario : scenarioList) {
					Number[] info = new Number[3];
					info[2] = scenarioState(scenario);
					info[0] = RequestLocalServiceUtil.countByScenarioIdAndUsedAndIsNotPortlet(scenario.getScenario_id());
					info[1] = RequestLocalServiceUtil.countByScenarioIdAndIsNotPortlet(scenario.getScenario_id());
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
			} catch (PortalException e) {
				throw new RuntimeException("error with get scenario list with localServiceUtil " + e.getMessage());
			} catch (EmptySimulation e) {
				LOG.info("Empty simulation ... redirect");
				page = jspFormFirstScenario;
			}
			// List of Sites
			List<Group> listGroups = GatlingUtil.getListOfSites();
			renderRequest.setAttribute("listGroup", listGroups);
		} else if (page.equals(jspEditScenario)) {
			/*
			 * 
			 * 
			 * ===== Edit scenario -> request list send to jsp page
			 * 
			 * 
			 */
			LOG.debug("DoView : Edit Scenario");
			if (ParamUtil.getLong(renderRequest, "scenarioId") == 0) {
				throw new NullPointerException("scenario id is null");
			}
			try {
				// get scenario
				Scenario scenario = ScenarioLocalServiceUtil.getScenario(ParamUtil.getLong(renderRequest, "scenarioId"));
				Simulation simulation = SimulationLocalServiceUtil.getSimulation(scenario.getSimulation_id());

				//update friendlyUrl of site if changed
				String oldFriendlyURL = scenario.getUrl_site();
				final ThemeDisplay themeDisplay =	(ThemeDisplay)renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
				String currentFriendlyURL = GroupLocalServiceUtil.fetchGroup(scenario.getGroup_id()).getIconURL(themeDisplay);
				StringBuilder sb = new StringBuilder(currentFriendlyURL.split("/")[0]);
				sb.append("//").append(currentFriendlyURL.split("/")[2]).append("/web").append(GroupLocalServiceUtil.fetchGroup(scenario.getGroup_id()).getFriendlyURL());
				currentFriendlyURL = sb.toString();

				if (! oldFriendlyURL.equals(currentFriendlyURL)) {
					//update site url 
					scenario.setUrl_site(currentFriendlyURL);
					ScenarioLocalServiceUtil.updateScenario(scenario);
				}

				//get public layout list
				long groupId = scenario.getGroup_id();
				List<Layout> listPublicLayouts = LayoutLocalServiceUtil.getLayouts(groupId, false, 0);

				//get private layout list
				List<Layout> listPrivateLayouts = LayoutLocalServiceUtil.getLayouts(groupId, true, 0);

				//get site name
				String siteName = GroupLocalServiceUtil.getGroup(groupId).getDescriptiveName();

				//create DisplayLayoutList with actuel layout of the site and old layout added from requests
				List<RequestDTO> displayItemList = new ArrayList<RequestDTO>();
				DisplayItemDTOUtil.addLayoutToDisplayItemList(displayItemList, listPublicLayouts);
				DisplayItemDTOUtil.addLayoutToDisplayItemList(displayItemList, listPrivateLayouts );

				//get list of request to add the old page to DisplayLayout
				List<Request> listRequests = RequestLocalServiceUtil.findByScenarioId(ParamUtil.get(renderRequest, "scenarioId", 0));
				//Merge Layout and Request in DisplayLayout List
				displayItemList = DisplayItemDTOUtil.addRequestToDisplayItemList(displayItemList, listRequests);

				// Get list of used names
				List<Scenario> scenariolist = ScenarioLocalServiceUtil.getScenarios(0, ScenarioLocalServiceUtil.getScenariosCount());
				String JSListName = GatlingUtil.createJSListOfScenarioName(scenariolist);

				//add private and public url of site
				String publicURL = scenario.getUrl_site();
				String privateURL = scenario.getUrl_site().replace("web", "group");
				/*
				 * create header list
				 */
				String[] headerList = new String[] {simulation.getName(), scenario.getName(), siteName};
				renderRequest.setAttribute("headerList", headerList);
				//add request parameters
				renderRequest.setAttribute("scenario", scenario);
				renderRequest.setAttribute("listPages", displayItemList);
				renderRequest.setAttribute("siteName", siteName);
				renderRequest.setAttribute("publicURL", publicURL);
				renderRequest.setAttribute("privateURL", privateURL);
				renderRequest.setAttribute("listOfScenarioName", JSListName);
			} catch (SystemException e) {
				throw new RuntimeException("cannot get layout list: " + e.getMessage());
			} catch (PortalException e) {
				throw new RuntimeException("cannot get layout list: " + e.getMessage());
			} 
			
		} else if (page.equals(jspEditPortlet)) {
			/*
			 * 
			 * 
			 * ===== PORTLET POPUP
			 * 
			 * 
			 */
			if (ParamUtil.getString(renderRequest, "pagePortletId") == null) {
				throw new NullPointerException("portlet id is null");
			}	
			//DTO BUILDER
			PortletConfigDTOBuilder builder = new PortletConfigDTO.PortletConfigDTOBuilder();
			
			String portletId = ParamUtil.getString(renderRequest, "pagePortletId");
			String portletName = PortletLocalServiceUtil.getPortletById(portletId).getDisplayName();
			long  groupId =  ParamUtil.getLong(renderRequest, "groupId");
			long  plId =  ParamUtil.getLong(renderRequest, "plId");
			long  requestId =  ParamUtil.getLong(renderRequest, "requestId");
			long lineId = ParamUtil.getLong(renderRequest, "lineId");
			// Add to DTO
			builder.portletId(portletId).portletName(portletName).groupId(groupId).plId(plId).requestId(requestId).lineId(lineId);

			List<LinkUsecaseRequestDTO> arrayLinkUsecaseRequest = null;
			String listRecordsName = null;
			String[][] availableScript = null;
			
			List<Record> recordList = new ArrayList<Record>();
			//get record and Sample list in db if exists
			try {
				availableScript =  ListScript.getList(portletId);
				arrayLinkUsecaseRequest = GatlingUtil.fillArrayLinkUseCases(requestId);
				
			} catch (SystemException e) {
				if(LOG.isErrorEnabled()){
					LOG.error("error when search for Record list: "+e.getMessage());
				}
			} catch (PortalException e) {
				if(LOG.isErrorEnabled()){
					LOG.error("error when search for Record list: "+e.getMessage());
				}
			}
			try {
				recordList = RecordLocalServiceUtil.findByPortletId(portletId);
				listRecordsName = GatlingUtil.createJSListOfRecordName(recordList);
			} catch (SystemException e) {
				if(LOG.isErrorEnabled()){
					LOG.error("error findByPortletId : "+e.getMessage());
				}
			} 
			
			// Add to DTO
			builder.availableScript(availableScript).linkDTO(arrayLinkUsecaseRequest).listRecordNameJS(listRecordsName);
			LOG.info("records list size= "+recordList.size());
			
			
			renderRequest.setAttribute("availableScript", availableScript);
			renderRequest.setAttribute("portletId", portletId);
			renderRequest.setAttribute("portletName", portletName);
			renderRequest.setAttribute("groupId", groupId);
			renderRequest.setAttribute("plId", plId);
			renderRequest.setAttribute("requestId", requestId);
			renderRequest.setAttribute("arrayLinkUsecaseRequest", arrayLinkUsecaseRequest);
			renderRequest.setAttribute("listRecordsName", listRecordsName);
			renderRequest.setAttribute("lineId", ParamUtil.getLong(renderRequest, "lineId"));
			renderRequest.setAttribute("listRecord", recordList);

			// Check state of recording
			String state = renderRequest.getParameter("recordState");
			Cookie myCookie;
			String nameUseCase = ParamUtil.getString(renderRequest, "useCaseRecordName");
			if(state != null) {
				renderRequest.setAttribute("tabs1", "record-usecase");
				if(state.equals("RECORD")) {
					myCookie = new Cookie("GATLING_RECORD_STATE", portletId+",RECORD,"+nameUseCase);
					// Add to DTO
					builder.nextStateRecord("STOP");
				} else {
					myCookie = new Cookie("GATLING_RECORD_STATE", portletId+",STOP,"+nameUseCase);
					// Add to DTO
					builder.nextStateRecord("RECORD");
				}

			} else {
				//Default cookie is stop
				myCookie = new Cookie("GATLING_RECORD_STATE", portletId+",STOP,USECASE");
				// Add to DTO
				builder.nextStateRecord("RECORD");
			}
			CookieKeys.addCookie(PortalUtil.getHttpServletRequest(renderRequest), PortalUtil.getHttpServletResponse(renderResponse), myCookie);
			
			renderRequest.setAttribute("portletGatlingDTO", builder.build());
		}
		
		else if (page.equals(jspEditRecord)) {
			
			//Get the list of UrlRecord that coresponds to the recordId, if requested
			long  recordId = ParamUtil.getLong(renderRequest, "recordId");
			List<UrlRecord> listRecordUrl = new ArrayList<UrlRecord>();
			
			if(recordId != 0){
				try {
					listRecordUrl = UrlRecordLocalServiceUtil.findByRecordId(recordId);
				} catch (SystemException e) {
					if(LOG.isErrorEnabled()){
						LOG.error("error when search for UrlRecord list: "+e.getMessage());
					}
				}
			}
			
			renderRequest.setAttribute("listRecordUrl", listRecordUrl);
			
		}
		/* redirect to jsp page */
		include(page, renderRequest, renderResponse);
	}

	/**
	 * 
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
			throw new RuntimeException("cannot add user preferences for gatling version " + e.getMessage());
		} catch (ValidatorException e) {
			throw new RuntimeException("cannot add user preferences for gatling version " + e.getMessage());
		} catch (IOException e) {
			throw new RuntimeException("cannot add user preferences for gatling version " + e.getMessage());
		} 
		//scripting Gatling
		String template;
		switch (gatlingVersion) {
		case 1:
			template = "resources/templateGatling1.5.mustache";
			break;
		case 2:
			template = "resources/templateGatling2.0.M3a.mustache";
			break;
		case 3:
		default:
			template = "resources/templateGatling2.0.RC2.mustache";
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
				throw new RuntimeException("cannot export zip for scenario(s) " + e.getMessage());
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
				throw new RuntimeException("cannot export script file " + e.getMessage());
			}
		} else {
			//if no one valide simulation id received then error
			throw new NullPointerException("nothing to export");
		}
		response.addProperty(HttpHeaders.CACHE_CONTROL, "max-age=3600, must-revalidate");
	}

}