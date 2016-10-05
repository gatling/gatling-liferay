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

import io.gatling.liferay.model.Process;

/**
 * The persistence interface for the process service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProcessPersistenceImpl
 * @see ProcessUtil
 * @generated
 */
public interface ProcessPersistence extends BasePersistence<Process> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link ProcessUtil} to access the process persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Returns the process where name = &#63; or throws a {@link io.gatling.liferay.NoSuchProcessException} if it could not be found.
    *
    * @param name the name
    * @return the matching process
    * @throws io.gatling.liferay.NoSuchProcessException if a matching process could not be found
    * @throws SystemException if a system exception occurred
    */
    public io.gatling.liferay.model.Process findByName(java.lang.String name)
        throws com.liferay.portal.kernel.exception.SystemException,
            io.gatling.liferay.NoSuchProcessException;

    /**
    * Returns the process where name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param name the name
    * @return the matching process, or <code>null</code> if a matching process could not be found
    * @throws SystemException if a system exception occurred
    */
    public io.gatling.liferay.model.Process fetchByName(java.lang.String name)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the process where name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param name the name
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching process, or <code>null</code> if a matching process could not be found
    * @throws SystemException if a system exception occurred
    */
    public io.gatling.liferay.model.Process fetchByName(java.lang.String name,
        boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes the process where name = &#63; from the database.
    *
    * @param name the name
    * @return the process that was removed
    * @throws SystemException if a system exception occurred
    */
    public io.gatling.liferay.model.Process removeByName(java.lang.String name)
        throws com.liferay.portal.kernel.exception.SystemException,
            io.gatling.liferay.NoSuchProcessException;

    /**
    * Returns the number of processes where name = &#63;.
    *
    * @param name the name
    * @return the number of matching processes
    * @throws SystemException if a system exception occurred
    */
    public int countByName(java.lang.String name)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Caches the process in the entity cache if it is enabled.
    *
    * @param process the process
    */
    public void cacheResult(io.gatling.liferay.model.Process process);

    /**
    * Caches the processes in the entity cache if it is enabled.
    *
    * @param processes the processes
    */
    public void cacheResult(
        java.util.List<io.gatling.liferay.model.Process> processes);

    /**
    * Creates a new process with the primary key. Does not add the process to the database.
    *
    * @param process_id the primary key for the new process
    * @return the new process
    */
    public io.gatling.liferay.model.Process create(long process_id);

    /**
    * Removes the process with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param process_id the primary key of the process
    * @return the process that was removed
    * @throws io.gatling.liferay.NoSuchProcessException if a process with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public io.gatling.liferay.model.Process remove(long process_id)
        throws com.liferay.portal.kernel.exception.SystemException,
            io.gatling.liferay.NoSuchProcessException;

    public io.gatling.liferay.model.Process updateImpl(
        io.gatling.liferay.model.Process process)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the process with the primary key or throws a {@link io.gatling.liferay.NoSuchProcessException} if it could not be found.
    *
    * @param process_id the primary key of the process
    * @return the process
    * @throws io.gatling.liferay.NoSuchProcessException if a process with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public io.gatling.liferay.model.Process findByPrimaryKey(long process_id)
        throws com.liferay.portal.kernel.exception.SystemException,
            io.gatling.liferay.NoSuchProcessException;

    /**
    * Returns the process with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param process_id the primary key of the process
    * @return the process, or <code>null</code> if a process with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public io.gatling.liferay.model.Process fetchByPrimaryKey(long process_id)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the processes.
    *
    * @return the processes
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<io.gatling.liferay.model.Process> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the processes.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link io.gatling.liferay.model.impl.ProcessModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of processes
    * @param end the upper bound of the range of processes (not inclusive)
    * @return the range of processes
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<io.gatling.liferay.model.Process> findAll(int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the processes.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link io.gatling.liferay.model.impl.ProcessModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of processes
    * @param end the upper bound of the range of processes (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of processes
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<io.gatling.liferay.model.Process> findAll(int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the processes from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of processes.
    *
    * @return the number of processes
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
