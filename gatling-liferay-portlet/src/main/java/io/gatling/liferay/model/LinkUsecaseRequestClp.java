package io.gatling.liferay.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import io.gatling.liferay.service.ClpSerializer;
import io.gatling.liferay.service.LinkUsecaseRequestLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;


public class LinkUsecaseRequestClp extends BaseModelImpl<LinkUsecaseRequest>
    implements LinkUsecaseRequest {
    private long _linkUsecaseRequestId;
    private long _request_id;
    private long _recordId;
    private double _weight;
    private boolean _sample;
    private BaseModel<?> _linkUsecaseRequestRemoteModel;
    private Class<?> _clpSerializerClass = io.gatling.liferay.service.ClpSerializer.class;

    public LinkUsecaseRequestClp() {
    }

    @Override
    public Class<?> getModelClass() {
        return LinkUsecaseRequest.class;
    }

    @Override
    public String getModelClassName() {
        return LinkUsecaseRequest.class.getName();
    }

    @Override
    public long getPrimaryKey() {
        return _linkUsecaseRequestId;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {
        setLinkUsecaseRequestId(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _linkUsecaseRequestId;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("linkUsecaseRequestId", getLinkUsecaseRequestId());
        attributes.put("request_id", getRequest_id());
        attributes.put("recordId", getRecordId());
        attributes.put("weight", getWeight());
        attributes.put("sample", getSample());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long linkUsecaseRequestId = (Long) attributes.get(
                "linkUsecaseRequestId");

        if (linkUsecaseRequestId != null) {
            setLinkUsecaseRequestId(linkUsecaseRequestId);
        }

        Long request_id = (Long) attributes.get("request_id");

        if (request_id != null) {
            setRequest_id(request_id);
        }

        Long recordId = (Long) attributes.get("recordId");

        if (recordId != null) {
            setRecordId(recordId);
        }

        Double weight = (Double) attributes.get("weight");

        if (weight != null) {
            setWeight(weight);
        }

        Boolean sample = (Boolean) attributes.get("sample");

        if (sample != null) {
            setSample(sample);
        }
    }

    @Override
    public long getLinkUsecaseRequestId() {
        return _linkUsecaseRequestId;
    }

    @Override
    public void setLinkUsecaseRequestId(long linkUsecaseRequestId) {
        _linkUsecaseRequestId = linkUsecaseRequestId;

        if (_linkUsecaseRequestRemoteModel != null) {
            try {
                Class<?> clazz = _linkUsecaseRequestRemoteModel.getClass();

                Method method = clazz.getMethod("setLinkUsecaseRequestId",
                        long.class);

                method.invoke(_linkUsecaseRequestRemoteModel,
                    linkUsecaseRequestId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getRequest_id() {
        return _request_id;
    }

    @Override
    public void setRequest_id(long request_id) {
        _request_id = request_id;

        if (_linkUsecaseRequestRemoteModel != null) {
            try {
                Class<?> clazz = _linkUsecaseRequestRemoteModel.getClass();

                Method method = clazz.getMethod("setRequest_id", long.class);

                method.invoke(_linkUsecaseRequestRemoteModel, request_id);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getRecordId() {
        return _recordId;
    }

    @Override
    public void setRecordId(long recordId) {
        _recordId = recordId;

        if (_linkUsecaseRequestRemoteModel != null) {
            try {
                Class<?> clazz = _linkUsecaseRequestRemoteModel.getClass();

                Method method = clazz.getMethod("setRecordId", long.class);

                method.invoke(_linkUsecaseRequestRemoteModel, recordId);
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

        if (_linkUsecaseRequestRemoteModel != null) {
            try {
                Class<?> clazz = _linkUsecaseRequestRemoteModel.getClass();

                Method method = clazz.getMethod("setWeight", double.class);

                method.invoke(_linkUsecaseRequestRemoteModel, weight);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public boolean getSample() {
        return _sample;
    }

    @Override
    public boolean isSample() {
        return _sample;
    }

    @Override
    public void setSample(boolean sample) {
        _sample = sample;

        if (_linkUsecaseRequestRemoteModel != null) {
            try {
                Class<?> clazz = _linkUsecaseRequestRemoteModel.getClass();

                Method method = clazz.getMethod("setSample", boolean.class);

                method.invoke(_linkUsecaseRequestRemoteModel, sample);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getLinkUsecaseRequestRemoteModel() {
        return _linkUsecaseRequestRemoteModel;
    }

    public void setLinkUsecaseRequestRemoteModel(
        BaseModel<?> linkUsecaseRequestRemoteModel) {
        _linkUsecaseRequestRemoteModel = linkUsecaseRequestRemoteModel;
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

        Class<?> remoteModelClass = _linkUsecaseRequestRemoteModel.getClass();

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

        Object returnValue = method.invoke(_linkUsecaseRequestRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            LinkUsecaseRequestLocalServiceUtil.addLinkUsecaseRequest(this);
        } else {
            LinkUsecaseRequestLocalServiceUtil.updateLinkUsecaseRequest(this);
        }
    }

    @Override
    public LinkUsecaseRequest toEscapedModel() {
        return (LinkUsecaseRequest) ProxyUtil.newProxyInstance(LinkUsecaseRequest.class.getClassLoader(),
            new Class[] { LinkUsecaseRequest.class },
            new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        LinkUsecaseRequestClp clone = new LinkUsecaseRequestClp();

        clone.setLinkUsecaseRequestId(getLinkUsecaseRequestId());
        clone.setRequest_id(getRequest_id());
        clone.setRecordId(getRecordId());
        clone.setWeight(getWeight());
        clone.setSample(getSample());

        return clone;
    }

    @Override
    public int compareTo(LinkUsecaseRequest linkUsecaseRequest) {
        long primaryKey = linkUsecaseRequest.getPrimaryKey();

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

        if (!(obj instanceof LinkUsecaseRequestClp)) {
            return false;
        }

        LinkUsecaseRequestClp linkUsecaseRequest = (LinkUsecaseRequestClp) obj;

        long primaryKey = linkUsecaseRequest.getPrimaryKey();

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

        sb.append("{linkUsecaseRequestId=");
        sb.append(getLinkUsecaseRequestId());
        sb.append(", request_id=");
        sb.append(getRequest_id());
        sb.append(", recordId=");
        sb.append(getRecordId());
        sb.append(", weight=");
        sb.append(getWeight());
        sb.append(", sample=");
        sb.append(getSample());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(19);

        sb.append("<model><model-name>");
        sb.append("io.gatling.liferay.model.LinkUsecaseRequest");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>linkUsecaseRequestId</column-name><column-value><![CDATA[");
        sb.append(getLinkUsecaseRequestId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>request_id</column-name><column-value><![CDATA[");
        sb.append(getRequest_id());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>recordId</column-name><column-value><![CDATA[");
        sb.append(getRecordId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>weight</column-name><column-value><![CDATA[");
        sb.append(getWeight());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>sample</column-name><column-value><![CDATA[");
        sb.append(getSample());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
