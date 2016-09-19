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
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import io.gatling.liferay.NoSuchUrlRecordException;
import io.gatling.liferay.model.UrlRecord;
import io.gatling.liferay.model.impl.UrlRecordImpl;
import io.gatling.liferay.model.impl.UrlRecordModelImpl;
import io.gatling.liferay.service.persistence.UrlRecordPersistence;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the url record service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UrlRecordPersistence
 * @see UrlRecordUtil
 * @generated
 */
public class UrlRecordPersistenceImpl extends BasePersistenceImpl<UrlRecord>
    implements UrlRecordPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link UrlRecordUtil} to access the url record persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = UrlRecordImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(UrlRecordModelImpl.ENTITY_CACHE_ENABLED,
            UrlRecordModelImpl.FINDER_CACHE_ENABLED, UrlRecordImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(UrlRecordModelImpl.ENTITY_CACHE_ENABLED,
            UrlRecordModelImpl.FINDER_CACHE_ENABLED, UrlRecordImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(UrlRecordModelImpl.ENTITY_CACHE_ENABLED,
            UrlRecordModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_RECORDID = new FinderPath(UrlRecordModelImpl.ENTITY_CACHE_ENABLED,
            UrlRecordModelImpl.FINDER_CACHE_ENABLED, UrlRecordImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByRecordId",
            new String[] {
                Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RECORDID =
        new FinderPath(UrlRecordModelImpl.ENTITY_CACHE_ENABLED,
            UrlRecordModelImpl.FINDER_CACHE_ENABLED, UrlRecordImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByRecordId",
            new String[] { Long.class.getName() },
            UrlRecordModelImpl.RECORDID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_RECORDID = new FinderPath(UrlRecordModelImpl.ENTITY_CACHE_ENABLED,
            UrlRecordModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByRecordId",
            new String[] { Long.class.getName() });
    private static final String _FINDER_COLUMN_RECORDID_RECORDID_2 = "urlRecord.recordId = ?";
    private static final String _SQL_SELECT_URLRECORD = "SELECT urlRecord FROM UrlRecord urlRecord";
    private static final String _SQL_SELECT_URLRECORD_WHERE = "SELECT urlRecord FROM UrlRecord urlRecord WHERE ";
    private static final String _SQL_COUNT_URLRECORD = "SELECT COUNT(urlRecord) FROM UrlRecord urlRecord";
    private static final String _SQL_COUNT_URLRECORD_WHERE = "SELECT COUNT(urlRecord) FROM UrlRecord urlRecord WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "urlRecord.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No UrlRecord exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No UrlRecord exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(UrlRecordPersistenceImpl.class);
    private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
                "type", "order"
            });
    private static UrlRecord _nullUrlRecord = new UrlRecordImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<UrlRecord> toCacheModel() {
                return _nullUrlRecordCacheModel;
            }
        };

    private static CacheModel<UrlRecord> _nullUrlRecordCacheModel = new CacheModel<UrlRecord>() {
            @Override
            public UrlRecord toEntityModel() {
                return _nullUrlRecord;
            }
        };

    public UrlRecordPersistenceImpl() {
        setModelClass(UrlRecord.class);
    }

    /**
     * Returns all the url records where recordId = &#63;.
     *
     * @param recordId the record ID
     * @return the matching url records
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<UrlRecord> findByRecordId(long recordId)
        throws SystemException {
        return findByRecordId(recordId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
            null);
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
    @Override
    public List<UrlRecord> findByRecordId(long recordId, int start, int end)
        throws SystemException {
        return findByRecordId(recordId, start, end, null);
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
    @Override
    public List<UrlRecord> findByRecordId(long recordId, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RECORDID;
            finderArgs = new Object[] { recordId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_RECORDID;
            finderArgs = new Object[] { recordId, start, end, orderByComparator };
        }

        List<UrlRecord> list = (List<UrlRecord>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (UrlRecord urlRecord : list) {
                if ((recordId != urlRecord.getRecordId())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(3 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(3);
            }

            query.append(_SQL_SELECT_URLRECORD_WHERE);

            query.append(_FINDER_COLUMN_RECORDID_RECORDID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(UrlRecordModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(recordId);

                if (!pagination) {
                    list = (List<UrlRecord>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<UrlRecord>(list);
                } else {
                    list = (List<UrlRecord>) QueryUtil.list(q, getDialect(),
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
     * Returns the first url record in the ordered set where recordId = &#63;.
     *
     * @param recordId the record ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching url record
     * @throws io.gatling.liferay.NoSuchUrlRecordException if a matching url record could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public UrlRecord findByRecordId_First(long recordId,
        OrderByComparator orderByComparator)
        throws NoSuchUrlRecordException, SystemException {
        UrlRecord urlRecord = fetchByRecordId_First(recordId, orderByComparator);

        if (urlRecord != null) {
            return urlRecord;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("recordId=");
        msg.append(recordId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchUrlRecordException(msg.toString());
    }

    /**
     * Returns the first url record in the ordered set where recordId = &#63;.
     *
     * @param recordId the record ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching url record, or <code>null</code> if a matching url record could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public UrlRecord fetchByRecordId_First(long recordId,
        OrderByComparator orderByComparator) throws SystemException {
        List<UrlRecord> list = findByRecordId(recordId, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    @Override
    public UrlRecord findByRecordId_Last(long recordId,
        OrderByComparator orderByComparator)
        throws NoSuchUrlRecordException, SystemException {
        UrlRecord urlRecord = fetchByRecordId_Last(recordId, orderByComparator);

        if (urlRecord != null) {
            return urlRecord;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("recordId=");
        msg.append(recordId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchUrlRecordException(msg.toString());
    }

    /**
     * Returns the last url record in the ordered set where recordId = &#63;.
     *
     * @param recordId the record ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching url record, or <code>null</code> if a matching url record could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public UrlRecord fetchByRecordId_Last(long recordId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByRecordId(recordId);

        if (count == 0) {
            return null;
        }

        List<UrlRecord> list = findByRecordId(recordId, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    @Override
    public UrlRecord[] findByRecordId_PrevAndNext(long urlRecordId,
        long recordId, OrderByComparator orderByComparator)
        throws NoSuchUrlRecordException, SystemException {
        UrlRecord urlRecord = findByPrimaryKey(urlRecordId);

        Session session = null;

        try {
            session = openSession();

            UrlRecord[] array = new UrlRecordImpl[3];

            array[0] = getByRecordId_PrevAndNext(session, urlRecord, recordId,
                    orderByComparator, true);

            array[1] = urlRecord;

            array[2] = getByRecordId_PrevAndNext(session, urlRecord, recordId,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected UrlRecord getByRecordId_PrevAndNext(Session session,
        UrlRecord urlRecord, long recordId,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_URLRECORD_WHERE);

        query.append(_FINDER_COLUMN_RECORDID_RECORDID_2);

        if (orderByComparator != null) {
            String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

            if (orderByConditionFields.length > 0) {
                query.append(WHERE_AND);
            }

            for (int i = 0; i < orderByConditionFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByConditionFields[i]);

                if ((i + 1) < orderByConditionFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN_HAS_NEXT);
                    } else {
                        query.append(WHERE_LESSER_THAN_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN);
                    } else {
                        query.append(WHERE_LESSER_THAN);
                    }
                }
            }

            query.append(ORDER_BY_CLAUSE);

            String[] orderByFields = orderByComparator.getOrderByFields();

            for (int i = 0; i < orderByFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByFields[i]);

                if ((i + 1) < orderByFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC_HAS_NEXT);
                    } else {
                        query.append(ORDER_BY_DESC_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC);
                    } else {
                        query.append(ORDER_BY_DESC);
                    }
                }
            }
        } else {
            query.append(UrlRecordModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(recordId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(urlRecord);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<UrlRecord> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the url records where recordId = &#63; from the database.
     *
     * @param recordId the record ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByRecordId(long recordId) throws SystemException {
        for (UrlRecord urlRecord : findByRecordId(recordId, QueryUtil.ALL_POS,
                QueryUtil.ALL_POS, null)) {
            remove(urlRecord);
        }
    }

    /**
     * Returns the number of url records where recordId = &#63;.
     *
     * @param recordId the record ID
     * @return the number of matching url records
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByRecordId(long recordId) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_RECORDID;

        Object[] finderArgs = new Object[] { recordId };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_URLRECORD_WHERE);

            query.append(_FINDER_COLUMN_RECORDID_RECORDID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(recordId);

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
     * Caches the url record in the entity cache if it is enabled.
     *
     * @param urlRecord the url record
     */
    @Override
    public void cacheResult(UrlRecord urlRecord) {
        EntityCacheUtil.putResult(UrlRecordModelImpl.ENTITY_CACHE_ENABLED,
            UrlRecordImpl.class, urlRecord.getPrimaryKey(), urlRecord);

        urlRecord.resetOriginalValues();
    }

    /**
     * Caches the url records in the entity cache if it is enabled.
     *
     * @param urlRecords the url records
     */
    @Override
    public void cacheResult(List<UrlRecord> urlRecords) {
        for (UrlRecord urlRecord : urlRecords) {
            if (EntityCacheUtil.getResult(
                        UrlRecordModelImpl.ENTITY_CACHE_ENABLED,
                        UrlRecordImpl.class, urlRecord.getPrimaryKey()) == null) {
                cacheResult(urlRecord);
            } else {
                urlRecord.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all url records.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(UrlRecordImpl.class.getName());
        }

        EntityCacheUtil.clearCache(UrlRecordImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the url record.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(UrlRecord urlRecord) {
        EntityCacheUtil.removeResult(UrlRecordModelImpl.ENTITY_CACHE_ENABLED,
            UrlRecordImpl.class, urlRecord.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<UrlRecord> urlRecords) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (UrlRecord urlRecord : urlRecords) {
            EntityCacheUtil.removeResult(UrlRecordModelImpl.ENTITY_CACHE_ENABLED,
                UrlRecordImpl.class, urlRecord.getPrimaryKey());
        }
    }

    /**
     * Creates a new url record with the primary key. Does not add the url record to the database.
     *
     * @param urlRecordId the primary key for the new url record
     * @return the new url record
     */
    @Override
    public UrlRecord create(long urlRecordId) {
        UrlRecord urlRecord = new UrlRecordImpl();

        urlRecord.setNew(true);
        urlRecord.setPrimaryKey(urlRecordId);

        return urlRecord;
    }

    /**
     * Removes the url record with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param urlRecordId the primary key of the url record
     * @return the url record that was removed
     * @throws io.gatling.liferay.NoSuchUrlRecordException if a url record with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public UrlRecord remove(long urlRecordId)
        throws NoSuchUrlRecordException, SystemException {
        return remove((Serializable) urlRecordId);
    }

    /**
     * Removes the url record with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the url record
     * @return the url record that was removed
     * @throws io.gatling.liferay.NoSuchUrlRecordException if a url record with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public UrlRecord remove(Serializable primaryKey)
        throws NoSuchUrlRecordException, SystemException {
        Session session = null;

        try {
            session = openSession();

            UrlRecord urlRecord = (UrlRecord) session.get(UrlRecordImpl.class,
                    primaryKey);

            if (urlRecord == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchUrlRecordException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(urlRecord);
        } catch (NoSuchUrlRecordException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected UrlRecord removeImpl(UrlRecord urlRecord)
        throws SystemException {
        urlRecord = toUnwrappedModel(urlRecord);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(urlRecord)) {
                urlRecord = (UrlRecord) session.get(UrlRecordImpl.class,
                        urlRecord.getPrimaryKeyObj());
            }

            if (urlRecord != null) {
                session.delete(urlRecord);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (urlRecord != null) {
            clearCache(urlRecord);
        }

        return urlRecord;
    }

    @Override
    public UrlRecord updateImpl(io.gatling.liferay.model.UrlRecord urlRecord)
        throws SystemException {
        urlRecord = toUnwrappedModel(urlRecord);

        boolean isNew = urlRecord.isNew();

        UrlRecordModelImpl urlRecordModelImpl = (UrlRecordModelImpl) urlRecord;

        Session session = null;

        try {
            session = openSession();

            if (urlRecord.isNew()) {
                session.save(urlRecord);

                urlRecord.setNew(false);
            } else {
                session.merge(urlRecord);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !UrlRecordModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((urlRecordModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RECORDID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        urlRecordModelImpl.getOriginalRecordId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_RECORDID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RECORDID,
                    args);

                args = new Object[] { urlRecordModelImpl.getRecordId() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_RECORDID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RECORDID,
                    args);
            }
        }

        EntityCacheUtil.putResult(UrlRecordModelImpl.ENTITY_CACHE_ENABLED,
            UrlRecordImpl.class, urlRecord.getPrimaryKey(), urlRecord);

        return urlRecord;
    }

    protected UrlRecord toUnwrappedModel(UrlRecord urlRecord) {
        if (urlRecord instanceof UrlRecordImpl) {
            return urlRecord;
        }

        UrlRecordImpl urlRecordImpl = new UrlRecordImpl();

        urlRecordImpl.setNew(urlRecord.isNew());
        urlRecordImpl.setPrimaryKey(urlRecord.getPrimaryKey());

        urlRecordImpl.setUrlRecordId(urlRecord.getUrlRecordId());
        urlRecordImpl.setRecordId(urlRecord.getRecordId());
        urlRecordImpl.setUrl(urlRecord.getUrl());
        urlRecordImpl.setType(urlRecord.getType());
        urlRecordImpl.setOrder(urlRecord.getOrder());
        urlRecordImpl.setPauseTime(urlRecord.getPauseTime());

        return urlRecordImpl;
    }

    /**
     * Returns the url record with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the url record
     * @return the url record
     * @throws io.gatling.liferay.NoSuchUrlRecordException if a url record with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public UrlRecord findByPrimaryKey(Serializable primaryKey)
        throws NoSuchUrlRecordException, SystemException {
        UrlRecord urlRecord = fetchByPrimaryKey(primaryKey);

        if (urlRecord == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchUrlRecordException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return urlRecord;
    }

    /**
     * Returns the url record with the primary key or throws a {@link io.gatling.liferay.NoSuchUrlRecordException} if it could not be found.
     *
     * @param urlRecordId the primary key of the url record
     * @return the url record
     * @throws io.gatling.liferay.NoSuchUrlRecordException if a url record with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public UrlRecord findByPrimaryKey(long urlRecordId)
        throws NoSuchUrlRecordException, SystemException {
        return findByPrimaryKey((Serializable) urlRecordId);
    }

    /**
     * Returns the url record with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the url record
     * @return the url record, or <code>null</code> if a url record with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public UrlRecord fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        UrlRecord urlRecord = (UrlRecord) EntityCacheUtil.getResult(UrlRecordModelImpl.ENTITY_CACHE_ENABLED,
                UrlRecordImpl.class, primaryKey);

        if (urlRecord == _nullUrlRecord) {
            return null;
        }

        if (urlRecord == null) {
            Session session = null;

            try {
                session = openSession();

                urlRecord = (UrlRecord) session.get(UrlRecordImpl.class,
                        primaryKey);

                if (urlRecord != null) {
                    cacheResult(urlRecord);
                } else {
                    EntityCacheUtil.putResult(UrlRecordModelImpl.ENTITY_CACHE_ENABLED,
                        UrlRecordImpl.class, primaryKey, _nullUrlRecord);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(UrlRecordModelImpl.ENTITY_CACHE_ENABLED,
                    UrlRecordImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return urlRecord;
    }

    /**
     * Returns the url record with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param urlRecordId the primary key of the url record
     * @return the url record, or <code>null</code> if a url record with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public UrlRecord fetchByPrimaryKey(long urlRecordId)
        throws SystemException {
        return fetchByPrimaryKey((Serializable) urlRecordId);
    }

    /**
     * Returns all the url records.
     *
     * @return the url records
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<UrlRecord> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
    @Override
    public List<UrlRecord> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
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
    @Override
    public List<UrlRecord> findAll(int start, int end,
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

        List<UrlRecord> list = (List<UrlRecord>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_URLRECORD);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_URLRECORD;

                if (pagination) {
                    sql = sql.concat(UrlRecordModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<UrlRecord>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<UrlRecord>(list);
                } else {
                    list = (List<UrlRecord>) QueryUtil.list(q, getDialect(),
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
     * Removes all the url records from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (UrlRecord urlRecord : findAll()) {
            remove(urlRecord);
        }
    }

    /**
     * Returns the number of url records.
     *
     * @return the number of url records
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

                Query q = session.createQuery(_SQL_COUNT_URLRECORD);

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
     * Initializes the url record persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.io.gatling.liferay.model.UrlRecord")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<UrlRecord>> listenersList = new ArrayList<ModelListener<UrlRecord>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<UrlRecord>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(UrlRecordImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
