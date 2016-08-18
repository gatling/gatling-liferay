package com.excilys.liferay.gatling.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ProcessLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ProcessLocalService
 * @generated
 */
public class ProcessLocalServiceWrapper implements ProcessLocalService,
    ServiceWrapper<ProcessLocalService> {
    private ProcessLocalService _processLocalService;

    public ProcessLocalServiceWrapper(ProcessLocalService processLocalService) {
        _processLocalService = processLocalService;
    }

    /**
    * Adds the process to the database. Also notifies the appropriate model listeners.
    *
    * @param process the process
    * @return the process that was added
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.excilys.liferay.gatling.model.Process addProcess(
        com.excilys.liferay.gatling.model.Process process)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _processLocalService.addProcess(process);
    }

    /**
    * Creates a new process with the primary key. Does not add the process to the database.
    *
    * @param process_id the primary key for the new process
    * @return the new process
    */
    @Override
    public com.excilys.liferay.gatling.model.Process createProcess(
        long process_id) {
        return _processLocalService.createProcess(process_id);
    }

    /**
    * Deletes the process with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param process_id the primary key of the process
    * @return the process that was removed
    * @throws PortalException if a process with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.excilys.liferay.gatling.model.Process deleteProcess(
        long process_id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _processLocalService.deleteProcess(process_id);
    }

    /**
    * Deletes the process from the database. Also notifies the appropriate model listeners.
    *
    * @param process the process
    * @return the process that was removed
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.excilys.liferay.gatling.model.Process deleteProcess(
        com.excilys.liferay.gatling.model.Process process)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _processLocalService.deleteProcess(process);
    }

    @Override
    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _processLocalService.dynamicQuery();
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
        return _processLocalService.dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.excilys.liferay.gatling.model.impl.ProcessModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _processLocalService.dynamicQuery(dynamicQuery, start, end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.excilys.liferay.gatling.model.impl.ProcessModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _processLocalService.dynamicQuery(dynamicQuery, start, end,
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
        return _processLocalService.dynamicQueryCount(dynamicQuery);
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
        return _processLocalService.dynamicQueryCount(dynamicQuery, projection);
    }

    @Override
    public com.excilys.liferay.gatling.model.Process fetchProcess(
        long process_id)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _processLocalService.fetchProcess(process_id);
    }

    /**
    * Returns the process with the primary key.
    *
    * @param process_id the primary key of the process
    * @return the process
    * @throws PortalException if a process with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.excilys.liferay.gatling.model.Process getProcess(long process_id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _processLocalService.getProcess(process_id);
    }

    @Override
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _processLocalService.getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the processes.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.excilys.liferay.gatling.model.impl.ProcessModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of processes
    * @param end the upper bound of the range of processes (not inclusive)
    * @return the range of processes
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.util.List<com.excilys.liferay.gatling.model.Process> getProcesses(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _processLocalService.getProcesses(start, end);
    }

    /**
    * Returns the number of processes.
    *
    * @return the number of processes
    * @throws SystemException if a system exception occurred
    */
    @Override
    public int getProcessesCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _processLocalService.getProcessesCount();
    }

    /**
    * Updates the process in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param process the process
    * @return the process that was updated
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.excilys.liferay.gatling.model.Process updateProcess(
        com.excilys.liferay.gatling.model.Process process)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _processLocalService.updateProcess(process);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _processLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _processLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _processLocalService.invokeMethod(name, parameterTypes, arguments);
    }

    /**
    * Find the record linked with the given process
    *
    * @param id The id of the process
    * @return The record linked with the process if it exists, else null
    * @throws PortalException
    * @throws SystemException
    */
    @Override
    public com.excilys.liferay.gatling.model.Record findRecordFromId(long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _processLocalService.findRecordFromId(id);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public ProcessLocalService getWrappedProcessLocalService() {
        return _processLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedProcessLocalService(
        ProcessLocalService processLocalService) {
        _processLocalService = processLocalService;
    }

    @Override
    public ProcessLocalService getWrappedService() {
        return _processLocalService;
    }

    @Override
    public void setWrappedService(ProcessLocalService processLocalService) {
        _processLocalService = processLocalService;
    }
}
