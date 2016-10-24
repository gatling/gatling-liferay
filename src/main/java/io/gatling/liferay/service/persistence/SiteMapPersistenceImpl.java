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
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import io.gatling.liferay.NoSuchSiteMapException;
import io.gatling.liferay.model.SiteMap;
import io.gatling.liferay.model.impl.SiteMapImpl;
import io.gatling.liferay.model.impl.SiteMapModelImpl;
import io.gatling.liferay.service.persistence.SiteMapPersistence;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the site map service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SiteMapPersistence
 * @see SiteMapUtil
 * @generated
 */
public class SiteMapPersistenceImpl extends BasePersistenceImpl<SiteMap>
    implements SiteMapPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link SiteMapUtil} to access the site map persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = SiteMapImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SiteMapModelImpl.ENTITY_CACHE_ENABLED,
            SiteMapModelImpl.FINDER_CACHE_ENABLED, SiteMapImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SiteMapModelImpl.ENTITY_CACHE_ENABLED,
            SiteMapModelImpl.FINDER_CACHE_ENABLED, SiteMapImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SiteMapModelImpl.ENTITY_CACHE_ENABLED,
            SiteMapModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_FETCH_BY_NAME = new FinderPath(SiteMapModelImpl.ENTITY_CACHE_ENABLED,
            SiteMapModelImpl.FINDER_CACHE_ENABLED, SiteMapImpl.class,
            FINDER_CLASS_NAME_ENTITY, "fetchByName",
            new String[] { String.class.getName() },
            SiteMapModelImpl.NAME_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_NAME = new FinderPath(SiteMapModelImpl.ENTITY_CACHE_ENABLED,
            SiteMapModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByName",
            new String[] { String.class.getName() });
    private static final String _FINDER_COLUMN_NAME_NAME_1 = "siteMap.name IS NULL";
    private static final String _FINDER_COLUMN_NAME_NAME_2 = "siteMap.name = ?";
    private static final String _FINDER_COLUMN_NAME_NAME_3 = "(siteMap.name IS NULL OR siteMap.name = '')";
    private static final String _SQL_SELECT_SITEMAP = "SELECT siteMap FROM SiteMap siteMap";
    private static final String _SQL_SELECT_SITEMAP_WHERE = "SELECT siteMap FROM SiteMap siteMap WHERE ";
    private static final String _SQL_COUNT_SITEMAP = "SELECT COUNT(siteMap) FROM SiteMap siteMap";
    private static final String _SQL_COUNT_SITEMAP_WHERE = "SELECT COUNT(siteMap) FROM SiteMap siteMap WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "siteMap.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No SiteMap exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No SiteMap exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(SiteMapPersistenceImpl.class);
    private static SiteMap _nullSiteMap = new SiteMapImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<SiteMap> toCacheModel() {
                return _nullSiteMapCacheModel;
            }
        };

    private static CacheModel<SiteMap> _nullSiteMapCacheModel = new CacheModel<SiteMap>() {
            @Override
            public SiteMap toEntityModel() {
                return _nullSiteMap;
            }
        };

    public SiteMapPersistenceImpl() {
        setModelClass(SiteMap.class);
    }

    /**
     * Returns the site map where name = &#63; or throws a {@link io.gatling.liferay.NoSuchSiteMapException} if it could not be found.
     *
     * @param name the name
     * @return the matching site map
     * @throws io.gatling.liferay.NoSuchSiteMapException if a matching site map could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public SiteMap findByName(String name)
        throws NoSuchSiteMapException, SystemException {
        SiteMap siteMap = fetchByName(name);

        if (siteMap == null) {
            StringBundler msg = new StringBundler(4);

            msg.append(_NO_SUCH_ENTITY_WITH_KEY);

            msg.append("name=");
            msg.append(name);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            if (_log.isWarnEnabled()) {
                _log.warn(msg.toString());
            }

            throw new NoSuchSiteMapException(msg.toString());
        }

        return siteMap;
    }

    /**
     * Returns the site map where name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
     *
     * @param name the name
     * @return the matching site map, or <code>null</code> if a matching site map could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public SiteMap fetchByName(String name) throws SystemException {
        return fetchByName(name, true);
    }

    /**
     * Returns the site map where name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
     *
     * @param name the name
     * @param retrieveFromCache whether to use the finder cache
     * @return the matching site map, or <code>null</code> if a matching site map could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public SiteMap fetchByName(String name, boolean retrieveFromCache)
        throws SystemException {
        Object[] finderArgs = new Object[] { name };

        Object result = null;

        if (retrieveFromCache) {
            result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_NAME,
                    finderArgs, this);
        }

        if (result instanceof SiteMap) {
            SiteMap siteMap = (SiteMap) result;

            if (!Validator.equals(name, siteMap.getName())) {
                result = null;
            }
        }

        if (result == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_SELECT_SITEMAP_WHERE);

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

                List<SiteMap> list = q.list();

                if (list.isEmpty()) {
                    FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAME,
                        finderArgs, list);
                } else {
                    SiteMap siteMap = list.get(0);

                    result = siteMap;

                    cacheResult(siteMap);

                    if ((siteMap.getName() == null) ||
                            !siteMap.getName().equals(name)) {
                        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAME,
                            finderArgs, siteMap);
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
            return (SiteMap) result;
        }
    }

    /**
     * Removes the site map where name = &#63; from the database.
     *
     * @param name the name
     * @return the site map that was removed
     * @throws SystemException if a system exception occurred
     */
    @Override
    public SiteMap removeByName(String name)
        throws NoSuchSiteMapException, SystemException {
        SiteMap siteMap = findByName(name);

        return remove(siteMap);
    }

    /**
     * Returns the number of site maps where name = &#63;.
     *
     * @param name the name
     * @return the number of matching site maps
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

            query.append(_SQL_COUNT_SITEMAP_WHERE);

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
     * Caches the site map in the entity cache if it is enabled.
     *
     * @param siteMap the site map
     */
    @Override
    public void cacheResult(SiteMap siteMap) {
        EntityCacheUtil.putResult(SiteMapModelImpl.ENTITY_CACHE_ENABLED,
            SiteMapImpl.class, siteMap.getPrimaryKey(), siteMap);

        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAME,
            new Object[] { siteMap.getName() }, siteMap);

        siteMap.resetOriginalValues();
    }

    /**
     * Caches the site maps in the entity cache if it is enabled.
     *
     * @param siteMaps the site maps
     */
    @Override
    public void cacheResult(List<SiteMap> siteMaps) {
        for (SiteMap siteMap : siteMaps) {
            if (EntityCacheUtil.getResult(
                        SiteMapModelImpl.ENTITY_CACHE_ENABLED,
                        SiteMapImpl.class, siteMap.getPrimaryKey()) == null) {
                cacheResult(siteMap);
            } else {
                siteMap.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all site maps.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(SiteMapImpl.class.getName());
        }

        EntityCacheUtil.clearCache(SiteMapImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the site map.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(SiteMap siteMap) {
        EntityCacheUtil.removeResult(SiteMapModelImpl.ENTITY_CACHE_ENABLED,
            SiteMapImpl.class, siteMap.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        clearUniqueFindersCache(siteMap);
    }

    @Override
    public void clearCache(List<SiteMap> siteMaps) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (SiteMap siteMap : siteMaps) {
            EntityCacheUtil.removeResult(SiteMapModelImpl.ENTITY_CACHE_ENABLED,
                SiteMapImpl.class, siteMap.getPrimaryKey());

            clearUniqueFindersCache(siteMap);
        }
    }

    protected void cacheUniqueFindersCache(SiteMap siteMap) {
        if (siteMap.isNew()) {
            Object[] args = new Object[] { siteMap.getName() };

            FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_NAME, args,
                Long.valueOf(1));
            FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAME, args, siteMap);
        } else {
            SiteMapModelImpl siteMapModelImpl = (SiteMapModelImpl) siteMap;

            if ((siteMapModelImpl.getColumnBitmask() &
                    FINDER_PATH_FETCH_BY_NAME.getColumnBitmask()) != 0) {
                Object[] args = new Object[] { siteMap.getName() };

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_NAME, args,
                    Long.valueOf(1));
                FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAME, args,
                    siteMap);
            }
        }
    }

    protected void clearUniqueFindersCache(SiteMap siteMap) {
        SiteMapModelImpl siteMapModelImpl = (SiteMapModelImpl) siteMap;

        Object[] args = new Object[] { siteMap.getName() };

        FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NAME, args);
        FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_NAME, args);

        if ((siteMapModelImpl.getColumnBitmask() &
                FINDER_PATH_FETCH_BY_NAME.getColumnBitmask()) != 0) {
            args = new Object[] { siteMapModelImpl.getOriginalName() };

            FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NAME, args);
            FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_NAME, args);
        }
    }

    /**
     * Creates a new site map with the primary key. Does not add the site map to the database.
     *
     * @param siteMapId the primary key for the new site map
     * @return the new site map
     */
    @Override
    public SiteMap create(long siteMapId) {
        SiteMap siteMap = new SiteMapImpl();

        siteMap.setNew(true);
        siteMap.setPrimaryKey(siteMapId);

        return siteMap;
    }

    /**
     * Removes the site map with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param siteMapId the primary key of the site map
     * @return the site map that was removed
     * @throws io.gatling.liferay.NoSuchSiteMapException if a site map with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public SiteMap remove(long siteMapId)
        throws NoSuchSiteMapException, SystemException {
        return remove((Serializable) siteMapId);
    }

    /**
     * Removes the site map with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the site map
     * @return the site map that was removed
     * @throws io.gatling.liferay.NoSuchSiteMapException if a site map with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public SiteMap remove(Serializable primaryKey)
        throws NoSuchSiteMapException, SystemException {
        Session session = null;

        try {
            session = openSession();

            SiteMap siteMap = (SiteMap) session.get(SiteMapImpl.class,
                    primaryKey);

            if (siteMap == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchSiteMapException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(siteMap);
        } catch (NoSuchSiteMapException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected SiteMap removeImpl(SiteMap siteMap) throws SystemException {
        siteMap = toUnwrappedModel(siteMap);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(siteMap)) {
                siteMap = (SiteMap) session.get(SiteMapImpl.class,
                        siteMap.getPrimaryKeyObj());
            }

            if (siteMap != null) {
                session.delete(siteMap);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (siteMap != null) {
            clearCache(siteMap);
        }

        return siteMap;
    }

    @Override
    public SiteMap updateImpl(io.gatling.liferay.model.SiteMap siteMap)
        throws SystemException {
        siteMap = toUnwrappedModel(siteMap);

        boolean isNew = siteMap.isNew();

        Session session = null;

        try {
            session = openSession();

            if (siteMap.isNew()) {
                session.save(siteMap);

                siteMap.setNew(false);
            } else {
                session.merge(siteMap);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !SiteMapModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }

        EntityCacheUtil.putResult(SiteMapModelImpl.ENTITY_CACHE_ENABLED,
            SiteMapImpl.class, siteMap.getPrimaryKey(), siteMap);

        clearUniqueFindersCache(siteMap);
        cacheUniqueFindersCache(siteMap);

        return siteMap;
    }

    protected SiteMap toUnwrappedModel(SiteMap siteMap) {
        if (siteMap instanceof SiteMapImpl) {
            return siteMap;
        }

        SiteMapImpl siteMapImpl = new SiteMapImpl();

        siteMapImpl.setNew(siteMap.isNew());
        siteMapImpl.setPrimaryKey(siteMap.getPrimaryKey());

        siteMapImpl.setSiteMapId(siteMap.getSiteMapId());
        siteMapImpl.setName(siteMap.getName());

        return siteMapImpl;
    }

    /**
     * Returns the site map with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the site map
     * @return the site map
     * @throws io.gatling.liferay.NoSuchSiteMapException if a site map with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public SiteMap findByPrimaryKey(Serializable primaryKey)
        throws NoSuchSiteMapException, SystemException {
        SiteMap siteMap = fetchByPrimaryKey(primaryKey);

        if (siteMap == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchSiteMapException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return siteMap;
    }

    /**
     * Returns the site map with the primary key or throws a {@link io.gatling.liferay.NoSuchSiteMapException} if it could not be found.
     *
     * @param siteMapId the primary key of the site map
     * @return the site map
     * @throws io.gatling.liferay.NoSuchSiteMapException if a site map with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public SiteMap findByPrimaryKey(long siteMapId)
        throws NoSuchSiteMapException, SystemException {
        return findByPrimaryKey((Serializable) siteMapId);
    }

    /**
     * Returns the site map with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the site map
     * @return the site map, or <code>null</code> if a site map with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public SiteMap fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        SiteMap siteMap = (SiteMap) EntityCacheUtil.getResult(SiteMapModelImpl.ENTITY_CACHE_ENABLED,
                SiteMapImpl.class, primaryKey);

        if (siteMap == _nullSiteMap) {
            return null;
        }

        if (siteMap == null) {
            Session session = null;

            try {
                session = openSession();

                siteMap = (SiteMap) session.get(SiteMapImpl.class, primaryKey);

                if (siteMap != null) {
                    cacheResult(siteMap);
                } else {
                    EntityCacheUtil.putResult(SiteMapModelImpl.ENTITY_CACHE_ENABLED,
                        SiteMapImpl.class, primaryKey, _nullSiteMap);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(SiteMapModelImpl.ENTITY_CACHE_ENABLED,
                    SiteMapImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return siteMap;
    }

    /**
     * Returns the site map with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param siteMapId the primary key of the site map
     * @return the site map, or <code>null</code> if a site map with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public SiteMap fetchByPrimaryKey(long siteMapId) throws SystemException {
        return fetchByPrimaryKey((Serializable) siteMapId);
    }

    /**
     * Returns all the site maps.
     *
     * @return the site maps
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<SiteMap> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the site maps.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link io.gatling.liferay.model.impl.SiteMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of site maps
     * @param end the upper bound of the range of site maps (not inclusive)
     * @return the range of site maps
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<SiteMap> findAll(int start, int end) throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the site maps.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link io.gatling.liferay.model.impl.SiteMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of site maps
     * @param end the upper bound of the range of site maps (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of site maps
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<SiteMap> findAll(int start, int end,
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

        List<SiteMap> list = (List<SiteMap>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_SITEMAP);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_SITEMAP;

                if (pagination) {
                    sql = sql.concat(SiteMapModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<SiteMap>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<SiteMap>(list);
                } else {
                    list = (List<SiteMap>) QueryUtil.list(q, getDialect(),
                            start, end);
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
     * Removes all the site maps from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (SiteMap siteMap : findAll()) {
            remove(siteMap);
        }
    }

    /**
     * Returns the number of site maps.
     *
     * @return the number of site maps
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

                Query q = session.createQuery(_SQL_COUNT_SITEMAP);

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

    /**
     * Initializes the site map persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.io.gatling.liferay.model.SiteMap")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<SiteMap>> listenersList = new ArrayList<ModelListener<SiteMap>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<SiteMap>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(SiteMapImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
