package com.excilys.liferay.gatling;

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
import com.liferay.portal.model.Group;
import com.liferay.portal.model.Layout;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.LayoutLocalServiceUtil;
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
	
	protected String jspListSimulation, jspEditSimulation, jspEditScenario;
	
	
	/**
	 * récupérer les noms de toutes les pages
	 */
	@Override
	public void init() throws PortletException {
		jspListSimulation = getInitParameter("list-simulation-jsp");
		jspEditSimulation = getInitParameter("edit-simulation-jsp");
		jspEditScenario = getInitParameter("edit-scenario-jsp");
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
		if(!ParamUtil.getString(request, "simulationName").isEmpty()) {
			simulation.setName(ParamUtil.getString(request, "simulationName"));
			SimulationLocalServiceUtil.addSimulation(simulation);
		}
		else {
			SessionErrors.add(request, "simulation-name-error");
			sendRedirect(request, response);
		}
	}

	public void removeSimulation(ActionRequest request, ActionResponse response)
			throws Exception {
		long simulationId = ParamUtil.getLong(request, "simulationId");
		log.info("remove Simulation with id : "+ simulationId);
		// Etape 1
		// -> Suppression des tables
		List<Scenario> listRequests = ScenarioLocalServiceUtil.findBySimulationId(simulationId);
		// Suppressions des requests
		for(Scenario scenario : listRequests) {
			RequestLocalServiceUtil.removeByScenarioId(scenario.getScenario_id());
		}
		//Suppression des scénarios
		ScenarioLocalServiceUtil.removeBySimulationId(simulationId);
		// Supression de la simulations
		SimulationLocalServiceUtil.deleteSimulation(simulationId);
		
		// Etape 2 
		// -> récupération des simulations
		List<Simulation> list = new ArrayList<Simulation>();
		try {
			list = SimulationLocalServiceUtil.getSimulations(0, SimulationLocalServiceUtil.getSimulationsCount());
		} catch (SystemException e) {
			e.printStackTrace();
		}
		request.setAttribute("listSimulation", list);
		response.setRenderParameter("jspPage", jspListSimulation); 
		sendRedirect(request, response);
	}	

	/*
	 * ==== Scenario ====
	 */
	/**
	 * Add a new Scenario to the database
	 * 
	 */
	public void addScenario(ActionRequest request, ActionResponse response)
			throws Exception {
		//create scenario
		long primaryKey = CounterLocalServiceUtil.increment(Request.class.getName());
		Scenario scenario = ScenarioLocalServiceUtil.createScenario(primaryKey);
		scenario.setName(ParamUtil.getString(request, "scenarioName"));
		scenario.setSimulation_id(ParamUtil.getLong(request, "simulationId"));
		scenario.setGroup_id(ParamUtil.getLong(request, "sites"));
		scenario = ScenarioLocalServiceUtil.addScenario(scenario);
		
		// Récupération de la simulation
		Simulation simulation = SimulationLocalServiceUtil.getSimulation(ParamUtil.getLong(request, "simulationId"));
		request.setAttribute("simulation", simulation);
		// Récupération des scénarios de la simulation
		List<Scenario> liScenarios = getScenarioForSimulation(simulation.getSimulation_id());
		request.setAttribute("listScenario", liScenarios);
		// List of Sites
		List<Group> liGroups = getListOfSites();
		request.setAttribute("listGroup", liGroups);
		
		response.setRenderParameter("jspPage", jspEditSimulation); 
		sendRedirect(request, response);
	}

	
	/**
	 * edit scenario
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public void editScenario(ActionRequest request, ActionResponse response)
			throws Exception {
	
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
			List<Layout> listLayouts = LayoutLocalServiceUtil.getLayouts(groupId, false);
			
			for (String key : parameters.keySet()){

				if(StringUtil.merge(parameters.get(key)).equals("true")){
					int requestNumber = Integer.parseInt(key);
					int weight  =  Integer.parseInt(StringUtil.merge(parameters.get("rate")).split(",")[requestNumber]);
					String url = listLayouts.get(requestNumber).getFriendlyURL();
					if(lstRequestToEdit.containsKey(url.trim())){
						Request updatedRequest = lstRequestToEdit.get(url);
						updatedRequest.setRate(weight);
						log.info("nouveau poids "+weight);
						RequestLocalServiceUtil.updateRequest(updatedRequest);
					}
					else{
						log.info("creation de nouvelle requette ");
						addRequest(url, weight, idScenario);
					}				
				}
			}
		}
		
		// Récupération de la simulation
		Scenario scenario = ScenarioLocalServiceUtil.getScenario(idScenario);
		Simulation simulation = SimulationLocalServiceUtil.getSimulation(scenario.getSimulation_id());
		request.setAttribute("simulation", simulation);
		// Récupération des scénarios de la simulation
		List<Scenario> liScenarios = getScenarioForSimulation(simulation.getSimulation_id());
		request.setAttribute("listScenario", liScenarios);
		// List of Sites
		List<Group> liGroups = getListOfSites();
		request.setAttribute("listGroup", liGroups);
		response.setRenderParameter("jspPage", "/html/gatling/editSimulation.jsp"); 
	}

	/**
	 * Add a new Request to the database
	 * 
	 */
	
	
	public void addRequest(String url, int rate, long idScenario)
		throws Exception {
	
		log.info("addRequest contrôleur");
		//create request
		long primaryKey = CounterLocalServiceUtil.increment(Request.class.getName());
		Request newRequest = RequestLocalServiceUtil.createRequest(primaryKey);
		newRequest.setUrl(url);
		newRequest.setRate(rate);
		newRequest.setScenario_id(idScenario);
		newRequest = RequestLocalServiceUtil.addRequest(newRequest);
			
	}
	/**
	 * ici en fonction de la page demandée, on effectue différentes actions pour envoyer <br/>
	 * en fonction de la demande, les informations nécessaire à la construction de la page
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
			List<Simulation> list = new ArrayList<Simulation>();
			try {
				list = SimulationLocalServiceUtil.getSimulations(0, SimulationLocalServiceUtil.getSimulationsCount());
			} catch (SystemException e) {
				e.printStackTrace();
			}
			renderRequest.setAttribute("listSimulation", list);
		} else if(page.equals(jspEditSimulation)) {
			/*
			 * Edition d'une simulation, liste des scénarios
			 */
			Long id = (Long) ParamUtil.getLong(renderRequest, "simulationId");

			Simulation simulation;
			try {
				simulation = SimulationLocalServiceUtil.getSimulation(id);
				renderRequest.setAttribute("simulation", simulation);
			} catch (PortalException | SystemException e1) {
				e1.printStackTrace();
			}
			// List of Scénarios
			List<Scenario> ls = getScenarioForSimulation(id);
			renderRequest.setAttribute("listScenario", ls);
			// List of Sites
			List<Group> liGroups = getListOfSites();
			renderRequest.setAttribute("listGroup", liGroups);
		}
		else if(page.equals(jspEditScenario)){
			//scenario
			try {
				log.info("jsp edit scenario");

				int sizeGroups  = GroupLocalServiceUtil.getGroupsCount();
				List<Group> listGroups = GroupLocalServiceUtil.getGroups(0, sizeGroups);
				Scenario scenario = ScenarioLocalServiceUtil.getScenario(ParamUtil.getLong(renderRequest, "scenarioId"));
				log.info("group id "+scenario.getGroup_id());
				long groupId = scenario.getGroup_id();

				List<Layout> listLayouts = LayoutLocalServiceUtil.getLayouts(groupId, false);
				log.info("taille list"+listLayouts.size());
				
				renderRequest.setAttribute("scenarioId", ParamUtil.get(renderRequest, "scenarioId",0));
				renderRequest.setAttribute("groupId", groupId);
				renderRequest.setAttribute("listLayout", listLayouts);	
				
				Map<String, Integer> ls =new HashMap<String, Integer>();
				try {
					for(Request r :RequestLocalServiceUtil.findByScenarioId(ParamUtil.get(renderRequest, "scenarioId",0))){
						ls.put(r.getUrl(), r.getRate());
					}
					
				} catch (SystemException e) {
					e.printStackTrace();
				}

				renderRequest.setAttribute("listrequest", ls);
				
			} catch (SystemException e) {
				e.printStackTrace();
			} catch (PortalException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		/* on redirige sur la jsp de page */
		include(page, renderRequest, renderResponse);	
	}
	
	/*
	 * Utils Scénarios
	 */
	/**
	 * Récupère la liste de scénario pour une simulation donnée
	 * @param id de la simulation
	 * @return list des scenarios
	 */
	private List<Scenario> getScenarioForSimulation(Long id) {
		List<Scenario> ls = new ArrayList<Scenario>();
		try {
			ls.addAll(ScenarioLocalServiceUtil.findBySimulationId(id));
		} catch (SystemException e) {
			e.printStackTrace();
		}
			
		return ls;
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