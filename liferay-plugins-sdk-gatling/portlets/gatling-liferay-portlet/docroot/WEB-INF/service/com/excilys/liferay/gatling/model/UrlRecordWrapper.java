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
 * This class is a wrapper for {@link UrlRecord}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UrlRecord
 * @generated
 */
public class UrlRecordWrapper implements UrlRecord, ModelWrapper<UrlRecord> {
	public UrlRecordWrapper(UrlRecord urlRecord) {
		_urlRecord = urlRecord;
	}

	@Override
	public Class<?> getModelClass() {
		return UrlRecord.class;
	}

	@Override
	public String getModelClassName() {
		return UrlRecord.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("urlRecordId", getUrlRecordId());
		attributes.put("recordId", getRecordId());
		attributes.put("url", getUrl());
		attributes.put("order", getOrder());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long urlRecordId = (Long)attributes.get("urlRecordId");

		if (urlRecordId != null) {
			setUrlRecordId(urlRecordId);
		}

		Long recordId = (Long)attributes.get("recordId");

		if (recordId != null) {
			setRecordId(recordId);
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
	* Returns the primary key of this url record.
	*
	* @return the primary key of this url record
	*/
	@Override
	public long getPrimaryKey() {
		return _urlRecord.getPrimaryKey();
	}

	/**
	* Sets the primary key of this url record.
	*
	* @param primaryKey the primary key of this url record
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_urlRecord.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the url record ID of this url record.
	*
	* @return the url record ID of this url record
	*/
	@Override
	public long getUrlRecordId() {
		return _urlRecord.getUrlRecordId();
	}

	/**
	* Sets the url record ID of this url record.
	*
	* @param urlRecordId the url record ID of this url record
	*/
	@Override
	public void setUrlRecordId(long urlRecordId) {
		_urlRecord.setUrlRecordId(urlRecordId);
	}

	/**
	* Returns the record ID of this url record.
	*
	* @return the record ID of this url record
	*/
	@Override
	public long getRecordId() {
		return _urlRecord.getRecordId();
	}

	/**
	* Sets the record ID of this url record.
	*
	* @param recordId the record ID of this url record
	*/
	@Override
	public void setRecordId(long recordId) {
		_urlRecord.setRecordId(recordId);
	}

	/**
	* Returns the url of this url record.
	*
	* @return the url of this url record
	*/
	@Override
	public java.lang.String getUrl() {
		return _urlRecord.getUrl();
	}

	/**
	* Sets the url of this url record.
	*
	* @param url the url of this url record
	*/
	@Override
	public void setUrl(java.lang.String url) {
		_urlRecord.setUrl(url);
	}

	/**
	* Returns the order of this url record.
	*
	* @return the order of this url record
	*/
	@Override
	public int getOrder() {
		return _urlRecord.getOrder();
	}

	/**
	* Sets the order of this url record.
	*
	* @param order the order of this url record
	*/
	@Override
	public void setOrder(int order) {
		_urlRecord.setOrder(order);
	}

	@Override
	public boolean isNew() {
		return _urlRecord.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_urlRecord.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _urlRecord.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_urlRecord.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _urlRecord.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _urlRecord.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_urlRecord.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _urlRecord.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_urlRecord.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_urlRecord.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_urlRecord.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new UrlRecordWrapper((UrlRecord)_urlRecord.clone());
	}

	@Override
	public int compareTo(UrlRecord urlRecord) {
		return _urlRecord.compareTo(urlRecord);
	}

	@Override
	public int hashCode() {
		return _urlRecord.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<UrlRecord> toCacheModel() {
		return _urlRecord.toCacheModel();
	}

	@Override
	public UrlRecord toEscapedModel() {
		return new UrlRecordWrapper(_urlRecord.toEscapedModel());
	}

	@Override
	public UrlRecord toUnescapedModel() {
		return new UrlRecordWrapper(_urlRecord.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _urlRecord.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _urlRecord.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_urlRecord.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof UrlRecordWrapper)) {
			return false;
		}

		UrlRecordWrapper urlRecordWrapper = (UrlRecordWrapper)obj;

		if (Validator.equals(_urlRecord, urlRecordWrapper._urlRecord)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public UrlRecord getWrappedUrlRecord() {
		return _urlRecord;
	}

	@Override
	public UrlRecord getWrappedModel() {
		return _urlRecord;
	}

	@Override
	public void resetOriginalValues() {
		_urlRecord.resetOriginalValues();
	}

	private UrlRecord _urlRecord;
}