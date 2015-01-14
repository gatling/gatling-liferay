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
public class UrlRecordSoap implements Serializable {
	public static UrlRecordSoap toSoapModel(UrlRecord model) {
		UrlRecordSoap soapModel = new UrlRecordSoap();

		soapModel.setUrlRecordId(model.getUrlRecordId());
		soapModel.setRecordId(model.getRecordId());
		soapModel.setUrl(model.getUrl());
		soapModel.setType(model.getType());
		soapModel.setOrder(model.getOrder());

		return soapModel;
	}

	public static UrlRecordSoap[] toSoapModels(UrlRecord[] models) {
		UrlRecordSoap[] soapModels = new UrlRecordSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static UrlRecordSoap[][] toSoapModels(UrlRecord[][] models) {
		UrlRecordSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new UrlRecordSoap[models.length][models[0].length];
		}
		else {
			soapModels = new UrlRecordSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static UrlRecordSoap[] toSoapModels(List<UrlRecord> models) {
		List<UrlRecordSoap> soapModels = new ArrayList<UrlRecordSoap>(models.size());

		for (UrlRecord model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new UrlRecordSoap[soapModels.size()]);
	}

	public UrlRecordSoap() {
	}

	public long getPrimaryKey() {
		return _urlRecordId;
	}

	public void setPrimaryKey(long pk) {
		setUrlRecordId(pk);
	}

	public long getUrlRecordId() {
		return _urlRecordId;
	}

	public void setUrlRecordId(long urlRecordId) {
		_urlRecordId = urlRecordId;
	}

	public long getRecordId() {
		return _recordId;
	}

	public void setRecordId(long recordId) {
		_recordId = recordId;
	}

	public String getUrl() {
		return _url;
	}

	public void setUrl(String url) {
		_url = url;
	}

	public String getType() {
		return _type;
	}

	public void setType(String type) {
		_type = type;
	}

	public int getOrder() {
		return _order;
	}

	public void setOrder(int order) {
		_order = order;
	}

	private long _urlRecordId;
	private long _recordId;
	private String _url;
	private String _type;
	private int _order;
}