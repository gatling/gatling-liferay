/**
 * Copyright 2011-2015 GatlingCorp (http://gatling.io)
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
import io.gatling.liferay.service.ProcessScenarioLinkLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;


public class ProcessScenarioLinkClp extends BaseModelImpl<ProcessScenarioLink>
    implements ProcessScenarioLink {
    private long _psl_id;
    private long _process_id;
    private long _scenario_id;
    private int _order;
    private int _pause;
    private BaseModel<?> _processScenarioLinkRemoteModel;
    private Class<?> _clpSerializerClass = io.gatling.liferay.service.ClpSerializer.class;

    public ProcessScenarioLinkClp() {
    }

    @Override
    public Class<?> getModelClass() {
        return ProcessScenarioLink.class;
    }

    @Override
    public String getModelClassName() {
        return ProcessScenarioLink.class.getName();
    }

    @Override
    public long getPrimaryKey() {
        return _psl_id;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {
        setPsl_id(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _psl_id;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("psl_id", getPsl_id());
        attributes.put("process_id", getProcess_id());
        attributes.put("scenario_id", getScenario_id());
        attributes.put("order", getOrder());
        attributes.put("pause", getPause());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long psl_id = (Long) attributes.get("psl_id");

        if (psl_id != null) {
            setPsl_id(psl_id);
        }

        Long process_id = (Long) attributes.get("process_id");

        if (process_id != null) {
            setProcess_id(process_id);
        }

        Long scenario_id = (Long) attributes.get("scenario_id");

        if (scenario_id != null) {
            setScenario_id(scenario_id);
        }

        Integer order = (Integer) attributes.get("order");

        if (order != null) {
            setOrder(order);
        }

        Integer pause = (Integer) attributes.get("pause");

        if (pause != null) {
            setPause(pause);
        }
    }

    @Override
    public long getPsl_id() {
        return _psl_id;
    }

    @Override
    public void setPsl_id(long psl_id) {
        _psl_id = psl_id;

        if (_processScenarioLinkRemoteModel != null) {
            try {
                Class<?> clazz = _processScenarioLinkRemoteModel.getClass();

                Method method = clazz.getMethod("setPsl_id", long.class);

                method.invoke(_processScenarioLinkRemoteModel, psl_id);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getProcess_id() {
        return _process_id;
    }

    @Override
    public void setProcess_id(long process_id) {
        _process_id = process_id;

        if (_processScenarioLinkRemoteModel != null) {
            try {
                Class<?> clazz = _processScenarioLinkRemoteModel.getClass();

                Method method = clazz.getMethod("setProcess_id", long.class);

                method.invoke(_processScenarioLinkRemoteModel, process_id);
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

        if (_processScenarioLinkRemoteModel != null) {
            try {
                Class<?> clazz = _processScenarioLinkRemoteModel.getClass();

                Method method = clazz.getMethod("setScenario_id", long.class);

                method.invoke(_processScenarioLinkRemoteModel, scenario_id);
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

        if (_processScenarioLinkRemoteModel != null) {
            try {
                Class<?> clazz = _processScenarioLinkRemoteModel.getClass();

                Method method = clazz.getMethod("setOrder", int.class);

                method.invoke(_processScenarioLinkRemoteModel, order);
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

        if (_processScenarioLinkRemoteModel != null) {
            try {
                Class<?> clazz = _processScenarioLinkRemoteModel.getClass();

                Method method = clazz.getMethod("setPause", int.class);

                method.invoke(_processScenarioLinkRemoteModel, pause);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getProcessScenarioLinkRemoteModel() {
        return _processScenarioLinkRemoteModel;
    }

    public void setProcessScenarioLinkRemoteModel(
        BaseModel<?> processScenarioLinkRemoteModel) {
        _processScenarioLinkRemoteModel = processScenarioLinkRemoteModel;
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

        Class<?> remoteModelClass = _processScenarioLinkRemoteModel.getClass();

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

        Object returnValue = method.invoke(_processScenarioLinkRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            ProcessScenarioLinkLocalServiceUtil.addProcessScenarioLink(this);
        } else {
            ProcessScenarioLinkLocalServiceUtil.updateProcessScenarioLink(this);
        }
    }

    @Override
    public ProcessScenarioLink toEscapedModel() {
        return (ProcessScenarioLink) ProxyUtil.newProxyInstance(ProcessScenarioLink.class.getClassLoader(),
            new Class[] { ProcessScenarioLink.class },
            new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        ProcessScenarioLinkClp clone = new ProcessScenarioLinkClp();

        clone.setPsl_id(getPsl_id());
        clone.setProcess_id(getProcess_id());
        clone.setScenario_id(getScenario_id());
        clone.setOrder(getOrder());
        clone.setPause(getPause());

        return clone;
    }

    @Override
    public int compareTo(ProcessScenarioLink processScenarioLink) {
        int value = 0;

        if (getOrder() < processScenarioLink.getOrder()) {
            value = -1;
        } else if (getOrder() > processScenarioLink.getOrder()) {
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

        if (!(obj instanceof ProcessScenarioLinkClp)) {
            return false;
        }

        ProcessScenarioLinkClp processScenarioLink = (ProcessScenarioLinkClp) obj;

        long primaryKey = processScenarioLink.getPrimaryKey();

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
        StringBundler sb = new StringBundler(11);

        sb.append("{psl_id=");
        sb.append(getPsl_id());
        sb.append(", process_id=");
        sb.append(getProcess_id());
        sb.append(", scenario_id=");
        sb.append(getScenario_id());
        sb.append(", order=");
        sb.append(getOrder());
        sb.append(", pause=");
        sb.append(getPause());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(19);

        sb.append("<model><model-name>");
        sb.append("io.gatling.liferay.model.ProcessScenarioLink");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>psl_id</column-name><column-value><![CDATA[");
        sb.append(getPsl_id());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>process_id</column-name><column-value><![CDATA[");
        sb.append(getProcess_id());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>scenario_id</column-name><column-value><![CDATA[");
        sb.append(getScenario_id());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>order</column-name><column-value><![CDATA[");
        sb.append(getOrder());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>pause</column-name><column-value><![CDATA[");
        sb.append(getPause());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
