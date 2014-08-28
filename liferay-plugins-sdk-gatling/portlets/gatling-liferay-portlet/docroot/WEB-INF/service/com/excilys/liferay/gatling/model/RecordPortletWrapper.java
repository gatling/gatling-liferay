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
 * This class is a wrapper for {@link RecordPortlet}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RecordPortlet
 * @generated
 */
public class RecordPortletWrapper implements RecordPortlet,
	ModelWrapper<RecordPortlet> {
	public RecordPortletWrapper(RecordPortlet recordPortlet) {
		_recordPortlet = recordPortlet;
	}

	@Override
	public Class<?> getModelClass() {
		return RecordPortlet.class;
	}

	@Override
	public String getModelClassName() {
		return RecordPortlet.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("recordPortletId", getRecordPortletId());
		attributes.put("portletId", getPortletId());
		attributes.put("state", getState());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long recordPortletId = (Long)attributes.get("recordPortletId");

		if (recordPortletId != null) {
			setRecordPortletId(recordPortletId);
		}

		String portletId = (String)attributes.get("portletId");

		if (portletId != null) {
			setPortletId(portletId);
		}

		String state = (String)attributes.get("state");

		if (state != null) {
			setState(state);
		}
	}

	/**
	* Returns the primary key of this record portlet.
	*
	* @return the primary key of this record portlet
	*/
	@Override
	public long getPrimaryKey() {
		return _recordPortlet.getPrimaryKey();
	}

	/**
	* Sets the primary key of this record portlet.
	*
	* @param primaryKey the primary key of this record portlet
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_recordPortlet.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the record portlet ID of this record portlet.
	*
	* @return the record portlet ID of this record portlet
	*/
	@Override
	public long getRecordPortletId() {
		return _recordPortlet.getRecordPortletId();
	}

	/**
	* Sets the record portlet ID of this record portlet.
	*
	* @param recordPortletId the record portlet ID of this record portlet
	*/
	@Override
	public void setRecordPortletId(long recordPortletId) {
		_recordPortlet.setRecordPortletId(recordPortletId);
	}

	/**
	* Returns the portlet ID of this record portlet.
	*
	* @return the portlet ID of this record portlet
	*/
	@Override
	public java.lang.String getPortletId() {
		return _recordPortlet.getPortletId();
	}

	/**
	* Sets the portlet ID of this record portlet.
	*
	* @param portletId the portlet ID of this record portlet
	*/
	@Override
	public void setPortletId(java.lang.String portletId) {
		_recordPortlet.setPortletId(portletId);
	}

	/**
	* Returns the state of this record portlet.
	*
	* @return the state of this record portlet
	*/
	@Override
	public java.lang.String getState() {
		return _recordPortlet.getState();
	}

	/**
	* Sets the state of this record portlet.
	*
	* @param state the state of this record portlet
	*/
	@Override
	public void setState(java.lang.String state) {
		_recordPortlet.setState(state);
	}

	@Override
	public boolean isNew() {
		return _recordPortlet.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_recordPortlet.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _recordPortlet.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_recordPortlet.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _recordPortlet.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _recordPortlet.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_recordPortlet.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _recordPortlet.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_recordPortlet.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_recordPortlet.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_recordPortlet.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new RecordPortletWrapper((RecordPortlet)_recordPortlet.clone());
	}

	@Override
	public int compareTo(RecordPortlet recordPortlet) {
		return _recordPortlet.compareTo(recordPortlet);
	}

	@Override
	public int hashCode() {
		return _recordPortlet.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<RecordPortlet> toCacheModel() {
		return _recordPortlet.toCacheModel();
	}

	@Override
	public RecordPortlet toEscapedModel() {
		return new RecordPortletWrapper(_recordPortlet.toEscapedModel());
	}

	@Override
	public RecordPortlet toUnescapedModel() {
		return new RecordPortletWrapper(_recordPortlet.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _recordPortlet.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _recordPortlet.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_recordPortlet.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof RecordPortletWrapper)) {
			return false;
		}

		RecordPortletWrapper recordPortletWrapper = (RecordPortletWrapper)obj;

		if (Validator.equals(_recordPortlet, recordPortletWrapper._recordPortlet)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public RecordPortlet getWrappedRecordPortlet() {
		return _recordPortlet;
	}

	@Override
	public RecordPortlet getWrappedModel() {
		return _recordPortlet;
	}

	@Override
	public void resetOriginalValues() {
		_recordPortlet.resetOriginalValues();
	}

	private RecordPortlet _recordPortlet;
}