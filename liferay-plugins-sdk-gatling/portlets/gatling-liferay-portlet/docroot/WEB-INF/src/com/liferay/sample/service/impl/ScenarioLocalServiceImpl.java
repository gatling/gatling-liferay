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

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.sample.NoSuchScenarioException;
import com.liferay.sample.model.Scenario;
import com.liferay.sample.service.RequestLocalServiceUtil;
import com.liferay.sample.service.ScenarioLocalServiceUtil;
import com.liferay.sample.service.base.ScenarioLocalServiceBaseImpl;

import java.util.ArrayList;
import java.util.List;

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
 * @author sana
 * @see com.liferay.sample.service.base.ScenarioLocalServiceBaseImpl
 * @see com.liferay.sample.service.ScenarioLocalServiceUtil
 */
public class ScenarioLocalServiceImpl extends ScenarioLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.liferay.sample.service.ScenarioLocalServiceUtil} to access the scenario local service.
	 */
	
	
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
}