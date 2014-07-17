package com.excilys.liferay.gatling;

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
import com.liferay.portal.kernel.servlet.SessionErrors;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

/**
 * Portlet implementation class GatlingPortlet
 */
public class GatlingPortlet extends MVCPortlet {


	private static Log log = LogFactoryUtil.getLog(GatlingPortlet.class);


	protected String jspListSimulation, jspEditSimulation, jspEditScenario, jspFormFirstScenario;


	/**
	 * récupérer les noms de toutes les pages
	 */
	@Override
	public void init() throws PortletException {
		jspListSimulation = getInitParameter("list-simulation-jsp");
		jspEditSimulation = getInitParameter("edit-simulation-jsp");
		jspEditScenario = getInitParameter("edit-scenario-jsp");
		jspFormFirstScenario = getInitParameter("form-first-scenario-jsp");
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
				SessionErrors.add(request, error);
			}
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
	public void addFirstScenario(ActionRequest request, ActionResponse response)
			throws Exception {
		//create scenario
		long primaryKey = CounterLocalServiceUtil.increment(Request.class.getName());
		Scenario scenario = ScenarioLocalServiceUtil.createScenario(primaryKey);
		scenario.setName(ParamUtil.getString(request, "scenarioName"));
		scenario.setSimulation_id(ParamUtil.getLong(request, "simulationId"));
		scenario.setGroup_id(ParamUtil.getLong(request, "sites"));
		// Saving ...
		List<String> errors = new ArrayList<String>();
		if(ScenarioValidator.validateScenario(scenario, errors)) {
			scenario = ScenarioLocalServiceUtil.addScenario(scenario);
			log.info("First Scenario Added");
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

		Long idScenario = ParamUtil.getLong(request, "scenarioId");
		Map<String, String[]> parameters = request.getParameterMap();
		Map<String, Request> lstRequestToEdit =new HashMap<String, Request>();
		try {
			for(Request r :RequestLocalServiceUtil.findByScenarioId(ParamUtil.get(request, "scenarioId",0))){
				lstRequestToEdit.put(r.getUrl().trim(),  r);
			}

		} catch (SystemException e) {
			e.printStackTrace();
		}

		if(idScenario !=null){

			long groupId =ParamUtil.getLong(request, "groupId");

			List<Layout> listLayouts;
			try {
				listLayouts = new ArrayList<Layout>(LayoutLocalServiceUtil.getLayouts(groupId, false));
				List<Layout> listLayoutsPrivate = LayoutLocalServiceUtil.getLayouts(groupId, true);
				listLayouts.addAll(listLayoutsPrivate);
				for (String key : parameters.keySet()){

					if((StringUtil.merge(parameters.get(key)).equals("true")) && (!key.contains("Checkbox")) ){
						int requestNumber = Integer.parseInt(key);
						double weight  =   Double.parseDouble(StringUtil.merge(parameters.get("rate")).split(",")[requestNumber]);
						String url = listLayouts.get(requestNumber).getFriendlyURL();
						if((lstRequestToEdit.containsKey(url.trim())) && (lstRequestToEdit.get(url).getWeight() != weight)){
							Request updatedRequest = lstRequestToEdit.get(url);
							updatedRequest.setWeight(weight);
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
						else if(! lstRequestToEdit.containsKey(url.trim())){					
							addRequest(url, weight, idScenario);
							log.info("request created and added succefully ");
						}				
					}
					else if((StringUtil.merge(parameters.get(key)).equals("false")) && (!key.contains("Checkbox")) ){
						int requestNumber = Integer.parseInt(key);
						String url = listLayouts.get(requestNumber).getFriendlyURL();
						if(lstRequestToEdit.containsKey(url.trim())){
							Request RequestToDelete = lstRequestToEdit.get(url);
							RequestLocalServiceUtil.deleteRequest(RequestToDelete);
							log.info("request deleted succefully ");

						}
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
	 * 
	 */


	public void addRequest(String url, double rate, long idScenario) {

		log.info("addRequest contrôleur");
		//create request
		long primaryKey;
		try {
			primaryKey = CounterLocalServiceUtil.increment(Request.class.getName());
			Request newRequest = RequestLocalServiceUtil.createRequest(primaryKey);
			newRequest.setUrl(url);
			newRequest.setWeight(rate);
			newRequest.setScenario_id(idScenario);
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
				Map<Scenario, Integer> scenariosMap = new HashMap<Scenario, Integer>();
				for(Scenario scena : ls){
					List<Request> lsR = RequestLocalServiceUtil.findByScenarioId(scena.getScenario_id());
					scenariosMap.put(scena, lsR.size());
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
				Scenario scenario = ScenarioLocalServiceUtil.getScenario(ParamUtil.getLong(renderRequest, "scenarioId"));
				long groupId = scenario.getGroup_id();
				List<Layout> listLayouts = new ArrayList<Layout>(LayoutLocalServiceUtil.getLayouts(groupId, false));
				// Puis les privates
				List<Layout> listLayoutsPrivate = LayoutLocalServiceUtil.getLayouts(groupId, true);
				listLayouts.addAll(listLayoutsPrivate);

				renderRequest.setAttribute("scenario", scenario);
				renderRequest.setAttribute("listLayout", listLayouts);	
				renderRequest.setAttribute("siteName", listLayouts.get(0).getGroup().getName());

				Map<String, Double> ls =new HashMap<String, Double>();
				try {
					for(Request r :RequestLocalServiceUtil.findByScenarioId(ParamUtil.get(renderRequest, "scenarioId",0))){
						ls.put(r.getUrl(), r.getWeight());
					}

				} catch (SystemException e) {
					e.printStackTrace();
				}

				renderRequest.setAttribute("listrequest", ls);

			} catch (SystemException e) {
				e.printStackTrace();
			} catch (PortalException e) {
				e.printStackTrace();
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

}