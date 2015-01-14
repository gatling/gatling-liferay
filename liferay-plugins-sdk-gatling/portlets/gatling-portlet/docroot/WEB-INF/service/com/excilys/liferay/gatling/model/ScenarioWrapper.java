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
 * This class is a wrapper for {@link Scenario}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Scenario
 * @generated
 */
public class ScenarioWrapper implements Scenario, ModelWrapper<Scenario> {
	public ScenarioWrapper(Scenario scenario) {
		_scenario = scenario;
	}

	@Override
	public Class<?> getModelClass() {
		return Scenario.class;
	}

	@Override
	public String getModelClassName() {
		return Scenario.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("scenarioId", getScenarioId());
		attributes.put("name", getName());
		attributes.put("urlSite", getUrlSite());
		attributes.put("group_id", getGroup_id());
		attributes.put("simulationId", getSimulationId());
		attributes.put("numberOfUsers", getNumberOfUsers());
		attributes.put("duration", getDuration());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long scenarioId = (Long)attributes.get("scenarioId");

		if (scenarioId != null) {
			setScenarioId(scenarioId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String urlSite = (String)attributes.get("urlSite");

		if (urlSite != null) {
			setUrlSite(urlSite);
		}

		Long group_id = (Long)attributes.get("group_id");

		if (group_id != null) {
			setGroup_id(group_id);
		}

		Long simulationId = (Long)attributes.get("simulationId");

		if (simulationId != null) {
			setSimulationId(simulationId);
		}

		Long numberOfUsers = (Long)attributes.get("numberOfUsers");

		if (numberOfUsers != null) {
			setNumberOfUsers(numberOfUsers);
		}

		Long duration = (Long)attributes.get("duration");

		if (duration != null) {
			setDuration(duration);
		}
	}

	/**
	* Returns the primary key of this scenario.
	*
	* @return the primary key of this scenario
	*/
	@Override
	public long getPrimaryKey() {
		return _scenario.getPrimaryKey();
	}

	/**
	* Sets the primary key of this scenario.
	*
	* @param primaryKey the primary key of this scenario
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_scenario.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the scenario ID of this scenario.
	*
	* @return the scenario ID of this scenario
	*/
	@Override
	public long getScenarioId() {
		return _scenario.getScenarioId();
	}

	/**
	* Sets the scenario ID of this scenario.
	*
	* @param scenarioId the scenario ID of this scenario
	*/
	@Override
	public void setScenarioId(long scenarioId) {
		_scenario.setScenarioId(scenarioId);
	}

	/**
	* Returns the name of this scenario.
	*
	* @return the name of this scenario
	*/
	@Override
	public java.lang.String getName() {
		return _scenario.getName();
	}

	/**
	* Sets the name of this scenario.
	*
	* @param name the name of this scenario
	*/
	@Override
	public void setName(java.lang.String name) {
		_scenario.setName(name);
	}

	/**
	* Returns the url site of this scenario.
	*
	* @return the url site of this scenario
	*/
	@Override
	public java.lang.String getUrlSite() {
		return _scenario.getUrlSite();
	}

	/**
	* Sets the url site of this scenario.
	*
	* @param urlSite the url site of this scenario
	*/
	@Override
	public void setUrlSite(java.lang.String urlSite) {
		_scenario.setUrlSite(urlSite);
	}

	/**
	* Returns the group_id of this scenario.
	*
	* @return the group_id of this scenario
	*/
	@Override
	public long getGroup_id() {
		return _scenario.getGroup_id();
	}

	/**
	* Sets the group_id of this scenario.
	*
	* @param group_id the group_id of this scenario
	*/
	@Override
	public void setGroup_id(long group_id) {
		_scenario.setGroup_id(group_id);
	}

	/**
	* Returns the simulation ID of this scenario.
	*
	* @return the simulation ID of this scenario
	*/
	@Override
	public long getSimulationId() {
		return _scenario.getSimulationId();
	}

	/**
	* Sets the simulation ID of this scenario.
	*
	* @param simulationId the simulation ID of this scenario
	*/
	@Override
	public void setSimulationId(long simulationId) {
		_scenario.setSimulationId(simulationId);
	}

	/**
	* Returns the number of users of this scenario.
	*
	* @return the number of users of this scenario
	*/
	@Override
	public long getNumberOfUsers() {
		return _scenario.getNumberOfUsers();
	}

	/**
	* Sets the number of users of this scenario.
	*
	* @param numberOfUsers the number of users of this scenario
	*/
	@Override
	public void setNumberOfUsers(long numberOfUsers) {
		_scenario.setNumberOfUsers(numberOfUsers);
	}

	/**
	* Returns the duration of this scenario.
	*
	* @return the duration of this scenario
	*/
	@Override
	public long getDuration() {
		return _scenario.getDuration();
	}

	/**
	* Sets the duration of this scenario.
	*
	* @param duration the duration of this scenario
	*/
	@Override
	public void setDuration(long duration) {
		_scenario.setDuration(duration);
	}

	@Override
	public boolean isNew() {
		return _scenario.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_scenario.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _scenario.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_scenario.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _scenario.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _scenario.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_scenario.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _scenario.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_scenario.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_scenario.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_scenario.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ScenarioWrapper((Scenario)_scenario.clone());
	}

	@Override
	public int compareTo(com.excilys.liferay.gatling.model.Scenario scenario) {
		return _scenario.compareTo(scenario);
	}

	@Override
	public int hashCode() {
		return _scenario.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.excilys.liferay.gatling.model.Scenario> toCacheModel() {
		return _scenario.toCacheModel();
	}

	@Override
	public com.excilys.liferay.gatling.model.Scenario toEscapedModel() {
		return new ScenarioWrapper(_scenario.toEscapedModel());
	}

	@Override
	public com.excilys.liferay.gatling.model.Scenario toUnescapedModel() {
		return new ScenarioWrapper(_scenario.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _scenario.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _scenario.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_scenario.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ScenarioWrapper)) {
			return false;
		}

		ScenarioWrapper scenarioWrapper = (ScenarioWrapper)obj;

		if (Validator.equals(_scenario, scenarioWrapper._scenario)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Scenario getWrappedScenario() {
		return _scenario;
	}

	@Override
	public Scenario getWrappedModel() {
		return _scenario;
	}

	@Override
	public void resetOriginalValues() {
		_scenario.resetOriginalValues();
	}

	private Scenario _scenario;
}