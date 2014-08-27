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

import com.excilys.liferay.gatling.model.Usecase;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the usecase service. This utility wraps {@link UsecasePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UsecasePersistence
 * @see UsecasePersistenceImpl
 * @generated
 */
public class UsecaseUtil {
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
	public static void clearCache(Usecase usecase) {
		getPersistence().clearCache(usecase);
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
	public static List<Usecase> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Usecase> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Usecase> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Usecase update(Usecase usecase) throws SystemException {
		return getPersistence().update(usecase);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Usecase update(Usecase usecase, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(usecase, serviceContext);
	}

	/**
	* Caches the usecase in the entity cache if it is enabled.
	*
	* @param usecase the usecase
	*/
	public static void cacheResult(
		com.excilys.liferay.gatling.model.Usecase usecase) {
		getPersistence().cacheResult(usecase);
	}

	/**
	* Caches the usecases in the entity cache if it is enabled.
	*
	* @param usecases the usecases
	*/
	public static void cacheResult(
		java.util.List<com.excilys.liferay.gatling.model.Usecase> usecases) {
		getPersistence().cacheResult(usecases);
	}

	/**
	* Creates a new usecase with the primary key. Does not add the usecase to the database.
	*
	* @param usecaseId the primary key for the new usecase
	* @return the new usecase
	*/
	public static com.excilys.liferay.gatling.model.Usecase create(
		long usecaseId) {
		return getPersistence().create(usecaseId);
	}

	/**
	* Removes the usecase with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param usecaseId the primary key of the usecase
	* @return the usecase that was removed
	* @throws com.excilys.liferay.gatling.NoSuchUsecaseException if a usecase with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.excilys.liferay.gatling.model.Usecase remove(
		long usecaseId)
		throws com.excilys.liferay.gatling.NoSuchUsecaseException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(usecaseId);
	}

	public static com.excilys.liferay.gatling.model.Usecase updateImpl(
		com.excilys.liferay.gatling.model.Usecase usecase)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(usecase);
	}

	/**
	* Returns the usecase with the primary key or throws a {@link com.excilys.liferay.gatling.NoSuchUsecaseException} if it could not be found.
	*
	* @param usecaseId the primary key of the usecase
	* @return the usecase
	* @throws com.excilys.liferay.gatling.NoSuchUsecaseException if a usecase with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.excilys.liferay.gatling.model.Usecase findByPrimaryKey(
		long usecaseId)
		throws com.excilys.liferay.gatling.NoSuchUsecaseException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(usecaseId);
	}

	/**
	* Returns the usecase with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param usecaseId the primary key of the usecase
	* @return the usecase, or <code>null</code> if a usecase with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.excilys.liferay.gatling.model.Usecase fetchByPrimaryKey(
		long usecaseId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(usecaseId);
	}

	/**
	* Returns all the usecases.
	*
	* @return the usecases
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.excilys.liferay.gatling.model.Usecase> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<com.excilys.liferay.gatling.model.Usecase> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the usecases.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.excilys.liferay.gatling.model.impl.UsecaseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of usecases
	* @param end the upper bound of the range of usecases (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of usecases
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.excilys.liferay.gatling.model.Usecase> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the usecases from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of usecases.
	*
	* @return the number of usecases
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static UsecasePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (UsecasePersistence)PortletBeanLocatorUtil.locate(com.excilys.liferay.gatling.service.ClpSerializer.getServletContextName(),
					UsecasePersistence.class.getName());

			ReferenceRegistry.registerReference(UsecaseUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(UsecasePersistence persistence) {
	}

	private static UsecasePersistence _persistence;
}