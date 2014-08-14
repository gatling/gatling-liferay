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

import com.excilys.liferay.gatling.model.Scenario;
import com.excilys.liferay.gatling.model.Simulation;
import com.excilys.liferay.gatling.service.ScenarioLocalServiceUtil;
import com.excilys.liferay.gatling.service.SimulationLocalServiceUtil;
import com.excilys.liferay.gatling.service.base.SimulationLocalServiceBaseImpl;
import com.excilys.liferay.gatling.util.GatlingUtil;
import com.excilys.liferay.gatling.validator.SimulationValidator;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;

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
 * @see com.liferay.sample.service.base.SimulationLocalServiceBaseImpl
 * @see com.liferay.sample.service.SimulationLocalServiceUtil
 */
public class SimulationLocalServiceImpl extends SimulationLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.liferay.sample.service.SimulationLocalServiceUtil} to access the simulation local service.
	 */
	private static final Log LOG = LogFactoryUtil.getLog(SimulationLocalServiceUtil.class);

	/**
	 * remove all {@link Scenario} linked to a simulationId and the simulation
	 */
	public void removeSimulationCascade(Long simulationId) throws SystemException, NoSuchModelException {
		ScenarioLocalServiceUtil.removeBySimulationIdCascade(simulationId);
		simulationPersistence.remove(simulationId);
	}

	/**
	 * Check if name is unique for {@link Simulation}
	 */
	public boolean isNameUnique(String name) throws SystemException {
		final DynamicQuery dq = DynamicQueryFactoryUtil.forClass(Simulation.class)
				.add(PropertyFactoryUtil.forName("name").eq(name));

		final long count = simulationPersistence.countWithDynamicQuery(dq);
		return (count == 0);
	}

	/**
	 * Count how many {@link Simulation} have this variableName
	 */
	public int countByVariableName(String variableName) throws SystemException {
		final DynamicQuery dq = DynamicQueryFactoryUtil.forClass(Simulation.class)
				.add(PropertyFactoryUtil.forName("variableName").like(variableName+"%"));

		return (int) simulationPersistence.countWithDynamicQuery(dq);
	}

	/**
	 * Add a {@link Simulation} from an {@link ActionRequest}
	 * @param {@link ActionRequest} request
	 * @param {@link ActionResponse} response
	 * @return {@link Simulation} if added, else null
	 * @throws SystemException
	 */
	public Simulation addSimulationFromRequest(ActionRequest request) throws SystemException  {
		/*
		 * Create simulation
		 */
		long primaryKey = CounterLocalServiceUtil.increment(Simulation.class.getName());
		Simulation simulation = SimulationLocalServiceUtil.createSimulation(primaryKey);
		simulation.setName(ParamUtil.getString(request, "simulationName"));
		/*
		 *  Set Variable Name
		 */
		String variableName = GatlingUtil.createVariableName("Simulation", ParamUtil.getString(request, "simulationName"));
		final int count = SimulationLocalServiceUtil.countByVariableName(variableName);
		// Test if the variable name already exists
		if(count != 0) {
			// Add a number at the end to make it unique
			variableName = variableName.concat(Integer.toString(count));
		}
		simulation.setVariableName(variableName);
		/*
		 *  Validator Simulation Fields
		 */
		List<String> errors = SimulationValidator.validateSimulation(simulation);
		if(errors.isEmpty()) {
			// Add scenario
			simulation = SimulationLocalServiceUtil.addSimulation(simulation);
			LOG.info(simulation);
			return simulation;
		}
		else {
			for(String error : errors) {
				SessionErrors.add(request, error);
			}
		}
		return null;

	}
}