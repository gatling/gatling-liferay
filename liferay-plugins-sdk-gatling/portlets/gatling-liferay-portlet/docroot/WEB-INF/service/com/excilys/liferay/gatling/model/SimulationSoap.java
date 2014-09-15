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
public class SimulationSoap implements Serializable {
	public static SimulationSoap toSoapModel(Simulation model) {
		SimulationSoap soapModel = new SimulationSoap();

		soapModel.setSimulation_id(model.getSimulation_id());
		soapModel.setName(model.getName());

		return soapModel;
	}

	public static SimulationSoap[] toSoapModels(Simulation[] models) {
		SimulationSoap[] soapModels = new SimulationSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SimulationSoap[][] toSoapModels(Simulation[][] models) {
		SimulationSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SimulationSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SimulationSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SimulationSoap[] toSoapModels(List<Simulation> models) {
		List<SimulationSoap> soapModels = new ArrayList<SimulationSoap>(models.size());

		for (Simulation model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SimulationSoap[soapModels.size()]);
	}

	public SimulationSoap() {
	}

	public long getPrimaryKey() {
		return _simulation_id;
	}

	public void setPrimaryKey(long pk) {
		setSimulation_id(pk);
	}

	public long getSimulation_id() {
		return _simulation_id;
	}

	public void setSimulation_id(long simulation_id) {
		_simulation_id = simulation_id;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	private long _simulation_id;
	private String _name;
}