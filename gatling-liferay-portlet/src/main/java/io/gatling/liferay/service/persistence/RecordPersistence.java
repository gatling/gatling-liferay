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

import com.liferay.portal.service.persistence.BasePersistence;

import io.gatling.liferay.model.Record;

/**
 * The persistence interface for the record service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RecordPersistenceImpl
 * @see RecordUtil
 * @generated
 */
public interface RecordPersistence extends BasePersistence<Record> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link RecordUtil} to access the record persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Returns all the records where portletId = &#63;.
    *
    * @param portletId the portlet ID
    * @return the matching records
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<io.gatling.liferay.model.Record> findByPortletId(
        java.lang.String portletId)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<io.gatling.liferay.model.Record> findByPortletId(
        java.lang.String portletId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<io.gatling.liferay.model.Record> findByPortletId(
        java.lang.String portletId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first record in the ordered set where portletId = &#63;.
    *
    * @param portletId the portlet ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching record
    * @throws io.gatling.liferay.NoSuchRecordException if a matching record could not be found
    * @throws SystemException if a system exception occurred
    */
    public io.gatling.liferay.model.Record findByPortletId_First(
        java.lang.String portletId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            io.gatling.liferay.NoSuchRecordException;

    /**
    * Returns the first record in the ordered set where portletId = &#63;.
    *
    * @param portletId the portlet ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching record, or <code>null</code> if a matching record could not be found
    * @throws SystemException if a system exception occurred
    */
    public io.gatling.liferay.model.Record fetchByPortletId_First(
        java.lang.String portletId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last record in the ordered set where portletId = &#63;.
    *
    * @param portletId the portlet ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching record
    * @throws io.gatling.liferay.NoSuchRecordException if a matching record could not be found
    * @throws SystemException if a system exception occurred
    */
    public io.gatling.liferay.model.Record findByPortletId_Last(
        java.lang.String portletId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            io.gatling.liferay.NoSuchRecordException;

    /**
    * Returns the last record in the ordered set where portletId = &#63;.
    *
    * @param portletId the portlet ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching record, or <code>null</code> if a matching record could not be found
    * @throws SystemException if a system exception occurred
    */
    public io.gatling.liferay.model.Record fetchByPortletId_Last(
        java.lang.String portletId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public io.gatling.liferay.model.Record[] findByPortletId_PrevAndNext(
        long recordId, java.lang.String portletId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            io.gatling.liferay.NoSuchRecordException;

    /**
    * Removes all the records where portletId = &#63; from the database.
    *
    * @param portletId the portlet ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByPortletId(java.lang.String portletId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of records where portletId = &#63;.
    *
    * @param portletId the portlet ID
    * @return the number of matching records
    * @throws SystemException if a system exception occurred
    */
    public int countByPortletId(java.lang.String portletId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the record where name = &#63; or throws a {@link io.gatling.liferay.NoSuchRecordException} if it could not be found.
    *
    * @param name the name
    * @return the matching record
    * @throws io.gatling.liferay.NoSuchRecordException if a matching record could not be found
    * @throws SystemException if a system exception occurred
    */
    public io.gatling.liferay.model.Record findByName(java.lang.String name)
        throws com.liferay.portal.kernel.exception.SystemException,
            io.gatling.liferay.NoSuchRecordException;

    /**
    * Returns the record where name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param name the name
    * @return the matching record, or <code>null</code> if a matching record could not be found
    * @throws SystemException if a system exception occurred
    */
    public io.gatling.liferay.model.Record fetchByName(java.lang.String name)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the record where name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param name the name
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching record, or <code>null</code> if a matching record could not be found
    * @throws SystemException if a system exception occurred
    */
    public io.gatling.liferay.model.Record fetchByName(java.lang.String name,
        boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes the record where name = &#63; from the database.
    *
    * @param name the name
    * @return the record that was removed
    * @throws SystemException if a system exception occurred
    */
    public io.gatling.liferay.model.Record removeByName(java.lang.String name)
        throws com.liferay.portal.kernel.exception.SystemException,
            io.gatling.liferay.NoSuchRecordException;

    /**
    * Returns the number of records where name = &#63;.
    *
    * @param name the name
    * @return the number of matching records
    * @throws SystemException if a system exception occurred
    */
    public int countByName(java.lang.String name)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Caches the record in the entity cache if it is enabled.
    *
    * @param record the record
    */
    public void cacheResult(io.gatling.liferay.model.Record record);

    /**
    * Caches the records in the entity cache if it is enabled.
    *
    * @param records the records
    */
    public void cacheResult(
        java.util.List<io.gatling.liferay.model.Record> records);

    /**
    * Creates a new record with the primary key. Does not add the record to the database.
    *
    * @param recordId the primary key for the new record
    * @return the new record
    */
    public io.gatling.liferay.model.Record create(long recordId);

    /**
    * Removes the record with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param recordId the primary key of the record
    * @return the record that was removed
    * @throws io.gatling.liferay.NoSuchRecordException if a record with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public io.gatling.liferay.model.Record remove(long recordId)
        throws com.liferay.portal.kernel.exception.SystemException,
            io.gatling.liferay.NoSuchRecordException;

    public io.gatling.liferay.model.Record updateImpl(
        io.gatling.liferay.model.Record record)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the record with the primary key or throws a {@link io.gatling.liferay.NoSuchRecordException} if it could not be found.
    *
    * @param recordId the primary key of the record
    * @return the record
    * @throws io.gatling.liferay.NoSuchRecordException if a record with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public io.gatling.liferay.model.Record findByPrimaryKey(long recordId)
        throws com.liferay.portal.kernel.exception.SystemException,
            io.gatling.liferay.NoSuchRecordException;

    /**
    * Returns the record with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param recordId the primary key of the record
    * @return the record, or <code>null</code> if a record with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public io.gatling.liferay.model.Record fetchByPrimaryKey(long recordId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the records.
    *
    * @return the records
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<io.gatling.liferay.model.Record> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<io.gatling.liferay.model.Record> findAll(int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<io.gatling.liferay.model.Record> findAll(int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the records from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of records.
    *
    * @return the number of records
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
