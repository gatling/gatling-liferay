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

import com.excilys.liferay.gatling.NoSuchLinkUsecaseRequestException;
import com.excilys.liferay.gatling.model.LinkUsecaseRequest;
import com.excilys.liferay.gatling.model.impl.LinkUsecaseRequestImpl;
import com.excilys.liferay.gatling.model.impl.LinkUsecaseRequestModelImpl;

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
 * The persistence implementation for the link usecase request service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LinkUsecaseRequestPersistence
 * @see LinkUsecaseRequestUtil
 * @generated
 */
public class LinkUsecaseRequestPersistenceImpl extends BasePersistenceImpl<LinkUsecaseRequest>
	implements LinkUsecaseRequestPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link LinkUsecaseRequestUtil} to access the link usecase request persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = LinkUsecaseRequestImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LinkUsecaseRequestModelImpl.ENTITY_CACHE_ENABLED,
			LinkUsecaseRequestModelImpl.FINDER_CACHE_ENABLED,
			LinkUsecaseRequestImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LinkUsecaseRequestModelImpl.ENTITY_CACHE_ENABLED,
			LinkUsecaseRequestModelImpl.FINDER_CACHE_ENABLED,
			LinkUsecaseRequestImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LinkUsecaseRequestModelImpl.ENTITY_CACHE_ENABLED,
			LinkUsecaseRequestModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public LinkUsecaseRequestPersistenceImpl() {
		setModelClass(LinkUsecaseRequest.class);
	}

	/**
	 * Caches the link usecase request in the entity cache if it is enabled.
	 *
	 * @param linkUsecaseRequest the link usecase request
	 */
	@Override
	public void cacheResult(LinkUsecaseRequest linkUsecaseRequest) {
		EntityCacheUtil.putResult(LinkUsecaseRequestModelImpl.ENTITY_CACHE_ENABLED,
			LinkUsecaseRequestImpl.class, linkUsecaseRequest.getPrimaryKey(),
			linkUsecaseRequest);

		linkUsecaseRequest.resetOriginalValues();
	}

	/**
	 * Caches the link usecase requests in the entity cache if it is enabled.
	 *
	 * @param linkUsecaseRequests the link usecase requests
	 */
	@Override
	public void cacheResult(List<LinkUsecaseRequest> linkUsecaseRequests) {
		for (LinkUsecaseRequest linkUsecaseRequest : linkUsecaseRequests) {
			if (EntityCacheUtil.getResult(
						LinkUsecaseRequestModelImpl.ENTITY_CACHE_ENABLED,
						LinkUsecaseRequestImpl.class,
						linkUsecaseRequest.getPrimaryKey()) == null) {
				cacheResult(linkUsecaseRequest);
			}
			else {
				linkUsecaseRequest.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all link usecase requests.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(LinkUsecaseRequestImpl.class.getName());
		}

		EntityCacheUtil.clearCache(LinkUsecaseRequestImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the link usecase request.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(LinkUsecaseRequest linkUsecaseRequest) {
		EntityCacheUtil.removeResult(LinkUsecaseRequestModelImpl.ENTITY_CACHE_ENABLED,
			LinkUsecaseRequestImpl.class, linkUsecaseRequest.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<LinkUsecaseRequest> linkUsecaseRequests) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (LinkUsecaseRequest linkUsecaseRequest : linkUsecaseRequests) {
			EntityCacheUtil.removeResult(LinkUsecaseRequestModelImpl.ENTITY_CACHE_ENABLED,
				LinkUsecaseRequestImpl.class, linkUsecaseRequest.getPrimaryKey());
		}
	}

	/**
	 * Creates a new link usecase request with the primary key. Does not add the link usecase request to the database.
	 *
	 * @param linkUsecaseRequestId the primary key for the new link usecase request
	 * @return the new link usecase request
	 */
	@Override
	public LinkUsecaseRequest create(long linkUsecaseRequestId) {
		LinkUsecaseRequest linkUsecaseRequest = new LinkUsecaseRequestImpl();

		linkUsecaseRequest.setNew(true);
		linkUsecaseRequest.setPrimaryKey(linkUsecaseRequestId);

		return linkUsecaseRequest;
	}

	/**
	 * Removes the link usecase request with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param linkUsecaseRequestId the primary key of the link usecase request
	 * @return the link usecase request that was removed
	 * @throws com.excilys.liferay.gatling.NoSuchLinkUsecaseRequestException if a link usecase request with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LinkUsecaseRequest remove(long linkUsecaseRequestId)
		throws NoSuchLinkUsecaseRequestException, SystemException {
		return remove((Serializable)linkUsecaseRequestId);
	}

	/**
	 * Removes the link usecase request with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the link usecase request
	 * @return the link usecase request that was removed
	 * @throws com.excilys.liferay.gatling.NoSuchLinkUsecaseRequestException if a link usecase request with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LinkUsecaseRequest remove(Serializable primaryKey)
		throws NoSuchLinkUsecaseRequestException, SystemException {
		Session session = null;

		try {
			session = openSession();

			LinkUsecaseRequest linkUsecaseRequest = (LinkUsecaseRequest)session.get(LinkUsecaseRequestImpl.class,
					primaryKey);

			if (linkUsecaseRequest == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLinkUsecaseRequestException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(linkUsecaseRequest);
		}
		catch (NoSuchLinkUsecaseRequestException nsee) {
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
	protected LinkUsecaseRequest removeImpl(
		LinkUsecaseRequest linkUsecaseRequest) throws SystemException {
		linkUsecaseRequest = toUnwrappedModel(linkUsecaseRequest);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(linkUsecaseRequest)) {
				linkUsecaseRequest = (LinkUsecaseRequest)session.get(LinkUsecaseRequestImpl.class,
						linkUsecaseRequest.getPrimaryKeyObj());
			}

			if (linkUsecaseRequest != null) {
				session.delete(linkUsecaseRequest);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (linkUsecaseRequest != null) {
			clearCache(linkUsecaseRequest);
		}

		return linkUsecaseRequest;
	}

	@Override
	public LinkUsecaseRequest updateImpl(
		com.excilys.liferay.gatling.model.LinkUsecaseRequest linkUsecaseRequest)
		throws SystemException {
		linkUsecaseRequest = toUnwrappedModel(linkUsecaseRequest);

		boolean isNew = linkUsecaseRequest.isNew();

		Session session = null;

		try {
			session = openSession();

			if (linkUsecaseRequest.isNew()) {
				session.save(linkUsecaseRequest);

				linkUsecaseRequest.setNew(false);
			}
			else {
				session.merge(linkUsecaseRequest);
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

		EntityCacheUtil.putResult(LinkUsecaseRequestModelImpl.ENTITY_CACHE_ENABLED,
			LinkUsecaseRequestImpl.class, linkUsecaseRequest.getPrimaryKey(),
			linkUsecaseRequest);

		return linkUsecaseRequest;
	}

	protected LinkUsecaseRequest toUnwrappedModel(
		LinkUsecaseRequest linkUsecaseRequest) {
		if (linkUsecaseRequest instanceof LinkUsecaseRequestImpl) {
			return linkUsecaseRequest;
		}

		LinkUsecaseRequestImpl linkUsecaseRequestImpl = new LinkUsecaseRequestImpl();

		linkUsecaseRequestImpl.setNew(linkUsecaseRequest.isNew());
		linkUsecaseRequestImpl.setPrimaryKey(linkUsecaseRequest.getPrimaryKey());

		linkUsecaseRequestImpl.setLinkUsecaseRequestId(linkUsecaseRequest.getLinkUsecaseRequestId());
		linkUsecaseRequestImpl.setRequest_id(linkUsecaseRequest.getRequest_id());
		linkUsecaseRequestImpl.setRecordId(linkUsecaseRequest.getRecordId());
		linkUsecaseRequestImpl.setWeight(linkUsecaseRequest.getWeight());
		linkUsecaseRequestImpl.setSample(linkUsecaseRequest.isSample());

		return linkUsecaseRequestImpl;
	}

	/**
	 * Returns the link usecase request with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the link usecase request
	 * @return the link usecase request
	 * @throws com.excilys.liferay.gatling.NoSuchLinkUsecaseRequestException if a link usecase request with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LinkUsecaseRequest findByPrimaryKey(Serializable primaryKey)
		throws NoSuchLinkUsecaseRequestException, SystemException {
		LinkUsecaseRequest linkUsecaseRequest = fetchByPrimaryKey(primaryKey);

		if (linkUsecaseRequest == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchLinkUsecaseRequestException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return linkUsecaseRequest;
	}

	/**
	 * Returns the link usecase request with the primary key or throws a {@link com.excilys.liferay.gatling.NoSuchLinkUsecaseRequestException} if it could not be found.
	 *
	 * @param linkUsecaseRequestId the primary key of the link usecase request
	 * @return the link usecase request
	 * @throws com.excilys.liferay.gatling.NoSuchLinkUsecaseRequestException if a link usecase request with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LinkUsecaseRequest findByPrimaryKey(long linkUsecaseRequestId)
		throws NoSuchLinkUsecaseRequestException, SystemException {
		return findByPrimaryKey((Serializable)linkUsecaseRequestId);
	}

	/**
	 * Returns the link usecase request with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the link usecase request
	 * @return the link usecase request, or <code>null</code> if a link usecase request with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LinkUsecaseRequest fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		LinkUsecaseRequest linkUsecaseRequest = (LinkUsecaseRequest)EntityCacheUtil.getResult(LinkUsecaseRequestModelImpl.ENTITY_CACHE_ENABLED,
				LinkUsecaseRequestImpl.class, primaryKey);

		if (linkUsecaseRequest == _nullLinkUsecaseRequest) {
			return null;
		}

		if (linkUsecaseRequest == null) {
			Session session = null;

			try {
				session = openSession();

				linkUsecaseRequest = (LinkUsecaseRequest)session.get(LinkUsecaseRequestImpl.class,
						primaryKey);

				if (linkUsecaseRequest != null) {
					cacheResult(linkUsecaseRequest);
				}
				else {
					EntityCacheUtil.putResult(LinkUsecaseRequestModelImpl.ENTITY_CACHE_ENABLED,
						LinkUsecaseRequestImpl.class, primaryKey,
						_nullLinkUsecaseRequest);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(LinkUsecaseRequestModelImpl.ENTITY_CACHE_ENABLED,
					LinkUsecaseRequestImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return linkUsecaseRequest;
	}

	/**
	 * Returns the link usecase request with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param linkUsecaseRequestId the primary key of the link usecase request
	 * @return the link usecase request, or <code>null</code> if a link usecase request with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LinkUsecaseRequest fetchByPrimaryKey(long linkUsecaseRequestId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)linkUsecaseRequestId);
	}

	/**
	 * Returns all the link usecase requests.
	 *
	 * @return the link usecase requests
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LinkUsecaseRequest> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the link usecase requests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.excilys.liferay.gatling.model.impl.LinkUsecaseRequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of link usecase requests
	 * @param end the upper bound of the range of link usecase requests (not inclusive)
	 * @return the range of link usecase requests
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LinkUsecaseRequest> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the link usecase requests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.excilys.liferay.gatling.model.impl.LinkUsecaseRequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of link usecase requests
	 * @param end the upper bound of the range of link usecase requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of link usecase requests
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LinkUsecaseRequest> findAll(int start, int end,
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

		List<LinkUsecaseRequest> list = (List<LinkUsecaseRequest>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_LINKUSECASEREQUEST);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LINKUSECASEREQUEST;

				if (pagination) {
					sql = sql.concat(LinkUsecaseRequestModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<LinkUsecaseRequest>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<LinkUsecaseRequest>(list);
				}
				else {
					list = (List<LinkUsecaseRequest>)QueryUtil.list(q,
							getDialect(), start, end);
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
	 * Removes all the link usecase requests from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (LinkUsecaseRequest linkUsecaseRequest : findAll()) {
			remove(linkUsecaseRequest);
		}
	}

	/**
	 * Returns the number of link usecase requests.
	 *
	 * @return the number of link usecase requests
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

				Query q = session.createQuery(_SQL_COUNT_LINKUSECASEREQUEST);

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
	 * Initializes the link usecase request persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.excilys.liferay.gatling.model.LinkUsecaseRequest")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<LinkUsecaseRequest>> listenersList = new ArrayList<ModelListener<LinkUsecaseRequest>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<LinkUsecaseRequest>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(LinkUsecaseRequestImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_LINKUSECASEREQUEST = "SELECT linkUsecaseRequest FROM LinkUsecaseRequest linkUsecaseRequest";
	private static final String _SQL_COUNT_LINKUSECASEREQUEST = "SELECT COUNT(linkUsecaseRequest) FROM LinkUsecaseRequest linkUsecaseRequest";
	private static final String _ORDER_BY_ENTITY_ALIAS = "linkUsecaseRequest.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LinkUsecaseRequest exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(LinkUsecaseRequestPersistenceImpl.class);
	private static LinkUsecaseRequest _nullLinkUsecaseRequest = new LinkUsecaseRequestImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<LinkUsecaseRequest> toCacheModel() {
				return _nullLinkUsecaseRequestCacheModel;
			}
		};

	private static CacheModel<LinkUsecaseRequest> _nullLinkUsecaseRequestCacheModel =
		new CacheModel<LinkUsecaseRequest>() {
			@Override
			public LinkUsecaseRequest toEntityModel() {
				return _nullLinkUsecaseRequest;
			}
		};
}