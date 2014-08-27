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
import com.excilys.liferay.gatling.service.UrlUsecaseLocalServiceUtil;

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
public class UrlUsecaseClp extends BaseModelImpl<UrlUsecase>
	implements UrlUsecase {
	public UrlUsecaseClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return UrlUsecase.class;
	}

	@Override
	public String getModelClassName() {
		return UrlUsecase.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _urlUsecaseId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setUrlUsecaseId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _urlUsecaseId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("urlUsecaseId", getUrlUsecaseId());
		attributes.put("usecaseId", getUsecaseId());
		attributes.put("url", getUrl());
		attributes.put("order", getOrder());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long urlUsecaseId = (Long)attributes.get("urlUsecaseId");

		if (urlUsecaseId != null) {
			setUrlUsecaseId(urlUsecaseId);
		}

		Long usecaseId = (Long)attributes.get("usecaseId");

		if (usecaseId != null) {
			setUsecaseId(usecaseId);
		}

		String url = (String)attributes.get("url");

		if (url != null) {
			setUrl(url);
		}

		Integer order = (Integer)attributes.get("order");

		if (order != null) {
			setOrder(order);
		}
	}

	@Override
	public long getUrlUsecaseId() {
		return _urlUsecaseId;
	}

	@Override
	public void setUrlUsecaseId(long urlUsecaseId) {
		_urlUsecaseId = urlUsecaseId;

		if (_urlUsecaseRemoteModel != null) {
			try {
				Class<?> clazz = _urlUsecaseRemoteModel.getClass();

				Method method = clazz.getMethod("setUrlUsecaseId", long.class);

				method.invoke(_urlUsecaseRemoteModel, urlUsecaseId);
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

		if (_urlUsecaseRemoteModel != null) {
			try {
				Class<?> clazz = _urlUsecaseRemoteModel.getClass();

				Method method = clazz.getMethod("setUsecaseId", long.class);

				method.invoke(_urlUsecaseRemoteModel, usecaseId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUrl() {
		return _url;
	}

	@Override
	public void setUrl(String url) {
		_url = url;

		if (_urlUsecaseRemoteModel != null) {
			try {
				Class<?> clazz = _urlUsecaseRemoteModel.getClass();

				Method method = clazz.getMethod("setUrl", String.class);

				method.invoke(_urlUsecaseRemoteModel, url);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getOrder() {
		return _order;
	}

	@Override
	public void setOrder(int order) {
		_order = order;

		if (_urlUsecaseRemoteModel != null) {
			try {
				Class<?> clazz = _urlUsecaseRemoteModel.getClass();

				Method method = clazz.getMethod("setOrder", int.class);

				method.invoke(_urlUsecaseRemoteModel, order);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getUrlUsecaseRemoteModel() {
		return _urlUsecaseRemoteModel;
	}

	public void setUrlUsecaseRemoteModel(BaseModel<?> urlUsecaseRemoteModel) {
		_urlUsecaseRemoteModel = urlUsecaseRemoteModel;
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

		Class<?> remoteModelClass = _urlUsecaseRemoteModel.getClass();

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

		Object returnValue = method.invoke(_urlUsecaseRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			UrlUsecaseLocalServiceUtil.addUrlUsecase(this);
		}
		else {
			UrlUsecaseLocalServiceUtil.updateUrlUsecase(this);
		}
	}

	@Override
	public UrlUsecase toEscapedModel() {
		return (UrlUsecase)ProxyUtil.newProxyInstance(UrlUsecase.class.getClassLoader(),
			new Class[] { UrlUsecase.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		UrlUsecaseClp clone = new UrlUsecaseClp();

		clone.setUrlUsecaseId(getUrlUsecaseId());
		clone.setUsecaseId(getUsecaseId());
		clone.setUrl(getUrl());
		clone.setOrder(getOrder());

		return clone;
	}

	@Override
	public int compareTo(UrlUsecase urlUsecase) {
		long primaryKey = urlUsecase.getPrimaryKey();

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

		if (!(obj instanceof UrlUsecaseClp)) {
			return false;
		}

		UrlUsecaseClp urlUsecase = (UrlUsecaseClp)obj;

		long primaryKey = urlUsecase.getPrimaryKey();

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

		sb.append("{urlUsecaseId=");
		sb.append(getUrlUsecaseId());
		sb.append(", usecaseId=");
		sb.append(getUsecaseId());
		sb.append(", url=");
		sb.append(getUrl());
		sb.append(", order=");
		sb.append(getOrder());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(16);

		sb.append("<model><model-name>");
		sb.append("com.excilys.liferay.gatling.model.UrlUsecase");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>urlUsecaseId</column-name><column-value><![CDATA[");
		sb.append(getUrlUsecaseId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>usecaseId</column-name><column-value><![CDATA[");
		sb.append(getUsecaseId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>url</column-name><column-value><![CDATA[");
		sb.append(getUrl());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>order</column-name><column-value><![CDATA[");
		sb.append(getOrder());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _urlUsecaseId;
	private long _usecaseId;
	private String _url;
	private int _order;
	private BaseModel<?> _urlUsecaseRemoteModel;
}