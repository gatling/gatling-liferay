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

import io.gatling.liferay.model.Login;

/**
 * The persistence interface for the login service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LoginPersistenceImpl
 * @see LoginUtil
 * @generated
 */
public interface LoginPersistence extends BasePersistence<Login> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link LoginUtil} to access the login persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Returns the login where name = &#63; or throws a {@link io.gatling.liferay.NoSuchLoginException} if it could not be found.
    *
    * @param name the name
    * @return the matching login
    * @throws io.gatling.liferay.NoSuchLoginException if a matching login could not be found
    * @throws SystemException if a system exception occurred
    */
    public io.gatling.liferay.model.Login findByName(java.lang.String name)
        throws com.liferay.portal.kernel.exception.SystemException,
            io.gatling.liferay.NoSuchLoginException;

    /**
    * Returns the login where name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param name the name
    * @return the matching login, or <code>null</code> if a matching login could not be found
    * @throws SystemException if a system exception occurred
    */
    public io.gatling.liferay.model.Login fetchByName(java.lang.String name)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the login where name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param name the name
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching login, or <code>null</code> if a matching login could not be found
    * @throws SystemException if a system exception occurred
    */
    public io.gatling.liferay.model.Login fetchByName(java.lang.String name,
        boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes the login where name = &#63; from the database.
    *
    * @param name the name
    * @return the login that was removed
    * @throws SystemException if a system exception occurred
    */
    public io.gatling.liferay.model.Login removeByName(java.lang.String name)
        throws com.liferay.portal.kernel.exception.SystemException,
            io.gatling.liferay.NoSuchLoginException;

    /**
    * Returns the number of logins where name = &#63;.
    *
    * @param name the name
    * @return the number of matching logins
    * @throws SystemException if a system exception occurred
    */
    public int countByName(java.lang.String name)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Caches the login in the entity cache if it is enabled.
    *
    * @param login the login
    */
    public void cacheResult(io.gatling.liferay.model.Login login);

    /**
    * Caches the logins in the entity cache if it is enabled.
    *
    * @param logins the logins
    */
    public void cacheResult(
        java.util.List<io.gatling.liferay.model.Login> logins);

    /**
    * Creates a new login with the primary key. Does not add the login to the database.
    *
    * @param userId the primary key for the new login
    * @return the new login
    */
    public io.gatling.liferay.model.Login create(long userId);

    /**
    * Removes the login with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param userId the primary key of the login
    * @return the login that was removed
    * @throws io.gatling.liferay.NoSuchLoginException if a login with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public io.gatling.liferay.model.Login remove(long userId)
        throws com.liferay.portal.kernel.exception.SystemException,
            io.gatling.liferay.NoSuchLoginException;

    public io.gatling.liferay.model.Login updateImpl(
        io.gatling.liferay.model.Login login)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the login with the primary key or throws a {@link io.gatling.liferay.NoSuchLoginException} if it could not be found.
    *
    * @param userId the primary key of the login
    * @return the login
    * @throws io.gatling.liferay.NoSuchLoginException if a login with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public io.gatling.liferay.model.Login findByPrimaryKey(long userId)
        throws com.liferay.portal.kernel.exception.SystemException,
            io.gatling.liferay.NoSuchLoginException;

    /**
    * Returns the login with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param userId the primary key of the login
    * @return the login, or <code>null</code> if a login with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public io.gatling.liferay.model.Login fetchByPrimaryKey(long userId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the logins.
    *
    * @return the logins
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<io.gatling.liferay.model.Login> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the logins.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link io.gatling.liferay.model.impl.LoginModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of logins
    * @param end the upper bound of the range of logins (not inclusive)
    * @return the range of logins
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<io.gatling.liferay.model.Login> findAll(int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the logins.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link io.gatling.liferay.model.impl.LoginModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of logins
    * @param end the upper bound of the range of logins (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of logins
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<io.gatling.liferay.model.Login> findAll(int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the logins from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of logins.
    *
    * @return the number of logins
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
