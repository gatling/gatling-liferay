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

import com.excilys.liferay.gatling.NoSuchUsecaseException;
import com.excilys.liferay.gatling.model.Usecase;
import com.excilys.liferay.gatling.model.impl.UsecaseImpl;
import com.excilys.liferay.gatling.model.impl.UsecaseModelImpl;

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
 * The persistence implementation for the usecase service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UsecasePersistence
 * @see UsecaseUtil
 * @generated
 */
public class UsecasePersistenceImpl extends BasePersistenceImpl<Usecase>
	implements UsecasePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link UsecaseUtil} to access the usecase persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = UsecaseImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(UsecaseModelImpl.ENTITY_CACHE_ENABLED,
			UsecaseModelImpl.FINDER_CACHE_ENABLED, UsecaseImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(UsecaseModelImpl.ENTITY_CACHE_ENABLED,
			UsecaseModelImpl.FINDER_CACHE_ENABLED, UsecaseImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(UsecaseModelImpl.ENTITY_CACHE_ENABLED,
			UsecaseModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public UsecasePersistenceImpl() {
		setModelClass(Usecase.class);
	}

	/**
	 * Caches the usecase in the entity cache if it is enabled.
	 *
	 * @param usecase the usecase
	 */
	@Override
	public void cacheResult(Usecase usecase) {
		EntityCacheUtil.putResult(UsecaseModelImpl.ENTITY_CACHE_ENABLED,
			UsecaseImpl.class, usecase.getPrimaryKey(), usecase);

		usecase.resetOriginalValues();
	}

	/**
	 * Caches the usecases in the entity cache if it is enabled.
	 *
	 * @param usecases the usecases
	 */
	@Override
	public void cacheResult(List<Usecase> usecases) {
		for (Usecase usecase : usecases) {
			if (EntityCacheUtil.getResult(
						UsecaseModelImpl.ENTITY_CACHE_ENABLED,
						UsecaseImpl.class, usecase.getPrimaryKey()) == null) {
				cacheResult(usecase);
			}
			else {
				usecase.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all usecases.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(UsecaseImpl.class.getName());
		}

		EntityCacheUtil.clearCache(UsecaseImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the usecase.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Usecase usecase) {
		EntityCacheUtil.removeResult(UsecaseModelImpl.ENTITY_CACHE_ENABLED,
			UsecaseImpl.class, usecase.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Usecase> usecases) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Usecase usecase : usecases) {
			EntityCacheUtil.removeResult(UsecaseModelImpl.ENTITY_CACHE_ENABLED,
				UsecaseImpl.class, usecase.getPrimaryKey());
		}
	}

	/**
	 * Creates a new usecase with the primary key. Does not add the usecase to the database.
	 *
	 * @param usecaseId the primary key for the new usecase
	 * @return the new usecase
	 */
	@Override
	public Usecase create(long usecaseId) {
		Usecase usecase = new UsecaseImpl();

		usecase.setNew(true);
		usecase.setPrimaryKey(usecaseId);

		return usecase;
	}

	/**
	 * Removes the usecase with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param usecaseId the primary key of the usecase
	 * @return the usecase that was removed
	 * @throws com.excilys.liferay.gatling.NoSuchUsecaseException if a usecase with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Usecase remove(long usecaseId)
		throws NoSuchUsecaseException, SystemException {
		return remove((Serializable)usecaseId);
	}

	/**
	 * Removes the usecase with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the usecase
	 * @return the usecase that was removed
	 * @throws com.excilys.liferay.gatling.NoSuchUsecaseException if a usecase with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Usecase remove(Serializable primaryKey)
		throws NoSuchUsecaseException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Usecase usecase = (Usecase)session.get(UsecaseImpl.class, primaryKey);

			if (usecase == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchUsecaseException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(usecase);
		}
		catch (NoSuchUsecaseException nsee) {
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
	protected Usecase removeImpl(Usecase usecase) throws SystemException {
		usecase = toUnwrappedModel(usecase);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(usecase)) {
				usecase = (Usecase)session.get(UsecaseImpl.class,
						usecase.getPrimaryKeyObj());
			}

			if (usecase != null) {
				session.delete(usecase);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (usecase != null) {
			clearCache(usecase);
		}

		return usecase;
	}

	@Override
	public Usecase updateImpl(com.excilys.liferay.gatling.model.Usecase usecase)
		throws SystemException {
		usecase = toUnwrappedModel(usecase);

		boolean isNew = usecase.isNew();

		Session session = null;

		try {
			session = openSession();

			if (usecase.isNew()) {
				session.save(usecase);

				usecase.setNew(false);
			}
			else {
				session.merge(usecase);
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

		EntityCacheUtil.putResult(UsecaseModelImpl.ENTITY_CACHE_ENABLED,
			UsecaseImpl.class, usecase.getPrimaryKey(), usecase);

		return usecase;
	}

	protected Usecase toUnwrappedModel(Usecase usecase) {
		if (usecase instanceof UsecaseImpl) {
			return usecase;
		}

		UsecaseImpl usecaseImpl = new UsecaseImpl();

		usecaseImpl.setNew(usecase.isNew());
		usecaseImpl.setPrimaryKey(usecase.getPrimaryKey());

		usecaseImpl.setUsecaseId(usecase.getUsecaseId());
		usecaseImpl.setPortletId(usecase.getPortletId());
		usecaseImpl.setVersionPortlet(usecase.getVersionPortlet());
		usecaseImpl.setName(usecase.getName());

		return usecaseImpl;
	}

	/**
	 * Returns the usecase with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the usecase
	 * @return the usecase
	 * @throws com.excilys.liferay.gatling.NoSuchUsecaseException if a usecase with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Usecase findByPrimaryKey(Serializable primaryKey)
		throws NoSuchUsecaseException, SystemException {
		Usecase usecase = fetchByPrimaryKey(primaryKey);

		if (usecase == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchUsecaseException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return usecase;
	}

	/**
	 * Returns the usecase with the primary key or throws a {@link com.excilys.liferay.gatling.NoSuchUsecaseException} if it could not be found.
	 *
	 * @param usecaseId the primary key of the usecase
	 * @return the usecase
	 * @throws com.excilys.liferay.gatling.NoSuchUsecaseException if a usecase with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Usecase findByPrimaryKey(long usecaseId)
		throws NoSuchUsecaseException, SystemException {
		return findByPrimaryKey((Serializable)usecaseId);
	}

	/**
	 * Returns the usecase with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the usecase
	 * @return the usecase, or <code>null</code> if a usecase with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Usecase fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Usecase usecase = (Usecase)EntityCacheUtil.getResult(UsecaseModelImpl.ENTITY_CACHE_ENABLED,
				UsecaseImpl.class, primaryKey);

		if (usecase == _nullUsecase) {
			return null;
		}

		if (usecase == null) {
			Session session = null;

			try {
				session = openSession();

				usecase = (Usecase)session.get(UsecaseImpl.class, primaryKey);

				if (usecase != null) {
					cacheResult(usecase);
				}
				else {
					EntityCacheUtil.putResult(UsecaseModelImpl.ENTITY_CACHE_ENABLED,
						UsecaseImpl.class, primaryKey, _nullUsecase);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(UsecaseModelImpl.ENTITY_CACHE_ENABLED,
					UsecaseImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return usecase;
	}

	/**
	 * Returns the usecase with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param usecaseId the primary key of the usecase
	 * @return the usecase, or <code>null</code> if a usecase with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Usecase fetchByPrimaryKey(long usecaseId) throws SystemException {
		return fetchByPrimaryKey((Serializable)usecaseId);
	}

	/**
	 * Returns all the usecases.
	 *
	 * @return the usecases
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Usecase> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the usecases.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.excilys.liferay.gatling.model.impl.UsecaseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of usecases
	 * @param end the upper bound of the range of usecases (not inclusive)
	 * @return the range of usecases
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Usecase> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the usecases.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.excilys.liferay.gatling.model.impl.UsecaseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of usecases
	 * @param end the upper bound of the range of usecases (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of usecases
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Usecase> findAll(int start, int end,
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

		List<Usecase> list = (List<Usecase>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_USECASE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_USECASE;

				if (pagination) {
					sql = sql.concat(UsecaseModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Usecase>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Usecase>(list);
				}
				else {
					list = (List<Usecase>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the usecases from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Usecase usecase : findAll()) {
			remove(usecase);
		}
	}

	/**
	 * Returns the number of usecases.
	 *
	 * @return the number of usecases
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

				Query q = session.createQuery(_SQL_COUNT_USECASE);

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
	 * Initializes the usecase persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.excilys.liferay.gatling.model.Usecase")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Usecase>> listenersList = new ArrayList<ModelListener<Usecase>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Usecase>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(UsecaseImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_USECASE = "SELECT usecase FROM Usecase usecase";
	private static final String _SQL_COUNT_USECASE = "SELECT COUNT(usecase) FROM Usecase usecase";
	private static final String _ORDER_BY_ENTITY_ALIAS = "usecase.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Usecase exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(UsecasePersistenceImpl.class);
	private static Usecase _nullUsecase = new UsecaseImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Usecase> toCacheModel() {
				return _nullUsecaseCacheModel;
			}
		};

	private static CacheModel<Usecase> _nullUsecaseCacheModel = new CacheModel<Usecase>() {
			@Override
			public Usecase toEntityModel() {
				return _nullUsecase;
			}
		};
}