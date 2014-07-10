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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author sana
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