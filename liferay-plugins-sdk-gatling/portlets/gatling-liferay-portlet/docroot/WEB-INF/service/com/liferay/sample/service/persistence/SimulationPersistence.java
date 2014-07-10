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

package com.liferay.sample.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import com.liferay.sample.model.Simulation;

/**
 * The persistence interface for the simulation service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author sana
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
	* Caches the simulation in the entity cache if it is enabled.
	*
	* @param simulation the simulation
	*/
	public void cacheResult(com.liferay.sample.model.Simulation simulation);

	/**
	* Caches the simulations in the entity cache if it is enabled.
	*
	* @param simulations the simulations
	*/
	public void cacheResult(
		java.util.List<com.liferay.sample.model.Simulation> simulations);

	/**
	* Creates a new simulation with the primary key. Does not add the simulation to the database.
	*
	* @param simulation_id the primary key for the new simulation
	* @return the new simulation
	*/
	public com.liferay.sample.model.Simulation create(long simulation_id);

	/**
	* Removes the simulation with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param simulation_id the primary key of the simulation
	* @return the simulation that was removed
	* @throws com.liferay.sample.NoSuchSimulationException if a simulation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.sample.model.Simulation remove(long simulation_id)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.sample.NoSuchSimulationException;

	public com.liferay.sample.model.Simulation updateImpl(
		com.liferay.sample.model.Simulation simulation)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the simulation with the primary key or throws a {@link com.liferay.sample.NoSuchSimulationException} if it could not be found.
	*
	* @param simulation_id the primary key of the simulation
	* @return the simulation
	* @throws com.liferay.sample.NoSuchSimulationException if a simulation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.sample.model.Simulation findByPrimaryKey(
		long simulation_id)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.sample.NoSuchSimulationException;

	/**
	* Returns the simulation with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param simulation_id the primary key of the simulation
	* @return the simulation, or <code>null</code> if a simulation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.sample.model.Simulation fetchByPrimaryKey(
		long simulation_id)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the simulations.
	*
	* @return the simulations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.sample.model.Simulation> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the simulations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.sample.model.impl.SimulationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of simulations
	* @param end the upper bound of the range of simulations (not inclusive)
	* @return the range of simulations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.sample.model.Simulation> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the simulations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.sample.model.impl.SimulationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of simulations
	* @param end the upper bound of the range of simulations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of simulations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.sample.model.Simulation> findAll(
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