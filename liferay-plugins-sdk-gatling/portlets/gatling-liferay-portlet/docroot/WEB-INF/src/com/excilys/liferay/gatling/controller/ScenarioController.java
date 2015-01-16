package com.excilys.liferay.gatling.controller;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

import com.excilys.liferay.gatling.GatlingPortlet;
import com.excilys.liferay.gatling.dto.RequestDTO;
import com.excilys.liferay.gatling.model.Request;
import com.excilys.liferay.gatling.model.Scenario;
import com.excilys.liferay.gatling.model.Simulation;
import com.excilys.liferay.gatling.service.RequestLocalServiceUtil;
import com.excilys.liferay.gatling.service.ScenarioLocalServiceUtil;
import com.excilys.liferay.gatling.service.SimulationLocalServiceUtil;
import com.excilys.liferay.gatling.util.DisplayItemDTOUtil;
import com.excilys.liferay.gatling.util.GatlingUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Layout;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;

@Controller(value="ScenarioController")
@RequestMapping("VIEW")
public class ScenarioController {

	private static final Log LOG = LogFactoryUtil.getLog(GatlingPortlet.class);

	@RenderMapping(params="render=renderScenario")
	public String renderScenario(final RenderRequest renderRequest, final RenderResponse renderResponse) throws SystemException , PortalException{
		final Long id = Long.parseLong(renderRequest.getParameter("scenarioId"));
		if (ParamUtil.getLong(renderRequest, "scenarioId") == 0) {
			throw new NullPointerException("scenario id is null");
		}
		final Scenario scenario =	ScenarioLocalServiceUtil.getScenario(id);
		renderRequest.setAttribute("scenario", scenario);

		// get scenario
		final Simulation simulation = SimulationLocalServiceUtil.getSimulation(scenario.getSimulation_id());

		//update friendlyUrl of site if changed
		final String oldFriendlyURL = scenario.getUrl_site();
		final ThemeDisplay themeDisplay =	(ThemeDisplay)renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String currentFriendlyURL = GroupLocalServiceUtil.fetchGroup(scenario.getGroup_id()).getIconURL(themeDisplay);
		final StringBuilder sb = new StringBuilder(currentFriendlyURL.split("/")[0]);
		sb.append("//").append(currentFriendlyURL.split("/")[2]).append("/web").append(GroupLocalServiceUtil.fetchGroup(scenario.getGroup_id()).getFriendlyURL());
		currentFriendlyURL = sb.toString();

		if (! oldFriendlyURL.equals(currentFriendlyURL)) {
			//update site url 
			scenario.setUrl_site(currentFriendlyURL);
			ScenarioLocalServiceUtil.updateScenario(scenario);
		}

		//get public layout list
		final long groupId = scenario.getGroup_id();
		final List<Layout> listPublicLayouts = LayoutLocalServiceUtil.getLayouts(groupId, false, 0);

		//get private layout list
		final List<Layout> listPrivateLayouts = LayoutLocalServiceUtil.getLayouts(groupId, true, 0);

		//get site name
		final String siteName = GroupLocalServiceUtil.getGroup(groupId).getDescriptiveName();

		//create DisplayLayoutList with actuel layout of the site and old layout added from requests
		List<RequestDTO> displayItemList = new ArrayList<RequestDTO>();
		DisplayItemDTOUtil.addLayoutToDisplayItemList(displayItemList, listPublicLayouts);
		DisplayItemDTOUtil.addLayoutToDisplayItemList(displayItemList, listPrivateLayouts);

		//get list of request to add the old page to DisplayLayout
		final List<Request> listRequests = RequestLocalServiceUtil.findByScenarioId(scenario.getScenario_id());
		//Merge Layout and Request in DisplayLayout List
		displayItemList = DisplayItemDTOUtil.addRequestToDisplayItemList(displayItemList, listRequests);

		// Get list of used names
		final List<Scenario> scenariolist = ScenarioLocalServiceUtil.getScenarios(0, ScenarioLocalServiceUtil.getScenariosCount());
		final String JSListName = GatlingUtil.createJSListOfScenarioName(scenariolist);

		//add private and public url of site
		final String publicURL = scenario.getUrl_site();
		final String privateURL = scenario.getUrl_site().replace("web", "group");
		/*
		 * create header list
		 */
		final String[] headerList = new String[] {simulation.getName(), scenario.getName(), siteName};
		renderRequest.setAttribute("headerList", headerList);
		//add request parameters
		renderRequest.setAttribute("listPages", displayItemList);
		renderRequest.setAttribute("siteName", siteName);
		renderRequest.setAttribute("publicURL", publicURL);
		renderRequest.setAttribute("privateURL", privateURL);
		renderRequest.setAttribute("listOfScenarioName", JSListName);
		return "editScenario";
	}

	@ActionMapping(params="action=editScenario")
	public void editScenarioAction(final ActionRequest request, final ActionResponse response, final Model model) throws SystemException, PortalException {
		LOG.debug("edit scenario controller");
		final Scenario scenario = ScenarioLocalServiceUtil.editScenarioFromRequest(request);
		if (scenario != null) {
			// redirect to editScenario
			response.setRenderParameter("scenarioId", Long.toString(scenario.getScenario_id()));
			response.setRenderParameter("render", "renderScenario");
		} else {
			response.setRenderParameter("simulationId", ParamUtil.getString(request, "simulationId"));
			response.setRenderParameter("render", "renderSimulation");
		}
	}

	@ActionMapping(params="action=deleteScenario")
	public void deleteScenarioAction(final ActionRequest request, final ActionResponse response, final Model model) throws PortalException, SystemException {
		final long scenarioId = ParamUtil.getLong(request, "scenarioId");
		final long simulationId = ParamUtil.getLong(request, "simulationId");
		if (LOG.isDebugEnabled()){
			LOG.debug("remove Scenario with id : " + scenarioId);
		}
		// cascade delete
		ScenarioLocalServiceUtil.removeByIdCascade(scenarioId);
		response.setRenderParameter("simulationId", Long.toString(simulationId));
		response.setRenderParameter("render", "renderScenario");
	}

	@ActionMapping(params="action=addScenario")
	public void addScenarioAction(final ActionRequest request, final ActionResponse response, final Model model) throws SystemException {

		final Scenario scenario = ScenarioLocalServiceUtil.addScenarioFromRequest(request);
		if (scenario != null) {
			// redirect to editScenario
			response.setRenderParameter("scenarioId", Long.toString(scenario.getScenario_id()));
			response.setRenderParameter("render", "renderScenario");
		} else {
			response.setRenderParameter("simulationId", ParamUtil.getString(request, "simulationId"));
			response.setRenderParameter("render", "renderSimulation");
		}
	}
}