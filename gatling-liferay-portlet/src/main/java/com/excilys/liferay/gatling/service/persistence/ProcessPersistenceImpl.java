package com.excilys.liferay.gatling.service.persistence;

import com.excilys.liferay.gatling.NoSuchProcessException;
import com.excilys.liferay.gatling.model.Process;
import com.excilys.liferay.gatling.model.impl.ProcessImpl;
import com.excilys.liferay.gatling.model.impl.ProcessModelImpl;
import com.excilys.liferay.gatling.service.persistence.ProcessPersistence;

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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the process service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProcessPersistence
 * @see ProcessUtil
 * @generated
 */
public class ProcessPersistenceImpl extends BasePersistenceImpl<Process>
    implements ProcessPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link ProcessUtil} to access the process persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = ProcessImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ProcessModelImpl.ENTITY_CACHE_ENABLED,
            ProcessModelImpl.FINDER_CACHE_ENABLED, ProcessImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ProcessModelImpl.ENTITY_CACHE_ENABLED,
            ProcessModelImpl.FINDER_CACHE_ENABLED, ProcessImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ProcessModelImpl.ENTITY_CACHE_ENABLED,
            ProcessModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_FETCH_BY_NAME = new FinderPath(ProcessModelImpl.ENTITY_CACHE_ENABLED,
            ProcessModelImpl.FINDER_CACHE_ENABLED, ProcessImpl.class,
            FINDER_CLASS_NAME_ENTITY, "fetchByName",
            new String[] { String.class.getName() },
            ProcessModelImpl.NAME_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_NAME = new FinderPath(ProcessModelImpl.ENTITY_CACHE_ENABLED,
            ProcessModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByName",
            new String[] { String.class.getName() });
    private static final String _FINDER_COLUMN_NAME_NAME_1 = "process.name IS NULL";
    private static final String _FINDER_COLUMN_NAME_NAME_2 = "process.name = ?";
    private static final String _FINDER_COLUMN_NAME_NAME_3 = "(process.name IS NULL OR process.name = '')";
    private static final String _SQL_SELECT_PROCESS = "SELECT process FROM Process process";
    private static final String _SQL_SELECT_PROCESS_WHERE = "SELECT process FROM Process process WHERE ";
    private static final String _SQL_COUNT_PROCESS = "SELECT COUNT(process) FROM Process process";
    private static final String _SQL_COUNT_PROCESS_WHERE = "SELECT COUNT(process) FROM Process process WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "process.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Process exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Process exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(ProcessPersistenceImpl.class);
    private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
                "type"
            });
    private static Process _nullProcess = new ProcessImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<Process> toCacheModel() {
                return _nullProcessCacheModel;
            }
        };

    private static CacheModel<Process> _nullProcessCacheModel = new CacheModel<Process>() {
            @Override
            public Process toEntityModel() {
                return _nullProcess;
            }
        };

    public ProcessPersistenceImpl() {
        setModelClass(Process.class);
    }

    /**
     * Returns the process where name = &#63; or throws a {@link com.excilys.liferay.gatling.NoSuchProcessException} if it could not be found.
     *
     * @param name the name
     * @return the matching process
     * @throws com.excilys.liferay.gatling.NoSuchProcessException if a matching process could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Process findByName(String name)
        throws NoSuchProcessException, SystemException {
        Process process = fetchByName(name);

        if (process == null) {
            StringBundler msg = new StringBundler(4);

            msg.append(_NO_SUCH_ENTITY_WITH_KEY);

            msg.append("name=");
            msg.append(name);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            if (_log.isWarnEnabled()) {
                _log.warn(msg.toString());
            }

            throw new NoSuchProcessException(msg.toString());
        }

        return process;
    }

    /**
     * Returns the process where name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
     *
     * @param name the name
     * @return the matching process, or <code>null</code> if a matching process could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Process fetchByName(String name) throws SystemException {
        return fetchByName(name, true);
    }

    /**
     * Returns the process where name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
     *
     * @param name the name
     * @param retrieveFromCache whether to use the finder cache
     * @return the matching process, or <code>null</code> if a matching process could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Process fetchByName(String name, boolean retrieveFromCache)
        throws SystemException {
        Object[] finderArgs = new Object[] { name };

        Object result = null;

        if (retrieveFromCache) {
            result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_NAME,
                    finderArgs, this);
        }

        if (result instanceof Process) {
            Process process = (Process) result;

            if (!Validator.equals(name, process.getName())) {
                result = null;
            }
        }

        if (result == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_SELECT_PROCESS_WHERE);

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

                List<Process> list = q.list();

                if (list.isEmpty()) {
                    FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAME,
                        finderArgs, list);
                } else {
                    Process process = list.get(0);

                    result = process;

                    cacheResult(process);

                    if ((process.getName() == null) ||
                            !process.getName().equals(name)) {
                        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAME,
                            finderArgs, process);
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
            return (Process) result;
        }
    }

    /**
     * Removes the process where name = &#63; from the database.
     *
     * @param name the name
     * @return the process that was removed
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Process removeByName(String name)
        throws NoSuchProcessException, SystemException {
        Process process = findByName(name);

        return remove(process);
    }

    /**
     * Returns the number of processes where name = &#63;.
     *
     * @param name the name
     * @return the number of matching processes
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

            query.append(_SQL_COUNT_PROCESS_WHERE);

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
     * Caches the process in the entity cache if it is enabled.
     *
     * @param process the process
     */
    @Override
    public void cacheResult(Process process) {
        EntityCacheUtil.putResult(ProcessModelImpl.ENTITY_CACHE_ENABLED,
            ProcessImpl.class, process.getPrimaryKey(), process);

        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAME,
            new Object[] { process.getName() }, process);

        process.resetOriginalValues();
    }

    /**
     * Caches the processes in the entity cache if it is enabled.
     *
     * @param processes the processes
     */
    @Override
    public void cacheResult(List<Process> processes) {
        for (Process process : processes) {
            if (EntityCacheUtil.getResult(
                        ProcessModelImpl.ENTITY_CACHE_ENABLED,
                        ProcessImpl.class, process.getPrimaryKey()) == null) {
                cacheResult(process);
            } else {
                process.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all processes.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(ProcessImpl.class.getName());
        }

        EntityCacheUtil.clearCache(ProcessImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the process.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(Process process) {
        EntityCacheUtil.removeResult(ProcessModelImpl.ENTITY_CACHE_ENABLED,
            ProcessImpl.class, process.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        clearUniqueFindersCache(process);
    }

    @Override
    public void clearCache(List<Process> processes) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (Process process : processes) {
            EntityCacheUtil.removeResult(ProcessModelImpl.ENTITY_CACHE_ENABLED,
                ProcessImpl.class, process.getPrimaryKey());

            clearUniqueFindersCache(process);
        }
    }

    protected void cacheUniqueFindersCache(Process process) {
        if (process.isNew()) {
            Object[] args = new Object[] { process.getName() };

            FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_NAME, args,
                Long.valueOf(1));
            FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAME, args, process);
        } else {
            ProcessModelImpl processModelImpl = (ProcessModelImpl) process;

            if ((processModelImpl.getColumnBitmask() &
                    FINDER_PATH_FETCH_BY_NAME.getColumnBitmask()) != 0) {
                Object[] args = new Object[] { process.getName() };

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_NAME, args,
                    Long.valueOf(1));
                FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAME, args,
                    process);
            }
        }
    }

    protected void clearUniqueFindersCache(Process process) {
        ProcessModelImpl processModelImpl = (ProcessModelImpl) process;

        Object[] args = new Object[] { process.getName() };

        FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NAME, args);
        FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_NAME, args);

        if ((processModelImpl.getColumnBitmask() &
                FINDER_PATH_FETCH_BY_NAME.getColumnBitmask()) != 0) {
            args = new Object[] { processModelImpl.getOriginalName() };

            FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NAME, args);
            FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_NAME, args);
        }
    }

    /**
     * Creates a new process with the primary key. Does not add the process to the database.
     *
     * @param process_id the primary key for the new process
     * @return the new process
     */
    @Override
    public Process create(long process_id) {
        Process process = new ProcessImpl();

        process.setNew(true);
        process.setPrimaryKey(process_id);

        return process;
    }

    /**
     * Removes the process with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param process_id the primary key of the process
     * @return the process that was removed
     * @throws com.excilys.liferay.gatling.NoSuchProcessException if a process with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Process remove(long process_id)
        throws NoSuchProcessException, SystemException {
        return remove((Serializable) process_id);
    }

    /**
     * Removes the process with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the process
     * @return the process that was removed
     * @throws com.excilys.liferay.gatling.NoSuchProcessException if a process with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Process remove(Serializable primaryKey)
        throws NoSuchProcessException, SystemException {
        Session session = null;

        try {
            session = openSession();

            Process process = (Process) session.get(ProcessImpl.class,
                    primaryKey);

            if (process == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchProcessException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(process);
        } catch (NoSuchProcessException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected Process removeImpl(Process process) throws SystemException {
        process = toUnwrappedModel(process);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(process)) {
                process = (Process) session.get(ProcessImpl.class,
                        process.getPrimaryKeyObj());
            }

            if (process != null) {
                session.delete(process);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (process != null) {
            clearCache(process);
        }

        return process;
    }

    @Override
    public Process updateImpl(com.excilys.liferay.gatling.model.Process process)
        throws SystemException {
        process = toUnwrappedModel(process);

        boolean isNew = process.isNew();

        Session session = null;

        try {
            session = openSession();

            if (process.isNew()) {
                session.save(process);

                process.setNew(false);
            } else {
                session.merge(process);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !ProcessModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }

        EntityCacheUtil.putResult(ProcessModelImpl.ENTITY_CACHE_ENABLED,
            ProcessImpl.class, process.getPrimaryKey(), process);

        clearUniqueFindersCache(process);
        cacheUniqueFindersCache(process);

        return process;
    }

    protected Process toUnwrappedModel(Process process) {
        if (process instanceof ProcessImpl) {
            return process;
        }

        ProcessImpl processImpl = new ProcessImpl();

        processImpl.setNew(process.isNew());
        processImpl.setPrimaryKey(process.getPrimaryKey());

        processImpl.setProcess_id(process.getProcess_id());
        processImpl.setName(process.getName());
        processImpl.setType(process.getType());
        processImpl.setFeederId(process.getFeederId());

        return processImpl;
    }

    /**
     * Returns the process with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the process
     * @return the process
     * @throws com.excilys.liferay.gatling.NoSuchProcessException if a process with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Process findByPrimaryKey(Serializable primaryKey)
        throws NoSuchProcessException, SystemException {
        Process process = fetchByPrimaryKey(primaryKey);

        if (process == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchProcessException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return process;
    }

    /**
     * Returns the process with the primary key or throws a {@link com.excilys.liferay.gatling.NoSuchProcessException} if it could not be found.
     *
     * @param process_id the primary key of the process
     * @return the process
     * @throws com.excilys.liferay.gatling.NoSuchProcessException if a process with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Process findByPrimaryKey(long process_id)
        throws NoSuchProcessException, SystemException {
        return findByPrimaryKey((Serializable) process_id);
    }

    /**
     * Returns the process with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the process
     * @return the process, or <code>null</code> if a process with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Process fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        Process process = (Process) EntityCacheUtil.getResult(ProcessModelImpl.ENTITY_CACHE_ENABLED,
                ProcessImpl.class, primaryKey);

        if (process == _nullProcess) {
            return null;
        }

        if (process == null) {
            Session session = null;

            try {
                session = openSession();

                process = (Process) session.get(ProcessImpl.class, primaryKey);

                if (process != null) {
                    cacheResult(process);
                } else {
                    EntityCacheUtil.putResult(ProcessModelImpl.ENTITY_CACHE_ENABLED,
                        ProcessImpl.class, primaryKey, _nullProcess);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(ProcessModelImpl.ENTITY_CACHE_ENABLED,
                    ProcessImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return process;
    }

    /**
     * Returns the process with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param process_id the primary key of the process
     * @return the process, or <code>null</code> if a process with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Process fetchByPrimaryKey(long process_id) throws SystemException {
        return fetchByPrimaryKey((Serializable) process_id);
    }

    /**
     * Returns all the processes.
     *
     * @return the processes
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Process> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the processes.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.excilys.liferay.gatling.model.impl.ProcessModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of processes
     * @param end the upper bound of the range of processes (not inclusive)
     * @return the range of processes
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Process> findAll(int start, int end) throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the processes.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.excilys.liferay.gatling.model.impl.ProcessModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of processes
     * @param end the upper bound of the range of processes (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of processes
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Process> findAll(int start, int end,
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

        List<Process> list = (List<Process>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_PROCESS);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_PROCESS;

                if (pagination) {
                    sql = sql.concat(ProcessModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<Process>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Process>(list);
                } else {
                    list = (List<Process>) QueryUtil.list(q, getDialect(),
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
     * Removes all the processes from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (Process process : findAll()) {
            remove(process);
        }
    }

    /**
     * Returns the number of processes.
     *
     * @return the number of processes
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

                Query q = session.createQuery(_SQL_COUNT_PROCESS);

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
     * Initializes the process persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.excilys.liferay.gatling.model.Process")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<Process>> listenersList = new ArrayList<ModelListener<Process>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<Process>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(ProcessImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
