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
 * This class is a wrapper for {@link Simulation}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Simulation
 * @generated
 */
public class SimulationWrapper implements Simulation, ModelWrapper<Simulation> {
	public SimulationWrapper(Simulation simulation) {
		_simulation = simulation;
	}

	@Override
	public Class<?> getModelClass() {
		return Simulation.class;
	}

	@Override
	public String getModelClassName() {
		return Simulation.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("simulation_id", getSimulation_id());
		attributes.put("name", getName());
		attributes.put("feederContent", getFeederContent());
		attributes.put("isFeederAFile", getIsFeederAFile());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long simulation_id = (Long)attributes.get("simulation_id");

		if (simulation_id != null) {
			setSimulation_id(simulation_id);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String feederContent = (String)attributes.get("feederContent");

		if (feederContent != null) {
			setFeederContent(feederContent);
		}

		Boolean isFeederAFile = (Boolean)attributes.get("isFeederAFile");

		if (isFeederAFile != null) {
			setIsFeederAFile(isFeederAFile);
		}
	}

	/**
	* Returns the primary key of this simulation.
	*
	* @return the primary key of this simulation
	*/
	@Override
	public long getPrimaryKey() {
		return _simulation.getPrimaryKey();
	}

	/**
	* Sets the primary key of this simulation.
	*
	* @param primaryKey the primary key of this simulation
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_simulation.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the simulation_id of this simulation.
	*
	* @return the simulation_id of this simulation
	*/
	@Override
	public long getSimulation_id() {
		return _simulation.getSimulation_id();
	}

	/**
	* Sets the simulation_id of this simulation.
	*
	* @param simulation_id the simulation_id of this simulation
	*/
	@Override
	public void setSimulation_id(long simulation_id) {
		_simulation.setSimulation_id(simulation_id);
	}

	/**
	* Returns the name of this simulation.
	*
	* @return the name of this simulation
	*/
	@Override
	public java.lang.String getName() {
		return _simulation.getName();
	}

	/**
	* Sets the name of this simulation.
	*
	* @param name the name of this simulation
	*/
	@Override
	public void setName(java.lang.String name) {
		_simulation.setName(name);
	}

	/**
	* Returns the feeder content of this simulation.
	*
	* @return the feeder content of this simulation
	*/
	@Override
	public java.lang.String getFeederContent() {
		return _simulation.getFeederContent();
	}

	/**
	* Sets the feeder content of this simulation.
	*
	* @param feederContent the feeder content of this simulation
	*/
	@Override
	public void setFeederContent(java.lang.String feederContent) {
		_simulation.setFeederContent(feederContent);
	}

	/**
	* Returns the is feeder a file of this simulation.
	*
	* @return the is feeder a file of this simulation
	*/
	@Override
	public boolean getIsFeederAFile() {
		return _simulation.getIsFeederAFile();
	}

	/**
	* Returns <code>true</code> if this simulation is is feeder a file.
	*
	* @return <code>true</code> if this simulation is is feeder a file; <code>false</code> otherwise
	*/
	@Override
	public boolean isIsFeederAFile() {
		return _simulation.isIsFeederAFile();
	}

	/**
	* Sets whether this simulation is is feeder a file.
	*
	* @param isFeederAFile the is feeder a file of this simulation
	*/
	@Override
	public void setIsFeederAFile(boolean isFeederAFile) {
		_simulation.setIsFeederAFile(isFeederAFile);
	}

	@Override
	public boolean isNew() {
		return _simulation.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_simulation.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _simulation.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_simulation.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _simulation.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _simulation.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_simulation.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _simulation.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_simulation.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_simulation.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_simulation.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new SimulationWrapper((Simulation)_simulation.clone());
	}

	@Override
	public int compareTo(
		com.excilys.liferay.gatling.model.Simulation simulation) {
		return _simulation.compareTo(simulation);
	}

	@Override
	public int hashCode() {
		return _simulation.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.excilys.liferay.gatling.model.Simulation> toCacheModel() {
		return _simulation.toCacheModel();
	}

	@Override
	public com.excilys.liferay.gatling.model.Simulation toEscapedModel() {
		return new SimulationWrapper(_simulation.toEscapedModel());
	}

	@Override
	public com.excilys.liferay.gatling.model.Simulation toUnescapedModel() {
		return new SimulationWrapper(_simulation.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _simulation.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _simulation.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_simulation.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SimulationWrapper)) {
			return false;
		}

		SimulationWrapper simulationWrapper = (SimulationWrapper)obj;

		if (Validator.equals(_simulation, simulationWrapper._simulation)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Simulation getWrappedSimulation() {
		return _simulation;
	}

	@Override
	public Simulation getWrappedModel() {
		return _simulation;
	}

	@Override
	public void resetOriginalValues() {
		_simulation.resetOriginalValues();
	}

	private Simulation _simulation;
}