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
 * This class is used by SOAP remote services, specifically {@link com.excilys.liferay.gatling.service.http.PortletStressServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.excilys.liferay.gatling.service.http.PortletStressServiceSoap
 * @generated
 */
public class PortletStressSoap implements Serializable {
	public static PortletStressSoap toSoapModel(PortletStress model) {
		PortletStressSoap soapModel = new PortletStressSoap();

		soapModel.setPortletStressId(model.getPortletStressId());
		soapModel.setPortletId(model.getPortletId());
		soapModel.setScenario_id(model.getScenario_id());

		return soapModel;
	}

	public static PortletStressSoap[] toSoapModels(PortletStress[] models) {
		PortletStressSoap[] soapModels = new PortletStressSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static PortletStressSoap[][] toSoapModels(PortletStress[][] models) {
		PortletStressSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new PortletStressSoap[models.length][models[0].length];
		}
		else {
			soapModels = new PortletStressSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static PortletStressSoap[] toSoapModels(List<PortletStress> models) {
		List<PortletStressSoap> soapModels = new ArrayList<PortletStressSoap>(models.size());

		for (PortletStress model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new PortletStressSoap[soapModels.size()]);
	}

	public PortletStressSoap() {
	}

	public long getPrimaryKey() {
		return _portletStressId;
	}

	public void setPrimaryKey(long pk) {
		setPortletStressId(pk);
	}

	public long getPortletStressId() {
		return _portletStressId;
	}

	public void setPortletStressId(long portletStressId) {
		_portletStressId = portletStressId;
	}

	public String getPortletId() {
		return _portletId;
	}

	public void setPortletId(String portletId) {
		_portletId = portletId;
	}

	public long getScenario_id() {
		return _scenario_id;
	}

	public void setScenario_id(long scenario_id) {
		_scenario_id = scenario_id;
	}

	private long _portletStressId;
	private String _portletId;
	private long _scenario_id;
}