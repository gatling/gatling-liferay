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
import com.liferay.sample.service.RequestLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sana
 */
public class RequestClp extends BaseModelImpl<Request> implements Request {
	public RequestClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Request.class;
	}

	@Override
	public String getModelClassName() {
		return Request.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _request_id;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setRequest_id(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _request_id;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("request_id", getRequest_id());
		attributes.put("scenario_id", getScenario_id());
		attributes.put("url", getUrl());
		attributes.put("rate", getRate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long request_id = (Long)attributes.get("request_id");

		if (request_id != null) {
			setRequest_id(request_id);
		}

		Long scenario_id = (Long)attributes.get("scenario_id");

		if (scenario_id != null) {
			setScenario_id(scenario_id);
		}

		String url = (String)attributes.get("url");

		if (url != null) {
			setUrl(url);
		}

		Integer rate = (Integer)attributes.get("rate");

		if (rate != null) {
			setRate(rate);
		}
	}

	@Override
	public long getRequest_id() {
		return _request_id;
	}

	@Override
	public void setRequest_id(long request_id) {
		_request_id = request_id;

		if (_requestRemoteModel != null) {
			try {
				Class<?> clazz = _requestRemoteModel.getClass();

				Method method = clazz.getMethod("setRequest_id", long.class);

				method.invoke(_requestRemoteModel, request_id);
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

		if (_requestRemoteModel != null) {
			try {
				Class<?> clazz = _requestRemoteModel.getClass();

				Method method = clazz.getMethod("setScenario_id", long.class);

				method.invoke(_requestRemoteModel, scenario_id);
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

		if (_requestRemoteModel != null) {
			try {
				Class<?> clazz = _requestRemoteModel.getClass();

				Method method = clazz.getMethod("setUrl", String.class);

				method.invoke(_requestRemoteModel, url);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getRate() {
		return _rate;
	}

	@Override
	public void setRate(int rate) {
		_rate = rate;

		if (_requestRemoteModel != null) {
			try {
				Class<?> clazz = _requestRemoteModel.getClass();

				Method method = clazz.getMethod("setRate", int.class);

				method.invoke(_requestRemoteModel, rate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getRequestRemoteModel() {
		return _requestRemoteModel;
	}

	public void setRequestRemoteModel(BaseModel<?> requestRemoteModel) {
		_requestRemoteModel = requestRemoteModel;
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

		Class<?> remoteModelClass = _requestRemoteModel.getClass();

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

		Object returnValue = method.invoke(_requestRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			RequestLocalServiceUtil.addRequest(this);
		}
		else {
			RequestLocalServiceUtil.updateRequest(this);
		}
	}

	@Override
	public Request toEscapedModel() {
		return (Request)ProxyUtil.newProxyInstance(Request.class.getClassLoader(),
			new Class[] { Request.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		RequestClp clone = new RequestClp();

		clone.setRequest_id(getRequest_id());
		clone.setScenario_id(getScenario_id());
		clone.setUrl(getUrl());
		clone.setRate(getRate());

		return clone;
	}

	@Override
	public int compareTo(Request request) {
		long primaryKey = request.getPrimaryKey();

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

		if (!(obj instanceof RequestClp)) {
			return false;
		}

		RequestClp request = (RequestClp)obj;

		long primaryKey = request.getPrimaryKey();

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

		sb.append("{request_id=");
		sb.append(getRequest_id());
		sb.append(", scenario_id=");
		sb.append(getScenario_id());
		sb.append(", url=");
		sb.append(getUrl());
		sb.append(", rate=");
		sb.append(getRate());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(16);

		sb.append("<model><model-name>");
		sb.append("com.liferay.sample.model.Request");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>request_id</column-name><column-value><![CDATA[");
		sb.append(getRequest_id());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>scenario_id</column-name><column-value><![CDATA[");
		sb.append(getScenario_id());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>url</column-name><column-value><![CDATA[");
		sb.append(getUrl());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>rate</column-name><column-value><![CDATA[");
		sb.append(getRate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _request_id;
	private long _scenario_id;
	private String _url;
	private int _rate;
	private BaseModel<?> _requestRemoteModel;
}