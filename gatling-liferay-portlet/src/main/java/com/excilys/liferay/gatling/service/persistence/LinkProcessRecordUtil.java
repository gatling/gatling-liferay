package com.excilys.liferay.gatling.service.persistence;

import com.excilys.liferay.gatling.model.LinkProcessRecord;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the link process record service. This utility wraps {@link LinkProcessRecordPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LinkProcessRecordPersistence
 * @see LinkProcessRecordPersistenceImpl
 * @generated
 */
public class LinkProcessRecordUtil {
    private static LinkProcessRecordPersistence _persistence;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
     */
    public static void clearCache() {
        getPersistence().clearCache();
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
     */
    public static void clearCache(LinkProcessRecord linkProcessRecord) {
        getPersistence().clearCache(linkProcessRecord);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
     */
    public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().countWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
     */
    public static List<LinkProcessRecord> findWithDynamicQuery(
        DynamicQuery dynamicQuery) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<LinkProcessRecord> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<LinkProcessRecord> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static LinkProcessRecord update(LinkProcessRecord linkProcessRecord)
        throws SystemException {
        return getPersistence().update(linkProcessRecord);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static LinkProcessRecord update(
        LinkProcessRecord linkProcessRecord, ServiceContext serviceContext)
        throws SystemException {
        return getPersistence().update(linkProcessRecord, serviceContext);
    }

    /**
    * Returns the link process record where process_id = &#63; or throws a {@link com.excilys.liferay.gatling.NoSuchLinkProcessRecordException} if it could not be found.
    *
    * @param process_id the process_id
    * @return the matching link process record
    * @throws com.excilys.liferay.gatling.NoSuchLinkProcessRecordException if a matching link process record could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.excilys.liferay.gatling.model.LinkProcessRecord findByProcessId(
        long process_id)
        throws com.excilys.liferay.gatling.NoSuchLinkProcessRecordException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByProcessId(process_id);
    }

    /**
    * Returns the link process record where process_id = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param process_id the process_id
    * @return the matching link process record, or <code>null</code> if a matching link process record could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.excilys.liferay.gatling.model.LinkProcessRecord fetchByProcessId(
        long process_id)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByProcessId(process_id);
    }

    /**
    * Returns the link process record where process_id = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param process_id the process_id
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching link process record, or <code>null</code> if a matching link process record could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.excilys.liferay.gatling.model.LinkProcessRecord fetchByProcessId(
        long process_id, boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByProcessId(process_id, retrieveFromCache);
    }

    /**
    * Removes the link process record where process_id = &#63; from the database.
    *
    * @param process_id the process_id
    * @return the link process record that was removed
    * @throws SystemException if a system exception occurred
    */
    public static com.excilys.liferay.gatling.model.LinkProcessRecord removeByProcessId(
        long process_id)
        throws com.excilys.liferay.gatling.NoSuchLinkProcessRecordException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().removeByProcessId(process_id);
    }

    /**
    * Returns the number of link process records where process_id = &#63;.
    *
    * @param process_id the process_id
    * @return the number of matching link process records
    * @throws SystemException if a system exception occurred
    */
    public static int countByProcessId(long process_id)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByProcessId(process_id);
    }

    /**
    * Returns the link process record where recordId = &#63; or throws a {@link com.excilys.liferay.gatling.NoSuchLinkProcessRecordException} if it could not be found.
    *
    * @param recordId the record ID
    * @return the matching link process record
    * @throws com.excilys.liferay.gatling.NoSuchLinkProcessRecordException if a matching link process record could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.excilys.liferay.gatling.model.LinkProcessRecord findByRecordId(
        long recordId)
        throws com.excilys.liferay.gatling.NoSuchLinkProcessRecordException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByRecordId(recordId);
    }

    /**
    * Returns the link process record where recordId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param recordId the record ID
    * @return the matching link process record, or <code>null</code> if a matching link process record could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.excilys.liferay.gatling.model.LinkProcessRecord fetchByRecordId(
        long recordId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByRecordId(recordId);
    }

    /**
    * Returns the link process record where recordId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param recordId the record ID
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching link process record, or <code>null</code> if a matching link process record could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.excilys.liferay.gatling.model.LinkProcessRecord fetchByRecordId(
        long recordId, boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByRecordId(recordId, retrieveFromCache);
    }

    /**
    * Removes the link process record where recordId = &#63; from the database.
    *
    * @param recordId the record ID
    * @return the link process record that was removed
    * @throws SystemException if a system exception occurred
    */
    public static com.excilys.liferay.gatling.model.LinkProcessRecord removeByRecordId(
        long recordId)
        throws com.excilys.liferay.gatling.NoSuchLinkProcessRecordException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().removeByRecordId(recordId);
    }

    /**
    * Returns the number of link process records where recordId = &#63;.
    *
    * @param recordId the record ID
    * @return the number of matching link process records
    * @throws SystemException if a system exception occurred
    */
    public static int countByRecordId(long recordId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByRecordId(recordId);
    }

    /**
    * Caches the link process record in the entity cache if it is enabled.
    *
    * @param linkProcessRecord the link process record
    */
    public static void cacheResult(
        com.excilys.liferay.gatling.model.LinkProcessRecord linkProcessRecord) {
        getPersistence().cacheResult(linkProcessRecord);
    }

    /**
    * Caches the link process records in the entity cache if it is enabled.
    *
    * @param linkProcessRecords the link process records
    */
    public static void cacheResult(
        java.util.List<com.excilys.liferay.gatling.model.LinkProcessRecord> linkProcessRecords) {
        getPersistence().cacheResult(linkProcessRecords);
    }

    /**
    * Creates a new link process record with the primary key. Does not add the link process record to the database.
    *
    * @param link_process_record_id the primary key for the new link process record
    * @return the new link process record
    */
    public static com.excilys.liferay.gatling.model.LinkProcessRecord create(
        long link_process_record_id) {
        return getPersistence().create(link_process_record_id);
    }

    /**
    * Removes the link process record with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param link_process_record_id the primary key of the link process record
    * @return the link process record that was removed
    * @throws com.excilys.liferay.gatling.NoSuchLinkProcessRecordException if a link process record with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.excilys.liferay.gatling.model.LinkProcessRecord remove(
        long link_process_record_id)
        throws com.excilys.liferay.gatling.NoSuchLinkProcessRecordException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().remove(link_process_record_id);
    }

    public static com.excilys.liferay.gatling.model.LinkProcessRecord updateImpl(
        com.excilys.liferay.gatling.model.LinkProcessRecord linkProcessRecord)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(linkProcessRecord);
    }

    /**
    * Returns the link process record with the primary key or throws a {@link com.excilys.liferay.gatling.NoSuchLinkProcessRecordException} if it could not be found.
    *
    * @param link_process_record_id the primary key of the link process record
    * @return the link process record
    * @throws com.excilys.liferay.gatling.NoSuchLinkProcessRecordException if a link process record with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.excilys.liferay.gatling.model.LinkProcessRecord findByPrimaryKey(
        long link_process_record_id)
        throws com.excilys.liferay.gatling.NoSuchLinkProcessRecordException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByPrimaryKey(link_process_record_id);
    }

    /**
    * Returns the link process record with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param link_process_record_id the primary key of the link process record
    * @return the link process record, or <code>null</code> if a link process record with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.excilys.liferay.gatling.model.LinkProcessRecord fetchByPrimaryKey(
        long link_process_record_id)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(link_process_record_id);
    }

    /**
    * Returns all the link process records.
    *
    * @return the link process records
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.excilys.liferay.gatling.model.LinkProcessRecord> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
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
    public static java.util.List<com.excilys.liferay.gatling.model.LinkProcessRecord> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

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
    public static java.util.List<com.excilys.liferay.gatling.model.LinkProcessRecord> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the link process records from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of link process records.
    *
    * @return the number of link process records
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static LinkProcessRecordPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (LinkProcessRecordPersistence) PortletBeanLocatorUtil.locate(com.excilys.liferay.gatling.service.ClpSerializer.getServletContextName(),
                    LinkProcessRecordPersistence.class.getName());

            ReferenceRegistry.registerReference(LinkProcessRecordUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(LinkProcessRecordPersistence persistence) {
    }
}
