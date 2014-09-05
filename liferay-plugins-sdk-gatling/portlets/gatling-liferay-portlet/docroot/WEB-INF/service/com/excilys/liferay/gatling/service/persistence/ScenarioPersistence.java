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

package com.excilys.liferay.gatling.service.persistence;

import com.excilys.liferay.gatling.model.Scenario;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the scenario service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ScenarioPersistenceImpl
 * @see ScenarioUtil
 * @generated
 */
public interface ScenarioPersistence extends BasePersistence<Scenario> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ScenarioUtil} to access the scenario persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the scenarios where simulation_id = &#63;.
	*
	* @param simulation_id the simulation_id
	* @return the matching scenarios
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.excilys.liferay.gatling.model.Scenario> findBySimulationId(
		long simulation_id)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the scenarios where simulation_id = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.excilys.liferay.gatling.model.impl.ScenarioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param simulation_id the simulation_id
	* @param start the lower bound of the range of scenarios
	* @param end the upper bound of the range of scenarios (not inclusive)
	* @return the range of matching scenarios
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.excilys.liferay.gatling.model.Scenario> findBySimulationId(
		long simulation_id, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the scenarios where simulation_id = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.excilys.liferay.gatling.model.impl.ScenarioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param simulation_id the simulation_id
	* @param start the lower bound of the range of scenarios
	* @param end the upper bound of the range of scenarios (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching scenarios
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.excilys.liferay.gatling.model.Scenario> findBySimulationId(
		long simulation_id, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first scenario in the ordered set where simulation_id = &#63;.
	*
	* @param simulation_id the simulation_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching scenario
	* @throws com.excilys.liferay.gatling.NoSuchScenarioException if a matching scenario could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.excilys.liferay.gatling.model.Scenario findBySimulationId_First(
		long simulation_id,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.excilys.liferay.gatling.NoSuchScenarioException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first scenario in the ordered set where simulation_id = &#63;.
	*
	* @param simulation_id the simulation_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching scenario, or <code>null</code> if a matching scenario could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.excilys.liferay.gatling.model.Scenario fetchBySimulationId_First(
		long simulation_id,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last scenario in the ordered set where simulation_id = &#63;.
	*
	* @param simulation_id the simulation_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching scenario
	* @throws com.excilys.liferay.gatling.NoSuchScenarioException if a matching scenario could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.excilys.liferay.gatling.model.Scenario findBySimulationId_Last(
		long simulation_id,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.excilys.liferay.gatling.NoSuchScenarioException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last scenario in the ordered set where simulation_id = &#63;.
	*
	* @param simulation_id the simulation_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching scenario, or <code>null</code> if a matching scenario could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.excilys.liferay.gatling.model.Scenario fetchBySimulationId_Last(
		long simulation_id,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the scenarios before and after the current scenario in the ordered set where simulation_id = &#63;.
	*
	* @param scenario_id the primary key of the current scenario
	* @param simulation_id the simulation_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next scenario
	* @throws com.excilys.liferay.gatling.NoSuchScenarioException if a scenario with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.excilys.liferay.gatling.model.Scenario[] findBySimulationId_PrevAndNext(
		long scenario_id, long simulation_id,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.excilys.liferay.gatling.NoSuchScenarioException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the scenarios where simulation_id = &#63; from the database.
	*
	* @param simulation_id the simulation_id
	* @throws SystemException if a system exception occurred
	*/
	public void removeBySimulationId(long simulation_id)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of scenarios where simulation_id = &#63;.
	*
	* @param simulation_id the simulation_id
	* @return the number of matching scenarios
	* @throws SystemException if a system exception occurred
	*/
	public int countBySimulationId(long simulation_id)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the scenarios where variableName = &#63; and simulation_id = &#63;.
	*
	* @param variableName the variable name
	* @param simulation_id the simulation_id
	* @return the matching scenarios
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.excilys.liferay.gatling.model.Scenario> findByVariableName(
		java.lang.String variableName, long simulation_id)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the scenarios where variableName = &#63; and simulation_id = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.excilys.liferay.gatling.model.impl.ScenarioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param variableName the variable name
	* @param simulation_id the simulation_id
	* @param start the lower bound of the range of scenarios
	* @param end the upper bound of the range of scenarios (not inclusive)
	* @return the range of matching scenarios
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.excilys.liferay.gatling.model.Scenario> findByVariableName(
		java.lang.String variableName, long simulation_id, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the scenarios where variableName = &#63; and simulation_id = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.excilys.liferay.gatling.model.impl.ScenarioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param variableName the variable name
	* @param simulation_id the simulation_id
	* @param start the lower bound of the range of scenarios
	* @param end the upper bound of the range of scenarios (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching scenarios
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.excilys.liferay.gatling.model.Scenario> findByVariableName(
		java.lang.String variableName, long simulation_id, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first scenario in the ordered set where variableName = &#63; and simulation_id = &#63;.
	*
	* @param variableName the variable name
	* @param simulation_id the simulation_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching scenario
	* @throws com.excilys.liferay.gatling.NoSuchScenarioException if a matching scenario could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.excilys.liferay.gatling.model.Scenario findByVariableName_First(
		java.lang.String variableName, long simulation_id,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.excilys.liferay.gatling.NoSuchScenarioException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first scenario in the ordered set where variableName = &#63; and simulation_id = &#63;.
	*
	* @param variableName the variable name
	* @param simulation_id the simulation_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching scenario, or <code>null</code> if a matching scenario could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.excilys.liferay.gatling.model.Scenario fetchByVariableName_First(
		java.lang.String variableName, long simulation_id,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last scenario in the ordered set where variableName = &#63; and simulation_id = &#63;.
	*
	* @param variableName the variable name
	* @param simulation_id the simulation_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching scenario
	* @throws com.excilys.liferay.gatling.NoSuchScenarioException if a matching scenario could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.excilys.liferay.gatling.model.Scenario findByVariableName_Last(
		java.lang.String variableName, long simulation_id,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.excilys.liferay.gatling.NoSuchScenarioException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last scenario in the ordered set where variableName = &#63; and simulation_id = &#63;.
	*
	* @param variableName the variable name
	* @param simulation_id the simulation_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching scenario, or <code>null</code> if a matching scenario could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.excilys.liferay.gatling.model.Scenario fetchByVariableName_Last(
		java.lang.String variableName, long simulation_id,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the scenarios before and after the current scenario in the ordered set where variableName = &#63; and simulation_id = &#63;.
	*
	* @param scenario_id the primary key of the current scenario
	* @param variableName the variable name
	* @param simulation_id the simulation_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next scenario
	* @throws com.excilys.liferay.gatling.NoSuchScenarioException if a scenario with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.excilys.liferay.gatling.model.Scenario[] findByVariableName_PrevAndNext(
		long scenario_id, java.lang.String variableName, long simulation_id,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.excilys.liferay.gatling.NoSuchScenarioException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the scenarios where variableName = &#63; and simulation_id = &#63; from the database.
	*
	* @param variableName the variable name
	* @param simulation_id the simulation_id
	* @throws SystemException if a system exception occurred
	*/
	public void removeByVariableName(java.lang.String variableName,
		long simulation_id)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of scenarios where variableName = &#63; and simulation_id = &#63;.
	*
	* @param variableName the variable name
	* @param simulation_id the simulation_id
	* @return the number of matching scenarios
	* @throws SystemException if a system exception occurred
	*/
	public int countByVariableName(java.lang.String variableName,
		long simulation_id)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the scenario in the entity cache if it is enabled.
	*
	* @param scenario the scenario
	*/
	public void cacheResult(com.excilys.liferay.gatling.model.Scenario scenario);

	/**
	* Caches the scenarios in the entity cache if it is enabled.
	*
	* @param scenarios the scenarios
	*/
	public void cacheResult(
		java.util.List<com.excilys.liferay.gatling.model.Scenario> scenarios);

	/**
	* Creates a new scenario with the primary key. Does not add the scenario to the database.
	*
	* @param scenario_id the primary key for the new scenario
	* @return the new scenario
	*/
	public com.excilys.liferay.gatling.model.Scenario create(long scenario_id);

	/**
	* Removes the scenario with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param scenario_id the primary key of the scenario
	* @return the scenario that was removed
	* @throws com.excilys.liferay.gatling.NoSuchScenarioException if a scenario with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.excilys.liferay.gatling.model.Scenario remove(long scenario_id)
		throws com.excilys.liferay.gatling.NoSuchScenarioException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.excilys.liferay.gatling.model.Scenario updateImpl(
		com.excilys.liferay.gatling.model.Scenario scenario)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the scenario with the primary key or throws a {@link com.excilys.liferay.gatling.NoSuchScenarioException} if it could not be found.
	*
	* @param scenario_id the primary key of the scenario
	* @return the scenario
	* @throws com.excilys.liferay.gatling.NoSuchScenarioException if a scenario with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.excilys.liferay.gatling.model.Scenario findByPrimaryKey(
		long scenario_id)
		throws com.excilys.liferay.gatling.NoSuchScenarioException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the scenario with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param scenario_id the primary key of the scenario
	* @return the scenario, or <code>null</code> if a scenario with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.excilys.liferay.gatling.model.Scenario fetchByPrimaryKey(
		long scenario_id)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the scenarios.
	*
	* @return the scenarios
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.excilys.liferay.gatling.model.Scenario> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.excilys.liferay.gatling.model.Scenario> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the scenarios.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.excilys.liferay.gatling.model.impl.ScenarioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of scenarios
	* @param end the upper bound of the range of scenarios (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of scenarios
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.excilys.liferay.gatling.model.Scenario> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the scenarios from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of scenarios.
	*
	* @return the number of scenarios
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}