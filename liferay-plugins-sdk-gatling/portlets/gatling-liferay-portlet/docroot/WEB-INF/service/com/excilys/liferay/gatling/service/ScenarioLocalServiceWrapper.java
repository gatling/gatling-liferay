/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.excilys.liferay.gatling.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ScenarioLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ScenarioLocalService
 * @generated
 */
public class ScenarioLocalServiceWrapper implements ScenarioLocalService,
	ServiceWrapper<ScenarioLocalService> {
	public ScenarioLocalServiceWrapper(
		ScenarioLocalService scenarioLocalService) {
		_scenarioLocalService = scenarioLocalService;
	}

	/**
	* Adds the scenario to the database. Also notifies the appropriate model listeners.
	*
	* @param scenario the scenario
	* @return the scenario that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.excilys.liferay.gatling.model.Scenario addScenario(
		com.excilys.liferay.gatling.model.Scenario scenario)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _scenarioLocalService.addScenario(scenario);
	}

	/**
	* Creates a new scenario with the primary key. Does not add the scenario to the database.
	*
	* @param scenario_id the primary key for the new scenario
	* @return the new scenario
	*/
	@Override
	public com.excilys.liferay.gatling.model.Scenario createScenario(
		long scenario_id) {
		return _scenarioLocalService.createScenario(scenario_id);
	}

	/**
	* Deletes the scenario with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param scenario_id the primary key of the scenario
	* @return the scenario that was removed
	* @throws PortalException if a scenario with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.excilys.liferay.gatling.model.Scenario deleteScenario(
		long scenario_id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _scenarioLocalService.deleteScenario(scenario_id);
	}

	/**
	* Deletes the scenario from the database. Also notifies the appropriate model listeners.
	*
	* @param scenario the scenario
	* @return the scenario that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.excilys.liferay.gatling.model.Scenario deleteScenario(
		com.excilys.liferay.gatling.model.Scenario scenario)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _scenarioLocalService.deleteScenario(scenario);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _scenarioLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _scenarioLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.excilys.liferay.gatling.model.impl.ScenarioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _scenarioLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.excilys.liferay.gatling.model.impl.ScenarioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _scenarioLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _scenarioLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _scenarioLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.excilys.liferay.gatling.model.Scenario fetchScenario(
		long scenario_id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _scenarioLocalService.fetchScenario(scenario_id);
	}

	/**
	* Returns the scenario with the primary key.
	*
	* @param scenario_id the primary key of the scenario
	* @return the scenario
	* @throws PortalException if a scenario with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.excilys.liferay.gatling.model.Scenario getScenario(
		long scenario_id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _scenarioLocalService.getScenario(scenario_id);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _scenarioLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the scenarios.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.excilys.liferay.gatling.model.impl.ScenarioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of scenarios
	* @param end the upper bound of the range of scenarios (not inclusive)
	* @return the range of scenarios
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.excilys.liferay.gatling.model.Scenario> getScenarios(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _scenarioLocalService.getScenarios(start, end);
	}

	/**
	* Returns the number of scenarios.
	*
	* @return the number of scenarios
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getScenariosCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _scenarioLocalService.getScenariosCount();
	}

	/**
	* Updates the scenario in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param scenario the scenario
	* @return the scenario that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.excilys.liferay.gatling.model.Scenario updateScenario(
		com.excilys.liferay.gatling.model.Scenario scenario)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _scenarioLocalService.updateScenario(scenario);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _scenarioLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_scenarioLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _scenarioLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public int countBySimulationId(long simulationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _scenarioLocalService.countBySimulationId(simulationId);
	}

	@Override
	public java.util.List<com.excilys.liferay.gatling.model.Scenario> findBySimulationId(
		long simulationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _scenarioLocalService.findBySimulationId(simulationId);
	}

	/**
	* Remove all {@link Scenario} (and children) for a given simulationId
	*/
	@Override
	public void removeBySimulationIdCascade(long simulationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		_scenarioLocalService.removeBySimulationIdCascade(simulationId);
	}

	/**
	* Remove all {@link Request} for a scenarioId
	*/
	@Override
	public void removeByIdCascade(long scenarioId)
		throws com.excilys.liferay.gatling.NoSuchScenarioException,
			com.liferay.portal.kernel.exception.SystemException {
		_scenarioLocalService.removeByIdCascade(scenarioId);
	}

	/**
	* Check if name is unique for {@link Scenario}
	*/
	@Override
	public boolean isNameUnique(java.lang.String name, long idSimulation)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _scenarioLocalService.isNameUnique(name, idSimulation);
	}

	/**
	* Count how many {@link Scenario} have this variableName
	*/
	@Override
	public int countByVariableName(java.lang.String variableName,
		long idSimulation)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _scenarioLocalService.countByVariableName(variableName,
			idSimulation);
	}

	/**
	* get {@link Scenario} have this variableName
	*/
	@Override
	public java.util.List<com.excilys.liferay.gatling.model.Scenario> findByVariableName(
		java.lang.String variableName, long idSimulation)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _scenarioLocalService.findByVariableName(variableName,
			idSimulation);
	}

	/**
	* Add a {@link Scenario} from an {@link ActionRequest}
	*
	* @param {@link ActionRequest} request
	* @param {@link ActionResponse} response
	* @return {@link Scenario} if added, else null
	* @throws SystemException
	*/
	@Override
	public com.excilys.liferay.gatling.model.Scenario addScenarioFromRequest(
		javax.portlet.ActionRequest request)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _scenarioLocalService.addScenarioFromRequest(request);
	}

	/**
	* Edit a {@link Scenario} from an {@link ActionRequest}
	*
	* @param {@link ActionRequest} request
	* @param {@link ActionResponse} response
	* @return {@link Scenario} if added, else null
	* @throws SystemException
	*/
	@Override
	public com.excilys.liferay.gatling.model.Scenario editScenarioFromRequest(
		javax.portlet.ActionRequest request)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _scenarioLocalService.editScenarioFromRequest(request);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ScenarioLocalService getWrappedScenarioLocalService() {
		return _scenarioLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedScenarioLocalService(
		ScenarioLocalService scenarioLocalService) {
		_scenarioLocalService = scenarioLocalService;
	}

	@Override
	public ScenarioLocalService getWrappedService() {
		return _scenarioLocalService;
	}

	@Override
	public void setWrappedService(ScenarioLocalService scenarioLocalService) {
		_scenarioLocalService = scenarioLocalService;
	}

	private ScenarioLocalService _scenarioLocalService;
}