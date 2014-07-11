package com.excilys.liferay.gatling;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;
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

		Long id = (Long) request.getAttribute("simulationId");
		
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
		
		response.setRenderParameter("jspPage", "/html/gatling/editSimulation.jsp"); 
	}

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		/* récupération de la value mvcPath */
		/* Elle doit être déclarée dans portlet.xml pour pouvoir récupérer la page associée */
		String page = ParamUtil.get(renderRequest, "mvcPath", "list-simulation-jsp"); 
		/* on récupére la page associée au mvcPath */
		String renderPagePath = getInitParameter(page);  
		log.info(renderPagePath);
		
		page = "edit-scenario-jsp";
		renderPagePath = "/html/gatling/editScenario.jsp";
		/* liste des simulations */
		if(page.isEmpty() || page.equals("list-simulation-jsp")) {
			List<Simulation> list = new ArrayList<Simulation>();
			try {
				list = SimulationLocalServiceUtil.getSimulations(0, SimulationLocalServiceUtil.getSimulationsCount());
			} catch (SystemException e) {
				e.printStackTrace();
			}
			renderRequest.setAttribute("listSimulation", list);
		}
		else if(page.equals("edit-simulation-jsp")) {
			log.info("hello from doview");
		}
		else if(page.equals("edit-scenario-jsp")) {
			//scenario
			try {

				int sizeGroups  = GroupLocalServiceUtil.getGroupsCount();
				List<Group> listGroups = GroupLocalServiceUtil.getGroups(0, sizeGroups);
				long groupId = 10184;

				List<Layout> listLayouts = LayoutLocalServiceUtil.getLayouts(groupId, false);

				renderRequest.setAttribute("listGroup", listGroups);
				renderRequest.setAttribute("listLayout", listLayouts);			
				
			} catch (SystemException e) {
				e.printStackTrace();
			}
		}
		
		/* on redirige sur la page du mvcPath */
		include(renderPagePath, renderRequest, renderResponse);
	}
	
	
	/**
	 * Adds a new Request to the database
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
			Request newRequest = RequestLocalServiceUtil.createRequest(0);
			newRequest.setUrl(ParamUtil.getString(request, "url"));
			newRequest.setRate(ParamUtil.getInteger(request, "rate"));
			newRequest = RequestLocalServiceUtil.addRequest(newRequest);
			log.info("create request ok");
			listUrlToStress.add(newRequest);
		}
		request.setAttribute("listUrlToStress", listUrlToStress);
		request.setAttribute("totalRate", totalRate);
		
		sendRedirect(request, response);
		
		/* long primaryKey = CounterLocalServiceUtil.increment(Request.class.getName());
		Request requestScenario = RequestLocalServiceUtil.createRequest(primaryKey);
		requestScenario.setScenario_id(ParamUtil.getLong(request, "scenarioId"));
		requestScenario.setUrl(ParamUtil.getString(request, "url"));
		requestScenario.setRate(ParamUtil.getInteger(request, "rate"));

		RequestLocalServiceUtil.addRequest(requestScenario);
		 */
	}
	
	/**
	 * Adds a new Scenario to the database
	 * 
	 */
	public void addScenario(ActionRequest request, ActionResponse response)
		throws Exception {

		log.info("addScenario contrôleur");
		
		//create scenario
		Scenario scenario = ScenarioLocalServiceUtil.createScenario(0);

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
}
