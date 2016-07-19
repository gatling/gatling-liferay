package com.excilys.liferay.gatling.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link FormParam}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FormParam
 * @generated
 */
public class FormParamWrapper implements FormParam, ModelWrapper<FormParam> {
    private FormParam _formParam;

    public FormParamWrapper(FormParam formParam) {
        _formParam = formParam;
    }

    @Override
    public Class<?> getModelClass() {
        return FormParam.class;
    }

    @Override
    public String getModelClassName() {
        return FormParam.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("formParamId", getFormParamId());
        attributes.put("urlRecordId", getUrlRecordId());
        attributes.put("key", getKey());
        attributes.put("value", getValue());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long formParamId = (Long) attributes.get("formParamId");

        if (formParamId != null) {
            setFormParamId(formParamId);
        }

        Long urlRecordId = (Long) attributes.get("urlRecordId");

        if (urlRecordId != null) {
            setUrlRecordId(urlRecordId);
        }

        String key = (String) attributes.get("key");

        if (key != null) {
            setKey(key);
        }

        String value = (String) attributes.get("value");

        if (value != null) {
            setValue(value);
        }
    }

    /**
    * Returns the primary key of this form param.
    *
    * @return the primary key of this form param
    */
    @Override
    public long getPrimaryKey() {
        return _formParam.getPrimaryKey();
    }

    /**
    * Sets the primary key of this form param.
    *
    * @param primaryKey the primary key of this form param
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _formParam.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the form param ID of this form param.
    *
    * @return the form param ID of this form param
    */
    @Override
    public long getFormParamId() {
        return _formParam.getFormParamId();
    }

    /**
    * Sets the form param ID of this form param.
    *
    * @param formParamId the form param ID of this form param
    */
    @Override
    public void setFormParamId(long formParamId) {
        _formParam.setFormParamId(formParamId);
    }

    /**
    * Returns the url record ID of this form param.
    *
    * @return the url record ID of this form param
    */
    @Override
    public long getUrlRecordId() {
        return _formParam.getUrlRecordId();
    }

    /**
    * Sets the url record ID of this form param.
    *
    * @param urlRecordId the url record ID of this form param
    */
    @Override
    public void setUrlRecordId(long urlRecordId) {
        _formParam.setUrlRecordId(urlRecordId);
    }

    /**
    * Returns the key of this form param.
    *
    * @return the key of this form param
    */
    @Override
    public java.lang.String getKey() {
        return _formParam.getKey();
    }

    /**
    * Sets the key of this form param.
    *
    * @param key the key of this form param
    */
    @Override
    public void setKey(java.lang.String key) {
        _formParam.setKey(key);
    }

    /**
    * Returns the value of this form param.
    *
    * @return the value of this form param
    */
    @Override
    public java.lang.String getValue() {
        return _formParam.getValue();
    }

    /**
    * Sets the value of this form param.
    *
    * @param value the value of this form param
    */
    @Override
    public void setValue(java.lang.String value) {
        _formParam.setValue(value);
    }

    @Override
    public boolean isNew() {
        return _formParam.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _formParam.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _formParam.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _formParam.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _formParam.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _formParam.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _formParam.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _formParam.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _formParam.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _formParam.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _formParam.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new FormParamWrapper((FormParam) _formParam.clone());
    }

    @Override
    public int compareTo(com.excilys.liferay.gatling.model.FormParam formParam) {
        return _formParam.compareTo(formParam);
    }

    @Override
    public int hashCode() {
        return _formParam.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<com.excilys.liferay.gatling.model.FormParam> toCacheModel() {
        return _formParam.toCacheModel();
    }

    @Override
    public com.excilys.liferay.gatling.model.FormParam toEscapedModel() {
        return new FormParamWrapper(_formParam.toEscapedModel());
    }

    @Override
    public com.excilys.liferay.gatling.model.FormParam toUnescapedModel() {
        return new FormParamWrapper(_formParam.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _formParam.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _formParam.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _formParam.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof FormParamWrapper)) {
            return false;
        }

        FormParamWrapper formParamWrapper = (FormParamWrapper) obj;

        if (Validator.equals(_formParam, formParamWrapper._formParam)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public FormParam getWrappedFormParam() {
        return _formParam;
    }

    @Override
    public FormParam getWrappedModel() {
        return _formParam;
    }

    @Override
    public void resetOriginalValues() {
        _formParam.resetOriginalValues();
    }
}
