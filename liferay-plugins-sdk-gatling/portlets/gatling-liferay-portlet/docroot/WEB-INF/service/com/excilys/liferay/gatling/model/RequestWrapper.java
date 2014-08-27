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
 * This class is a wrapper for {@link Request}.
 * </p>
 *
 * @author Brian Wing Shun Chan
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
		attributes.put("name", getName());
		attributes.put("url", getUrl());
		attributes.put("weight", getWeight());
		attributes.put("privatePage", getPrivatePage());
		attributes.put("parentPlId", getParentPlId());
		attributes.put("layoutId", getLayoutId());
		attributes.put("plId", getPlId());
		attributes.put("isPortlet", getIsPortlet());
		attributes.put("portetId", getPortetId());

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

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String url = (String)attributes.get("url");

		if (url != null) {
			setUrl(url);
		}

		Double weight = (Double)attributes.get("weight");

		if (weight != null) {
			setWeight(weight);
		}

		Boolean privatePage = (Boolean)attributes.get("privatePage");

		if (privatePage != null) {
			setPrivatePage(privatePage);
		}

		Long parentPlId = (Long)attributes.get("parentPlId");

		if (parentPlId != null) {
			setParentPlId(parentPlId);
		}

		Long layoutId = (Long)attributes.get("layoutId");

		if (layoutId != null) {
			setLayoutId(layoutId);
		}

		Long plId = (Long)attributes.get("plId");

		if (plId != null) {
			setPlId(plId);
		}

		Boolean isPortlet = (Boolean)attributes.get("isPortlet");

		if (isPortlet != null) {
			setIsPortlet(isPortlet);
		}

		String portetId = (String)attributes.get("portetId");

		if (portetId != null) {
			setPortetId(portetId);
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
	* Returns the name of this request.
	*
	* @return the name of this request
	*/
	@Override
	public java.lang.String getName() {
		return _request.getName();
	}

	/**
	* Sets the name of this request.
	*
	* @param name the name of this request
	*/
	@Override
	public void setName(java.lang.String name) {
		_request.setName(name);
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
	* Returns the weight of this request.
	*
	* @return the weight of this request
	*/
	@Override
	public double getWeight() {
		return _request.getWeight();
	}

	/**
	* Sets the weight of this request.
	*
	* @param weight the weight of this request
	*/
	@Override
	public void setWeight(double weight) {
		_request.setWeight(weight);
	}

	/**
	* Returns the private page of this request.
	*
	* @return the private page of this request
	*/
	@Override
	public boolean getPrivatePage() {
		return _request.getPrivatePage();
	}

	/**
	* Returns <code>true</code> if this request is private page.
	*
	* @return <code>true</code> if this request is private page; <code>false</code> otherwise
	*/
	@Override
	public boolean isPrivatePage() {
		return _request.isPrivatePage();
	}

	/**
	* Sets whether this request is private page.
	*
	* @param privatePage the private page of this request
	*/
	@Override
	public void setPrivatePage(boolean privatePage) {
		_request.setPrivatePage(privatePage);
	}

	/**
	* Returns the parent pl ID of this request.
	*
	* @return the parent pl ID of this request
	*/
	@Override
	public long getParentPlId() {
		return _request.getParentPlId();
	}

	/**
	* Sets the parent pl ID of this request.
	*
	* @param parentPlId the parent pl ID of this request
	*/
	@Override
	public void setParentPlId(long parentPlId) {
		_request.setParentPlId(parentPlId);
	}

	/**
	* Returns the layout ID of this request.
	*
	* @return the layout ID of this request
	*/
	@Override
	public long getLayoutId() {
		return _request.getLayoutId();
	}

	/**
	* Sets the layout ID of this request.
	*
	* @param layoutId the layout ID of this request
	*/
	@Override
	public void setLayoutId(long layoutId) {
		_request.setLayoutId(layoutId);
	}

	/**
	* Returns the pl ID of this request.
	*
	* @return the pl ID of this request
	*/
	@Override
	public long getPlId() {
		return _request.getPlId();
	}

	/**
	* Sets the pl ID of this request.
	*
	* @param plId the pl ID of this request
	*/
	@Override
	public void setPlId(long plId) {
		_request.setPlId(plId);
	}

	/**
	* Returns the is portlet of this request.
	*
	* @return the is portlet of this request
	*/
	@Override
	public boolean getIsPortlet() {
		return _request.getIsPortlet();
	}

	/**
	* Returns <code>true</code> if this request is is portlet.
	*
	* @return <code>true</code> if this request is is portlet; <code>false</code> otherwise
	*/
	@Override
	public boolean isIsPortlet() {
		return _request.isIsPortlet();
	}

	/**
	* Sets whether this request is is portlet.
	*
	* @param isPortlet the is portlet of this request
	*/
	@Override
	public void setIsPortlet(boolean isPortlet) {
		_request.setIsPortlet(isPortlet);
	}

	/**
	* Returns the portet ID of this request.
	*
	* @return the portet ID of this request
	*/
	@Override
	public java.lang.String getPortetId() {
		return _request.getPortetId();
	}

	/**
	* Sets the portet ID of this request.
	*
	* @param portetId the portet ID of this request
	*/
	@Override
	public void setPortetId(java.lang.String portetId) {
		_request.setPortetId(portetId);
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
	public int compareTo(com.excilys.liferay.gatling.model.Request request) {
		return _request.compareTo(request);
	}

	@Override
	public int hashCode() {
		return _request.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.excilys.liferay.gatling.model.Request> toCacheModel() {
		return _request.toCacheModel();
	}

	@Override
	public com.excilys.liferay.gatling.model.Request toEscapedModel() {
		return new RequestWrapper(_request.toEscapedModel());
	}

	@Override
	public com.excilys.liferay.gatling.model.Request toUnescapedModel() {
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
	public boolean isUsed() {
		return _request.isUsed();
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