package com.excilys.liferay.gatling.service.persistence;

import com.excilys.liferay.gatling.model.LinkProcessRecord;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the link process record service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LinkProcessRecordPersistenceImpl
 * @see LinkProcessRecordUtil
 * @generated
 */
public interface LinkProcessRecordPersistence extends BasePersistence<LinkProcessRecord> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link LinkProcessRecordUtil} to access the link process record persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Returns the link process record where process_id = &#63; or throws a {@link com.excilys.liferay.gatling.NoSuchLinkProcessRecordException} if it could not be found.
    *
    * @param process_id the process_id
    * @return the matching link process record
    * @throws com.excilys.liferay.gatling.NoSuchLinkProcessRecordException if a matching link process record could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.excilys.liferay.gatling.model.LinkProcessRecord findByProcessId(
        long process_id)
        throws com.excilys.liferay.gatling.NoSuchLinkProcessRecordException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the link process record where process_id = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param process_id the process_id
    * @return the matching link process record, or <code>null</code> if a matching link process record could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.excilys.liferay.gatling.model.LinkProcessRecord fetchByProcessId(
        long process_id)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the link process record where process_id = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param process_id the process_id
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching link process record, or <code>null</code> if a matching link process record could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.excilys.liferay.gatling.model.LinkProcessRecord fetchByProcessId(
        long process_id, boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes the link process record where process_id = &#63; from the database.
    *
    * @param process_id the process_id
    * @return the link process record that was removed
    * @throws SystemException if a system exception occurred
    */
    public com.excilys.liferay.gatling.model.LinkProcessRecord removeByProcessId(
        long process_id)
        throws com.excilys.liferay.gatling.NoSuchLinkProcessRecordException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of link process records where process_id = &#63;.
    *
    * @param process_id the process_id
    * @return the number of matching link process records
    * @throws SystemException if a system exception occurred
    */
    public int countByProcessId(long process_id)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the link process record where recordId = &#63; or throws a {@link com.excilys.liferay.gatling.NoSuchLinkProcessRecordException} if it could not be found.
    *
    * @param recordId the record ID
    * @return the matching link process record
    * @throws com.excilys.liferay.gatling.NoSuchLinkProcessRecordException if a matching link process record could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.excilys.liferay.gatling.model.LinkProcessRecord findByRecordId(
        long recordId)
        throws com.excilys.liferay.gatling.NoSuchLinkProcessRecordException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the link process record where recordId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param recordId the record ID
    * @return the matching link process record, or <code>null</code> if a matching link process record could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.excilys.liferay.gatling.model.LinkProcessRecord fetchByRecordId(
        long recordId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the link process record where recordId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param recordId the record ID
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching link process record, or <code>null</code> if a matching link process record could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.excilys.liferay.gatling.model.LinkProcessRecord fetchByRecordId(
        long recordId, boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes the link process record where recordId = &#63; from the database.
    *
    * @param recordId the record ID
    * @return the link process record that was removed
    * @throws SystemException if a system exception occurred
    */
    public com.excilys.liferay.gatling.model.LinkProcessRecord removeByRecordId(
        long recordId)
        throws com.excilys.liferay.gatling.NoSuchLinkProcessRecordException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of link process records where recordId = &#63;.
    *
    * @param recordId the record ID
    * @return the number of matching link process records
    * @throws SystemException if a system exception occurred
    */
    public int countByRecordId(long recordId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Caches the link process record in the entity cache if it is enabled.
    *
    * @param linkProcessRecord the link process record
    */
    public void cacheResult(
        com.excilys.liferay.gatling.model.LinkProcessRecord linkProcessRecord);

    /**
    * Caches the link process records in the entity cache if it is enabled.
    *
    * @param linkProcessRecords the link process records
    */
    public void cacheResult(
        java.util.List<com.excilys.liferay.gatling.model.LinkProcessRecord> linkProcessRecords);

    /**
    * Creates a new link process record with the primary key. Does not add the link process record to the database.
    *
    * @param link_process_record_id the primary key for the new link process record
    * @return the new link process record
    */
    public com.excilys.liferay.gatling.model.LinkProcessRecord create(
        long link_process_record_id);

    /**
    * Removes the link process record with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param link_process_record_id the primary key of the link process record
    * @return the link process record that was removed
    * @throws com.excilys.liferay.gatling.NoSuchLinkProcessRecordException if a link process record with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.excilys.liferay.gatling.model.LinkProcessRecord remove(
        long link_process_record_id)
        throws com.excilys.liferay.gatling.NoSuchLinkProcessRecordException,
            com.liferay.portal.kernel.exception.SystemException;

    public com.excilys.liferay.gatling.model.LinkProcessRecord updateImpl(
        com.excilys.liferay.gatling.model.LinkProcessRecord linkProcessRecord)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the link process record with the primary key or throws a {@link com.excilys.liferay.gatling.NoSuchLinkProcessRecordException} if it could not be found.
    *
    * @param link_process_record_id the primary key of the link process record
    * @return the link process record
    * @throws com.excilys.liferay.gatling.NoSuchLinkProcessRecordException if a link process record with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.excilys.liferay.gatling.model.LinkProcessRecord findByPrimaryKey(
        long link_process_record_id)
        throws com.excilys.liferay.gatling.NoSuchLinkProcessRecordException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the link process record with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param link_process_record_id the primary key of the link process record
    * @return the link process record, or <code>null</code> if a link process record with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.excilys.liferay.gatling.model.LinkProcessRecord fetchByPrimaryKey(
        long link_process_record_id)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the link process records.
    *
    * @return the link process records
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.excilys.liferay.gatling.model.LinkProcessRecord> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.excilys.liferay.gatling.model.LinkProcessRecord> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the link process records.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.excilys.liferay.gatling.model.impl.LinkProcessRecordModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of link process records
    * @param end the upper bound of the range of link process records (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of link process records
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.excilys.liferay.gatling.model.LinkProcessRecord> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the link process records from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of link process records.
    *
    * @return the number of link process records
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
