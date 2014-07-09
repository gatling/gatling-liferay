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
public class RequestSoap implements Serializable {
	public static RequestSoap toSoapModel(Request model) {
		RequestSoap soapModel = new RequestSoap();

		soapModel.setRequest_id(model.getRequest_id());
		soapModel.setScenario_id(model.getScenario_id());
		soapModel.setUrl(model.getUrl());
		soapModel.setRate(model.getRate());

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

	public String getUrl() {
		return _url;
	}

	public void setUrl(String url) {
		_url = url;
	}

	public int getRate() {
		return _rate;
	}

	public void setRate(int rate) {
		_rate = rate;
	}

	private long _request_id;
	private long _scenario_id;
	private String _url;
	private int _rate;
}