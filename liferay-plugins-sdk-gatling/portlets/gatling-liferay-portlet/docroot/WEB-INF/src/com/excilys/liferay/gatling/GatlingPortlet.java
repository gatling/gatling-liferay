package com.excilys.liferay.gatling;

import com.excilys.liferay.gatling.util.DisplayLayout;
import com.excilys.liferay.gatling.util.DisplayLayoutUtil;
import com.excilys.liferay.gatling.util.IdDisplayLayout;
import com.excilys.liferay.gatling.validator.RequestValidator;
import com.excilys.liferay.gatling.validator.ScenarioValidator;
import com.excilys.liferay.gatling.validator.SimulationValidator;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.HttpHeaders;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.Layout;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.sample.model.Request;
import com.liferay.sample.model.Scenario;
import com.liferay.sample.model.Simulation;
import com.liferay.sample.service.RequestLocalServiceUtil;
import com.liferay.sample.service.ScenarioLocalServiceUtil;
import com.liferay.sample.service.SimulationLocalServiceUtil;
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
		long primaryKey = CounterLocalServiceUtil.increment(Simulation.class.getName());	
		Simulation simulation = SimulationLocalServiceUtil.createSimulation(primaryKey);
		simulation.setName(ParamUtil.getString(request, "simulationName"));
		List<String> errors = new ArrayList<String>();
		if(SimulationValidator.validateSimulation(simulation, errors)) {
			simulation = SimulationLocalServiceUtil.addSimulation(simulation);
			List<Scenario> list = ScenarioLocalServiceUtil.findBySimulationId(simulation.getSimulation_id());
			if(list.isEmpty()) {
				response.setRenderParameter("simulationId", Long.toString(simulation.getSimulation_id()));
				response.setRenderParameter("page", jspFormFirstScenario);
			}
			else {
				response.setRenderParameter("page", jspListSimulation);
			}
		}
		else {
			for(String error : errors) {
				log.info(error);
				SessionErrors.add(request, error);
			}
		}
		
	}
	
	public void editSimulation(ActionRequest request, ActionResponse response) throws Exception{
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
	public void addFirstScenario(ActionRequest request, ActionResponse response)
			throws Exception {
		
		ThemeDisplay themeDisplay =
				(ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
		
		//create scenario
		long primaryKey = CounterLocalServiceUtil.increment(Request.class.getName());
		Scenario scenario = ScenarioLocalServiceUtil.createScenario(primaryKey);
		scenario.setName(ParamUtil.getString(request, "scenarioName"));
		scenario.setSimulation_id(ParamUtil.getLong(request, "simulationId"));
		scenario.setGroup_id(ParamUtil.getLong(request, "sites"));
		//ajout de l'url du site à revoir marche pas pour les private pages
		String urlSite = GroupLocalServiceUtil.fetchGroup(ParamUtil.getLong(request, "sites")).getIconURL(themeDisplay);	
		urlSite = urlSite.split("/")[0]+"//"+urlSite.split("/")[2]+"/web"+GroupLocalServiceUtil.fetchGroup(ParamUtil.getLong(request, "sites")).getFriendlyURL();
		log.info(urlSite);
		scenario.setUrl_site(urlSite);
				
		// Saving ...
		List<String> errors = new ArrayList<String>();
		if(ScenarioValidator.validateScenario(scenario, errors)) {
			scenario = ScenarioLocalServiceUtil.addScenario(scenario);
			log.info("First Scenario Added");
			//add Requests
			List<Layout> listLayouts = new ArrayList<Layout>(LayoutLocalServiceUtil.getLayouts(ParamUtil.getLong(request, "sites"), false));
			List<Layout> listLayoutsPrivate = LayoutLocalServiceUtil.getLayouts(ParamUtil.getLong(request, "sites"), true);
			listLayouts.addAll(listLayoutsPrivate);
			
			for(Layout layout: listLayouts){
				addRequest(layout, 0, scenario.getScenario_id(),false);
			}
			// redirect to editScenario
			response.setRenderParameter("scenarioId", Long.toString(scenario.getScenario_id()));
			response.setRenderParameter("page", jspEditScenario);
		}
		else {
			for(String error : errors) {
				SessionErrors.add(request, error);
			}
			// redirect to form first scénario
			response.setRenderParameter("simulationId", Long.toString(scenario.getSimulation_id()));
			response.setRenderParameter("page", jspFormFirstScenario);
		}
	}
	/**
	 * Add a new Scenario to the database
	 * 
	 */
	public void addScenario(ActionRequest request, ActionResponse response)
			throws Exception {
		
		ThemeDisplay themeDisplay =
				(ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
		
		//create scenario
		long primaryKey = CounterLocalServiceUtil.increment(Request.class.getName());
		Scenario scenario = ScenarioLocalServiceUtil.createScenario(primaryKey);
		scenario.setName(ParamUtil.getString(request, "scenarioName"));
		scenario.setSimulation_id(ParamUtil.getLong(request, "simulationId"));
		scenario.setGroup_id(ParamUtil.getLong(request, "sites"));
		//ajout de l'url du site
		String urlSite = GroupLocalServiceUtil.fetchGroup(ParamUtil.getLong(request, "sites")).getIconURL(themeDisplay);	
		urlSite = urlSite.split("/")[0]+"//"+urlSite.split("/")[2]+"/web"+GroupLocalServiceUtil.fetchGroup(ParamUtil.getLong(request, "sites")).getFriendlyURL();
		log.info(urlSite);
		scenario.setUrl_site(urlSite);
		// Saving ...
		List<String> errors = new ArrayList<String>();
		if(ScenarioValidator.validateScenario(scenario, errors)) {
			scenario = ScenarioLocalServiceUtil.addScenario(scenario);
			//add Requests
			List<Layout> listLayouts = new ArrayList<Layout>(LayoutLocalServiceUtil.getLayouts(ParamUtil.getLong(request, "sites"), false));
			List<Layout> listLayoutsPrivate = LayoutLocalServiceUtil.getLayouts(ParamUtil.getLong(request, "sites"), true);
			listLayouts.addAll(listLayoutsPrivate);
			
			for(Layout layout: listLayouts){
				addRequest(layout, 0, scenario.getScenario_id(),false);
			}
		}
		else {
			for(String error : errors) {
				SessionErrors.add(request, error);
			}
		}
			
		response.setRenderParameter("simulationId", Long.toString(scenario.getSimulation_id()));
		response.setRenderParameter("page", jspEditSimulation); 
	}


	/**
	 * edit scenario
	 * @param request
	 * @param response
	 * @throws SystemException 
	 * @throws Exception
	 */
	public void editScenario(ActionRequest request, ActionResponse response) {
		
		log.info("edit scenario controler");
		Long idScenario = ParamUtil.getLong(request, "scenarioId");
		Map<String, String[]> parameters = request.getParameterMap();
		Map<String, Request> lstRequestToEdit =new HashMap<String, Request>();
		
		if(idScenario !=null){

			long groupId =ParamUtil.getLong(request, "groupId");
			
			try {
				
				List<Layout> listLayouts = LayoutLocalServiceUtil.getLayouts(groupId,false,0);
				String siteName = listLayouts.get(0).getGroup().getName();
				// Puis les privates
				List<Layout> listLayoutsPrivate = LayoutLocalServiceUtil.getLayouts(groupId, true, 0);
				
				List<DisplayLayout> displayLayoutList = new ArrayList<DisplayLayout>();
				//On va trier les layout dans l'ordre de parent
				DisplayLayoutUtil.addLayoutToDisplayLayoutList(displayLayoutList, listLayouts);
				DisplayLayoutUtil.addLayoutToDisplayLayoutList(displayLayoutList, listLayoutsPrivate);
				
				//On recupère la liste des requêtes dans la base
				List<Request> listRequests = RequestLocalServiceUtil.findByScenarioId(idScenario);
				//Merge Layout and Request in DisplayLayout List
				displayLayoutList = DisplayLayoutUtil.addRequestToDisplayLayoutList(displayLayoutList, listRequests);
				
				//on récupère la liste de requête
				for(Request r :RequestLocalServiceUtil.findByScenarioId(ParamUtil.get(request, "scenarioId",0))){
					lstRequestToEdit.put(r.getUrl().trim(),  r);
				}
				
				//on met à jour les données
				for (String key : parameters.keySet()){
					log.info(key+" : "+StringUtil.merge(parameters.get(key)));
					//Cas de case coché
					if((StringUtil.merge(parameters.get(key)).equals("true")) && (!key.contains("Checkbox")) ){
						int layoutId = (int) Double.parseDouble(key);
						double weight  =   Double.parseDouble(StringUtil.merge(parameters.get("weight"+key)));
						DisplayLayout displayLayout = displayLayoutList.get(layoutId);
						String url = displayLayout.getUrl();
						//Si la requête exist déja donc l'éditer
						if(( lstRequestToEdit.containsKey(url.trim()) ) && ((lstRequestToEdit.get(url).getWeight() != weight) || (!lstRequestToEdit.get(url).isChecked()))){
							Request updatedRequest = lstRequestToEdit.get(url);
							updatedRequest.setWeight(weight);
							updatedRequest.setChecked(true);
							// Saving ...
							List<String> errors = new ArrayList<String>();
							if(RequestValidator.validateRequest(updatedRequest, errors)) {
								RequestLocalServiceUtil.updateRequest(updatedRequest);
								log.info("request updated succefully");
							}
							else {
								for(String error : errors) {
									SessionErrors.add(request, error);
								}
							}
						}
						
						// ajout de nouvelles requêtes correspondants aux nouvelles pages
						else if(! lstRequestToEdit.containsKey(url.trim())){
							Layout layout = LayoutLocalServiceUtil.getLayout(groupId, displayLayout.getDisplayLayoutId().isPrivatePage(), displayLayout.getDisplayLayoutId().getLayoutId());

							addRequest(layout, weight, idScenario, true);
							log.info("request created and added succefully ");
						}				
					}
					
					//Cas de suppression de requête dans le scenario --> case pas coché en bd update
					else if((StringUtil.merge(parameters.get(key)).equals("false")) && (!key.contains("Checkbox")) && (!key.contains("/")) ){
						int layoutId = (int) Double.parseDouble(key);
						DisplayLayout displayLayout = displayLayoutList.get(layoutId);

						Layout layout = LayoutLocalServiceUtil.getLayout(groupId, displayLayout.getDisplayLayoutId().isPrivatePage(), displayLayout.getDisplayLayoutId().getLayoutId());
						String url = layout.getFriendlyURL();
							
						if(lstRequestToEdit.containsKey(url.trim())){
							Request requestToDelete = lstRequestToEdit.get(url);
							if(requestToDelete.isChecked()){
								requestToDelete.setChecked(false);
								RequestLocalServiceUtil.updateRequest(requestToDelete);
								log.info("request check apdated successfully ");
							}
						}
					}
					
					//Cas de supression de requêtes qui correspondent aux pages supprimées 
					else if(key.contains("delete") ){
						long requestId =  Long.parseLong(StringUtil.merge(parameters.get(key)));
						RequestLocalServiceUtil.deleteRequest(requestId);
						log.info("request deleted successfully ");
					}
				}
				
				Scenario scenario = ScenarioLocalServiceUtil.getScenario(idScenario);
				response.setRenderParameter("simulationId", Long.toString(scenario.getSimulation_id()));
				response.setRenderParameter("page", jspEditSimulation);
			} catch (SystemException e) {
				log.info("pbm with layout : "+e.getMessage());
			} catch (PortalException e) {
				log.info("pbm with ScenarioLocalServiceUtil.getScenario "+ e.getMessage());
			} 
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
	 * Add a new Request to the database
	 * @param parentLayoutId 
	 * 
	 */


	public void addRequest(Layout layout, double weight, long idScenario, boolean checked) {
		log.info("addRequest contrôleur");
		//create request
		long primaryKey;
		try {
			primaryKey = CounterLocalServiceUtil.increment(Request.class.getName());
			Request newRequest = RequestLocalServiceUtil.createRequest(primaryKey);
			newRequest.setLayoutId(layout.getLayoutId());
			newRequest.setName(layout.getName(LocaleUtil.getDefault()));
			newRequest.setUrl(layout.getFriendlyURL());
			newRequest.setWeight(weight);
			newRequest.setScenario_id(idScenario);
			newRequest.setChecked(checked);
			newRequest.setPrivatePage(layout.isPrivateLayout());
			newRequest.setParentLayoutId(layout.getParentLayoutId());
			// Saving ...
			List<String> errors = new ArrayList<String>();
			if(RequestValidator.validateRequest(newRequest, errors)) {
				newRequest = RequestLocalServiceUtil.addRequest(newRequest);
			}
		} catch (SystemException e) {
			log.info("pbm with addRequestMethod "+e.getMessage());
		}
		
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
		} else if(page.equals(jspHelp)) {
			
			
			
			
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
				Map<Scenario, Integer[]> scenariosMap = new HashMap<Scenario, Integer[]>();
				for(Scenario scena : ls){
					List<Request> lsR = RequestLocalServiceUtil.findByScenarioId(scena.getScenario_id());
					Integer[] info = new Integer[4];
					int count=0;
					int count2 =0;
					for(Request r : lsR){
						count2 ++;
						if(r.isChecked())
							count ++;
					}
					info[0] = count;
					info[1] = count2;
					info[2] = (int) scena.getDuration();
					info[3] = (int) scena.getUsers_per_seconds();
					scenariosMap.put(scena, info);
				}
				
				renderRequest.setAttribute("listScenario", ls);	
				renderRequest.setAttribute("MapScenario", scenariosMap);	
			} catch (PortalException | SystemException e1) {
				e1.printStackTrace();
			}

			// List of Sites
			List<Group> liGroups = getListOfSites();
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
	
	/**
	 * Récupère la liste des sites du portail
	 * @return list des sites
	 */
	private List<Group> getListOfSites()  {
		/*recupere la liste des sites*/			
		DynamicQuery dq = DynamicQueryFactoryUtil.forClass(Group.class)
				.add(PropertyFactoryUtil.forName("type").eq(1)) //1 -> site
				.add(PropertyFactoryUtil.forName("site").eq(true))
				.add(PropertyFactoryUtil.forName("active").eq(true));

		List<Group> listGroups = new ArrayList<Group>();
		try {
			listGroups = (List<Group>) GroupLocalServiceUtil.dynamicQuery(dq);
		} catch (SystemException e) {
			e.printStackTrace();
		}

		return listGroups;

	}



	public void editScenarioDetails(ActionRequest request, ActionResponse response)
			throws Exception {



		Long idScenario = ParamUtil.getLong(request, "scenarioId");
		Scenario scenario = ScenarioLocalServiceUtil.getScenario(idScenario);
		Long usersSimulation = ParamUtil.getLong(request, "scenarioUsers");
		Long durationSimulation = ParamUtil.getLong(request, "scenarioDuration");
		scenario.setUsers_per_seconds(usersSimulation);
		scenario.setDuration(durationSimulation);
		List<String> errors = new ArrayList<String>();
		if(ScenarioValidator.validateEditScenarioDetails(scenario, errors)) {
			ScenarioLocalServiceUtil.updateScenario(scenario);			
		}
		else {
			for(String error : errors) {
				SessionErrors.add(request, error);
			}
		}
		response.setRenderParameter("scenarioId", Long.toString(scenario.getScenario_id()));
		response.setRenderParameter("page", jspEditScenario);

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
					fileByte = generateSimulation(simulationId).getBytes();
					OutputStream out = response.getPortletOutputStream();
					out.write(fileByte);
					out.flush();
					out.close();
				} catch (Exception e) {	e.printStackTrace();}
			}
		} catch (PortalException e2) {	e2.printStackTrace();} catch (SystemException e2) {	e2.printStackTrace();}
	}

}