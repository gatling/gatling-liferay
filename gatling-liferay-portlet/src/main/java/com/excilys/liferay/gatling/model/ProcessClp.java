package com.excilys.liferay.gatling.model;

import com.excilys.liferay.gatling.service.ClpSerializer;
import com.excilys.liferay.gatling.service.ProcessLocalServiceUtil;

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


public class ProcessClp extends BaseModelImpl<Process> implements Process {
    private long _process_id;
    private String _name;
    private String _type;
    private Long _feederId;
    private BaseModel<?> _processRemoteModel;
    private Class<?> _clpSerializerClass = com.excilys.liferay.gatling.service.ClpSerializer.class;

    public ProcessClp() {
    }

    @Override
    public Class<?> getModelClass() {
        return Process.class;
    }

    @Override
    public String getModelClassName() {
        return Process.class.getName();
    }

    @Override
    public long getPrimaryKey() {
        return _process_id;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {
        setProcess_id(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _process_id;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("process_id", getProcess_id());
        attributes.put("name", getName());
        attributes.put("type", getType());
        attributes.put("feederId", getFeederId());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long process_id = (Long) attributes.get("process_id");

        if (process_id != null) {
            setProcess_id(process_id);
        }

        String name = (String) attributes.get("name");

        if (name != null) {
            setName(name);
        }

        String type = (String) attributes.get("type");

        if (type != null) {
            setType(type);
        }

        Long feederId = (Long) attributes.get("feederId");

        if (feederId != null) {
            setFeederId(feederId);
        }
    }

    @Override
    public long getProcess_id() {
        return _process_id;
    }

    @Override
    public void setProcess_id(long process_id) {
        _process_id = process_id;

        if (_processRemoteModel != null) {
            try {
                Class<?> clazz = _processRemoteModel.getClass();

                Method method = clazz.getMethod("setProcess_id", long.class);

                method.invoke(_processRemoteModel, process_id);
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

        if (_processRemoteModel != null) {
            try {
                Class<?> clazz = _processRemoteModel.getClass();

                Method method = clazz.getMethod("setName", String.class);

                method.invoke(_processRemoteModel, name);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getType() {
        return _type;
    }

    @Override
    public void setType(String type) {
        _type = type;

        if (_processRemoteModel != null) {
            try {
                Class<?> clazz = _processRemoteModel.getClass();

                Method method = clazz.getMethod("setType", String.class);

                method.invoke(_processRemoteModel, type);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Long getFeederId() {
        return _feederId;
    }

    @Override
    public void setFeederId(Long feederId) {
        _feederId = feederId;

        if (_processRemoteModel != null) {
            try {
                Class<?> clazz = _processRemoteModel.getClass();

                Method method = clazz.getMethod("setFeederId", Long.class);

                method.invoke(_processRemoteModel, feederId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getProcessRemoteModel() {
        return _processRemoteModel;
    }

    public void setProcessRemoteModel(BaseModel<?> processRemoteModel) {
        _processRemoteModel = processRemoteModel;
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

        Class<?> remoteModelClass = _processRemoteModel.getClass();

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

        Object returnValue = method.invoke(_processRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            ProcessLocalServiceUtil.addProcess(this);
        } else {
            ProcessLocalServiceUtil.updateProcess(this);
        }
    }

    @Override
    public Process toEscapedModel() {
        return (Process) ProxyUtil.newProxyInstance(Process.class.getClassLoader(),
            new Class[] { Process.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        ProcessClp clone = new ProcessClp();

        clone.setProcess_id(getProcess_id());
        clone.setName(getName());
        clone.setType(getType());
        clone.setFeederId(getFeederId());

        return clone;
    }

    @Override
    public int compareTo(Process process) {
        long primaryKey = process.getPrimaryKey();

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

        if (!(obj instanceof ProcessClp)) {
            return false;
        }

        ProcessClp process = (ProcessClp) obj;

        long primaryKey = process.getPrimaryKey();

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

        sb.append("{process_id=");
        sb.append(getProcess_id());
        sb.append(", name=");
        sb.append(getName());
        sb.append(", type=");
        sb.append(getType());
        sb.append(", feederId=");
        sb.append(getFeederId());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(16);

        sb.append("<model><model-name>");
        sb.append("com.excilys.liferay.gatling.model.Process");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>process_id</column-name><column-value><![CDATA[");
        sb.append(getProcess_id());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>name</column-name><column-value><![CDATA[");
        sb.append(getName());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>type</column-name><column-value><![CDATA[");
        sb.append(getType());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>feederId</column-name><column-value><![CDATA[");
        sb.append(getFeederId());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
