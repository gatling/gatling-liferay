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

import com.excilys.liferay.gatling.model.LinkUsecaseScenario;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the link usecase scenario service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LinkUsecaseScenarioPersistenceImpl
 * @see LinkUsecaseScenarioUtil
 * @generated
 */
public interface LinkUsecaseScenarioPersistence extends BasePersistence<LinkUsecaseScenario> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LinkUsecaseScenarioUtil} to access the link usecase scenario persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the link usecase scenario in the entity cache if it is enabled.
	*
	* @param linkUsecaseScenario the link usecase scenario
	*/
	public void cacheResult(
		com.excilys.liferay.gatling.model.LinkUsecaseScenario linkUsecaseScenario);

	/**
	* Caches the link usecase scenarios in the entity cache if it is enabled.
	*
	* @param linkUsecaseScenarios the link usecase scenarios
	*/
	public void cacheResult(
		java.util.List<com.excilys.liferay.gatling.model.LinkUsecaseScenario> linkUsecaseScenarios);

	/**
	* Creates a new link usecase scenario with the primary key. Does not add the link usecase scenario to the database.
	*
	* @param linkUsecaseScenarioPK the primary key for the new link usecase scenario
	* @return the new link usecase scenario
	*/
	public com.excilys.liferay.gatling.model.LinkUsecaseScenario create(
		LinkUsecaseScenarioPK linkUsecaseScenarioPK);

	/**
	* Removes the link usecase scenario with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param linkUsecaseScenarioPK the primary key of the link usecase scenario
	* @return the link usecase scenario that was removed
	* @throws com.excilys.liferay.gatling.NoSuchLinkUsecaseScenarioException if a link usecase scenario with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.excilys.liferay.gatling.model.LinkUsecaseScenario remove(
		LinkUsecaseScenarioPK linkUsecaseScenarioPK)
		throws com.excilys.liferay.gatling.NoSuchLinkUsecaseScenarioException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.excilys.liferay.gatling.model.LinkUsecaseScenario updateImpl(
		com.excilys.liferay.gatling.model.LinkUsecaseScenario linkUsecaseScenario)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the link usecase scenario with the primary key or throws a {@link com.excilys.liferay.gatling.NoSuchLinkUsecaseScenarioException} if it could not be found.
	*
	* @param linkUsecaseScenarioPK the primary key of the link usecase scenario
	* @return the link usecase scenario
	* @throws com.excilys.liferay.gatling.NoSuchLinkUsecaseScenarioException if a link usecase scenario with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.excilys.liferay.gatling.model.LinkUsecaseScenario findByPrimaryKey(
		LinkUsecaseScenarioPK linkUsecaseScenarioPK)
		throws com.excilys.liferay.gatling.NoSuchLinkUsecaseScenarioException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the link usecase scenario with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param linkUsecaseScenarioPK the primary key of the link usecase scenario
	* @return the link usecase scenario, or <code>null</code> if a link usecase scenario with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.excilys.liferay.gatling.model.LinkUsecaseScenario fetchByPrimaryKey(
		LinkUsecaseScenarioPK linkUsecaseScenarioPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the link usecase scenarios.
	*
	* @return the link usecase scenarios
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.excilys.liferay.gatling.model.LinkUsecaseScenario> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the link usecase scenarios.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.excilys.liferay.gatling.model.impl.LinkUsecaseScenarioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of link usecase scenarios
	* @param end the upper bound of the range of link usecase scenarios (not inclusive)
	* @return the range of link usecase scenarios
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.excilys.liferay.gatling.model.LinkUsecaseScenario> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the link usecase scenarios.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.excilys.liferay.gatling.model.impl.LinkUsecaseScenarioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of link usecase scenarios
	* @param end the upper bound of the range of link usecase scenarios (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of link usecase scenarios
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.excilys.liferay.gatling.model.LinkUsecaseScenario> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the link usecase scenarios from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of link usecase scenarios.
	*
	* @return the number of link usecase scenarios
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}