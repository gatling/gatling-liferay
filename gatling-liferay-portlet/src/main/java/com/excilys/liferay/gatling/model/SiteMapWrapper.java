package com.excilys.liferay.gatling.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link SiteMap}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SiteMap
 * @generated
 */
public class SiteMapWrapper implements SiteMap, ModelWrapper<SiteMap> {
    private SiteMap _siteMap;

    public SiteMapWrapper(SiteMap siteMap) {
        _siteMap = siteMap;
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

    /**
    * Returns the primary key of this site map.
    *
    * @return the primary key of this site map
    */
    @Override
    public long getPrimaryKey() {
        return _siteMap.getPrimaryKey();
    }

    /**
    * Sets the primary key of this site map.
    *
    * @param primaryKey the primary key of this site map
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _siteMap.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the site map ID of this site map.
    *
    * @return the site map ID of this site map
    */
    @Override
    public long getSiteMapId() {
        return _siteMap.getSiteMapId();
    }

    /**
    * Sets the site map ID of this site map.
    *
    * @param siteMapId the site map ID of this site map
    */
    @Override
    public void setSiteMapId(long siteMapId) {
        _siteMap.setSiteMapId(siteMapId);
    }

    /**
    * Returns the name of this site map.
    *
    * @return the name of this site map
    */
    @Override
    public java.lang.String getName() {
        return _siteMap.getName();
    }

    /**
    * Sets the name of this site map.
    *
    * @param name the name of this site map
    */
    @Override
    public void setName(java.lang.String name) {
        _siteMap.setName(name);
    }

    @Override
    public boolean isNew() {
        return _siteMap.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _siteMap.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _siteMap.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _siteMap.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _siteMap.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _siteMap.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _siteMap.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _siteMap.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _siteMap.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _siteMap.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _siteMap.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new SiteMapWrapper((SiteMap) _siteMap.clone());
    }

    @Override
    public int compareTo(com.excilys.liferay.gatling.model.SiteMap siteMap) {
        return _siteMap.compareTo(siteMap);
    }

    @Override
    public int hashCode() {
        return _siteMap.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<com.excilys.liferay.gatling.model.SiteMap> toCacheModel() {
        return _siteMap.toCacheModel();
    }

    @Override
    public com.excilys.liferay.gatling.model.SiteMap toEscapedModel() {
        return new SiteMapWrapper(_siteMap.toEscapedModel());
    }

    @Override
    public com.excilys.liferay.gatling.model.SiteMap toUnescapedModel() {
        return new SiteMapWrapper(_siteMap.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _siteMap.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _siteMap.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _siteMap.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof SiteMapWrapper)) {
            return false;
        }

        SiteMapWrapper siteMapWrapper = (SiteMapWrapper) obj;

        if (Validator.equals(_siteMap, siteMapWrapper._siteMap)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public SiteMap getWrappedSiteMap() {
        return _siteMap;
    }

    @Override
    public SiteMap getWrappedModel() {
        return _siteMap;
    }

    @Override
    public void resetOriginalValues() {
        _siteMap.resetOriginalValues();
    }
}
