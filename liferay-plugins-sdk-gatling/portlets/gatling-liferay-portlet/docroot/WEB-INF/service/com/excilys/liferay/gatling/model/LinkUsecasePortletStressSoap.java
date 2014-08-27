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
public class LinkUsecasePortletStressSoap implements Serializable {
	public static LinkUsecasePortletStressSoap toSoapModel(
		LinkUsecasePortletStress model) {
		LinkUsecasePortletStressSoap soapModel = new LinkUsecasePortletStressSoap();

		soapModel.setLinkUsecasePortletStressId(model.getLinkUsecasePortletStressId());
		soapModel.setPortletStressId(model.getPortletStressId());
		soapModel.setUsecaseId(model.getUsecaseId());
		soapModel.setWeight(model.getWeight());

		return soapModel;
	}

	public static LinkUsecasePortletStressSoap[] toSoapModels(
		LinkUsecasePortletStress[] models) {
		LinkUsecasePortletStressSoap[] soapModels = new LinkUsecasePortletStressSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LinkUsecasePortletStressSoap[][] toSoapModels(
		LinkUsecasePortletStress[][] models) {
		LinkUsecasePortletStressSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new LinkUsecasePortletStressSoap[models.length][models[0].length];
		}
		else {
			soapModels = new LinkUsecasePortletStressSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LinkUsecasePortletStressSoap[] toSoapModels(
		List<LinkUsecasePortletStress> models) {
		List<LinkUsecasePortletStressSoap> soapModels = new ArrayList<LinkUsecasePortletStressSoap>(models.size());

		for (LinkUsecasePortletStress model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LinkUsecasePortletStressSoap[soapModels.size()]);
	}

	public LinkUsecasePortletStressSoap() {
	}

	public long getPrimaryKey() {
		return _linkUsecasePortletStressId;
	}

	public void setPrimaryKey(long pk) {
		setLinkUsecasePortletStressId(pk);
	}

	public long getLinkUsecasePortletStressId() {
		return _linkUsecasePortletStressId;
	}

	public void setLinkUsecasePortletStressId(long linkUsecasePortletStressId) {
		_linkUsecasePortletStressId = linkUsecasePortletStressId;
	}

	public long getPortletStressId() {
		return _portletStressId;
	}

	public void setPortletStressId(long portletStressId) {
		_portletStressId = portletStressId;
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

	private long _linkUsecasePortletStressId;
	private long _portletStressId;
	private long _usecaseId;
	private double _weight;
}