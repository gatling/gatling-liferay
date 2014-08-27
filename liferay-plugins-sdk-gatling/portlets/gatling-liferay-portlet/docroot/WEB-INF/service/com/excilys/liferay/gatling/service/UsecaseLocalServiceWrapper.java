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
 * Provides a wrapper for {@link UsecaseLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see UsecaseLocalService
 * @generated
 */
public class UsecaseLocalServiceWrapper implements UsecaseLocalService,
	ServiceWrapper<UsecaseLocalService> {
	public UsecaseLocalServiceWrapper(UsecaseLocalService usecaseLocalService) {
		_usecaseLocalService = usecaseLocalService;
	}

	/**
	* Adds the usecase to the database. Also notifies the appropriate model listeners.
	*
	* @param usecase the usecase
	* @return the usecase that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.excilys.liferay.gatling.model.Usecase addUsecase(
		com.excilys.liferay.gatling.model.Usecase usecase)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _usecaseLocalService.addUsecase(usecase);
	}

	/**
	* Creates a new usecase with the primary key. Does not add the usecase to the database.
	*
	* @param usecaseId the primary key for the new usecase
	* @return the new usecase
	*/
	@Override
	public com.excilys.liferay.gatling.model.Usecase createUsecase(
		long usecaseId) {
		return _usecaseLocalService.createUsecase(usecaseId);
	}

	/**
	* Deletes the usecase with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param usecaseId the primary key of the usecase
	* @return the usecase that was removed
	* @throws PortalException if a usecase with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.excilys.liferay.gatling.model.Usecase deleteUsecase(
		long usecaseId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _usecaseLocalService.deleteUsecase(usecaseId);
	}

	/**
	* Deletes the usecase from the database. Also notifies the appropriate model listeners.
	*
	* @param usecase the usecase
	* @return the usecase that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.excilys.liferay.gatling.model.Usecase deleteUsecase(
		com.excilys.liferay.gatling.model.Usecase usecase)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _usecaseLocalService.deleteUsecase(usecase);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _usecaseLocalService.dynamicQuery();
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
		return _usecaseLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.excilys.liferay.gatling.model.impl.UsecaseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _usecaseLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.excilys.liferay.gatling.model.impl.UsecaseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _usecaseLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _usecaseLocalService.dynamicQueryCount(dynamicQuery);
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
		return _usecaseLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.excilys.liferay.gatling.model.Usecase fetchUsecase(
		long usecaseId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _usecaseLocalService.fetchUsecase(usecaseId);
	}

	/**
	* Returns the usecase with the primary key.
	*
	* @param usecaseId the primary key of the usecase
	* @return the usecase
	* @throws PortalException if a usecase with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.excilys.liferay.gatling.model.Usecase getUsecase(long usecaseId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _usecaseLocalService.getUsecase(usecaseId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _usecaseLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the usecases.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.excilys.liferay.gatling.model.impl.UsecaseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of usecases
	* @param end the upper bound of the range of usecases (not inclusive)
	* @return the range of usecases
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.excilys.liferay.gatling.model.Usecase> getUsecases(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _usecaseLocalService.getUsecases(start, end);
	}

	/**
	* Returns the number of usecases.
	*
	* @return the number of usecases
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getUsecasesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _usecaseLocalService.getUsecasesCount();
	}

	/**
	* Updates the usecase in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param usecase the usecase
	* @return the usecase that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.excilys.liferay.gatling.model.Usecase updateUsecase(
		com.excilys.liferay.gatling.model.Usecase usecase)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _usecaseLocalService.updateUsecase(usecase);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _usecaseLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_usecaseLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _usecaseLocalService.invokeMethod(name, parameterTypes, arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public UsecaseLocalService getWrappedUsecaseLocalService() {
		return _usecaseLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedUsecaseLocalService(
		UsecaseLocalService usecaseLocalService) {
		_usecaseLocalService = usecaseLocalService;
	}

	@Override
	public UsecaseLocalService getWrappedService() {
		return _usecaseLocalService;
	}

	@Override
	public void setWrappedService(UsecaseLocalService usecaseLocalService) {
		_usecaseLocalService = usecaseLocalService;
	}

	private UsecaseLocalService _usecaseLocalService;
}