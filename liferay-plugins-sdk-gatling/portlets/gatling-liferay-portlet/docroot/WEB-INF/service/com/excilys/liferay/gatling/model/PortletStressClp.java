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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
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
public class PortletStressClp extends BaseModelImpl<PortletStress>
	implements PortletStress {
	public PortletStressClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return PortletStress.class;
	}

	@Override
	public String getModelClassName() {
		return PortletStress.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _portletStressId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setPortletStressId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _portletStressId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("portletStressId", getPortletStressId());
		attributes.put("portletId", getPortletId());
		attributes.put("scenario_id", getScenario_id());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long portletStressId = (Long)attributes.get("portletStressId");

		if (portletStressId != null) {
			setPortletStressId(portletStressId);
		}

		String portletId = (String)attributes.get("portletId");

		if (portletId != null) {
			setPortletId(portletId);
		}

		Long scenario_id = (Long)attributes.get("scenario_id");

		if (scenario_id != null) {
			setScenario_id(scenario_id);
		}
	}

	@Override
	public long getPortletStressId() {
		return _portletStressId;
	}

	@Override
	public void setPortletStressId(long portletStressId) {
		_portletStressId = portletStressId;

		if (_portletStressRemoteModel != null) {
			try {
				Class<?> clazz = _portletStressRemoteModel.getClass();

				Method method = clazz.getMethod("setPortletStressId", long.class);

				method.invoke(_portletStressRemoteModel, portletStressId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPortletId() {
		return _portletId;
	}

	@Override
	public void setPortletId(String portletId) {
		_portletId = portletId;

		if (_portletStressRemoteModel != null) {
			try {
				Class<?> clazz = _portletStressRemoteModel.getClass();

				Method method = clazz.getMethod("setPortletId", String.class);

				method.invoke(_portletStressRemoteModel, portletId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getScenario_id() {
		return _scenario_id;
	}

	@Override
	public void setScenario_id(long scenario_id) {
		_scenario_id = scenario_id;

		if (_portletStressRemoteModel != null) {
			try {
				Class<?> clazz = _portletStressRemoteModel.getClass();

				Method method = clazz.getMethod("setScenario_id", long.class);

				method.invoke(_portletStressRemoteModel, scenario_id);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getPortletStressRemoteModel() {
		return _portletStressRemoteModel;
	}

	public void setPortletStressRemoteModel(
		BaseModel<?> portletStressRemoteModel) {
		_portletStressRemoteModel = portletStressRemoteModel;
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

		Class<?> remoteModelClass = _portletStressRemoteModel.getClass();

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

		Object returnValue = method.invoke(_portletStressRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public PortletStress toEscapedModel() {
		return (PortletStress)ProxyUtil.newProxyInstance(PortletStress.class.getClassLoader(),
			new Class[] { PortletStress.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		PortletStressClp clone = new PortletStressClp();

		clone.setPortletStressId(getPortletStressId());
		clone.setPortletId(getPortletId());
		clone.setScenario_id(getScenario_id());

		return clone;
	}

	@Override
	public int compareTo(PortletStress portletStress) {
		long primaryKey = portletStress.getPrimaryKey();

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

		if (!(obj instanceof PortletStressClp)) {
			return false;
		}

		PortletStressClp portletStress = (PortletStressClp)obj;

		long primaryKey = portletStress.getPrimaryKey();

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
		StringBundler sb = new StringBundler(7);

		sb.append("{portletStressId=");
		sb.append(getPortletStressId());
		sb.append(", portletId=");
		sb.append(getPortletId());
		sb.append(", scenario_id=");
		sb.append(getScenario_id());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(13);

		sb.append("<model><model-name>");
		sb.append("com.excilys.liferay.gatling.model.PortletStress");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>portletStressId</column-name><column-value><![CDATA[");
		sb.append(getPortletStressId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>portletId</column-name><column-value><![CDATA[");
		sb.append(getPortletId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>scenario_id</column-name><column-value><![CDATA[");
		sb.append(getScenario_id());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _portletStressId;
	private String _portletId;
	private long _scenario_id;
	private BaseModel<?> _portletStressRemoteModel;
}