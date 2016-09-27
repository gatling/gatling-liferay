package io.gatling.liferay.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import io.gatling.liferay.service.ClpSerializer;
import io.gatling.liferay.service.UrlSiteMapLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;


public class UrlSiteMapClp extends BaseModelImpl<UrlSiteMap>
    implements UrlSiteMap {
    private long _urlSiteMapId;
    private long _siteMapId;
    private String _group;
    private String _friendlyUrl;
    private String _url;
    private int _weight;
    private BaseModel<?> _urlSiteMapRemoteModel;
    private Class<?> _clpSerializerClass = io.gatling.liferay.service.ClpSerializer.class;

    public UrlSiteMapClp() {
    }

    @Override
    public Class<?> getModelClass() {
        return UrlSiteMap.class;
    }

    @Override
    public String getModelClassName() {
        return UrlSiteMap.class.getName();
    }

    @Override
    public long getPrimaryKey() {
        return _urlSiteMapId;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {
        setUrlSiteMapId(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _urlSiteMapId;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("urlSiteMapId", getUrlSiteMapId());
        attributes.put("siteMapId", getSiteMapId());
        attributes.put("group", getGroup());
        attributes.put("friendlyUrl", getFriendlyUrl());
        attributes.put("url", getUrl());
        attributes.put("weight", getWeight());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long urlSiteMapId = (Long) attributes.get("urlSiteMapId");

        if (urlSiteMapId != null) {
            setUrlSiteMapId(urlSiteMapId);
        }

        Long siteMapId = (Long) attributes.get("siteMapId");

        if (siteMapId != null) {
            setSiteMapId(siteMapId);
        }

        String group = (String) attributes.get("group");

        if (group != null) {
            setGroup(group);
        }

        String friendlyUrl = (String) attributes.get("friendlyUrl");

        if (friendlyUrl != null) {
            setFriendlyUrl(friendlyUrl);
        }

        String url = (String) attributes.get("url");

        if (url != null) {
            setUrl(url);
        }

        Integer weight = (Integer) attributes.get("weight");

        if (weight != null) {
            setWeight(weight);
        }
    }

    @Override
    public long getUrlSiteMapId() {
        return _urlSiteMapId;
    }

    @Override
    public void setUrlSiteMapId(long urlSiteMapId) {
        _urlSiteMapId = urlSiteMapId;

        if (_urlSiteMapRemoteModel != null) {
            try {
                Class<?> clazz = _urlSiteMapRemoteModel.getClass();

                Method method = clazz.getMethod("setUrlSiteMapId", long.class);

                method.invoke(_urlSiteMapRemoteModel, urlSiteMapId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getSiteMapId() {
        return _siteMapId;
    }

    @Override
    public void setSiteMapId(long siteMapId) {
        _siteMapId = siteMapId;

        if (_urlSiteMapRemoteModel != null) {
            try {
                Class<?> clazz = _urlSiteMapRemoteModel.getClass();

                Method method = clazz.getMethod("setSiteMapId", long.class);

                method.invoke(_urlSiteMapRemoteModel, siteMapId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getGroup() {
        return _group;
    }

    @Override
    public void setGroup(String group) {
        _group = group;

        if (_urlSiteMapRemoteModel != null) {
            try {
                Class<?> clazz = _urlSiteMapRemoteModel.getClass();

                Method method = clazz.getMethod("setGroup", String.class);

                method.invoke(_urlSiteMapRemoteModel, group);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getFriendlyUrl() {
        return _friendlyUrl;
    }

    @Override
    public void setFriendlyUrl(String friendlyUrl) {
        _friendlyUrl = friendlyUrl;

        if (_urlSiteMapRemoteModel != null) {
            try {
                Class<?> clazz = _urlSiteMapRemoteModel.getClass();

                Method method = clazz.getMethod("setFriendlyUrl", String.class);

                method.invoke(_urlSiteMapRemoteModel, friendlyUrl);
            } catch (Exception e) {
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

        if (_urlSiteMapRemoteModel != null) {
            try {
                Class<?> clazz = _urlSiteMapRemoteModel.getClass();

                Method method = clazz.getMethod("setUrl", String.class);

                method.invoke(_urlSiteMapRemoteModel, url);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public int getWeight() {
        return _weight;
    }

    @Override
    public void setWeight(int weight) {
        _weight = weight;

        if (_urlSiteMapRemoteModel != null) {
            try {
                Class<?> clazz = _urlSiteMapRemoteModel.getClass();

                Method method = clazz.getMethod("setWeight", int.class);

                method.invoke(_urlSiteMapRemoteModel, weight);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getUrlSiteMapRemoteModel() {
        return _urlSiteMapRemoteModel;
    }

    public void setUrlSiteMapRemoteModel(BaseModel<?> urlSiteMapRemoteModel) {
        _urlSiteMapRemoteModel = urlSiteMapRemoteModel;
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

        Class<?> remoteModelClass = _urlSiteMapRemoteModel.getClass();

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

        Object returnValue = method.invoke(_urlSiteMapRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            UrlSiteMapLocalServiceUtil.addUrlSiteMap(this);
        } else {
            UrlSiteMapLocalServiceUtil.updateUrlSiteMap(this);
        }
    }

    @Override
    public UrlSiteMap toEscapedModel() {
        return (UrlSiteMap) ProxyUtil.newProxyInstance(UrlSiteMap.class.getClassLoader(),
            new Class[] { UrlSiteMap.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        UrlSiteMapClp clone = new UrlSiteMapClp();

        clone.setUrlSiteMapId(getUrlSiteMapId());
        clone.setSiteMapId(getSiteMapId());
        clone.setGroup(getGroup());
        clone.setFriendlyUrl(getFriendlyUrl());
        clone.setUrl(getUrl());
        clone.setWeight(getWeight());

        return clone;
    }

    @Override
    public int compareTo(UrlSiteMap urlSiteMap) {
        long primaryKey = urlSiteMap.getPrimaryKey();

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

        if (!(obj instanceof UrlSiteMapClp)) {
            return false;
        }

        UrlSiteMapClp urlSiteMap = (UrlSiteMapClp) obj;

        long primaryKey = urlSiteMap.getPrimaryKey();

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
        StringBundler sb = new StringBundler(13);

        sb.append("{urlSiteMapId=");
        sb.append(getUrlSiteMapId());
        sb.append(", siteMapId=");
        sb.append(getSiteMapId());
        sb.append(", group=");
        sb.append(getGroup());
        sb.append(", friendlyUrl=");
        sb.append(getFriendlyUrl());
        sb.append(", url=");
        sb.append(getUrl());
        sb.append(", weight=");
        sb.append(getWeight());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(22);

        sb.append("<model><model-name>");
        sb.append("io.gatling.liferay.model.UrlSiteMap");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>urlSiteMapId</column-name><column-value><![CDATA[");
        sb.append(getUrlSiteMapId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>siteMapId</column-name><column-value><![CDATA[");
        sb.append(getSiteMapId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>group</column-name><column-value><![CDATA[");
        sb.append(getGroup());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>friendlyUrl</column-name><column-value><![CDATA[");
        sb.append(getFriendlyUrl());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>url</column-name><column-value><![CDATA[");
        sb.append(getUrl());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>weight</column-name><column-value><![CDATA[");
        sb.append(getWeight());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
