package com.excilys.liferay.gatling;

import com.excilys.liferay.gatling.model.Request;
import com.excilys.liferay.gatling.model.Scenario;
import com.excilys.liferay.gatling.model.Simulation;
import com.excilys.liferay.gatling.service.RequestLocalServiceUtil;
import com.excilys.liferay.gatling.service.ScenarioLocalServiceUtil;
import com.excilys.liferay.gatling.service.SimulationLocalServiceUtil;
import com.excilys.liferay.gatling.util.DisplayLayout;
import com.excilys.liferay.gatling.util.DisplayLayoutUtil;
import com.excilys.liferay.gatling.util.GatlingUtil;
import com.excilys.liferay.gatling.util.IdDisplayLayout;
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
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

/**
 * Portlet implementation class GatlingPortlet
 */
public class GatlingPortlet extends MVCPortlet {


	private static Log log = LogFactoryUtil.getLog(GatlingPortlet.class);


	protected String jspListSimulation, jspEditSimulation, jspEditScenario, jspFormFirstScenario, jspHelp;


	/**
	 * récupérer les noms de toutes les pages
	 */
	@Override
	public void init() throws PortletException {
		jspListSimulation = getInitParameter("list-simulation-jsp");
		jspEditSimulation = getInitParameter("edit-simulation-jsp");
		jspEditScenario = getInitParameter("edit-scenario-jsp");
		jspFormFirstScenario = getInitParameter("form-first-scenario-jsp");
		jspHelp = getInitParameter("help-jsp");

		//création du role Gatling
		GatlingUtil.createRole();
		super.init();
	}


	/*
	 * ==== Simulation ====
	 */
	/**
	 * Adds a new Simulation to the database.
	 * 
	 */
	public void addSimulation(ActionRequest request, ActionResponse response)
			throws Exception {
		// Add Simulation 
		Simulation simulation = SimulationLocalServiceUtil.addSimulationFromRequest(request, response);
		// If simulation is add (!= null)
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
			log.info("Simulation fails to add");
			response.setRenderParameter("page", jspListSimulation);
		}

	}

	public void removeSimulation(ActionRequest request, ActionResponse response)
			throws Exception {
		long simulationId = ParamUtil.getLong(request, "simulationId");
		log.info("remove Simulation with id : "+ simulationId);
		// Etape 1
		// -> Suppression des tables
		SimulationLocalServiceUtil.removeSimulationCascade(simulationId);
		response.setRenderParameter("page", jspListSimulation);
	}	

	/*
	 * ==== Scenario ====
	 */
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
		log.info("edit scenario controler");
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
		//Pour le retour
		long simulationId = ParamUtil.getLong(request, "simulationId");
		log.info("remove Scenario with id : "+ scenarioId);
		// Etape 1
		// -> Suppression des tables
		ScenarioLocalServiceUtil.removeByIdCascade(scenarioId);
		response.setRenderParameter("simulationId", Long.toString(simulationId));
		response.setRenderParameter("page", jspEditSimulation); 
	}

	/*
	 * ==== Request ====
	 */
	/**
	 *  Remove request from database
	 * @param request
	 * @param response
	 */
	public void removeRequest(ActionRequest request, ActionResponse response){
		long requestId = (long) Double.parseDouble(request.getParameter("requestId"));
		try {
			RequestLocalServiceUtil.deleteRequest(requestId);
			log.info("request deleted succefully ");
		} catch (PortalException | SystemException e) {
			log.info("fail to delete request: "+e.getMessage());
		}


	}

	/**
	 * ici en fonction de la page demandée, on effectue différentes actions pour envoyer <br/>
	 * les informations nécessaire à la construction de la page
	 */
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		/* récupération de la value page */
		/* récupération du chemin de la prochaine jsp ou par défaut jspListSimulation */
		String page = ParamUtil.get(renderRequest, "page", jspListSimulation); 

		if(page.equals(jspListSimulation)) {
			/*
			 * Page d'acceuil, liste des simulations
			 */
			log.info("DoView : List Simulation");
			List<Simulation> list = new ArrayList<Simulation>();
			try {
				list = SimulationLocalServiceUtil.getSimulations(0, SimulationLocalServiceUtil.getSimulationsCount());
			} catch (SystemException e) {
				e.printStackTrace();
			}
			renderRequest.setAttribute("listSimulation", list);
		} else if(page.equals(jspEditSimulation) || page.equals(jspFormFirstScenario)) {
			/*
			 * Edition d'une simulation, liste des scénarios
			 */
			log.info("DoView : Edit Simulation");
			Long id = (Long) ParamUtil.getLong(renderRequest, "simulationId");

			Simulation simulation;
			try {
				simulation = SimulationLocalServiceUtil.getSimulation(id);
				renderRequest.setAttribute("simulation", simulation);
				// List of Scénarios
				List<Scenario> ls = ScenarioLocalServiceUtil.findBySimulationId(simulation.getSimulation_id());

				//map <scenario, number of requests>
				Map<Scenario, Number[]> scenariosMap = new HashMap<Scenario, Number[]>();
				for(Scenario scena : ls){
					List<Request> lsR = RequestLocalServiceUtil.findByScenarioId(scena.getScenario_id());
					Number[] info = new Number[4];
					int count=0;
					int count2 =0;
					for(Request r : lsR){
						count2 ++;
						if(r.isChecked())
							count ++;
					}
					info[0] = count;
					info[1] = count2;
					info[2] = scena.getDuration();
					info[3] = scena.getUsers_per_seconds();
					scenariosMap.put(scena, info);
				}

				renderRequest.setAttribute("listScenario", ls);	
				renderRequest.setAttribute("MapScenario", scenariosMap);	
			} catch (PortalException | SystemException e1) {
				e1.printStackTrace();
			}

			// List of Sites
			List<Group> liGroups = GatlingUtil.getListOfSites();
			renderRequest.setAttribute("listGroup", liGroups);
		}
		else if(page.equals(jspEditScenario)){
			/*
			 * Edition d'un scénario -> liste des requêtes
			 */
			log.info("DoView : Edit Scenario");
			try {
				//récupération du scénario
				Scenario scenario = ScenarioLocalServiceUtil.getScenario(ParamUtil.getLong(renderRequest, "scenarioId"));

				//on récupère la liste des layout
				long groupId = scenario.getGroup_id();
				List<Layout> listLayouts = LayoutLocalServiceUtil.getLayouts(groupId,false,0);
				String siteName = GroupLocalServiceUtil.getGroup(groupId).getName();
				// Puis les privates
				List<Layout> listLayoutsPrivate = LayoutLocalServiceUtil.getLayouts(groupId, true, 0);

				List<DisplayLayout> displayLayoutList = new ArrayList<DisplayLayout>();
				//On va trier les layout dans l'ordre de parent
				DisplayLayoutUtil.addLayoutToDisplayLayoutList(displayLayoutList, listLayouts);
				DisplayLayoutUtil.addLayoutToDisplayLayoutList(displayLayoutList, listLayoutsPrivate);
				// Get Hierachy (use to add a button if a row is a parent
				Map<IdDisplayLayout, List<IdDisplayLayout>> hierachy = new LinkedHashMap<IdDisplayLayout, List<IdDisplayLayout>>();
				DisplayLayoutUtil.mapHierachy(displayLayoutList, hierachy);

				//On recupère la liste des requêtes dans la base
				List<Request> listRequests = RequestLocalServiceUtil.findByScenarioId(ParamUtil.get(renderRequest, "scenarioId",0));
				//Merge Layout and Request in DisplayLayout List
				displayLayoutList = DisplayLayoutUtil.addRequestToDisplayLayoutList(displayLayoutList, listRequests);


				//navigation form: declaration of the variables
				String[] categoryNames = {"scenario-edit"};
				String[] category1 = {"scenario", "details"};

				// Number of categorySections should equal number of categories
				String[][] categorySections = {category1};

				renderRequest.setAttribute("categoryNames", categoryNames);
				renderRequest.setAttribute("categorySections", categorySections);


				//ajout des paramètres dans la requête
				renderRequest.setAttribute("scenario", scenario);
				renderRequest.setAttribute("listPages", displayLayoutList);
				renderRequest.setAttribute("hierachy", hierachy);
				renderRequest.setAttribute("siteName", siteName);
			} catch (SystemException e) {
				log.info("pbm avec récupération des layout "+e.getMessage());
			} catch (PortalException e) {
				log.info("pbm avec récupération des layout "+e.getMessage());
			} 
		}

		/* on redirige sur la jsp de page */
		include(page, renderRequest, renderResponse);	
	}


	private String generateSimulation(Long simulationId)
			throws Exception { 
		Date date =new Date();
		//		File simulationFile = new File("/home/pif/Documents/SimulationsGatling/Simulation"  + SimulationLocalServiceUtil.getSimulation(simulationId).getName()  + date.getTime() + ".scala");
		//		simulationFile.createNewFile();
		StringBuilder sb = new StringBuilder();
		ScriptGenerator.generateImports(sb);
		sb.append("\nclass Simulation" + SimulationLocalServiceUtil.getSimulation(simulationId).getName() + " extends Simulation {\n");
		ScriptGenerator.generateClass(sb, simulationId);
		sb.append("\n}");
		//		simulationFile.setWritable(true);
		//		
		//		FileWriter fw = new FileWriter(simulationFile);
		//		BufferedWriter bw = new BufferedWriter(fw);
		//		bw.write(sb.toString());
		//		bw.close();
		return sb.toString();
	}


	@Override 
	public void serveResource(ResourceRequest request, ResourceResponse response) {

		Long simulationId = ParamUtil.getLong(request, "simulationId");
		log.info("serveResource : " + simulationId);
		Simulation simu;
		try {
			simu = SimulationLocalServiceUtil.getSimulation(simulationId);
			if(simulationId!=null && simu!=null){
				response.setContentType("application/x-wais-source");
				response.addProperty(HttpHeaders.CACHE_CONTROL, "max-age=3600, must-revalidate");

				byte[] fileByte;
				Date date =new Date();
				try {
					response.addProperty("Content-Disposition", "attachment; filename=Simulation"  + SimulationLocalServiceUtil.getSimulation(simulationId).getName()  + date.getTime() + ".scala");
				} catch (PortalException e1) {	e1.printStackTrace();} catch (SystemException e1) {	e1.printStackTrace();}

				try {
					fileByte = ScriptGenerator.generateSimulation2(simulationId).getBytes();
					OutputStream out = response.getPortletOutputStream();
					out.write(fileByte);
					out.flush();
					out.close();
				} catch (Exception e) {	e.printStackTrace();}
			}
		} catch (PortalException e2) {	e2.printStackTrace();} catch (SystemException e2) {	e2.printStackTrace();}
	}

}