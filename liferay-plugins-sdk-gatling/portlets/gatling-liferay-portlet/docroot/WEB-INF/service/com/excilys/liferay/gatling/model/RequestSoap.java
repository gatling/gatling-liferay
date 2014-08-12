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
public class RequestSoap implements Serializable {
	public static RequestSoap toSoapModel(Request model) {
		RequestSoap soapModel = new RequestSoap();

		soapModel.setRequest_id(model.getRequest_id());
		soapModel.setScenario_id(model.getScenario_id());
		soapModel.setName(model.getName());
		soapModel.setUrl(model.getUrl());
		soapModel.setWeight(model.getWeight());
		soapModel.setPrivatePage(model.getPrivatePage());
		soapModel.setParentLayoutId(model.getParentLayoutId());
		soapModel.setLayoutId(model.getLayoutId());

		return soapModel;
	}

	public static RequestSoap[] toSoapModels(Request[] models) {
		RequestSoap[] soapModels = new RequestSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static RequestSoap[][] toSoapModels(Request[][] models) {
		RequestSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new RequestSoap[models.length][models[0].length];
		}
		else {
			soapModels = new RequestSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static RequestSoap[] toSoapModels(List<Request> models) {
		List<RequestSoap> soapModels = new ArrayList<RequestSoap>(models.size());

		for (Request model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new RequestSoap[soapModels.size()]);
	}

	public RequestSoap() {
	}

	public long getPrimaryKey() {
		return _request_id;
	}

	public void setPrimaryKey(long pk) {
		setRequest_id(pk);
	}

	public long getRequest_id() {
		return _request_id;
	}

	public void setRequest_id(long request_id) {
		_request_id = request_id;
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

	public String getUrl() {
		return _url;
	}

	public void setUrl(String url) {
		_url = url;
	}

	public double getWeight() {
		return _weight;
	}

	public void setWeight(double weight) {
		_weight = weight;
	}

	public boolean getPrivatePage() {
		return _privatePage;
	}

	public boolean isPrivatePage() {
		return _privatePage;
	}

	public void setPrivatePage(boolean privatePage) {
		_privatePage = privatePage;
	}

	public long getParentLayoutId() {
		return _parentLayoutId;
	}

	public void setParentLayoutId(long parentLayoutId) {
		_parentLayoutId = parentLayoutId;
	}

	public long getLayoutId() {
		return _layoutId;
	}

	public void setLayoutId(long layoutId) {
		_layoutId = layoutId;
	}

	private long _request_id;
	private long _scenario_id;
	private String _name;
	private String _url;
	private double _weight;
	private boolean _privatePage;
	private long _parentLayoutId;
	private long _layoutId;
}