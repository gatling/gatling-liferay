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

package com.liferay.sample.service.impl;

import com.excilys.liferay.gatling.util.GatlingUtil;
import com.excilys.liferay.gatling.validator.SimulationValidator;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.sample.model.Simulation;
import com.liferay.sample.service.ScenarioLocalServiceUtil;
import com.liferay.sample.service.SimulationLocalServiceUtil;
import com.liferay.sample.service.base.SimulationLocalServiceBaseImpl;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

/**
 * The implementation of the simulation local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.sample.service.SimulationLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author sana
 * @see com.liferay.sample.service.base.SimulationLocalServiceBaseImpl
 * @see com.liferay.sample.service.SimulationLocalServiceUtil
 */
public class SimulationLocalServiceImpl extends SimulationLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.liferay.sample.service.SimulationLocalServiceUtil} to access the simulation local service.
	 */
	
	public void removeSimulationCascade(Long simulationId) throws SystemException {
		ScenarioLocalServiceUtil.removeBySimulationIdCascade(simulationId);
		try {
			simulationPersistence.remove(simulationId);
		} catch (NoSuchModelException e) {
			e.printStackTrace();
		}
	}
	
	public boolean isNameUnique(String name) {
		DynamicQuery dq = DynamicQueryFactoryUtil.forClass(Simulation.class)
				.add(PropertyFactoryUtil.forName("name").eq(name));

		List<?> result;
		try {
			result = simulationPersistence.findWithDynamicQuery(dq);
			return result.isEmpty();
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public List<Simulation> findByVariableName(String variableName) {
		DynamicQuery dq = DynamicQueryFactoryUtil.forClass(Simulation.class)
				.add(PropertyFactoryUtil.forName("variableName").like(variableName+"%"));

		List<Simulation> result = new ArrayList<Simulation>();
		try {
			result = simulationPersistence.findWithDynamicQuery(dq);
			return result;
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * Add a scenario from request
	 * @param request
	 * @param response
	 * @return Simulation if added, else null
	 * @throws SystemException
	 */
	public Simulation addSimulationFromRequest(ActionRequest request, ActionResponse response) throws SystemException {
		/*
		 * Create simulation
		 */
		long primaryKey = CounterLocalServiceUtil.increment(Simulation.class.getName());	
		Simulation simulation = SimulationLocalServiceUtil.createSimulation(primaryKey);
		simulation.setName(ParamUtil.getString(request, "simulationName"));
		/*
		 *  Set Variable Name
		 */
		String variableName = GatlingUtil.createVariableName("simulation", ParamUtil.getString(request, "variableName"));
		List<Simulation> listVar = SimulationLocalServiceUtil.findByVariableName(variableName);
		// Test if the variable name already exists
		if(!listVar.isEmpty() ) {
			variableName = variableName.concat(Integer.toString(listVar.size()));
		}
		simulation.setVariableName(variableName);
		/*
		 *  Validator Simulation Fields
		 */
		List<String> errors = new ArrayList<String>();
		if(SimulationValidator.validateSimulation(simulation, errors)) {
			ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
			Long userId = themeDisplay.getUserId();
			// Add scenario
			return SimulationLocalServiceUtil.addSimulation(simulation);
			
		}
		else {
			for(String error : errors) {
				SessionErrors.add(request, error);
			}
		}
		return null;
		
	}
}