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
import com.excilys.liferay.gatling.service.RecordPortletLocalServiceUtil;

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
public class RecordPortletClp extends BaseModelImpl<RecordPortlet>
	implements RecordPortlet {
	public RecordPortletClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return RecordPortlet.class;
	}

	@Override
	public String getModelClassName() {
		return RecordPortlet.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _recordPortletId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setRecordPortletId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _recordPortletId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("recordPortletId", getRecordPortletId());
		attributes.put("portletId", getPortletId());
		attributes.put("state", getState());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long recordPortletId = (Long)attributes.get("recordPortletId");

		if (recordPortletId != null) {
			setRecordPortletId(recordPortletId);
		}

		String portletId = (String)attributes.get("portletId");

		if (portletId != null) {
			setPortletId(portletId);
		}

		String state = (String)attributes.get("state");

		if (state != null) {
			setState(state);
		}
	}

	@Override
	public long getRecordPortletId() {
		return _recordPortletId;
	}

	@Override
	public void setRecordPortletId(long recordPortletId) {
		_recordPortletId = recordPortletId;

		if (_recordPortletRemoteModel != null) {
			try {
				Class<?> clazz = _recordPortletRemoteModel.getClass();

				Method method = clazz.getMethod("setRecordPortletId", long.class);

				method.invoke(_recordPortletRemoteModel, recordPortletId);
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

		if (_recordPortletRemoteModel != null) {
			try {
				Class<?> clazz = _recordPortletRemoteModel.getClass();

				Method method = clazz.getMethod("setPortletId", String.class);

				method.invoke(_recordPortletRemoteModel, portletId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getState() {
		return _state;
	}

	@Override
	public void setState(String state) {
		_state = state;

		if (_recordPortletRemoteModel != null) {
			try {
				Class<?> clazz = _recordPortletRemoteModel.getClass();

				Method method = clazz.getMethod("setState", String.class);

				method.invoke(_recordPortletRemoteModel, state);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getRecordPortletRemoteModel() {
		return _recordPortletRemoteModel;
	}

	public void setRecordPortletRemoteModel(
		BaseModel<?> recordPortletRemoteModel) {
		_recordPortletRemoteModel = recordPortletRemoteModel;
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

		Class<?> remoteModelClass = _recordPortletRemoteModel.getClass();

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

		Object returnValue = method.invoke(_recordPortletRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			RecordPortletLocalServiceUtil.addRecordPortlet(this);
		}
		else {
			RecordPortletLocalServiceUtil.updateRecordPortlet(this);
		}
	}

	@Override
	public RecordPortlet toEscapedModel() {
		return (RecordPortlet)ProxyUtil.newProxyInstance(RecordPortlet.class.getClassLoader(),
			new Class[] { RecordPortlet.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		RecordPortletClp clone = new RecordPortletClp();

		clone.setRecordPortletId(getRecordPortletId());
		clone.setPortletId(getPortletId());
		clone.setState(getState());

		return clone;
	}

	@Override
	public int compareTo(RecordPortlet recordPortlet) {
		long primaryKey = recordPortlet.getPrimaryKey();

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

		if (!(obj instanceof RecordPortletClp)) {
			return false;
		}

		RecordPortletClp recordPortlet = (RecordPortletClp)obj;

		long primaryKey = recordPortlet.getPrimaryKey();

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

		sb.append("{recordPortletId=");
		sb.append(getRecordPortletId());
		sb.append(", portletId=");
		sb.append(getPortletId());
		sb.append(", state=");
		sb.append(getState());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(13);

		sb.append("<model><model-name>");
		sb.append("com.excilys.liferay.gatling.model.RecordPortlet");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>recordPortletId</column-name><column-value><![CDATA[");
		sb.append(getRecordPortletId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>portletId</column-name><column-value><![CDATA[");
		sb.append(getPortletId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>state</column-name><column-value><![CDATA[");
		sb.append(getState());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _recordPortletId;
	private String _portletId;
	private String _state;
	private BaseModel<?> _recordPortletRemoteModel;
}