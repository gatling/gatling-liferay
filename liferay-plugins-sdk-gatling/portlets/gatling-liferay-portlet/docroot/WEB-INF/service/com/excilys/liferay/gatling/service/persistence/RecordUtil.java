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

import com.excilys.liferay.gatling.model.Record;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the record service. This utility wraps {@link RecordPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RecordPersistence
 * @see RecordPersistenceImpl
 * @generated
 */
public class RecordUtil {
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
	public static void clearCache(Record record) {
		getPersistence().clearCache(record);
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
	public static List<Record> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Record> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Record> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Record update(Record record) throws SystemException {
		return getPersistence().update(record);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Record update(Record record, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(record, serviceContext);
	}

	/**
	* Caches the record in the entity cache if it is enabled.
	*
	* @param record the record
	*/
	public static void cacheResult(
		com.excilys.liferay.gatling.model.Record record) {
		getPersistence().cacheResult(record);
	}

	/**
	* Caches the records in the entity cache if it is enabled.
	*
	* @param records the records
	*/
	public static void cacheResult(
		java.util.List<com.excilys.liferay.gatling.model.Record> records) {
		getPersistence().cacheResult(records);
	}

	/**
	* Creates a new record with the primary key. Does not add the record to the database.
	*
	* @param recordId the primary key for the new record
	* @return the new record
	*/
	public static com.excilys.liferay.gatling.model.Record create(long recordId) {
		return getPersistence().create(recordId);
	}

	/**
	* Removes the record with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param recordId the primary key of the record
	* @return the record that was removed
	* @throws com.excilys.liferay.gatling.NoSuchRecordException if a record with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.excilys.liferay.gatling.model.Record remove(long recordId)
		throws com.excilys.liferay.gatling.NoSuchRecordException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(recordId);
	}

	public static com.excilys.liferay.gatling.model.Record updateImpl(
		com.excilys.liferay.gatling.model.Record record)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(record);
	}

	/**
	* Returns the record with the primary key or throws a {@link com.excilys.liferay.gatling.NoSuchRecordException} if it could not be found.
	*
	* @param recordId the primary key of the record
	* @return the record
	* @throws com.excilys.liferay.gatling.NoSuchRecordException if a record with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.excilys.liferay.gatling.model.Record findByPrimaryKey(
		long recordId)
		throws com.excilys.liferay.gatling.NoSuchRecordException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(recordId);
	}

	/**
	* Returns the record with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param recordId the primary key of the record
	* @return the record, or <code>null</code> if a record with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.excilys.liferay.gatling.model.Record fetchByPrimaryKey(
		long recordId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(recordId);
	}

	/**
	* Returns all the records.
	*
	* @return the records
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.excilys.liferay.gatling.model.Record> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the records.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.excilys.liferay.gatling.model.impl.RecordModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of records
	* @param end the upper bound of the range of records (not inclusive)
	* @return the range of records
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.excilys.liferay.gatling.model.Record> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the records.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.excilys.liferay.gatling.model.impl.RecordModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of records
	* @param end the upper bound of the range of records (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of records
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.excilys.liferay.gatling.model.Record> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the records from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of records.
	*
	* @return the number of records
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static RecordPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (RecordPersistence)PortletBeanLocatorUtil.locate(com.excilys.liferay.gatling.service.ClpSerializer.getServletContextName(),
					RecordPersistence.class.getName());

			ReferenceRegistry.registerReference(RecordUtil.class, "_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(RecordPersistence persistence) {
	}

	private static RecordPersistence _persistence;
}