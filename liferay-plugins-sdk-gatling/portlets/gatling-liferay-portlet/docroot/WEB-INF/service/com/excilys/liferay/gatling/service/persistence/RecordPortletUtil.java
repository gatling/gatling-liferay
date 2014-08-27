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

import com.excilys.liferay.gatling.model.RecordPortlet;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the record portlet service. This utility wraps {@link RecordPortletPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RecordPortletPersistence
 * @see RecordPortletPersistenceImpl
 * @generated
 */
public class RecordPortletUtil {
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
	public static void clearCache(RecordPortlet recordPortlet) {
		getPersistence().clearCache(recordPortlet);
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
	public static List<RecordPortlet> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<RecordPortlet> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<RecordPortlet> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static RecordPortlet update(RecordPortlet recordPortlet)
		throws SystemException {
		return getPersistence().update(recordPortlet);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static RecordPortlet update(RecordPortlet recordPortlet,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(recordPortlet, serviceContext);
	}

	/**
	* Caches the record portlet in the entity cache if it is enabled.
	*
	* @param recordPortlet the record portlet
	*/
	public static void cacheResult(
		com.excilys.liferay.gatling.model.RecordPortlet recordPortlet) {
		getPersistence().cacheResult(recordPortlet);
	}

	/**
	* Caches the record portlets in the entity cache if it is enabled.
	*
	* @param recordPortlets the record portlets
	*/
	public static void cacheResult(
		java.util.List<com.excilys.liferay.gatling.model.RecordPortlet> recordPortlets) {
		getPersistence().cacheResult(recordPortlets);
	}

	/**
	* Creates a new record portlet with the primary key. Does not add the record portlet to the database.
	*
	* @param recordPortletId the primary key for the new record portlet
	* @return the new record portlet
	*/
	public static com.excilys.liferay.gatling.model.RecordPortlet create(
		long recordPortletId) {
		return getPersistence().create(recordPortletId);
	}

	/**
	* Removes the record portlet with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param recordPortletId the primary key of the record portlet
	* @return the record portlet that was removed
	* @throws com.excilys.liferay.gatling.NoSuchRecordPortletException if a record portlet with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.excilys.liferay.gatling.model.RecordPortlet remove(
		long recordPortletId)
		throws com.excilys.liferay.gatling.NoSuchRecordPortletException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(recordPortletId);
	}

	public static com.excilys.liferay.gatling.model.RecordPortlet updateImpl(
		com.excilys.liferay.gatling.model.RecordPortlet recordPortlet)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(recordPortlet);
	}

	/**
	* Returns the record portlet with the primary key or throws a {@link com.excilys.liferay.gatling.NoSuchRecordPortletException} if it could not be found.
	*
	* @param recordPortletId the primary key of the record portlet
	* @return the record portlet
	* @throws com.excilys.liferay.gatling.NoSuchRecordPortletException if a record portlet with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.excilys.liferay.gatling.model.RecordPortlet findByPrimaryKey(
		long recordPortletId)
		throws com.excilys.liferay.gatling.NoSuchRecordPortletException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(recordPortletId);
	}

	/**
	* Returns the record portlet with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param recordPortletId the primary key of the record portlet
	* @return the record portlet, or <code>null</code> if a record portlet with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.excilys.liferay.gatling.model.RecordPortlet fetchByPrimaryKey(
		long recordPortletId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(recordPortletId);
	}

	/**
	* Returns all the record portlets.
	*
	* @return the record portlets
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.excilys.liferay.gatling.model.RecordPortlet> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the record portlets.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.excilys.liferay.gatling.model.impl.RecordPortletModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of record portlets
	* @param end the upper bound of the range of record portlets (not inclusive)
	* @return the range of record portlets
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.excilys.liferay.gatling.model.RecordPortlet> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the record portlets.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.excilys.liferay.gatling.model.impl.RecordPortletModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of record portlets
	* @param end the upper bound of the range of record portlets (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of record portlets
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.excilys.liferay.gatling.model.RecordPortlet> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the record portlets from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of record portlets.
	*
	* @return the number of record portlets
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static RecordPortletPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (RecordPortletPersistence)PortletBeanLocatorUtil.locate(com.excilys.liferay.gatling.service.ClpSerializer.getServletContextName(),
					RecordPortletPersistence.class.getName());

			ReferenceRegistry.registerReference(RecordPortletUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(RecordPortletPersistence persistence) {
	}

	private static RecordPortletPersistence _persistence;
}