package com.excilys.liferay.gatling;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Layout;
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
		Scenario scenario =ScenarioLocalServiceUtil.createScenario(0);
		scenario.setScenario_id(ParamUtil.getLong(request, "scenarioId"));
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
		Request requestScenario = RequestLocalServiceUtil.createRequest(0);
		requestScenario.setRequest_id(ParamUtil.getLong(request, "requestId"));
		requestScenario.setScenario_id(ParamUtil.getLong(request, "scenarioId"));
		requestScenario.setUrl(ParamUtil.getString(request, "url"));
		requestScenario.setRate(ParamUtil.getInteger(request, "rate"));
		
		RequestLocalServiceUtil.addRequest(requestScenario);
	}
	



	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {


		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest
				.getAttribute(WebKeys.THEME_DISPLAY);

		int sizeLayouts;
		try {
			sizeLayouts = LayoutLocalServiceUtil.getLayoutsCount();
			
			
			long groupId = 10184;
			List<Layout> listLayouts = LayoutLocalServiceUtil.getLayouts(groupId, false);
			List<PageSiteWrapper> pageSW = new ArrayList<PageSiteWrapper>();
			for (Layout layout : listLayouts) {
				PageSiteWrapper page = new PageSiteWrapper();
				page.setValue(layout.getFriendlyURL());
				page.setLabel(layout.getName());
				pageSW.add(page);
			}

			renderRequest.setAttribute("pageSiteWrapper", pageSW);
		} catch (SystemException e) {
			e.printStackTrace();
		}finally {
			super.doView(renderRequest, renderResponse);
		}
	}


	/*
	private List<PageSiteWrapper> GetListPages(Layout layout, Locale locale){

		List<PageSiteWrapper> listPages = new ArrayList<PageSiteWrapper>();
		LayoutLister layoutLister = new LayoutLister();
		String rootNodeName = StringPool.BLANK;
		LayoutView layoutView;

		try {
			layoutView = layoutLister.getLayoutView(layout.getGroupId(), layout.isPrivateLayout(), rootNodeName, locale);

			List layoutList = layoutView.getList();

			for (int i = 0; i < layoutList.size(); i++) {

				PageSiteWrapper page = new PageSiteWrapper();

				String layoutDesc = (String)layoutList.get(i);

				String[] nodeValues = StringUtil.split(layoutDesc, '|');

				long objId = GetterUtil.getLong(nodeValues[3]);
				String name = nodeValues[4];

				int depth = 0;
				if (i != 0) {
					depth = GetterUtil.getInteger(nodeValues[6]);
				}
				for (int j = 0; j < depth; j++) {
					name = "-&nbsp;" + name;
				}

				Layout curRootLayout = null;

				try {
					curRootLayout = LayoutLocalServiceUtil.getLayout(objId);
				}
				catch (Exception e) {
				}

				page.setLabel(name);

				if (curRootLayout != null) {
					page.setValue(curRootLayout.getUuid());
				}
				listPages.add(page);

			} 
		}
		catch (PortalException e1) {
				e1.printStackTrace();
		} catch (SystemException e1) {
				e1.printStackTrace();
		}



		return listPages;
	}
	 */
}
