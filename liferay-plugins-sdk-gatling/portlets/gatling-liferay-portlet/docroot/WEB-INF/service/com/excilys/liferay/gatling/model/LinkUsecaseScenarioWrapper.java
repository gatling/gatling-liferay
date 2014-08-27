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
 * This class is a wrapper for {@link LinkUsecaseScenario}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LinkUsecaseScenario
 * @generated
 */
public class LinkUsecaseScenarioWrapper implements LinkUsecaseScenario,
	ModelWrapper<LinkUsecaseScenario> {
	public LinkUsecaseScenarioWrapper(LinkUsecaseScenario linkUsecaseScenario) {
		_linkUsecaseScenario = linkUsecaseScenario;
	}

	@Override
	public Class<?> getModelClass() {
		return LinkUsecaseScenario.class;
	}

	@Override
	public String getModelClassName() {
		return LinkUsecaseScenario.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("scenario_id", getScenario_id());
		attributes.put("usecaseId", getUsecaseId());
		attributes.put("weight", getWeight());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long scenario_id = (Long)attributes.get("scenario_id");

		if (scenario_id != null) {
			setScenario_id(scenario_id);
		}

		Long usecaseId = (Long)attributes.get("usecaseId");

		if (usecaseId != null) {
			setUsecaseId(usecaseId);
		}

		Double weight = (Double)attributes.get("weight");

		if (weight != null) {
			setWeight(weight);
		}
	}

	/**
	* Returns the primary key of this link usecase scenario.
	*
	* @return the primary key of this link usecase scenario
	*/
	@Override
	public com.excilys.liferay.gatling.service.persistence.LinkUsecaseScenarioPK getPrimaryKey() {
		return _linkUsecaseScenario.getPrimaryKey();
	}

	/**
	* Sets the primary key of this link usecase scenario.
	*
	* @param primaryKey the primary key of this link usecase scenario
	*/
	@Override
	public void setPrimaryKey(
		com.excilys.liferay.gatling.service.persistence.LinkUsecaseScenarioPK primaryKey) {
		_linkUsecaseScenario.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the scenario_id of this link usecase scenario.
	*
	* @return the scenario_id of this link usecase scenario
	*/
	@Override
	public long getScenario_id() {
		return _linkUsecaseScenario.getScenario_id();
	}

	/**
	* Sets the scenario_id of this link usecase scenario.
	*
	* @param scenario_id the scenario_id of this link usecase scenario
	*/
	@Override
	public void setScenario_id(long scenario_id) {
		_linkUsecaseScenario.setScenario_id(scenario_id);
	}

	/**
	* Returns the usecase ID of this link usecase scenario.
	*
	* @return the usecase ID of this link usecase scenario
	*/
	@Override
	public long getUsecaseId() {
		return _linkUsecaseScenario.getUsecaseId();
	}

	/**
	* Sets the usecase ID of this link usecase scenario.
	*
	* @param usecaseId the usecase ID of this link usecase scenario
	*/
	@Override
	public void setUsecaseId(long usecaseId) {
		_linkUsecaseScenario.setUsecaseId(usecaseId);
	}

	/**
	* Returns the weight of this link usecase scenario.
	*
	* @return the weight of this link usecase scenario
	*/
	@Override
	public double getWeight() {
		return _linkUsecaseScenario.getWeight();
	}

	/**
	* Sets the weight of this link usecase scenario.
	*
	* @param weight the weight of this link usecase scenario
	*/
	@Override
	public void setWeight(double weight) {
		_linkUsecaseScenario.setWeight(weight);
	}

	@Override
	public boolean isNew() {
		return _linkUsecaseScenario.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_linkUsecaseScenario.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _linkUsecaseScenario.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_linkUsecaseScenario.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _linkUsecaseScenario.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _linkUsecaseScenario.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_linkUsecaseScenario.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _linkUsecaseScenario.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_linkUsecaseScenario.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_linkUsecaseScenario.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_linkUsecaseScenario.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new LinkUsecaseScenarioWrapper((LinkUsecaseScenario)_linkUsecaseScenario.clone());
	}

	@Override
	public int compareTo(LinkUsecaseScenario linkUsecaseScenario) {
		return _linkUsecaseScenario.compareTo(linkUsecaseScenario);
	}

	@Override
	public int hashCode() {
		return _linkUsecaseScenario.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<LinkUsecaseScenario> toCacheModel() {
		return _linkUsecaseScenario.toCacheModel();
	}

	@Override
	public LinkUsecaseScenario toEscapedModel() {
		return new LinkUsecaseScenarioWrapper(_linkUsecaseScenario.toEscapedModel());
	}

	@Override
	public LinkUsecaseScenario toUnescapedModel() {
		return new LinkUsecaseScenarioWrapper(_linkUsecaseScenario.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _linkUsecaseScenario.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _linkUsecaseScenario.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_linkUsecaseScenario.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LinkUsecaseScenarioWrapper)) {
			return false;
		}

		LinkUsecaseScenarioWrapper linkUsecaseScenarioWrapper = (LinkUsecaseScenarioWrapper)obj;

		if (Validator.equals(_linkUsecaseScenario,
					linkUsecaseScenarioWrapper._linkUsecaseScenario)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public LinkUsecaseScenario getWrappedLinkUsecaseScenario() {
		return _linkUsecaseScenario;
	}

	@Override
	public LinkUsecaseScenario getWrappedModel() {
		return _linkUsecaseScenario;
	}

	@Override
	public void resetOriginalValues() {
		_linkUsecaseScenario.resetOriginalValues();
	}

	private LinkUsecaseScenario _linkUsecaseScenario;
}