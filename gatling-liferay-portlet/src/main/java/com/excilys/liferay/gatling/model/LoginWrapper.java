package com.excilys.liferay.gatling.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Login}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Login
 * @generated
 */
public class LoginWrapper implements Login, ModelWrapper<Login> {
    private Login _login;

    public LoginWrapper(Login login) {
        _login = login;
    }

    @Override
    public Class<?> getModelClass() {
        return Login.class;
    }

    @Override
    public String getModelClassName() {
        return Login.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("userId", getUserId());
        attributes.put("name", getName());
        attributes.put("data", getData());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long userId = (Long) attributes.get("userId");

        if (userId != null) {
            setUserId(userId);
        }

        String name = (String) attributes.get("name");

        if (name != null) {
            setName(name);
        }

        String data = (String) attributes.get("data");

        if (data != null) {
            setData(data);
        }
    }

    /**
    * Returns the primary key of this login.
    *
    * @return the primary key of this login
    */
    @Override
    public long getPrimaryKey() {
        return _login.getPrimaryKey();
    }

    /**
    * Sets the primary key of this login.
    *
    * @param primaryKey the primary key of this login
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _login.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the user ID of this login.
    *
    * @return the user ID of this login
    */
    @Override
    public long getUserId() {
        return _login.getUserId();
    }

    /**
    * Sets the user ID of this login.
    *
    * @param userId the user ID of this login
    */
    @Override
    public void setUserId(long userId) {
        _login.setUserId(userId);
    }

    /**
    * Returns the user uuid of this login.
    *
    * @return the user uuid of this login
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.lang.String getUserUuid()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _login.getUserUuid();
    }

    /**
    * Sets the user uuid of this login.
    *
    * @param userUuid the user uuid of this login
    */
    @Override
    public void setUserUuid(java.lang.String userUuid) {
        _login.setUserUuid(userUuid);
    }

    /**
    * Returns the name of this login.
    *
    * @return the name of this login
    */
    @Override
    public java.lang.String getName() {
        return _login.getName();
    }

    /**
    * Sets the name of this login.
    *
    * @param name the name of this login
    */
    @Override
    public void setName(java.lang.String name) {
        _login.setName(name);
    }

    /**
    * Returns the data of this login.
    *
    * @return the data of this login
    */
    @Override
    public java.lang.String getData() {
        return _login.getData();
    }

    /**
    * Sets the data of this login.
    *
    * @param data the data of this login
    */
    @Override
    public void setData(java.lang.String data) {
        _login.setData(data);
    }

    @Override
    public boolean isNew() {
        return _login.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _login.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _login.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _login.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _login.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _login.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _login.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _login.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _login.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _login.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _login.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new LoginWrapper((Login) _login.clone());
    }

    @Override
    public int compareTo(com.excilys.liferay.gatling.model.Login login) {
        return _login.compareTo(login);
    }

    @Override
    public int hashCode() {
        return _login.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<com.excilys.liferay.gatling.model.Login> toCacheModel() {
        return _login.toCacheModel();
    }

    @Override
    public com.excilys.liferay.gatling.model.Login toEscapedModel() {
        return new LoginWrapper(_login.toEscapedModel());
    }

    @Override
    public com.excilys.liferay.gatling.model.Login toUnescapedModel() {
        return new LoginWrapper(_login.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _login.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _login.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _login.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof LoginWrapper)) {
            return false;
        }

        LoginWrapper loginWrapper = (LoginWrapper) obj;

        if (Validator.equals(_login, loginWrapper._login)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public Login getWrappedLogin() {
        return _login;
    }

    @Override
    public Login getWrappedModel() {
        return _login;
    }

    @Override
    public void resetOriginalValues() {
        _login.resetOriginalValues();
    }
}
