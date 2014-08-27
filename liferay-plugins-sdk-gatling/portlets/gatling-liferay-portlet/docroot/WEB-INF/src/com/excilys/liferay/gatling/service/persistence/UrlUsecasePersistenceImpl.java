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

import com.excilys.liferay.gatling.NoSuchUrlUsecaseException;
import com.excilys.liferay.gatling.model.UrlUsecase;
import com.excilys.liferay.gatling.model.impl.UrlUsecaseImpl;
import com.excilys.liferay.gatling.model.impl.UrlUsecaseModelImpl;

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
import com.liferay.portal.kernel.util.SetUtil;
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
import java.util.Set;

/**
 * The persistence implementation for the url usecase service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UrlUsecasePersistence
 * @see UrlUsecaseUtil
 * @generated
 */
public class UrlUsecasePersistenceImpl extends BasePersistenceImpl<UrlUsecase>
	implements UrlUsecasePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link UrlUsecaseUtil} to access the url usecase persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = UrlUsecaseImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(UrlUsecaseModelImpl.ENTITY_CACHE_ENABLED,
			UrlUsecaseModelImpl.FINDER_CACHE_ENABLED, UrlUsecaseImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(UrlUsecaseModelImpl.ENTITY_CACHE_ENABLED,
			UrlUsecaseModelImpl.FINDER_CACHE_ENABLED, UrlUsecaseImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(UrlUsecaseModelImpl.ENTITY_CACHE_ENABLED,
			UrlUsecaseModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public UrlUsecasePersistenceImpl() {
		setModelClass(UrlUsecase.class);
	}

	/**
	 * Caches the url usecase in the entity cache if it is enabled.
	 *
	 * @param urlUsecase the url usecase
	 */
	@Override
	public void cacheResult(UrlUsecase urlUsecase) {
		EntityCacheUtil.putResult(UrlUsecaseModelImpl.ENTITY_CACHE_ENABLED,
			UrlUsecaseImpl.class, urlUsecase.getPrimaryKey(), urlUsecase);

		urlUsecase.resetOriginalValues();
	}

	/**
	 * Caches the url usecases in the entity cache if it is enabled.
	 *
	 * @param urlUsecases the url usecases
	 */
	@Override
	public void cacheResult(List<UrlUsecase> urlUsecases) {
		for (UrlUsecase urlUsecase : urlUsecases) {
			if (EntityCacheUtil.getResult(
						UrlUsecaseModelImpl.ENTITY_CACHE_ENABLED,
						UrlUsecaseImpl.class, urlUsecase.getPrimaryKey()) == null) {
				cacheResult(urlUsecase);
			}
			else {
				urlUsecase.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all url usecases.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(UrlUsecaseImpl.class.getName());
		}

		EntityCacheUtil.clearCache(UrlUsecaseImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the url usecase.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(UrlUsecase urlUsecase) {
		EntityCacheUtil.removeResult(UrlUsecaseModelImpl.ENTITY_CACHE_ENABLED,
			UrlUsecaseImpl.class, urlUsecase.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<UrlUsecase> urlUsecases) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (UrlUsecase urlUsecase : urlUsecases) {
			EntityCacheUtil.removeResult(UrlUsecaseModelImpl.ENTITY_CACHE_ENABLED,
				UrlUsecaseImpl.class, urlUsecase.getPrimaryKey());
		}
	}

	/**
	 * Creates a new url usecase with the primary key. Does not add the url usecase to the database.
	 *
	 * @param urlUsecaseId the primary key for the new url usecase
	 * @return the new url usecase
	 */
	@Override
	public UrlUsecase create(long urlUsecaseId) {
		UrlUsecase urlUsecase = new UrlUsecaseImpl();

		urlUsecase.setNew(true);
		urlUsecase.setPrimaryKey(urlUsecaseId);

		return urlUsecase;
	}

	/**
	 * Removes the url usecase with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param urlUsecaseId the primary key of the url usecase
	 * @return the url usecase that was removed
	 * @throws com.excilys.liferay.gatling.NoSuchUrlUsecaseException if a url usecase with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UrlUsecase remove(long urlUsecaseId)
		throws NoSuchUrlUsecaseException, SystemException {
		return remove((Serializable)urlUsecaseId);
	}

	/**
	 * Removes the url usecase with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the url usecase
	 * @return the url usecase that was removed
	 * @throws com.excilys.liferay.gatling.NoSuchUrlUsecaseException if a url usecase with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UrlUsecase remove(Serializable primaryKey)
		throws NoSuchUrlUsecaseException, SystemException {
		Session session = null;

		try {
			session = openSession();

			UrlUsecase urlUsecase = (UrlUsecase)session.get(UrlUsecaseImpl.class,
					primaryKey);

			if (urlUsecase == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchUrlUsecaseException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(urlUsecase);
		}
		catch (NoSuchUrlUsecaseException nsee) {
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
	protected UrlUsecase removeImpl(UrlUsecase urlUsecase)
		throws SystemException {
		urlUsecase = toUnwrappedModel(urlUsecase);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(urlUsecase)) {
				urlUsecase = (UrlUsecase)session.get(UrlUsecaseImpl.class,
						urlUsecase.getPrimaryKeyObj());
			}

			if (urlUsecase != null) {
				session.delete(urlUsecase);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (urlUsecase != null) {
			clearCache(urlUsecase);
		}

		return urlUsecase;
	}

	@Override
	public UrlUsecase updateImpl(
		com.excilys.liferay.gatling.model.UrlUsecase urlUsecase)
		throws SystemException {
		urlUsecase = toUnwrappedModel(urlUsecase);

		boolean isNew = urlUsecase.isNew();

		Session session = null;

		try {
			session = openSession();

			if (urlUsecase.isNew()) {
				session.save(urlUsecase);

				urlUsecase.setNew(false);
			}
			else {
				session.merge(urlUsecase);
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

		EntityCacheUtil.putResult(UrlUsecaseModelImpl.ENTITY_CACHE_ENABLED,
			UrlUsecaseImpl.class, urlUsecase.getPrimaryKey(), urlUsecase);

		return urlUsecase;
	}

	protected UrlUsecase toUnwrappedModel(UrlUsecase urlUsecase) {
		if (urlUsecase instanceof UrlUsecaseImpl) {
			return urlUsecase;
		}

		UrlUsecaseImpl urlUsecaseImpl = new UrlUsecaseImpl();

		urlUsecaseImpl.setNew(urlUsecase.isNew());
		urlUsecaseImpl.setPrimaryKey(urlUsecase.getPrimaryKey());

		urlUsecaseImpl.setUrlUsecaseId(urlUsecase.getUrlUsecaseId());
		urlUsecaseImpl.setUsecaseId(urlUsecase.getUsecaseId());
		urlUsecaseImpl.setUrl(urlUsecase.getUrl());
		urlUsecaseImpl.setOrder(urlUsecase.getOrder());

		return urlUsecaseImpl;
	}

	/**
	 * Returns the url usecase with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the url usecase
	 * @return the url usecase
	 * @throws com.excilys.liferay.gatling.NoSuchUrlUsecaseException if a url usecase with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UrlUsecase findByPrimaryKey(Serializable primaryKey)
		throws NoSuchUrlUsecaseException, SystemException {
		UrlUsecase urlUsecase = fetchByPrimaryKey(primaryKey);

		if (urlUsecase == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchUrlUsecaseException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return urlUsecase;
	}

	/**
	 * Returns the url usecase with the primary key or throws a {@link com.excilys.liferay.gatling.NoSuchUrlUsecaseException} if it could not be found.
	 *
	 * @param urlUsecaseId the primary key of the url usecase
	 * @return the url usecase
	 * @throws com.excilys.liferay.gatling.NoSuchUrlUsecaseException if a url usecase with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UrlUsecase findByPrimaryKey(long urlUsecaseId)
		throws NoSuchUrlUsecaseException, SystemException {
		return findByPrimaryKey((Serializable)urlUsecaseId);
	}

	/**
	 * Returns the url usecase with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the url usecase
	 * @return the url usecase, or <code>null</code> if a url usecase with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UrlUsecase fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		UrlUsecase urlUsecase = (UrlUsecase)EntityCacheUtil.getResult(UrlUsecaseModelImpl.ENTITY_CACHE_ENABLED,
				UrlUsecaseImpl.class, primaryKey);

		if (urlUsecase == _nullUrlUsecase) {
			return null;
		}

		if (urlUsecase == null) {
			Session session = null;

			try {
				session = openSession();

				urlUsecase = (UrlUsecase)session.get(UrlUsecaseImpl.class,
						primaryKey);

				if (urlUsecase != null) {
					cacheResult(urlUsecase);
				}
				else {
					EntityCacheUtil.putResult(UrlUsecaseModelImpl.ENTITY_CACHE_ENABLED,
						UrlUsecaseImpl.class, primaryKey, _nullUrlUsecase);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(UrlUsecaseModelImpl.ENTITY_CACHE_ENABLED,
					UrlUsecaseImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return urlUsecase;
	}

	/**
	 * Returns the url usecase with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param urlUsecaseId the primary key of the url usecase
	 * @return the url usecase, or <code>null</code> if a url usecase with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UrlUsecase fetchByPrimaryKey(long urlUsecaseId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)urlUsecaseId);
	}

	/**
	 * Returns all the url usecases.
	 *
	 * @return the url usecases
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UrlUsecase> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the url usecases.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.excilys.liferay.gatling.model.impl.UrlUsecaseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of url usecases
	 * @param end the upper bound of the range of url usecases (not inclusive)
	 * @return the range of url usecases
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UrlUsecase> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the url usecases.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.excilys.liferay.gatling.model.impl.UrlUsecaseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of url usecases
	 * @param end the upper bound of the range of url usecases (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of url usecases
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UrlUsecase> findAll(int start, int end,
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

		List<UrlUsecase> list = (List<UrlUsecase>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_URLUSECASE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_URLUSECASE;

				if (pagination) {
					sql = sql.concat(UrlUsecaseModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<UrlUsecase>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<UrlUsecase>(list);
				}
				else {
					list = (List<UrlUsecase>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the url usecases from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (UrlUsecase urlUsecase : findAll()) {
			remove(urlUsecase);
		}
	}

	/**
	 * Returns the number of url usecases.
	 *
	 * @return the number of url usecases
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

				Query q = session.createQuery(_SQL_COUNT_URLUSECASE);

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

	@Override
	protected Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	/**
	 * Initializes the url usecase persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.excilys.liferay.gatling.model.UrlUsecase")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<UrlUsecase>> listenersList = new ArrayList<ModelListener<UrlUsecase>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<UrlUsecase>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(UrlUsecaseImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_URLUSECASE = "SELECT urlUsecase FROM UrlUsecase urlUsecase";
	private static final String _SQL_COUNT_URLUSECASE = "SELECT COUNT(urlUsecase) FROM UrlUsecase urlUsecase";
	private static final String _ORDER_BY_ENTITY_ALIAS = "urlUsecase.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No UrlUsecase exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(UrlUsecasePersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"order"
			});
	private static UrlUsecase _nullUrlUsecase = new UrlUsecaseImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<UrlUsecase> toCacheModel() {
				return _nullUrlUsecaseCacheModel;
			}
		};

	private static CacheModel<UrlUsecase> _nullUrlUsecaseCacheModel = new CacheModel<UrlUsecase>() {
			@Override
			public UrlUsecase toEntityModel() {
				return _nullUrlUsecase;
			}
		};
}