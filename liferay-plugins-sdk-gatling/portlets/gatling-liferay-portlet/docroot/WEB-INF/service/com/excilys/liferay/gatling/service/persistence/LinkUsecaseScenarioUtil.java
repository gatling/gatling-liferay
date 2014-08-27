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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the link usecase scenario service. This utility wraps {@link LinkUsecaseScenarioPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LinkUsecaseScenarioPersistence
 * @see LinkUsecaseScenarioPersistenceImpl
 * @generated
 */
public class LinkUsecaseScenarioUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(LinkUsecaseScenario linkUsecaseScenario) {
		getPersistence().clearCache(linkUsecaseScenario);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<LinkUsecaseScenario> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<LinkUsecaseScenario> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<LinkUsecaseScenario> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static LinkUsecaseScenario update(
		LinkUsecaseScenario linkUsecaseScenario) throws SystemException {
		return getPersistence().update(linkUsecaseScenario);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static LinkUsecaseScenario update(
		LinkUsecaseScenario linkUsecaseScenario, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(linkUsecaseScenario, serviceContext);
	}

	/**
	* Caches the link usecase scenario in the entity cache if it is enabled.
	*
	* @param linkUsecaseScenario the link usecase scenario
	*/
	public static void cacheResult(
		com.excilys.liferay.gatling.model.LinkUsecaseScenario linkUsecaseScenario) {
		getPersistence().cacheResult(linkUsecaseScenario);
	}

	/**
	* Caches the link usecase scenarios in the entity cache if it is enabled.
	*
	* @param linkUsecaseScenarios the link usecase scenarios
	*/
	public static void cacheResult(
		java.util.List<com.excilys.liferay.gatling.model.LinkUsecaseScenario> linkUsecaseScenarios) {
		getPersistence().cacheResult(linkUsecaseScenarios);
	}

	/**
	* Creates a new link usecase scenario with the primary key. Does not add the link usecase scenario to the database.
	*
	* @param linkUsecaseScenarioPK the primary key for the new link usecase scenario
	* @return the new link usecase scenario
	*/
	public static com.excilys.liferay.gatling.model.LinkUsecaseScenario create(
		LinkUsecaseScenarioPK linkUsecaseScenarioPK) {
		return getPersistence().create(linkUsecaseScenarioPK);
	}

	/**
	* Removes the link usecase scenario with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param linkUsecaseScenarioPK the primary key of the link usecase scenario
	* @return the link usecase scenario that was removed
	* @throws com.excilys.liferay.gatling.NoSuchLinkUsecaseScenarioException if a link usecase scenario with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.excilys.liferay.gatling.model.LinkUsecaseScenario remove(
		LinkUsecaseScenarioPK linkUsecaseScenarioPK)
		throws com.excilys.liferay.gatling.NoSuchLinkUsecaseScenarioException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(linkUsecaseScenarioPK);
	}

	public static com.excilys.liferay.gatling.model.LinkUsecaseScenario updateImpl(
		com.excilys.liferay.gatling.model.LinkUsecaseScenario linkUsecaseScenario)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(linkUsecaseScenario);
	}

	/**
	* Returns the link usecase scenario with the primary key or throws a {@link com.excilys.liferay.gatling.NoSuchLinkUsecaseScenarioException} if it could not be found.
	*
	* @param linkUsecaseScenarioPK the primary key of the link usecase scenario
	* @return the link usecase scenario
	* @throws com.excilys.liferay.gatling.NoSuchLinkUsecaseScenarioException if a link usecase scenario with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.excilys.liferay.gatling.model.LinkUsecaseScenario findByPrimaryKey(
		LinkUsecaseScenarioPK linkUsecaseScenarioPK)
		throws com.excilys.liferay.gatling.NoSuchLinkUsecaseScenarioException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(linkUsecaseScenarioPK);
	}

	/**
	* Returns the link usecase scenario with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param linkUsecaseScenarioPK the primary key of the link usecase scenario
	* @return the link usecase scenario, or <code>null</code> if a link usecase scenario with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.excilys.liferay.gatling.model.LinkUsecaseScenario fetchByPrimaryKey(
		LinkUsecaseScenarioPK linkUsecaseScenarioPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(linkUsecaseScenarioPK);
	}

	/**
	* Returns all the link usecase scenarios.
	*
	* @return the link usecase scenarios
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.excilys.liferay.gatling.model.LinkUsecaseScenario> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<com.excilys.liferay.gatling.model.LinkUsecaseScenario> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.excilys.liferay.gatling.model.LinkUsecaseScenario> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the link usecase scenarios from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of link usecase scenarios.
	*
	* @return the number of link usecase scenarios
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static LinkUsecaseScenarioPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (LinkUsecaseScenarioPersistence)PortletBeanLocatorUtil.locate(com.excilys.liferay.gatling.service.ClpSerializer.getServletContextName(),
					LinkUsecaseScenarioPersistence.class.getName());

			ReferenceRegistry.registerReference(LinkUsecaseScenarioUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(LinkUsecaseScenarioPersistence persistence) {
	}

	private static LinkUsecaseScenarioPersistence _persistence;
}