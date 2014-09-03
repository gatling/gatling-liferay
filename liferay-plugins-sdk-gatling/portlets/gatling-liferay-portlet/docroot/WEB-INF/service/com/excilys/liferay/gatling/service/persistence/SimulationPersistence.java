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

import com.excilys.liferay.gatling.model.Simulation;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the simulation service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SimulationPersistenceImpl
 * @see SimulationUtil
 * @generated
 */
public interface SimulationPersistence extends BasePersistence<Simulation> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SimulationUtil} to access the simulation persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the simulations where variableName = &#63;.
	*
	* @param variableName the variable name
	* @return the matching simulations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.excilys.liferay.gatling.model.Simulation> findByVariableName(
		java.lang.String variableName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the simulations where variableName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.excilys.liferay.gatling.model.impl.SimulationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param variableName the variable name
	* @param start the lower bound of the range of simulations
	* @param end the upper bound of the range of simulations (not inclusive)
	* @return the range of matching simulations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.excilys.liferay.gatling.model.Simulation> findByVariableName(
		java.lang.String variableName, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the simulations where variableName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.excilys.liferay.gatling.model.impl.SimulationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param variableName the variable name
	* @param start the lower bound of the range of simulations
	* @param end the upper bound of the range of simulations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching simulations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.excilys.liferay.gatling.model.Simulation> findByVariableName(
		java.lang.String variableName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first simulation in the ordered set where variableName = &#63;.
	*
	* @param variableName the variable name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching simulation
	* @throws com.excilys.liferay.gatling.NoSuchSimulationException if a matching simulation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.excilys.liferay.gatling.model.Simulation findByVariableName_First(
		java.lang.String variableName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.excilys.liferay.gatling.NoSuchSimulationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first simulation in the ordered set where variableName = &#63;.
	*
	* @param variableName the variable name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching simulation, or <code>null</code> if a matching simulation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.excilys.liferay.gatling.model.Simulation fetchByVariableName_First(
		java.lang.String variableName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last simulation in the ordered set where variableName = &#63;.
	*
	* @param variableName the variable name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching simulation
	* @throws com.excilys.liferay.gatling.NoSuchSimulationException if a matching simulation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.excilys.liferay.gatling.model.Simulation findByVariableName_Last(
		java.lang.String variableName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.excilys.liferay.gatling.NoSuchSimulationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last simulation in the ordered set where variableName = &#63;.
	*
	* @param variableName the variable name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching simulation, or <code>null</code> if a matching simulation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.excilys.liferay.gatling.model.Simulation fetchByVariableName_Last(
		java.lang.String variableName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the simulations before and after the current simulation in the ordered set where variableName = &#63;.
	*
	* @param simulation_id the primary key of the current simulation
	* @param variableName the variable name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next simulation
	* @throws com.excilys.liferay.gatling.NoSuchSimulationException if a simulation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.excilys.liferay.gatling.model.Simulation[] findByVariableName_PrevAndNext(
		long simulation_id, java.lang.String variableName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.excilys.liferay.gatling.NoSuchSimulationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the simulations where variableName = &#63; from the database.
	*
	* @param variableName the variable name
	* @throws SystemException if a system exception occurred
	*/
	public void removeByVariableName(java.lang.String variableName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of simulations where variableName = &#63;.
	*
	* @param variableName the variable name
	* @return the number of matching simulations
	* @throws SystemException if a system exception occurred
	*/
	public int countByVariableName(java.lang.String variableName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the simulation in the entity cache if it is enabled.
	*
	* @param simulation the simulation
	*/
	public void cacheResult(
		com.excilys.liferay.gatling.model.Simulation simulation);

	/**
	* Caches the simulations in the entity cache if it is enabled.
	*
	* @param simulations the simulations
	*/
	public void cacheResult(
		java.util.List<com.excilys.liferay.gatling.model.Simulation> simulations);

	/**
	* Creates a new simulation with the primary key. Does not add the simulation to the database.
	*
	* @param simulation_id the primary key for the new simulation
	* @return the new simulation
	*/
	public com.excilys.liferay.gatling.model.Simulation create(
		long simulation_id);

	/**
	* Removes the simulation with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param simulation_id the primary key of the simulation
	* @return the simulation that was removed
	* @throws com.excilys.liferay.gatling.NoSuchSimulationException if a simulation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.excilys.liferay.gatling.model.Simulation remove(
		long simulation_id)
		throws com.excilys.liferay.gatling.NoSuchSimulationException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.excilys.liferay.gatling.model.Simulation updateImpl(
		com.excilys.liferay.gatling.model.Simulation simulation)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the simulation with the primary key or throws a {@link com.excilys.liferay.gatling.NoSuchSimulationException} if it could not be found.
	*
	* @param simulation_id the primary key of the simulation
	* @return the simulation
	* @throws com.excilys.liferay.gatling.NoSuchSimulationException if a simulation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.excilys.liferay.gatling.model.Simulation findByPrimaryKey(
		long simulation_id)
		throws com.excilys.liferay.gatling.NoSuchSimulationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the simulation with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param simulation_id the primary key of the simulation
	* @return the simulation, or <code>null</code> if a simulation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.excilys.liferay.gatling.model.Simulation fetchByPrimaryKey(
		long simulation_id)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the simulations.
	*
	* @return the simulations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.excilys.liferay.gatling.model.Simulation> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the simulations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.excilys.liferay.gatling.model.impl.SimulationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of simulations
	* @param end the upper bound of the range of simulations (not inclusive)
	* @return the range of simulations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.excilys.liferay.gatling.model.Simulation> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the simulations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.excilys.liferay.gatling.model.impl.SimulationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of simulations
	* @param end the upper bound of the range of simulations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of simulations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.excilys.liferay.gatling.model.Simulation> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the simulations from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of simulations.
	*
	* @return the number of simulations
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}