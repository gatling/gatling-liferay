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

		soapModel.setScenario_id(model.getScenario_id());
		soapModel.setName(model.getName());
		soapModel.setVariableName(model.getVariableName());
		soapModel.setUrl_site(model.getUrl_site());
		soapModel.setGroup_id(model.getGroup_id());
		soapModel.setSimulation_id(model.getSimulation_id());
		soapModel.setUsers_per_seconds(model.getUsers_per_seconds());
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
		return _scenario_id;
	}

	public void setPrimaryKey(long pk) {
		setScenario_id(pk);
	}

	public long getScenario_id() {
		return _scenario_id;
	}

	public void setScenario_id(long scenario_id) {
		_scenario_id = scenario_id;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getVariableName() {
		return _variableName;
	}

	public void setVariableName(String variableName) {
		_variableName = variableName;
	}

	public String getUrl_site() {
		return _url_site;
	}

	public void setUrl_site(String url_site) {
		_url_site = url_site;
	}

	public long getGroup_id() {
		return _group_id;
	}

	public void setGroup_id(long group_id) {
		_group_id = group_id;
	}

	public long getSimulation_id() {
		return _simulation_id;
	}

	public void setSimulation_id(long simulation_id) {
		_simulation_id = simulation_id;
	}

	public long getUsers_per_seconds() {
		return _users_per_seconds;
	}

	public void setUsers_per_seconds(long users_per_seconds) {
		_users_per_seconds = users_per_seconds;
	}

	public long getDuration() {
		return _duration;
	}

	public void setDuration(long duration) {
		_duration = duration;
	}

	private long _scenario_id;
	private String _name;
	private String _variableName;
	private String _url_site;
	private long _group_id;
	private long _simulation_id;
	private long _users_per_seconds;
	private long _duration;
}