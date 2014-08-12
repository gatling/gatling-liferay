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

import com.excilys.liferay.gatling.model.Request;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the request service. This utility wraps {@link RequestPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RequestPersistence
 * @see RequestPersistenceImpl
 * @generated
 */
public class RequestUtil {
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
	public static void clearCache(Request request) {
		getPersistence().clearCache(request);
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
	public static List<Request> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Request> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Request> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Request update(Request request) throws SystemException {
		return getPersistence().update(request);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Request update(Request request, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(request, serviceContext);
	}

	/**
	* Returns all the requests where scenario_id = &#63;.
	*
	* @param scenario_id the scenario_id
	* @return the matching requests
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.excilys.liferay.gatling.model.Request> findByScenarioId(
		long scenario_id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByScenarioId(scenario_id);
	}

	/**
	* Returns a range of all the requests where scenario_id = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.excilys.liferay.gatling.model.impl.RequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param scenario_id the scenario_id
	* @param start the lower bound of the range of requests
	* @param end the upper bound of the range of requests (not inclusive)
	* @return the range of matching requests
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.excilys.liferay.gatling.model.Request> findByScenarioId(
		long scenario_id, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByScenarioId(scenario_id, start, end);
	}

	/**
	* Returns an ordered range of all the requests where scenario_id = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.excilys.liferay.gatling.model.impl.RequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param scenario_id the scenario_id
	* @param start the lower bound of the range of requests
	* @param end the upper bound of the range of requests (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching requests
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.excilys.liferay.gatling.model.Request> findByScenarioId(
		long scenario_id, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByScenarioId(scenario_id, start, end, orderByComparator);
	}

	/**
	* Returns the first request in the ordered set where scenario_id = &#63;.
	*
	* @param scenario_id the scenario_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching request
	* @throws com.excilys.liferay.gatling.NoSuchRequestException if a matching request could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.excilys.liferay.gatling.model.Request findByScenarioId_First(
		long scenario_id,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.excilys.liferay.gatling.NoSuchRequestException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByScenarioId_First(scenario_id, orderByComparator);
	}

	/**
	* Returns the first request in the ordered set where scenario_id = &#63;.
	*
	* @param scenario_id the scenario_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching request, or <code>null</code> if a matching request could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.excilys.liferay.gatling.model.Request fetchByScenarioId_First(
		long scenario_id,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByScenarioId_First(scenario_id, orderByComparator);
	}

	/**
	* Returns the last request in the ordered set where scenario_id = &#63;.
	*
	* @param scenario_id the scenario_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching request
	* @throws com.excilys.liferay.gatling.NoSuchRequestException if a matching request could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.excilys.liferay.gatling.model.Request findByScenarioId_Last(
		long scenario_id,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.excilys.liferay.gatling.NoSuchRequestException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByScenarioId_Last(scenario_id, orderByComparator);
	}

	/**
	* Returns the last request in the ordered set where scenario_id = &#63;.
	*
	* @param scenario_id the scenario_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching request, or <code>null</code> if a matching request could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.excilys.liferay.gatling.model.Request fetchByScenarioId_Last(
		long scenario_id,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByScenarioId_Last(scenario_id, orderByComparator);
	}

	/**
	* Returns the requests before and after the current request in the ordered set where scenario_id = &#63;.
	*
	* @param request_id the primary key of the current request
	* @param scenario_id the scenario_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next request
	* @throws com.excilys.liferay.gatling.NoSuchRequestException if a request with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.excilys.liferay.gatling.model.Request[] findByScenarioId_PrevAndNext(
		long request_id, long scenario_id,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.excilys.liferay.gatling.NoSuchRequestException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByScenarioId_PrevAndNext(request_id, scenario_id,
			orderByComparator);
	}

	/**
	* Removes all the requests where scenario_id = &#63; from the database.
	*
	* @param scenario_id the scenario_id
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByScenarioId(long scenario_id)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByScenarioId(scenario_id);
	}

	/**
	* Returns the number of requests where scenario_id = &#63;.
	*
	* @param scenario_id the scenario_id
	* @return the number of matching requests
	* @throws SystemException if a system exception occurred
	*/
	public static int countByScenarioId(long scenario_id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByScenarioId(scenario_id);
	}

	/**
	* Returns all the requests where scenario_id = &#63; and weight &gt; &#63;.
	*
	* @param scenario_id the scenario_id
	* @param weight the weight
	* @return the matching requests
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.excilys.liferay.gatling.model.Request> findByScenarioIdAndUsed(
		long scenario_id, double weight)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByScenarioIdAndUsed(scenario_id, weight);
	}

	/**
	* Returns a range of all the requests where scenario_id = &#63; and weight &gt; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.excilys.liferay.gatling.model.impl.RequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param scenario_id the scenario_id
	* @param weight the weight
	* @param start the lower bound of the range of requests
	* @param end the upper bound of the range of requests (not inclusive)
	* @return the range of matching requests
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.excilys.liferay.gatling.model.Request> findByScenarioIdAndUsed(
		long scenario_id, double weight, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByScenarioIdAndUsed(scenario_id, weight, start, end);
	}

	/**
	* Returns an ordered range of all the requests where scenario_id = &#63; and weight &gt; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.excilys.liferay.gatling.model.impl.RequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param scenario_id the scenario_id
	* @param weight the weight
	* @param start the lower bound of the range of requests
	* @param end the upper bound of the range of requests (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching requests
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.excilys.liferay.gatling.model.Request> findByScenarioIdAndUsed(
		long scenario_id, double weight, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByScenarioIdAndUsed(scenario_id, weight, start, end,
			orderByComparator);
	}

	/**
	* Returns the first request in the ordered set where scenario_id = &#63; and weight &gt; &#63;.
	*
	* @param scenario_id the scenario_id
	* @param weight the weight
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching request
	* @throws com.excilys.liferay.gatling.NoSuchRequestException if a matching request could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.excilys.liferay.gatling.model.Request findByScenarioIdAndUsed_First(
		long scenario_id, double weight,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.excilys.liferay.gatling.NoSuchRequestException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByScenarioIdAndUsed_First(scenario_id, weight,
			orderByComparator);
	}

	/**
	* Returns the first request in the ordered set where scenario_id = &#63; and weight &gt; &#63;.
	*
	* @param scenario_id the scenario_id
	* @param weight the weight
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching request, or <code>null</code> if a matching request could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.excilys.liferay.gatling.model.Request fetchByScenarioIdAndUsed_First(
		long scenario_id, double weight,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByScenarioIdAndUsed_First(scenario_id, weight,
			orderByComparator);
	}

	/**
	* Returns the last request in the ordered set where scenario_id = &#63; and weight &gt; &#63;.
	*
	* @param scenario_id the scenario_id
	* @param weight the weight
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching request
	* @throws com.excilys.liferay.gatling.NoSuchRequestException if a matching request could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.excilys.liferay.gatling.model.Request findByScenarioIdAndUsed_Last(
		long scenario_id, double weight,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.excilys.liferay.gatling.NoSuchRequestException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByScenarioIdAndUsed_Last(scenario_id, weight,
			orderByComparator);
	}

	/**
	* Returns the last request in the ordered set where scenario_id = &#63; and weight &gt; &#63;.
	*
	* @param scenario_id the scenario_id
	* @param weight the weight
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching request, or <code>null</code> if a matching request could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.excilys.liferay.gatling.model.Request fetchByScenarioIdAndUsed_Last(
		long scenario_id, double weight,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByScenarioIdAndUsed_Last(scenario_id, weight,
			orderByComparator);
	}

	/**
	* Returns the requests before and after the current request in the ordered set where scenario_id = &#63; and weight &gt; &#63;.
	*
	* @param request_id the primary key of the current request
	* @param scenario_id the scenario_id
	* @param weight the weight
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next request
	* @throws com.excilys.liferay.gatling.NoSuchRequestException if a request with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.excilys.liferay.gatling.model.Request[] findByScenarioIdAndUsed_PrevAndNext(
		long request_id, long scenario_id, double weight,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.excilys.liferay.gatling.NoSuchRequestException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByScenarioIdAndUsed_PrevAndNext(request_id,
			scenario_id, weight, orderByComparator);
	}

	/**
	* Removes all the requests where scenario_id = &#63; and weight &gt; &#63; from the database.
	*
	* @param scenario_id the scenario_id
	* @param weight the weight
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByScenarioIdAndUsed(long scenario_id, double weight)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByScenarioIdAndUsed(scenario_id, weight);
	}

	/**
	* Returns the number of requests where scenario_id = &#63; and weight &gt; &#63;.
	*
	* @param scenario_id the scenario_id
	* @param weight the weight
	* @return the number of matching requests
	* @throws SystemException if a system exception occurred
	*/
	public static int countByScenarioIdAndUsed(long scenario_id, double weight)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByScenarioIdAndUsed(scenario_id, weight);
	}

	/**
	* Caches the request in the entity cache if it is enabled.
	*
	* @param request the request
	*/
	public static void cacheResult(
		com.excilys.liferay.gatling.model.Request request) {
		getPersistence().cacheResult(request);
	}

	/**
	* Caches the requests in the entity cache if it is enabled.
	*
	* @param requests the requests
	*/
	public static void cacheResult(
		java.util.List<com.excilys.liferay.gatling.model.Request> requests) {
		getPersistence().cacheResult(requests);
	}

	/**
	* Creates a new request with the primary key. Does not add the request to the database.
	*
	* @param request_id the primary key for the new request
	* @return the new request
	*/
	public static com.excilys.liferay.gatling.model.Request create(
		long request_id) {
		return getPersistence().create(request_id);
	}

	/**
	* Removes the request with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param request_id the primary key of the request
	* @return the request that was removed
	* @throws com.excilys.liferay.gatling.NoSuchRequestException if a request with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.excilys.liferay.gatling.model.Request remove(
		long request_id)
		throws com.excilys.liferay.gatling.NoSuchRequestException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(request_id);
	}

	public static com.excilys.liferay.gatling.model.Request updateImpl(
		com.excilys.liferay.gatling.model.Request request)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(request);
	}

	/**
	* Returns the request with the primary key or throws a {@link com.excilys.liferay.gatling.NoSuchRequestException} if it could not be found.
	*
	* @param request_id the primary key of the request
	* @return the request
	* @throws com.excilys.liferay.gatling.NoSuchRequestException if a request with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.excilys.liferay.gatling.model.Request findByPrimaryKey(
		long request_id)
		throws com.excilys.liferay.gatling.NoSuchRequestException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(request_id);
	}

	/**
	* Returns the request with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param request_id the primary key of the request
	* @return the request, or <code>null</code> if a request with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.excilys.liferay.gatling.model.Request fetchByPrimaryKey(
		long request_id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(request_id);
	}

	/**
	* Returns all the requests.
	*
	* @return the requests
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.excilys.liferay.gatling.model.Request> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the requests.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.excilys.liferay.gatling.model.impl.RequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of requests
	* @param end the upper bound of the range of requests (not inclusive)
	* @return the range of requests
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.excilys.liferay.gatling.model.Request> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the requests.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.excilys.liferay.gatling.model.impl.RequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of requests
	* @param end the upper bound of the range of requests (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of requests
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.excilys.liferay.gatling.model.Request> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the requests from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of requests.
	*
	* @return the number of requests
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static RequestPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (RequestPersistence)PortletBeanLocatorUtil.locate(com.excilys.liferay.gatling.service.ClpSerializer.getServletContextName(),
					RequestPersistence.class.getName());

			ReferenceRegistry.registerReference(RequestUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(RequestPersistence persistence) {
	}

	private static RequestPersistence _persistence;
}