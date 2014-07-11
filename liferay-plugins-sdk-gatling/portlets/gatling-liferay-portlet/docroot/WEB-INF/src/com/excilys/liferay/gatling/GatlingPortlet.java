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
import com.liferay.portal.model.Group;
import com.liferay.portal.model.GroupConstants;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.GroupServiceUtil;
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
import javax.servlet.FilterRegistration.Dynamic;

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
	}	

	/**
	 * Adds a new Scenario to the database.
	 * 
	 */
	public void addScenario(ActionRequest request, ActionResponse response)
			throws Exception {
		long primaryKey = CounterLocalServiceUtil.increment(Scenario.class.getName());
		Scenario scenario = ScenarioLocalServiceUtil.createScenario(primaryKey);
		scenario.setName(ParamUtil.getString(request, "scenarioName"));
		scenario.setSimulation_id(ParamUtil.getLong(request, "simulationId"));

		ScenarioLocalServiceUtil.addScenario(scenario);
		
		Simulation simulation = SimulationLocalServiceUtil.getSimulation(ParamUtil.getLong(request, "simulationId"));
		//TODO: récuperer liste sscenario
		request.setAttribute("simulation", simulation);
		response.setRenderParameter("jspPage", "/html/gatling/editSimulation.jsp");
	}

	/**
	 * Adds a new Request to the database.
	 * 
	 */
	public void addRequest(ActionRequest request, ActionResponse response)
			throws Exception {
		long primaryKey = CounterLocalServiceUtil.increment(Request.class.getName());
		Request requestScenario = RequestLocalServiceUtil.createRequest(primaryKey);
		requestScenario.setScenario_id(ParamUtil.getLong(request, "scenarioId"));
		requestScenario.setUrl(ParamUtil.getString(request, "url"));
		requestScenario.setRate(ParamUtil.getInteger(request, "rate"));

		RequestLocalServiceUtil.addRequest(requestScenario);
		
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

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		/* récupération de la value mvcPath */
		/* récupération du chemin de la prochaine jsp */
		String page = ParamUtil.get(renderRequest, "page", jspListSimulation); 
		/* liste des simulations */
		if(page.isEmpty() || page.equals(jspListSimulation)) {
			List<Simulation> list = new ArrayList<Simulation>();
			try {
				list = SimulationLocalServiceUtil.getSimulations(0, SimulationLocalServiceUtil.getSimulationsCount());
			} catch (SystemException e) {
				e.printStackTrace();
			}
			renderRequest.setAttribute("listSimulation", list);
		} else if(page.equals(jspEditSimulation)) { // page de scenarios
			

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
		/*
		 * TODO : Remettre au bon endroit
		try {

			int sizeGroups  = GroupLocalServiceUtil.getGroupsCount();

			List<Group> listGroups = GroupLocalServiceUtil.getGroups(0, sizeGroups);
			long groupId = 10184;

			List<Layout> listLayouts = LayoutLocalServiceUtil.getLayouts(groupId, false);
			renderRequest.setAttribute("setGroup", listGroups);
			renderRequest.setAttribute("listLayout", listLayouts);



			List<Scenario> ls =new ArrayList<Scenario>();
			try {
				ls.addAll(ScenarioLocalServiceUtil.findBySimulationId(1));
				l.info(ls.get(0).getName());
				int sizeLs = ls.size();
				l.info(ls.get(sizeLs-1).getName());

			} catch (SystemException e) {
				e.printStackTrace();
			}
			renderRequest.setAttribute("ls", ls);


		} catch (SystemException e) {
			e.printStackTrace();
		}finally {
			super.doView(renderRequest, renderResponse);

		}*/

	}
	
	
	
}
