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

import com.excilys.liferay.gatling.model.LinkUsecaseRequest;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the link usecase request service. This utility wraps {@link LinkUsecaseRequestPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LinkUsecaseRequestPersistence
 * @see LinkUsecaseRequestPersistenceImpl
 * @generated
 */
public class LinkUsecaseRequestUtil {
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
	public static void clearCache(LinkUsecaseRequest linkUsecaseRequest) {
		getPersistence().clearCache(linkUsecaseRequest);
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
	public static List<LinkUsecaseRequest> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<LinkUsecaseRequest> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<LinkUsecaseRequest> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static LinkUsecaseRequest update(
		LinkUsecaseRequest linkUsecaseRequest) throws SystemException {
		return getPersistence().update(linkUsecaseRequest);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static LinkUsecaseRequest update(
		LinkUsecaseRequest linkUsecaseRequest, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(linkUsecaseRequest, serviceContext);
	}

	/**
	* Returns all the link usecase requests where request_id = &#63; and weight &gt; &#63;.
	*
	* @param request_id the request_id
	* @param weight the weight
	* @return the matching link usecase requests
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.excilys.liferay.gatling.model.LinkUsecaseRequest> findByRequestIdAndUsed(
		long request_id, double weight)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByRequestIdAndUsed(request_id, weight);
	}

	/**
	* Returns a range of all the link usecase requests where request_id = &#63; and weight &gt; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.excilys.liferay.gatling.model.impl.LinkUsecaseRequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param request_id the request_id
	* @param weight the weight
	* @param start the lower bound of the range of link usecase requests
	* @param end the upper bound of the range of link usecase requests (not inclusive)
	* @return the range of matching link usecase requests
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.excilys.liferay.gatling.model.LinkUsecaseRequest> findByRequestIdAndUsed(
		long request_id, double weight, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByRequestIdAndUsed(request_id, weight, start, end);
	}

	/**
	* Returns an ordered range of all the link usecase requests where request_id = &#63; and weight &gt; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.excilys.liferay.gatling.model.impl.LinkUsecaseRequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param request_id the request_id
	* @param weight the weight
	* @param start the lower bound of the range of link usecase requests
	* @param end the upper bound of the range of link usecase requests (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching link usecase requests
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.excilys.liferay.gatling.model.LinkUsecaseRequest> findByRequestIdAndUsed(
		long request_id, double weight, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByRequestIdAndUsed(request_id, weight, start, end,
			orderByComparator);
	}

	/**
	* Returns the first link usecase request in the ordered set where request_id = &#63; and weight &gt; &#63;.
	*
	* @param request_id the request_id
	* @param weight the weight
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching link usecase request
	* @throws com.excilys.liferay.gatling.NoSuchLinkUsecaseRequestException if a matching link usecase request could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.excilys.liferay.gatling.model.LinkUsecaseRequest findByRequestIdAndUsed_First(
		long request_id, double weight,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.excilys.liferay.gatling.NoSuchLinkUsecaseRequestException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByRequestIdAndUsed_First(request_id, weight,
			orderByComparator);
	}

	/**
	* Returns the first link usecase request in the ordered set where request_id = &#63; and weight &gt; &#63;.
	*
	* @param request_id the request_id
	* @param weight the weight
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching link usecase request, or <code>null</code> if a matching link usecase request could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.excilys.liferay.gatling.model.LinkUsecaseRequest fetchByRequestIdAndUsed_First(
		long request_id, double weight,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByRequestIdAndUsed_First(request_id, weight,
			orderByComparator);
	}

	/**
	* Returns the last link usecase request in the ordered set where request_id = &#63; and weight &gt; &#63;.
	*
	* @param request_id the request_id
	* @param weight the weight
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching link usecase request
	* @throws com.excilys.liferay.gatling.NoSuchLinkUsecaseRequestException if a matching link usecase request could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.excilys.liferay.gatling.model.LinkUsecaseRequest findByRequestIdAndUsed_Last(
		long request_id, double weight,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.excilys.liferay.gatling.NoSuchLinkUsecaseRequestException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByRequestIdAndUsed_Last(request_id, weight,
			orderByComparator);
	}

	/**
	* Returns the last link usecase request in the ordered set where request_id = &#63; and weight &gt; &#63;.
	*
	* @param request_id the request_id
	* @param weight the weight
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching link usecase request, or <code>null</code> if a matching link usecase request could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.excilys.liferay.gatling.model.LinkUsecaseRequest fetchByRequestIdAndUsed_Last(
		long request_id, double weight,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByRequestIdAndUsed_Last(request_id, weight,
			orderByComparator);
	}

	/**
	* Returns the link usecase requests before and after the current link usecase request in the ordered set where request_id = &#63; and weight &gt; &#63;.
	*
	* @param linkUsecaseRequestId the primary key of the current link usecase request
	* @param request_id the request_id
	* @param weight the weight
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next link usecase request
	* @throws com.excilys.liferay.gatling.NoSuchLinkUsecaseRequestException if a link usecase request with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.excilys.liferay.gatling.model.LinkUsecaseRequest[] findByRequestIdAndUsed_PrevAndNext(
		long linkUsecaseRequestId, long request_id, double weight,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.excilys.liferay.gatling.NoSuchLinkUsecaseRequestException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByRequestIdAndUsed_PrevAndNext(linkUsecaseRequestId,
			request_id, weight, orderByComparator);
	}

	/**
	* Removes all the link usecase requests where request_id = &#63; and weight &gt; &#63; from the database.
	*
	* @param request_id the request_id
	* @param weight the weight
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByRequestIdAndUsed(long request_id, double weight)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByRequestIdAndUsed(request_id, weight);
	}

	/**
	* Returns the number of link usecase requests where request_id = &#63; and weight &gt; &#63;.
	*
	* @param request_id the request_id
	* @param weight the weight
	* @return the number of matching link usecase requests
	* @throws SystemException if a system exception occurred
	*/
	public static int countByRequestIdAndUsed(long request_id, double weight)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByRequestIdAndUsed(request_id, weight);
	}

	/**
	* Caches the link usecase request in the entity cache if it is enabled.
	*
	* @param linkUsecaseRequest the link usecase request
	*/
	public static void cacheResult(
		com.excilys.liferay.gatling.model.LinkUsecaseRequest linkUsecaseRequest) {
		getPersistence().cacheResult(linkUsecaseRequest);
	}

	/**
	* Caches the link usecase requests in the entity cache if it is enabled.
	*
	* @param linkUsecaseRequests the link usecase requests
	*/
	public static void cacheResult(
		java.util.List<com.excilys.liferay.gatling.model.LinkUsecaseRequest> linkUsecaseRequests) {
		getPersistence().cacheResult(linkUsecaseRequests);
	}

	/**
	* Creates a new link usecase request with the primary key. Does not add the link usecase request to the database.
	*
	* @param linkUsecaseRequestId the primary key for the new link usecase request
	* @return the new link usecase request
	*/
	public static com.excilys.liferay.gatling.model.LinkUsecaseRequest create(
		long linkUsecaseRequestId) {
		return getPersistence().create(linkUsecaseRequestId);
	}

	/**
	* Removes the link usecase request with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param linkUsecaseRequestId the primary key of the link usecase request
	* @return the link usecase request that was removed
	* @throws com.excilys.liferay.gatling.NoSuchLinkUsecaseRequestException if a link usecase request with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.excilys.liferay.gatling.model.LinkUsecaseRequest remove(
		long linkUsecaseRequestId)
		throws com.excilys.liferay.gatling.NoSuchLinkUsecaseRequestException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(linkUsecaseRequestId);
	}

	public static com.excilys.liferay.gatling.model.LinkUsecaseRequest updateImpl(
		com.excilys.liferay.gatling.model.LinkUsecaseRequest linkUsecaseRequest)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(linkUsecaseRequest);
	}

	/**
	* Returns the link usecase request with the primary key or throws a {@link com.excilys.liferay.gatling.NoSuchLinkUsecaseRequestException} if it could not be found.
	*
	* @param linkUsecaseRequestId the primary key of the link usecase request
	* @return the link usecase request
	* @throws com.excilys.liferay.gatling.NoSuchLinkUsecaseRequestException if a link usecase request with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.excilys.liferay.gatling.model.LinkUsecaseRequest findByPrimaryKey(
		long linkUsecaseRequestId)
		throws com.excilys.liferay.gatling.NoSuchLinkUsecaseRequestException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(linkUsecaseRequestId);
	}

	/**
	* Returns the link usecase request with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param linkUsecaseRequestId the primary key of the link usecase request
	* @return the link usecase request, or <code>null</code> if a link usecase request with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.excilys.liferay.gatling.model.LinkUsecaseRequest fetchByPrimaryKey(
		long linkUsecaseRequestId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(linkUsecaseRequestId);
	}

	/**
	* Returns all the link usecase requests.
	*
	* @return the link usecase requests
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.excilys.liferay.gatling.model.LinkUsecaseRequest> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<com.excilys.liferay.gatling.model.LinkUsecaseRequest> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the link usecase requests.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.excilys.liferay.gatling.model.impl.LinkUsecaseRequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of link usecase requests
	* @param end the upper bound of the range of link usecase requests (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of link usecase requests
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.excilys.liferay.gatling.model.LinkUsecaseRequest> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the link usecase requests from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of link usecase requests.
	*
	* @return the number of link usecase requests
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static LinkUsecaseRequestPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (LinkUsecaseRequestPersistence)PortletBeanLocatorUtil.locate(com.excilys.liferay.gatling.service.ClpSerializer.getServletContextName(),
					LinkUsecaseRequestPersistence.class.getName());

			ReferenceRegistry.registerReference(LinkUsecaseRequestUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(LinkUsecaseRequestPersistence persistence) {
	}

	private static LinkUsecaseRequestPersistence _persistence;
}