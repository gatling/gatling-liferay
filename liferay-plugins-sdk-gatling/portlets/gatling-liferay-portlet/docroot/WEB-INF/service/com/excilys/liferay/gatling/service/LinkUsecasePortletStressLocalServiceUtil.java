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
 * Provides the local service utility for LinkUsecasePortletStress. This utility wraps
 * {@link com.excilys.liferay.gatling.service.impl.LinkUsecasePortletStressLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see LinkUsecasePortletStressLocalService
 * @see com.excilys.liferay.gatling.service.base.LinkUsecasePortletStressLocalServiceBaseImpl
 * @see com.excilys.liferay.gatling.service.impl.LinkUsecasePortletStressLocalServiceImpl
 * @generated
 */
public class LinkUsecasePortletStressLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.excilys.liferay.gatling.service.impl.LinkUsecasePortletStressLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the link usecase portlet stress to the database. Also notifies the appropriate model listeners.
	*
	* @param linkUsecasePortletStress the link usecase portlet stress
	* @return the link usecase portlet stress that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.excilys.liferay.gatling.model.LinkUsecasePortletStress addLinkUsecasePortletStress(
		com.excilys.liferay.gatling.model.LinkUsecasePortletStress linkUsecasePortletStress)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addLinkUsecasePortletStress(linkUsecasePortletStress);
	}

	/**
	* Creates a new link usecase portlet stress with the primary key. Does not add the link usecase portlet stress to the database.
	*
	* @param linkUsecasePortletStressId the primary key for the new link usecase portlet stress
	* @return the new link usecase portlet stress
	*/
	public static com.excilys.liferay.gatling.model.LinkUsecasePortletStress createLinkUsecasePortletStress(
		long linkUsecasePortletStressId) {
		return getService()
				   .createLinkUsecasePortletStress(linkUsecasePortletStressId);
	}

	/**
	* Deletes the link usecase portlet stress with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param linkUsecasePortletStressId the primary key of the link usecase portlet stress
	* @return the link usecase portlet stress that was removed
	* @throws PortalException if a link usecase portlet stress with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.excilys.liferay.gatling.model.LinkUsecasePortletStress deleteLinkUsecasePortletStress(
		long linkUsecasePortletStressId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .deleteLinkUsecasePortletStress(linkUsecasePortletStressId);
	}

	/**
	* Deletes the link usecase portlet stress from the database. Also notifies the appropriate model listeners.
	*
	* @param linkUsecasePortletStress the link usecase portlet stress
	* @return the link usecase portlet stress that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.excilys.liferay.gatling.model.LinkUsecasePortletStress deleteLinkUsecasePortletStress(
		com.excilys.liferay.gatling.model.LinkUsecasePortletStress linkUsecasePortletStress)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .deleteLinkUsecasePortletStress(linkUsecasePortletStress);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.excilys.liferay.gatling.model.impl.LinkUsecasePortletStressModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.excilys.liferay.gatling.model.impl.LinkUsecasePortletStressModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.excilys.liferay.gatling.model.LinkUsecasePortletStress fetchLinkUsecasePortletStress(
		long linkUsecasePortletStressId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .fetchLinkUsecasePortletStress(linkUsecasePortletStressId);
	}

	/**
	* Returns the link usecase portlet stress with the primary key.
	*
	* @param linkUsecasePortletStressId the primary key of the link usecase portlet stress
	* @return the link usecase portlet stress
	* @throws PortalException if a link usecase portlet stress with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.excilys.liferay.gatling.model.LinkUsecasePortletStress getLinkUsecasePortletStress(
		long linkUsecasePortletStressId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getLinkUsecasePortletStress(linkUsecasePortletStressId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the link usecase portlet stresses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.excilys.liferay.gatling.model.impl.LinkUsecasePortletStressModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of link usecase portlet stresses
	* @param end the upper bound of the range of link usecase portlet stresses (not inclusive)
	* @return the range of link usecase portlet stresses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.excilys.liferay.gatling.model.LinkUsecasePortletStress> getLinkUsecasePortletStresses(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getLinkUsecasePortletStresses(start, end);
	}

	/**
	* Returns the number of link usecase portlet stresses.
	*
	* @return the number of link usecase portlet stresses
	* @throws SystemException if a system exception occurred
	*/
	public static int getLinkUsecasePortletStressesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getLinkUsecasePortletStressesCount();
	}

	/**
	* Updates the link usecase portlet stress in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param linkUsecasePortletStress the link usecase portlet stress
	* @return the link usecase portlet stress that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.excilys.liferay.gatling.model.LinkUsecasePortletStress updateLinkUsecasePortletStress(
		com.excilys.liferay.gatling.model.LinkUsecasePortletStress linkUsecasePortletStress)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateLinkUsecasePortletStress(linkUsecasePortletStress);
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

	public static void clearService() {
		_service = null;
	}

	public static LinkUsecasePortletStressLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					LinkUsecasePortletStressLocalService.class.getName());

			if (invokableLocalService instanceof LinkUsecasePortletStressLocalService) {
				_service = (LinkUsecasePortletStressLocalService)invokableLocalService;
			}
			else {
				_service = new LinkUsecasePortletStressLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(LinkUsecasePortletStressLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(LinkUsecasePortletStressLocalService service) {
	}

	private static LinkUsecasePortletStressLocalService _service;
}