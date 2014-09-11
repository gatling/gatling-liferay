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

package com.excilys.liferay.gatling.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link RecordLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see RecordLocalService
 * @generated
 */
public class RecordLocalServiceWrapper implements RecordLocalService,
	ServiceWrapper<RecordLocalService> {
	public RecordLocalServiceWrapper(RecordLocalService recordLocalService) {
		_recordLocalService = recordLocalService;
	}

	/**
	* Adds the record to the database. Also notifies the appropriate model listeners.
	*
	* @param record the record
	* @return the record that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.excilys.liferay.gatling.model.Record addRecord(
		com.excilys.liferay.gatling.model.Record record)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _recordLocalService.addRecord(record);
	}

	/**
	* Creates a new record with the primary key. Does not add the record to the database.
	*
	* @param recordId the primary key for the new record
	* @return the new record
	*/
	@Override
	public com.excilys.liferay.gatling.model.Record createRecord(long recordId) {
		return _recordLocalService.createRecord(recordId);
	}

	/**
	* Deletes the record with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param recordId the primary key of the record
	* @return the record that was removed
	* @throws PortalException if a record with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.excilys.liferay.gatling.model.Record deleteRecord(long recordId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _recordLocalService.deleteRecord(recordId);
	}

	/**
	* Deletes the record from the database. Also notifies the appropriate model listeners.
	*
	* @param record the record
	* @return the record that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.excilys.liferay.gatling.model.Record deleteRecord(
		com.excilys.liferay.gatling.model.Record record)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _recordLocalService.deleteRecord(record);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _recordLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _recordLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.excilys.liferay.gatling.model.impl.RecordModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _recordLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.excilys.liferay.gatling.model.impl.RecordModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _recordLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _recordLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _recordLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.excilys.liferay.gatling.model.Record fetchRecord(long recordId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _recordLocalService.fetchRecord(recordId);
	}

	/**
	* Returns the record with the primary key.
	*
	* @param recordId the primary key of the record
	* @return the record
	* @throws PortalException if a record with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.excilys.liferay.gatling.model.Record getRecord(long recordId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _recordLocalService.getRecord(recordId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _recordLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public java.util.List<com.excilys.liferay.gatling.model.Record> getRecords(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _recordLocalService.getRecords(start, end);
	}

	/**
	* Returns the number of records.
	*
	* @return the number of records
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getRecordsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _recordLocalService.getRecordsCount();
	}

	/**
	* Updates the record in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param record the record
	* @return the record that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.excilys.liferay.gatling.model.Record updateRecord(
		com.excilys.liferay.gatling.model.Record record)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _recordLocalService.updateRecord(record);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _recordLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_recordLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _recordLocalService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public java.util.List<com.excilys.liferay.gatling.model.Record> findByPortletId(
		java.lang.String portletId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _recordLocalService.findByPortletId(portletId);
	}

	@Override
	public int countByPortletId(java.lang.String portletId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _recordLocalService.countByPortletId(portletId);
	}

	@Override
	public void update(long recordId, java.lang.String name)
		throws com.liferay.portal.NoSuchModelException,
			com.liferay.portal.kernel.exception.SystemException {
		_recordLocalService.update(recordId, name);
	}

	@Override
	public com.excilys.liferay.gatling.model.Record save(
		java.lang.String name, java.lang.String portletId, long version)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _recordLocalService.save(name, portletId, version);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public RecordLocalService getWrappedRecordLocalService() {
		return _recordLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedRecordLocalService(
		RecordLocalService recordLocalService) {
		_recordLocalService = recordLocalService;
	}

	@Override
	public RecordLocalService getWrappedService() {
		return _recordLocalService;
	}

	@Override
	public void setWrappedService(RecordLocalService recordLocalService) {
		_recordLocalService = recordLocalService;
	}

	private RecordLocalService _recordLocalService;
}