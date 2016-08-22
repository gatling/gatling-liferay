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
    private int _order;
    private int _pause;
    private long _scenario_id;
    private Long _recordId;
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
        attributes.put("order", getOrder());
        attributes.put("pause", getPause());
        attributes.put("scenario_id", getScenario_id());
        attributes.put("recordId", getRecordId());

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

        Integer order = (Integer) attributes.get("order");

        if (order != null) {
            setOrder(order);
        }

        Integer pause = (Integer) attributes.get("pause");

        if (pause != null) {
            setPause(pause);
        }

        Long scenario_id = (Long) attributes.get("scenario_id");

        if (scenario_id != null) {
            setScenario_id(scenario_id);
        }

        Long recordId = (Long) attributes.get("recordId");

        if (recordId != null) {
            setRecordId(recordId);
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
    public int getOrder() {
        return _order;
    }

    @Override
    public void setOrder(int order) {
        _order = order;

        if (_processRemoteModel != null) {
            try {
                Class<?> clazz = _processRemoteModel.getClass();

                Method method = clazz.getMethod("setOrder", int.class);

                method.invoke(_processRemoteModel, order);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public int getPause() {
        return _pause;
    }

    @Override
    public void setPause(int pause) {
        _pause = pause;

        if (_processRemoteModel != null) {
            try {
                Class<?> clazz = _processRemoteModel.getClass();

                Method method = clazz.getMethod("setPause", int.class);

                method.invoke(_processRemoteModel, pause);
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

        if (_processRemoteModel != null) {
            try {
                Class<?> clazz = _processRemoteModel.getClass();

                Method method = clazz.getMethod("setScenario_id", long.class);

                method.invoke(_processRemoteModel, scenario_id);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Long getRecordId() {
        return _recordId;
    }

    @Override
    public void setRecordId(Long recordId) {
        _recordId = recordId;

        if (_processRemoteModel != null) {
            try {
                Class<?> clazz = _processRemoteModel.getClass();

                Method method = clazz.getMethod("setRecordId", Long.class);

                method.invoke(_processRemoteModel, recordId);
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
        clone.setOrder(getOrder());
        clone.setPause(getPause());
        clone.setScenario_id(getScenario_id());
        clone.setRecordId(getRecordId());

        return clone;
    }

    @Override
    public int compareTo(Process process) {
        int value = 0;

        if (getOrder() < process.getOrder()) {
            value = -1;
        } else if (getOrder() > process.getOrder()) {
            value = 1;
        } else {
            value = 0;
        }

        if (value != 0) {
            return value;
        }

        return 0;
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
        StringBundler sb = new StringBundler(15);

        sb.append("{process_id=");
        sb.append(getProcess_id());
        sb.append(", name=");
        sb.append(getName());
        sb.append(", type=");
        sb.append(getType());
        sb.append(", order=");
        sb.append(getOrder());
        sb.append(", pause=");
        sb.append(getPause());
        sb.append(", scenario_id=");
        sb.append(getScenario_id());
        sb.append(", recordId=");
        sb.append(getRecordId());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(25);

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
            "<column><column-name>order</column-name><column-value><![CDATA[");
        sb.append(getOrder());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>pause</column-name><column-value><![CDATA[");
        sb.append(getPause());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>scenario_id</column-name><column-value><![CDATA[");
        sb.append(getScenario_id());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>recordId</column-name><column-value><![CDATA[");
        sb.append(getRecordId());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
