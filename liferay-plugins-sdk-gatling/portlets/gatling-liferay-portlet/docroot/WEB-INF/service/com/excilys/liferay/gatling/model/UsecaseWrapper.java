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

package com.excilys.liferay.gatling.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Usecase}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Usecase
 * @generated
 */
public class UsecaseWrapper implements Usecase, ModelWrapper<Usecase> {
	public UsecaseWrapper(Usecase usecase) {
		_usecase = usecase;
	}

	@Override
	public Class<?> getModelClass() {
		return Usecase.class;
	}

	@Override
	public String getModelClassName() {
		return Usecase.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("usecaseId", getUsecaseId());
		attributes.put("portletId", getPortletId());
		attributes.put("versionPortlet", getVersionPortlet());
		attributes.put("name", getName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long usecaseId = (Long)attributes.get("usecaseId");

		if (usecaseId != null) {
			setUsecaseId(usecaseId);
		}

		Long portletId = (Long)attributes.get("portletId");

		if (portletId != null) {
			setPortletId(portletId);
		}

		Long versionPortlet = (Long)attributes.get("versionPortlet");

		if (versionPortlet != null) {
			setVersionPortlet(versionPortlet);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}
	}

	/**
	* Returns the primary key of this usecase.
	*
	* @return the primary key of this usecase
	*/
	@Override
	public long getPrimaryKey() {
		return _usecase.getPrimaryKey();
	}

	/**
	* Sets the primary key of this usecase.
	*
	* @param primaryKey the primary key of this usecase
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_usecase.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the usecase ID of this usecase.
	*
	* @return the usecase ID of this usecase
	*/
	@Override
	public long getUsecaseId() {
		return _usecase.getUsecaseId();
	}

	/**
	* Sets the usecase ID of this usecase.
	*
	* @param usecaseId the usecase ID of this usecase
	*/
	@Override
	public void setUsecaseId(long usecaseId) {
		_usecase.setUsecaseId(usecaseId);
	}

	/**
	* Returns the portlet ID of this usecase.
	*
	* @return the portlet ID of this usecase
	*/
	@Override
	public long getPortletId() {
		return _usecase.getPortletId();
	}

	/**
	* Sets the portlet ID of this usecase.
	*
	* @param portletId the portlet ID of this usecase
	*/
	@Override
	public void setPortletId(long portletId) {
		_usecase.setPortletId(portletId);
	}

	/**
	* Returns the version portlet of this usecase.
	*
	* @return the version portlet of this usecase
	*/
	@Override
	public long getVersionPortlet() {
		return _usecase.getVersionPortlet();
	}

	/**
	* Sets the version portlet of this usecase.
	*
	* @param versionPortlet the version portlet of this usecase
	*/
	@Override
	public void setVersionPortlet(long versionPortlet) {
		_usecase.setVersionPortlet(versionPortlet);
	}

	/**
	* Returns the name of this usecase.
	*
	* @return the name of this usecase
	*/
	@Override
	public java.lang.String getName() {
		return _usecase.getName();
	}

	/**
	* Sets the name of this usecase.
	*
	* @param name the name of this usecase
	*/
	@Override
	public void setName(java.lang.String name) {
		_usecase.setName(name);
	}

	@Override
	public boolean isNew() {
		return _usecase.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_usecase.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _usecase.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_usecase.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _usecase.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _usecase.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_usecase.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _usecase.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_usecase.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_usecase.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_usecase.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new UsecaseWrapper((Usecase)_usecase.clone());
	}

	@Override
	public int compareTo(Usecase usecase) {
		return _usecase.compareTo(usecase);
	}

	@Override
	public int hashCode() {
		return _usecase.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<Usecase> toCacheModel() {
		return _usecase.toCacheModel();
	}

	@Override
	public Usecase toEscapedModel() {
		return new UsecaseWrapper(_usecase.toEscapedModel());
	}

	@Override
	public Usecase toUnescapedModel() {
		return new UsecaseWrapper(_usecase.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _usecase.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _usecase.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_usecase.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof UsecaseWrapper)) {
			return false;
		}

		UsecaseWrapper usecaseWrapper = (UsecaseWrapper)obj;

		if (Validator.equals(_usecase, usecaseWrapper._usecase)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Usecase getWrappedUsecase() {
		return _usecase;
	}

	@Override
	public Usecase getWrappedModel() {
		return _usecase;
	}

	@Override
	public void resetOriginalValues() {
		_usecase.resetOriginalValues();
	}

	private Usecase _usecase;
}