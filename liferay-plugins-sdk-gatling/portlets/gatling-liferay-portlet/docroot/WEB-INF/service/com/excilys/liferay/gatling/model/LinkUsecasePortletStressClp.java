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
import com.excilys.liferay.gatling.service.LinkUsecasePortletStressLocalServiceUtil;

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
public class LinkUsecasePortletStressClp extends BaseModelImpl<LinkUsecasePortletStress>
	implements LinkUsecasePortletStress {
	public LinkUsecasePortletStressClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return LinkUsecasePortletStress.class;
	}

	@Override
	public String getModelClassName() {
		return LinkUsecasePortletStress.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _linkUsecasePortletStressId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setLinkUsecasePortletStressId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _linkUsecasePortletStressId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("linkUsecasePortletStressId",
			getLinkUsecasePortletStressId());
		attributes.put("portletStressId", getPortletStressId());
		attributes.put("usecaseId", getUsecaseId());
		attributes.put("weight", getWeight());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long linkUsecasePortletStressId = (Long)attributes.get(
				"linkUsecasePortletStressId");

		if (linkUsecasePortletStressId != null) {
			setLinkUsecasePortletStressId(linkUsecasePortletStressId);
		}

		Long portletStressId = (Long)attributes.get("portletStressId");

		if (portletStressId != null) {
			setPortletStressId(portletStressId);
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
	public long getLinkUsecasePortletStressId() {
		return _linkUsecasePortletStressId;
	}

	@Override
	public void setLinkUsecasePortletStressId(long linkUsecasePortletStressId) {
		_linkUsecasePortletStressId = linkUsecasePortletStressId;

		if (_linkUsecasePortletStressRemoteModel != null) {
			try {
				Class<?> clazz = _linkUsecasePortletStressRemoteModel.getClass();

				Method method = clazz.getMethod("setLinkUsecasePortletStressId",
						long.class);

				method.invoke(_linkUsecasePortletStressRemoteModel,
					linkUsecasePortletStressId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getPortletStressId() {
		return _portletStressId;
	}

	@Override
	public void setPortletStressId(long portletStressId) {
		_portletStressId = portletStressId;

		if (_linkUsecasePortletStressRemoteModel != null) {
			try {
				Class<?> clazz = _linkUsecasePortletStressRemoteModel.getClass();

				Method method = clazz.getMethod("setPortletStressId", long.class);

				method.invoke(_linkUsecasePortletStressRemoteModel,
					portletStressId);
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

		if (_linkUsecasePortletStressRemoteModel != null) {
			try {
				Class<?> clazz = _linkUsecasePortletStressRemoteModel.getClass();

				Method method = clazz.getMethod("setUsecaseId", long.class);

				method.invoke(_linkUsecasePortletStressRemoteModel, usecaseId);
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

		if (_linkUsecasePortletStressRemoteModel != null) {
			try {
				Class<?> clazz = _linkUsecasePortletStressRemoteModel.getClass();

				Method method = clazz.getMethod("setWeight", double.class);

				method.invoke(_linkUsecasePortletStressRemoteModel, weight);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getLinkUsecasePortletStressRemoteModel() {
		return _linkUsecasePortletStressRemoteModel;
	}

	public void setLinkUsecasePortletStressRemoteModel(
		BaseModel<?> linkUsecasePortletStressRemoteModel) {
		_linkUsecasePortletStressRemoteModel = linkUsecasePortletStressRemoteModel;
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

		Class<?> remoteModelClass = _linkUsecasePortletStressRemoteModel.getClass();

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

		Object returnValue = method.invoke(_linkUsecasePortletStressRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			LinkUsecasePortletStressLocalServiceUtil.addLinkUsecasePortletStress(this);
		}
		else {
			LinkUsecasePortletStressLocalServiceUtil.updateLinkUsecasePortletStress(this);
		}
	}

	@Override
	public LinkUsecasePortletStress toEscapedModel() {
		return (LinkUsecasePortletStress)ProxyUtil.newProxyInstance(LinkUsecasePortletStress.class.getClassLoader(),
			new Class[] { LinkUsecasePortletStress.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		LinkUsecasePortletStressClp clone = new LinkUsecasePortletStressClp();

		clone.setLinkUsecasePortletStressId(getLinkUsecasePortletStressId());
		clone.setPortletStressId(getPortletStressId());
		clone.setUsecaseId(getUsecaseId());
		clone.setWeight(getWeight());

		return clone;
	}

	@Override
	public int compareTo(LinkUsecasePortletStress linkUsecasePortletStress) {
		long primaryKey = linkUsecasePortletStress.getPrimaryKey();

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

		if (!(obj instanceof LinkUsecasePortletStressClp)) {
			return false;
		}

		LinkUsecasePortletStressClp linkUsecasePortletStress = (LinkUsecasePortletStressClp)obj;

		long primaryKey = linkUsecasePortletStress.getPrimaryKey();

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

		sb.append("{linkUsecasePortletStressId=");
		sb.append(getLinkUsecasePortletStressId());
		sb.append(", portletStressId=");
		sb.append(getPortletStressId());
		sb.append(", usecaseId=");
		sb.append(getUsecaseId());
		sb.append(", weight=");
		sb.append(getWeight());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(16);

		sb.append("<model><model-name>");
		sb.append("com.excilys.liferay.gatling.model.LinkUsecasePortletStress");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>linkUsecasePortletStressId</column-name><column-value><![CDATA[");
		sb.append(getLinkUsecasePortletStressId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>portletStressId</column-name><column-value><![CDATA[");
		sb.append(getPortletStressId());
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

	private long _linkUsecasePortletStressId;
	private long _portletStressId;
	private long _usecaseId;
	private double _weight;
	private BaseModel<?> _linkUsecasePortletStressRemoteModel;
}