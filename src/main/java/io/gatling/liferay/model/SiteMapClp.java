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
import io.gatling.liferay.service.SiteMapLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;


public class SiteMapClp extends BaseModelImpl<SiteMap> implements SiteMap {
    private long _siteMapId;
    private String _name;
    private BaseModel<?> _siteMapRemoteModel;
    private Class<?> _clpSerializerClass = io.gatling.liferay.service.ClpSerializer.class;

    public SiteMapClp() {
    }

    @Override
    public Class<?> getModelClass() {
        return SiteMap.class;
    }

    @Override
    public String getModelClassName() {
        return SiteMap.class.getName();
    }

    @Override
    public long getPrimaryKey() {
        return _siteMapId;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {
        setSiteMapId(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _siteMapId;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("siteMapId", getSiteMapId());
        attributes.put("name", getName());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long siteMapId = (Long) attributes.get("siteMapId");

        if (siteMapId != null) {
            setSiteMapId(siteMapId);
        }

        String name = (String) attributes.get("name");

        if (name != null) {
            setName(name);
        }
    }

    @Override
    public long getSiteMapId() {
        return _siteMapId;
    }

    @Override
    public void setSiteMapId(long siteMapId) {
        _siteMapId = siteMapId;

        if (_siteMapRemoteModel != null) {
            try {
                Class<?> clazz = _siteMapRemoteModel.getClass();

                Method method = clazz.getMethod("setSiteMapId", long.class);

                method.invoke(_siteMapRemoteModel, siteMapId);
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

        if (_siteMapRemoteModel != null) {
            try {
                Class<?> clazz = _siteMapRemoteModel.getClass();

                Method method = clazz.getMethod("setName", String.class);

                method.invoke(_siteMapRemoteModel, name);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getSiteMapRemoteModel() {
        return _siteMapRemoteModel;
    }

    public void setSiteMapRemoteModel(BaseModel<?> siteMapRemoteModel) {
        _siteMapRemoteModel = siteMapRemoteModel;
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

        Class<?> remoteModelClass = _siteMapRemoteModel.getClass();

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

        Object returnValue = method.invoke(_siteMapRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            SiteMapLocalServiceUtil.addSiteMap(this);
        } else {
            SiteMapLocalServiceUtil.updateSiteMap(this);
        }
    }

    @Override
    public SiteMap toEscapedModel() {
        return (SiteMap) ProxyUtil.newProxyInstance(SiteMap.class.getClassLoader(),
            new Class[] { SiteMap.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        SiteMapClp clone = new SiteMapClp();

        clone.setSiteMapId(getSiteMapId());
        clone.setName(getName());

        return clone;
    }

    @Override
    public int compareTo(SiteMap siteMap) {
        long primaryKey = siteMap.getPrimaryKey();

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

        if (!(obj instanceof SiteMapClp)) {
            return false;
        }

        SiteMapClp siteMap = (SiteMapClp) obj;

        long primaryKey = siteMap.getPrimaryKey();

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
        StringBundler sb = new StringBundler(5);

        sb.append("{siteMapId=");
        sb.append(getSiteMapId());
        sb.append(", name=");
        sb.append(getName());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(10);

        sb.append("<model><model-name>");
        sb.append("io.gatling.liferay.model.SiteMap");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>siteMapId</column-name><column-value><![CDATA[");
        sb.append(getSiteMapId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>name</column-name><column-value><![CDATA[");
        sb.append(getName());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
