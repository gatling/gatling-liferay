/**
 * Copyright 2011-2015 GatlingCorp (http://gatling.io)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * 		http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.gatling.liferay.service.impl;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.model.Group;

import io.gatling.liferay.NoSuchScenarioException;
import io.gatling.liferay.model.ProcessScenarioLink;
import io.gatling.liferay.model.Scenario;
import io.gatling.liferay.model.Simulation;
import io.gatling.liferay.service.ScenarioLocalServiceUtil;
import io.gatling.liferay.service.base.ScenarioLocalServiceBaseImpl;
import io.gatling.liferay.service.persistence.ProcessScenarioLinkUtil;
import io.gatling.liferay.service.persistence.ScenarioUtil;
import io.gatling.liferay.util.GatlingUtil;

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

	public static final String DEFAULT_NAME = "Default Scenario";

	
	
	/**
	 * Creates the empty default scenario, persists it and returns it.
	 * @param simulation The simulation that contains the new scenario
	 * @param themeDisplay 
	 * @return The fresh default scenario
	 * @throws SystemException If an error occures in services
	 */
	@Override
	public Scenario createDefaultScenario(Simulation simulation) throws SystemException {
		try {
			return scenarioPersistence.findByName(DEFAULT_NAME);
		} catch (NoSuchScenarioException e) {
			return createScenario(DEFAULT_NAME, simulation.getSimulation_id(), "ramp Over", 100, 5);
		}
	}
	
	@Override
	public Scenario createScenario(String name, long simulationId, String injection, long numberOfUsers, long duration) throws SystemException{
		Scenario scenario = ScenarioUtil.create(CounterLocalServiceUtil.increment(Scenario.class.getName()));
		List<Group> listGroups = GatlingUtil.getListOfSites();
		if (listGroups.isEmpty()) {
			scenario.setGroup_id(0);
		}
		else {
			scenario.setGroup_id(listGroups.get(0).getGroupId());
		}
		scenario.setSimulation_id(simulationId);
		scenario.setInjection(injection);
		scenario.setNumberOfUsers(numberOfUsers);
		scenario.setDuration(duration);
		
		
		// TODO: find a another way to create scenario name
		// Used to generate unique scenario name
		if(!name.equals(DEFAULT_NAME)) {
			name += scenario.getScenario_id();
		}
		
		scenario.setName(name);
		
		scenario.persist();
		return scenario;
	}
	
	@Override
	public Scenario addScenario(String name, long simulationId) throws SystemException, NoSuchScenarioException{ {
		Scenario defaultScenario = ScenarioLocalServiceUtil.findBySimulationId(simulationId).get(0);
		return createScenario(name, simulationId, defaultScenario.getInjection(), defaultScenario.getNumberOfUsers(), defaultScenario.getDuration());
	}
	
	}
	@Override
	public void addProcess(long scenarioId, long processId, int order, int pause) throws SystemException{
		ProcessScenarioLink link = ProcessScenarioLinkUtil.create(CounterLocalServiceUtil.increment(ProcessScenarioLink.class.getName()));
		link.setScenario_id(scenarioId);
		link.setProcess_id(processId);
		link.setOrder(order);
		link.setPause(pause);
		link.persist();
	}
	
	
	@Override
	public int countBySimulationId(long simulationId) throws SystemException{
		return scenarioPersistence.countBySimulationId(simulationId);
	}
	
	@Override
	public List<Scenario> findBySimulationId(long simulationId) throws SystemException {
		return scenarioPersistence.findBySimulationId(simulationId);
	}

	/**
	 * Check if name is unique for {@link Scenario}
	 */
	public boolean isNameUnique(String name, long idSimulation) throws SystemException {
		final DynamicQuery dq = DynamicQueryFactoryUtil.forClass(Scenario.class)
				.add(PropertyFactoryUtil.forName("name").eq(name))
				.add(PropertyFactoryUtil.forName("simulation_id").eq(idSimulation));
		int result = (int) scenarioPersistence.countWithDynamicQuery(dq);
		return (result == 0);
	}
	
	/**
	 * Count how many {@link Scenario} have this variableName
	 */
	public int countByVariableName(String variableName, long idSimulation) throws SystemException {
		DynamicQuery dq = DynamicQueryFactoryUtil.forClass(Scenario.class)
				.add(PropertyFactoryUtil.forName("variableName").like(variableName+"%"))
				.add(PropertyFactoryUtil.forName("simulation_id").eq(idSimulation));

		return (int) scenarioPersistence.countWithDynamicQuery(dq);
	}

	/**
	 * get {@link Scenario} have this variableName
	 */
	@SuppressWarnings("unchecked")
	public List<Scenario> findByVariableName(String variableName, long idSimulation)  throws SystemException {
		DynamicQuery dq = DynamicQueryFactoryUtil.forClass(Scenario.class)
				.add(PropertyFactoryUtil.forName("variableName").like(variableName+"%"))
				.add(PropertyFactoryUtil.forName("simulation_id").eq(idSimulation));

		return scenarioPersistence.findWithDynamicQuery(dq);
	}

}