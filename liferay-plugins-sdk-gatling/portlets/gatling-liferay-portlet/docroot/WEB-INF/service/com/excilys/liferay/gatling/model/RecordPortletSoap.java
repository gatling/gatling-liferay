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
 * This class is used by SOAP remote services, specifically {@link com.excilys.liferay.gatling.service.http.RecordPortletServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.excilys.liferay.gatling.service.http.RecordPortletServiceSoap
 * @generated
 */
public class RecordPortletSoap implements Serializable {
	public static RecordPortletSoap toSoapModel(RecordPortlet model) {
		RecordPortletSoap soapModel = new RecordPortletSoap();

		soapModel.setRecordPortletId(model.getRecordPortletId());
		soapModel.setPortletId(model.getPortletId());
		soapModel.setState(model.getState());

		return soapModel;
	}

	public static RecordPortletSoap[] toSoapModels(RecordPortlet[] models) {
		RecordPortletSoap[] soapModels = new RecordPortletSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static RecordPortletSoap[][] toSoapModels(RecordPortlet[][] models) {
		RecordPortletSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new RecordPortletSoap[models.length][models[0].length];
		}
		else {
			soapModels = new RecordPortletSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static RecordPortletSoap[] toSoapModels(List<RecordPortlet> models) {
		List<RecordPortletSoap> soapModels = new ArrayList<RecordPortletSoap>(models.size());

		for (RecordPortlet model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new RecordPortletSoap[soapModels.size()]);
	}

	public RecordPortletSoap() {
	}

	public long getPrimaryKey() {
		return _recordPortletId;
	}

	public void setPrimaryKey(long pk) {
		setRecordPortletId(pk);
	}

	public long getRecordPortletId() {
		return _recordPortletId;
	}

	public void setRecordPortletId(long recordPortletId) {
		_recordPortletId = recordPortletId;
	}

	public String getPortletId() {
		return _portletId;
	}

	public void setPortletId(String portletId) {
		_portletId = portletId;
	}

	public String getState() {
		return _state;
	}

	public void setState(String state) {
		_state = state;
	}

	private long _recordPortletId;
	private String _portletId;
	private String _state;
}