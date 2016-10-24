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

import io.gatling.liferay.NoSuchScenarioException;
import io.gatling.liferay.model.Scenario;
import io.gatling.liferay.model.impl.ScenarioImpl;
import io.gatling.liferay.model.impl.ScenarioModelImpl;
import io.gatling.liferay.service.persistence.ScenarioPersistence;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the scenario service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ScenarioPersistence
 * @see ScenarioUtil
 * @generated
 */
public class ScenarioPersistenceImpl extends BasePersistenceImpl<Scenario>
    implements ScenarioPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link ScenarioUtil} to access the scenario persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = ScenarioImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ScenarioModelImpl.ENTITY_CACHE_ENABLED,
            ScenarioModelImpl.FINDER_CACHE_ENABLED, ScenarioImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ScenarioModelImpl.ENTITY_CACHE_ENABLED,
            ScenarioModelImpl.FINDER_CACHE_ENABLED, ScenarioImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ScenarioModelImpl.ENTITY_CACHE_ENABLED,
            ScenarioModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_SIMULATIONID =
        new FinderPath(ScenarioModelImpl.ENTITY_CACHE_ENABLED,
            ScenarioModelImpl.FINDER_CACHE_ENABLED, ScenarioImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBySimulationId",
            new String[] {
                Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SIMULATIONID =
        new FinderPath(ScenarioModelImpl.ENTITY_CACHE_ENABLED,
            ScenarioModelImpl.FINDER_CACHE_ENABLED, ScenarioImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBySimulationId",
            new String[] { Long.class.getName() },
            ScenarioModelImpl.SIMULATION_ID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_SIMULATIONID = new FinderPath(ScenarioModelImpl.ENTITY_CACHE_ENABLED,
            ScenarioModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBySimulationId",
            new String[] { Long.class.getName() });
    private static final String _FINDER_COLUMN_SIMULATIONID_SIMULATION_ID_2 = "scenario.simulation_id = ?";
    public static final FinderPath FINDER_PATH_FETCH_BY_NAME = new FinderPath(ScenarioModelImpl.ENTITY_CACHE_ENABLED,
            ScenarioModelImpl.FINDER_CACHE_ENABLED, ScenarioImpl.class,
            FINDER_CLASS_NAME_ENTITY, "fetchByName",
            new String[] { String.class.getName() },
            ScenarioModelImpl.NAME_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_NAME = new FinderPath(ScenarioModelImpl.ENTITY_CACHE_ENABLED,
            ScenarioModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByName",
            new String[] { String.class.getName() });
    private static final String _FINDER_COLUMN_NAME_NAME_1 = "scenario.name IS NULL";
    private static final String _FINDER_COLUMN_NAME_NAME_2 = "scenario.name = ?";
    private static final String _FINDER_COLUMN_NAME_NAME_3 = "(scenario.name IS NULL OR scenario.name = '')";
    private static final String _SQL_SELECT_SCENARIO = "SELECT scenario FROM Scenario scenario";
    private static final String _SQL_SELECT_SCENARIO_WHERE = "SELECT scenario FROM Scenario scenario WHERE ";
    private static final String _SQL_COUNT_SCENARIO = "SELECT COUNT(scenario) FROM Scenario scenario";
    private static final String _SQL_COUNT_SCENARIO_WHERE = "SELECT COUNT(scenario) FROM Scenario scenario WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "scenario.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Scenario exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Scenario exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(ScenarioPersistenceImpl.class);
    private static Scenario _nullScenario = new ScenarioImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<Scenario> toCacheModel() {
                return _nullScenarioCacheModel;
            }
        };

    private static CacheModel<Scenario> _nullScenarioCacheModel = new CacheModel<Scenario>() {
            @Override
            public Scenario toEntityModel() {
                return _nullScenario;
            }
        };

    public ScenarioPersistenceImpl() {
        setModelClass(Scenario.class);
    }

    /**
     * Returns all the scenarios where simulation_id = &#63;.
     *
     * @param simulation_id the simulation_id
     * @return the matching scenarios
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Scenario> findBySimulationId(long simulation_id)
        throws SystemException {
        return findBySimulationId(simulation_id, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the scenarios where simulation_id = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link io.gatling.liferay.model.impl.ScenarioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param simulation_id the simulation_id
     * @param start the lower bound of the range of scenarios
     * @param end the upper bound of the range of scenarios (not inclusive)
     * @return the range of matching scenarios
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Scenario> findBySimulationId(long simulation_id, int start,
        int end) throws SystemException {
        return findBySimulationId(simulation_id, start, end, null);
    }

    /**
     * Returns an ordered range of all the scenarios where simulation_id = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link io.gatling.liferay.model.impl.ScenarioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param simulation_id the simulation_id
     * @param start the lower bound of the range of scenarios
     * @param end the upper bound of the range of scenarios (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching scenarios
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Scenario> findBySimulationId(long simulation_id, int start,
        int end, OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SIMULATIONID;
            finderArgs = new Object[] { simulation_id };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_SIMULATIONID;
            finderArgs = new Object[] {
                    simulation_id,
                    
                    start, end, orderByComparator
                };
        }

        List<Scenario> list = (List<Scenario>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Scenario scenario : list) {
                if ((simulation_id != scenario.getSimulation_id())) {
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

            query.append(_SQL_SELECT_SCENARIO_WHERE);

            query.append(_FINDER_COLUMN_SIMULATIONID_SIMULATION_ID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(ScenarioModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(simulation_id);

                if (!pagination) {
                    list = (List<Scenario>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Scenario>(list);
                } else {
                    list = (List<Scenario>) QueryUtil.list(q, getDialect(),
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
     * Returns the first scenario in the ordered set where simulation_id = &#63;.
     *
     * @param simulation_id the simulation_id
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching scenario
     * @throws io.gatling.liferay.NoSuchScenarioException if a matching scenario could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Scenario findBySimulationId_First(long simulation_id,
        OrderByComparator orderByComparator)
        throws NoSuchScenarioException, SystemException {
        Scenario scenario = fetchBySimulationId_First(simulation_id,
                orderByComparator);

        if (scenario != null) {
            return scenario;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("simulation_id=");
        msg.append(simulation_id);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchScenarioException(msg.toString());
    }

    /**
     * Returns the first scenario in the ordered set where simulation_id = &#63;.
     *
     * @param simulation_id the simulation_id
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching scenario, or <code>null</code> if a matching scenario could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Scenario fetchBySimulationId_First(long simulation_id,
        OrderByComparator orderByComparator) throws SystemException {
        List<Scenario> list = findBySimulationId(simulation_id, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last scenario in the ordered set where simulation_id = &#63;.
     *
     * @param simulation_id the simulation_id
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching scenario
     * @throws io.gatling.liferay.NoSuchScenarioException if a matching scenario could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Scenario findBySimulationId_Last(long simulation_id,
        OrderByComparator orderByComparator)
        throws NoSuchScenarioException, SystemException {
        Scenario scenario = fetchBySimulationId_Last(simulation_id,
                orderByComparator);

        if (scenario != null) {
            return scenario;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("simulation_id=");
        msg.append(simulation_id);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchScenarioException(msg.toString());
    }

    /**
     * Returns the last scenario in the ordered set where simulation_id = &#63;.
     *
     * @param simulation_id the simulation_id
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching scenario, or <code>null</code> if a matching scenario could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Scenario fetchBySimulationId_Last(long simulation_id,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countBySimulationId(simulation_id);

        if (count == 0) {
            return null;
        }

        List<Scenario> list = findBySimulationId(simulation_id, count - 1,
                count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the scenarios before and after the current scenario in the ordered set where simulation_id = &#63;.
     *
     * @param scenario_id the primary key of the current scenario
     * @param simulation_id the simulation_id
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next scenario
     * @throws io.gatling.liferay.NoSuchScenarioException if a scenario with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Scenario[] findBySimulationId_PrevAndNext(long scenario_id,
        long simulation_id, OrderByComparator orderByComparator)
        throws NoSuchScenarioException, SystemException {
        Scenario scenario = findByPrimaryKey(scenario_id);

        Session session = null;

        try {
            session = openSession();

            Scenario[] array = new ScenarioImpl[3];

            array[0] = getBySimulationId_PrevAndNext(session, scenario,
                    simulation_id, orderByComparator, true);

            array[1] = scenario;

            array[2] = getBySimulationId_PrevAndNext(session, scenario,
                    simulation_id, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Scenario getBySimulationId_PrevAndNext(Session session,
        Scenario scenario, long simulation_id,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_SCENARIO_WHERE);

        query.append(_FINDER_COLUMN_SIMULATIONID_SIMULATION_ID_2);

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
            query.append(ScenarioModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(simulation_id);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(scenario);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Scenario> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the scenarios where simulation_id = &#63; from the database.
     *
     * @param simulation_id the simulation_id
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeBySimulationId(long simulation_id)
        throws SystemException {
        for (Scenario scenario : findBySimulationId(simulation_id,
                QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(scenario);
        }
    }

    /**
     * Returns the number of scenarios where simulation_id = &#63;.
     *
     * @param simulation_id the simulation_id
     * @return the number of matching scenarios
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countBySimulationId(long simulation_id)
        throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_SIMULATIONID;

        Object[] finderArgs = new Object[] { simulation_id };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_SCENARIO_WHERE);

            query.append(_FINDER_COLUMN_SIMULATIONID_SIMULATION_ID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(simulation_id);

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
     * Returns the scenario where name = &#63; or throws a {@link io.gatling.liferay.NoSuchScenarioException} if it could not be found.
     *
     * @param name the name
     * @return the matching scenario
     * @throws io.gatling.liferay.NoSuchScenarioException if a matching scenario could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Scenario findByName(String name)
        throws NoSuchScenarioException, SystemException {
        Scenario scenario = fetchByName(name);

        if (scenario == null) {
            StringBundler msg = new StringBundler(4);

            msg.append(_NO_SUCH_ENTITY_WITH_KEY);

            msg.append("name=");
            msg.append(name);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            if (_log.isWarnEnabled()) {
                _log.warn(msg.toString());
            }

            throw new NoSuchScenarioException(msg.toString());
        }

        return scenario;
    }

    /**
     * Returns the scenario where name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
     *
     * @param name the name
     * @return the matching scenario, or <code>null</code> if a matching scenario could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Scenario fetchByName(String name) throws SystemException {
        return fetchByName(name, true);
    }

    /**
     * Returns the scenario where name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
     *
     * @param name the name
     * @param retrieveFromCache whether to use the finder cache
     * @return the matching scenario, or <code>null</code> if a matching scenario could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Scenario fetchByName(String name, boolean retrieveFromCache)
        throws SystemException {
        Object[] finderArgs = new Object[] { name };

        Object result = null;

        if (retrieveFromCache) {
            result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_NAME,
                    finderArgs, this);
        }

        if (result instanceof Scenario) {
            Scenario scenario = (Scenario) result;

            if (!Validator.equals(name, scenario.getName())) {
                result = null;
            }
        }

        if (result == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_SELECT_SCENARIO_WHERE);

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

                List<Scenario> list = q.list();

                if (list.isEmpty()) {
                    FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAME,
                        finderArgs, list);
                } else {
                    Scenario scenario = list.get(0);

                    result = scenario;

                    cacheResult(scenario);

                    if ((scenario.getName() == null) ||
                            !scenario.getName().equals(name)) {
                        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAME,
                            finderArgs, scenario);
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
            return (Scenario) result;
        }
    }

    /**
     * Removes the scenario where name = &#63; from the database.
     *
     * @param name the name
     * @return the scenario that was removed
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Scenario removeByName(String name)
        throws NoSuchScenarioException, SystemException {
        Scenario scenario = findByName(name);

        return remove(scenario);
    }

    /**
     * Returns the number of scenarios where name = &#63;.
     *
     * @param name the name
     * @return the number of matching scenarios
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

            query.append(_SQL_COUNT_SCENARIO_WHERE);

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
     * Caches the scenario in the entity cache if it is enabled.
     *
     * @param scenario the scenario
     */
    @Override
    public void cacheResult(Scenario scenario) {
        EntityCacheUtil.putResult(ScenarioModelImpl.ENTITY_CACHE_ENABLED,
            ScenarioImpl.class, scenario.getPrimaryKey(), scenario);

        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAME,
            new Object[] { scenario.getName() }, scenario);

        scenario.resetOriginalValues();
    }

    /**
     * Caches the scenarios in the entity cache if it is enabled.
     *
     * @param scenarios the scenarios
     */
    @Override
    public void cacheResult(List<Scenario> scenarios) {
        for (Scenario scenario : scenarios) {
            if (EntityCacheUtil.getResult(
                        ScenarioModelImpl.ENTITY_CACHE_ENABLED,
                        ScenarioImpl.class, scenario.getPrimaryKey()) == null) {
                cacheResult(scenario);
            } else {
                scenario.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all scenarios.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(ScenarioImpl.class.getName());
        }

        EntityCacheUtil.clearCache(ScenarioImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the scenario.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(Scenario scenario) {
        EntityCacheUtil.removeResult(ScenarioModelImpl.ENTITY_CACHE_ENABLED,
            ScenarioImpl.class, scenario.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        clearUniqueFindersCache(scenario);
    }

    @Override
    public void clearCache(List<Scenario> scenarios) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (Scenario scenario : scenarios) {
            EntityCacheUtil.removeResult(ScenarioModelImpl.ENTITY_CACHE_ENABLED,
                ScenarioImpl.class, scenario.getPrimaryKey());

            clearUniqueFindersCache(scenario);
        }
    }

    protected void cacheUniqueFindersCache(Scenario scenario) {
        if (scenario.isNew()) {
            Object[] args = new Object[] { scenario.getName() };

            FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_NAME, args,
                Long.valueOf(1));
            FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAME, args, scenario);
        } else {
            ScenarioModelImpl scenarioModelImpl = (ScenarioModelImpl) scenario;

            if ((scenarioModelImpl.getColumnBitmask() &
                    FINDER_PATH_FETCH_BY_NAME.getColumnBitmask()) != 0) {
                Object[] args = new Object[] { scenario.getName() };

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_NAME, args,
                    Long.valueOf(1));
                FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAME, args,
                    scenario);
            }
        }
    }

    protected void clearUniqueFindersCache(Scenario scenario) {
        ScenarioModelImpl scenarioModelImpl = (ScenarioModelImpl) scenario;

        Object[] args = new Object[] { scenario.getName() };

        FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NAME, args);
        FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_NAME, args);

        if ((scenarioModelImpl.getColumnBitmask() &
                FINDER_PATH_FETCH_BY_NAME.getColumnBitmask()) != 0) {
            args = new Object[] { scenarioModelImpl.getOriginalName() };

            FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NAME, args);
            FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_NAME, args);
        }
    }

    /**
     * Creates a new scenario with the primary key. Does not add the scenario to the database.
     *
     * @param scenario_id the primary key for the new scenario
     * @return the new scenario
     */
    @Override
    public Scenario create(long scenario_id) {
        Scenario scenario = new ScenarioImpl();

        scenario.setNew(true);
        scenario.setPrimaryKey(scenario_id);

        return scenario;
    }

    /**
     * Removes the scenario with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param scenario_id the primary key of the scenario
     * @return the scenario that was removed
     * @throws io.gatling.liferay.NoSuchScenarioException if a scenario with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Scenario remove(long scenario_id)
        throws NoSuchScenarioException, SystemException {
        return remove((Serializable) scenario_id);
    }

    /**
     * Removes the scenario with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the scenario
     * @return the scenario that was removed
     * @throws io.gatling.liferay.NoSuchScenarioException if a scenario with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Scenario remove(Serializable primaryKey)
        throws NoSuchScenarioException, SystemException {
        Session session = null;

        try {
            session = openSession();

            Scenario scenario = (Scenario) session.get(ScenarioImpl.class,
                    primaryKey);

            if (scenario == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchScenarioException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(scenario);
        } catch (NoSuchScenarioException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected Scenario removeImpl(Scenario scenario) throws SystemException {
        scenario = toUnwrappedModel(scenario);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(scenario)) {
                scenario = (Scenario) session.get(ScenarioImpl.class,
                        scenario.getPrimaryKeyObj());
            }

            if (scenario != null) {
                session.delete(scenario);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (scenario != null) {
            clearCache(scenario);
        }

        return scenario;
    }

    @Override
    public Scenario updateImpl(io.gatling.liferay.model.Scenario scenario)
        throws SystemException {
        scenario = toUnwrappedModel(scenario);

        boolean isNew = scenario.isNew();

        ScenarioModelImpl scenarioModelImpl = (ScenarioModelImpl) scenario;

        Session session = null;

        try {
            session = openSession();

            if (scenario.isNew()) {
                session.save(scenario);

                scenario.setNew(false);
            } else {
                session.merge(scenario);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !ScenarioModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((scenarioModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SIMULATIONID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        scenarioModelImpl.getOriginalSimulation_id()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SIMULATIONID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SIMULATIONID,
                    args);

                args = new Object[] { scenarioModelImpl.getSimulation_id() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SIMULATIONID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SIMULATIONID,
                    args);
            }
        }

        EntityCacheUtil.putResult(ScenarioModelImpl.ENTITY_CACHE_ENABLED,
            ScenarioImpl.class, scenario.getPrimaryKey(), scenario);

        clearUniqueFindersCache(scenario);
        cacheUniqueFindersCache(scenario);

        return scenario;
    }

    protected Scenario toUnwrappedModel(Scenario scenario) {
        if (scenario instanceof ScenarioImpl) {
            return scenario;
        }

        ScenarioImpl scenarioImpl = new ScenarioImpl();

        scenarioImpl.setNew(scenario.isNew());
        scenarioImpl.setPrimaryKey(scenario.getPrimaryKey());

        scenarioImpl.setScenario_id(scenario.getScenario_id());
        scenarioImpl.setName(scenario.getName());
        scenarioImpl.setUrl_site(scenario.getUrl_site());
        scenarioImpl.setGroup_id(scenario.getGroup_id());
        scenarioImpl.setSimulation_id(scenario.getSimulation_id());
        scenarioImpl.setNumberOfUsers(scenario.getNumberOfUsers());
        scenarioImpl.setDuration(scenario.getDuration());
        scenarioImpl.setInjection(scenario.getInjection());

        return scenarioImpl;
    }

    /**
     * Returns the scenario with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the scenario
     * @return the scenario
     * @throws io.gatling.liferay.NoSuchScenarioException if a scenario with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Scenario findByPrimaryKey(Serializable primaryKey)
        throws NoSuchScenarioException, SystemException {
        Scenario scenario = fetchByPrimaryKey(primaryKey);

        if (scenario == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchScenarioException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return scenario;
    }

    /**
     * Returns the scenario with the primary key or throws a {@link io.gatling.liferay.NoSuchScenarioException} if it could not be found.
     *
     * @param scenario_id the primary key of the scenario
     * @return the scenario
     * @throws io.gatling.liferay.NoSuchScenarioException if a scenario with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Scenario findByPrimaryKey(long scenario_id)
        throws NoSuchScenarioException, SystemException {
        return findByPrimaryKey((Serializable) scenario_id);
    }

    /**
     * Returns the scenario with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the scenario
     * @return the scenario, or <code>null</code> if a scenario with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Scenario fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        Scenario scenario = (Scenario) EntityCacheUtil.getResult(ScenarioModelImpl.ENTITY_CACHE_ENABLED,
                ScenarioImpl.class, primaryKey);

        if (scenario == _nullScenario) {
            return null;
        }

        if (scenario == null) {
            Session session = null;

            try {
                session = openSession();

                scenario = (Scenario) session.get(ScenarioImpl.class, primaryKey);

                if (scenario != null) {
                    cacheResult(scenario);
                } else {
                    EntityCacheUtil.putResult(ScenarioModelImpl.ENTITY_CACHE_ENABLED,
                        ScenarioImpl.class, primaryKey, _nullScenario);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(ScenarioModelImpl.ENTITY_CACHE_ENABLED,
                    ScenarioImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return scenario;
    }

    /**
     * Returns the scenario with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param scenario_id the primary key of the scenario
     * @return the scenario, or <code>null</code> if a scenario with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Scenario fetchByPrimaryKey(long scenario_id)
        throws SystemException {
        return fetchByPrimaryKey((Serializable) scenario_id);
    }

    /**
     * Returns all the scenarios.
     *
     * @return the scenarios
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Scenario> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the scenarios.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link io.gatling.liferay.model.impl.ScenarioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of scenarios
     * @param end the upper bound of the range of scenarios (not inclusive)
     * @return the range of scenarios
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Scenario> findAll(int start, int end) throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the scenarios.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link io.gatling.liferay.model.impl.ScenarioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of scenarios
     * @param end the upper bound of the range of scenarios (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of scenarios
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Scenario> findAll(int start, int end,
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

        List<Scenario> list = (List<Scenario>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_SCENARIO);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_SCENARIO;

                if (pagination) {
                    sql = sql.concat(ScenarioModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<Scenario>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Scenario>(list);
                } else {
                    list = (List<Scenario>) QueryUtil.list(q, getDialect(),
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
     * Removes all the scenarios from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (Scenario scenario : findAll()) {
            remove(scenario);
        }
    }

    /**
     * Returns the number of scenarios.
     *
     * @return the number of scenarios
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

                Query q = session.createQuery(_SQL_COUNT_SCENARIO);

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
     * Initializes the scenario persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.io.gatling.liferay.model.Scenario")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<Scenario>> listenersList = new ArrayList<ModelListener<Scenario>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<Scenario>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(ScenarioImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
