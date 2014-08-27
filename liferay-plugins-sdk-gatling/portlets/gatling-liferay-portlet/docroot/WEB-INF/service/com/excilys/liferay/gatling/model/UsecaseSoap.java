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
public class UsecaseSoap implements Serializable {
	public static UsecaseSoap toSoapModel(Usecase model) {
		UsecaseSoap soapModel = new UsecaseSoap();

		soapModel.setUsecaseId(model.getUsecaseId());
		soapModel.setPortletId(model.getPortletId());
		soapModel.setVersionPortlet(model.getVersionPortlet());
		soapModel.setName(model.getName());

		return soapModel;
	}

	public static UsecaseSoap[] toSoapModels(Usecase[] models) {
		UsecaseSoap[] soapModels = new UsecaseSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static UsecaseSoap[][] toSoapModels(Usecase[][] models) {
		UsecaseSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new UsecaseSoap[models.length][models[0].length];
		}
		else {
			soapModels = new UsecaseSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static UsecaseSoap[] toSoapModels(List<Usecase> models) {
		List<UsecaseSoap> soapModels = new ArrayList<UsecaseSoap>(models.size());

		for (Usecase model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new UsecaseSoap[soapModels.size()]);
	}

	public UsecaseSoap() {
	}

	public long getPrimaryKey() {
		return _usecaseId;
	}

	public void setPrimaryKey(long pk) {
		setUsecaseId(pk);
	}

	public long getUsecaseId() {
		return _usecaseId;
	}

	public void setUsecaseId(long usecaseId) {
		_usecaseId = usecaseId;
	}

	public long getPortletId() {
		return _portletId;
	}

	public void setPortletId(long portletId) {
		_portletId = portletId;
	}

	public long getVersionPortlet() {
		return _versionPortlet;
	}

	public void setVersionPortlet(long versionPortlet) {
		_versionPortlet = versionPortlet;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	private long _usecaseId;
	private long _portletId;
	private long _versionPortlet;
	private String _name;
}