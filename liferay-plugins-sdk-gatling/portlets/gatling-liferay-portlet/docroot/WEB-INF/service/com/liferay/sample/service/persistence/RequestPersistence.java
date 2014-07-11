/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 *
 *
 *
 */

package com.liferay.sample.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import com.liferay.sample.model.Request;

/**
 * The persistence interface for the request service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author sana
 * @see RequestPersistenceImpl
 * @see RequestUtil
 * @generated
 */
public interface RequestPersistence extends BasePersistence<Request> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link RequestUtil} to access the request persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the requests where scenario_id = &#63;.
	*
	* @param scenario_id the scenario_id
	* @return the matching requests
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.sample.model.Request> findByScenarioId(
		long scenario_id)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the requests where scenario_id = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.sample.model.impl.RequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param scenario_id the scenario_id
	* @param start the lower bound of the range of requests
	* @param end the upper bound of the range of requests (not inclusive)
	* @return the range of matching requests
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.sample.model.Request> findByScenarioId(
		long scenario_id, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the requests where scenario_id = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.sample.model.impl.RequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param scenario_id the scenario_id
	* @param start the lower bound of the range of requests
	* @param end the upper bound of the range of requests (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching requests
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.sample.model.Request> findByScenarioId(
		long scenario_id, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first request in the ordered set where scenario_id = &#63;.
	*
	* @param scenario_id the scenario_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching request
	* @throws com.liferay.sample.NoSuchRequestException if a matching request could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.sample.model.Request findByScenarioId_First(
		long scenario_id,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.sample.NoSuchRequestException;

	/**
	* Returns the first request in the ordered set where scenario_id = &#63;.
	*
	* @param scenario_id the scenario_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching request, or <code>null</code> if a matching request could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.sample.model.Request fetchByScenarioId_First(
		long scenario_id,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last request in the ordered set where scenario_id = &#63;.
	*
	* @param scenario_id the scenario_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching request
	* @throws com.liferay.sample.NoSuchRequestException if a matching request could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.sample.model.Request findByScenarioId_Last(
		long scenario_id,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.sample.NoSuchRequestException;

	/**
	* Returns the last request in the ordered set where scenario_id = &#63;.
	*
	* @param scenario_id the scenario_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching request, or <code>null</code> if a matching request could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.sample.model.Request fetchByScenarioId_Last(
		long scenario_id,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the requests before and after the current request in the ordered set where scenario_id = &#63;.
	*
	* @param request_id the primary key of the current request
	* @param scenario_id the scenario_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next request
	* @throws com.liferay.sample.NoSuchRequestException if a request with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.sample.model.Request[] findByScenarioId_PrevAndNext(
		long request_id, long scenario_id,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.sample.NoSuchRequestException;

	/**
	* Removes all the requests where scenario_id = &#63; from the database.
	*
	* @param scenario_id the scenario_id
	* @throws SystemException if a system exception occurred
	*/
	public void removeByScenarioId(long scenario_id)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of requests where scenario_id = &#63;.
	*
	* @param scenario_id the scenario_id
	* @return the number of matching requests
	* @throws SystemException if a system exception occurred
	*/
	public int countByScenarioId(long scenario_id)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the request in the entity cache if it is enabled.
	*
	* @param request the request
	*/
	public void cacheResult(com.liferay.sample.model.Request request);

	/**
	* Caches the requests in the entity cache if it is enabled.
	*
	* @param requests the requests
	*/
	public void cacheResult(
		java.util.List<com.liferay.sample.model.Request> requests);

	/**
	* Creates a new request with the primary key. Does not add the request to the database.
	*
	* @param request_id the primary key for the new request
	* @return the new request
	*/
	public com.liferay.sample.model.Request create(long request_id);

	/**
	* Removes the request with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param request_id the primary key of the request
	* @return the request that was removed
	* @throws com.liferay.sample.NoSuchRequestException if a request with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.sample.model.Request remove(long request_id)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.sample.NoSuchRequestException;

	public com.liferay.sample.model.Request updateImpl(
		com.liferay.sample.model.Request request)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the request with the primary key or throws a {@link com.liferay.sample.NoSuchRequestException} if it could not be found.
	*
	* @param request_id the primary key of the request
	* @return the request
	* @throws com.liferay.sample.NoSuchRequestException if a request with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.sample.model.Request findByPrimaryKey(long request_id)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.sample.NoSuchRequestException;

	/**
	* Returns the request with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param request_id the primary key of the request
	* @return the request, or <code>null</code> if a request with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.sample.model.Request fetchByPrimaryKey(long request_id)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the requests.
	*
	* @return the requests
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.sample.model.Request> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the requests.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.sample.model.impl.RequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of requests
	* @param end the upper bound of the range of requests (not inclusive)
	* @return the range of requests
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.sample.model.Request> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the requests.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.sample.model.impl.RequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of requests
	* @param end the upper bound of the range of requests (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of requests
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.sample.model.Request> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the requests from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of requests.
	*
	* @return the number of requests
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}