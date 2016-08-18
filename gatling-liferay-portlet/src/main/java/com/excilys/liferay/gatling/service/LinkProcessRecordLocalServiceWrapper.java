package com.excilys.liferay.gatling.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link LinkProcessRecordLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see LinkProcessRecordLocalService
 * @generated
 */
public class LinkProcessRecordLocalServiceWrapper
    implements LinkProcessRecordLocalService,
        ServiceWrapper<LinkProcessRecordLocalService> {
    private LinkProcessRecordLocalService _linkProcessRecordLocalService;

    public LinkProcessRecordLocalServiceWrapper(
        LinkProcessRecordLocalService linkProcessRecordLocalService) {
        _linkProcessRecordLocalService = linkProcessRecordLocalService;
    }

    /**
    * Adds the link process record to the database. Also notifies the appropriate model listeners.
    *
    * @param linkProcessRecord the link process record
    * @return the link process record that was added
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.excilys.liferay.gatling.model.LinkProcessRecord addLinkProcessRecord(
        com.excilys.liferay.gatling.model.LinkProcessRecord linkProcessRecord)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _linkProcessRecordLocalService.addLinkProcessRecord(linkProcessRecord);
    }

    /**
    * Creates a new link process record with the primary key. Does not add the link process record to the database.
    *
    * @param link_process_record_id the primary key for the new link process record
    * @return the new link process record
    */
    @Override
    public com.excilys.liferay.gatling.model.LinkProcessRecord createLinkProcessRecord(
        long link_process_record_id) {
        return _linkProcessRecordLocalService.createLinkProcessRecord(link_process_record_id);
    }

    /**
    * Deletes the link process record with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param link_process_record_id the primary key of the link process record
    * @return the link process record that was removed
    * @throws PortalException if a link process record with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.excilys.liferay.gatling.model.LinkProcessRecord deleteLinkProcessRecord(
        long link_process_record_id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _linkProcessRecordLocalService.deleteLinkProcessRecord(link_process_record_id);
    }

    /**
    * Deletes the link process record from the database. Also notifies the appropriate model listeners.
    *
    * @param linkProcessRecord the link process record
    * @return the link process record that was removed
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.excilys.liferay.gatling.model.LinkProcessRecord deleteLinkProcessRecord(
        com.excilys.liferay.gatling.model.LinkProcessRecord linkProcessRecord)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _linkProcessRecordLocalService.deleteLinkProcessRecord(linkProcessRecord);
    }

    @Override
    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _linkProcessRecordLocalService.dynamicQuery();
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
        return _linkProcessRecordLocalService.dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.excilys.liferay.gatling.model.impl.LinkProcessRecordModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _linkProcessRecordLocalService.dynamicQuery(dynamicQuery, start,
            end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.excilys.liferay.gatling.model.impl.LinkProcessRecordModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _linkProcessRecordLocalService.dynamicQuery(dynamicQuery, start,
            end, orderByComparator);
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
        return _linkProcessRecordLocalService.dynamicQueryCount(dynamicQuery);
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
        return _linkProcessRecordLocalService.dynamicQueryCount(dynamicQuery,
            projection);
    }

    @Override
    public com.excilys.liferay.gatling.model.LinkProcessRecord fetchLinkProcessRecord(
        long link_process_record_id)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _linkProcessRecordLocalService.fetchLinkProcessRecord(link_process_record_id);
    }

    /**
    * Returns the link process record with the primary key.
    *
    * @param link_process_record_id the primary key of the link process record
    * @return the link process record
    * @throws PortalException if a link process record with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.excilys.liferay.gatling.model.LinkProcessRecord getLinkProcessRecord(
        long link_process_record_id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _linkProcessRecordLocalService.getLinkProcessRecord(link_process_record_id);
    }

    @Override
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _linkProcessRecordLocalService.getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the link process records.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.excilys.liferay.gatling.model.impl.LinkProcessRecordModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of link process records
    * @param end the upper bound of the range of link process records (not inclusive)
    * @return the range of link process records
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.util.List<com.excilys.liferay.gatling.model.LinkProcessRecord> getLinkProcessRecords(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _linkProcessRecordLocalService.getLinkProcessRecords(start, end);
    }

    /**
    * Returns the number of link process records.
    *
    * @return the number of link process records
    * @throws SystemException if a system exception occurred
    */
    @Override
    public int getLinkProcessRecordsCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _linkProcessRecordLocalService.getLinkProcessRecordsCount();
    }

    /**
    * Updates the link process record in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param linkProcessRecord the link process record
    * @return the link process record that was updated
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.excilys.liferay.gatling.model.LinkProcessRecord updateLinkProcessRecord(
        com.excilys.liferay.gatling.model.LinkProcessRecord linkProcessRecord)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _linkProcessRecordLocalService.updateLinkProcessRecord(linkProcessRecord);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _linkProcessRecordLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _linkProcessRecordLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _linkProcessRecordLocalService.invokeMethod(name,
            parameterTypes, arguments);
    }

    /**
    * Finds the Process associated with the given record id
    *
    * @param recordId The id of the record
    * @return The Process associated with the given record id or
    null if no process is associated with the given record id
    */
    @Override
    public com.excilys.liferay.gatling.model.Process findProcessFromRecordId(
        long recordId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _linkProcessRecordLocalService.findProcessFromRecordId(recordId);
    }

    /**
    * Finds the Record associated with the given process id
    *
    * @param processId The id of the process
    * @return The Record associated with the given process id or
    null if no record is associated with the given process id
    */
    @Override
    public com.excilys.liferay.gatling.model.Record findRecordFromProcessId(
        long processId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _linkProcessRecordLocalService.findRecordFromProcessId(processId);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public LinkProcessRecordLocalService getWrappedLinkProcessRecordLocalService() {
        return _linkProcessRecordLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedLinkProcessRecordLocalService(
        LinkProcessRecordLocalService linkProcessRecordLocalService) {
        _linkProcessRecordLocalService = linkProcessRecordLocalService;
    }

    @Override
    public LinkProcessRecordLocalService getWrappedService() {
        return _linkProcessRecordLocalService;
    }

    @Override
    public void setWrappedService(
        LinkProcessRecordLocalService linkProcessRecordLocalService) {
        _linkProcessRecordLocalService = linkProcessRecordLocalService;
    }
}
