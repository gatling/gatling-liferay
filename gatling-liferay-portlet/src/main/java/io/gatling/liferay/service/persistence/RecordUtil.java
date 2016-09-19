package io.gatling.liferay.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import io.gatling.liferay.model.Record;

import java.util.List;

/**
 * The persistence utility for the record service. This utility wraps {@link RecordPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RecordPersistence
 * @see RecordPersistenceImpl
 * @generated
 */
public class RecordUtil {
    private static RecordPersistence _persistence;

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
    public static void clearCache(Record record) {
        getPersistence().clearCache(record);
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
    public static List<Record> findWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<Record> findWithDynamicQuery(DynamicQuery dynamicQuery,
        int start, int end) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<Record> findWithDynamicQuery(DynamicQuery dynamicQuery,
        int start, int end, OrderByComparator orderByComparator)
        throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static Record update(Record record) throws SystemException {
        return getPersistence().update(record);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static Record update(Record record, ServiceContext serviceContext)
        throws SystemException {
        return getPersistence().update(record, serviceContext);
    }

    /**
    * Returns all the records where portletId = &#63;.
    *
    * @param portletId the portlet ID
    * @return the matching records
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<io.gatling.liferay.model.Record> findByPortletId(
        java.lang.String portletId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByPortletId(portletId);
    }

    /**
    * Returns a range of all the records where portletId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link io.gatling.liferay.model.impl.RecordModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param portletId the portlet ID
    * @param start the lower bound of the range of records
    * @param end the upper bound of the range of records (not inclusive)
    * @return the range of matching records
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<io.gatling.liferay.model.Record> findByPortletId(
        java.lang.String portletId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByPortletId(portletId, start, end);
    }

    /**
    * Returns an ordered range of all the records where portletId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link io.gatling.liferay.model.impl.RecordModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param portletId the portlet ID
    * @param start the lower bound of the range of records
    * @param end the upper bound of the range of records (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching records
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<io.gatling.liferay.model.Record> findByPortletId(
        java.lang.String portletId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByPortletId(portletId, start, end, orderByComparator);
    }

    /**
    * Returns the first record in the ordered set where portletId = &#63;.
    *
    * @param portletId the portlet ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching record
    * @throws io.gatling.liferay.NoSuchRecordException if a matching record could not be found
    * @throws SystemException if a system exception occurred
    */
    public static io.gatling.liferay.model.Record findByPortletId_First(
        java.lang.String portletId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            io.gatling.liferay.NoSuchRecordException {
        return getPersistence()
                   .findByPortletId_First(portletId, orderByComparator);
    }

    /**
    * Returns the first record in the ordered set where portletId = &#63;.
    *
    * @param portletId the portlet ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching record, or <code>null</code> if a matching record could not be found
    * @throws SystemException if a system exception occurred
    */
    public static io.gatling.liferay.model.Record fetchByPortletId_First(
        java.lang.String portletId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByPortletId_First(portletId, orderByComparator);
    }

    /**
    * Returns the last record in the ordered set where portletId = &#63;.
    *
    * @param portletId the portlet ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching record
    * @throws io.gatling.liferay.NoSuchRecordException if a matching record could not be found
    * @throws SystemException if a system exception occurred
    */
    public static io.gatling.liferay.model.Record findByPortletId_Last(
        java.lang.String portletId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            io.gatling.liferay.NoSuchRecordException {
        return getPersistence()
                   .findByPortletId_Last(portletId, orderByComparator);
    }

    /**
    * Returns the last record in the ordered set where portletId = &#63;.
    *
    * @param portletId the portlet ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching record, or <code>null</code> if a matching record could not be found
    * @throws SystemException if a system exception occurred
    */
    public static io.gatling.liferay.model.Record fetchByPortletId_Last(
        java.lang.String portletId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByPortletId_Last(portletId, orderByComparator);
    }

    /**
    * Returns the records before and after the current record in the ordered set where portletId = &#63;.
    *
    * @param recordId the primary key of the current record
    * @param portletId the portlet ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next record
    * @throws io.gatling.liferay.NoSuchRecordException if a record with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static io.gatling.liferay.model.Record[] findByPortletId_PrevAndNext(
        long recordId, java.lang.String portletId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            io.gatling.liferay.NoSuchRecordException {
        return getPersistence()
                   .findByPortletId_PrevAndNext(recordId, portletId,
            orderByComparator);
    }

    /**
    * Removes all the records where portletId = &#63; from the database.
    *
    * @param portletId the portlet ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByPortletId(java.lang.String portletId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByPortletId(portletId);
    }

    /**
    * Returns the number of records where portletId = &#63;.
    *
    * @param portletId the portlet ID
    * @return the number of matching records
    * @throws SystemException if a system exception occurred
    */
    public static int countByPortletId(java.lang.String portletId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByPortletId(portletId);
    }

    /**
    * Returns the record where name = &#63; or throws a {@link io.gatling.liferay.NoSuchRecordException} if it could not be found.
    *
    * @param name the name
    * @return the matching record
    * @throws io.gatling.liferay.NoSuchRecordException if a matching record could not be found
    * @throws SystemException if a system exception occurred
    */
    public static io.gatling.liferay.model.Record findByName(
        java.lang.String name)
        throws com.liferay.portal.kernel.exception.SystemException,
            io.gatling.liferay.NoSuchRecordException {
        return getPersistence().findByName(name);
    }

    /**
    * Returns the record where name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param name the name
    * @return the matching record, or <code>null</code> if a matching record could not be found
    * @throws SystemException if a system exception occurred
    */
    public static io.gatling.liferay.model.Record fetchByName(
        java.lang.String name)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByName(name);
    }

    /**
    * Returns the record where name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param name the name
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching record, or <code>null</code> if a matching record could not be found
    * @throws SystemException if a system exception occurred
    */
    public static io.gatling.liferay.model.Record fetchByName(
        java.lang.String name, boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByName(name, retrieveFromCache);
    }

    /**
    * Removes the record where name = &#63; from the database.
    *
    * @param name the name
    * @return the record that was removed
    * @throws SystemException if a system exception occurred
    */
    public static io.gatling.liferay.model.Record removeByName(
        java.lang.String name)
        throws com.liferay.portal.kernel.exception.SystemException,
            io.gatling.liferay.NoSuchRecordException {
        return getPersistence().removeByName(name);
    }

    /**
    * Returns the number of records where name = &#63;.
    *
    * @param name the name
    * @return the number of matching records
    * @throws SystemException if a system exception occurred
    */
    public static int countByName(java.lang.String name)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByName(name);
    }

    /**
    * Caches the record in the entity cache if it is enabled.
    *
    * @param record the record
    */
    public static void cacheResult(io.gatling.liferay.model.Record record) {
        getPersistence().cacheResult(record);
    }

    /**
    * Caches the records in the entity cache if it is enabled.
    *
    * @param records the records
    */
    public static void cacheResult(
        java.util.List<io.gatling.liferay.model.Record> records) {
        getPersistence().cacheResult(records);
    }

    /**
    * Creates a new record with the primary key. Does not add the record to the database.
    *
    * @param recordId the primary key for the new record
    * @return the new record
    */
    public static io.gatling.liferay.model.Record create(long recordId) {
        return getPersistence().create(recordId);
    }

    /**
    * Removes the record with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param recordId the primary key of the record
    * @return the record that was removed
    * @throws io.gatling.liferay.NoSuchRecordException if a record with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static io.gatling.liferay.model.Record remove(long recordId)
        throws com.liferay.portal.kernel.exception.SystemException,
            io.gatling.liferay.NoSuchRecordException {
        return getPersistence().remove(recordId);
    }

    public static io.gatling.liferay.model.Record updateImpl(
        io.gatling.liferay.model.Record record)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(record);
    }

    /**
    * Returns the record with the primary key or throws a {@link io.gatling.liferay.NoSuchRecordException} if it could not be found.
    *
    * @param recordId the primary key of the record
    * @return the record
    * @throws io.gatling.liferay.NoSuchRecordException if a record with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static io.gatling.liferay.model.Record findByPrimaryKey(
        long recordId)
        throws com.liferay.portal.kernel.exception.SystemException,
            io.gatling.liferay.NoSuchRecordException {
        return getPersistence().findByPrimaryKey(recordId);
    }

    /**
    * Returns the record with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param recordId the primary key of the record
    * @return the record, or <code>null</code> if a record with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static io.gatling.liferay.model.Record fetchByPrimaryKey(
        long recordId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(recordId);
    }

    /**
    * Returns all the records.
    *
    * @return the records
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<io.gatling.liferay.model.Record> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
    }

    /**
    * Returns a range of all the records.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link io.gatling.liferay.model.impl.RecordModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of records
    * @param end the upper bound of the range of records (not inclusive)
    * @return the range of records
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<io.gatling.liferay.model.Record> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the records.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link io.gatling.liferay.model.impl.RecordModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of records
    * @param end the upper bound of the range of records (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of records
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<io.gatling.liferay.model.Record> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the records from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of records.
    *
    * @return the number of records
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static RecordPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (RecordPersistence) PortletBeanLocatorUtil.locate(io.gatling.liferay.service.ClpSerializer.getServletContextName(),
                    RecordPersistence.class.getName());

            ReferenceRegistry.registerReference(RecordUtil.class, "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(RecordPersistence persistence) {
    }
}
