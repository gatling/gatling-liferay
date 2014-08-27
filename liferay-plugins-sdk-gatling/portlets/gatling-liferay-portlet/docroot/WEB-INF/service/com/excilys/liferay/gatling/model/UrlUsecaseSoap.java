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
public class UrlUsecaseSoap implements Serializable {
	public static UrlUsecaseSoap toSoapModel(UrlUsecase model) {
		UrlUsecaseSoap soapModel = new UrlUsecaseSoap();

		soapModel.setUrlUsecaseId(model.getUrlUsecaseId());
		soapModel.setUsecaseId(model.getUsecaseId());
		soapModel.setUrl(model.getUrl());
		soapModel.setOrder(model.getOrder());

		return soapModel;
	}

	public static UrlUsecaseSoap[] toSoapModels(UrlUsecase[] models) {
		UrlUsecaseSoap[] soapModels = new UrlUsecaseSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static UrlUsecaseSoap[][] toSoapModels(UrlUsecase[][] models) {
		UrlUsecaseSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new UrlUsecaseSoap[models.length][models[0].length];
		}
		else {
			soapModels = new UrlUsecaseSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static UrlUsecaseSoap[] toSoapModels(List<UrlUsecase> models) {
		List<UrlUsecaseSoap> soapModels = new ArrayList<UrlUsecaseSoap>(models.size());

		for (UrlUsecase model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new UrlUsecaseSoap[soapModels.size()]);
	}

	public UrlUsecaseSoap() {
	}

	public long getPrimaryKey() {
		return _urlUsecaseId;
	}

	public void setPrimaryKey(long pk) {
		setUrlUsecaseId(pk);
	}

	public long getUrlUsecaseId() {
		return _urlUsecaseId;
	}

	public void setUrlUsecaseId(long urlUsecaseId) {
		_urlUsecaseId = urlUsecaseId;
	}

	public long getUsecaseId() {
		return _usecaseId;
	}

	public void setUsecaseId(long usecaseId) {
		_usecaseId = usecaseId;
	}

	public String getUrl() {
		return _url;
	}

	public void setUrl(String url) {
		_url = url;
	}

	public int getOrder() {
		return _order;
	}

	public void setOrder(int order) {
		_order = order;
	}

	private long _urlUsecaseId;
	private long _usecaseId;
	private String _url;
	private int _order;
}