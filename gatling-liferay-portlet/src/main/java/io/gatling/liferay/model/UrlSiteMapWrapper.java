package io.gatling.liferay.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link UrlSiteMap}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UrlSiteMap
 * @generated
 */
public class UrlSiteMapWrapper implements UrlSiteMap, ModelWrapper<UrlSiteMap> {
    private UrlSiteMap _urlSiteMap;

    public UrlSiteMapWrapper(UrlSiteMap urlSiteMap) {
        _urlSiteMap = urlSiteMap;
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
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("urlSiteMapId", getUrlSiteMapId());
        attributes.put("siteMapId", getSiteMapId());
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

    /**
    * Returns the primary key of this url site map.
    *
    * @return the primary key of this url site map
    */
    @Override
    public long getPrimaryKey() {
        return _urlSiteMap.getPrimaryKey();
    }

    /**
    * Sets the primary key of this url site map.
    *
    * @param primaryKey the primary key of this url site map
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _urlSiteMap.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the url site map ID of this url site map.
    *
    * @return the url site map ID of this url site map
    */
    @Override
    public long getUrlSiteMapId() {
        return _urlSiteMap.getUrlSiteMapId();
    }

    /**
    * Sets the url site map ID of this url site map.
    *
    * @param urlSiteMapId the url site map ID of this url site map
    */
    @Override
    public void setUrlSiteMapId(long urlSiteMapId) {
        _urlSiteMap.setUrlSiteMapId(urlSiteMapId);
    }

    /**
    * Returns the site map ID of this url site map.
    *
    * @return the site map ID of this url site map
    */
    @Override
    public long getSiteMapId() {
        return _urlSiteMap.getSiteMapId();
    }

    /**
    * Sets the site map ID of this url site map.
    *
    * @param siteMapId the site map ID of this url site map
    */
    @Override
    public void setSiteMapId(long siteMapId) {
        _urlSiteMap.setSiteMapId(siteMapId);
    }

    /**
    * Returns the friendly url of this url site map.
    *
    * @return the friendly url of this url site map
    */
    @Override
    public java.lang.String getFriendlyUrl() {
        return _urlSiteMap.getFriendlyUrl();
    }

    /**
    * Sets the friendly url of this url site map.
    *
    * @param friendlyUrl the friendly url of this url site map
    */
    @Override
    public void setFriendlyUrl(java.lang.String friendlyUrl) {
        _urlSiteMap.setFriendlyUrl(friendlyUrl);
    }

    /**
    * Returns the url of this url site map.
    *
    * @return the url of this url site map
    */
    @Override
    public java.lang.String getUrl() {
        return _urlSiteMap.getUrl();
    }

    /**
    * Sets the url of this url site map.
    *
    * @param url the url of this url site map
    */
    @Override
    public void setUrl(java.lang.String url) {
        _urlSiteMap.setUrl(url);
    }

    /**
    * Returns the weight of this url site map.
    *
    * @return the weight of this url site map
    */
    @Override
    public int getWeight() {
        return _urlSiteMap.getWeight();
    }

    /**
    * Sets the weight of this url site map.
    *
    * @param weight the weight of this url site map
    */
    @Override
    public void setWeight(int weight) {
        _urlSiteMap.setWeight(weight);
    }

    @Override
    public boolean isNew() {
        return _urlSiteMap.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _urlSiteMap.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _urlSiteMap.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _urlSiteMap.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _urlSiteMap.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _urlSiteMap.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _urlSiteMap.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _urlSiteMap.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _urlSiteMap.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _urlSiteMap.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _urlSiteMap.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new UrlSiteMapWrapper((UrlSiteMap) _urlSiteMap.clone());
    }

    @Override
    public int compareTo(io.gatling.liferay.model.UrlSiteMap urlSiteMap) {
        return _urlSiteMap.compareTo(urlSiteMap);
    }

    @Override
    public int hashCode() {
        return _urlSiteMap.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<io.gatling.liferay.model.UrlSiteMap> toCacheModel() {
        return _urlSiteMap.toCacheModel();
    }

    @Override
    public io.gatling.liferay.model.UrlSiteMap toEscapedModel() {
        return new UrlSiteMapWrapper(_urlSiteMap.toEscapedModel());
    }

    @Override
    public io.gatling.liferay.model.UrlSiteMap toUnescapedModel() {
        return new UrlSiteMapWrapper(_urlSiteMap.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _urlSiteMap.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _urlSiteMap.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _urlSiteMap.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof UrlSiteMapWrapper)) {
            return false;
        }

        UrlSiteMapWrapper urlSiteMapWrapper = (UrlSiteMapWrapper) obj;

        if (Validator.equals(_urlSiteMap, urlSiteMapWrapper._urlSiteMap)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public UrlSiteMap getWrappedUrlSiteMap() {
        return _urlSiteMap;
    }

    @Override
    public UrlSiteMap getWrappedModel() {
        return _urlSiteMap;
    }

    @Override
    public void resetOriginalValues() {
        _urlSiteMap.resetOriginalValues();
    }
}
