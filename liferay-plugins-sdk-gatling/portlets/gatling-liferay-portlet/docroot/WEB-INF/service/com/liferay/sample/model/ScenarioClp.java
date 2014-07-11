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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.liferay.sample.service.ClpSerializer;
import com.liferay.sample.service.ScenarioLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sana
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
		return _scenario_id;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setScenario_id(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _scenario_id;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("scenario_id", getScenario_id());
		attributes.put("name", getName());
		attributes.put("group_id", getGroup_id());
		attributes.put("simulation_id", getSimulation_id());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long scenario_id = (Long)attributes.get("scenario_id");

		if (scenario_id != null) {
			setScenario_id(scenario_id);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		Long group_id = (Long)attributes.get("group_id");

		if (group_id != null) {
			setGroup_id(group_id);
		}

		Long simulation_id = (Long)attributes.get("simulation_id");

		if (simulation_id != null) {
			setSimulation_id(simulation_id);
		}
	}

	@Override
	public long getScenario_id() {
		return _scenario_id;
	}

	@Override
	public void setScenario_id(long scenario_id) {
		_scenario_id = scenario_id;

		if (_scenarioRemoteModel != null) {
			try {
				Class<?> clazz = _scenarioRemoteModel.getClass();

				Method method = clazz.getMethod("setScenario_id", long.class);

				method.invoke(_scenarioRemoteModel, scenario_id);
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
	public long getSimulation_id() {
		return _simulation_id;
	}

	@Override
	public void setSimulation_id(long simulation_id) {
		_simulation_id = simulation_id;

		if (_scenarioRemoteModel != null) {
			try {
				Class<?> clazz = _scenarioRemoteModel.getClass();

				Method method = clazz.getMethod("setSimulation_id", long.class);

				method.invoke(_scenarioRemoteModel, simulation_id);
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

		clone.setScenario_id(getScenario_id());
		clone.setName(getName());
		clone.setGroup_id(getGroup_id());
		clone.setSimulation_id(getSimulation_id());

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
		StringBundler sb = new StringBundler(9);

		sb.append("{scenario_id=");
		sb.append(getScenario_id());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", group_id=");
		sb.append(getGroup_id());
		sb.append(", simulation_id=");
		sb.append(getSimulation_id());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(16);

		sb.append("<model><model-name>");
		sb.append("com.liferay.sample.model.Scenario");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>scenario_id</column-name><column-value><![CDATA[");
		sb.append(getScenario_id());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>group_id</column-name><column-value><![CDATA[");
		sb.append(getGroup_id());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>simulation_id</column-name><column-value><![CDATA[");
		sb.append(getSimulation_id());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _scenario_id;
	private String _name;
	private long _group_id;
	private long _simulation_id;
	private BaseModel<?> _scenarioRemoteModel;
}