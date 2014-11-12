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
 * This class is a wrapper for {@link LinkUsecaseRequest}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LinkUsecaseRequest
 * @generated
 */
public class LinkUsecaseRequestWrapper implements LinkUsecaseRequest,
	ModelWrapper<LinkUsecaseRequest> {
	public LinkUsecaseRequestWrapper(LinkUsecaseRequest linkUsecaseRequest) {
		_linkUsecaseRequest = linkUsecaseRequest;
	}

	@Override
	public Class<?> getModelClass() {
		return LinkUsecaseRequest.class;
	}

	@Override
	public String getModelClassName() {
		return LinkUsecaseRequest.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("linkUsecaseRequestId", getLinkUsecaseRequestId());
		attributes.put("request_id", getRequest_id());
		attributes.put("recordId", getRecordId());
		attributes.put("weight", getWeight());
		attributes.put("sample", getSample());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long linkUsecaseRequestId = (Long)attributes.get("linkUsecaseRequestId");

		if (linkUsecaseRequestId != null) {
			setLinkUsecaseRequestId(linkUsecaseRequestId);
		}

		Long request_id = (Long)attributes.get("request_id");

		if (request_id != null) {
			setRequest_id(request_id);
		}

		Long recordId = (Long)attributes.get("recordId");

		if (recordId != null) {
			setRecordId(recordId);
		}

		Double weight = (Double)attributes.get("weight");

		if (weight != null) {
			setWeight(weight);
		}

		Boolean sample = (Boolean)attributes.get("sample");

		if (sample != null) {
			setSample(sample);
		}
	}

	/**
	* Returns the primary key of this link usecase request.
	*
	* @return the primary key of this link usecase request
	*/
	@Override
	public long getPrimaryKey() {
		return _linkUsecaseRequest.getPrimaryKey();
	}

	/**
	* Sets the primary key of this link usecase request.
	*
	* @param primaryKey the primary key of this link usecase request
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_linkUsecaseRequest.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the link usecase request ID of this link usecase request.
	*
	* @return the link usecase request ID of this link usecase request
	*/
	@Override
	public long getLinkUsecaseRequestId() {
		return _linkUsecaseRequest.getLinkUsecaseRequestId();
	}

	/**
	* Sets the link usecase request ID of this link usecase request.
	*
	* @param linkUsecaseRequestId the link usecase request ID of this link usecase request
	*/
	@Override
	public void setLinkUsecaseRequestId(long linkUsecaseRequestId) {
		_linkUsecaseRequest.setLinkUsecaseRequestId(linkUsecaseRequestId);
	}

	/**
	* Returns the request_id of this link usecase request.
	*
	* @return the request_id of this link usecase request
	*/
	@Override
	public long getRequest_id() {
		return _linkUsecaseRequest.getRequest_id();
	}

	/**
	* Sets the request_id of this link usecase request.
	*
	* @param request_id the request_id of this link usecase request
	*/
	@Override
	public void setRequest_id(long request_id) {
		_linkUsecaseRequest.setRequest_id(request_id);
	}

	/**
	* Returns the record ID of this link usecase request.
	*
	* @return the record ID of this link usecase request
	*/
	@Override
	public long getRecordId() {
		return _linkUsecaseRequest.getRecordId();
	}

	/**
	* Sets the record ID of this link usecase request.
	*
	* @param recordId the record ID of this link usecase request
	*/
	@Override
	public void setRecordId(long recordId) {
		_linkUsecaseRequest.setRecordId(recordId);
	}

	/**
	* Returns the weight of this link usecase request.
	*
	* @return the weight of this link usecase request
	*/
	@Override
	public double getWeight() {
		return _linkUsecaseRequest.getWeight();
	}

	/**
	* Sets the weight of this link usecase request.
	*
	* @param weight the weight of this link usecase request
	*/
	@Override
	public void setWeight(double weight) {
		_linkUsecaseRequest.setWeight(weight);
	}

	/**
	* Returns the sample of this link usecase request.
	*
	* @return the sample of this link usecase request
	*/
	@Override
	public boolean getSample() {
		return _linkUsecaseRequest.getSample();
	}

	/**
	* Returns <code>true</code> if this link usecase request is sample.
	*
	* @return <code>true</code> if this link usecase request is sample; <code>false</code> otherwise
	*/
	@Override
	public boolean isSample() {
		return _linkUsecaseRequest.isSample();
	}

	/**
	* Sets whether this link usecase request is sample.
	*
	* @param sample the sample of this link usecase request
	*/
	@Override
	public void setSample(boolean sample) {
		_linkUsecaseRequest.setSample(sample);
	}

	@Override
	public boolean isNew() {
		return _linkUsecaseRequest.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_linkUsecaseRequest.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _linkUsecaseRequest.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_linkUsecaseRequest.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _linkUsecaseRequest.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _linkUsecaseRequest.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_linkUsecaseRequest.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _linkUsecaseRequest.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_linkUsecaseRequest.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_linkUsecaseRequest.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_linkUsecaseRequest.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new LinkUsecaseRequestWrapper((LinkUsecaseRequest)_linkUsecaseRequest.clone());
	}

	@Override
	public int compareTo(LinkUsecaseRequest linkUsecaseRequest) {
		return _linkUsecaseRequest.compareTo(linkUsecaseRequest);
	}

	@Override
	public int hashCode() {
		return _linkUsecaseRequest.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<LinkUsecaseRequest> toCacheModel() {
		return _linkUsecaseRequest.toCacheModel();
	}

	@Override
	public LinkUsecaseRequest toEscapedModel() {
		return new LinkUsecaseRequestWrapper(_linkUsecaseRequest.toEscapedModel());
	}

	@Override
	public LinkUsecaseRequest toUnescapedModel() {
		return new LinkUsecaseRequestWrapper(_linkUsecaseRequest.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _linkUsecaseRequest.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _linkUsecaseRequest.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_linkUsecaseRequest.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LinkUsecaseRequestWrapper)) {
			return false;
		}

		LinkUsecaseRequestWrapper linkUsecaseRequestWrapper = (LinkUsecaseRequestWrapper)obj;

		if (Validator.equals(_linkUsecaseRequest,
					linkUsecaseRequestWrapper._linkUsecaseRequest)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public LinkUsecaseRequest getWrappedLinkUsecaseRequest() {
		return _linkUsecaseRequest;
	}

	@Override
	public LinkUsecaseRequest getWrappedModel() {
		return _linkUsecaseRequest;
	}

	@Override
	public void resetOriginalValues() {
		_linkUsecaseRequest.resetOriginalValues();
	}

	private LinkUsecaseRequest _linkUsecaseRequest;
}