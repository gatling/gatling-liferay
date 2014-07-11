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

package com.liferay.sample.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Request}.
 * </p>
 *
 * @author sana
 * @see Request
 * @generated
 */
public class RequestWrapper implements Request, ModelWrapper<Request> {
	public RequestWrapper(Request request) {
		_request = request;
	}

	@Override
	public Class<?> getModelClass() {
		return Request.class;
	}

	@Override
	public String getModelClassName() {
		return Request.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("request_id", getRequest_id());
		attributes.put("scenario_id", getScenario_id());
		attributes.put("url", getUrl());
		attributes.put("rate", getRate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long request_id = (Long)attributes.get("request_id");

		if (request_id != null) {
			setRequest_id(request_id);
		}

		Long scenario_id = (Long)attributes.get("scenario_id");

		if (scenario_id != null) {
			setScenario_id(scenario_id);
		}

		String url = (String)attributes.get("url");

		if (url != null) {
			setUrl(url);
		}

		Integer rate = (Integer)attributes.get("rate");

		if (rate != null) {
			setRate(rate);
		}
	}

	/**
	* Returns the primary key of this request.
	*
	* @return the primary key of this request
	*/
	@Override
	public long getPrimaryKey() {
		return _request.getPrimaryKey();
	}

	/**
	* Sets the primary key of this request.
	*
	* @param primaryKey the primary key of this request
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_request.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the request_id of this request.
	*
	* @return the request_id of this request
	*/
	@Override
	public long getRequest_id() {
		return _request.getRequest_id();
	}

	/**
	* Sets the request_id of this request.
	*
	* @param request_id the request_id of this request
	*/
	@Override
	public void setRequest_id(long request_id) {
		_request.setRequest_id(request_id);
	}

	/**
	* Returns the scenario_id of this request.
	*
	* @return the scenario_id of this request
	*/
	@Override
	public long getScenario_id() {
		return _request.getScenario_id();
	}

	/**
	* Sets the scenario_id of this request.
	*
	* @param scenario_id the scenario_id of this request
	*/
	@Override
	public void setScenario_id(long scenario_id) {
		_request.setScenario_id(scenario_id);
	}

	/**
	* Returns the url of this request.
	*
	* @return the url of this request
	*/
	@Override
	public java.lang.String getUrl() {
		return _request.getUrl();
	}

	/**
	* Sets the url of this request.
	*
	* @param url the url of this request
	*/
	@Override
	public void setUrl(java.lang.String url) {
		_request.setUrl(url);
	}

	/**
	* Returns the rate of this request.
	*
	* @return the rate of this request
	*/
	@Override
	public int getRate() {
		return _request.getRate();
	}

	/**
	* Sets the rate of this request.
	*
	* @param rate the rate of this request
	*/
	@Override
	public void setRate(int rate) {
		_request.setRate(rate);
	}

	@Override
	public boolean isNew() {
		return _request.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_request.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _request.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_request.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _request.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _request.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_request.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _request.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_request.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_request.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_request.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new RequestWrapper((Request)_request.clone());
	}

	@Override
	public int compareTo(com.liferay.sample.model.Request request) {
		return _request.compareTo(request);
	}

	@Override
	public int hashCode() {
		return _request.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.liferay.sample.model.Request> toCacheModel() {
		return _request.toCacheModel();
	}

	@Override
	public com.liferay.sample.model.Request toEscapedModel() {
		return new RequestWrapper(_request.toEscapedModel());
	}

	@Override
	public com.liferay.sample.model.Request toUnescapedModel() {
		return new RequestWrapper(_request.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _request.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _request.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_request.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof RequestWrapper)) {
			return false;
		}

		RequestWrapper requestWrapper = (RequestWrapper)obj;

		if (Validator.equals(_request, requestWrapper._request)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Request getWrappedRequest() {
		return _request;
	}

	@Override
	public Request getWrappedModel() {
		return _request;
	}

	@Override
	public void resetOriginalValues() {
		_request.resetOriginalValues();
	}

	private Request _request;
}