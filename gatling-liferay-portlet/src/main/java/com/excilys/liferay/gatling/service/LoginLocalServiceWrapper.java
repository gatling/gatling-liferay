package com.excilys.liferay.gatling.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link LoginLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see LoginLocalService
 * @generated
 */
public class LoginLocalServiceWrapper implements LoginLocalService,
    ServiceWrapper<LoginLocalService> {
    private LoginLocalService _loginLocalService;

    public LoginLocalServiceWrapper(LoginLocalService loginLocalService) {
        _loginLocalService = loginLocalService;
    }

    /**
    * Adds the login to the database. Also notifies the appropriate model listeners.
    *
    * @param login the login
    * @return the login that was added
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.excilys.liferay.gatling.model.Login addLogin(
        com.excilys.liferay.gatling.model.Login login)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _loginLocalService.addLogin(login);
    }

    /**
    * Creates a new login with the primary key. Does not add the login to the database.
    *
    * @param userId the primary key for the new login
    * @return the new login
    */
    @Override
    public com.excilys.liferay.gatling.model.Login createLogin(long userId) {
        return _loginLocalService.createLogin(userId);
    }

    /**
    * Deletes the login with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param userId the primary key of the login
    * @return the login that was removed
    * @throws PortalException if a login with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.excilys.liferay.gatling.model.Login deleteLogin(long userId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _loginLocalService.deleteLogin(userId);
    }

    /**
    * Deletes the login from the database. Also notifies the appropriate model listeners.
    *
    * @param login the login
    * @return the login that was removed
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.excilys.liferay.gatling.model.Login deleteLogin(
        com.excilys.liferay.gatling.model.Login login)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _loginLocalService.deleteLogin(login);
    }

    @Override
    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _loginLocalService.dynamicQuery();
    }

    /**
    * Performs a dynamic query on the database and returns the matching rows.
    *
    * @param dynamicQuery the dynamic query
    * @return the matching rows
    * @throws SystemException if a system exception occurred
    */
    @Override
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _loginLocalService.dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.excilys.liferay.gatling.model.impl.LoginModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @return the range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @Override
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return _loginLocalService.dynamicQuery(dynamicQuery, start, end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.excilys.liferay.gatling.model.impl.LoginModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @Override
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _loginLocalService.dynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    @Override
    public long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _loginLocalService.dynamicQueryCount(dynamicQuery);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @param projection the projection to apply to the query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    @Override
    public long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
        com.liferay.portal.kernel.dao.orm.Projection projection)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _loginLocalService.dynamicQueryCount(dynamicQuery, projection);
    }

    @Override
    public com.excilys.liferay.gatling.model.Login fetchLogin(long userId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _loginLocalService.fetchLogin(userId);
    }

    /**
    * Returns the login with the primary key.
    *
    * @param userId the primary key of the login
    * @return the login
    * @throws PortalException if a login with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.excilys.liferay.gatling.model.Login getLogin(long userId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _loginLocalService.getLogin(userId);
    }

    @Override
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _loginLocalService.getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the logins.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.excilys.liferay.gatling.model.impl.LoginModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of logins
    * @param end the upper bound of the range of logins (not inclusive)
    * @return the range of logins
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.util.List<com.excilys.liferay.gatling.model.Login> getLogins(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _loginLocalService.getLogins(start, end);
    }

    /**
    * Returns the number of logins.
    *
    * @return the number of logins
    * @throws SystemException if a system exception occurred
    */
    @Override
    public int getLoginsCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _loginLocalService.getLoginsCount();
    }

    /**
    * Updates the login in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param login the login
    * @return the login that was updated
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.excilys.liferay.gatling.model.Login updateLogin(
        com.excilys.liferay.gatling.model.Login login)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _loginLocalService.updateLogin(login);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _loginLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _loginLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _loginLocalService.invokeMethod(name, parameterTypes, arguments);
    }

    @Override
    public com.excilys.liferay.gatling.model.Login findByProcessId(
        long processId)
        throws com.excilys.liferay.gatling.NoSuchProcessException,
            com.liferay.portal.NoSuchModelException,
            com.liferay.portal.kernel.exception.SystemException {
        return _loginLocalService.findByProcessId(processId);
    }

    @Override
    public com.excilys.liferay.gatling.model.Login findByName(
        java.lang.String name)
        throws com.excilys.liferay.gatling.NoSuchLoginException,
            com.excilys.liferay.gatling.NoSuchRecordException,
            com.liferay.portal.kernel.exception.SystemException {
        return _loginLocalService.findByName(name);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public LoginLocalService getWrappedLoginLocalService() {
        return _loginLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedLoginLocalService(LoginLocalService loginLocalService) {
        _loginLocalService = loginLocalService;
    }

    @Override
    public LoginLocalService getWrappedService() {
        return _loginLocalService;
    }

    @Override
    public void setWrappedService(LoginLocalService loginLocalService) {
        _loginLocalService = loginLocalService;
    }
}
