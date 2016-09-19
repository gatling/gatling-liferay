package io.gatling.liferay.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import io.gatling.liferay.service.ClpSerializer;
import io.gatling.liferay.service.FormParamLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;


public class FormParamClp extends BaseModelImpl<FormParam> implements FormParam {
    private long _formParamId;
    private long _urlRecordId;
    private String _data;
    private BaseModel<?> _formParamRemoteModel;
    private Class<?> _clpSerializerClass = io.gatling.liferay.service.ClpSerializer.class;

    public FormParamClp() {
    }

    @Override
    public Class<?> getModelClass() {
        return FormParam.class;
    }

    @Override
    public String getModelClassName() {
        return FormParam.class.getName();
    }

    @Override
    public long getPrimaryKey() {
        return _formParamId;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {
        setFormParamId(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _formParamId;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("formParamId", getFormParamId());
        attributes.put("urlRecordId", getUrlRecordId());
        attributes.put("data", getData());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long formParamId = (Long) attributes.get("formParamId");

        if (formParamId != null) {
            setFormParamId(formParamId);
        }

        Long urlRecordId = (Long) attributes.get("urlRecordId");

        if (urlRecordId != null) {
            setUrlRecordId(urlRecordId);
        }

        String data = (String) attributes.get("data");

        if (data != null) {
            setData(data);
        }
    }

    @Override
    public long getFormParamId() {
        return _formParamId;
    }

    @Override
    public void setFormParamId(long formParamId) {
        _formParamId = formParamId;

        if (_formParamRemoteModel != null) {
            try {
                Class<?> clazz = _formParamRemoteModel.getClass();

                Method method = clazz.getMethod("setFormParamId", long.class);

                method.invoke(_formParamRemoteModel, formParamId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getUrlRecordId() {
        return _urlRecordId;
    }

    @Override
    public void setUrlRecordId(long urlRecordId) {
        _urlRecordId = urlRecordId;

        if (_formParamRemoteModel != null) {
            try {
                Class<?> clazz = _formParamRemoteModel.getClass();

                Method method = clazz.getMethod("setUrlRecordId", long.class);

                method.invoke(_formParamRemoteModel, urlRecordId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getData() {
        return _data;
    }

    @Override
    public void setData(String data) {
        _data = data;

        if (_formParamRemoteModel != null) {
            try {
                Class<?> clazz = _formParamRemoteModel.getClass();

                Method method = clazz.getMethod("setData", String.class);

                method.invoke(_formParamRemoteModel, data);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getFormParamRemoteModel() {
        return _formParamRemoteModel;
    }

    public void setFormParamRemoteModel(BaseModel<?> formParamRemoteModel) {
        _formParamRemoteModel = formParamRemoteModel;
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

        Class<?> remoteModelClass = _formParamRemoteModel.getClass();

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

        Object returnValue = method.invoke(_formParamRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            FormParamLocalServiceUtil.addFormParam(this);
        } else {
            FormParamLocalServiceUtil.updateFormParam(this);
        }
    }

    @Override
    public FormParam toEscapedModel() {
        return (FormParam) ProxyUtil.newProxyInstance(FormParam.class.getClassLoader(),
            new Class[] { FormParam.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        FormParamClp clone = new FormParamClp();

        clone.setFormParamId(getFormParamId());
        clone.setUrlRecordId(getUrlRecordId());
        clone.setData(getData());

        return clone;
    }

    @Override
    public int compareTo(FormParam formParam) {
        long primaryKey = formParam.getPrimaryKey();

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

        if (!(obj instanceof FormParamClp)) {
            return false;
        }

        FormParamClp formParam = (FormParamClp) obj;

        long primaryKey = formParam.getPrimaryKey();

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
        StringBundler sb = new StringBundler(7);

        sb.append("{formParamId=");
        sb.append(getFormParamId());
        sb.append(", urlRecordId=");
        sb.append(getUrlRecordId());
        sb.append(", data=");
        sb.append(getData());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(13);

        sb.append("<model><model-name>");
        sb.append("io.gatling.liferay.model.FormParam");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>formParamId</column-name><column-value><![CDATA[");
        sb.append(getFormParamId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>urlRecordId</column-name><column-value><![CDATA[");
        sb.append(getUrlRecordId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>data</column-name><column-value><![CDATA[");
        sb.append(getData());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
