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

import com.excilys.liferay.gatling.NoSuchRecordPortletException;
import com.excilys.liferay.gatling.model.RecordPortlet;
import com.excilys.liferay.gatling.model.impl.RecordPortletImpl;
import com.excilys.liferay.gatling.model.impl.RecordPortletModelImpl;

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
 * The persistence implementation for the record portlet service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RecordPortletPersistence
 * @see RecordPortletUtil
 * @generated
 */
public class RecordPortletPersistenceImpl extends BasePersistenceImpl<RecordPortlet>
	implements RecordPortletPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link RecordPortletUtil} to access the record portlet persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = RecordPortletImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(RecordPortletModelImpl.ENTITY_CACHE_ENABLED,
			RecordPortletModelImpl.FINDER_CACHE_ENABLED,
			RecordPortletImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(RecordPortletModelImpl.ENTITY_CACHE_ENABLED,
			RecordPortletModelImpl.FINDER_CACHE_ENABLED,
			RecordPortletImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(RecordPortletModelImpl.ENTITY_CACHE_ENABLED,
			RecordPortletModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public RecordPortletPersistenceImpl() {
		setModelClass(RecordPortlet.class);
	}

	/**
	 * Caches the record portlet in the entity cache if it is enabled.
	 *
	 * @param recordPortlet the record portlet
	 */
	@Override
	public void cacheResult(RecordPortlet recordPortlet) {
		EntityCacheUtil.putResult(RecordPortletModelImpl.ENTITY_CACHE_ENABLED,
			RecordPortletImpl.class, recordPortlet.getPrimaryKey(),
			recordPortlet);

		recordPortlet.resetOriginalValues();
	}

	/**
	 * Caches the record portlets in the entity cache if it is enabled.
	 *
	 * @param recordPortlets the record portlets
	 */
	@Override
	public void cacheResult(List<RecordPortlet> recordPortlets) {
		for (RecordPortlet recordPortlet : recordPortlets) {
			if (EntityCacheUtil.getResult(
						RecordPortletModelImpl.ENTITY_CACHE_ENABLED,
						RecordPortletImpl.class, recordPortlet.getPrimaryKey()) == null) {
				cacheResult(recordPortlet);
			}
			else {
				recordPortlet.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all record portlets.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(RecordPortletImpl.class.getName());
		}

		EntityCacheUtil.clearCache(RecordPortletImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the record portlet.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(RecordPortlet recordPortlet) {
		EntityCacheUtil.removeResult(RecordPortletModelImpl.ENTITY_CACHE_ENABLED,
			RecordPortletImpl.class, recordPortlet.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<RecordPortlet> recordPortlets) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (RecordPortlet recordPortlet : recordPortlets) {
			EntityCacheUtil.removeResult(RecordPortletModelImpl.ENTITY_CACHE_ENABLED,
				RecordPortletImpl.class, recordPortlet.getPrimaryKey());
		}
	}

	/**
	 * Creates a new record portlet with the primary key. Does not add the record portlet to the database.
	 *
	 * @param recordPortletId the primary key for the new record portlet
	 * @return the new record portlet
	 */
	@Override
	public RecordPortlet create(long recordPortletId) {
		RecordPortlet recordPortlet = new RecordPortletImpl();

		recordPortlet.setNew(true);
		recordPortlet.setPrimaryKey(recordPortletId);

		return recordPortlet;
	}

	/**
	 * Removes the record portlet with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param recordPortletId the primary key of the record portlet
	 * @return the record portlet that was removed
	 * @throws com.excilys.liferay.gatling.NoSuchRecordPortletException if a record portlet with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RecordPortlet remove(long recordPortletId)
		throws NoSuchRecordPortletException, SystemException {
		return remove((Serializable)recordPortletId);
	}

	/**
	 * Removes the record portlet with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the record portlet
	 * @return the record portlet that was removed
	 * @throws com.excilys.liferay.gatling.NoSuchRecordPortletException if a record portlet with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RecordPortlet remove(Serializable primaryKey)
		throws NoSuchRecordPortletException, SystemException {
		Session session = null;

		try {
			session = openSession();

			RecordPortlet recordPortlet = (RecordPortlet)session.get(RecordPortletImpl.class,
					primaryKey);

			if (recordPortlet == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchRecordPortletException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(recordPortlet);
		}
		catch (NoSuchRecordPortletException nsee) {
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
	protected RecordPortlet removeImpl(RecordPortlet recordPortlet)
		throws SystemException {
		recordPortlet = toUnwrappedModel(recordPortlet);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(recordPortlet)) {
				recordPortlet = (RecordPortlet)session.get(RecordPortletImpl.class,
						recordPortlet.getPrimaryKeyObj());
			}

			if (recordPortlet != null) {
				session.delete(recordPortlet);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (recordPortlet != null) {
			clearCache(recordPortlet);
		}

		return recordPortlet;
	}

	@Override
	public RecordPortlet updateImpl(
		com.excilys.liferay.gatling.model.RecordPortlet recordPortlet)
		throws SystemException {
		recordPortlet = toUnwrappedModel(recordPortlet);

		boolean isNew = recordPortlet.isNew();

		Session session = null;

		try {
			session = openSession();

			if (recordPortlet.isNew()) {
				session.save(recordPortlet);

				recordPortlet.setNew(false);
			}
			else {
				session.merge(recordPortlet);
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

		EntityCacheUtil.putResult(RecordPortletModelImpl.ENTITY_CACHE_ENABLED,
			RecordPortletImpl.class, recordPortlet.getPrimaryKey(),
			recordPortlet);

		return recordPortlet;
	}

	protected RecordPortlet toUnwrappedModel(RecordPortlet recordPortlet) {
		if (recordPortlet instanceof RecordPortletImpl) {
			return recordPortlet;
		}

		RecordPortletImpl recordPortletImpl = new RecordPortletImpl();

		recordPortletImpl.setNew(recordPortlet.isNew());
		recordPortletImpl.setPrimaryKey(recordPortlet.getPrimaryKey());

		recordPortletImpl.setRecordPortletId(recordPortlet.getRecordPortletId());
		recordPortletImpl.setPortletId(recordPortlet.getPortletId());
		recordPortletImpl.setState(recordPortlet.getState());

		return recordPortletImpl;
	}

	/**
	 * Returns the record portlet with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the record portlet
	 * @return the record portlet
	 * @throws com.excilys.liferay.gatling.NoSuchRecordPortletException if a record portlet with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RecordPortlet findByPrimaryKey(Serializable primaryKey)
		throws NoSuchRecordPortletException, SystemException {
		RecordPortlet recordPortlet = fetchByPrimaryKey(primaryKey);

		if (recordPortlet == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchRecordPortletException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return recordPortlet;
	}

	/**
	 * Returns the record portlet with the primary key or throws a {@link com.excilys.liferay.gatling.NoSuchRecordPortletException} if it could not be found.
	 *
	 * @param recordPortletId the primary key of the record portlet
	 * @return the record portlet
	 * @throws com.excilys.liferay.gatling.NoSuchRecordPortletException if a record portlet with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RecordPortlet findByPrimaryKey(long recordPortletId)
		throws NoSuchRecordPortletException, SystemException {
		return findByPrimaryKey((Serializable)recordPortletId);
	}

	/**
	 * Returns the record portlet with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the record portlet
	 * @return the record portlet, or <code>null</code> if a record portlet with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RecordPortlet fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		RecordPortlet recordPortlet = (RecordPortlet)EntityCacheUtil.getResult(RecordPortletModelImpl.ENTITY_CACHE_ENABLED,
				RecordPortletImpl.class, primaryKey);

		if (recordPortlet == _nullRecordPortlet) {
			return null;
		}

		if (recordPortlet == null) {
			Session session = null;

			try {
				session = openSession();

				recordPortlet = (RecordPortlet)session.get(RecordPortletImpl.class,
						primaryKey);

				if (recordPortlet != null) {
					cacheResult(recordPortlet);
				}
				else {
					EntityCacheUtil.putResult(RecordPortletModelImpl.ENTITY_CACHE_ENABLED,
						RecordPortletImpl.class, primaryKey, _nullRecordPortlet);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(RecordPortletModelImpl.ENTITY_CACHE_ENABLED,
					RecordPortletImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return recordPortlet;
	}

	/**
	 * Returns the record portlet with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param recordPortletId the primary key of the record portlet
	 * @return the record portlet, or <code>null</code> if a record portlet with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RecordPortlet fetchByPrimaryKey(long recordPortletId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)recordPortletId);
	}

	/**
	 * Returns all the record portlets.
	 *
	 * @return the record portlets
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RecordPortlet> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the record portlets.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.excilys.liferay.gatling.model.impl.RecordPortletModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of record portlets
	 * @param end the upper bound of the range of record portlets (not inclusive)
	 * @return the range of record portlets
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RecordPortlet> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the record portlets.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.excilys.liferay.gatling.model.impl.RecordPortletModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of record portlets
	 * @param end the upper bound of the range of record portlets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of record portlets
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RecordPortlet> findAll(int start, int end,
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

		List<RecordPortlet> list = (List<RecordPortlet>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_RECORDPORTLET);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_RECORDPORTLET;

				if (pagination) {
					sql = sql.concat(RecordPortletModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<RecordPortlet>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<RecordPortlet>(list);
				}
				else {
					list = (List<RecordPortlet>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the record portlets from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (RecordPortlet recordPortlet : findAll()) {
			remove(recordPortlet);
		}
	}

	/**
	 * Returns the number of record portlets.
	 *
	 * @return the number of record portlets
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

				Query q = session.createQuery(_SQL_COUNT_RECORDPORTLET);

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
	 * Initializes the record portlet persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.excilys.liferay.gatling.model.RecordPortlet")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<RecordPortlet>> listenersList = new ArrayList<ModelListener<RecordPortlet>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<RecordPortlet>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(RecordPortletImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_RECORDPORTLET = "SELECT recordPortlet FROM RecordPortlet recordPortlet";
	private static final String _SQL_COUNT_RECORDPORTLET = "SELECT COUNT(recordPortlet) FROM RecordPortlet recordPortlet";
	private static final String _ORDER_BY_ENTITY_ALIAS = "recordPortlet.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No RecordPortlet exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(RecordPortletPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"state"
			});
	private static RecordPortlet _nullRecordPortlet = new RecordPortletImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<RecordPortlet> toCacheModel() {
				return _nullRecordPortletCacheModel;
			}
		};

	private static CacheModel<RecordPortlet> _nullRecordPortletCacheModel = new CacheModel<RecordPortlet>() {
			@Override
			public RecordPortlet toEntityModel() {
				return _nullRecordPortlet;
			}
		};
}