package com.excilys.liferay.gatling;

import com.excilys.liferay.gatling.model.Request;
import com.excilys.liferay.gatling.model.Scenario;
import com.excilys.liferay.gatling.model.Simulation;
import com.excilys.liferay.gatling.mustache.ScriptGeneratorGatling;
import com.excilys.liferay.gatling.mustache.ScriptGeneratorGatling1_5;
import com.excilys.liferay.gatling.mustache.ScriptGeneratorGatling2;
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
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

/**
 * Portlet implementation class GatlingPortlet
 */
public class GatlingPortlet extends MVCPortlet {


	MustacheFactory mf = new DefaultMustacheFactory();

	private static Log log = LogFactoryUtil.getLog(GatlingPortlet.class);

	/**
	 * pages of portlet
	 */
	protected String jspListSimulation, jspEditSimulation, jspEditScenario, jspFormFirstScenario, jspHelp;


	/**
	 * get all name page and create the role 'gatling' on init portlet
	 */
	@Override
	public void init() throws PortletException {
		jspListSimulation = getInitParameter("list-simulation-jsp");
		jspEditSimulation = getInitParameter("edit-simulation-jsp");
		jspEditScenario = getInitParameter("edit-scenario-jsp");
		jspFormFirstScenario = getInitParameter("form-first-scenario-jsp");
		jspHelp = getInitParameter("help-jsp");

//		//create the role Gatling		
//		long companyId = PortalUtil.getDefaultCompanyId();
//		long userId = 10437;
//		GatlingUtil.createRole(companyId,userId);
		super.init();
	}

	/**
	 * Adds a new Simulation to the database.
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public void addSimulation(ActionRequest request, ActionResponse response)
			throws Exception {
		Simulation simulation = SimulationLocalServiceUtil.addSimulationFromRequest(request, response);

		if(simulation != null) {
			List<Scenario> list = ScenarioLocalServiceUtil.findBySimulationId(simulation.getSimulation_id());
			response.setRenderParameter("simulationId", Long.toString(simulation.getSimulation_id()));
			// If new, add First scenario
			if(list.isEmpty()) {
				response.setRenderParameter("page", jspFormFirstScenario);
			}
			else {
				response.setRenderParameter("page", jspEditSimulation);
			}
		}
		else {
			if(log.isDebugEnabled()) {
				log.debug("Simulation fails to add");
			}
			response.setRenderParameter("page", jspListSimulation);
		}

	}

	/**
	 * edit simulation method
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public void editSimulation(ActionRequest request, ActionResponse response) throws Exception {
		long simulationId = ParamUtil.getLong(request, "simulationId");
		log.info("edit Simulation with id : "+ simulationId);
		Simulation simulation = SimulationLocalServiceUtil.getSimulation(simulationId);
		simulation.setName(ParamUtil.getString(request,"simulationName"));
		String variable = GatlingUtil.createVariableName("Simulation", ParamUtil.getString(request, "variableSimulationName"));
		simulation.setVariableName(variable);
		SimulationLocalServiceUtil.updateSimulation(simulation);
		response.setRenderParameter("simulationId", Long.toString(simulationId));
		response.setRenderParameter("page", jspEditSimulation);
	}

	/**
	 * remove simulation method
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public void removeSimulation(ActionRequest request, ActionResponse response) throws Exception {
		long simulationId = ParamUtil.getLong(request, "simulationId");
		if(log.isDebugEnabled()) {
			log.debug("remove Simulation with id : "+ simulationId);
		}

		SimulationLocalServiceUtil.removeSimulationCascade(simulationId);
		response.setRenderParameter("page", jspListSimulation);
	}	


	/**
	 * Add the First Scenario to the database
	 * 
	 */
	public void addFirstScenario(ActionRequest request, ActionResponse response) throws Exception {
		Scenario scenario = ScenarioLocalServiceUtil.addScenarioFromRequest(request,response);
		// Test if add success
		if(scenario != null) {
			// redirect to editScenario
			response.setRenderParameter("scenarioId", Long.toString(scenario.getScenario_id()));
			response.setRenderParameter("page", jspEditScenario);
		}
		else {
			// redirect to form first scénario
			response.setRenderParameter("simulationId", Long.toString(ParamUtil.getLong(request, "simulationId")));
			response.setRenderParameter("page", jspFormFirstScenario);
		}
	}
	/**
	 * Add a new Scenario to the database
	 * 
	 */
	public void addScenario(ActionRequest request, ActionResponse response) throws Exception {
		Scenario scenario = ScenarioLocalServiceUtil.addScenarioFromRequest(request,response);
		if(scenario != null) {
			// redirect to editScenario
			response.setRenderParameter("scenarioId", Long.toString(scenario.getScenario_id()));
			response.setRenderParameter("page", jspEditScenario);
		} else {
			response.setRenderParameter("simulationId", Long.toString(ParamUtil.getLong(request, "simulationId")));
			response.setRenderParameter("page", jspEditSimulation); 
		}
	}


	/**
	 * edit scenario
	 * @param request
	 * @param response
	 * @throws SystemException 
	 * @throws PortalException 
	 * @throws Exception
	 */
	public void editScenario(ActionRequest request, ActionResponse response) throws SystemException, PortalException {
		if(log.isDebugEnabled()) log.debug("edit scenario controler");
		Scenario scenario = ScenarioLocalServiceUtil.editScenarioFromRequest(request, response);
		if(scenario != null) {
			response.setRenderParameter("simulationId", Long.toString(scenario.getSimulation_id()));
			response.setRenderParameter("page", jspEditSimulation);
		}
		else {
			response.setRenderParameter("page", jspListSimulation);
		}
	}

	/**
	 * Remove scenario from database
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public void removeScenario(ActionRequest request, ActionResponse response)
			throws Exception {
		long scenarioId = ParamUtil.getLong(request, "scenarioId");
		long simulationId = ParamUtil.getLong(request, "simulationId");
		if(log.isDebugEnabled()) log.debug("remove Scenario with id : "+ scenarioId);
		// cascade delete
		ScenarioLocalServiceUtil.removeByIdCascade(scenarioId);
		response.setRenderParameter("simulationId", Long.toString(simulationId));
		response.setRenderParameter("page", jspEditSimulation); 
	}


	/**
	 *  Remove request from database
	 * @param request
	 * @param response
	 */
	public void removeRequest(ActionRequest request, ActionResponse response){
		long requestId = (long) Double.parseDouble(request.getParameter("requestId"));
		try {
			RequestLocalServiceUtil.deleteRequest(requestId);
			if(log.isDebugEnabled()) log.debug("request deleted succefully ");
		} catch (PortalException e) {
			if(log.isDebugEnabled()) log.debug("fail to delete request: "+e.getMessage());
		}catch (SystemException  e) {
			if(log.isDebugEnabled()) log.debug("fail to delete request: "+e.getMessage());
		}


	}

	/**
	 * get the scenario state, if completed or not yet
	 * @param scenario
	 * @return
	 */
	private int scenarioState(Scenario scenario) {
		List<Request> lsR;
		try {
			lsR = RequestLocalServiceUtil.findByScenarioId(scenario.getScenario_id());
			int count=0;
			for(Request r : lsR){
				if(r.isUsed())
					count ++;
			}
			//completed scenario = case if all minimal information are completed 
			if((count != 0) && (scenario.getDuration() != 0) && (scenario.getUsers_per_seconds()!=0)){
				return 2;
			}
			//incomplete scenario = case if one or more information detail of scenario are not completed but there is request selected
			else if((count != 0) && ((scenario.getDuration() == 0) || (scenario.getUsers_per_seconds()==0))){
				return 1;
			}
			//case if not request selected to that scenario = empty scenario
			else if((count == 0)){
				return 0;
			}
			return 0;	
		} catch (SystemException e) {
			log.error("enable to determine Scenario state "+e.getMessage());
			return 0;	
		}

	}

	/**
	 * get the simulation state, if all scenario are completed or not yet
	 * @param simulation
	 * @return
	 */
	public int simulationState(Simulation simulation){
		try {
			List<Scenario> scenariosList = ScenarioLocalServiceUtil.findBySimulationId(simulation.getSimulation_id());
			int checkNumberCompleted=0;
			for(Scenario scenario : scenariosList){
				if(scenarioState(scenario) ==2){
					checkNumberCompleted++;
				}
			}
			
			//if no one scenario is completed = simulation empty
			if((checkNumberCompleted == 0) || (scenariosList.size() ==0)){
				return 0;
			}
			//if all scenario completed = simulation complited
			else if(checkNumberCompleted == scenariosList.size()){
				return 2;
			}
			//other case = simulation incompleted
			else{
				return 1;
			}
		} catch (SystemException e) {
			log.error("enable to determine Simulation state "+e.getMessage());
			return 0;
		}
	}
	/**
	 * View method : redirect to requested page and send necessary parameters
	 */

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		/* get the path  for next jsp or by  default jspListSimulation */
		String page = ParamUtil.get(renderRequest, "page", jspListSimulation); 

		//view.jsp => list of the simulations
		if(page.equals(jspListSimulation)) {
			if(log.isDebugEnabled()) log.debug("DoView : List Simulation");
			List<Simulation> list = new ArrayList<Simulation>();
			Map<Simulation, Integer[]> listSimulation = new HashMap<Simulation,Integer[]>();
			try {
				list = SimulationLocalServiceUtil.getSimulations(0, SimulationLocalServiceUtil.getSimulationsCount());
				for(Simulation s : list){
					Integer[] res = new Integer[2];
					List<Scenario> ls = ScenarioLocalServiceUtil.findBySimulationId(s.getSimulation_id());
					res[0] = ls.size();
					res[1] = simulationState(s);
					listSimulation.put(s, res );
				}
			} catch (SystemException e) {
				e.printStackTrace();
			}
			String JSListName = GatlingUtil.createJSListOfSimulationName(list);
			renderRequest.setAttribute("listOfSimulationName", JSListName);
			renderRequest.setAttribute("listSimulation", list);
			renderRequest.setAttribute("MapSimulation", listSimulation);
		} else if(page.equals(jspEditSimulation) || page.equals(jspFormFirstScenario)) {
			/*
			 * Edit simulation, get and send scenarios list to jsp page
			 */
			if(log.isDebugEnabled()) log.debug("DoView : Edit Simulation");
			Long id = (Long) ParamUtil.getLong(renderRequest, "simulationId");

			Simulation simulation;
			try {
				simulation = SimulationLocalServiceUtil.getSimulation(id);
				renderRequest.setAttribute("simulation", simulation);
				// List of Scenario
				List<Scenario> scenarioList = ScenarioLocalServiceUtil.findBySimulationId(simulation.getSimulation_id());

				//map <scenario, scenarioInfo>
				Map<Scenario, Number[]> scenariosMap = new HashMap<Scenario, Number[]>();
				for(Scenario scenario : scenarioList){

					List<Request> lsR = RequestLocalServiceUtil.findByScenarioId(scenario.getScenario_id());
					Number[] info = new Number[3];
					int numberRequestAdded=0;
					int numberRequest =0;
					for(Request r : lsR){
						numberRequest ++;
						if(r.isUsed())
							numberRequestAdded ++;
					}

					info[2] = scenarioState(scenario);
					info[0] = numberRequestAdded;
					info[1] = numberRequest;
					scenariosMap.put(scenario, info);
				}
				String JSListName = GatlingUtil.createJSListOfScenarioName(scenarioList);
				renderRequest.setAttribute("listOfScenarioName", JSListName);
				/*
				 * get list of simulation (for edit name)
				 */
				List<Simulation> listSimulations = SimulationLocalServiceUtil.getSimulations(0, SimulationLocalServiceUtil.getSimulationsCount());
				String JSListSimName = GatlingUtil.createJSListOfSimulationName(listSimulations);
				renderRequest.setAttribute("listOfSimulationName", JSListSimName);

				renderRequest.setAttribute("listScenario", scenarioList);	
				renderRequest.setAttribute("MapScenario", scenariosMap);	
			} catch (PortalException  e1) {
				e1.printStackTrace();
			} catch (SystemException  e1) {
				e1.printStackTrace();
			}

			// List of Sites
			List<Group> listGroups = GatlingUtil.getListOfSites();
			renderRequest.setAttribute("listGroup", listGroups);
		}
		else if(page.equals(jspEditScenario)){
			/*
			 * Edit scenario -> request list send to jsp page
			 */
			if(log.isDebugEnabled()) log.debug("DoView : Edit Scenario");
			try {
				//get scenario
				Scenario scenario = ScenarioLocalServiceUtil.getScenario(ParamUtil.getLong(renderRequest, "scenarioId"));

				//get layout list
				long groupId = scenario.getGroup_id();
				List<Layout> listLayouts = LayoutLocalServiceUtil.getLayouts(groupId,false,0);
				String siteName = GroupLocalServiceUtil.getGroup(groupId).getName();
				// and private layouts
				List<Layout> listLayoutsPrivate = LayoutLocalServiceUtil.getLayouts(groupId, true, 0);

				List<DisplayLayout> displayLayoutList = new ArrayList<DisplayLayout>();
				DisplayLayoutUtil.addLayoutToDisplayLayoutList(displayLayoutList, listLayouts);
				DisplayLayoutUtil.addLayoutToDisplayLayoutList(displayLayoutList, listLayoutsPrivate);
				// Get Hierachy (use to add a button if a row is a parent
				Map<IdDisplayLayout, List<IdDisplayLayout>> hierachy = new LinkedHashMap<IdDisplayLayout, List<IdDisplayLayout>>();
				DisplayLayoutUtil.mapHierachy(displayLayoutList, hierachy);

				List<Request> listRequests = RequestLocalServiceUtil.findByScenarioId(ParamUtil.get(renderRequest, "scenarioId",0));
				//Merge Layout and Request in DisplayLayout List
				displayLayoutList = DisplayLayoutUtil.addRequestToDisplayLayoutList(displayLayoutList, listRequests);

				// Get list of used names
				List<Scenario> listScenario = ScenarioLocalServiceUtil.getScenarios(0, ScenarioLocalServiceUtil.getScenariosCount());
				String JSListName = GatlingUtil.createJSListOfScenarioName(listScenario);
				renderRequest.setAttribute("listOfScenarioName", JSListName);
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

			} catch (SystemException e) {
				if(log.isDebugEnabled()) {
					log.debug("connot get layout list: "+e.getMessage());
				}
			} catch (PortalException e) {
				if(log.isDebugEnabled()) {
					log.debug("connot get layout list: "+e.getMessage());
				}
			} 
		}

		/* redirect to jsp page */
		include(page, renderRequest, renderResponse);	
	}

	/**
	 * 
	 */
	@Override 
	public void serveResource(ResourceRequest request, ResourceResponse response) {
		/*
		 * Get template from version
		 */
		int gatlingVersion = ParamUtil.getInteger(request, "gatlingVersion");
		String template;
		ScriptGeneratorGatling sgg;
		switch (gatlingVersion) {
		case 1:
			sgg = new ScriptGeneratorGatling1_5();
			template = "resources/templateGatling1.5.mustache";
			break;
		case 2:
			sgg = new ScriptGeneratorGatling2();
			template = "resources/templateGatling2.0.mustache";
			break;
		default:
			sgg = new ScriptGeneratorGatling2();
			template = "resources/templateGatling2.0.mustache";
			break;
		}
		/*
		 * Get simulations ids
		 */
		long[] simulationsIds = ParamUtil.getLongValues(request, "export");
		Simulation simulation;
		if(simulationsIds.length > 1) {
			response.setContentType("application/zip");
			response.addProperty(HttpHeaders.CACHE_CONTROL, "max-age=3600, must-revalidate");
			response.addProperty("Content-Disposition", "attachment; filename = multiSimulations.zip");

			try {					
				ZipOutputStream zipOutputStream = new ZipOutputStream(response.getPortletOutputStream());
				for (long id : simulationsIds) {
					if(id  > 0) {
						simulation = SimulationLocalServiceUtil.getSimulation(id);
						Date date =new Date();
						zipOutputStream.putNextEntry(new ZipEntry("Simulation"  + simulation.getName()  + date.getTime() + ".scala"));
						Mustache mustache = mf.compile(template);           
						sgg.setId(simulationsIds[0]);
						mustache.execute(new PrintWriter(zipOutputStream), sgg).flush();
						zipOutputStream.closeEntry();
					}
				}
				zipOutputStream.close();
			}
			catch (Exception e2) {
				e2.printStackTrace();
			} 

		} else if(simulationsIds.length == 1 && simulationsIds[0] > 0) {	
			response.setContentType("application/x-wais-source");
			response.addProperty(HttpHeaders.CACHE_CONTROL, "max-age=3600, must-revalidate");

			Date date =new Date();
			try {
				simulation = SimulationLocalServiceUtil.getSimulation(simulationsIds[0]);
				response.addProperty("Content-Disposition", "attachment; filename=Simulation"  + simulation.getName()  + date.getTime() + ".scala");
				Mustache mustache = mf.compile(template);
				OutputStream out = response.getPortletOutputStream();            
				sgg.setId(simulationsIds[0]);
				mustache.execute(new PrintWriter(out), sgg).flush();
				out.close();
			} catch (Exception e) { 
				e.printStackTrace();
			}
		} else {
			PortletURL render = response.createRenderURL();
			//render.setParameter("page", jspListSimulation);
			response.addProperty("Location", render.toString());
		}
	}
}