/**
 * Copyright 2011-2015 GatlingCorp (http://gatling.io)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * 		http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.gatling.liferay.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import io.gatling.liferay.model.UrlRecord;

import java.util.List;

/**
 * The persistence utility for the url record service. This utility wraps {@link UrlRecordPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UrlRecordPersistence
 * @see UrlRecordPersistenceImpl
 * @generated
 */
public class UrlRecordUtil {
    private static UrlRecordPersistence _persistence;

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
    public static void clearCache(UrlRecord urlRecord) {
        getPersistence().clearCache(urlRecord);
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
    public static List<UrlRecord> findWithDynamicQuery(
        DynamicQuery dynamicQuery) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<UrlRecord> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<UrlRecord> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static UrlRecord update(UrlRecord urlRecord)
        throws SystemException {
        return getPersistence().update(urlRecord);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static UrlRecord update(UrlRecord urlRecord,
        ServiceContext serviceContext) throws SystemException {
        return getPersistence().update(urlRecord, serviceContext);
    }

    /**
    * Returns all the url records where recordId = &#63;.
    *
    * @param recordId the record ID
    * @return the matching url records
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<io.gatling.liferay.model.UrlRecord> findByRecordId(
        long recordId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByRecordId(recordId);
    }

    /**
    * Returns a range of all the url records where recordId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link io.gatling.liferay.model.impl.UrlRecordModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param recordId the record ID
    * @param start the lower bound of the range of url records
    * @param end the upper bound of the range of url records (not inclusive)
    * @return the range of matching url records
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<io.gatling.liferay.model.UrlRecord> findByRecordId(
        long recordId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByRecordId(recordId, start, end);
    }

    /**
    * Returns an ordered range of all the url records where recordId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link io.gatling.liferay.model.impl.UrlRecordModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param recordId the record ID
    * @param start the lower bound of the range of url records
    * @param end the upper bound of the range of url records (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching url records
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<io.gatling.liferay.model.UrlRecord> findByRecordId(
        long recordId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByRecordId(recordId, start, end, orderByComparator);
    }

    /**
    * Returns the first url record in the ordered set where recordId = &#63;.
    *
    * @param recordId the record ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching url record
    * @throws io.gatling.liferay.NoSuchUrlRecordException if a matching url record could not be found
    * @throws SystemException if a system exception occurred
    */
    public static io.gatling.liferay.model.UrlRecord findByRecordId_First(
        long recordId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            io.gatling.liferay.NoSuchUrlRecordException {
        return getPersistence().findByRecordId_First(recordId, orderByComparator);
    }

    /**
    * Returns the first url record in the ordered set where recordId = &#63;.
    *
    * @param recordId the record ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching url record, or <code>null</code> if a matching url record could not be found
    * @throws SystemException if a system exception occurred
    */
    public static io.gatling.liferay.model.UrlRecord fetchByRecordId_First(
        long recordId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByRecordId_First(recordId, orderByComparator);
    }

    /**
    * Returns the last url record in the ordered set where recordId = &#63;.
    *
    * @param recordId the record ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching url record
    * @throws io.gatling.liferay.NoSuchUrlRecordException if a matching url record could not be found
    * @throws SystemException if a system exception occurred
    */
    public static io.gatling.liferay.model.UrlRecord findByRecordId_Last(
        long recordId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            io.gatling.liferay.NoSuchUrlRecordException {
        return getPersistence().findByRecordId_Last(recordId, orderByComparator);
    }

    /**
    * Returns the last url record in the ordered set where recordId = &#63;.
    *
    * @param recordId the record ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching url record, or <code>null</code> if a matching url record could not be found
    * @throws SystemException if a system exception occurred
    */
    public static io.gatling.liferay.model.UrlRecord fetchByRecordId_Last(
        long recordId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByRecordId_Last(recordId, orderByComparator);
    }

    /**
    * Returns the url records before and after the current url record in the ordered set where recordId = &#63;.
    *
    * @param urlRecordId the primary key of the current url record
    * @param recordId the record ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next url record
    * @throws io.gatling.liferay.NoSuchUrlRecordException if a url record with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static io.gatling.liferay.model.UrlRecord[] findByRecordId_PrevAndNext(
        long urlRecordId, long recordId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            io.gatling.liferay.NoSuchUrlRecordException {
        return getPersistence()
                   .findByRecordId_PrevAndNext(urlRecordId, recordId,
            orderByComparator);
    }

    /**
    * Removes all the url records where recordId = &#63; from the database.
    *
    * @param recordId the record ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByRecordId(long recordId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByRecordId(recordId);
    }

    /**
    * Returns the number of url records where recordId = &#63;.
    *
    * @param recordId the record ID
    * @return the number of matching url records
    * @throws SystemException if a system exception occurred
    */
    public static int countByRecordId(long recordId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByRecordId(recordId);
    }

    /**
    * Caches the url record in the entity cache if it is enabled.
    *
    * @param urlRecord the url record
    */
    public static void cacheResult(io.gatling.liferay.model.UrlRecord urlRecord) {
        getPersistence().cacheResult(urlRecord);
    }

    /**
    * Caches the url records in the entity cache if it is enabled.
    *
    * @param urlRecords the url records
    */
    public static void cacheResult(
        java.util.List<io.gatling.liferay.model.UrlRecord> urlRecords) {
        getPersistence().cacheResult(urlRecords);
    }

    /**
    * Creates a new url record with the primary key. Does not add the url record to the database.
    *
    * @param urlRecordId the primary key for the new url record
    * @return the new url record
    */
    public static io.gatling.liferay.model.UrlRecord create(long urlRecordId) {
        return getPersistence().create(urlRecordId);
    }

    /**
    * Removes the url record with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param urlRecordId the primary key of the url record
    * @return the url record that was removed
    * @throws io.gatling.liferay.NoSuchUrlRecordException if a url record with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static io.gatling.liferay.model.UrlRecord remove(long urlRecordId)
        throws com.liferay.portal.kernel.exception.SystemException,
            io.gatling.liferay.NoSuchUrlRecordException {
        return getPersistence().remove(urlRecordId);
    }

    public static io.gatling.liferay.model.UrlRecord updateImpl(
        io.gatling.liferay.model.UrlRecord urlRecord)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(urlRecord);
    }

    /**
    * Returns the url record with the primary key or throws a {@link io.gatling.liferay.NoSuchUrlRecordException} if it could not be found.
    *
    * @param urlRecordId the primary key of the url record
    * @return the url record
    * @throws io.gatling.liferay.NoSuchUrlRecordException if a url record with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static io.gatling.liferay.model.UrlRecord findByPrimaryKey(
        long urlRecordId)
        throws com.liferay.portal.kernel.exception.SystemException,
            io.gatling.liferay.NoSuchUrlRecordException {
        return getPersistence().findByPrimaryKey(urlRecordId);
    }

    /**
    * Returns the url record with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param urlRecordId the primary key of the url record
    * @return the url record, or <code>null</code> if a url record with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static io.gatling.liferay.model.UrlRecord fetchByPrimaryKey(
        long urlRecordId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(urlRecordId);
    }

    /**
    * Returns all the url records.
    *
    * @return the url records
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<io.gatling.liferay.model.UrlRecord> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
    }

    /**
    * Returns a range of all the url records.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link io.gatling.liferay.model.impl.UrlRecordModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of url records
    * @param end the upper bound of the range of url records (not inclusive)
    * @return the range of url records
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<io.gatling.liferay.model.UrlRecord> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the url records.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link io.gatling.liferay.model.impl.UrlRecordModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of url records
    * @param end the upper bound of the range of url records (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of url records
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<io.gatling.liferay.model.UrlRecord> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the url records from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of url records.
    *
    * @return the number of url records
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static UrlRecordPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (UrlRecordPersistence) PortletBeanLocatorUtil.locate(io.gatling.liferay.service.ClpSerializer.getServletContextName(),
                    UrlRecordPersistence.class.getName());

            ReferenceRegistry.registerReference(UrlRecordUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(UrlRecordPersistence persistence) {
    }
}
