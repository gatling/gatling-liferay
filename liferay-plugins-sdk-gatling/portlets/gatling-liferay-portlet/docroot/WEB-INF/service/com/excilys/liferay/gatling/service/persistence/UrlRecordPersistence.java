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

import com.excilys.liferay.gatling.model.UrlRecord;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the url record service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UrlRecordPersistenceImpl
 * @see UrlRecordUtil
 * @generated
 */
public interface UrlRecordPersistence extends BasePersistence<UrlRecord> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link UrlRecordUtil} to access the url record persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the url records where recordId = &#63;.
	*
	* @param recordId the record ID
	* @return the matching url records
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.excilys.liferay.gatling.model.UrlRecord> findByrecordId(
		long recordId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the url records where recordId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.excilys.liferay.gatling.model.impl.UrlRecordModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param recordId the record ID
	* @param start the lower bound of the range of url records
	* @param end the upper bound of the range of url records (not inclusive)
	* @return the range of matching url records
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.excilys.liferay.gatling.model.UrlRecord> findByrecordId(
		long recordId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the url records where recordId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.excilys.liferay.gatling.model.impl.UrlRecordModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param recordId the record ID
	* @param start the lower bound of the range of url records
	* @param end the upper bound of the range of url records (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching url records
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.excilys.liferay.gatling.model.UrlRecord> findByrecordId(
		long recordId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first url record in the ordered set where recordId = &#63;.
	*
	* @param recordId the record ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching url record
	* @throws com.excilys.liferay.gatling.NoSuchUrlRecordException if a matching url record could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.excilys.liferay.gatling.model.UrlRecord findByrecordId_First(
		long recordId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.excilys.liferay.gatling.NoSuchUrlRecordException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first url record in the ordered set where recordId = &#63;.
	*
	* @param recordId the record ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching url record, or <code>null</code> if a matching url record could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.excilys.liferay.gatling.model.UrlRecord fetchByrecordId_First(
		long recordId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last url record in the ordered set where recordId = &#63;.
	*
	* @param recordId the record ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching url record
	* @throws com.excilys.liferay.gatling.NoSuchUrlRecordException if a matching url record could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.excilys.liferay.gatling.model.UrlRecord findByrecordId_Last(
		long recordId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.excilys.liferay.gatling.NoSuchUrlRecordException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last url record in the ordered set where recordId = &#63;.
	*
	* @param recordId the record ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching url record, or <code>null</code> if a matching url record could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.excilys.liferay.gatling.model.UrlRecord fetchByrecordId_Last(
		long recordId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the url records before and after the current url record in the ordered set where recordId = &#63;.
	*
	* @param urlRecordId the primary key of the current url record
	* @param recordId the record ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next url record
	* @throws com.excilys.liferay.gatling.NoSuchUrlRecordException if a url record with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.excilys.liferay.gatling.model.UrlRecord[] findByrecordId_PrevAndNext(
		long urlRecordId, long recordId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.excilys.liferay.gatling.NoSuchUrlRecordException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the url records where recordId = &#63; from the database.
	*
	* @param recordId the record ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByrecordId(long recordId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of url records where recordId = &#63;.
	*
	* @param recordId the record ID
	* @return the number of matching url records
	* @throws SystemException if a system exception occurred
	*/
	public int countByrecordId(long recordId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the url record in the entity cache if it is enabled.
	*
	* @param urlRecord the url record
	*/
	public void cacheResult(
		com.excilys.liferay.gatling.model.UrlRecord urlRecord);

	/**
	* Caches the url records in the entity cache if it is enabled.
	*
	* @param urlRecords the url records
	*/
	public void cacheResult(
		java.util.List<com.excilys.liferay.gatling.model.UrlRecord> urlRecords);

	/**
	* Creates a new url record with the primary key. Does not add the url record to the database.
	*
	* @param urlRecordId the primary key for the new url record
	* @return the new url record
	*/
	public com.excilys.liferay.gatling.model.UrlRecord create(long urlRecordId);

	/**
	* Removes the url record with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param urlRecordId the primary key of the url record
	* @return the url record that was removed
	* @throws com.excilys.liferay.gatling.NoSuchUrlRecordException if a url record with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.excilys.liferay.gatling.model.UrlRecord remove(long urlRecordId)
		throws com.excilys.liferay.gatling.NoSuchUrlRecordException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.excilys.liferay.gatling.model.UrlRecord updateImpl(
		com.excilys.liferay.gatling.model.UrlRecord urlRecord)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the url record with the primary key or throws a {@link com.excilys.liferay.gatling.NoSuchUrlRecordException} if it could not be found.
	*
	* @param urlRecordId the primary key of the url record
	* @return the url record
	* @throws com.excilys.liferay.gatling.NoSuchUrlRecordException if a url record with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.excilys.liferay.gatling.model.UrlRecord findByPrimaryKey(
		long urlRecordId)
		throws com.excilys.liferay.gatling.NoSuchUrlRecordException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the url record with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param urlRecordId the primary key of the url record
	* @return the url record, or <code>null</code> if a url record with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.excilys.liferay.gatling.model.UrlRecord fetchByPrimaryKey(
		long urlRecordId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the url records.
	*
	* @return the url records
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.excilys.liferay.gatling.model.UrlRecord> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the url records.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.excilys.liferay.gatling.model.impl.UrlRecordModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of url records
	* @param end the upper bound of the range of url records (not inclusive)
	* @return the range of url records
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.excilys.liferay.gatling.model.UrlRecord> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the url records.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.excilys.liferay.gatling.model.impl.UrlRecordModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of url records
	* @param end the upper bound of the range of url records (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of url records
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.excilys.liferay.gatling.model.UrlRecord> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the url records from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of url records.
	*
	* @return the number of url records
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}