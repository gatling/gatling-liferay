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
 * This class is a wrapper for {@link PortletStress}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PortletStress
 * @generated
 */
public class PortletStressWrapper implements PortletStress,
	ModelWrapper<PortletStress> {
	public PortletStressWrapper(PortletStress portletStress) {
		_portletStress = portletStress;
	}

	@Override
	public Class<?> getModelClass() {
		return PortletStress.class;
	}

	@Override
	public String getModelClassName() {
		return PortletStress.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("portletStressId", getPortletStressId());
		attributes.put("portletId", getPortletId());
		attributes.put("scenario_id", getScenario_id());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long portletStressId = (Long)attributes.get("portletStressId");

		if (portletStressId != null) {
			setPortletStressId(portletStressId);
		}

		String portletId = (String)attributes.get("portletId");

		if (portletId != null) {
			setPortletId(portletId);
		}

		Long scenario_id = (Long)attributes.get("scenario_id");

		if (scenario_id != null) {
			setScenario_id(scenario_id);
		}
	}

	/**
	* Returns the primary key of this portlet stress.
	*
	* @return the primary key of this portlet stress
	*/
	@Override
	public long getPrimaryKey() {
		return _portletStress.getPrimaryKey();
	}

	/**
	* Sets the primary key of this portlet stress.
	*
	* @param primaryKey the primary key of this portlet stress
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_portletStress.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the portlet stress ID of this portlet stress.
	*
	* @return the portlet stress ID of this portlet stress
	*/
	@Override
	public long getPortletStressId() {
		return _portletStress.getPortletStressId();
	}

	/**
	* Sets the portlet stress ID of this portlet stress.
	*
	* @param portletStressId the portlet stress ID of this portlet stress
	*/
	@Override
	public void setPortletStressId(long portletStressId) {
		_portletStress.setPortletStressId(portletStressId);
	}

	/**
	* Returns the portlet ID of this portlet stress.
	*
	* @return the portlet ID of this portlet stress
	*/
	@Override
	public java.lang.String getPortletId() {
		return _portletStress.getPortletId();
	}

	/**
	* Sets the portlet ID of this portlet stress.
	*
	* @param portletId the portlet ID of this portlet stress
	*/
	@Override
	public void setPortletId(java.lang.String portletId) {
		_portletStress.setPortletId(portletId);
	}

	/**
	* Returns the scenario_id of this portlet stress.
	*
	* @return the scenario_id of this portlet stress
	*/
	@Override
	public long getScenario_id() {
		return _portletStress.getScenario_id();
	}

	/**
	* Sets the scenario_id of this portlet stress.
	*
	* @param scenario_id the scenario_id of this portlet stress
	*/
	@Override
	public void setScenario_id(long scenario_id) {
		_portletStress.setScenario_id(scenario_id);
	}

	@Override
	public boolean isNew() {
		return _portletStress.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_portletStress.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _portletStress.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_portletStress.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _portletStress.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _portletStress.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_portletStress.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _portletStress.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_portletStress.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_portletStress.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_portletStress.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new PortletStressWrapper((PortletStress)_portletStress.clone());
	}

	@Override
	public int compareTo(
		com.excilys.liferay.gatling.model.PortletStress portletStress) {
		return _portletStress.compareTo(portletStress);
	}

	@Override
	public int hashCode() {
		return _portletStress.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.excilys.liferay.gatling.model.PortletStress> toCacheModel() {
		return _portletStress.toCacheModel();
	}

	@Override
	public com.excilys.liferay.gatling.model.PortletStress toEscapedModel() {
		return new PortletStressWrapper(_portletStress.toEscapedModel());
	}

	@Override
	public com.excilys.liferay.gatling.model.PortletStress toUnescapedModel() {
		return new PortletStressWrapper(_portletStress.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _portletStress.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _portletStress.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof PortletStressWrapper)) {
			return false;
		}

		PortletStressWrapper portletStressWrapper = (PortletStressWrapper)obj;

		if (Validator.equals(_portletStress, portletStressWrapper._portletStress)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public PortletStress getWrappedPortletStress() {
		return _portletStress;
	}

	@Override
	public PortletStress getWrappedModel() {
		return _portletStress;
	}

	@Override
	public void resetOriginalValues() {
		_portletStress.resetOriginalValues();
	}

	private PortletStress _portletStress;
}