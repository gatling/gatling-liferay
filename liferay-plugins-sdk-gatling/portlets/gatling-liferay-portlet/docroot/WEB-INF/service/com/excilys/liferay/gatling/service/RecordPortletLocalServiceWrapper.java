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
 * Provides a wrapper for {@link RecordPortletLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see RecordPortletLocalService
 * @generated
 */
public class RecordPortletLocalServiceWrapper
	implements RecordPortletLocalService,
		ServiceWrapper<RecordPortletLocalService> {
	public RecordPortletLocalServiceWrapper(
		RecordPortletLocalService recordPortletLocalService) {
		_recordPortletLocalService = recordPortletLocalService;
	}

	/**
	* Adds the record portlet to the database. Also notifies the appropriate model listeners.
	*
	* @param recordPortlet the record portlet
	* @return the record portlet that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.excilys.liferay.gatling.model.RecordPortlet addRecordPortlet(
		com.excilys.liferay.gatling.model.RecordPortlet recordPortlet)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _recordPortletLocalService.addRecordPortlet(recordPortlet);
	}

	/**
	* Creates a new record portlet with the primary key. Does not add the record portlet to the database.
	*
	* @param recordPortletId the primary key for the new record portlet
	* @return the new record portlet
	*/
	@Override
	public com.excilys.liferay.gatling.model.RecordPortlet createRecordPortlet(
		long recordPortletId) {
		return _recordPortletLocalService.createRecordPortlet(recordPortletId);
	}

	/**
	* Deletes the record portlet with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param recordPortletId the primary key of the record portlet
	* @return the record portlet that was removed
	* @throws PortalException if a record portlet with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.excilys.liferay.gatling.model.RecordPortlet deleteRecordPortlet(
		long recordPortletId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _recordPortletLocalService.deleteRecordPortlet(recordPortletId);
	}

	/**
	* Deletes the record portlet from the database. Also notifies the appropriate model listeners.
	*
	* @param recordPortlet the record portlet
	* @return the record portlet that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.excilys.liferay.gatling.model.RecordPortlet deleteRecordPortlet(
		com.excilys.liferay.gatling.model.RecordPortlet recordPortlet)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _recordPortletLocalService.deleteRecordPortlet(recordPortlet);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _recordPortletLocalService.dynamicQuery();
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
		return _recordPortletLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.excilys.liferay.gatling.model.impl.RecordPortletModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _recordPortletLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.excilys.liferay.gatling.model.impl.RecordPortletModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _recordPortletLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
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
		return _recordPortletLocalService.dynamicQueryCount(dynamicQuery);
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
		return _recordPortletLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.excilys.liferay.gatling.model.RecordPortlet fetchRecordPortlet(
		long recordPortletId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _recordPortletLocalService.fetchRecordPortlet(recordPortletId);
	}

	/**
	* Returns the record portlet with the primary key.
	*
	* @param recordPortletId the primary key of the record portlet
	* @return the record portlet
	* @throws PortalException if a record portlet with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.excilys.liferay.gatling.model.RecordPortlet getRecordPortlet(
		long recordPortletId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _recordPortletLocalService.getRecordPortlet(recordPortletId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _recordPortletLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public java.util.List<com.excilys.liferay.gatling.model.RecordPortlet> getRecordPortlets(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _recordPortletLocalService.getRecordPortlets(start, end);
	}

	/**
	* Returns the number of record portlets.
	*
	* @return the number of record portlets
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getRecordPortletsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _recordPortletLocalService.getRecordPortletsCount();
	}

	/**
	* Updates the record portlet in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param recordPortlet the record portlet
	* @return the record portlet that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.excilys.liferay.gatling.model.RecordPortlet updateRecordPortlet(
		com.excilys.liferay.gatling.model.RecordPortlet recordPortlet)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _recordPortletLocalService.updateRecordPortlet(recordPortlet);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _recordPortletLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_recordPortletLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _recordPortletLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public RecordPortletLocalService getWrappedRecordPortletLocalService() {
		return _recordPortletLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedRecordPortletLocalService(
		RecordPortletLocalService recordPortletLocalService) {
		_recordPortletLocalService = recordPortletLocalService;
	}

	@Override
	public RecordPortletLocalService getWrappedService() {
		return _recordPortletLocalService;
	}

	@Override
	public void setWrappedService(
		RecordPortletLocalService recordPortletLocalService) {
		_recordPortletLocalService = recordPortletLocalService;
	}

	private RecordPortletLocalService _recordPortletLocalService;
}