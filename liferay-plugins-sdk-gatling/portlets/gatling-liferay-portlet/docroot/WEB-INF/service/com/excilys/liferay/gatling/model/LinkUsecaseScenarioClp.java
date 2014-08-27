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

import com.excilys.liferay.gatling.service.ClpSerializer;
import com.excilys.liferay.gatling.service.LinkUsecaseScenarioLocalServiceUtil;
import com.excilys.liferay.gatling.service.persistence.LinkUsecaseScenarioPK;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Brian Wing Shun Chan
 */
public class LinkUsecaseScenarioClp extends BaseModelImpl<LinkUsecaseScenario>
	implements LinkUsecaseScenario {
	public LinkUsecaseScenarioClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return LinkUsecaseScenario.class;
	}

	@Override
	public String getModelClassName() {
		return LinkUsecaseScenario.class.getName();
	}

	@Override
	public LinkUsecaseScenarioPK getPrimaryKey() {
		return new LinkUsecaseScenarioPK(_scenario_id, _usecaseId);
	}

	@Override
	public void setPrimaryKey(LinkUsecaseScenarioPK primaryKey) {
		setScenario_id(primaryKey.scenario_id);
		setUsecaseId(primaryKey.usecaseId);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return new LinkUsecaseScenarioPK(_scenario_id, _usecaseId);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((LinkUsecaseScenarioPK)primaryKeyObj);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("scenario_id", getScenario_id());
		attributes.put("usecaseId", getUsecaseId());
		attributes.put("weight", getWeight());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long scenario_id = (Long)attributes.get("scenario_id");

		if (scenario_id != null) {
			setScenario_id(scenario_id);
		}

		Long usecaseId = (Long)attributes.get("usecaseId");

		if (usecaseId != null) {
			setUsecaseId(usecaseId);
		}

		Double weight = (Double)attributes.get("weight");

		if (weight != null) {
			setWeight(weight);
		}
	}

	@Override
	public long getScenario_id() {
		return _scenario_id;
	}

	@Override
	public void setScenario_id(long scenario_id) {
		_scenario_id = scenario_id;

		if (_linkUsecaseScenarioRemoteModel != null) {
			try {
				Class<?> clazz = _linkUsecaseScenarioRemoteModel.getClass();

				Method method = clazz.getMethod("setScenario_id", long.class);

				method.invoke(_linkUsecaseScenarioRemoteModel, scenario_id);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getUsecaseId() {
		return _usecaseId;
	}

	@Override
	public void setUsecaseId(long usecaseId) {
		_usecaseId = usecaseId;

		if (_linkUsecaseScenarioRemoteModel != null) {
			try {
				Class<?> clazz = _linkUsecaseScenarioRemoteModel.getClass();

				Method method = clazz.getMethod("setUsecaseId", long.class);

				method.invoke(_linkUsecaseScenarioRemoteModel, usecaseId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getWeight() {
		return _weight;
	}

	@Override
	public void setWeight(double weight) {
		_weight = weight;

		if (_linkUsecaseScenarioRemoteModel != null) {
			try {
				Class<?> clazz = _linkUsecaseScenarioRemoteModel.getClass();

				Method method = clazz.getMethod("setWeight", double.class);

				method.invoke(_linkUsecaseScenarioRemoteModel, weight);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getLinkUsecaseScenarioRemoteModel() {
		return _linkUsecaseScenarioRemoteModel;
	}

	public void setLinkUsecaseScenarioRemoteModel(
		BaseModel<?> linkUsecaseScenarioRemoteModel) {
		_linkUsecaseScenarioRemoteModel = linkUsecaseScenarioRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _linkUsecaseScenarioRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_linkUsecaseScenarioRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			LinkUsecaseScenarioLocalServiceUtil.addLinkUsecaseScenario(this);
		}
		else {
			LinkUsecaseScenarioLocalServiceUtil.updateLinkUsecaseScenario(this);
		}
	}

	@Override
	public LinkUsecaseScenario toEscapedModel() {
		return (LinkUsecaseScenario)ProxyUtil.newProxyInstance(LinkUsecaseScenario.class.getClassLoader(),
			new Class[] { LinkUsecaseScenario.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		LinkUsecaseScenarioClp clone = new LinkUsecaseScenarioClp();

		clone.setScenario_id(getScenario_id());
		clone.setUsecaseId(getUsecaseId());
		clone.setWeight(getWeight());

		return clone;
	}

	@Override
	public int compareTo(LinkUsecaseScenario linkUsecaseScenario) {
		LinkUsecaseScenarioPK primaryKey = linkUsecaseScenario.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LinkUsecaseScenarioClp)) {
			return false;
		}

		LinkUsecaseScenarioClp linkUsecaseScenario = (LinkUsecaseScenarioClp)obj;

		LinkUsecaseScenarioPK primaryKey = linkUsecaseScenario.getPrimaryKey();

		if (getPrimaryKey().equals(primaryKey)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return getPrimaryKey().hashCode();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{scenario_id=");
		sb.append(getScenario_id());
		sb.append(", usecaseId=");
		sb.append(getUsecaseId());
		sb.append(", weight=");
		sb.append(getWeight());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(13);

		sb.append("<model><model-name>");
		sb.append("com.excilys.liferay.gatling.model.LinkUsecaseScenario");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>scenario_id</column-name><column-value><![CDATA[");
		sb.append(getScenario_id());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>usecaseId</column-name><column-value><![CDATA[");
		sb.append(getUsecaseId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>weight</column-name><column-value><![CDATA[");
		sb.append(getWeight());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _scenario_id;
	private long _usecaseId;
	private double _weight;
	private BaseModel<?> _linkUsecaseScenarioRemoteModel;
}