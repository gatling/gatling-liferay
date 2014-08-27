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

import com.excilys.liferay.gatling.model.PortletStress;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the portlet stress service. This utility wraps {@link PortletStressPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PortletStressPersistence
 * @see PortletStressPersistenceImpl
 * @generated
 */
public class PortletStressUtil {
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
	public static void clearCache(PortletStress portletStress) {
		getPersistence().clearCache(portletStress);
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
	public static List<PortletStress> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<PortletStress> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<PortletStress> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static PortletStress update(PortletStress portletStress)
		throws SystemException {
		return getPersistence().update(portletStress);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static PortletStress update(PortletStress portletStress,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(portletStress, serviceContext);
	}

	/**
	* Caches the portlet stress in the entity cache if it is enabled.
	*
	* @param portletStress the portlet stress
	*/
	public static void cacheResult(
		com.excilys.liferay.gatling.model.PortletStress portletStress) {
		getPersistence().cacheResult(portletStress);
	}

	/**
	* Caches the portlet stresses in the entity cache if it is enabled.
	*
	* @param portletStresses the portlet stresses
	*/
	public static void cacheResult(
		java.util.List<com.excilys.liferay.gatling.model.PortletStress> portletStresses) {
		getPersistence().cacheResult(portletStresses);
	}

	/**
	* Creates a new portlet stress with the primary key. Does not add the portlet stress to the database.
	*
	* @param portletStressId the primary key for the new portlet stress
	* @return the new portlet stress
	*/
	public static com.excilys.liferay.gatling.model.PortletStress create(
		long portletStressId) {
		return getPersistence().create(portletStressId);
	}

	/**
	* Removes the portlet stress with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param portletStressId the primary key of the portlet stress
	* @return the portlet stress that was removed
	* @throws com.excilys.liferay.gatling.NoSuchPortletStressException if a portlet stress with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.excilys.liferay.gatling.model.PortletStress remove(
		long portletStressId)
		throws com.excilys.liferay.gatling.NoSuchPortletStressException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(portletStressId);
	}

	public static com.excilys.liferay.gatling.model.PortletStress updateImpl(
		com.excilys.liferay.gatling.model.PortletStress portletStress)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(portletStress);
	}

	/**
	* Returns the portlet stress with the primary key or throws a {@link com.excilys.liferay.gatling.NoSuchPortletStressException} if it could not be found.
	*
	* @param portletStressId the primary key of the portlet stress
	* @return the portlet stress
	* @throws com.excilys.liferay.gatling.NoSuchPortletStressException if a portlet stress with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.excilys.liferay.gatling.model.PortletStress findByPrimaryKey(
		long portletStressId)
		throws com.excilys.liferay.gatling.NoSuchPortletStressException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(portletStressId);
	}

	/**
	* Returns the portlet stress with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param portletStressId the primary key of the portlet stress
	* @return the portlet stress, or <code>null</code> if a portlet stress with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.excilys.liferay.gatling.model.PortletStress fetchByPrimaryKey(
		long portletStressId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(portletStressId);
	}

	/**
	* Returns all the portlet stresses.
	*
	* @return the portlet stresses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.excilys.liferay.gatling.model.PortletStress> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the portlet stresses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.excilys.liferay.gatling.model.impl.PortletStressModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of portlet stresses
	* @param end the upper bound of the range of portlet stresses (not inclusive)
	* @return the range of portlet stresses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.excilys.liferay.gatling.model.PortletStress> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the portlet stresses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.excilys.liferay.gatling.model.impl.PortletStressModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of portlet stresses
	* @param end the upper bound of the range of portlet stresses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of portlet stresses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.excilys.liferay.gatling.model.PortletStress> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the portlet stresses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of portlet stresses.
	*
	* @return the number of portlet stresses
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static PortletStressPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (PortletStressPersistence)PortletBeanLocatorUtil.locate(com.excilys.liferay.gatling.service.ClpSerializer.getServletContextName(),
					PortletStressPersistence.class.getName());

			ReferenceRegistry.registerReference(PortletStressUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(PortletStressPersistence persistence) {
	}

	private static PortletStressPersistence _persistence;
}