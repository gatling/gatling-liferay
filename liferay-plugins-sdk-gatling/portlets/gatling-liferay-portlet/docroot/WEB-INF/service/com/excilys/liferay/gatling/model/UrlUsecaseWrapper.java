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
 * This class is a wrapper for {@link UrlUsecase}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UrlUsecase
 * @generated
 */
public class UrlUsecaseWrapper implements UrlUsecase, ModelWrapper<UrlUsecase> {
	public UrlUsecaseWrapper(UrlUsecase urlUsecase) {
		_urlUsecase = urlUsecase;
	}

	@Override
	public Class<?> getModelClass() {
		return UrlUsecase.class;
	}

	@Override
	public String getModelClassName() {
		return UrlUsecase.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("urlUsecaseId", getUrlUsecaseId());
		attributes.put("usecaseId", getUsecaseId());
		attributes.put("url", getUrl());
		attributes.put("order", getOrder());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long urlUsecaseId = (Long)attributes.get("urlUsecaseId");

		if (urlUsecaseId != null) {
			setUrlUsecaseId(urlUsecaseId);
		}

		Long usecaseId = (Long)attributes.get("usecaseId");

		if (usecaseId != null) {
			setUsecaseId(usecaseId);
		}

		String url = (String)attributes.get("url");

		if (url != null) {
			setUrl(url);
		}

		Integer order = (Integer)attributes.get("order");

		if (order != null) {
			setOrder(order);
		}
	}

	/**
	* Returns the primary key of this url usecase.
	*
	* @return the primary key of this url usecase
	*/
	@Override
	public long getPrimaryKey() {
		return _urlUsecase.getPrimaryKey();
	}

	/**
	* Sets the primary key of this url usecase.
	*
	* @param primaryKey the primary key of this url usecase
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_urlUsecase.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the url usecase ID of this url usecase.
	*
	* @return the url usecase ID of this url usecase
	*/
	@Override
	public long getUrlUsecaseId() {
		return _urlUsecase.getUrlUsecaseId();
	}

	/**
	* Sets the url usecase ID of this url usecase.
	*
	* @param urlUsecaseId the url usecase ID of this url usecase
	*/
	@Override
	public void setUrlUsecaseId(long urlUsecaseId) {
		_urlUsecase.setUrlUsecaseId(urlUsecaseId);
	}

	/**
	* Returns the usecase ID of this url usecase.
	*
	* @return the usecase ID of this url usecase
	*/
	@Override
	public long getUsecaseId() {
		return _urlUsecase.getUsecaseId();
	}

	/**
	* Sets the usecase ID of this url usecase.
	*
	* @param usecaseId the usecase ID of this url usecase
	*/
	@Override
	public void setUsecaseId(long usecaseId) {
		_urlUsecase.setUsecaseId(usecaseId);
	}

	/**
	* Returns the url of this url usecase.
	*
	* @return the url of this url usecase
	*/
	@Override
	public java.lang.String getUrl() {
		return _urlUsecase.getUrl();
	}

	/**
	* Sets the url of this url usecase.
	*
	* @param url the url of this url usecase
	*/
	@Override
	public void setUrl(java.lang.String url) {
		_urlUsecase.setUrl(url);
	}

	/**
	* Returns the order of this url usecase.
	*
	* @return the order of this url usecase
	*/
	@Override
	public int getOrder() {
		return _urlUsecase.getOrder();
	}

	/**
	* Sets the order of this url usecase.
	*
	* @param order the order of this url usecase
	*/
	@Override
	public void setOrder(int order) {
		_urlUsecase.setOrder(order);
	}

	@Override
	public boolean isNew() {
		return _urlUsecase.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_urlUsecase.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _urlUsecase.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_urlUsecase.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _urlUsecase.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _urlUsecase.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_urlUsecase.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _urlUsecase.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_urlUsecase.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_urlUsecase.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_urlUsecase.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new UrlUsecaseWrapper((UrlUsecase)_urlUsecase.clone());
	}

	@Override
	public int compareTo(
		com.excilys.liferay.gatling.model.UrlUsecase urlUsecase) {
		return _urlUsecase.compareTo(urlUsecase);
	}

	@Override
	public int hashCode() {
		return _urlUsecase.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.excilys.liferay.gatling.model.UrlUsecase> toCacheModel() {
		return _urlUsecase.toCacheModel();
	}

	@Override
	public com.excilys.liferay.gatling.model.UrlUsecase toEscapedModel() {
		return new UrlUsecaseWrapper(_urlUsecase.toEscapedModel());
	}

	@Override
	public com.excilys.liferay.gatling.model.UrlUsecase toUnescapedModel() {
		return new UrlUsecaseWrapper(_urlUsecase.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _urlUsecase.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _urlUsecase.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_urlUsecase.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof UrlUsecaseWrapper)) {
			return false;
		}

		UrlUsecaseWrapper urlUsecaseWrapper = (UrlUsecaseWrapper)obj;

		if (Validator.equals(_urlUsecase, urlUsecaseWrapper._urlUsecase)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public UrlUsecase getWrappedUrlUsecase() {
		return _urlUsecase;
	}

	@Override
	public UrlUsecase getWrappedModel() {
		return _urlUsecase;
	}

	@Override
	public void resetOriginalValues() {
		_urlUsecase.resetOriginalValues();
	}

	private UrlUsecase _urlUsecase;
}