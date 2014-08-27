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

import com.excilys.liferay.gatling.service.persistence.LinkUsecaseScenarioPK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class LinkUsecaseScenarioSoap implements Serializable {
	public static LinkUsecaseScenarioSoap toSoapModel(LinkUsecaseScenario model) {
		LinkUsecaseScenarioSoap soapModel = new LinkUsecaseScenarioSoap();

		soapModel.setScenario_id(model.getScenario_id());
		soapModel.setUsecaseId(model.getUsecaseId());
		soapModel.setWeight(model.getWeight());

		return soapModel;
	}

	public static LinkUsecaseScenarioSoap[] toSoapModels(
		LinkUsecaseScenario[] models) {
		LinkUsecaseScenarioSoap[] soapModels = new LinkUsecaseScenarioSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LinkUsecaseScenarioSoap[][] toSoapModels(
		LinkUsecaseScenario[][] models) {
		LinkUsecaseScenarioSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new LinkUsecaseScenarioSoap[models.length][models[0].length];
		}
		else {
			soapModels = new LinkUsecaseScenarioSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LinkUsecaseScenarioSoap[] toSoapModels(
		List<LinkUsecaseScenario> models) {
		List<LinkUsecaseScenarioSoap> soapModels = new ArrayList<LinkUsecaseScenarioSoap>(models.size());

		for (LinkUsecaseScenario model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LinkUsecaseScenarioSoap[soapModels.size()]);
	}

	public LinkUsecaseScenarioSoap() {
	}

	public LinkUsecaseScenarioPK getPrimaryKey() {
		return new LinkUsecaseScenarioPK(_scenario_id, _usecaseId);
	}

	public void setPrimaryKey(LinkUsecaseScenarioPK pk) {
		setScenario_id(pk.scenario_id);
		setUsecaseId(pk.usecaseId);
	}

	public long getScenario_id() {
		return _scenario_id;
	}

	public void setScenario_id(long scenario_id) {
		_scenario_id = scenario_id;
	}

	public long getUsecaseId() {
		return _usecaseId;
	}

	public void setUsecaseId(long usecaseId) {
		_usecaseId = usecaseId;
	}

	public double getWeight() {
		return _weight;
	}

	public void setWeight(double weight) {
		_weight = weight;
	}

	private long _scenario_id;
	private long _usecaseId;
	private double _weight;
}