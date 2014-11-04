/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.excilys.liferay.gatling.service.persistence;

import com.excilys.liferay.gatling.NoSuchSimulationException;
import com.excilys.liferay.gatling.model.Simulation;
import com.excilys.liferay.gatling.model.impl.SimulationImpl;
import com.excilys.liferay.gatling.model.impl.SimulationModelImpl;

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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the simulation service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SimulationPersistence
 * @see SimulationUtil
 * @generated
 */
public class SimulationPersistenceImpl extends BasePersistenceImpl<Simulation>
	implements SimulationPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SimulationUtil} to access the simulation persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SimulationImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SimulationModelImpl.ENTITY_CACHE_ENABLED,
			SimulationModelImpl.FINDER_CACHE_ENABLED, SimulationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SimulationModelImpl.ENTITY_CACHE_ENABLED,
			SimulationModelImpl.FINDER_CACHE_ENABLED, SimulationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SimulationModelImpl.ENTITY_CACHE_ENABLED,
			SimulationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public SimulationPersistenceImpl() {
		setModelClass(Simulation.class);
	}

	/**
	 * Caches the simulation in the entity cache if it is enabled.
	 *
	 * @param simulation the simulation
	 */
	@Override
	public void cacheResult(Simulation simulation) {
		EntityCacheUtil.putResult(SimulationModelImpl.ENTITY_CACHE_ENABLED,
			SimulationImpl.class, simulation.getPrimaryKey(), simulation);

		simulation.resetOriginalValues();
	}

	/**
	 * Caches the simulations in the entity cache if it is enabled.
	 *
	 * @param simulations the simulations
	 */
	@Override
	public void cacheResult(List<Simulation> simulations) {
		for (Simulation simulation : simulations) {
			if (EntityCacheUtil.getResult(
						SimulationModelImpl.ENTITY_CACHE_ENABLED,
						SimulationImpl.class, simulation.getPrimaryKey()) == null) {
				cacheResult(simulation);
			}
			else {
				simulation.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all simulations.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(SimulationImpl.class.getName());
		}

		EntityCacheUtil.clearCache(SimulationImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the simulation.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Simulation simulation) {
		EntityCacheUtil.removeResult(SimulationModelImpl.ENTITY_CACHE_ENABLED,
			SimulationImpl.class, simulation.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Simulation> simulations) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Simulation simulation : simulations) {
			EntityCacheUtil.removeResult(SimulationModelImpl.ENTITY_CACHE_ENABLED,
				SimulationImpl.class, simulation.getPrimaryKey());
		}
	}

	/**
	 * Creates a new simulation with the primary key. Does not add the simulation to the database.
	 *
	 * @param simulation_id the primary key for the new simulation
	 * @return the new simulation
	 */
	@Override
	public Simulation create(long simulation_id) {
		Simulation simulation = new SimulationImpl();

		simulation.setNew(true);
		simulation.setPrimaryKey(simulation_id);

		return simulation;
	}

	/**
	 * Removes the simulation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param simulation_id the primary key of the simulation
	 * @return the simulation that was removed
	 * @throws com.excilys.liferay.gatling.NoSuchSimulationException if a simulation with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Simulation remove(long simulation_id)
		throws NoSuchSimulationException, SystemException {
		return remove((Serializable)simulation_id);
	}

	/**
	 * Removes the simulation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the simulation
	 * @return the simulation that was removed
	 * @throws com.excilys.liferay.gatling.NoSuchSimulationException if a simulation with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Simulation remove(Serializable primaryKey)
		throws NoSuchSimulationException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Simulation simulation = (Simulation)session.get(SimulationImpl.class,
					primaryKey);

			if (simulation == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSimulationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(simulation);
		}
		catch (NoSuchSimulationException nsee) {
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
	protected Simulation removeImpl(Simulation simulation)
		throws SystemException {
		simulation = toUnwrappedModel(simulation);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(simulation)) {
				simulation = (Simulation)session.get(SimulationImpl.class,
						simulation.getPrimaryKeyObj());
			}

			if (simulation != null) {
				session.delete(simulation);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (simulation != null) {
			clearCache(simulation);
		}

		return simulation;
	}

	@Override
	public Simulation updateImpl(
		com.excilys.liferay.gatling.model.Simulation simulation)
		throws SystemException {
		simulation = toUnwrappedModel(simulation);

		boolean isNew = simulation.isNew();

		Session session = null;

		try {
			session = openSession();

			if (simulation.isNew()) {
				session.save(simulation);

				simulation.setNew(false);
			}
			else {
				session.merge(simulation);
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

		EntityCacheUtil.putResult(SimulationModelImpl.ENTITY_CACHE_ENABLED,
			SimulationImpl.class, simulation.getPrimaryKey(), simulation);

		return simulation;
	}

	protected Simulation toUnwrappedModel(Simulation simulation) {
		if (simulation instanceof SimulationImpl) {
			return simulation;
		}

		SimulationImpl simulationImpl = new SimulationImpl();

		simulationImpl.setNew(simulation.isNew());
		simulationImpl.setPrimaryKey(simulation.getPrimaryKey());

		simulationImpl.setSimulation_id(simulation.getSimulation_id());
		simulationImpl.setName(simulation.getName());
		simulationImpl.setFeederContent(simulation.getFeederContent());
		simulationImpl.setIsFeederAFile(simulation.isIsFeederAFile());

		return simulationImpl;
	}

	/**
	 * Returns the simulation with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the simulation
	 * @return the simulation
	 * @throws com.excilys.liferay.gatling.NoSuchSimulationException if a simulation with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Simulation findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSimulationException, SystemException {
		Simulation simulation = fetchByPrimaryKey(primaryKey);

		if (simulation == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSimulationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return simulation;
	}

	/**
	 * Returns the simulation with the primary key or throws a {@link com.excilys.liferay.gatling.NoSuchSimulationException} if it could not be found.
	 *
	 * @param simulation_id the primary key of the simulation
	 * @return the simulation
	 * @throws com.excilys.liferay.gatling.NoSuchSimulationException if a simulation with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Simulation findByPrimaryKey(long simulation_id)
		throws NoSuchSimulationException, SystemException {
		return findByPrimaryKey((Serializable)simulation_id);
	}

	/**
	 * Returns the simulation with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the simulation
	 * @return the simulation, or <code>null</code> if a simulation with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Simulation fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Simulation simulation = (Simulation)EntityCacheUtil.getResult(SimulationModelImpl.ENTITY_CACHE_ENABLED,
				SimulationImpl.class, primaryKey);

		if (simulation == _nullSimulation) {
			return null;
		}

		if (simulation == null) {
			Session session = null;

			try {
				session = openSession();

				simulation = (Simulation)session.get(SimulationImpl.class,
						primaryKey);

				if (simulation != null) {
					cacheResult(simulation);
				}
				else {
					EntityCacheUtil.putResult(SimulationModelImpl.ENTITY_CACHE_ENABLED,
						SimulationImpl.class, primaryKey, _nullSimulation);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(SimulationModelImpl.ENTITY_CACHE_ENABLED,
					SimulationImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return simulation;
	}

	/**
	 * Returns the simulation with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param simulation_id the primary key of the simulation
	 * @return the simulation, or <code>null</code> if a simulation with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Simulation fetchByPrimaryKey(long simulation_id)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)simulation_id);
	}

	/**
	 * Returns all the simulations.
	 *
	 * @return the simulations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Simulation> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the simulations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.excilys.liferay.gatling.model.impl.SimulationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of simulations
	 * @param end the upper bound of the range of simulations (not inclusive)
	 * @return the range of simulations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Simulation> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the simulations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.excilys.liferay.gatling.model.impl.SimulationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of simulations
	 * @param end the upper bound of the range of simulations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of simulations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Simulation> findAll(int start, int end,
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

		List<Simulation> list = (List<Simulation>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SIMULATION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SIMULATION;

				if (pagination) {
					sql = sql.concat(SimulationModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Simulation>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Simulation>(list);
				}
				else {
					list = (List<Simulation>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the simulations from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Simulation simulation : findAll()) {
			remove(simulation);
		}
	}

	/**
	 * Returns the number of simulations.
	 *
	 * @return the number of simulations
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

				Query q = session.createQuery(_SQL_COUNT_SIMULATION);

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
	 * Initializes the simulation persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.excilys.liferay.gatling.model.Simulation")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Simulation>> listenersList = new ArrayList<ModelListener<Simulation>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Simulation>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(SimulationImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_SIMULATION = "SELECT simulation FROM Simulation simulation";
	private static final String _SQL_COUNT_SIMULATION = "SELECT COUNT(simulation) FROM Simulation simulation";
	private static final String _ORDER_BY_ENTITY_ALIAS = "simulation.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Simulation exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(SimulationPersistenceImpl.class);
	private static Simulation _nullSimulation = new SimulationImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Simulation> toCacheModel() {
				return _nullSimulationCacheModel;
			}
		};

	private static CacheModel<Simulation> _nullSimulationCacheModel = new CacheModel<Simulation>() {
			@Override
			public Simulation toEntityModel() {
				return _nullSimulation;
			}
		};
}