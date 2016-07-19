package com.excilys.liferay.gatling.service.persistence;

import com.excilys.liferay.gatling.NoSuchFormParamException;
import com.excilys.liferay.gatling.model.FormParam;
import com.excilys.liferay.gatling.model.impl.FormParamImpl;
import com.excilys.liferay.gatling.model.impl.FormParamModelImpl;
import com.excilys.liferay.gatling.service.persistence.FormParamPersistence;

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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the form param service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FormParamPersistence
 * @see FormParamUtil
 * @generated
 */
public class FormParamPersistenceImpl extends BasePersistenceImpl<FormParam>
    implements FormParamPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link FormParamUtil} to access the form param persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = FormParamImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(FormParamModelImpl.ENTITY_CACHE_ENABLED,
            FormParamModelImpl.FINDER_CACHE_ENABLED, FormParamImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(FormParamModelImpl.ENTITY_CACHE_ENABLED,
            FormParamModelImpl.FINDER_CACHE_ENABLED, FormParamImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(FormParamModelImpl.ENTITY_CACHE_ENABLED,
            FormParamModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_URLRECORDID =
        new FinderPath(FormParamModelImpl.ENTITY_CACHE_ENABLED,
            FormParamModelImpl.FINDER_CACHE_ENABLED, FormParamImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUrlRecordId",
            new String[] {
                Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_URLRECORDID =
        new FinderPath(FormParamModelImpl.ENTITY_CACHE_ENABLED,
            FormParamModelImpl.FINDER_CACHE_ENABLED, FormParamImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUrlRecordId",
            new String[] { Long.class.getName() },
            FormParamModelImpl.URLRECORDID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_URLRECORDID = new FinderPath(FormParamModelImpl.ENTITY_CACHE_ENABLED,
            FormParamModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUrlRecordId",
            new String[] { Long.class.getName() });
    private static final String _FINDER_COLUMN_URLRECORDID_URLRECORDID_2 = "formParam.urlRecordId = ?";
    private static final String _SQL_SELECT_FORMPARAM = "SELECT formParam FROM FormParam formParam";
    private static final String _SQL_SELECT_FORMPARAM_WHERE = "SELECT formParam FROM FormParam formParam WHERE ";
    private static final String _SQL_COUNT_FORMPARAM = "SELECT COUNT(formParam) FROM FormParam formParam";
    private static final String _SQL_COUNT_FORMPARAM_WHERE = "SELECT COUNT(formParam) FROM FormParam formParam WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "formParam.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No FormParam exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No FormParam exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(FormParamPersistenceImpl.class);
    private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
                "key"
            });
    private static FormParam _nullFormParam = new FormParamImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<FormParam> toCacheModel() {
                return _nullFormParamCacheModel;
            }
        };

    private static CacheModel<FormParam> _nullFormParamCacheModel = new CacheModel<FormParam>() {
            @Override
            public FormParam toEntityModel() {
                return _nullFormParam;
            }
        };

    public FormParamPersistenceImpl() {
        setModelClass(FormParam.class);
    }

    /**
     * Returns all the form params where urlRecordId = &#63;.
     *
     * @param urlRecordId the url record ID
     * @return the matching form params
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<FormParam> findByUrlRecordId(long urlRecordId)
        throws SystemException {
        return findByUrlRecordId(urlRecordId, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the form params where urlRecordId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.excilys.liferay.gatling.model.impl.FormParamModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param urlRecordId the url record ID
     * @param start the lower bound of the range of form params
     * @param end the upper bound of the range of form params (not inclusive)
     * @return the range of matching form params
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<FormParam> findByUrlRecordId(long urlRecordId, int start,
        int end) throws SystemException {
        return findByUrlRecordId(urlRecordId, start, end, null);
    }

    /**
     * Returns an ordered range of all the form params where urlRecordId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.excilys.liferay.gatling.model.impl.FormParamModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param urlRecordId the url record ID
     * @param start the lower bound of the range of form params
     * @param end the upper bound of the range of form params (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching form params
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<FormParam> findByUrlRecordId(long urlRecordId, int start,
        int end, OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_URLRECORDID;
            finderArgs = new Object[] { urlRecordId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_URLRECORDID;
            finderArgs = new Object[] { urlRecordId, start, end, orderByComparator };
        }

        List<FormParam> list = (List<FormParam>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (FormParam formParam : list) {
                if ((urlRecordId != formParam.getUrlRecordId())) {
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

            query.append(_SQL_SELECT_FORMPARAM_WHERE);

            query.append(_FINDER_COLUMN_URLRECORDID_URLRECORDID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(FormParamModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(urlRecordId);

                if (!pagination) {
                    list = (List<FormParam>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<FormParam>(list);
                } else {
                    list = (List<FormParam>) QueryUtil.list(q, getDialect(),
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
     * Returns the first form param in the ordered set where urlRecordId = &#63;.
     *
     * @param urlRecordId the url record ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching form param
     * @throws com.excilys.liferay.gatling.NoSuchFormParamException if a matching form param could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public FormParam findByUrlRecordId_First(long urlRecordId,
        OrderByComparator orderByComparator)
        throws NoSuchFormParamException, SystemException {
        FormParam formParam = fetchByUrlRecordId_First(urlRecordId,
                orderByComparator);

        if (formParam != null) {
            return formParam;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("urlRecordId=");
        msg.append(urlRecordId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchFormParamException(msg.toString());
    }

    /**
     * Returns the first form param in the ordered set where urlRecordId = &#63;.
     *
     * @param urlRecordId the url record ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching form param, or <code>null</code> if a matching form param could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public FormParam fetchByUrlRecordId_First(long urlRecordId,
        OrderByComparator orderByComparator) throws SystemException {
        List<FormParam> list = findByUrlRecordId(urlRecordId, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last form param in the ordered set where urlRecordId = &#63;.
     *
     * @param urlRecordId the url record ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching form param
     * @throws com.excilys.liferay.gatling.NoSuchFormParamException if a matching form param could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public FormParam findByUrlRecordId_Last(long urlRecordId,
        OrderByComparator orderByComparator)
        throws NoSuchFormParamException, SystemException {
        FormParam formParam = fetchByUrlRecordId_Last(urlRecordId,
                orderByComparator);

        if (formParam != null) {
            return formParam;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("urlRecordId=");
        msg.append(urlRecordId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchFormParamException(msg.toString());
    }

    /**
     * Returns the last form param in the ordered set where urlRecordId = &#63;.
     *
     * @param urlRecordId the url record ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching form param, or <code>null</code> if a matching form param could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public FormParam fetchByUrlRecordId_Last(long urlRecordId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByUrlRecordId(urlRecordId);

        if (count == 0) {
            return null;
        }

        List<FormParam> list = findByUrlRecordId(urlRecordId, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the form params before and after the current form param in the ordered set where urlRecordId = &#63;.
     *
     * @param formParamId the primary key of the current form param
     * @param urlRecordId the url record ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next form param
     * @throws com.excilys.liferay.gatling.NoSuchFormParamException if a form param with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public FormParam[] findByUrlRecordId_PrevAndNext(long formParamId,
        long urlRecordId, OrderByComparator orderByComparator)
        throws NoSuchFormParamException, SystemException {
        FormParam formParam = findByPrimaryKey(formParamId);

        Session session = null;

        try {
            session = openSession();

            FormParam[] array = new FormParamImpl[3];

            array[0] = getByUrlRecordId_PrevAndNext(session, formParam,
                    urlRecordId, orderByComparator, true);

            array[1] = formParam;

            array[2] = getByUrlRecordId_PrevAndNext(session, formParam,
                    urlRecordId, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected FormParam getByUrlRecordId_PrevAndNext(Session session,
        FormParam formParam, long urlRecordId,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_FORMPARAM_WHERE);

        query.append(_FINDER_COLUMN_URLRECORDID_URLRECORDID_2);

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
            query.append(FormParamModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(urlRecordId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(formParam);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<FormParam> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the form params where urlRecordId = &#63; from the database.
     *
     * @param urlRecordId the url record ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByUrlRecordId(long urlRecordId) throws SystemException {
        for (FormParam formParam : findByUrlRecordId(urlRecordId,
                QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(formParam);
        }
    }

    /**
     * Returns the number of form params where urlRecordId = &#63;.
     *
     * @param urlRecordId the url record ID
     * @return the number of matching form params
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByUrlRecordId(long urlRecordId) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_URLRECORDID;

        Object[] finderArgs = new Object[] { urlRecordId };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_FORMPARAM_WHERE);

            query.append(_FINDER_COLUMN_URLRECORDID_URLRECORDID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(urlRecordId);

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
     * Caches the form param in the entity cache if it is enabled.
     *
     * @param formParam the form param
     */
    @Override
    public void cacheResult(FormParam formParam) {
        EntityCacheUtil.putResult(FormParamModelImpl.ENTITY_CACHE_ENABLED,
            FormParamImpl.class, formParam.getPrimaryKey(), formParam);

        formParam.resetOriginalValues();
    }

    /**
     * Caches the form params in the entity cache if it is enabled.
     *
     * @param formParams the form params
     */
    @Override
    public void cacheResult(List<FormParam> formParams) {
        for (FormParam formParam : formParams) {
            if (EntityCacheUtil.getResult(
                        FormParamModelImpl.ENTITY_CACHE_ENABLED,
                        FormParamImpl.class, formParam.getPrimaryKey()) == null) {
                cacheResult(formParam);
            } else {
                formParam.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all form params.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(FormParamImpl.class.getName());
        }

        EntityCacheUtil.clearCache(FormParamImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the form param.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(FormParam formParam) {
        EntityCacheUtil.removeResult(FormParamModelImpl.ENTITY_CACHE_ENABLED,
            FormParamImpl.class, formParam.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<FormParam> formParams) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (FormParam formParam : formParams) {
            EntityCacheUtil.removeResult(FormParamModelImpl.ENTITY_CACHE_ENABLED,
                FormParamImpl.class, formParam.getPrimaryKey());
        }
    }

    /**
     * Creates a new form param with the primary key. Does not add the form param to the database.
     *
     * @param formParamId the primary key for the new form param
     * @return the new form param
     */
    @Override
    public FormParam create(long formParamId) {
        FormParam formParam = new FormParamImpl();

        formParam.setNew(true);
        formParam.setPrimaryKey(formParamId);

        return formParam;
    }

    /**
     * Removes the form param with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param formParamId the primary key of the form param
     * @return the form param that was removed
     * @throws com.excilys.liferay.gatling.NoSuchFormParamException if a form param with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public FormParam remove(long formParamId)
        throws NoSuchFormParamException, SystemException {
        return remove((Serializable) formParamId);
    }

    /**
     * Removes the form param with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the form param
     * @return the form param that was removed
     * @throws com.excilys.liferay.gatling.NoSuchFormParamException if a form param with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public FormParam remove(Serializable primaryKey)
        throws NoSuchFormParamException, SystemException {
        Session session = null;

        try {
            session = openSession();

            FormParam formParam = (FormParam) session.get(FormParamImpl.class,
                    primaryKey);

            if (formParam == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchFormParamException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(formParam);
        } catch (NoSuchFormParamException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected FormParam removeImpl(FormParam formParam)
        throws SystemException {
        formParam = toUnwrappedModel(formParam);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(formParam)) {
                formParam = (FormParam) session.get(FormParamImpl.class,
                        formParam.getPrimaryKeyObj());
            }

            if (formParam != null) {
                session.delete(formParam);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (formParam != null) {
            clearCache(formParam);
        }

        return formParam;
    }

    @Override
    public FormParam updateImpl(
        com.excilys.liferay.gatling.model.FormParam formParam)
        throws SystemException {
        formParam = toUnwrappedModel(formParam);

        boolean isNew = formParam.isNew();

        FormParamModelImpl formParamModelImpl = (FormParamModelImpl) formParam;

        Session session = null;

        try {
            session = openSession();

            if (formParam.isNew()) {
                session.save(formParam);

                formParam.setNew(false);
            } else {
                session.merge(formParam);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !FormParamModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((formParamModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_URLRECORDID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        formParamModelImpl.getOriginalUrlRecordId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_URLRECORDID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_URLRECORDID,
                    args);

                args = new Object[] { formParamModelImpl.getUrlRecordId() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_URLRECORDID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_URLRECORDID,
                    args);
            }
        }

        EntityCacheUtil.putResult(FormParamModelImpl.ENTITY_CACHE_ENABLED,
            FormParamImpl.class, formParam.getPrimaryKey(), formParam);

        return formParam;
    }

    protected FormParam toUnwrappedModel(FormParam formParam) {
        if (formParam instanceof FormParamImpl) {
            return formParam;
        }

        FormParamImpl formParamImpl = new FormParamImpl();

        formParamImpl.setNew(formParam.isNew());
        formParamImpl.setPrimaryKey(formParam.getPrimaryKey());

        formParamImpl.setFormParamId(formParam.getFormParamId());
        formParamImpl.setUrlRecordId(formParam.getUrlRecordId());
        formParamImpl.setKey(formParam.getKey());
        formParamImpl.setValue(formParam.getValue());

        return formParamImpl;
    }

    /**
     * Returns the form param with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the form param
     * @return the form param
     * @throws com.excilys.liferay.gatling.NoSuchFormParamException if a form param with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public FormParam findByPrimaryKey(Serializable primaryKey)
        throws NoSuchFormParamException, SystemException {
        FormParam formParam = fetchByPrimaryKey(primaryKey);

        if (formParam == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchFormParamException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return formParam;
    }

    /**
     * Returns the form param with the primary key or throws a {@link com.excilys.liferay.gatling.NoSuchFormParamException} if it could not be found.
     *
     * @param formParamId the primary key of the form param
     * @return the form param
     * @throws com.excilys.liferay.gatling.NoSuchFormParamException if a form param with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public FormParam findByPrimaryKey(long formParamId)
        throws NoSuchFormParamException, SystemException {
        return findByPrimaryKey((Serializable) formParamId);
    }

    /**
     * Returns the form param with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the form param
     * @return the form param, or <code>null</code> if a form param with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public FormParam fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        FormParam formParam = (FormParam) EntityCacheUtil.getResult(FormParamModelImpl.ENTITY_CACHE_ENABLED,
                FormParamImpl.class, primaryKey);

        if (formParam == _nullFormParam) {
            return null;
        }

        if (formParam == null) {
            Session session = null;

            try {
                session = openSession();

                formParam = (FormParam) session.get(FormParamImpl.class,
                        primaryKey);

                if (formParam != null) {
                    cacheResult(formParam);
                } else {
                    EntityCacheUtil.putResult(FormParamModelImpl.ENTITY_CACHE_ENABLED,
                        FormParamImpl.class, primaryKey, _nullFormParam);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(FormParamModelImpl.ENTITY_CACHE_ENABLED,
                    FormParamImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return formParam;
    }

    /**
     * Returns the form param with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param formParamId the primary key of the form param
     * @return the form param, or <code>null</code> if a form param with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public FormParam fetchByPrimaryKey(long formParamId)
        throws SystemException {
        return fetchByPrimaryKey((Serializable) formParamId);
    }

    /**
     * Returns all the form params.
     *
     * @return the form params
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<FormParam> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the form params.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.excilys.liferay.gatling.model.impl.FormParamModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of form params
     * @param end the upper bound of the range of form params (not inclusive)
     * @return the range of form params
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<FormParam> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the form params.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.excilys.liferay.gatling.model.impl.FormParamModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of form params
     * @param end the upper bound of the range of form params (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of form params
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<FormParam> findAll(int start, int end,
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

        List<FormParam> list = (List<FormParam>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_FORMPARAM);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_FORMPARAM;

                if (pagination) {
                    sql = sql.concat(FormParamModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<FormParam>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<FormParam>(list);
                } else {
                    list = (List<FormParam>) QueryUtil.list(q, getDialect(),
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
     * Removes all the form params from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (FormParam formParam : findAll()) {
            remove(formParam);
        }
    }

    /**
     * Returns the number of form params.
     *
     * @return the number of form params
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

                Query q = session.createQuery(_SQL_COUNT_FORMPARAM);

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
     * Initializes the form param persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.excilys.liferay.gatling.model.FormParam")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<FormParam>> listenersList = new ArrayList<ModelListener<FormParam>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<FormParam>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(FormParamImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
