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
 * This class is a wrapper for {@link Record}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Record
 * @generated
 */
public class RecordWrapper implements Record, ModelWrapper<Record> {
	public RecordWrapper(Record record) {
		_record = record;
	}

	@Override
	public Class<?> getModelClass() {
		return Record.class;
	}

	@Override
	public String getModelClassName() {
		return Record.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("recordId", getRecordId());
		attributes.put("portletId", getPortletId());
		attributes.put("versionPortlet", getVersionPortlet());
		attributes.put("name", getName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long recordId = (Long)attributes.get("recordId");

		if (recordId != null) {
			setRecordId(recordId);
		}

		String portletId = (String)attributes.get("portletId");

		if (portletId != null) {
			setPortletId(portletId);
		}

		String versionPortlet = (String)attributes.get("versionPortlet");

		if (versionPortlet != null) {
			setVersionPortlet(versionPortlet);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}
	}

	/**
	* Returns the primary key of this record.
	*
	* @return the primary key of this record
	*/
	@Override
	public long getPrimaryKey() {
		return _record.getPrimaryKey();
	}

	/**
	* Sets the primary key of this record.
	*
	* @param primaryKey the primary key of this record
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_record.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the record ID of this record.
	*
	* @return the record ID of this record
	*/
	@Override
	public long getRecordId() {
		return _record.getRecordId();
	}

	/**
	* Sets the record ID of this record.
	*
	* @param recordId the record ID of this record
	*/
	@Override
	public void setRecordId(long recordId) {
		_record.setRecordId(recordId);
	}

	/**
	* Returns the portlet ID of this record.
	*
	* @return the portlet ID of this record
	*/
	@Override
	public java.lang.String getPortletId() {
		return _record.getPortletId();
	}

	/**
	* Sets the portlet ID of this record.
	*
	* @param portletId the portlet ID of this record
	*/
	@Override
	public void setPortletId(java.lang.String portletId) {
		_record.setPortletId(portletId);
	}

	/**
	* Returns the version portlet of this record.
	*
	* @return the version portlet of this record
	*/
	@Override
	public java.lang.String getVersionPortlet() {
		return _record.getVersionPortlet();
	}

	/**
	* Sets the version portlet of this record.
	*
	* @param versionPortlet the version portlet of this record
	*/
	@Override
	public void setVersionPortlet(java.lang.String versionPortlet) {
		_record.setVersionPortlet(versionPortlet);
	}

	/**
	* Returns the name of this record.
	*
	* @return the name of this record
	*/
	@Override
	public java.lang.String getName() {
		return _record.getName();
	}

	/**
	* Sets the name of this record.
	*
	* @param name the name of this record
	*/
	@Override
	public void setName(java.lang.String name) {
		_record.setName(name);
	}

	@Override
	public boolean isNew() {
		return _record.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_record.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _record.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_record.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _record.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _record.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_record.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _record.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_record.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_record.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_record.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new RecordWrapper((Record)_record.clone());
	}

	@Override
	public int compareTo(com.excilys.liferay.gatling.model.Record record) {
		return _record.compareTo(record);
	}

	@Override
	public int hashCode() {
		return _record.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.excilys.liferay.gatling.model.Record> toCacheModel() {
		return _record.toCacheModel();
	}

	@Override
	public com.excilys.liferay.gatling.model.Record toEscapedModel() {
		return new RecordWrapper(_record.toEscapedModel());
	}

	@Override
	public com.excilys.liferay.gatling.model.Record toUnescapedModel() {
		return new RecordWrapper(_record.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _record.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _record.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_record.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof RecordWrapper)) {
			return false;
		}

		RecordWrapper recordWrapper = (RecordWrapper)obj;

		if (Validator.equals(_record, recordWrapper._record)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Record getWrappedRecord() {
		return _record;
	}

	@Override
	public Record getWrappedModel() {
		return _record;
	}

	@Override
	public void resetOriginalValues() {
		_record.resetOriginalValues();
	}

	private Record _record;
}