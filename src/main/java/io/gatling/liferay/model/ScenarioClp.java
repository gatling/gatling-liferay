/**
 * Copyright 2011-2016 GatlingCorp (http://gatling.io)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * 		http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.gatling.liferay.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import io.gatling.liferay.service.ClpSerializer;
import io.gatling.liferay.service.ScenarioLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;


public class ScenarioClp extends BaseModelImpl<Scenario> implements Scenario {
    private long _scenario_id;
    private String _name;
    private String _url_site;
    private long _group_id;
    private long _simulation_id;
    private long _numberOfUsers;
    private long _duration;
    private String _injection;
    private BaseModel<?> _scenarioRemoteModel;
    private Class<?> _clpSerializerClass = io.gatling.liferay.service.ClpSerializer.class;

    public ScenarioClp() {
    }

    @Override
    public Class<?> getModelClass() {
        return Scenario.class;
    }

    @Override
    public String getModelClassName() {
        return Scenario.class.getName();
    }

    @Override
    public long getPrimaryKey() {
        return _scenario_id;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {
        setScenario_id(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _scenario_id;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("scenario_id", getScenario_id());
        attributes.put("name", getName());
        attributes.put("url_site", getUrl_site());
        attributes.put("group_id", getGroup_id());
        attributes.put("simulation_id", getSimulation_id());
        attributes.put("numberOfUsers", getNumberOfUsers());
        attributes.put("duration", getDuration());
        attributes.put("injection", getInjection());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long scenario_id = (Long) attributes.get("scenario_id");

        if (scenario_id != null) {
            setScenario_id(scenario_id);
        }

        String name = (String) attributes.get("name");

        if (name != null) {
            setName(name);
        }

        String url_site = (String) attributes.get("url_site");

        if (url_site != null) {
            setUrl_site(url_site);
        }

        Long group_id = (Long) attributes.get("group_id");

        if (group_id != null) {
            setGroup_id(group_id);
        }

        Long simulation_id = (Long) attributes.get("simulation_id");

        if (simulation_id != null) {
            setSimulation_id(simulation_id);
        }

        Long numberOfUsers = (Long) attributes.get("numberOfUsers");

        if (numberOfUsers != null) {
            setNumberOfUsers(numberOfUsers);
        }

        Long duration = (Long) attributes.get("duration");

        if (duration != null) {
            setDuration(duration);
        }

        String injection = (String) attributes.get("injection");

        if (injection != null) {
            setInjection(injection);
        }
    }

    @Override
    public long getScenario_id() {
        return _scenario_id;
    }

    @Override
    public void setScenario_id(long scenario_id) {
        _scenario_id = scenario_id;

        if (_scenarioRemoteModel != null) {
            try {
                Class<?> clazz = _scenarioRemoteModel.getClass();

                Method method = clazz.getMethod("setScenario_id", long.class);

                method.invoke(_scenarioRemoteModel, scenario_id);
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

        if (_scenarioRemoteModel != null) {
            try {
                Class<?> clazz = _scenarioRemoteModel.getClass();

                Method method = clazz.getMethod("setName", String.class);

                method.invoke(_scenarioRemoteModel, name);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getUrl_site() {
        return _url_site;
    }

    @Override
    public void setUrl_site(String url_site) {
        _url_site = url_site;

        if (_scenarioRemoteModel != null) {
            try {
                Class<?> clazz = _scenarioRemoteModel.getClass();

                Method method = clazz.getMethod("setUrl_site", String.class);

                method.invoke(_scenarioRemoteModel, url_site);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getGroup_id() {
        return _group_id;
    }

    @Override
    public void setGroup_id(long group_id) {
        _group_id = group_id;

        if (_scenarioRemoteModel != null) {
            try {
                Class<?> clazz = _scenarioRemoteModel.getClass();

                Method method = clazz.getMethod("setGroup_id", long.class);

                method.invoke(_scenarioRemoteModel, group_id);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getSimulation_id() {
        return _simulation_id;
    }

    @Override
    public void setSimulation_id(long simulation_id) {
        _simulation_id = simulation_id;

        if (_scenarioRemoteModel != null) {
            try {
                Class<?> clazz = _scenarioRemoteModel.getClass();

                Method method = clazz.getMethod("setSimulation_id", long.class);

                method.invoke(_scenarioRemoteModel, simulation_id);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getNumberOfUsers() {
        return _numberOfUsers;
    }

    @Override
    public void setNumberOfUsers(long numberOfUsers) {
        _numberOfUsers = numberOfUsers;

        if (_scenarioRemoteModel != null) {
            try {
                Class<?> clazz = _scenarioRemoteModel.getClass();

                Method method = clazz.getMethod("setNumberOfUsers", long.class);

                method.invoke(_scenarioRemoteModel, numberOfUsers);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getDuration() {
        return _duration;
    }

    @Override
    public void setDuration(long duration) {
        _duration = duration;

        if (_scenarioRemoteModel != null) {
            try {
                Class<?> clazz = _scenarioRemoteModel.getClass();

                Method method = clazz.getMethod("setDuration", long.class);

                method.invoke(_scenarioRemoteModel, duration);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getInjection() {
        return _injection;
    }

    @Override
    public void setInjection(String injection) {
        _injection = injection;

        if (_scenarioRemoteModel != null) {
            try {
                Class<?> clazz = _scenarioRemoteModel.getClass();

                Method method = clazz.getMethod("setInjection", String.class);

                method.invoke(_scenarioRemoteModel, injection);
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

    public BaseModel<?> getScenarioRemoteModel() {
        return _scenarioRemoteModel;
    }

    public void setScenarioRemoteModel(BaseModel<?> scenarioRemoteModel) {
        _scenarioRemoteModel = scenarioRemoteModel;
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

        Class<?> remoteModelClass = _scenarioRemoteModel.getClass();

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

        Object returnValue = method.invoke(_scenarioRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            ScenarioLocalServiceUtil.addScenario(this);
        } else {
            ScenarioLocalServiceUtil.updateScenario(this);
        }
    }

    @Override
    public Scenario toEscapedModel() {
        return (Scenario) ProxyUtil.newProxyInstance(Scenario.class.getClassLoader(),
            new Class[] { Scenario.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        ScenarioClp clone = new ScenarioClp();

        clone.setScenario_id(getScenario_id());
        clone.setName(getName());
        clone.setUrl_site(getUrl_site());
        clone.setGroup_id(getGroup_id());
        clone.setSimulation_id(getSimulation_id());
        clone.setNumberOfUsers(getNumberOfUsers());
        clone.setDuration(getDuration());
        clone.setInjection(getInjection());

        return clone;
    }

    @Override
    public int compareTo(Scenario scenario) {
        long primaryKey = scenario.getPrimaryKey();

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

        if (!(obj instanceof ScenarioClp)) {
            return false;
        }

        ScenarioClp scenario = (ScenarioClp) obj;

        long primaryKey = scenario.getPrimaryKey();

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
        StringBundler sb = new StringBundler(17);

        sb.append("{scenario_id=");
        sb.append(getScenario_id());
        sb.append(", name=");
        sb.append(getName());
        sb.append(", url_site=");
        sb.append(getUrl_site());
        sb.append(", group_id=");
        sb.append(getGroup_id());
        sb.append(", simulation_id=");
        sb.append(getSimulation_id());
        sb.append(", numberOfUsers=");
        sb.append(getNumberOfUsers());
        sb.append(", duration=");
        sb.append(getDuration());
        sb.append(", injection=");
        sb.append(getInjection());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(28);

        sb.append("<model><model-name>");
        sb.append("io.gatling.liferay.model.Scenario");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>scenario_id</column-name><column-value><![CDATA[");
        sb.append(getScenario_id());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>name</column-name><column-value><![CDATA[");
        sb.append(getName());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>url_site</column-name><column-value><![CDATA[");
        sb.append(getUrl_site());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>group_id</column-name><column-value><![CDATA[");
        sb.append(getGroup_id());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>simulation_id</column-name><column-value><![CDATA[");
        sb.append(getSimulation_id());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>numberOfUsers</column-name><column-value><![CDATA[");
        sb.append(getNumberOfUsers());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>duration</column-name><column-value><![CDATA[");
        sb.append(getDuration());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>injection</column-name><column-value><![CDATA[");
        sb.append(getInjection());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
