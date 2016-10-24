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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import io.gatling.liferay.model.Login;

import java.util.List;

/**
 * The persistence utility for the login service. This utility wraps {@link LoginPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LoginPersistence
 * @see LoginPersistenceImpl
 * @generated
 */
public class LoginUtil {
    private static LoginPersistence _persistence;

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
    public static void clearCache(Login login) {
        getPersistence().clearCache(login);
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
    public static List<Login> findWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<Login> findWithDynamicQuery(DynamicQuery dynamicQuery,
        int start, int end) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<Login> findWithDynamicQuery(DynamicQuery dynamicQuery,
        int start, int end, OrderByComparator orderByComparator)
        throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static Login update(Login login) throws SystemException {
        return getPersistence().update(login);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static Login update(Login login, ServiceContext serviceContext)
        throws SystemException {
        return getPersistence().update(login, serviceContext);
    }

    /**
    * Returns the login where name = &#63; or throws a {@link io.gatling.liferay.NoSuchLoginException} if it could not be found.
    *
    * @param name the name
    * @return the matching login
    * @throws io.gatling.liferay.NoSuchLoginException if a matching login could not be found
    * @throws SystemException if a system exception occurred
    */
    public static io.gatling.liferay.model.Login findByName(
        java.lang.String name)
        throws com.liferay.portal.kernel.exception.SystemException,
            io.gatling.liferay.NoSuchLoginException {
        return getPersistence().findByName(name);
    }

    /**
    * Returns the login where name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param name the name
    * @return the matching login, or <code>null</code> if a matching login could not be found
    * @throws SystemException if a system exception occurred
    */
    public static io.gatling.liferay.model.Login fetchByName(
        java.lang.String name)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByName(name);
    }

    /**
    * Returns the login where name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param name the name
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching login, or <code>null</code> if a matching login could not be found
    * @throws SystemException if a system exception occurred
    */
    public static io.gatling.liferay.model.Login fetchByName(
        java.lang.String name, boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByName(name, retrieveFromCache);
    }

    /**
    * Removes the login where name = &#63; from the database.
    *
    * @param name the name
    * @return the login that was removed
    * @throws SystemException if a system exception occurred
    */
    public static io.gatling.liferay.model.Login removeByName(
        java.lang.String name)
        throws com.liferay.portal.kernel.exception.SystemException,
            io.gatling.liferay.NoSuchLoginException {
        return getPersistence().removeByName(name);
    }

    /**
    * Returns the number of logins where name = &#63;.
    *
    * @param name the name
    * @return the number of matching logins
    * @throws SystemException if a system exception occurred
    */
    public static int countByName(java.lang.String name)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByName(name);
    }

    /**
    * Caches the login in the entity cache if it is enabled.
    *
    * @param login the login
    */
    public static void cacheResult(io.gatling.liferay.model.Login login) {
        getPersistence().cacheResult(login);
    }

    /**
    * Caches the logins in the entity cache if it is enabled.
    *
    * @param logins the logins
    */
    public static void cacheResult(
        java.util.List<io.gatling.liferay.model.Login> logins) {
        getPersistence().cacheResult(logins);
    }

    /**
    * Creates a new login with the primary key. Does not add the login to the database.
    *
    * @param userId the primary key for the new login
    * @return the new login
    */
    public static io.gatling.liferay.model.Login create(long userId) {
        return getPersistence().create(userId);
    }

    /**
    * Removes the login with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param userId the primary key of the login
    * @return the login that was removed
    * @throws io.gatling.liferay.NoSuchLoginException if a login with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static io.gatling.liferay.model.Login remove(long userId)
        throws com.liferay.portal.kernel.exception.SystemException,
            io.gatling.liferay.NoSuchLoginException {
        return getPersistence().remove(userId);
    }

    public static io.gatling.liferay.model.Login updateImpl(
        io.gatling.liferay.model.Login login)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(login);
    }

    /**
    * Returns the login with the primary key or throws a {@link io.gatling.liferay.NoSuchLoginException} if it could not be found.
    *
    * @param userId the primary key of the login
    * @return the login
    * @throws io.gatling.liferay.NoSuchLoginException if a login with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static io.gatling.liferay.model.Login findByPrimaryKey(long userId)
        throws com.liferay.portal.kernel.exception.SystemException,
            io.gatling.liferay.NoSuchLoginException {
        return getPersistence().findByPrimaryKey(userId);
    }

    /**
    * Returns the login with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param userId the primary key of the login
    * @return the login, or <code>null</code> if a login with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static io.gatling.liferay.model.Login fetchByPrimaryKey(long userId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(userId);
    }

    /**
    * Returns all the logins.
    *
    * @return the logins
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<io.gatling.liferay.model.Login> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
    }

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
    public static java.util.List<io.gatling.liferay.model.Login> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

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
    public static java.util.List<io.gatling.liferay.model.Login> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the logins from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of logins.
    *
    * @return the number of logins
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static LoginPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (LoginPersistence) PortletBeanLocatorUtil.locate(io.gatling.liferay.service.ClpSerializer.getServletContextName(),
                    LoginPersistence.class.getName());

            ReferenceRegistry.registerReference(LoginUtil.class, "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(LoginPersistence persistence) {
    }
}
