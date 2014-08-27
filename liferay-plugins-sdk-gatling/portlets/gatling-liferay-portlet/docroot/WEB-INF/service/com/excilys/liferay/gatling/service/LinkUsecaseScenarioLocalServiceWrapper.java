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
 * Provides a wrapper for {@link LinkUsecaseScenarioLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see LinkUsecaseScenarioLocalService
 * @generated
 */
public class LinkUsecaseScenarioLocalServiceWrapper
	implements LinkUsecaseScenarioLocalService,
		ServiceWrapper<LinkUsecaseScenarioLocalService> {
	public LinkUsecaseScenarioLocalServiceWrapper(
		LinkUsecaseScenarioLocalService linkUsecaseScenarioLocalService) {
		_linkUsecaseScenarioLocalService = linkUsecaseScenarioLocalService;
	}

	/**
	* Adds the link usecase scenario to the database. Also notifies the appropriate model listeners.
	*
	* @param linkUsecaseScenario the link usecase scenario
	* @return the link usecase scenario that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.excilys.liferay.gatling.model.LinkUsecaseScenario addLinkUsecaseScenario(
		com.excilys.liferay.gatling.model.LinkUsecaseScenario linkUsecaseScenario)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _linkUsecaseScenarioLocalService.addLinkUsecaseScenario(linkUsecaseScenario);
	}

	/**
	* Creates a new link usecase scenario with the primary key. Does not add the link usecase scenario to the database.
	*
	* @param linkUsecaseScenarioPK the primary key for the new link usecase scenario
	* @return the new link usecase scenario
	*/
	@Override
	public com.excilys.liferay.gatling.model.LinkUsecaseScenario createLinkUsecaseScenario(
		com.excilys.liferay.gatling.service.persistence.LinkUsecaseScenarioPK linkUsecaseScenarioPK) {
		return _linkUsecaseScenarioLocalService.createLinkUsecaseScenario(linkUsecaseScenarioPK);
	}

	/**
	* Deletes the link usecase scenario with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param linkUsecaseScenarioPK the primary key of the link usecase scenario
	* @return the link usecase scenario that was removed
	* @throws PortalException if a link usecase scenario with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.excilys.liferay.gatling.model.LinkUsecaseScenario deleteLinkUsecaseScenario(
		com.excilys.liferay.gatling.service.persistence.LinkUsecaseScenarioPK linkUsecaseScenarioPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _linkUsecaseScenarioLocalService.deleteLinkUsecaseScenario(linkUsecaseScenarioPK);
	}

	/**
	* Deletes the link usecase scenario from the database. Also notifies the appropriate model listeners.
	*
	* @param linkUsecaseScenario the link usecase scenario
	* @return the link usecase scenario that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.excilys.liferay.gatling.model.LinkUsecaseScenario deleteLinkUsecaseScenario(
		com.excilys.liferay.gatling.model.LinkUsecaseScenario linkUsecaseScenario)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _linkUsecaseScenarioLocalService.deleteLinkUsecaseScenario(linkUsecaseScenario);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _linkUsecaseScenarioLocalService.dynamicQuery();
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
		return _linkUsecaseScenarioLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.excilys.liferay.gatling.model.impl.LinkUsecaseScenarioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _linkUsecaseScenarioLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.excilys.liferay.gatling.model.impl.LinkUsecaseScenarioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _linkUsecaseScenarioLocalService.dynamicQuery(dynamicQuery,
			start, end, orderByComparator);
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
		return _linkUsecaseScenarioLocalService.dynamicQueryCount(dynamicQuery);
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
		return _linkUsecaseScenarioLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.excilys.liferay.gatling.model.LinkUsecaseScenario fetchLinkUsecaseScenario(
		com.excilys.liferay.gatling.service.persistence.LinkUsecaseScenarioPK linkUsecaseScenarioPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _linkUsecaseScenarioLocalService.fetchLinkUsecaseScenario(linkUsecaseScenarioPK);
	}

	/**
	* Returns the link usecase scenario with the primary key.
	*
	* @param linkUsecaseScenarioPK the primary key of the link usecase scenario
	* @return the link usecase scenario
	* @throws PortalException if a link usecase scenario with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.excilys.liferay.gatling.model.LinkUsecaseScenario getLinkUsecaseScenario(
		com.excilys.liferay.gatling.service.persistence.LinkUsecaseScenarioPK linkUsecaseScenarioPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _linkUsecaseScenarioLocalService.getLinkUsecaseScenario(linkUsecaseScenarioPK);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _linkUsecaseScenarioLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public java.util.List<com.excilys.liferay.gatling.model.LinkUsecaseScenario> getLinkUsecaseScenarios(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _linkUsecaseScenarioLocalService.getLinkUsecaseScenarios(start,
			end);
	}

	/**
	* Returns the number of link usecase scenarios.
	*
	* @return the number of link usecase scenarios
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getLinkUsecaseScenariosCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _linkUsecaseScenarioLocalService.getLinkUsecaseScenariosCount();
	}

	/**
	* Updates the link usecase scenario in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param linkUsecaseScenario the link usecase scenario
	* @return the link usecase scenario that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.excilys.liferay.gatling.model.LinkUsecaseScenario updateLinkUsecaseScenario(
		com.excilys.liferay.gatling.model.LinkUsecaseScenario linkUsecaseScenario)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _linkUsecaseScenarioLocalService.updateLinkUsecaseScenario(linkUsecaseScenario);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _linkUsecaseScenarioLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_linkUsecaseScenarioLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _linkUsecaseScenarioLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public LinkUsecaseScenarioLocalService getWrappedLinkUsecaseScenarioLocalService() {
		return _linkUsecaseScenarioLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedLinkUsecaseScenarioLocalService(
		LinkUsecaseScenarioLocalService linkUsecaseScenarioLocalService) {
		_linkUsecaseScenarioLocalService = linkUsecaseScenarioLocalService;
	}

	@Override
	public LinkUsecaseScenarioLocalService getWrappedService() {
		return _linkUsecaseScenarioLocalService;
	}

	@Override
	public void setWrappedService(
		LinkUsecaseScenarioLocalService linkUsecaseScenarioLocalService) {
		_linkUsecaseScenarioLocalService = linkUsecaseScenarioLocalService;
	}

	private LinkUsecaseScenarioLocalService _linkUsecaseScenarioLocalService;
}