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

import com.excilys.liferay.gatling.model.UrlUsecase;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the url usecase service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UrlUsecasePersistenceImpl
 * @see UrlUsecaseUtil
 * @generated
 */
public interface UrlUsecasePersistence extends BasePersistence<UrlUsecase> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link UrlUsecaseUtil} to access the url usecase persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the url usecase in the entity cache if it is enabled.
	*
	* @param urlUsecase the url usecase
	*/
	public void cacheResult(
		com.excilys.liferay.gatling.model.UrlUsecase urlUsecase);

	/**
	* Caches the url usecases in the entity cache if it is enabled.
	*
	* @param urlUsecases the url usecases
	*/
	public void cacheResult(
		java.util.List<com.excilys.liferay.gatling.model.UrlUsecase> urlUsecases);

	/**
	* Creates a new url usecase with the primary key. Does not add the url usecase to the database.
	*
	* @param urlUsecaseId the primary key for the new url usecase
	* @return the new url usecase
	*/
	public com.excilys.liferay.gatling.model.UrlUsecase create(
		long urlUsecaseId);

	/**
	* Removes the url usecase with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param urlUsecaseId the primary key of the url usecase
	* @return the url usecase that was removed
	* @throws com.excilys.liferay.gatling.NoSuchUrlUsecaseException if a url usecase with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.excilys.liferay.gatling.model.UrlUsecase remove(
		long urlUsecaseId)
		throws com.excilys.liferay.gatling.NoSuchUrlUsecaseException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.excilys.liferay.gatling.model.UrlUsecase updateImpl(
		com.excilys.liferay.gatling.model.UrlUsecase urlUsecase)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the url usecase with the primary key or throws a {@link com.excilys.liferay.gatling.NoSuchUrlUsecaseException} if it could not be found.
	*
	* @param urlUsecaseId the primary key of the url usecase
	* @return the url usecase
	* @throws com.excilys.liferay.gatling.NoSuchUrlUsecaseException if a url usecase with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.excilys.liferay.gatling.model.UrlUsecase findByPrimaryKey(
		long urlUsecaseId)
		throws com.excilys.liferay.gatling.NoSuchUrlUsecaseException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the url usecase with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param urlUsecaseId the primary key of the url usecase
	* @return the url usecase, or <code>null</code> if a url usecase with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.excilys.liferay.gatling.model.UrlUsecase fetchByPrimaryKey(
		long urlUsecaseId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the url usecases.
	*
	* @return the url usecases
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.excilys.liferay.gatling.model.UrlUsecase> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the url usecases.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.excilys.liferay.gatling.model.impl.UrlUsecaseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of url usecases
	* @param end the upper bound of the range of url usecases (not inclusive)
	* @return the range of url usecases
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.excilys.liferay.gatling.model.UrlUsecase> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the url usecases.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.excilys.liferay.gatling.model.impl.UrlUsecaseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of url usecases
	* @param end the upper bound of the range of url usecases (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of url usecases
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.excilys.liferay.gatling.model.UrlUsecase> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the url usecases from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of url usecases.
	*
	* @return the number of url usecases
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}