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

import java.util.List;

import javax.portlet.ActionRequest;

import com.excilys.liferay.gatling.model.Request;
import com.excilys.liferay.gatling.model.Scenario;
import com.excilys.liferay.gatling.model.Simulation;
import com.excilys.liferay.gatling.service.RequestLocalServiceUtil;
import com.excilys.liferay.gatling.service.ScenarioLocalServiceUtil;
import com.excilys.liferay.gatling.service.base.SimulationLocalServiceBaseImpl;
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

	private static final Log LOG = LogFactoryUtil.getLog(SimulationLocalServiceImpl.class);
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.liferay.sample.service.SimulationLocalServiceUtil} to access the simulation local service.
	 */

	/**
	 * remove all {@link Scenario} linked to a simulationId and the simulation
	 */
	@Override
	public void removeSimulationCascade(final Long simulationId) throws SystemException, NoSuchModelException {
		ScenarioLocalServiceUtil.removeBySimulationIdCascade(simulationId);
		simulationPersistence.remove(simulationId);
	}

	/**
	 * Check if name is unique for {@link Simulation}
	 */
	@Override
	public boolean isNameUnique(final String name) throws SystemException {
		final DynamicQuery dq = DynamicQueryFactoryUtil.forClass(Simulation.class)
				.add(PropertyFactoryUtil.forName("name").eq(name));

		final long count = simulationPersistence.countWithDynamicQuery(dq);
		return count == 0;
	}

	/**
	 * Add a {@link Simulation} from an {@link ActionRequest}
	 * @param {@link ActionRequest} request
	 * @return {@link Simulation} if added, else null
	 * @throws SystemException
	 */
	@Override
	public Simulation addSimulationFromRequest(final ActionRequest request) throws SystemException  {
		/*
		 * Create simulation
		 */
		final long primaryKey = CounterLocalServiceUtil.increment(Simulation.class.getName());
		final Simulation simulation = simulationPersistence.create(primaryKey);
		final String simuName = ParamUtil.getString(request, "simulationName");
		LOG.info("simulation Name : "+simuName);
		simulation.setName(simuName);
		/*
		 *  Validator Simulation Fields
		 */
		final List<String> errors = SimulationValidator.validateSimulation(simulation);
		if(errors.isEmpty()) {
			simulation.persist();
			return simulation;
		}
		else {
			for(final String error : errors) {
				SessionErrors.add(request, error);
			}
			return null;
		}

	}

	@Override
	public boolean containsPrivatePage(final long simulationId) throws SystemException {
		for ( final Scenario scenario : ScenarioLocalServiceUtil.findBySimulationId(simulationId)) {
			for (final Request request : RequestLocalServiceUtil.findByScenarioId(scenario.getScenario_id())) {
				if (request.getPrivatePage()) {
					return true;
				}
			}
		}

		return false;
	}
}