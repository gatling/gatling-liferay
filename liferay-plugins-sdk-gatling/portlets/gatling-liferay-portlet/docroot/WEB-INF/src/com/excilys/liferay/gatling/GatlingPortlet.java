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
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Group;
import com.liferay.portal.service.GroupLocalServiceUtil;
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
import java.util.List;

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
	
	protected String jspListSimulation, jspEditSimulation;
	
	/**
	 * récupérer les noms de toutes les pages
	 */
	@Override
	public void init() throws PortletException {
		jspListSimulation = getInitParameter("list-simulation-jsp");
		jspEditSimulation = getInitParameter("edit-simulation-jsp");
		super.init();
	}

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
		log.info("remove Simulation with id : "+ ParamUtil.getLong(request, "simulationId"));
		SimulationLocalServiceUtil.deleteSimulation(ParamUtil.getLong(request, "simulationId"));
		//TODO : remove all scenario for this simulation
	}	

	/**
	 * Add a new Request to the database
	 * 
	 */
	public void addRequest(ActionRequest request, ActionResponse response)
		throws Exception {

		log.info("addRequest contrôleur");
		
		ThemeDisplay themeDisplay =
			(ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);		

		//update request list of scenario
		List<Request> listUrlToStress = (List<Request>) request.getAttribute("listUrlToStress");
		int totalRate = ParamUtil.getInteger(request,"totalRate");
		if(listUrlToStress == null){
			listUrlToStress = new ArrayList<Request>();
		}
				
		totalRate += ParamUtil.getInteger(request, "rate");
		log.info("totalRate= "+totalRate+ " rate= "+ParamUtil.getInteger(request, "rate"));
		log.info("url= "+ParamUtil.getString(request, "url"));
		if(totalRate ==100){
			log.info("total rate = 100 --> create request ");
			//create request
			long primaryKey = CounterLocalServiceUtil.increment(Request.class.getName());
			Request newRequest = RequestLocalServiceUtil.createRequest(primaryKey);
			newRequest.setUrl(ParamUtil.getString(request, "url"));
			newRequest.setRate(ParamUtil.getInteger(request, "rate"));
			newRequest = RequestLocalServiceUtil.addRequest(newRequest);
			log.info("create request ok");
			listUrlToStress.add(newRequest);
		}
		request.setAttribute("listUrlToStress", listUrlToStress);
		request.setAttribute("totalRate", totalRate);
		
		sendRedirect(request, response);
		
	}
	
	/**
	 * Add a new Scenario to the database
	 * 
	 */
	public void addScenario(ActionRequest request, ActionResponse response)
		throws Exception {

		log.info("addScenario contrôleur");
		
		//create scenario
		long primaryKey = CounterLocalServiceUtil.increment(Request.class.getName());
		Scenario scenario = ScenarioLocalServiceUtil.createScenario(primaryKey);
		scenario.setName(ParamUtil.getString(request, "name"));
		scenario.setSimulation_id(ParamUtil.getLong(request, "simulation_id"));		
		scenario = ScenarioLocalServiceUtil.addScenario(scenario);

		//update data in database 
		List<Request> listUrlToStress = (List<Request>) request.getAttribute("listUrlToStress");
		if(listUrlToStress != null){
			for(Request req : listUrlToStress){
				req.setScenario_id(scenario.getScenario_id());
				RequestLocalServiceUtil.updateRequest(req);
			}
		}
		
		sendRedirect(request, response);
	}
	
	public void editScenario(ActionRequest request, ActionResponse response)
			throws Exception {

		Long id = (Long) request.getAttribute("scenarioId");
		
		List<Request> ls =new ArrayList<Request>();
		try {
			ls.addAll(RequestLocalServiceUtil.findByScenarioId(id));
			
		} catch (SystemException e) {
			e.printStackTrace();
		}
		request.setAttribute("listrequest", ls);
		
		response.setRenderParameter("jspPage", "/html/gatling/editSimulation.jsp"); 
	}
	
	public void editSimulation(ActionRequest request, ActionResponse response)
			throws Exception {

		Long id = (Long) ParamUtil.getLong(request, "simulationId");
		List<Scenario> ls =new ArrayList<Scenario>();
		try {
			ls.addAll(ScenarioLocalServiceUtil.findBySimulationId(id));
			log.info(ls.get(0).getName());
			int sizeLs = ls.size();
			log.info(ls.get(sizeLs-1).getName());
			
		} catch (SystemException e) {
			e.printStackTrace();
		}
		request.setAttribute("listscenario", ls);
		request.setAttribute("simulationId", id);
		response.setRenderParameter("jspPage", "/html/gatling/editSimulation.jsp"); 
	}

	/**
	 * ici en fonction de la page demandée, on effectue différentes actions pour envoyer <br/>
	 * en fonction de la demande, les informations nécessaire à la construction de la page
	 */
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		/* récupération de la value mvcPath */
		/* récupération du chemin de la prochaine jsp */
		String page = ParamUtil.get(renderRequest, "page", jspListSimulation); 
		
		if(page.isEmpty() || page.equals(jspListSimulation)) {
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

			log.info("id simulation:" +id);
			Simulation simulation;
			try {
				simulation = SimulationLocalServiceUtil.getSimulation(id);
				renderRequest.setAttribute("simulation", simulation);
			} catch (PortalException | SystemException e1) {
				e1.printStackTrace();
			}
			
			List<Scenario> ls = new ArrayList<Scenario>();
			try {
				ls.addAll(ScenarioLocalServiceUtil.findBySimulationId(id));
				int sizeLs = ls.size();
				
				/*recupere la liste des sites*/				
				DynamicQuery dq = DynamicQueryFactoryUtil.forClass(Group.class)
						.add(PropertyFactoryUtil.forName("type").ne(0))
						.add(PropertyFactoryUtil.forName("site").eq(true))
						.add(PropertyFactoryUtil.forName("active").eq(true));
				
				List<Group> listGroups = (List<Group>) GroupLocalServiceUtil.dynamicQuery(dq);
				renderRequest.setAttribute("listGroup", listGroups);
				
			} catch (SystemException e) {
				e.printStackTrace();
			}
			
			renderRequest.setAttribute("listscenario", ls);
			
		}
		/* on redirige sur la jsp de page */
		include(page, renderRequest, renderResponse);
	}
}