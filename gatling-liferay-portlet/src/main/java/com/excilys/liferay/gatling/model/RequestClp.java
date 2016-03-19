package com.excilys.liferay.gatling.model;

import com.excilys.liferay.gatling.service.ClpSerializer;
import com.excilys.liferay.gatling.service.RequestLocalServiceUtil;

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


public class RequestClp extends BaseModelImpl<Request> implements Request {
    private long _request_id;
    private long _scenario_id;
    private double _weight;
    private boolean _privatePage;
    private long _parentPlId;
    private long _layoutId;
    private long _plId;
    private boolean _portlet;
    private String _portletId;
    private BaseModel<?> _requestRemoteModel;
    private Class<?> _clpSerializerClass = com.excilys.liferay.gatling.service.ClpSerializer.class;

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
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("request_id", getRequest_id());
        attributes.put("scenario_id", getScenario_id());
        attributes.put("weight", getWeight());
        attributes.put("privatePage", getPrivatePage());
        attributes.put("parentPlId", getParentPlId());
        attributes.put("layoutId", getLayoutId());
        attributes.put("plId", getPlId());
        attributes.put("portlet", getPortlet());
        attributes.put("portletId", getPortletId());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long request_id = (Long) attributes.get("request_id");

        if (request_id != null) {
            setRequest_id(request_id);
        }

        Long scenario_id = (Long) attributes.get("scenario_id");

        if (scenario_id != null) {
            setScenario_id(scenario_id);
        }

        Double weight = (Double) attributes.get("weight");

        if (weight != null) {
            setWeight(weight);
        }

        Boolean privatePage = (Boolean) attributes.get("privatePage");

        if (privatePage != null) {
            setPrivatePage(privatePage);
        }

        Long parentPlId = (Long) attributes.get("parentPlId");

        if (parentPlId != null) {
            setParentPlId(parentPlId);
        }

        Long layoutId = (Long) attributes.get("layoutId");

        if (layoutId != null) {
            setLayoutId(layoutId);
        }

        Long plId = (Long) attributes.get("plId");

        if (plId != null) {
            setPlId(plId);
        }

        Boolean portlet = (Boolean) attributes.get("portlet");

        if (portlet != null) {
            setPortlet(portlet);
        }

        String portletId = (String) attributes.get("portletId");

        if (portletId != null) {
            setPortletId(portletId);
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
            } catch (Exception e) {
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
            } catch (Exception e) {
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

        if (_requestRemoteModel != null) {
            try {
                Class<?> clazz = _requestRemoteModel.getClass();

                Method method = clazz.getMethod("setWeight", double.class);

                method.invoke(_requestRemoteModel, weight);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public boolean getPrivatePage() {
        return _privatePage;
    }

    @Override
    public boolean isPrivatePage() {
        return _privatePage;
    }

    @Override
    public void setPrivatePage(boolean privatePage) {
        _privatePage = privatePage;

        if (_requestRemoteModel != null) {
            try {
                Class<?> clazz = _requestRemoteModel.getClass();

                Method method = clazz.getMethod("setPrivatePage", boolean.class);

                method.invoke(_requestRemoteModel, privatePage);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getParentPlId() {
        return _parentPlId;
    }

    @Override
    public void setParentPlId(long parentPlId) {
        _parentPlId = parentPlId;

        if (_requestRemoteModel != null) {
            try {
                Class<?> clazz = _requestRemoteModel.getClass();

                Method method = clazz.getMethod("setParentPlId", long.class);

                method.invoke(_requestRemoteModel, parentPlId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getLayoutId() {
        return _layoutId;
    }

    @Override
    public void setLayoutId(long layoutId) {
        _layoutId = layoutId;

        if (_requestRemoteModel != null) {
            try {
                Class<?> clazz = _requestRemoteModel.getClass();

                Method method = clazz.getMethod("setLayoutId", long.class);

                method.invoke(_requestRemoteModel, layoutId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getPlId() {
        return _plId;
    }

    @Override
    public void setPlId(long plId) {
        _plId = plId;

        if (_requestRemoteModel != null) {
            try {
                Class<?> clazz = _requestRemoteModel.getClass();

                Method method = clazz.getMethod("setPlId", long.class);

                method.invoke(_requestRemoteModel, plId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public boolean getPortlet() {
        return _portlet;
    }

    @Override
    public boolean isPortlet() {
        return _portlet;
    }

    @Override
    public void setPortlet(boolean portlet) {
        _portlet = portlet;

        if (_requestRemoteModel != null) {
            try {
                Class<?> clazz = _requestRemoteModel.getClass();

                Method method = clazz.getMethod("setPortlet", boolean.class);

                method.invoke(_requestRemoteModel, portlet);
            } catch (Exception e) {
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

        if (_requestRemoteModel != null) {
            try {
                Class<?> clazz = _requestRemoteModel.getClass();

                Method method = clazz.getMethod("setPortletId", String.class);

                method.invoke(_requestRemoteModel, portletId);
            } catch (Exception e) {
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
            } else {
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
        } else {
            RequestLocalServiceUtil.updateRequest(this);
        }
    }

    @Override
    public Request toEscapedModel() {
        return (Request) ProxyUtil.newProxyInstance(Request.class.getClassLoader(),
            new Class[] { Request.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        RequestClp clone = new RequestClp();

        clone.setRequest_id(getRequest_id());
        clone.setScenario_id(getScenario_id());
        clone.setWeight(getWeight());
        clone.setPrivatePage(getPrivatePage());
        clone.setParentPlId(getParentPlId());
        clone.setLayoutId(getLayoutId());
        clone.setPlId(getPlId());
        clone.setPortlet(getPortlet());
        clone.setPortletId(getPortletId());

        return clone;
    }

    @Override
    public int compareTo(Request request) {
        long primaryKey = request.getPrimaryKey();

        if (getPrimaryKey() < primaryKey) {
            return -1;
        } else if (getPrimaryKey() > primaryKey) {
            return 1;
        } else {
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

        RequestClp request = (RequestClp) obj;

        long primaryKey = request.getPrimaryKey();

        if (getPrimaryKey() == primaryKey) {
            return true;
        } else {
            return false;
        }
    }

    public Class<?> getClpSerializerClass() {
        return _clpSerializerClass;
    }

    @Override
    public int hashCode() {
        return (int) getPrimaryKey();
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(19);

        sb.append("{request_id=");
        sb.append(getRequest_id());
        sb.append(", scenario_id=");
        sb.append(getScenario_id());
        sb.append(", weight=");
        sb.append(getWeight());
        sb.append(", privatePage=");
        sb.append(getPrivatePage());
        sb.append(", parentPlId=");
        sb.append(getParentPlId());
        sb.append(", layoutId=");
        sb.append(getLayoutId());
        sb.append(", plId=");
        sb.append(getPlId());
        sb.append(", portlet=");
        sb.append(getPortlet());
        sb.append(", portletId=");
        sb.append(getPortletId());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(31);

        sb.append("<model><model-name>");
        sb.append("com.excilys.liferay.gatling.model.Request");
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
            "<column><column-name>weight</column-name><column-value><![CDATA[");
        sb.append(getWeight());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>privatePage</column-name><column-value><![CDATA[");
        sb.append(getPrivatePage());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>parentPlId</column-name><column-value><![CDATA[");
        sb.append(getParentPlId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>layoutId</column-name><column-value><![CDATA[");
        sb.append(getLayoutId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>plId</column-name><column-value><![CDATA[");
        sb.append(getPlId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>portlet</column-name><column-value><![CDATA[");
        sb.append(getPortlet());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>portletId</column-name><column-value><![CDATA[");
        sb.append(getPortletId());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
