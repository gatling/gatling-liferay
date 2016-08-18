package com.excilys.liferay.gatling.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.service.BaseLocalService;
import com.liferay.portal.service.InvokableLocalService;
import com.liferay.portal.service.PersistedModelLocalService;

/**
 * Provides the local service interface for Record. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see RecordLocalServiceUtil
 * @see com.excilys.liferay.gatling.service.base.RecordLocalServiceBaseImpl
 * @see com.excilys.liferay.gatling.service.impl.RecordLocalServiceImpl
 * @generated
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
    PortalException.class, SystemException.class}
)
public interface RecordLocalService extends BaseLocalService,
    InvokableLocalService, PersistedModelLocalService {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link RecordLocalServiceUtil} to access the record local service. Add custom service methods to {@link com.excilys.liferay.gatling.service.impl.RecordLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
     */

    /**
    * Adds the record to the database. Also notifies the appropriate model listeners.
    *
    * @param record the record
    * @return the record that was added
    * @throws SystemException if a system exception occurred
    */
    @com.liferay.portal.kernel.search.Indexable(type = IndexableType.REINDEX)
    public com.excilys.liferay.gatling.model.Record addRecord(
        com.excilys.liferay.gatling.model.Record record)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Creates a new record with the primary key. Does not add the record to the database.
    *
    * @param recordId the primary key for the new record
    * @return the new record
    */
    public com.excilys.liferay.gatling.model.Record createRecord(long recordId);

    /**
    * Deletes the record with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param recordId the primary key of the record
    * @return the record that was removed
    * @throws PortalException if a record with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @com.liferay.portal.kernel.search.Indexable(type = IndexableType.DELETE)
    public com.excilys.liferay.gatling.model.Record deleteRecord(long recordId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Deletes the record from the database. Also notifies the appropriate model listeners.
    *
    * @param record the record
    * @return the record that was removed
    * @throws SystemException if a system exception occurred
    */
    @com.liferay.portal.kernel.search.Indexable(type = IndexableType.DELETE)
    public com.excilys.liferay.gatling.model.Record deleteRecord(
        com.excilys.liferay.gatling.model.Record record)
        throws com.liferay.portal.kernel.exception.SystemException;

    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery();

    /**
    * Performs a dynamic query on the database and returns the matching rows.
    *
    * @param dynamicQuery the dynamic query
    * @return the matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.excilys.liferay.gatling.model.impl.RecordModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @return the range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.excilys.liferay.gatling.model.impl.RecordModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @param projection the projection to apply to the query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
        com.liferay.portal.kernel.dao.orm.Projection projection)
        throws com.liferay.portal.kernel.exception.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.excilys.liferay.gatling.model.Record fetchRecord(long recordId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the record with the primary key.
    *
    * @param recordId the primary key of the record
    * @return the record
    * @throws PortalException if a record with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.excilys.liferay.gatling.model.Record getRecord(long recordId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the records.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.excilys.liferay.gatling.model.impl.RecordModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of records
    * @param end the upper bound of the range of records (not inclusive)
    * @return the range of records
    * @throws SystemException if a system exception occurred
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.excilys.liferay.gatling.model.Record> getRecords(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of records.
    *
    * @return the number of records
    * @throws SystemException if a system exception occurred
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int getRecordsCount()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Updates the record in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param record the record
    * @return the record that was updated
    * @throws SystemException if a system exception occurred
    */
    @com.liferay.portal.kernel.search.Indexable(type = IndexableType.REINDEX)
    public com.excilys.liferay.gatling.model.Record updateRecord(
        com.excilys.liferay.gatling.model.Record record)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public java.lang.String getBeanIdentifier();

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public void setBeanIdentifier(java.lang.String beanIdentifier);

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable;

    public java.util.List<com.excilys.liferay.gatling.model.Record> findByPortletId(
        java.lang.String portletId)
        throws com.liferay.portal.kernel.exception.SystemException;

    public com.excilys.liferay.gatling.model.Record findByName(
        java.lang.String name)
        throws com.excilys.liferay.gatling.NoSuchRecordException,
            com.liferay.portal.kernel.exception.SystemException;

    public int countByPortletId(java.lang.String portletId)
        throws com.liferay.portal.kernel.exception.SystemException;

    public void update(long recordId, java.lang.String name)
        throws com.liferay.portal.NoSuchModelException,
            com.liferay.portal.kernel.exception.SystemException;

    public com.excilys.liferay.gatling.model.Record save(
        java.lang.String name, java.lang.String portletId,
        java.lang.String version)
        throws com.liferay.portal.kernel.exception.SystemException;
}
