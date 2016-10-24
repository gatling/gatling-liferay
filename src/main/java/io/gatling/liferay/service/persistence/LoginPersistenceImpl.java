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

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import io.gatling.liferay.NoSuchLoginException;
import io.gatling.liferay.model.Login;
import io.gatling.liferay.model.impl.LoginImpl;
import io.gatling.liferay.model.impl.LoginModelImpl;
import io.gatling.liferay.service.persistence.LoginPersistence;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the login service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LoginPersistence
 * @see LoginUtil
 * @generated
 */
public class LoginPersistenceImpl extends BasePersistenceImpl<Login>
    implements LoginPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link LoginUtil} to access the login persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = LoginImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LoginModelImpl.ENTITY_CACHE_ENABLED,
            LoginModelImpl.FINDER_CACHE_ENABLED, LoginImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LoginModelImpl.ENTITY_CACHE_ENABLED,
            LoginModelImpl.FINDER_CACHE_ENABLED, LoginImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LoginModelImpl.ENTITY_CACHE_ENABLED,
            LoginModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_FETCH_BY_NAME = new FinderPath(LoginModelImpl.ENTITY_CACHE_ENABLED,
            LoginModelImpl.FINDER_CACHE_ENABLED, LoginImpl.class,
            FINDER_CLASS_NAME_ENTITY, "fetchByName",
            new String[] { String.class.getName() },
            LoginModelImpl.NAME_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_NAME = new FinderPath(LoginModelImpl.ENTITY_CACHE_ENABLED,
            LoginModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByName",
            new String[] { String.class.getName() });
    private static final String _FINDER_COLUMN_NAME_NAME_1 = "login.name IS NULL";
    private static final String _FINDER_COLUMN_NAME_NAME_2 = "login.name = ?";
    private static final String _FINDER_COLUMN_NAME_NAME_3 = "(login.name IS NULL OR login.name = '')";
    private static final String _SQL_SELECT_LOGIN = "SELECT login FROM Login login";
    private static final String _SQL_SELECT_LOGIN_WHERE = "SELECT login FROM Login login WHERE ";
    private static final String _SQL_COUNT_LOGIN = "SELECT COUNT(login) FROM Login login";
    private static final String _SQL_COUNT_LOGIN_WHERE = "SELECT COUNT(login) FROM Login login WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "login.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Login exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Login exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(LoginPersistenceImpl.class);
    private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
                "data"
            });
    private static Login _nullLogin = new LoginImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<Login> toCacheModel() {
                return _nullLoginCacheModel;
            }
        };

    private static CacheModel<Login> _nullLoginCacheModel = new CacheModel<Login>() {
            @Override
            public Login toEntityModel() {
                return _nullLogin;
            }
        };

    public LoginPersistenceImpl() {
        setModelClass(Login.class);
    }

    /**
     * Returns the login where name = &#63; or throws a {@link io.gatling.liferay.NoSuchLoginException} if it could not be found.
     *
     * @param name the name
     * @return the matching login
     * @throws io.gatling.liferay.NoSuchLoginException if a matching login could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Login findByName(String name)
        throws NoSuchLoginException, SystemException {
        Login login = fetchByName(name);

        if (login == null) {
            StringBundler msg = new StringBundler(4);

            msg.append(_NO_SUCH_ENTITY_WITH_KEY);

            msg.append("name=");
            msg.append(name);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            if (_log.isWarnEnabled()) {
                _log.warn(msg.toString());
            }

            throw new NoSuchLoginException(msg.toString());
        }

        return login;
    }

    /**
     * Returns the login where name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
     *
     * @param name the name
     * @return the matching login, or <code>null</code> if a matching login could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Login fetchByName(String name) throws SystemException {
        return fetchByName(name, true);
    }

    /**
     * Returns the login where name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
     *
     * @param name the name
     * @param retrieveFromCache whether to use the finder cache
     * @return the matching login, or <code>null</code> if a matching login could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Login fetchByName(String name, boolean retrieveFromCache)
        throws SystemException {
        Object[] finderArgs = new Object[] { name };

        Object result = null;

        if (retrieveFromCache) {
            result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_NAME,
                    finderArgs, this);
        }

        if (result instanceof Login) {
            Login login = (Login) result;

            if (!Validator.equals(name, login.getName())) {
                result = null;
            }
        }

        if (result == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_SELECT_LOGIN_WHERE);

            boolean bindName = false;

            if (name == null) {
                query.append(_FINDER_COLUMN_NAME_NAME_1);
            } else if (name.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_NAME_NAME_3);
            } else {
                bindName = true;

                query.append(_FINDER_COLUMN_NAME_NAME_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindName) {
                    qPos.add(name);
                }

                List<Login> list = q.list();

                if (list.isEmpty()) {
                    FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAME,
                        finderArgs, list);
                } else {
                    Login login = list.get(0);

                    result = login;

                    cacheResult(login);

                    if ((login.getName() == null) ||
                            !login.getName().equals(name)) {
                        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAME,
                            finderArgs, login);
                    }
                }
            } catch (Exception e) {
                FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_NAME,
                    finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        if (result instanceof List<?>) {
            return null;
        } else {
            return (Login) result;
        }
    }

    /**
     * Removes the login where name = &#63; from the database.
     *
     * @param name the name
     * @return the login that was removed
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Login removeByName(String name)
        throws NoSuchLoginException, SystemException {
        Login login = findByName(name);

        return remove(login);
    }

    /**
     * Returns the number of logins where name = &#63;.
     *
     * @param name the name
     * @return the number of matching logins
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByName(String name) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_NAME;

        Object[] finderArgs = new Object[] { name };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_LOGIN_WHERE);

            boolean bindName = false;

            if (name == null) {
                query.append(_FINDER_COLUMN_NAME_NAME_1);
            } else if (name.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_NAME_NAME_3);
            } else {
                bindName = true;

                query.append(_FINDER_COLUMN_NAME_NAME_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindName) {
                    qPos.add(name);
                }

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(finderPath, finderArgs, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Caches the login in the entity cache if it is enabled.
     *
     * @param login the login
     */
    @Override
    public void cacheResult(Login login) {
        EntityCacheUtil.putResult(LoginModelImpl.ENTITY_CACHE_ENABLED,
            LoginImpl.class, login.getPrimaryKey(), login);

        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAME,
            new Object[] { login.getName() }, login);

        login.resetOriginalValues();
    }

    /**
     * Caches the logins in the entity cache if it is enabled.
     *
     * @param logins the logins
     */
    @Override
    public void cacheResult(List<Login> logins) {
        for (Login login : logins) {
            if (EntityCacheUtil.getResult(LoginModelImpl.ENTITY_CACHE_ENABLED,
                        LoginImpl.class, login.getPrimaryKey()) == null) {
                cacheResult(login);
            } else {
                login.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all logins.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(LoginImpl.class.getName());
        }

        EntityCacheUtil.clearCache(LoginImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the login.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(Login login) {
        EntityCacheUtil.removeResult(LoginModelImpl.ENTITY_CACHE_ENABLED,
            LoginImpl.class, login.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        clearUniqueFindersCache(login);
    }

    @Override
    public void clearCache(List<Login> logins) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (Login login : logins) {
            EntityCacheUtil.removeResult(LoginModelImpl.ENTITY_CACHE_ENABLED,
                LoginImpl.class, login.getPrimaryKey());

            clearUniqueFindersCache(login);
        }
    }

    protected void cacheUniqueFindersCache(Login login) {
        if (login.isNew()) {
            Object[] args = new Object[] { login.getName() };

            FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_NAME, args,
                Long.valueOf(1));
            FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAME, args, login);
        } else {
            LoginModelImpl loginModelImpl = (LoginModelImpl) login;

            if ((loginModelImpl.getColumnBitmask() &
                    FINDER_PATH_FETCH_BY_NAME.getColumnBitmask()) != 0) {
                Object[] args = new Object[] { login.getName() };

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_NAME, args,
                    Long.valueOf(1));
                FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAME, args, login);
            }
        }
    }

    protected void clearUniqueFindersCache(Login login) {
        LoginModelImpl loginModelImpl = (LoginModelImpl) login;

        Object[] args = new Object[] { login.getName() };

        FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NAME, args);
        FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_NAME, args);

        if ((loginModelImpl.getColumnBitmask() &
                FINDER_PATH_FETCH_BY_NAME.getColumnBitmask()) != 0) {
            args = new Object[] { loginModelImpl.getOriginalName() };

            FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NAME, args);
            FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_NAME, args);
        }
    }

    /**
     * Creates a new login with the primary key. Does not add the login to the database.
     *
     * @param userId the primary key for the new login
     * @return the new login
     */
    @Override
    public Login create(long userId) {
        Login login = new LoginImpl();

        login.setNew(true);
        login.setPrimaryKey(userId);

        return login;
    }

    /**
     * Removes the login with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param userId the primary key of the login
     * @return the login that was removed
     * @throws io.gatling.liferay.NoSuchLoginException if a login with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Login remove(long userId)
        throws NoSuchLoginException, SystemException {
        return remove((Serializable) userId);
    }

    /**
     * Removes the login with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the login
     * @return the login that was removed
     * @throws io.gatling.liferay.NoSuchLoginException if a login with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Login remove(Serializable primaryKey)
        throws NoSuchLoginException, SystemException {
        Session session = null;

        try {
            session = openSession();

            Login login = (Login) session.get(LoginImpl.class, primaryKey);

            if (login == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchLoginException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(login);
        } catch (NoSuchLoginException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected Login removeImpl(Login login) throws SystemException {
        login = toUnwrappedModel(login);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(login)) {
                login = (Login) session.get(LoginImpl.class,
                        login.getPrimaryKeyObj());
            }

            if (login != null) {
                session.delete(login);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (login != null) {
            clearCache(login);
        }

        return login;
    }

    @Override
    public Login updateImpl(io.gatling.liferay.model.Login login)
        throws SystemException {
        login = toUnwrappedModel(login);

        boolean isNew = login.isNew();

        Session session = null;

        try {
            session = openSession();

            if (login.isNew()) {
                session.save(login);

                login.setNew(false);
            } else {
                session.merge(login);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !LoginModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }

        EntityCacheUtil.putResult(LoginModelImpl.ENTITY_CACHE_ENABLED,
            LoginImpl.class, login.getPrimaryKey(), login);

        clearUniqueFindersCache(login);
        cacheUniqueFindersCache(login);

        return login;
    }

    protected Login toUnwrappedModel(Login login) {
        if (login instanceof LoginImpl) {
            return login;
        }

        LoginImpl loginImpl = new LoginImpl();

        loginImpl.setNew(login.isNew());
        loginImpl.setPrimaryKey(login.getPrimaryKey());

        loginImpl.setUserId(login.getUserId());
        loginImpl.setName(login.getName());
        loginImpl.setData(login.getData());

        return loginImpl;
    }

    /**
     * Returns the login with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the login
     * @return the login
     * @throws io.gatling.liferay.NoSuchLoginException if a login with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Login findByPrimaryKey(Serializable primaryKey)
        throws NoSuchLoginException, SystemException {
        Login login = fetchByPrimaryKey(primaryKey);

        if (login == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchLoginException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return login;
    }

    /**
     * Returns the login with the primary key or throws a {@link io.gatling.liferay.NoSuchLoginException} if it could not be found.
     *
     * @param userId the primary key of the login
     * @return the login
     * @throws io.gatling.liferay.NoSuchLoginException if a login with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Login findByPrimaryKey(long userId)
        throws NoSuchLoginException, SystemException {
        return findByPrimaryKey((Serializable) userId);
    }

    /**
     * Returns the login with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the login
     * @return the login, or <code>null</code> if a login with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Login fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        Login login = (Login) EntityCacheUtil.getResult(LoginModelImpl.ENTITY_CACHE_ENABLED,
                LoginImpl.class, primaryKey);

        if (login == _nullLogin) {
            return null;
        }

        if (login == null) {
            Session session = null;

            try {
                session = openSession();

                login = (Login) session.get(LoginImpl.class, primaryKey);

                if (login != null) {
                    cacheResult(login);
                } else {
                    EntityCacheUtil.putResult(LoginModelImpl.ENTITY_CACHE_ENABLED,
                        LoginImpl.class, primaryKey, _nullLogin);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(LoginModelImpl.ENTITY_CACHE_ENABLED,
                    LoginImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return login;
    }

    /**
     * Returns the login with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param userId the primary key of the login
     * @return the login, or <code>null</code> if a login with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Login fetchByPrimaryKey(long userId) throws SystemException {
        return fetchByPrimaryKey((Serializable) userId);
    }

    /**
     * Returns all the logins.
     *
     * @return the logins
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Login> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
    @Override
    public List<Login> findAll(int start, int end) throws SystemException {
        return findAll(start, end, null);
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
    @Override
    public List<Login> findAll(int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
            finderArgs = FINDER_ARGS_EMPTY;
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
            finderArgs = new Object[] { start, end, orderByComparator };
        }

        List<Login> list = (List<Login>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_LOGIN);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_LOGIN;

                if (pagination) {
                    sql = sql.concat(LoginModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<Login>) QueryUtil.list(q, getDialect(), start,
                            end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Login>(list);
                } else {
                    list = (List<Login>) QueryUtil.list(q, getDialect(), start,
                            end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
    }

    /**
     * Removes all the logins from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (Login login : findAll()) {
            remove(login);
        }
    }

    /**
     * Returns the number of logins.
     *
     * @return the number of logins
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countAll() throws SystemException {
        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
                FINDER_ARGS_EMPTY, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(_SQL_COUNT_LOGIN);

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
                    FINDER_ARGS_EMPTY, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
                    FINDER_ARGS_EMPTY);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    @Override
    protected Set<String> getBadColumnNames() {
        return _badColumnNames;
    }

    /**
     * Initializes the login persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.io.gatling.liferay.model.Login")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<Login>> listenersList = new ArrayList<ModelListener<Login>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<Login>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(LoginImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
