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
import com.excilys.liferay.gatling.service.UsecaseLocalServiceUtil;

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
public class UsecaseClp extends BaseModelImpl<Usecase> implements Usecase {
	public UsecaseClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Usecase.class;
	}

	@Override
	public String getModelClassName() {
		return Usecase.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _usecaseId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setUsecaseId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _usecaseId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("usecaseId", getUsecaseId());
		attributes.put("portletId", getPortletId());
		attributes.put("versionPortlet", getVersionPortlet());
		attributes.put("name", getName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long usecaseId = (Long)attributes.get("usecaseId");

		if (usecaseId != null) {
			setUsecaseId(usecaseId);
		}

		Long portletId = (Long)attributes.get("portletId");

		if (portletId != null) {
			setPortletId(portletId);
		}

		Long versionPortlet = (Long)attributes.get("versionPortlet");

		if (versionPortlet != null) {
			setVersionPortlet(versionPortlet);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}
	}

	@Override
	public long getUsecaseId() {
		return _usecaseId;
	}

	@Override
	public void setUsecaseId(long usecaseId) {
		_usecaseId = usecaseId;

		if (_usecaseRemoteModel != null) {
			try {
				Class<?> clazz = _usecaseRemoteModel.getClass();

				Method method = clazz.getMethod("setUsecaseId", long.class);

				method.invoke(_usecaseRemoteModel, usecaseId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getPortletId() {
		return _portletId;
	}

	@Override
	public void setPortletId(long portletId) {
		_portletId = portletId;

		if (_usecaseRemoteModel != null) {
			try {
				Class<?> clazz = _usecaseRemoteModel.getClass();

				Method method = clazz.getMethod("setPortletId", long.class);

				method.invoke(_usecaseRemoteModel, portletId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getVersionPortlet() {
		return _versionPortlet;
	}

	@Override
	public void setVersionPortlet(long versionPortlet) {
		_versionPortlet = versionPortlet;

		if (_usecaseRemoteModel != null) {
			try {
				Class<?> clazz = _usecaseRemoteModel.getClass();

				Method method = clazz.getMethod("setVersionPortlet", long.class);

				method.invoke(_usecaseRemoteModel, versionPortlet);
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

		if (_usecaseRemoteModel != null) {
			try {
				Class<?> clazz = _usecaseRemoteModel.getClass();

				Method method = clazz.getMethod("setName", String.class);

				method.invoke(_usecaseRemoteModel, name);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getUsecaseRemoteModel() {
		return _usecaseRemoteModel;
	}

	public void setUsecaseRemoteModel(BaseModel<?> usecaseRemoteModel) {
		_usecaseRemoteModel = usecaseRemoteModel;
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

		Class<?> remoteModelClass = _usecaseRemoteModel.getClass();

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

		Object returnValue = method.invoke(_usecaseRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			UsecaseLocalServiceUtil.addUsecase(this);
		}
		else {
			UsecaseLocalServiceUtil.updateUsecase(this);
		}
	}

	@Override
	public Usecase toEscapedModel() {
		return (Usecase)ProxyUtil.newProxyInstance(Usecase.class.getClassLoader(),
			new Class[] { Usecase.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		UsecaseClp clone = new UsecaseClp();

		clone.setUsecaseId(getUsecaseId());
		clone.setPortletId(getPortletId());
		clone.setVersionPortlet(getVersionPortlet());
		clone.setName(getName());

		return clone;
	}

	@Override
	public int compareTo(Usecase usecase) {
		long primaryKey = usecase.getPrimaryKey();

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

		if (!(obj instanceof UsecaseClp)) {
			return false;
		}

		UsecaseClp usecase = (UsecaseClp)obj;

		long primaryKey = usecase.getPrimaryKey();

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

		sb.append("{usecaseId=");
		sb.append(getUsecaseId());
		sb.append(", portletId=");
		sb.append(getPortletId());
		sb.append(", versionPortlet=");
		sb.append(getVersionPortlet());
		sb.append(", name=");
		sb.append(getName());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(16);

		sb.append("<model><model-name>");
		sb.append("com.excilys.liferay.gatling.model.Usecase");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>usecaseId</column-name><column-value><![CDATA[");
		sb.append(getUsecaseId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>portletId</column-name><column-value><![CDATA[");
		sb.append(getPortletId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>versionPortlet</column-name><column-value><![CDATA[");
		sb.append(getVersionPortlet());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _usecaseId;
	private long _portletId;
	private long _versionPortlet;
	private String _name;
	private BaseModel<?> _usecaseRemoteModel;
}