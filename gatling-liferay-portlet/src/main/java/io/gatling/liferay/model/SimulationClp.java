package io.gatling.liferay.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import io.gatling.liferay.service.ClpSerializer;
import io.gatling.liferay.service.SimulationLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;


public class SimulationClp extends BaseModelImpl<Simulation>
    implements Simulation {
    private long _simulation_id;
    private String _name;
    private String _feederContent;
    private boolean _isFeederAFile;
    private BaseModel<?> _simulationRemoteModel;
    private Class<?> _clpSerializerClass = io.gatling.liferay.service.ClpSerializer.class;

    public SimulationClp() {
    }

    @Override
    public Class<?> getModelClass() {
        return Simulation.class;
    }

    @Override
    public String getModelClassName() {
        return Simulation.class.getName();
    }

    @Override
    public long getPrimaryKey() {
        return _simulation_id;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {
        setSimulation_id(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _simulation_id;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("simulation_id", getSimulation_id());
        attributes.put("name", getName());
        attributes.put("feederContent", getFeederContent());
        attributes.put("isFeederAFile", getIsFeederAFile());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long simulation_id = (Long) attributes.get("simulation_id");

        if (simulation_id != null) {
            setSimulation_id(simulation_id);
        }

        String name = (String) attributes.get("name");

        if (name != null) {
            setName(name);
        }

        String feederContent = (String) attributes.get("feederContent");

        if (feederContent != null) {
            setFeederContent(feederContent);
        }

        Boolean isFeederAFile = (Boolean) attributes.get("isFeederAFile");

        if (isFeederAFile != null) {
            setIsFeederAFile(isFeederAFile);
        }
    }

    @Override
    public long getSimulation_id() {
        return _simulation_id;
    }

    @Override
    public void setSimulation_id(long simulation_id) {
        _simulation_id = simulation_id;

        if (_simulationRemoteModel != null) {
            try {
                Class<?> clazz = _simulationRemoteModel.getClass();

                Method method = clazz.getMethod("setSimulation_id", long.class);

                method.invoke(_simulationRemoteModel, simulation_id);
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

        if (_simulationRemoteModel != null) {
            try {
                Class<?> clazz = _simulationRemoteModel.getClass();

                Method method = clazz.getMethod("setName", String.class);

                method.invoke(_simulationRemoteModel, name);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getFeederContent() {
        return _feederContent;
    }

    @Override
    public void setFeederContent(String feederContent) {
        _feederContent = feederContent;

        if (_simulationRemoteModel != null) {
            try {
                Class<?> clazz = _simulationRemoteModel.getClass();

                Method method = clazz.getMethod("setFeederContent", String.class);

                method.invoke(_simulationRemoteModel, feederContent);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public boolean getIsFeederAFile() {
        return _isFeederAFile;
    }

    @Override
    public boolean isIsFeederAFile() {
        return _isFeederAFile;
    }

    @Override
    public void setIsFeederAFile(boolean isFeederAFile) {
        _isFeederAFile = isFeederAFile;

        if (_simulationRemoteModel != null) {
            try {
                Class<?> clazz = _simulationRemoteModel.getClass();

                Method method = clazz.getMethod("setIsFeederAFile",
                        boolean.class);

                method.invoke(_simulationRemoteModel, isFeederAFile);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public boolean isComplete() {
        try {
            String methodName = "isComplete";

            Class<?>[] parameterTypes = new Class<?>[] {  };

            Object[] parameterValues = new Object[] {  };

            Boolean returnObj = (Boolean) invokeOnRemoteModel(methodName,
                    parameterTypes, parameterValues);

            return returnObj;
        } catch (Exception e) {
            throw new UnsupportedOperationException(e);
        }
    }

    public BaseModel<?> getSimulationRemoteModel() {
        return _simulationRemoteModel;
    }

    public void setSimulationRemoteModel(BaseModel<?> simulationRemoteModel) {
        _simulationRemoteModel = simulationRemoteModel;
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

        Class<?> remoteModelClass = _simulationRemoteModel.getClass();

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

        Object returnValue = method.invoke(_simulationRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            SimulationLocalServiceUtil.addSimulation(this);
        } else {
            SimulationLocalServiceUtil.updateSimulation(this);
        }
    }

    @Override
    public Simulation toEscapedModel() {
        return (Simulation) ProxyUtil.newProxyInstance(Simulation.class.getClassLoader(),
            new Class[] { Simulation.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        SimulationClp clone = new SimulationClp();

        clone.setSimulation_id(getSimulation_id());
        clone.setName(getName());
        clone.setFeederContent(getFeederContent());
        clone.setIsFeederAFile(getIsFeederAFile());

        return clone;
    }

    @Override
    public int compareTo(Simulation simulation) {
        long primaryKey = simulation.getPrimaryKey();

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

        if (!(obj instanceof SimulationClp)) {
            return false;
        }

        SimulationClp simulation = (SimulationClp) obj;

        long primaryKey = simulation.getPrimaryKey();

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

        sb.append("{simulation_id=");
        sb.append(getSimulation_id());
        sb.append(", name=");
        sb.append(getName());
        sb.append(", feederContent=");
        sb.append(getFeederContent());
        sb.append(", isFeederAFile=");
        sb.append(getIsFeederAFile());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(16);

        sb.append("<model><model-name>");
        sb.append("io.gatling.liferay.model.Simulation");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>simulation_id</column-name><column-value><![CDATA[");
        sb.append(getSimulation_id());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>name</column-name><column-value><![CDATA[");
        sb.append(getName());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>feederContent</column-name><column-value><![CDATA[");
        sb.append(getFeederContent());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>isFeederAFile</column-name><column-value><![CDATA[");
        sb.append(getIsFeederAFile());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
