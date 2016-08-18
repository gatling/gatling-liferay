package com.excilys.liferay.gatling.model;

import com.excilys.liferay.gatling.service.ClpSerializer;
import com.excilys.liferay.gatling.service.LinkProcessRecordLocalServiceUtil;

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


public class LinkProcessRecordClp extends BaseModelImpl<LinkProcessRecord>
    implements LinkProcessRecord {
    private long _link_process_record_id;
    private long _process_id;
    private long _recordId;
    private BaseModel<?> _linkProcessRecordRemoteModel;
    private Class<?> _clpSerializerClass = com.excilys.liferay.gatling.service.ClpSerializer.class;

    public LinkProcessRecordClp() {
    }

    @Override
    public Class<?> getModelClass() {
        return LinkProcessRecord.class;
    }

    @Override
    public String getModelClassName() {
        return LinkProcessRecord.class.getName();
    }

    @Override
    public long getPrimaryKey() {
        return _link_process_record_id;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {
        setLink_process_record_id(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _link_process_record_id;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("link_process_record_id", getLink_process_record_id());
        attributes.put("process_id", getProcess_id());
        attributes.put("recordId", getRecordId());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long link_process_record_id = (Long) attributes.get(
                "link_process_record_id");

        if (link_process_record_id != null) {
            setLink_process_record_id(link_process_record_id);
        }

        Long process_id = (Long) attributes.get("process_id");

        if (process_id != null) {
            setProcess_id(process_id);
        }

        Long recordId = (Long) attributes.get("recordId");

        if (recordId != null) {
            setRecordId(recordId);
        }
    }

    @Override
    public long getLink_process_record_id() {
        return _link_process_record_id;
    }

    @Override
    public void setLink_process_record_id(long link_process_record_id) {
        _link_process_record_id = link_process_record_id;

        if (_linkProcessRecordRemoteModel != null) {
            try {
                Class<?> clazz = _linkProcessRecordRemoteModel.getClass();

                Method method = clazz.getMethod("setLink_process_record_id",
                        long.class);

                method.invoke(_linkProcessRecordRemoteModel,
                    link_process_record_id);
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

        if (_linkProcessRecordRemoteModel != null) {
            try {
                Class<?> clazz = _linkProcessRecordRemoteModel.getClass();

                Method method = clazz.getMethod("setProcess_id", long.class);

                method.invoke(_linkProcessRecordRemoteModel, process_id);
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

        if (_linkProcessRecordRemoteModel != null) {
            try {
                Class<?> clazz = _linkProcessRecordRemoteModel.getClass();

                Method method = clazz.getMethod("setRecordId", long.class);

                method.invoke(_linkProcessRecordRemoteModel, recordId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getLinkProcessRecordRemoteModel() {
        return _linkProcessRecordRemoteModel;
    }

    public void setLinkProcessRecordRemoteModel(
        BaseModel<?> linkProcessRecordRemoteModel) {
        _linkProcessRecordRemoteModel = linkProcessRecordRemoteModel;
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

        Class<?> remoteModelClass = _linkProcessRecordRemoteModel.getClass();

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

        Object returnValue = method.invoke(_linkProcessRecordRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            LinkProcessRecordLocalServiceUtil.addLinkProcessRecord(this);
        } else {
            LinkProcessRecordLocalServiceUtil.updateLinkProcessRecord(this);
        }
    }

    @Override
    public LinkProcessRecord toEscapedModel() {
        return (LinkProcessRecord) ProxyUtil.newProxyInstance(LinkProcessRecord.class.getClassLoader(),
            new Class[] { LinkProcessRecord.class },
            new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        LinkProcessRecordClp clone = new LinkProcessRecordClp();

        clone.setLink_process_record_id(getLink_process_record_id());
        clone.setProcess_id(getProcess_id());
        clone.setRecordId(getRecordId());

        return clone;
    }

    @Override
    public int compareTo(LinkProcessRecord linkProcessRecord) {
        long primaryKey = linkProcessRecord.getPrimaryKey();

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

        if (!(obj instanceof LinkProcessRecordClp)) {
            return false;
        }

        LinkProcessRecordClp linkProcessRecord = (LinkProcessRecordClp) obj;

        long primaryKey = linkProcessRecord.getPrimaryKey();

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

        sb.append("{link_process_record_id=");
        sb.append(getLink_process_record_id());
        sb.append(", process_id=");
        sb.append(getProcess_id());
        sb.append(", recordId=");
        sb.append(getRecordId());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(13);

        sb.append("<model><model-name>");
        sb.append("com.excilys.liferay.gatling.model.LinkProcessRecord");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>link_process_record_id</column-name><column-value><![CDATA[");
        sb.append(getLink_process_record_id());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>process_id</column-name><column-value><![CDATA[");
        sb.append(getProcess_id());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>recordId</column-name><column-value><![CDATA[");
        sb.append(getRecordId());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
