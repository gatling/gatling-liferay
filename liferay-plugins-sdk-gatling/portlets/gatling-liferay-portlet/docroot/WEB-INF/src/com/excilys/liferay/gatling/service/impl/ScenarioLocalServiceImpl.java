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
import com.excilys.liferay.gatling.util.DisplayLayout.RequestState;
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
	private static final Log LOG = LogFactoryUtil.getLog(ScenarioLocalServiceImpl.class);


	@Override
	public int countBySimulationId(long simulationId) throws SystemException{
		return scenarioPersistence.countBySimulationId(simulationId);
	}
	
	@Override
	public List<Scenario> findBySimulationId(long simulationId) throws SystemException {
		return scenarioPersistence.findBySimulationId(simulationId);
	}

	@Override
	public	void removeBySimulationIdCascade(long simulationId) throws SystemException {
		final List<Scenario> listScenario = ScenarioLocalServiceUtil.findBySimulationId(simulationId);
		//Remove its requests
		for(Scenario scenario : listScenario) {
			RequestLocalServiceUtil.removeByScenarioId(scenario.getScenario_id());
		}
		scenarioPersistence.removeBySimulationId(simulationId);
	}

	@Override
	public	void removeByIdCascade(long scenarioId) throws SystemException, NoSuchScenarioException {
		RequestLocalServiceUtil.removeByScenarioId(scenarioId);
		scenarioPersistence.remove(scenarioId);
	}

	/**
	 * Check if display name is unique
	 * true if unique else false
	 */
	public boolean isNameUnique(String name, long idSimulation) throws SystemException {
		final DynamicQuery dq = DynamicQueryFactoryUtil.forClass(Scenario.class)
				.add(PropertyFactoryUtil.forName("name").eq(name))
				.add(PropertyFactoryUtil.forName("simulation_id").eq(idSimulation));
		int result = (int) scenarioPersistence.countWithDynamicQuery(dq);
		return (result == 0);
	}

	public int countByVariableName(String variableName, long idSimulation) throws SystemException {
		DynamicQuery dq = DynamicQueryFactoryUtil.forClass(Scenario.class)
				.add(PropertyFactoryUtil.forName("variableName").like(variableName+"%"))
				.add(PropertyFactoryUtil.forName("simulation_id").eq(idSimulation));

		return (int) scenarioPersistence.countWithDynamicQuery(dq);
	}

	public List<Scenario> findByVariableName(String variableName, long idSimulation)  throws SystemException {
		DynamicQuery dq = DynamicQueryFactoryUtil.forClass(Scenario.class)
				.add(PropertyFactoryUtil.forName("variableName").like(variableName+"%"))
				.add(PropertyFactoryUtil.forName("simulation_id").eq(idSimulation));

		return scenarioPersistence.findWithDynamicQuery(dq);
	}

	public Scenario addScenarioFromRequest(ActionRequest request, ActionResponse response) throws SystemException {
		final ThemeDisplay themeDisplay =	(ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
		final Long userId = themeDisplay.getUserId();
		/*
		 * Create a scenario
		 */
		final long primaryKey = CounterLocalServiceUtil.increment(Request.class.getName());
		Scenario scenario = ScenarioLocalServiceUtil.createScenario(primaryKey);
		scenario.setName(ParamUtil.getString(request, "scenarioName"));
		scenario.setSimulation_id(ParamUtil.getLong(request, "simulationId"));
		scenario.setGroup_id(ParamUtil.getLong(request, "sites"));
		/*
		 *  Set Variable Name
		 */
		String variableName = GatlingUtil.createVariableName("scenario", ParamUtil.getString(request, "scenarioName"));
		final int sizeVar = ScenarioLocalServiceUtil.countByVariableName(variableName, scenario.getSimulation_id());
		if(sizeVar !=0 ) {
			variableName = variableName.concat(Integer.toString(sizeVar));
		}
		scenario.setVariableName(variableName);
		/*
		 * Add base url
		 */
		String urlSite = GroupLocalServiceUtil.fetchGroup(ParamUtil.getLong(request, "sites")).getIconURL(themeDisplay);	
		urlSite = urlSite.split("/")[0]+"//"+urlSite.split("/")[2]+"/web"+GroupLocalServiceUtil.fetchGroup(ParamUtil.getLong(request, "sites")).getFriendlyURL();
		scenario.setUrl_site(urlSite);

		// Saving ...
		final List<String> errors = ScenarioValidator.validateScenario(scenario);
		if(!errors.isEmpty()) {
			scenario = ScenarioLocalServiceUtil.addScenario(scenario);
			//add Requests
			final List<Layout> listLayouts = new ArrayList<Layout>(LayoutLocalServiceUtil.getLayouts(ParamUtil.getLong(request, "sites"), false));
			final List<Layout> listLayoutsPrivate = LayoutLocalServiceUtil.getLayouts(ParamUtil.getLong(request, "sites"), true);
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
		final Long idScenario = ParamUtil.getLong(request, "scenarioId");
		final Map<String, String[]> parameters = request.getParameterMap();
		final Map<String, Request> mapPrivateRequestToEdit =new HashMap<String, Request>();
		final Map<String, Request> mapPublicRequestToEdit =new HashMap<String, Request>();

		//security
		final ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
		final Long userId = themeDisplay.getUserId();
		
		Scenario scenarioToReturn = null;

		/*
		 * Update Details
		 */
		LOG.debug("editScenarioDetails");
		
		Scenario scenario = ScenarioLocalServiceUtil.getScenario(idScenario);
		String scenarioName= ParamUtil.getString(request, "scenarioName");
		scenario.setName(scenarioName);
		scenario.setVariableName(GatlingUtil.createVariableName("scenario", scenarioName));
		scenario.setUsers_per_seconds(ParamUtil.getLong(request, "scenarioUsers"));
		scenario.setDuration(ParamUtil.getLong(request, "scenarioDuration"));
		scenarioToReturn = scenarioPersistence.update(scenario);
		/*
		 * Then update requests
		 * 
		 */
		/*
		 * Layout
		 */
		final long groupId =ParamUtil.getLong(request, "groupId");
		// Get non private pages
		final List<Layout> listLayouts = LayoutLocalServiceUtil.getLayouts(groupId,false,0);
		// then the private
		final List<Layout> listLayoutsPrivate = LayoutLocalServiceUtil.getLayouts(groupId, true, 0);
		List<DisplayLayout> displayLayoutList = new ArrayList<DisplayLayout>();
		// Sorting layout
		DisplayLayoutUtil.addLayoutToDisplayLayoutList(displayLayoutList, listLayouts);
		DisplayLayoutUtil.addLayoutToDisplayLayoutList(displayLayoutList, listLayoutsPrivate);
		// Retrieve Request from DB
		final List<Request> listRequests = RequestLocalServiceUtil.findByScenarioId(idScenario);
		// Merge Layout and Request in DisplayLayout List
		displayLayoutList = DisplayLayoutUtil.addRequestToDisplayLayoutList(displayLayoutList, listRequests);

		// get List request
		final List<Request> listRequest = RequestLocalServiceUtil.findByScenarioId(ParamUtil.get(request, "scenarioId",0));
		for(Request r : listRequest){
			if(r.isPrivatePage()){
				mapPrivateRequestToEdit.put(r.getUrl().trim(),  r);
			}
			else{
				mapPublicRequestToEdit.put(r.getUrl().trim(),  r);
			}
			
		}

		/*
		 *  update data
		 */
		int layoutId = 0;
		double weight = 0.0d;
		DisplayLayout displayLayout = null;
		String url = null;
		RequestState status = null;
		for (String key : parameters.keySet()){
			
			if (key.contains("weight")) {
				layoutId = Integer.parseInt(key.replace("weight",""));
				weight = Double.parseDouble(StringUtil.merge(parameters.get(key)));
				displayLayout = displayLayoutList.get(layoutId);
				url = displayLayout.getUrl();
				status = displayLayout.getState();
				//Request requestToedit = lstRequestToEdit.get(url)
				if(status != RequestState.OLD_REQUEST){
					// if already exists in DB
					boolean alreadyExists = false;
					Request updatedRequest = null;
					if(displayLayout.isPrivateLayout()){
						alreadyExists = mapPrivateRequestToEdit.containsKey(url.trim());
						if(alreadyExists){
							updatedRequest = mapPrivateRequestToEdit.get(url);
						}
					}
					else{
						alreadyExists = mapPublicRequestToEdit.containsKey(url.trim());
						if(alreadyExists) {
							updatedRequest = mapPublicRequestToEdit.get(url);								
						}
					}
					
					if (alreadyExists && (updatedRequest.getWeight() != weight)){
						
						updatedRequest.setWeight(weight);
						// Saving ...
						final List<String> errors = RequestValidator.validateRequest(updatedRequest);
						if (errors.isEmpty()) {
							for (String error : errors) {
								SessionErrors.add(request, error);
							}
						} else {
							RequestLocalServiceUtil.updateRequest(updatedRequest);
							LOG.debug("request updated succefully");									
						}
					}

					// else Add new page
					else if (!alreadyExists) {
						if (LOG.isInfoEnabled()){
							LOG.info("add new request "+key+" : "+StringUtil.merge(parameters.get(key)));
						}
						final Layout layout = LayoutLocalServiceUtil.getLayout(groupId, displayLayout.getDisplayLayoutId().isPrivatePage(), 
								displayLayout.getDisplayLayoutId().getLayoutId());

						RequestLocalServiceUtil.addRequestFromLayout(layout, weight, idScenario, true, userId);
						LOG.debug("request created and added succefully ");
					}	
				}
				
				// if layout doesn't exist anymore
				else {
					if (LOG.isInfoEnabled()){
						LOG.info("delete request: "+key+" : "+StringUtil.merge(parameters.get(key)));
					}
					final long requestId =  displayLayout.getRequestId();
					RequestLocalServiceUtil.deleteRequest(requestId);
				}
				
			}
		}
		return scenarioToReturn;
	}

}