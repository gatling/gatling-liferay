package com.excilys.liferay.gatling.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ProcessScenarioLinkLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ProcessScenarioLinkLocalService
 * @generated
 */
public class ProcessScenarioLinkLocalServiceWrapper
    implements ProcessScenarioLinkLocalService,
        ServiceWrapper<ProcessScenarioLinkLocalService> {
    private ProcessScenarioLinkLocalService _processScenarioLinkLocalService;

    public ProcessScenarioLinkLocalServiceWrapper(
        ProcessScenarioLinkLocalService processScenarioLinkLocalService) {
        _processScenarioLinkLocalService = processScenarioLinkLocalService;
    }

    /**
    * Adds the process scenario link to the database. Also notifies the appropriate model listeners.
    *
    * @param processScenarioLink the process scenario link
    * @return the process scenario link that was added
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.excilys.liferay.gatling.model.ProcessScenarioLink addProcessScenarioLink(
        com.excilys.liferay.gatling.model.ProcessScenarioLink processScenarioLink)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _processScenarioLinkLocalService.addProcessScenarioLink(processScenarioLink);
    }

    /**
    * Creates a new process scenario link with the primary key. Does not add the process scenario link to the database.
    *
    * @param psl_id the primary key for the new process scenario link
    * @return the new process scenario link
    */
    @Override
    public com.excilys.liferay.gatling.model.ProcessScenarioLink createProcessScenarioLink(
        long psl_id) {
        return _processScenarioLinkLocalService.createProcessScenarioLink(psl_id);
    }

    /**
    * Deletes the process scenario link with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param psl_id the primary key of the process scenario link
    * @return the process scenario link that was removed
    * @throws PortalException if a process scenario link with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.excilys.liferay.gatling.model.ProcessScenarioLink deleteProcessScenarioLink(
        long psl_id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _processScenarioLinkLocalService.deleteProcessScenarioLink(psl_id);
    }

    /**
    * Deletes the process scenario link from the database. Also notifies the appropriate model listeners.
    *
    * @param processScenarioLink the process scenario link
    * @return the process scenario link that was removed
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.excilys.liferay.gatling.model.ProcessScenarioLink deleteProcessScenarioLink(
        com.excilys.liferay.gatling.model.ProcessScenarioLink processScenarioLink)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _processScenarioLinkLocalService.deleteProcessScenarioLink(processScenarioLink);
    }

    @Override
    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _processScenarioLinkLocalService.dynamicQuery();
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
        return _processScenarioLinkLocalService.dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.excilys.liferay.gatling.model.impl.ProcessScenarioLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _processScenarioLinkLocalService.dynamicQuery(dynamicQuery,
            start, end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.excilys.liferay.gatling.model.impl.ProcessScenarioLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _processScenarioLinkLocalService.dynamicQuery(dynamicQuery,
            start, end, orderByComparator);
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
        return _processScenarioLinkLocalService.dynamicQueryCount(dynamicQuery);
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
        return _processScenarioLinkLocalService.dynamicQueryCount(dynamicQuery,
            projection);
    }

    @Override
    public com.excilys.liferay.gatling.model.ProcessScenarioLink fetchProcessScenarioLink(
        long psl_id) throws com.liferay.portal.kernel.exception.SystemException {
        return _processScenarioLinkLocalService.fetchProcessScenarioLink(psl_id);
    }

    /**
    * Returns the process scenario link with the primary key.
    *
    * @param psl_id the primary key of the process scenario link
    * @return the process scenario link
    * @throws PortalException if a process scenario link with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.excilys.liferay.gatling.model.ProcessScenarioLink getProcessScenarioLink(
        long psl_id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _processScenarioLinkLocalService.getProcessScenarioLink(psl_id);
    }

    @Override
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _processScenarioLinkLocalService.getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the process scenario links.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.excilys.liferay.gatling.model.impl.ProcessScenarioLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of process scenario links
    * @param end the upper bound of the range of process scenario links (not inclusive)
    * @return the range of process scenario links
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.util.List<com.excilys.liferay.gatling.model.ProcessScenarioLink> getProcessScenarioLinks(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _processScenarioLinkLocalService.getProcessScenarioLinks(start,
            end);
    }

    /**
    * Returns the number of process scenario links.
    *
    * @return the number of process scenario links
    * @throws SystemException if a system exception occurred
    */
    @Override
    public int getProcessScenarioLinksCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _processScenarioLinkLocalService.getProcessScenarioLinksCount();
    }

    /**
    * Updates the process scenario link in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param processScenarioLink the process scenario link
    * @return the process scenario link that was updated
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.excilys.liferay.gatling.model.ProcessScenarioLink updateProcessScenarioLink(
        com.excilys.liferay.gatling.model.ProcessScenarioLink processScenarioLink)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _processScenarioLinkLocalService.updateProcessScenarioLink(processScenarioLink);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _processScenarioLinkLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _processScenarioLinkLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _processScenarioLinkLocalService.invokeMethod(name,
            parameterTypes, arguments);
    }

    @Override
    public com.excilys.liferay.gatling.model.ProcessScenarioLink createLink(
        long scenarioId, long processId, int order, int pause)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _processScenarioLinkLocalService.createLink(scenarioId,
            processId, order, pause);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public ProcessScenarioLinkLocalService getWrappedProcessScenarioLinkLocalService() {
        return _processScenarioLinkLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedProcessScenarioLinkLocalService(
        ProcessScenarioLinkLocalService processScenarioLinkLocalService) {
        _processScenarioLinkLocalService = processScenarioLinkLocalService;
    }

    @Override
    public ProcessScenarioLinkLocalService getWrappedService() {
        return _processScenarioLinkLocalService;
    }

    @Override
    public void setWrappedService(
        ProcessScenarioLinkLocalService processScenarioLinkLocalService) {
        _processScenarioLinkLocalService = processScenarioLinkLocalService;
    }
}
