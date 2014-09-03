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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for LinkUsecaseRequest. This utility wraps
 * {@link com.excilys.liferay.gatling.service.impl.LinkUsecaseRequestLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see LinkUsecaseRequestLocalService
 * @see com.excilys.liferay.gatling.service.base.LinkUsecaseRequestLocalServiceBaseImpl
 * @see com.excilys.liferay.gatling.service.impl.LinkUsecaseRequestLocalServiceImpl
 * @generated
 */
public class LinkUsecaseRequestLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.excilys.liferay.gatling.service.impl.LinkUsecaseRequestLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the link usecase request to the database. Also notifies the appropriate model listeners.
	*
	* @param linkUsecaseRequest the link usecase request
	* @return the link usecase request that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.excilys.liferay.gatling.model.LinkUsecaseRequest addLinkUsecaseRequest(
		com.excilys.liferay.gatling.model.LinkUsecaseRequest linkUsecaseRequest)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addLinkUsecaseRequest(linkUsecaseRequest);
	}

	/**
	* Creates a new link usecase request with the primary key. Does not add the link usecase request to the database.
	*
	* @param linkUsecaseRequestId the primary key for the new link usecase request
	* @return the new link usecase request
	*/
	public static com.excilys.liferay.gatling.model.LinkUsecaseRequest createLinkUsecaseRequest(
		long linkUsecaseRequestId) {
		return getService().createLinkUsecaseRequest(linkUsecaseRequestId);
	}

	/**
	* Deletes the link usecase request with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param linkUsecaseRequestId the primary key of the link usecase request
	* @return the link usecase request that was removed
	* @throws PortalException if a link usecase request with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.excilys.liferay.gatling.model.LinkUsecaseRequest deleteLinkUsecaseRequest(
		long linkUsecaseRequestId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteLinkUsecaseRequest(linkUsecaseRequestId);
	}

	/**
	* Deletes the link usecase request from the database. Also notifies the appropriate model listeners.
	*
	* @param linkUsecaseRequest the link usecase request
	* @return the link usecase request that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.excilys.liferay.gatling.model.LinkUsecaseRequest deleteLinkUsecaseRequest(
		com.excilys.liferay.gatling.model.LinkUsecaseRequest linkUsecaseRequest)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteLinkUsecaseRequest(linkUsecaseRequest);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.excilys.liferay.gatling.model.impl.LinkUsecaseRequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.excilys.liferay.gatling.model.impl.LinkUsecaseRequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.excilys.liferay.gatling.model.LinkUsecaseRequest fetchLinkUsecaseRequest(
		long linkUsecaseRequestId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchLinkUsecaseRequest(linkUsecaseRequestId);
	}

	/**
	* Returns the link usecase request with the primary key.
	*
	* @param linkUsecaseRequestId the primary key of the link usecase request
	* @return the link usecase request
	* @throws PortalException if a link usecase request with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.excilys.liferay.gatling.model.LinkUsecaseRequest getLinkUsecaseRequest(
		long linkUsecaseRequestId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getLinkUsecaseRequest(linkUsecaseRequestId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the link usecase requests.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.excilys.liferay.gatling.model.impl.LinkUsecaseRequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of link usecase requests
	* @param end the upper bound of the range of link usecase requests (not inclusive)
	* @return the range of link usecase requests
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.excilys.liferay.gatling.model.LinkUsecaseRequest> getLinkUsecaseRequests(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getLinkUsecaseRequests(start, end);
	}

	/**
	* Returns the number of link usecase requests.
	*
	* @return the number of link usecase requests
	* @throws SystemException if a system exception occurred
	*/
	public static int getLinkUsecaseRequestsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getLinkUsecaseRequestsCount();
	}

	/**
	* Updates the link usecase request in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param linkUsecaseRequest the link usecase request
	* @return the link usecase request that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.excilys.liferay.gatling.model.LinkUsecaseRequest updateLinkUsecaseRequest(
		com.excilys.liferay.gatling.model.LinkUsecaseRequest linkUsecaseRequest)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateLinkUsecaseRequest(linkUsecaseRequest);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static void saveLinkUseCase(long linkUsecaseRequestId,
		long requestId, long recordId, double weight, boolean isSample) {
		getService()
			.saveLinkUseCase(linkUsecaseRequestId, requestId, recordId, weight,
			isSample);
	}

	/**
	* get {@link LinkUsecaseRequest} have this requestId
	*/
	public static java.util.List<com.excilys.liferay.gatling.model.LinkUsecaseRequest> findByRecordAndRequest(
		long requestId, long recordId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByRecordAndRequest(requestId, recordId);
	}

	public static java.util.List<com.excilys.liferay.gatling.model.LinkUsecaseRequest> findByRequestIdAndUsed(
		long requestId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByRequestIdAndUsed(requestId);
	}

	public static int countByRequestIdAndUsed(long requestId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().countByRequestIdAndUsed(requestId);
	}

	public static void removeByRequestId(long requestId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().removeByRequestId(requestId);
	}

	public static int countByRequestId(long requestId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().countByRequestId(requestId);
	}

	public static java.util.List<com.excilys.liferay.gatling.model.LinkUsecaseRequest> findByRequestId(
		long requestId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByRequestId(requestId);
	}

	public static void clearService() {
		_service = null;
	}

	public static LinkUsecaseRequestLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					LinkUsecaseRequestLocalService.class.getName());

			if (invokableLocalService instanceof LinkUsecaseRequestLocalService) {
				_service = (LinkUsecaseRequestLocalService)invokableLocalService;
			}
			else {
				_service = new LinkUsecaseRequestLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(LinkUsecaseRequestLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(LinkUsecaseRequestLocalService service) {
	}

	private static LinkUsecaseRequestLocalService _service;
}