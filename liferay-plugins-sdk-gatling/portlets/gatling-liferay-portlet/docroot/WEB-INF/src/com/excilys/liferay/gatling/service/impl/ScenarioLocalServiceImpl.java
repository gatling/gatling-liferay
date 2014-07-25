/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 *
 *
 *
 */

package com.excilys.liferay.gatling.service.impl;

import com.excilys.liferay.gatling.NoSuchScenarioException;
import com.excilys.liferay.gatling.model.Request;
import com.excilys.liferay.gatling.model.Scenario;
import com.excilys.liferay.gatling.service.RequestLocalServiceUtil;
import com.excilys.liferay.gatling.service.ScenarioLocalServiceUtil;
import com.excilys.liferay.gatling.service.base.ScenarioLocalServiceBaseImpl;
import com.excilys.liferay.gatling.util.DisplayLayout;
import com.excilys.liferay.gatling.util.DisplayLayoutUtil;
import com.excilys.liferay.gatling.util.GatlingUtil;
import com.excilys.liferay.gatling.validator.RequestValidator;
import com.excilys.liferay.gatling.validator.ScenarioValidator;
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
import com.liferay.portal.model.Layout;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

/**
 * The implementation of the scenario local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.sample.service.ScenarioLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p> 
 *
 * @see com.liferay.sample.service.base.ScenarioLocalServiceBaseImpl
 * @see com.liferay.sample.service.ScenarioLocalServiceUtil
 */
public class ScenarioLocalServiceImpl extends ScenarioLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.liferay.sample.service.ScenarioLocalServiceUtil} to access the scenario local service.
	 */
	private static Log log = LogFactoryUtil.getLog(ScenarioLocalServiceImpl.class);

	@Override
	public List<Scenario> findBySimulationId(long simulationId) throws SystemException {
		return scenarioPersistence.findBySimulationId(simulationId);
	}

	@Override
	public	void removeBySimulationIdCascade(long simulationId) throws SystemException {
		List<Scenario> listRequests = ScenarioLocalServiceUtil.findBySimulationId(simulationId);
		//Demande de suppression des requetes associées
		for(Scenario scenario : listRequests) {
			RequestLocalServiceUtil.removeByScenarioId(scenario.getScenario_id());
		}
		scenarioPersistence.removeBySimulationId(simulationId);
	}

	@Override
	public	void removeByIdCascade(long scenarioId) throws SystemException {
		RequestLocalServiceUtil.removeByScenarioId(scenarioId);
		try {
			scenarioPersistence.remove(scenarioId);
		} catch (NoSuchScenarioException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Check if display name is unique
	 * true if unique else false
	 */
	public boolean isNameUnique(String name, long idSimulation) {
		DynamicQuery dq = DynamicQueryFactoryUtil.forClass(Scenario.class)
				.add(PropertyFactoryUtil.forName("name").eq(name))
				.add(PropertyFactoryUtil.forName("simulation_id").eq(idSimulation));

		List<?> result;
		try {
			result = scenarioPersistence.findWithDynamicQuery(dq);
			return result.isEmpty();
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return false;
	}

	public List<Scenario> findByVariableName(String variableName, long idSimulation) {
		DynamicQuery dq = DynamicQueryFactoryUtil.forClass(Scenario.class)
				.add(PropertyFactoryUtil.forName("variableName").like(variableName+"%"))
				.add(PropertyFactoryUtil.forName("simulation_id").eq(idSimulation));

		List<Scenario> result = new ArrayList<Scenario>();
		try {
			result = scenarioPersistence.findWithDynamicQuery(dq);
			return result;
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return result;
	}

	public Scenario addScenarioFromRequest(ActionRequest request, ActionResponse response) throws SystemException {
		ThemeDisplay themeDisplay =	(ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
		Long userId = themeDisplay.getUserId();
		/*
		 * Create a scenario
		 */
		long primaryKey = CounterLocalServiceUtil.increment(Request.class.getName());
		Scenario scenario = ScenarioLocalServiceUtil.createScenario(primaryKey);
		scenario.setName(ParamUtil.getString(request, "scenarioName"));
		scenario.setSimulation_id(ParamUtil.getLong(request, "simulationId"));
		scenario.setGroup_id(ParamUtil.getLong(request, "sites"));
		/*
		 *  Set Variable Name
		 */
		String variableName = GatlingUtil.createVariableName("scenario", ParamUtil.getString(request, "variableScenarioName"));
		List<Scenario> listVar = ScenarioLocalServiceUtil.findByVariableName(variableName, scenario.getSimulation_id());
		if(!listVar.isEmpty() ) {
			variableName = variableName.concat(Integer.toString(listVar.size()));
		}
		scenario.setVariableName(variableName);

		/*
		 * Add base url
		 */
		String urlSite = GroupLocalServiceUtil.fetchGroup(ParamUtil.getLong(request, "sites")).getIconURL(themeDisplay);	
		urlSite = urlSite.split("/")[0]+"//"+urlSite.split("/")[2]+"/web"+GroupLocalServiceUtil.fetchGroup(ParamUtil.getLong(request, "sites")).getFriendlyURL();
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
				RequestLocalServiceUtil.addRequestFromLayout(layout, 0, scenario.getScenario_id(),false, userId);
			}
			return scenario;
		}
		else {
			for(String error : errors) {
				SessionErrors.add(request, error);
			}
		}

		return null;
	}


	public Scenario editScenarioFromRequest(ActionRequest request, ActionResponse response) throws PortalException, SystemException  {
		Long idScenario = ParamUtil.getLong(request, "scenarioId");
		Map<String, String[]> parameters = request.getParameterMap();
		Map<String, Request> lstRequestToEdit =new HashMap<String, Request>();

		//security
		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
		Long userId = themeDisplay.getUserId();

		if(idScenario !=null){

			long groupId =ParamUtil.getLong(request, "groupId");
			/*
			 * Update Details
			 */
			if(log.isDebugEnabled()) log.debug("editScenarioDetails");
			Scenario scenario = ScenarioLocalServiceUtil.getScenario(idScenario);
			String scenarioName= ParamUtil.getString(request, "scenarioName");
			Long scenarioUsers = ParamUtil.getLong(request, "scenarioUsers");
			Long scenarioDuration = ParamUtil.getLong(request, "scenarioDuration");
			scenario.setName(scenarioName);
			scenario.setUsers_per_seconds(scenarioUsers);
			scenario.setDuration(scenarioDuration);
			scenarioPersistence.update(scenario);
			/*
			 * Then update requests
			 * 
			 */
			/*
			 * Layout
			 */
			// Get non private pages
			List<Layout> listLayouts = LayoutLocalServiceUtil.getLayouts(groupId,false,0);
			String siteName = listLayouts.get(0).getGroup().getName();
			// then the private
			List<Layout> listLayoutsPrivate = LayoutLocalServiceUtil.getLayouts(groupId, true, 0);
			List<DisplayLayout> displayLayoutList = new ArrayList<DisplayLayout>();
			// Sorting layout
			DisplayLayoutUtil.addLayoutToDisplayLayoutList(displayLayoutList, listLayouts);
			DisplayLayoutUtil.addLayoutToDisplayLayoutList(displayLayoutList, listLayoutsPrivate);
			// Retrieve Request from DB
			List<Request> listRequests = RequestLocalServiceUtil.findByScenarioId(idScenario);
			// Merge Layout and Request in DisplayLayout List
			displayLayoutList = DisplayLayoutUtil.addRequestToDisplayLayoutList(displayLayoutList, listRequests);

			// get List request
			for(Request r :RequestLocalServiceUtil.findByScenarioId(ParamUtil.get(request, "scenarioId",0))){
				lstRequestToEdit.put(r.getUrl().trim(),  r);
			}

			/*
			 *  update data
			 */
			for (String key : parameters.keySet()){
				// if checked
				if((StringUtil.merge(parameters.get(key)).equals("true")) && (!key.contains("Checkbox")) ){
					int layoutId = (int) Double.parseDouble(key);
					double weight  =   Double.parseDouble(StringUtil.merge(parameters.get("weight"+key)));
					DisplayLayout displayLayout = displayLayoutList.get(layoutId);
					String url = displayLayout.getUrl();
					// if already exists in DB
					if(( lstRequestToEdit.containsKey(url.trim()) ) && ((lstRequestToEdit.get(url).getWeight() != weight) || (!lstRequestToEdit.get(url).isChecked()))){
						Request updatedRequest = lstRequestToEdit.get(url);
						updatedRequest.setWeight(weight);
						updatedRequest.setChecked(true);
						// Saving ...
						List<String> errors = new ArrayList<String>();
						if(RequestValidator.validateRequest(updatedRequest, errors)) {
							RequestLocalServiceUtil.updateRequest(updatedRequest);
							if(log.isDebugEnabled()) log.debug("request updated succefully");
						}
						else {
							for(String error : errors) {
								SessionErrors.add(request, error);
							}
						}
					}

					// else Add new page
					else if(! lstRequestToEdit.containsKey(url.trim())){
						Layout layout = LayoutLocalServiceUtil.getLayout(groupId, displayLayout.getDisplayLayoutId().isPrivatePage(), displayLayout.getDisplayLayoutId().getLayoutId());

						RequestLocalServiceUtil.addRequestFromLayout(layout, weight, idScenario, true, userId );
						if(log.isDebugEnabled()) log.debug("request created and added succefully ");
					}				
				}

				// Cas de suppression de requête dans le scenario --> case pas coché en bd update
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
						}
					}
				}

				// if layout doesn't exist anymore
				else if(key.contains("delete") ){
					long requestId =  Long.parseLong(StringUtil.merge(parameters.get(key)));
					RequestLocalServiceUtil.deleteRequest(requestId);
				}
			}

			return ScenarioLocalServiceUtil.getScenario(idScenario);

		}
		return null;
	}

}