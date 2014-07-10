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

import com.liferay.sample.NoSuchRequestException;
import com.liferay.sample.model.Request;
import com.liferay.sample.model.impl.RequestImpl;
import com.liferay.sample.model.impl.RequestModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the request service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author sana
 * @see RequestPersistence
 * @see RequestUtil
 * @generated
 */
public class RequestPersistenceImpl extends BasePersistenceImpl<Request>
	implements RequestPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link RequestUtil} to access the request persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = RequestImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(RequestModelImpl.ENTITY_CACHE_ENABLED,
			RequestModelImpl.FINDER_CACHE_ENABLED, RequestImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(RequestModelImpl.ENTITY_CACHE_ENABLED,
			RequestModelImpl.FINDER_CACHE_ENABLED, RequestImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(RequestModelImpl.ENTITY_CACHE_ENABLED,
			RequestModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public RequestPersistenceImpl() {
		setModelClass(Request.class);
	}

	/**
	 * Caches the request in the entity cache if it is enabled.
	 *
	 * @param request the request
	 */
	@Override
	public void cacheResult(Request request) {
		EntityCacheUtil.putResult(RequestModelImpl.ENTITY_CACHE_ENABLED,
			RequestImpl.class, request.getPrimaryKey(), request);

		request.resetOriginalValues();
	}

	/**
	 * Caches the requests in the entity cache if it is enabled.
	 *
	 * @param requests the requests
	 */
	@Override
	public void cacheResult(List<Request> requests) {
		for (Request request : requests) {
			if (EntityCacheUtil.getResult(
						RequestModelImpl.ENTITY_CACHE_ENABLED,
						RequestImpl.class, request.getPrimaryKey()) == null) {
				cacheResult(request);
			}
			else {
				request.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all requests.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(RequestImpl.class.getName());
		}

		EntityCacheUtil.clearCache(RequestImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the request.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Request request) {
		EntityCacheUtil.removeResult(RequestModelImpl.ENTITY_CACHE_ENABLED,
			RequestImpl.class, request.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Request> requests) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Request request : requests) {
			EntityCacheUtil.removeResult(RequestModelImpl.ENTITY_CACHE_ENABLED,
				RequestImpl.class, request.getPrimaryKey());
		}
	}

	/**
	 * Creates a new request with the primary key. Does not add the request to the database.
	 *
	 * @param request_id the primary key for the new request
	 * @return the new request
	 */
	@Override
	public Request create(long request_id) {
		Request request = new RequestImpl();

		request.setNew(true);
		request.setPrimaryKey(request_id);

		return request;
	}

	/**
	 * Removes the request with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param request_id the primary key of the request
	 * @return the request that was removed
	 * @throws com.liferay.sample.NoSuchRequestException if a request with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Request remove(long request_id)
		throws NoSuchRequestException, SystemException {
		return remove((Serializable)request_id);
	}

	/**
	 * Removes the request with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the request
	 * @return the request that was removed
	 * @throws com.liferay.sample.NoSuchRequestException if a request with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Request remove(Serializable primaryKey)
		throws NoSuchRequestException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Request request = (Request)session.get(RequestImpl.class, primaryKey);

			if (request == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchRequestException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(request);
		}
		catch (NoSuchRequestException nsee) {
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
	protected Request removeImpl(Request request) throws SystemException {
		request = toUnwrappedModel(request);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(request)) {
				request = (Request)session.get(RequestImpl.class,
						request.getPrimaryKeyObj());
			}

			if (request != null) {
				session.delete(request);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (request != null) {
			clearCache(request);
		}

		return request;
	}

	@Override
	public Request updateImpl(com.liferay.sample.model.Request request)
		throws SystemException {
		request = toUnwrappedModel(request);

		boolean isNew = request.isNew();

		Session session = null;

		try {
			session = openSession();

			if (request.isNew()) {
				session.save(request);

				request.setNew(false);
			}
			else {
				session.merge(request);
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

		EntityCacheUtil.putResult(RequestModelImpl.ENTITY_CACHE_ENABLED,
			RequestImpl.class, request.getPrimaryKey(), request);

		return request;
	}

	protected Request toUnwrappedModel(Request request) {
		if (request instanceof RequestImpl) {
			return request;
		}

		RequestImpl requestImpl = new RequestImpl();

		requestImpl.setNew(request.isNew());
		requestImpl.setPrimaryKey(request.getPrimaryKey());

		requestImpl.setRequest_id(request.getRequest_id());
		requestImpl.setScenario_id(request.getScenario_id());
		requestImpl.setUrl(request.getUrl());
		requestImpl.setRate(request.getRate());

		return requestImpl;
	}

	/**
	 * Returns the request with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the request
	 * @return the request
	 * @throws com.liferay.sample.NoSuchRequestException if a request with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Request findByPrimaryKey(Serializable primaryKey)
		throws NoSuchRequestException, SystemException {
		Request request = fetchByPrimaryKey(primaryKey);

		if (request == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchRequestException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return request;
	}

	/**
	 * Returns the request with the primary key or throws a {@link com.liferay.sample.NoSuchRequestException} if it could not be found.
	 *
	 * @param request_id the primary key of the request
	 * @return the request
	 * @throws com.liferay.sample.NoSuchRequestException if a request with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Request findByPrimaryKey(long request_id)
		throws NoSuchRequestException, SystemException {
		return findByPrimaryKey((Serializable)request_id);
	}

	/**
	 * Returns the request with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the request
	 * @return the request, or <code>null</code> if a request with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Request fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Request request = (Request)EntityCacheUtil.getResult(RequestModelImpl.ENTITY_CACHE_ENABLED,
				RequestImpl.class, primaryKey);

		if (request == _nullRequest) {
			return null;
		}

		if (request == null) {
			Session session = null;

			try {
				session = openSession();

				request = (Request)session.get(RequestImpl.class, primaryKey);

				if (request != null) {
					cacheResult(request);
				}
				else {
					EntityCacheUtil.putResult(RequestModelImpl.ENTITY_CACHE_ENABLED,
						RequestImpl.class, primaryKey, _nullRequest);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(RequestModelImpl.ENTITY_CACHE_ENABLED,
					RequestImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return request;
	}

	/**
	 * Returns the request with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param request_id the primary key of the request
	 * @return the request, or <code>null</code> if a request with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Request fetchByPrimaryKey(long request_id) throws SystemException {
		return fetchByPrimaryKey((Serializable)request_id);
	}

	/**
	 * Returns all the requests.
	 *
	 * @return the requests
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Request> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the requests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.sample.model.impl.RequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of requests
	 * @param end the upper bound of the range of requests (not inclusive)
	 * @return the range of requests
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Request> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the requests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.sample.model.impl.RequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of requests
	 * @param end the upper bound of the range of requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of requests
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Request> findAll(int start, int end,
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

		List<Request> list = (List<Request>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_REQUEST);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_REQUEST;

				if (pagination) {
					sql = sql.concat(RequestModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Request>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Request>(list);
				}
				else {
					list = (List<Request>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the requests from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Request request : findAll()) {
			remove(request);
		}
	}

	/**
	 * Returns the number of requests.
	 *
	 * @return the number of requests
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

				Query q = session.createQuery(_SQL_COUNT_REQUEST);

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
	 * Initializes the request persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.liferay.sample.model.Request")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Request>> listenersList = new ArrayList<ModelListener<Request>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Request>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(RequestImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_REQUEST = "SELECT request FROM Request request";
	private static final String _SQL_COUNT_REQUEST = "SELECT COUNT(request) FROM Request request";
	private static final String _ORDER_BY_ENTITY_ALIAS = "request.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Request exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(RequestPersistenceImpl.class);
	private static Request _nullRequest = new RequestImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Request> toCacheModel() {
				return _nullRequestCacheModel;
			}
		};

	private static CacheModel<Request> _nullRequestCacheModel = new CacheModel<Request>() {
			@Override
			public Request toEntityModel() {
				return _nullRequest;
			}
		};
}