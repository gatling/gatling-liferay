package com.excilys.liferay.gatling.model;

import com.excilys.liferay.gatling.service.ClpSerializer;
import com.excilys.liferay.gatling.service.RecordLocalServiceUtil;

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


public class RecordClp extends BaseModelImpl<Record> implements Record {
    private long _recordId;
    private String _portletId;
    private String _versionPortlet;
    private String _name;
    private BaseModel<?> _recordRemoteModel;
    private Class<?> _clpSerializerClass = com.excilys.liferay.gatling.service.ClpSerializer.class;

    public RecordClp() {
    }

    @Override
    public Class<?> getModelClass() {
        return Record.class;
    }

    @Override
    public String getModelClassName() {
        return Record.class.getName();
    }

    @Override
    public long getPrimaryKey() {
        return _recordId;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {
        setRecordId(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _recordId;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("recordId", getRecordId());
        attributes.put("portletId", getPortletId());
        attributes.put("versionPortlet", getVersionPortlet());
        attributes.put("name", getName());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long recordId = (Long) attributes.get("recordId");

        if (recordId != null) {
            setRecordId(recordId);
        }

        String portletId = (String) attributes.get("portletId");

        if (portletId != null) {
            setPortletId(portletId);
        }

        String versionPortlet = (String) attributes.get("versionPortlet");

        if (versionPortlet != null) {
            setVersionPortlet(versionPortlet);
        }

        String name = (String) attributes.get("name");

        if (name != null) {
            setName(name);
        }
    }

    @Override
    public long getRecordId() {
        return _recordId;
    }

    @Override
    public void setRecordId(long recordId) {
        _recordId = recordId;

        if (_recordRemoteModel != null) {
            try {
                Class<?> clazz = _recordRemoteModel.getClass();

                Method method = clazz.getMethod("setRecordId", long.class);

                method.invoke(_recordRemoteModel, recordId);
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

        if (_recordRemoteModel != null) {
            try {
                Class<?> clazz = _recordRemoteModel.getClass();

                Method method = clazz.getMethod("setPortletId", String.class);

                method.invoke(_recordRemoteModel, portletId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getVersionPortlet() {
        return _versionPortlet;
    }

    @Override
    public void setVersionPortlet(String versionPortlet) {
        _versionPortlet = versionPortlet;

        if (_recordRemoteModel != null) {
            try {
                Class<?> clazz = _recordRemoteModel.getClass();

                Method method = clazz.getMethod("setVersionPortlet",
                        String.class);

                method.invoke(_recordRemoteModel, versionPortlet);
            } catch (Exception e) {
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

        if (_recordRemoteModel != null) {
            try {
                Class<?> clazz = _recordRemoteModel.getClass();

                Method method = clazz.getMethod("setName", String.class);

                method.invoke(_recordRemoteModel, name);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getRecordRemoteModel() {
        return _recordRemoteModel;
    }

    public void setRecordRemoteModel(BaseModel<?> recordRemoteModel) {
        _recordRemoteModel = recordRemoteModel;
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

        Class<?> remoteModelClass = _recordRemoteModel.getClass();

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

        Object returnValue = method.invoke(_recordRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            RecordLocalServiceUtil.addRecord(this);
        } else {
            RecordLocalServiceUtil.updateRecord(this);
        }
    }

    @Override
    public Record toEscapedModel() {
        return (Record) ProxyUtil.newProxyInstance(Record.class.getClassLoader(),
            new Class[] { Record.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        RecordClp clone = new RecordClp();

        clone.setRecordId(getRecordId());
        clone.setPortletId(getPortletId());
        clone.setVersionPortlet(getVersionPortlet());
        clone.setName(getName());

        return clone;
    }

    @Override
    public int compareTo(Record record) {
        long primaryKey = record.getPrimaryKey();

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

        if (!(obj instanceof RecordClp)) {
            return false;
        }

        RecordClp record = (RecordClp) obj;

        long primaryKey = record.getPrimaryKey();

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
        StringBundler sb = new StringBundler(9);

        sb.append("{recordId=");
        sb.append(getRecordId());
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
        sb.append("com.excilys.liferay.gatling.model.Record");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>recordId</column-name><column-value><![CDATA[");
        sb.append(getRecordId());
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
}
