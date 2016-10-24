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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link UrlRecord}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UrlRecord
 * @generated
 */
public class UrlRecordWrapper implements UrlRecord, ModelWrapper<UrlRecord> {
    private UrlRecord _urlRecord;

    public UrlRecordWrapper(UrlRecord urlRecord) {
        _urlRecord = urlRecord;
    }

    @Override
    public Class<?> getModelClass() {
        return UrlRecord.class;
    }

    @Override
    public String getModelClassName() {
        return UrlRecord.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("urlRecordId", getUrlRecordId());
        attributes.put("recordId", getRecordId());
        attributes.put("url", getUrl());
        attributes.put("type", getType());
        attributes.put("order", getOrder());
        attributes.put("pauseTime", getPauseTime());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long urlRecordId = (Long) attributes.get("urlRecordId");

        if (urlRecordId != null) {
            setUrlRecordId(urlRecordId);
        }

        Long recordId = (Long) attributes.get("recordId");

        if (recordId != null) {
            setRecordId(recordId);
        }

        String url = (String) attributes.get("url");

        if (url != null) {
            setUrl(url);
        }

        String type = (String) attributes.get("type");

        if (type != null) {
            setType(type);
        }

        Integer order = (Integer) attributes.get("order");

        if (order != null) {
            setOrder(order);
        }

        Integer pauseTime = (Integer) attributes.get("pauseTime");

        if (pauseTime != null) {
            setPauseTime(pauseTime);
        }
    }

    /**
    * Returns the primary key of this url record.
    *
    * @return the primary key of this url record
    */
    @Override
    public long getPrimaryKey() {
        return _urlRecord.getPrimaryKey();
    }

    /**
    * Sets the primary key of this url record.
    *
    * @param primaryKey the primary key of this url record
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _urlRecord.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the url record ID of this url record.
    *
    * @return the url record ID of this url record
    */
    @Override
    public long getUrlRecordId() {
        return _urlRecord.getUrlRecordId();
    }

    /**
    * Sets the url record ID of this url record.
    *
    * @param urlRecordId the url record ID of this url record
    */
    @Override
    public void setUrlRecordId(long urlRecordId) {
        _urlRecord.setUrlRecordId(urlRecordId);
    }

    /**
    * Returns the record ID of this url record.
    *
    * @return the record ID of this url record
    */
    @Override
    public long getRecordId() {
        return _urlRecord.getRecordId();
    }

    /**
    * Sets the record ID of this url record.
    *
    * @param recordId the record ID of this url record
    */
    @Override
    public void setRecordId(long recordId) {
        _urlRecord.setRecordId(recordId);
    }

    /**
    * Returns the url of this url record.
    *
    * @return the url of this url record
    */
    @Override
    public java.lang.String getUrl() {
        return _urlRecord.getUrl();
    }

    /**
    * Sets the url of this url record.
    *
    * @param url the url of this url record
    */
    @Override
    public void setUrl(java.lang.String url) {
        _urlRecord.setUrl(url);
    }

    /**
    * Returns the type of this url record.
    *
    * @return the type of this url record
    */
    @Override
    public java.lang.String getType() {
        return _urlRecord.getType();
    }

    /**
    * Sets the type of this url record.
    *
    * @param type the type of this url record
    */
    @Override
    public void setType(java.lang.String type) {
        _urlRecord.setType(type);
    }

    /**
    * Returns the order of this url record.
    *
    * @return the order of this url record
    */
    @Override
    public int getOrder() {
        return _urlRecord.getOrder();
    }

    /**
    * Sets the order of this url record.
    *
    * @param order the order of this url record
    */
    @Override
    public void setOrder(int order) {
        _urlRecord.setOrder(order);
    }

    /**
    * Returns the pause time of this url record.
    *
    * @return the pause time of this url record
    */
    @Override
    public int getPauseTime() {
        return _urlRecord.getPauseTime();
    }

    /**
    * Sets the pause time of this url record.
    *
    * @param pauseTime the pause time of this url record
    */
    @Override
    public void setPauseTime(int pauseTime) {
        _urlRecord.setPauseTime(pauseTime);
    }

    @Override
    public boolean isNew() {
        return _urlRecord.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _urlRecord.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _urlRecord.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _urlRecord.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _urlRecord.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _urlRecord.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _urlRecord.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _urlRecord.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _urlRecord.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _urlRecord.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _urlRecord.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new UrlRecordWrapper((UrlRecord) _urlRecord.clone());
    }

    @Override
    public int compareTo(io.gatling.liferay.model.UrlRecord urlRecord) {
        return _urlRecord.compareTo(urlRecord);
    }

    @Override
    public int hashCode() {
        return _urlRecord.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<io.gatling.liferay.model.UrlRecord> toCacheModel() {
        return _urlRecord.toCacheModel();
    }

    @Override
    public io.gatling.liferay.model.UrlRecord toEscapedModel() {
        return new UrlRecordWrapper(_urlRecord.toEscapedModel());
    }

    @Override
    public io.gatling.liferay.model.UrlRecord toUnescapedModel() {
        return new UrlRecordWrapper(_urlRecord.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _urlRecord.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _urlRecord.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _urlRecord.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof UrlRecordWrapper)) {
            return false;
        }

        UrlRecordWrapper urlRecordWrapper = (UrlRecordWrapper) obj;

        if (Validator.equals(_urlRecord, urlRecordWrapper._urlRecord)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public UrlRecord getWrappedUrlRecord() {
        return _urlRecord;
    }

    @Override
    public UrlRecord getWrappedModel() {
        return _urlRecord;
    }

    @Override
    public void resetOriginalValues() {
        _urlRecord.resetOriginalValues();
    }
}
