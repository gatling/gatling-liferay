package com.excilys.liferay.gatling.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link LinkProcessRecord}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LinkProcessRecord
 * @generated
 */
public class LinkProcessRecordWrapper implements LinkProcessRecord,
    ModelWrapper<LinkProcessRecord> {
    private LinkProcessRecord _linkProcessRecord;

    public LinkProcessRecordWrapper(LinkProcessRecord linkProcessRecord) {
        _linkProcessRecord = linkProcessRecord;
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

    /**
    * Returns the primary key of this link process record.
    *
    * @return the primary key of this link process record
    */
    @Override
    public long getPrimaryKey() {
        return _linkProcessRecord.getPrimaryKey();
    }

    /**
    * Sets the primary key of this link process record.
    *
    * @param primaryKey the primary key of this link process record
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _linkProcessRecord.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the link_process_record_id of this link process record.
    *
    * @return the link_process_record_id of this link process record
    */
    @Override
    public long getLink_process_record_id() {
        return _linkProcessRecord.getLink_process_record_id();
    }

    /**
    * Sets the link_process_record_id of this link process record.
    *
    * @param link_process_record_id the link_process_record_id of this link process record
    */
    @Override
    public void setLink_process_record_id(long link_process_record_id) {
        _linkProcessRecord.setLink_process_record_id(link_process_record_id);
    }

    /**
    * Returns the process_id of this link process record.
    *
    * @return the process_id of this link process record
    */
    @Override
    public long getProcess_id() {
        return _linkProcessRecord.getProcess_id();
    }

    /**
    * Sets the process_id of this link process record.
    *
    * @param process_id the process_id of this link process record
    */
    @Override
    public void setProcess_id(long process_id) {
        _linkProcessRecord.setProcess_id(process_id);
    }

    /**
    * Returns the record ID of this link process record.
    *
    * @return the record ID of this link process record
    */
    @Override
    public long getRecordId() {
        return _linkProcessRecord.getRecordId();
    }

    /**
    * Sets the record ID of this link process record.
    *
    * @param recordId the record ID of this link process record
    */
    @Override
    public void setRecordId(long recordId) {
        _linkProcessRecord.setRecordId(recordId);
    }

    @Override
    public boolean isNew() {
        return _linkProcessRecord.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _linkProcessRecord.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _linkProcessRecord.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _linkProcessRecord.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _linkProcessRecord.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _linkProcessRecord.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _linkProcessRecord.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _linkProcessRecord.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _linkProcessRecord.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _linkProcessRecord.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _linkProcessRecord.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new LinkProcessRecordWrapper((LinkProcessRecord) _linkProcessRecord.clone());
    }

    @Override
    public int compareTo(
        com.excilys.liferay.gatling.model.LinkProcessRecord linkProcessRecord) {
        return _linkProcessRecord.compareTo(linkProcessRecord);
    }

    @Override
    public int hashCode() {
        return _linkProcessRecord.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<com.excilys.liferay.gatling.model.LinkProcessRecord> toCacheModel() {
        return _linkProcessRecord.toCacheModel();
    }

    @Override
    public com.excilys.liferay.gatling.model.LinkProcessRecord toEscapedModel() {
        return new LinkProcessRecordWrapper(_linkProcessRecord.toEscapedModel());
    }

    @Override
    public com.excilys.liferay.gatling.model.LinkProcessRecord toUnescapedModel() {
        return new LinkProcessRecordWrapper(_linkProcessRecord.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _linkProcessRecord.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _linkProcessRecord.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _linkProcessRecord.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof LinkProcessRecordWrapper)) {
            return false;
        }

        LinkProcessRecordWrapper linkProcessRecordWrapper = (LinkProcessRecordWrapper) obj;

        if (Validator.equals(_linkProcessRecord,
                    linkProcessRecordWrapper._linkProcessRecord)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public LinkProcessRecord getWrappedLinkProcessRecord() {
        return _linkProcessRecord;
    }

    @Override
    public LinkProcessRecord getWrappedModel() {
        return _linkProcessRecord;
    }

    @Override
    public void resetOriginalValues() {
        _linkProcessRecord.resetOriginalValues();
    }
}
