package com.excilys.liferay.gatling;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;
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

	/**
	 * Adds a new Scenario to the database.
	 * 
	 */
	public void addScenario(ActionRequest request, ActionResponse response)
			throws Exception {
		long primaryKey = CounterLocalServiceUtil.increment(Scenario.class.getName());
		Scenario scenario =ScenarioLocalServiceUtil.createScenario(primaryKey);
		scenario.setName(ParamUtil.getString(request, "scenarioName"));
		scenario.setSimulation_id(ParamUtil.getLong(request, "simulationId"));

		ScenarioLocalServiceUtil.addScenario(scenario);
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

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		/* récupération de la value mvcPath */
		/* récupération du chemin de la prochaine jsp */
		String page = ParamUtil.get(renderRequest, "page", jspListSimulation); 
		/* liste des simulations */
		if(page.isEmpty() || page.equals(jspListSimulation)) {
			List<Simulation> list = new ArrayList<>();
			try {
				list = SimulationLocalServiceUtil.getSimulations(0, SimulationLocalServiceUtil.getSimulationsCount());
			} catch (SystemException e) {
				e.printStackTrace();
			}
			renderRequest.setAttribute("listSimulation", list);
		}
		else if(page.equals(jspEditSimulation)) {
			log.info("hello from doview");
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
