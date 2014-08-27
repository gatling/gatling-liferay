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

import com.excilys.liferay.gatling.model.LinkUsecasePortletStress;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the link usecase portlet stress service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LinkUsecasePortletStressPersistenceImpl
 * @see LinkUsecasePortletStressUtil
 * @generated
 */
public interface LinkUsecasePortletStressPersistence extends BasePersistence<LinkUsecasePortletStress> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LinkUsecasePortletStressUtil} to access the link usecase portlet stress persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the link usecase portlet stress in the entity cache if it is enabled.
	*
	* @param linkUsecasePortletStress the link usecase portlet stress
	*/
	public void cacheResult(
		com.excilys.liferay.gatling.model.LinkUsecasePortletStress linkUsecasePortletStress);

	/**
	* Caches the link usecase portlet stresses in the entity cache if it is enabled.
	*
	* @param linkUsecasePortletStresses the link usecase portlet stresses
	*/
	public void cacheResult(
		java.util.List<com.excilys.liferay.gatling.model.LinkUsecasePortletStress> linkUsecasePortletStresses);

	/**
	* Creates a new link usecase portlet stress with the primary key. Does not add the link usecase portlet stress to the database.
	*
	* @param linkUsecasePortletStressId the primary key for the new link usecase portlet stress
	* @return the new link usecase portlet stress
	*/
	public com.excilys.liferay.gatling.model.LinkUsecasePortletStress create(
		long linkUsecasePortletStressId);

	/**
	* Removes the link usecase portlet stress with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param linkUsecasePortletStressId the primary key of the link usecase portlet stress
	* @return the link usecase portlet stress that was removed
	* @throws com.excilys.liferay.gatling.NoSuchLinkUsecasePortletStressException if a link usecase portlet stress with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.excilys.liferay.gatling.model.LinkUsecasePortletStress remove(
		long linkUsecasePortletStressId)
		throws com.excilys.liferay.gatling.NoSuchLinkUsecasePortletStressException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.excilys.liferay.gatling.model.LinkUsecasePortletStress updateImpl(
		com.excilys.liferay.gatling.model.LinkUsecasePortletStress linkUsecasePortletStress)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the link usecase portlet stress with the primary key or throws a {@link com.excilys.liferay.gatling.NoSuchLinkUsecasePortletStressException} if it could not be found.
	*
	* @param linkUsecasePortletStressId the primary key of the link usecase portlet stress
	* @return the link usecase portlet stress
	* @throws com.excilys.liferay.gatling.NoSuchLinkUsecasePortletStressException if a link usecase portlet stress with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.excilys.liferay.gatling.model.LinkUsecasePortletStress findByPrimaryKey(
		long linkUsecasePortletStressId)
		throws com.excilys.liferay.gatling.NoSuchLinkUsecasePortletStressException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the link usecase portlet stress with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param linkUsecasePortletStressId the primary key of the link usecase portlet stress
	* @return the link usecase portlet stress, or <code>null</code> if a link usecase portlet stress with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.excilys.liferay.gatling.model.LinkUsecasePortletStress fetchByPrimaryKey(
		long linkUsecasePortletStressId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the link usecase portlet stresses.
	*
	* @return the link usecase portlet stresses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.excilys.liferay.gatling.model.LinkUsecasePortletStress> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.excilys.liferay.gatling.model.LinkUsecasePortletStress> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the link usecase portlet stresses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.excilys.liferay.gatling.model.impl.LinkUsecasePortletStressModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of link usecase portlet stresses
	* @param end the upper bound of the range of link usecase portlet stresses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of link usecase portlet stresses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.excilys.liferay.gatling.model.LinkUsecasePortletStress> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the link usecase portlet stresses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of link usecase portlet stresses.
	*
	* @return the number of link usecase portlet stresses
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}