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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ScenarioSoap implements Serializable {
	public static ScenarioSoap toSoapModel(Scenario model) {
		ScenarioSoap soapModel = new ScenarioSoap();

		soapModel.setScenarioId(model.getScenarioId());
		soapModel.setName(model.getName());
		soapModel.setUrlSite(model.getUrlSite());
		soapModel.setGroup_id(model.getGroup_id());
		soapModel.setSimulationId(model.getSimulationId());
		soapModel.setNumberOfUsers(model.getNumberOfUsers());
		soapModel.setDuration(model.getDuration());

		return soapModel;
	}

	public static ScenarioSoap[] toSoapModels(Scenario[] models) {
		ScenarioSoap[] soapModels = new ScenarioSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ScenarioSoap[][] toSoapModels(Scenario[][] models) {
		ScenarioSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ScenarioSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ScenarioSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ScenarioSoap[] toSoapModels(List<Scenario> models) {
		List<ScenarioSoap> soapModels = new ArrayList<ScenarioSoap>(models.size());

		for (Scenario model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ScenarioSoap[soapModels.size()]);
	}

	public ScenarioSoap() {
	}

	public long getPrimaryKey() {
		return _scenarioId;
	}

	public void setPrimaryKey(long pk) {
		setScenarioId(pk);
	}

	public long getScenarioId() {
		return _scenarioId;
	}

	public void setScenarioId(long scenarioId) {
		_scenarioId = scenarioId;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getUrlSite() {
		return _urlSite;
	}

	public void setUrlSite(String urlSite) {
		_urlSite = urlSite;
	}

	public long getGroup_id() {
		return _group_id;
	}

	public void setGroup_id(long group_id) {
		_group_id = group_id;
	}

	public long getSimulationId() {
		return _simulationId;
	}

	public void setSimulationId(long simulationId) {
		_simulationId = simulationId;
	}

	public long getNumberOfUsers() {
		return _numberOfUsers;
	}

	public void setNumberOfUsers(long numberOfUsers) {
		_numberOfUsers = numberOfUsers;
	}

	public long getDuration() {
		return _duration;
	}

	public void setDuration(long duration) {
		_duration = duration;
	}

	private long _scenarioId;
	private String _name;
	private String _urlSite;
	private long _group_id;
	private long _simulationId;
	private long _numberOfUsers;
	private long _duration;
}