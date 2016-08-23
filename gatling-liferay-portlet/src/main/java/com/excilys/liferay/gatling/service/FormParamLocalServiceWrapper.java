package com.excilys.liferay.gatling.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link FormParamLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see FormParamLocalService
 * @generated
 */
public class FormParamLocalServiceWrapper implements FormParamLocalService,
    ServiceWrapper<FormParamLocalService> {
    private FormParamLocalService _formParamLocalService;

    public FormParamLocalServiceWrapper(
        FormParamLocalService formParamLocalService) {
        _formParamLocalService = formParamLocalService;
    }

    /**
    * Adds the form param to the database. Also notifies the appropriate model listeners.
    *
    * @param formParam the form param
    * @return the form param that was added
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.excilys.liferay.gatling.model.FormParam addFormParam(
        com.excilys.liferay.gatling.model.FormParam formParam)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _formParamLocalService.addFormParam(formParam);
    }

    /**
    * Creates a new form param with the primary key. Does not add the form param to the database.
    *
    * @param formParamId the primary key for the new form param
    * @return the new form param
    */
    @Override
    public com.excilys.liferay.gatling.model.FormParam createFormParam(
        long formParamId) {
        return _formParamLocalService.createFormParam(formParamId);
    }

    /**
    * Deletes the form param with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param formParamId the primary key of the form param
    * @return the form param that was removed
    * @throws PortalException if a form param with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.excilys.liferay.gatling.model.FormParam deleteFormParam(
        long formParamId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _formParamLocalService.deleteFormParam(formParamId);
    }

    /**
    * Deletes the form param from the database. Also notifies the appropriate model listeners.
    *
    * @param formParam the form param
    * @return the form param that was removed
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.excilys.liferay.gatling.model.FormParam deleteFormParam(
        com.excilys.liferay.gatling.model.FormParam formParam)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _formParamLocalService.deleteFormParam(formParam);
    }

    @Override
    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _formParamLocalService.dynamicQuery();
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
        return _formParamLocalService.dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.excilys.liferay.gatling.model.impl.FormParamModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _formParamLocalService.dynamicQuery(dynamicQuery, start, end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.excilys.liferay.gatling.model.impl.FormParamModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _formParamLocalService.dynamicQuery(dynamicQuery, start, end,
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
        return _formParamLocalService.dynamicQueryCount(dynamicQuery);
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
        return _formParamLocalService.dynamicQueryCount(dynamicQuery, projection);
    }

    @Override
    public com.excilys.liferay.gatling.model.FormParam fetchFormParam(
        long formParamId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _formParamLocalService.fetchFormParam(formParamId);
    }

    /**
    * Returns the form param with the primary key.
    *
    * @param formParamId the primary key of the form param
    * @return the form param
    * @throws PortalException if a form param with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.excilys.liferay.gatling.model.FormParam getFormParam(
        long formParamId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _formParamLocalService.getFormParam(formParamId);
    }

    @Override
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _formParamLocalService.getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the form params.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.excilys.liferay.gatling.model.impl.FormParamModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of form params
    * @param end the upper bound of the range of form params (not inclusive)
    * @return the range of form params
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.util.List<com.excilys.liferay.gatling.model.FormParam> getFormParams(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _formParamLocalService.getFormParams(start, end);
    }

    /**
    * Returns the number of form params.
    *
    * @return the number of form params
    * @throws SystemException if a system exception occurred
    */
    @Override
    public int getFormParamsCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _formParamLocalService.getFormParamsCount();
    }

    /**
    * Updates the form param in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param formParam the form param
    * @return the form param that was updated
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.excilys.liferay.gatling.model.FormParam updateFormParam(
        com.excilys.liferay.gatling.model.FormParam formParam)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _formParamLocalService.updateFormParam(formParam);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _formParamLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _formParamLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _formParamLocalService.invokeMethod(name, parameterTypes,
            arguments);
    }

    @Override
    public com.excilys.liferay.gatling.model.FormParam findByUrlRecordId(
        long urlRecordId)
        throws com.excilys.liferay.gatling.NoSuchFormParamException,
            com.liferay.portal.kernel.exception.SystemException {
        return _formParamLocalService.findByUrlRecordId(urlRecordId);
    }

    @Override
    public void save(long urlRecordId, java.lang.String data)
        throws com.liferay.portal.kernel.exception.SystemException {
        _formParamLocalService.save(urlRecordId, data);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public FormParamLocalService getWrappedFormParamLocalService() {
        return _formParamLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedFormParamLocalService(
        FormParamLocalService formParamLocalService) {
        _formParamLocalService = formParamLocalService;
    }

    @Override
    public FormParamLocalService getWrappedService() {
        return _formParamLocalService;
    }

    @Override
    public void setWrappedService(FormParamLocalService formParamLocalService) {
        _formParamLocalService = formParamLocalService;
    }
}
