package com.excilys.liferay.gatling.service.persistence;

import com.excilys.liferay.gatling.NoSuchLinkProcessRecordException;
import com.excilys.liferay.gatling.model.LinkProcessRecord;
import com.excilys.liferay.gatling.model.impl.LinkProcessRecordImpl;
import com.excilys.liferay.gatling.model.impl.LinkProcessRecordModelImpl;
import com.excilys.liferay.gatling.service.persistence.LinkProcessRecordPersistence;

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
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the link process record service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LinkProcessRecordPersistence
 * @see LinkProcessRecordUtil
 * @generated
 */
public class LinkProcessRecordPersistenceImpl extends BasePersistenceImpl<LinkProcessRecord>
    implements LinkProcessRecordPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link LinkProcessRecordUtil} to access the link process record persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = LinkProcessRecordImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LinkProcessRecordModelImpl.ENTITY_CACHE_ENABLED,
            LinkProcessRecordModelImpl.FINDER_CACHE_ENABLED,
            LinkProcessRecordImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LinkProcessRecordModelImpl.ENTITY_CACHE_ENABLED,
            LinkProcessRecordModelImpl.FINDER_CACHE_ENABLED,
            LinkProcessRecordImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LinkProcessRecordModelImpl.ENTITY_CACHE_ENABLED,
            LinkProcessRecordModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_FETCH_BY_PROCESSID = new FinderPath(LinkProcessRecordModelImpl.ENTITY_CACHE_ENABLED,
            LinkProcessRecordModelImpl.FINDER_CACHE_ENABLED,
            LinkProcessRecordImpl.class, FINDER_CLASS_NAME_ENTITY,
            "fetchByProcessId", new String[] { Long.class.getName() },
            LinkProcessRecordModelImpl.PROCESS_ID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_PROCESSID = new FinderPath(LinkProcessRecordModelImpl.ENTITY_CACHE_ENABLED,
            LinkProcessRecordModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByProcessId",
            new String[] { Long.class.getName() });
    private static final String _FINDER_COLUMN_PROCESSID_PROCESS_ID_2 = "linkProcessRecord.process_id = ?";
    public static final FinderPath FINDER_PATH_FETCH_BY_RECORDID = new FinderPath(LinkProcessRecordModelImpl.ENTITY_CACHE_ENABLED,
            LinkProcessRecordModelImpl.FINDER_CACHE_ENABLED,
            LinkProcessRecordImpl.class, FINDER_CLASS_NAME_ENTITY,
            "fetchByRecordId", new String[] { Long.class.getName() },
            LinkProcessRecordModelImpl.RECORDID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_RECORDID = new FinderPath(LinkProcessRecordModelImpl.ENTITY_CACHE_ENABLED,
            LinkProcessRecordModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByRecordId",
            new String[] { Long.class.getName() });
    private static final String _FINDER_COLUMN_RECORDID_RECORDID_2 = "linkProcessRecord.recordId = ?";
    private static final String _SQL_SELECT_LINKPROCESSRECORD = "SELECT linkProcessRecord FROM LinkProcessRecord linkProcessRecord";
    private static final String _SQL_SELECT_LINKPROCESSRECORD_WHERE = "SELECT linkProcessRecord FROM LinkProcessRecord linkProcessRecord WHERE ";
    private static final String _SQL_COUNT_LINKPROCESSRECORD = "SELECT COUNT(linkProcessRecord) FROM LinkProcessRecord linkProcessRecord";
    private static final String _SQL_COUNT_LINKPROCESSRECORD_WHERE = "SELECT COUNT(linkProcessRecord) FROM LinkProcessRecord linkProcessRecord WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "linkProcessRecord.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LinkProcessRecord exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No LinkProcessRecord exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(LinkProcessRecordPersistenceImpl.class);
    private static LinkProcessRecord _nullLinkProcessRecord = new LinkProcessRecordImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<LinkProcessRecord> toCacheModel() {
                return _nullLinkProcessRecordCacheModel;
            }
        };

    private static CacheModel<LinkProcessRecord> _nullLinkProcessRecordCacheModel =
        new CacheModel<LinkProcessRecord>() {
            @Override
            public LinkProcessRecord toEntityModel() {
                return _nullLinkProcessRecord;
            }
        };

    public LinkProcessRecordPersistenceImpl() {
        setModelClass(LinkProcessRecord.class);
    }

    /**
     * Returns the link process record where process_id = &#63; or throws a {@link com.excilys.liferay.gatling.NoSuchLinkProcessRecordException} if it could not be found.
     *
     * @param process_id the process_id
     * @return the matching link process record
     * @throws com.excilys.liferay.gatling.NoSuchLinkProcessRecordException if a matching link process record could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LinkProcessRecord findByProcessId(long process_id)
        throws NoSuchLinkProcessRecordException, SystemException {
        LinkProcessRecord linkProcessRecord = fetchByProcessId(process_id);

        if (linkProcessRecord == null) {
            StringBundler msg = new StringBundler(4);

            msg.append(_NO_SUCH_ENTITY_WITH_KEY);

            msg.append("process_id=");
            msg.append(process_id);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            if (_log.isWarnEnabled()) {
                _log.warn(msg.toString());
            }

            throw new NoSuchLinkProcessRecordException(msg.toString());
        }

        return linkProcessRecord;
    }

    /**
     * Returns the link process record where process_id = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
     *
     * @param process_id the process_id
     * @return the matching link process record, or <code>null</code> if a matching link process record could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LinkProcessRecord fetchByProcessId(long process_id)
        throws SystemException {
        return fetchByProcessId(process_id, true);
    }

    /**
     * Returns the link process record where process_id = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
     *
     * @param process_id the process_id
     * @param retrieveFromCache whether to use the finder cache
     * @return the matching link process record, or <code>null</code> if a matching link process record could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LinkProcessRecord fetchByProcessId(long process_id,
        boolean retrieveFromCache) throws SystemException {
        Object[] finderArgs = new Object[] { process_id };

        Object result = null;

        if (retrieveFromCache) {
            result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_PROCESSID,
                    finderArgs, this);
        }

        if (result instanceof LinkProcessRecord) {
            LinkProcessRecord linkProcessRecord = (LinkProcessRecord) result;

            if ((process_id != linkProcessRecord.getProcess_id())) {
                result = null;
            }
        }

        if (result == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_SELECT_LINKPROCESSRECORD_WHERE);

            query.append(_FINDER_COLUMN_PROCESSID_PROCESS_ID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(process_id);

                List<LinkProcessRecord> list = q.list();

                if (list.isEmpty()) {
                    FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PROCESSID,
                        finderArgs, list);
                } else {
                    LinkProcessRecord linkProcessRecord = list.get(0);

                    result = linkProcessRecord;

                    cacheResult(linkProcessRecord);

                    if ((linkProcessRecord.getProcess_id() != process_id)) {
                        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PROCESSID,
                            finderArgs, linkProcessRecord);
                    }
                }
            } catch (Exception e) {
                FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_PROCESSID,
                    finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        if (result instanceof List<?>) {
            return null;
        } else {
            return (LinkProcessRecord) result;
        }
    }

    /**
     * Removes the link process record where process_id = &#63; from the database.
     *
     * @param process_id the process_id
     * @return the link process record that was removed
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LinkProcessRecord removeByProcessId(long process_id)
        throws NoSuchLinkProcessRecordException, SystemException {
        LinkProcessRecord linkProcessRecord = findByProcessId(process_id);

        return remove(linkProcessRecord);
    }

    /**
     * Returns the number of link process records where process_id = &#63;.
     *
     * @param process_id the process_id
     * @return the number of matching link process records
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByProcessId(long process_id) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_PROCESSID;

        Object[] finderArgs = new Object[] { process_id };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_LINKPROCESSRECORD_WHERE);

            query.append(_FINDER_COLUMN_PROCESSID_PROCESS_ID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(process_id);

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
     * Returns the link process record where recordId = &#63; or throws a {@link com.excilys.liferay.gatling.NoSuchLinkProcessRecordException} if it could not be found.
     *
     * @param recordId the record ID
     * @return the matching link process record
     * @throws com.excilys.liferay.gatling.NoSuchLinkProcessRecordException if a matching link process record could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LinkProcessRecord findByRecordId(long recordId)
        throws NoSuchLinkProcessRecordException, SystemException {
        LinkProcessRecord linkProcessRecord = fetchByRecordId(recordId);

        if (linkProcessRecord == null) {
            StringBundler msg = new StringBundler(4);

            msg.append(_NO_SUCH_ENTITY_WITH_KEY);

            msg.append("recordId=");
            msg.append(recordId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            if (_log.isWarnEnabled()) {
                _log.warn(msg.toString());
            }

            throw new NoSuchLinkProcessRecordException(msg.toString());
        }

        return linkProcessRecord;
    }

    /**
     * Returns the link process record where recordId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
     *
     * @param recordId the record ID
     * @return the matching link process record, or <code>null</code> if a matching link process record could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LinkProcessRecord fetchByRecordId(long recordId)
        throws SystemException {
        return fetchByRecordId(recordId, true);
    }

    /**
     * Returns the link process record where recordId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
     *
     * @param recordId the record ID
     * @param retrieveFromCache whether to use the finder cache
     * @return the matching link process record, or <code>null</code> if a matching link process record could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LinkProcessRecord fetchByRecordId(long recordId,
        boolean retrieveFromCache) throws SystemException {
        Object[] finderArgs = new Object[] { recordId };

        Object result = null;

        if (retrieveFromCache) {
            result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_RECORDID,
                    finderArgs, this);
        }

        if (result instanceof LinkProcessRecord) {
            LinkProcessRecord linkProcessRecord = (LinkProcessRecord) result;

            if ((recordId != linkProcessRecord.getRecordId())) {
                result = null;
            }
        }

        if (result == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_SELECT_LINKPROCESSRECORD_WHERE);

            query.append(_FINDER_COLUMN_RECORDID_RECORDID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(recordId);

                List<LinkProcessRecord> list = q.list();

                if (list.isEmpty()) {
                    FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_RECORDID,
                        finderArgs, list);
                } else {
                    LinkProcessRecord linkProcessRecord = list.get(0);

                    result = linkProcessRecord;

                    cacheResult(linkProcessRecord);

                    if ((linkProcessRecord.getRecordId() != recordId)) {
                        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_RECORDID,
                            finderArgs, linkProcessRecord);
                    }
                }
            } catch (Exception e) {
                FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_RECORDID,
                    finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        if (result instanceof List<?>) {
            return null;
        } else {
            return (LinkProcessRecord) result;
        }
    }

    /**
     * Removes the link process record where recordId = &#63; from the database.
     *
     * @param recordId the record ID
     * @return the link process record that was removed
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LinkProcessRecord removeByRecordId(long recordId)
        throws NoSuchLinkProcessRecordException, SystemException {
        LinkProcessRecord linkProcessRecord = findByRecordId(recordId);

        return remove(linkProcessRecord);
    }

    /**
     * Returns the number of link process records where recordId = &#63;.
     *
     * @param recordId the record ID
     * @return the number of matching link process records
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

            query.append(_SQL_COUNT_LINKPROCESSRECORD_WHERE);

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
     * Caches the link process record in the entity cache if it is enabled.
     *
     * @param linkProcessRecord the link process record
     */
    @Override
    public void cacheResult(LinkProcessRecord linkProcessRecord) {
        EntityCacheUtil.putResult(LinkProcessRecordModelImpl.ENTITY_CACHE_ENABLED,
            LinkProcessRecordImpl.class, linkProcessRecord.getPrimaryKey(),
            linkProcessRecord);

        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PROCESSID,
            new Object[] { linkProcessRecord.getProcess_id() },
            linkProcessRecord);

        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_RECORDID,
            new Object[] { linkProcessRecord.getRecordId() }, linkProcessRecord);

        linkProcessRecord.resetOriginalValues();
    }

    /**
     * Caches the link process records in the entity cache if it is enabled.
     *
     * @param linkProcessRecords the link process records
     */
    @Override
    public void cacheResult(List<LinkProcessRecord> linkProcessRecords) {
        for (LinkProcessRecord linkProcessRecord : linkProcessRecords) {
            if (EntityCacheUtil.getResult(
                        LinkProcessRecordModelImpl.ENTITY_CACHE_ENABLED,
                        LinkProcessRecordImpl.class,
                        linkProcessRecord.getPrimaryKey()) == null) {
                cacheResult(linkProcessRecord);
            } else {
                linkProcessRecord.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all link process records.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(LinkProcessRecordImpl.class.getName());
        }

        EntityCacheUtil.clearCache(LinkProcessRecordImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the link process record.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(LinkProcessRecord linkProcessRecord) {
        EntityCacheUtil.removeResult(LinkProcessRecordModelImpl.ENTITY_CACHE_ENABLED,
            LinkProcessRecordImpl.class, linkProcessRecord.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        clearUniqueFindersCache(linkProcessRecord);
    }

    @Override
    public void clearCache(List<LinkProcessRecord> linkProcessRecords) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (LinkProcessRecord linkProcessRecord : linkProcessRecords) {
            EntityCacheUtil.removeResult(LinkProcessRecordModelImpl.ENTITY_CACHE_ENABLED,
                LinkProcessRecordImpl.class, linkProcessRecord.getPrimaryKey());

            clearUniqueFindersCache(linkProcessRecord);
        }
    }

    protected void cacheUniqueFindersCache(LinkProcessRecord linkProcessRecord) {
        if (linkProcessRecord.isNew()) {
            Object[] args = new Object[] { linkProcessRecord.getProcess_id() };

            FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_PROCESSID, args,
                Long.valueOf(1));
            FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PROCESSID, args,
                linkProcessRecord);

            args = new Object[] { linkProcessRecord.getRecordId() };

            FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_RECORDID, args,
                Long.valueOf(1));
            FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_RECORDID, args,
                linkProcessRecord);
        } else {
            LinkProcessRecordModelImpl linkProcessRecordModelImpl = (LinkProcessRecordModelImpl) linkProcessRecord;

            if ((linkProcessRecordModelImpl.getColumnBitmask() &
                    FINDER_PATH_FETCH_BY_PROCESSID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] { linkProcessRecord.getProcess_id() };

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_PROCESSID, args,
                    Long.valueOf(1));
                FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PROCESSID, args,
                    linkProcessRecord);
            }

            if ((linkProcessRecordModelImpl.getColumnBitmask() &
                    FINDER_PATH_FETCH_BY_RECORDID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] { linkProcessRecord.getRecordId() };

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_RECORDID, args,
                    Long.valueOf(1));
                FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_RECORDID, args,
                    linkProcessRecord);
            }
        }
    }

    protected void clearUniqueFindersCache(LinkProcessRecord linkProcessRecord) {
        LinkProcessRecordModelImpl linkProcessRecordModelImpl = (LinkProcessRecordModelImpl) linkProcessRecord;

        Object[] args = new Object[] { linkProcessRecord.getProcess_id() };

        FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PROCESSID, args);
        FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_PROCESSID, args);

        if ((linkProcessRecordModelImpl.getColumnBitmask() &
                FINDER_PATH_FETCH_BY_PROCESSID.getColumnBitmask()) != 0) {
            args = new Object[] {
                    linkProcessRecordModelImpl.getOriginalProcess_id()
                };

            FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PROCESSID, args);
            FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_PROCESSID, args);
        }

        args = new Object[] { linkProcessRecord.getRecordId() };

        FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_RECORDID, args);
        FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_RECORDID, args);

        if ((linkProcessRecordModelImpl.getColumnBitmask() &
                FINDER_PATH_FETCH_BY_RECORDID.getColumnBitmask()) != 0) {
            args = new Object[] { linkProcessRecordModelImpl.getOriginalRecordId() };

            FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_RECORDID, args);
            FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_RECORDID, args);
        }
    }

    /**
     * Creates a new link process record with the primary key. Does not add the link process record to the database.
     *
     * @param link_process_record_id the primary key for the new link process record
     * @return the new link process record
     */
    @Override
    public LinkProcessRecord create(long link_process_record_id) {
        LinkProcessRecord linkProcessRecord = new LinkProcessRecordImpl();

        linkProcessRecord.setNew(true);
        linkProcessRecord.setPrimaryKey(link_process_record_id);

        return linkProcessRecord;
    }

    /**
     * Removes the link process record with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param link_process_record_id the primary key of the link process record
     * @return the link process record that was removed
     * @throws com.excilys.liferay.gatling.NoSuchLinkProcessRecordException if a link process record with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LinkProcessRecord remove(long link_process_record_id)
        throws NoSuchLinkProcessRecordException, SystemException {
        return remove((Serializable) link_process_record_id);
    }

    /**
     * Removes the link process record with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the link process record
     * @return the link process record that was removed
     * @throws com.excilys.liferay.gatling.NoSuchLinkProcessRecordException if a link process record with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LinkProcessRecord remove(Serializable primaryKey)
        throws NoSuchLinkProcessRecordException, SystemException {
        Session session = null;

        try {
            session = openSession();

            LinkProcessRecord linkProcessRecord = (LinkProcessRecord) session.get(LinkProcessRecordImpl.class,
                    primaryKey);

            if (linkProcessRecord == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchLinkProcessRecordException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(linkProcessRecord);
        } catch (NoSuchLinkProcessRecordException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected LinkProcessRecord removeImpl(LinkProcessRecord linkProcessRecord)
        throws SystemException {
        linkProcessRecord = toUnwrappedModel(linkProcessRecord);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(linkProcessRecord)) {
                linkProcessRecord = (LinkProcessRecord) session.get(LinkProcessRecordImpl.class,
                        linkProcessRecord.getPrimaryKeyObj());
            }

            if (linkProcessRecord != null) {
                session.delete(linkProcessRecord);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (linkProcessRecord != null) {
            clearCache(linkProcessRecord);
        }

        return linkProcessRecord;
    }

    @Override
    public LinkProcessRecord updateImpl(
        com.excilys.liferay.gatling.model.LinkProcessRecord linkProcessRecord)
        throws SystemException {
        linkProcessRecord = toUnwrappedModel(linkProcessRecord);

        boolean isNew = linkProcessRecord.isNew();

        Session session = null;

        try {
            session = openSession();

            if (linkProcessRecord.isNew()) {
                session.save(linkProcessRecord);

                linkProcessRecord.setNew(false);
            } else {
                session.merge(linkProcessRecord);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !LinkProcessRecordModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }

        EntityCacheUtil.putResult(LinkProcessRecordModelImpl.ENTITY_CACHE_ENABLED,
            LinkProcessRecordImpl.class, linkProcessRecord.getPrimaryKey(),
            linkProcessRecord);

        clearUniqueFindersCache(linkProcessRecord);
        cacheUniqueFindersCache(linkProcessRecord);

        return linkProcessRecord;
    }

    protected LinkProcessRecord toUnwrappedModel(
        LinkProcessRecord linkProcessRecord) {
        if (linkProcessRecord instanceof LinkProcessRecordImpl) {
            return linkProcessRecord;
        }

        LinkProcessRecordImpl linkProcessRecordImpl = new LinkProcessRecordImpl();

        linkProcessRecordImpl.setNew(linkProcessRecord.isNew());
        linkProcessRecordImpl.setPrimaryKey(linkProcessRecord.getPrimaryKey());

        linkProcessRecordImpl.setLink_process_record_id(linkProcessRecord.getLink_process_record_id());
        linkProcessRecordImpl.setProcess_id(linkProcessRecord.getProcess_id());
        linkProcessRecordImpl.setRecordId(linkProcessRecord.getRecordId());

        return linkProcessRecordImpl;
    }

    /**
     * Returns the link process record with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the link process record
     * @return the link process record
     * @throws com.excilys.liferay.gatling.NoSuchLinkProcessRecordException if a link process record with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LinkProcessRecord findByPrimaryKey(Serializable primaryKey)
        throws NoSuchLinkProcessRecordException, SystemException {
        LinkProcessRecord linkProcessRecord = fetchByPrimaryKey(primaryKey);

        if (linkProcessRecord == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchLinkProcessRecordException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return linkProcessRecord;
    }

    /**
     * Returns the link process record with the primary key or throws a {@link com.excilys.liferay.gatling.NoSuchLinkProcessRecordException} if it could not be found.
     *
     * @param link_process_record_id the primary key of the link process record
     * @return the link process record
     * @throws com.excilys.liferay.gatling.NoSuchLinkProcessRecordException if a link process record with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LinkProcessRecord findByPrimaryKey(long link_process_record_id)
        throws NoSuchLinkProcessRecordException, SystemException {
        return findByPrimaryKey((Serializable) link_process_record_id);
    }

    /**
     * Returns the link process record with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the link process record
     * @return the link process record, or <code>null</code> if a link process record with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LinkProcessRecord fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        LinkProcessRecord linkProcessRecord = (LinkProcessRecord) EntityCacheUtil.getResult(LinkProcessRecordModelImpl.ENTITY_CACHE_ENABLED,
                LinkProcessRecordImpl.class, primaryKey);

        if (linkProcessRecord == _nullLinkProcessRecord) {
            return null;
        }

        if (linkProcessRecord == null) {
            Session session = null;

            try {
                session = openSession();

                linkProcessRecord = (LinkProcessRecord) session.get(LinkProcessRecordImpl.class,
                        primaryKey);

                if (linkProcessRecord != null) {
                    cacheResult(linkProcessRecord);
                } else {
                    EntityCacheUtil.putResult(LinkProcessRecordModelImpl.ENTITY_CACHE_ENABLED,
                        LinkProcessRecordImpl.class, primaryKey,
                        _nullLinkProcessRecord);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(LinkProcessRecordModelImpl.ENTITY_CACHE_ENABLED,
                    LinkProcessRecordImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return linkProcessRecord;
    }

    /**
     * Returns the link process record with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param link_process_record_id the primary key of the link process record
     * @return the link process record, or <code>null</code> if a link process record with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LinkProcessRecord fetchByPrimaryKey(long link_process_record_id)
        throws SystemException {
        return fetchByPrimaryKey((Serializable) link_process_record_id);
    }

    /**
     * Returns all the link process records.
     *
     * @return the link process records
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LinkProcessRecord> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the link process records.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.excilys.liferay.gatling.model.impl.LinkProcessRecordModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of link process records
     * @param end the upper bound of the range of link process records (not inclusive)
     * @return the range of link process records
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LinkProcessRecord> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the link process records.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.excilys.liferay.gatling.model.impl.LinkProcessRecordModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of link process records
     * @param end the upper bound of the range of link process records (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of link process records
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LinkProcessRecord> findAll(int start, int end,
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

        List<LinkProcessRecord> list = (List<LinkProcessRecord>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_LINKPROCESSRECORD);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_LINKPROCESSRECORD;

                if (pagination) {
                    sql = sql.concat(LinkProcessRecordModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<LinkProcessRecord>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<LinkProcessRecord>(list);
                } else {
                    list = (List<LinkProcessRecord>) QueryUtil.list(q,
                            getDialect(), start, end);
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
     * Removes all the link process records from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (LinkProcessRecord linkProcessRecord : findAll()) {
            remove(linkProcessRecord);
        }
    }

    /**
     * Returns the number of link process records.
     *
     * @return the number of link process records
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

                Query q = session.createQuery(_SQL_COUNT_LINKPROCESSRECORD);

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
     * Initializes the link process record persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.excilys.liferay.gatling.model.LinkProcessRecord")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<LinkProcessRecord>> listenersList = new ArrayList<ModelListener<LinkProcessRecord>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<LinkProcessRecord>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(LinkProcessRecordImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
