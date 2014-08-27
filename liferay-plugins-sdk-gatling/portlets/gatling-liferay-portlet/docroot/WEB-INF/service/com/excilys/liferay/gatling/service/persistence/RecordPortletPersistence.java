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

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the record portlet service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RecordPortletPersistenceImpl
 * @see RecordPortletUtil
 * @generated
 */
public interface RecordPortletPersistence extends BasePersistence<RecordPortlet> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link RecordPortletUtil} to access the record portlet persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the record portlet in the entity cache if it is enabled.
	*
	* @param recordPortlet the record portlet
	*/
	public void cacheResult(
		com.excilys.liferay.gatling.model.RecordPortlet recordPortlet);

	/**
	* Caches the record portlets in the entity cache if it is enabled.
	*
	* @param recordPortlets the record portlets
	*/
	public void cacheResult(
		java.util.List<com.excilys.liferay.gatling.model.RecordPortlet> recordPortlets);

	/**
	* Creates a new record portlet with the primary key. Does not add the record portlet to the database.
	*
	* @param recordPortletId the primary key for the new record portlet
	* @return the new record portlet
	*/
	public com.excilys.liferay.gatling.model.RecordPortlet create(
		long recordPortletId);

	/**
	* Removes the record portlet with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param recordPortletId the primary key of the record portlet
	* @return the record portlet that was removed
	* @throws com.excilys.liferay.gatling.NoSuchRecordPortletException if a record portlet with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.excilys.liferay.gatling.model.RecordPortlet remove(
		long recordPortletId)
		throws com.excilys.liferay.gatling.NoSuchRecordPortletException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.excilys.liferay.gatling.model.RecordPortlet updateImpl(
		com.excilys.liferay.gatling.model.RecordPortlet recordPortlet)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the record portlet with the primary key or throws a {@link com.excilys.liferay.gatling.NoSuchRecordPortletException} if it could not be found.
	*
	* @param recordPortletId the primary key of the record portlet
	* @return the record portlet
	* @throws com.excilys.liferay.gatling.NoSuchRecordPortletException if a record portlet with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.excilys.liferay.gatling.model.RecordPortlet findByPrimaryKey(
		long recordPortletId)
		throws com.excilys.liferay.gatling.NoSuchRecordPortletException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the record portlet with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param recordPortletId the primary key of the record portlet
	* @return the record portlet, or <code>null</code> if a record portlet with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.excilys.liferay.gatling.model.RecordPortlet fetchByPrimaryKey(
		long recordPortletId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the record portlets.
	*
	* @return the record portlets
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.excilys.liferay.gatling.model.RecordPortlet> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.excilys.liferay.gatling.model.RecordPortlet> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.excilys.liferay.gatling.model.RecordPortlet> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the record portlets from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of record portlets.
	*
	* @return the number of record portlets
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}