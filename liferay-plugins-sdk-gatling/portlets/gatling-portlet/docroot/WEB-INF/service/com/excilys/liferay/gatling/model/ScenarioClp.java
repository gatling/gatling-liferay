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
import com.excilys.liferay.gatling.service.ScenarioLocalServiceUtil;

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
public class ScenarioClp extends BaseModelImpl<Scenario> implements Scenario {
	public ScenarioClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Scenario.class;
	}

	@Override
	public String getModelClassName() {
		return Scenario.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _scenarioId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setScenarioId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _scenarioId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("scenarioId", getScenarioId());
		attributes.put("name", getName());
		attributes.put("urlSite", getUrlSite());
		attributes.put("group_id", getGroup_id());
		attributes.put("simulationId", getSimulationId());
		attributes.put("numberOfUsers", getNumberOfUsers());
		attributes.put("duration", getDuration());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long scenarioId = (Long)attributes.get("scenarioId");

		if (scenarioId != null) {
			setScenarioId(scenarioId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String urlSite = (String)attributes.get("urlSite");

		if (urlSite != null) {
			setUrlSite(urlSite);
		}

		Long group_id = (Long)attributes.get("group_id");

		if (group_id != null) {
			setGroup_id(group_id);
		}

		Long simulationId = (Long)attributes.get("simulationId");

		if (simulationId != null) {
			setSimulationId(simulationId);
		}

		Long numberOfUsers = (Long)attributes.get("numberOfUsers");

		if (numberOfUsers != null) {
			setNumberOfUsers(numberOfUsers);
		}

		Long duration = (Long)attributes.get("duration");

		if (duration != null) {
			setDuration(duration);
		}
	}

	@Override
	public long getScenarioId() {
		return _scenarioId;
	}

	@Override
	public void setScenarioId(long scenarioId) {
		_scenarioId = scenarioId;

		if (_scenarioRemoteModel != null) {
			try {
				Class<?> clazz = _scenarioRemoteModel.getClass();

				Method method = clazz.getMethod("setScenarioId", long.class);

				method.invoke(_scenarioRemoteModel, scenarioId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getName() {
		return _name;
	}

	@Override
	public void setName(String name) {
		_name = name;

		if (_scenarioRemoteModel != null) {
			try {
				Class<?> clazz = _scenarioRemoteModel.getClass();

				Method method = clazz.getMethod("setName", String.class);

				method.invoke(_scenarioRemoteModel, name);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUrlSite() {
		return _urlSite;
	}

	@Override
	public void setUrlSite(String urlSite) {
		_urlSite = urlSite;

		if (_scenarioRemoteModel != null) {
			try {
				Class<?> clazz = _scenarioRemoteModel.getClass();

				Method method = clazz.getMethod("setUrlSite", String.class);

				method.invoke(_scenarioRemoteModel, urlSite);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getGroup_id() {
		return _group_id;
	}

	@Override
	public void setGroup_id(long group_id) {
		_group_id = group_id;

		if (_scenarioRemoteModel != null) {
			try {
				Class<?> clazz = _scenarioRemoteModel.getClass();

				Method method = clazz.getMethod("setGroup_id", long.class);

				method.invoke(_scenarioRemoteModel, group_id);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getSimulationId() {
		return _simulationId;
	}

	@Override
	public void setSimulationId(long simulationId) {
		_simulationId = simulationId;

		if (_scenarioRemoteModel != null) {
			try {
				Class<?> clazz = _scenarioRemoteModel.getClass();

				Method method = clazz.getMethod("setSimulationId", long.class);

				method.invoke(_scenarioRemoteModel, simulationId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getNumberOfUsers() {
		return _numberOfUsers;
	}

	@Override
	public void setNumberOfUsers(long numberOfUsers) {
		_numberOfUsers = numberOfUsers;

		if (_scenarioRemoteModel != null) {
			try {
				Class<?> clazz = _scenarioRemoteModel.getClass();

				Method method = clazz.getMethod("setNumberOfUsers", long.class);

				method.invoke(_scenarioRemoteModel, numberOfUsers);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getDuration() {
		return _duration;
	}

	@Override
	public void setDuration(long duration) {
		_duration = duration;

		if (_scenarioRemoteModel != null) {
			try {
				Class<?> clazz = _scenarioRemoteModel.getClass();

				Method method = clazz.getMethod("setDuration", long.class);

				method.invoke(_scenarioRemoteModel, duration);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getScenarioRemoteModel() {
		return _scenarioRemoteModel;
	}

	public void setScenarioRemoteModel(BaseModel<?> scenarioRemoteModel) {
		_scenarioRemoteModel = scenarioRemoteModel;
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

		Class<?> remoteModelClass = _scenarioRemoteModel.getClass();

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

		Object returnValue = method.invoke(_scenarioRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ScenarioLocalServiceUtil.addScenario(this);
		}
		else {
			ScenarioLocalServiceUtil.updateScenario(this);
		}
	}

	@Override
	public Scenario toEscapedModel() {
		return (Scenario)ProxyUtil.newProxyInstance(Scenario.class.getClassLoader(),
			new Class[] { Scenario.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ScenarioClp clone = new ScenarioClp();

		clone.setScenarioId(getScenarioId());
		clone.setName(getName());
		clone.setUrlSite(getUrlSite());
		clone.setGroup_id(getGroup_id());
		clone.setSimulationId(getSimulationId());
		clone.setNumberOfUsers(getNumberOfUsers());
		clone.setDuration(getDuration());

		return clone;
	}

	@Override
	public int compareTo(Scenario scenario) {
		long primaryKey = scenario.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ScenarioClp)) {
			return false;
		}

		ScenarioClp scenario = (ScenarioClp)obj;

		long primaryKey = scenario.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{scenarioId=");
		sb.append(getScenarioId());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", urlSite=");
		sb.append(getUrlSite());
		sb.append(", group_id=");
		sb.append(getGroup_id());
		sb.append(", simulationId=");
		sb.append(getSimulationId());
		sb.append(", numberOfUsers=");
		sb.append(getNumberOfUsers());
		sb.append(", duration=");
		sb.append(getDuration());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(25);

		sb.append("<model><model-name>");
		sb.append("com.excilys.liferay.gatling.model.Scenario");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>scenarioId</column-name><column-value><![CDATA[");
		sb.append(getScenarioId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>urlSite</column-name><column-value><![CDATA[");
		sb.append(getUrlSite());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>group_id</column-name><column-value><![CDATA[");
		sb.append(getGroup_id());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>simulationId</column-name><column-value><![CDATA[");
		sb.append(getSimulationId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>numberOfUsers</column-name><column-value><![CDATA[");
		sb.append(getNumberOfUsers());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>duration</column-name><column-value><![CDATA[");
		sb.append(getDuration());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _scenarioId;
	private String _name;
	private String _urlSite;
	private long _group_id;
	private long _simulationId;
	private long _numberOfUsers;
	private long _duration;
	private BaseModel<?> _scenarioRemoteModel;
}