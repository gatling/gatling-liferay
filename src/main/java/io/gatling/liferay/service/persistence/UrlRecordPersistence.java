/**
 * Copyright 2011-2016 GatlingCorp (http://gatling.io)
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

import io.gatling.liferay.model.UrlRecord;

/**
 * The persistence interface for the url record service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UrlRecordPersistenceImpl
 * @see UrlRecordUtil
 * @generated
 */
public interface UrlRecordPersistence extends BasePersistence<UrlRecord> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link UrlRecordUtil} to access the url record persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Returns all the url records where recordId = &#63;.
    *
    * @param recordId the record ID
    * @return the matching url records
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<io.gatling.liferay.model.UrlRecord> findByRecordId(
        long recordId)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<io.gatling.liferay.model.UrlRecord> findByRecordId(
        long recordId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<io.gatling.liferay.model.UrlRecord> findByRecordId(
        long recordId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first url record in the ordered set where recordId = &#63;.
    *
    * @param recordId the record ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching url record
    * @throws io.gatling.liferay.NoSuchUrlRecordException if a matching url record could not be found
    * @throws SystemException if a system exception occurred
    */
    public io.gatling.liferay.model.UrlRecord findByRecordId_First(
        long recordId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            io.gatling.liferay.NoSuchUrlRecordException;

    /**
    * Returns the first url record in the ordered set where recordId = &#63;.
    *
    * @param recordId the record ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching url record, or <code>null</code> if a matching url record could not be found
    * @throws SystemException if a system exception occurred
    */
    public io.gatling.liferay.model.UrlRecord fetchByRecordId_First(
        long recordId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last url record in the ordered set where recordId = &#63;.
    *
    * @param recordId the record ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching url record
    * @throws io.gatling.liferay.NoSuchUrlRecordException if a matching url record could not be found
    * @throws SystemException if a system exception occurred
    */
    public io.gatling.liferay.model.UrlRecord findByRecordId_Last(
        long recordId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            io.gatling.liferay.NoSuchUrlRecordException;

    /**
    * Returns the last url record in the ordered set where recordId = &#63;.
    *
    * @param recordId the record ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching url record, or <code>null</code> if a matching url record could not be found
    * @throws SystemException if a system exception occurred
    */
    public io.gatling.liferay.model.UrlRecord fetchByRecordId_Last(
        long recordId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public io.gatling.liferay.model.UrlRecord[] findByRecordId_PrevAndNext(
        long urlRecordId, long recordId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            io.gatling.liferay.NoSuchUrlRecordException;

    /**
    * Removes all the url records where recordId = &#63; from the database.
    *
    * @param recordId the record ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByRecordId(long recordId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of url records where recordId = &#63;.
    *
    * @param recordId the record ID
    * @return the number of matching url records
    * @throws SystemException if a system exception occurred
    */
    public int countByRecordId(long recordId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Caches the url record in the entity cache if it is enabled.
    *
    * @param urlRecord the url record
    */
    public void cacheResult(io.gatling.liferay.model.UrlRecord urlRecord);

    /**
    * Caches the url records in the entity cache if it is enabled.
    *
    * @param urlRecords the url records
    */
    public void cacheResult(
        java.util.List<io.gatling.liferay.model.UrlRecord> urlRecords);

    /**
    * Creates a new url record with the primary key. Does not add the url record to the database.
    *
    * @param urlRecordId the primary key for the new url record
    * @return the new url record
    */
    public io.gatling.liferay.model.UrlRecord create(long urlRecordId);

    /**
    * Removes the url record with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param urlRecordId the primary key of the url record
    * @return the url record that was removed
    * @throws io.gatling.liferay.NoSuchUrlRecordException if a url record with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public io.gatling.liferay.model.UrlRecord remove(long urlRecordId)
        throws com.liferay.portal.kernel.exception.SystemException,
            io.gatling.liferay.NoSuchUrlRecordException;

    public io.gatling.liferay.model.UrlRecord updateImpl(
        io.gatling.liferay.model.UrlRecord urlRecord)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the url record with the primary key or throws a {@link io.gatling.liferay.NoSuchUrlRecordException} if it could not be found.
    *
    * @param urlRecordId the primary key of the url record
    * @return the url record
    * @throws io.gatling.liferay.NoSuchUrlRecordException if a url record with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public io.gatling.liferay.model.UrlRecord findByPrimaryKey(long urlRecordId)
        throws com.liferay.portal.kernel.exception.SystemException,
            io.gatling.liferay.NoSuchUrlRecordException;

    /**
    * Returns the url record with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param urlRecordId the primary key of the url record
    * @return the url record, or <code>null</code> if a url record with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public io.gatling.liferay.model.UrlRecord fetchByPrimaryKey(
        long urlRecordId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the url records.
    *
    * @return the url records
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<io.gatling.liferay.model.UrlRecord> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<io.gatling.liferay.model.UrlRecord> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<io.gatling.liferay.model.UrlRecord> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the url records from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of url records.
    *
    * @return the number of url records
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
