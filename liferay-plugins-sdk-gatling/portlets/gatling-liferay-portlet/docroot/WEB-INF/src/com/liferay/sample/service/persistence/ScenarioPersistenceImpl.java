/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 *
 *
 *
 */

package com.liferay.sample.service.persistence;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
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
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.liferay.sample.NoSuchScenarioException;
import com.liferay.sample.model.Scenario;
import com.liferay.sample.model.impl.ScenarioImpl;
import com.liferay.sample.model.impl.ScenarioModelImpl;

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
 * @author sana
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

	public ScenarioPersistenceImpl() {
		setModelClass(Scenario.class);
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
			}
			else {
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
	}

	@Override
	public void clearCache(List<Scenario> scenarios) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Scenario scenario : scenarios) {
			EntityCacheUtil.removeResult(ScenarioModelImpl.ENTITY_CACHE_ENABLED,
				ScenarioImpl.class, scenario.getPrimaryKey());
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
	 * @throws com.liferay.sample.NoSuchScenarioException if a scenario with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Scenario remove(long scenario_id)
		throws NoSuchScenarioException, SystemException {
		return remove((Serializable)scenario_id);
	}

	/**
	 * Removes the scenario with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the scenario
	 * @return the scenario that was removed
	 * @throws com.liferay.sample.NoSuchScenarioException if a scenario with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Scenario remove(Serializable primaryKey)
		throws NoSuchScenarioException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Scenario scenario = (Scenario)session.get(ScenarioImpl.class,
					primaryKey);

			if (scenario == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchScenarioException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(scenario);
		}
		catch (NoSuchScenarioException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
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
				scenario = (Scenario)session.get(ScenarioImpl.class,
						scenario.getPrimaryKeyObj());
			}

			if (scenario != null) {
				session.delete(scenario);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (scenario != null) {
			clearCache(scenario);
		}

		return scenario;
	}

	@Override
	public Scenario updateImpl(com.liferay.sample.model.Scenario scenario)
		throws SystemException {
		scenario = toUnwrappedModel(scenario);

		boolean isNew = scenario.isNew();

		Session session = null;

		try {
			session = openSession();

			if (scenario.isNew()) {
				session.save(scenario);

				scenario.setNew(false);
			}
			else {
				session.merge(scenario);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(ScenarioModelImpl.ENTITY_CACHE_ENABLED,
			ScenarioImpl.class, scenario.getPrimaryKey(), scenario);

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
		scenarioImpl.setSimulation_id(scenario.getSimulation_id());

		return scenarioImpl;
	}

	/**
	 * Returns the scenario with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the scenario
	 * @return the scenario
	 * @throws com.liferay.sample.NoSuchScenarioException if a scenario with the primary key could not be found
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
	 * Returns the scenario with the primary key or throws a {@link com.liferay.sample.NoSuchScenarioException} if it could not be found.
	 *
	 * @param scenario_id the primary key of the scenario
	 * @return the scenario
	 * @throws com.liferay.sample.NoSuchScenarioException if a scenario with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Scenario findByPrimaryKey(long scenario_id)
		throws NoSuchScenarioException, SystemException {
		return findByPrimaryKey((Serializable)scenario_id);
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
		Scenario scenario = (Scenario)EntityCacheUtil.getResult(ScenarioModelImpl.ENTITY_CACHE_ENABLED,
				ScenarioImpl.class, primaryKey);

		if (scenario == _nullScenario) {
			return null;
		}

		if (scenario == null) {
			Session session = null;

			try {
				session = openSession();

				scenario = (Scenario)session.get(ScenarioImpl.class, primaryKey);

				if (scenario != null) {
					cacheResult(scenario);
				}
				else {
					EntityCacheUtil.putResult(ScenarioModelImpl.ENTITY_CACHE_ENABLED,
						ScenarioImpl.class, primaryKey, _nullScenario);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ScenarioModelImpl.ENTITY_CACHE_ENABLED,
					ScenarioImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
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
		return fetchByPrimaryKey((Serializable)scenario_id);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.sample.model.impl.ScenarioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.sample.model.impl.ScenarioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<Scenario> list = (List<Scenario>)FinderCacheUtil.getResult(finderPath,
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
			}
			else {
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
					list = (List<Scenario>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Scenario>(list);
				}
				else {
					list = (List<Scenario>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
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
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_SCENARIO);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
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
						"value.object.listener.com.liferay.sample.model.Scenario")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Scenario>> listenersList = new ArrayList<ModelListener<Scenario>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Scenario>)InstanceFactory.newInstance(
							getClassLoader(), listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
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

	private static final String _SQL_SELECT_SCENARIO = "SELECT scenario FROM Scenario scenario";
	private static final String _SQL_COUNT_SCENARIO = "SELECT COUNT(scenario) FROM Scenario scenario";
	private static final String _ORDER_BY_ENTITY_ALIAS = "scenario.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Scenario exists with the primary key ";
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
}