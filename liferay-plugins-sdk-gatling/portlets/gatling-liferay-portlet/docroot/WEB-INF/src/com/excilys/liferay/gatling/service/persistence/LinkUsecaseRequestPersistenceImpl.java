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
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_REQUESTIDANDUSED =
		new FinderPath(LinkUsecaseRequestModelImpl.ENTITY_CACHE_ENABLED,
			LinkUsecaseRequestModelImpl.FINDER_CACHE_ENABLED,
			LinkUsecaseRequestImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByRequestIdAndUsed",
			new String[] {
				Long.class.getName(), Double.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_REQUESTIDANDUSED =
		new FinderPath(LinkUsecaseRequestModelImpl.ENTITY_CACHE_ENABLED,
			LinkUsecaseRequestModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByRequestIdAndUsed",
			new String[] { Long.class.getName(), Double.class.getName() });

	/**
	 * Returns all the link usecase requests where request_id = &#63; and weight &gt; &#63;.
	 *
	 * @param request_id the request_id
	 * @param weight the weight
	 * @return the matching link usecase requests
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LinkUsecaseRequest> findByRequestIdAndUsed(long request_id,
		double weight) throws SystemException {
		return findByRequestIdAndUsed(request_id, weight, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the link usecase requests where request_id = &#63; and weight &gt; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.excilys.liferay.gatling.model.impl.LinkUsecaseRequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param request_id the request_id
	 * @param weight the weight
	 * @param start the lower bound of the range of link usecase requests
	 * @param end the upper bound of the range of link usecase requests (not inclusive)
	 * @return the range of matching link usecase requests
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LinkUsecaseRequest> findByRequestIdAndUsed(long request_id,
		double weight, int start, int end) throws SystemException {
		return findByRequestIdAndUsed(request_id, weight, start, end, null);
	}

	/**
	 * Returns an ordered range of all the link usecase requests where request_id = &#63; and weight &gt; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.excilys.liferay.gatling.model.impl.LinkUsecaseRequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param request_id the request_id
	 * @param weight the weight
	 * @param start the lower bound of the range of link usecase requests
	 * @param end the upper bound of the range of link usecase requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching link usecase requests
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LinkUsecaseRequest> findByRequestIdAndUsed(long request_id,
		double weight, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_REQUESTIDANDUSED;
		finderArgs = new Object[] {
				request_id, weight,
				
				start, end, orderByComparator
			};

		List<LinkUsecaseRequest> list = (List<LinkUsecaseRequest>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (LinkUsecaseRequest linkUsecaseRequest : list) {
				if ((request_id != linkUsecaseRequest.getRequest_id()) ||
						(weight >= linkUsecaseRequest.getWeight())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_LINKUSECASEREQUEST_WHERE);

			query.append(_FINDER_COLUMN_REQUESTIDANDUSED_REQUEST_ID_2);

			query.append(_FINDER_COLUMN_REQUESTIDANDUSED_WEIGHT_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(LinkUsecaseRequestModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(request_id);

				qPos.add(weight);

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
	 * Returns the first link usecase request in the ordered set where request_id = &#63; and weight &gt; &#63;.
	 *
	 * @param request_id the request_id
	 * @param weight the weight
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching link usecase request
	 * @throws com.excilys.liferay.gatling.NoSuchLinkUsecaseRequestException if a matching link usecase request could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LinkUsecaseRequest findByRequestIdAndUsed_First(long request_id,
		double weight, OrderByComparator orderByComparator)
		throws NoSuchLinkUsecaseRequestException, SystemException {
		LinkUsecaseRequest linkUsecaseRequest = fetchByRequestIdAndUsed_First(request_id,
				weight, orderByComparator);

		if (linkUsecaseRequest != null) {
			return linkUsecaseRequest;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("request_id=");
		msg.append(request_id);

		msg.append(", weight=");
		msg.append(weight);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLinkUsecaseRequestException(msg.toString());
	}

	/**
	 * Returns the first link usecase request in the ordered set where request_id = &#63; and weight &gt; &#63;.
	 *
	 * @param request_id the request_id
	 * @param weight the weight
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching link usecase request, or <code>null</code> if a matching link usecase request could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LinkUsecaseRequest fetchByRequestIdAndUsed_First(long request_id,
		double weight, OrderByComparator orderByComparator)
		throws SystemException {
		List<LinkUsecaseRequest> list = findByRequestIdAndUsed(request_id,
				weight, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last link usecase request in the ordered set where request_id = &#63; and weight &gt; &#63;.
	 *
	 * @param request_id the request_id
	 * @param weight the weight
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching link usecase request
	 * @throws com.excilys.liferay.gatling.NoSuchLinkUsecaseRequestException if a matching link usecase request could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LinkUsecaseRequest findByRequestIdAndUsed_Last(long request_id,
		double weight, OrderByComparator orderByComparator)
		throws NoSuchLinkUsecaseRequestException, SystemException {
		LinkUsecaseRequest linkUsecaseRequest = fetchByRequestIdAndUsed_Last(request_id,
				weight, orderByComparator);

		if (linkUsecaseRequest != null) {
			return linkUsecaseRequest;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("request_id=");
		msg.append(request_id);

		msg.append(", weight=");
		msg.append(weight);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLinkUsecaseRequestException(msg.toString());
	}

	/**
	 * Returns the last link usecase request in the ordered set where request_id = &#63; and weight &gt; &#63;.
	 *
	 * @param request_id the request_id
	 * @param weight the weight
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching link usecase request, or <code>null</code> if a matching link usecase request could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LinkUsecaseRequest fetchByRequestIdAndUsed_Last(long request_id,
		double weight, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByRequestIdAndUsed(request_id, weight);

		if (count == 0) {
			return null;
		}

		List<LinkUsecaseRequest> list = findByRequestIdAndUsed(request_id,
				weight, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the link usecase requests before and after the current link usecase request in the ordered set where request_id = &#63; and weight &gt; &#63;.
	 *
	 * @param linkUsecaseRequestId the primary key of the current link usecase request
	 * @param request_id the request_id
	 * @param weight the weight
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next link usecase request
	 * @throws com.excilys.liferay.gatling.NoSuchLinkUsecaseRequestException if a link usecase request with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LinkUsecaseRequest[] findByRequestIdAndUsed_PrevAndNext(
		long linkUsecaseRequestId, long request_id, double weight,
		OrderByComparator orderByComparator)
		throws NoSuchLinkUsecaseRequestException, SystemException {
		LinkUsecaseRequest linkUsecaseRequest = findByPrimaryKey(linkUsecaseRequestId);

		Session session = null;

		try {
			session = openSession();

			LinkUsecaseRequest[] array = new LinkUsecaseRequestImpl[3];

			array[0] = getByRequestIdAndUsed_PrevAndNext(session,
					linkUsecaseRequest, request_id, weight, orderByComparator,
					true);

			array[1] = linkUsecaseRequest;

			array[2] = getByRequestIdAndUsed_PrevAndNext(session,
					linkUsecaseRequest, request_id, weight, orderByComparator,
					false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected LinkUsecaseRequest getByRequestIdAndUsed_PrevAndNext(
		Session session, LinkUsecaseRequest linkUsecaseRequest,
		long request_id, double weight, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LINKUSECASEREQUEST_WHERE);

		query.append(_FINDER_COLUMN_REQUESTIDANDUSED_REQUEST_ID_2);

		query.append(_FINDER_COLUMN_REQUESTIDANDUSED_WEIGHT_2);

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
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
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
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(LinkUsecaseRequestModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(request_id);

		qPos.add(weight);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(linkUsecaseRequest);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<LinkUsecaseRequest> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the link usecase requests where request_id = &#63; and weight &gt; &#63; from the database.
	 *
	 * @param request_id the request_id
	 * @param weight the weight
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByRequestIdAndUsed(long request_id, double weight)
		throws SystemException {
		for (LinkUsecaseRequest linkUsecaseRequest : findByRequestIdAndUsed(
				request_id, weight, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(linkUsecaseRequest);
		}
	}

	/**
	 * Returns the number of link usecase requests where request_id = &#63; and weight &gt; &#63;.
	 *
	 * @param request_id the request_id
	 * @param weight the weight
	 * @return the number of matching link usecase requests
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByRequestIdAndUsed(long request_id, double weight)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_WITH_PAGINATION_COUNT_BY_REQUESTIDANDUSED;

		Object[] finderArgs = new Object[] { request_id, weight };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_LINKUSECASEREQUEST_WHERE);

			query.append(_FINDER_COLUMN_REQUESTIDANDUSED_REQUEST_ID_2);

			query.append(_FINDER_COLUMN_REQUESTIDANDUSED_WEIGHT_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(request_id);

				qPos.add(weight);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_REQUESTIDANDUSED_REQUEST_ID_2 = "linkUsecaseRequest.request_id = ? AND ";
	private static final String _FINDER_COLUMN_REQUESTIDANDUSED_WEIGHT_2 = "linkUsecaseRequest.weight > ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_REQUESTID =
		new FinderPath(LinkUsecaseRequestModelImpl.ENTITY_CACHE_ENABLED,
			LinkUsecaseRequestModelImpl.FINDER_CACHE_ENABLED,
			LinkUsecaseRequestImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByRequestId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_REQUESTID =
		new FinderPath(LinkUsecaseRequestModelImpl.ENTITY_CACHE_ENABLED,
			LinkUsecaseRequestModelImpl.FINDER_CACHE_ENABLED,
			LinkUsecaseRequestImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByRequestId",
			new String[] { Long.class.getName() },
			LinkUsecaseRequestModelImpl.REQUEST_ID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_REQUESTID = new FinderPath(LinkUsecaseRequestModelImpl.ENTITY_CACHE_ENABLED,
			LinkUsecaseRequestModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByRequestId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the link usecase requests where request_id = &#63;.
	 *
	 * @param request_id the request_id
	 * @return the matching link usecase requests
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LinkUsecaseRequest> findByRequestId(long request_id)
		throws SystemException {
		return findByRequestId(request_id, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the link usecase requests where request_id = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.excilys.liferay.gatling.model.impl.LinkUsecaseRequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param request_id the request_id
	 * @param start the lower bound of the range of link usecase requests
	 * @param end the upper bound of the range of link usecase requests (not inclusive)
	 * @return the range of matching link usecase requests
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LinkUsecaseRequest> findByRequestId(long request_id, int start,
		int end) throws SystemException {
		return findByRequestId(request_id, start, end, null);
	}

	/**
	 * Returns an ordered range of all the link usecase requests where request_id = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.excilys.liferay.gatling.model.impl.LinkUsecaseRequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param request_id the request_id
	 * @param start the lower bound of the range of link usecase requests
	 * @param end the upper bound of the range of link usecase requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching link usecase requests
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LinkUsecaseRequest> findByRequestId(long request_id, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_REQUESTID;
			finderArgs = new Object[] { request_id };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_REQUESTID;
			finderArgs = new Object[] { request_id, start, end, orderByComparator };
		}

		List<LinkUsecaseRequest> list = (List<LinkUsecaseRequest>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (LinkUsecaseRequest linkUsecaseRequest : list) {
				if ((request_id != linkUsecaseRequest.getRequest_id())) {
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
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_LINKUSECASEREQUEST_WHERE);

			query.append(_FINDER_COLUMN_REQUESTID_REQUEST_ID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(LinkUsecaseRequestModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(request_id);

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
	 * Returns the first link usecase request in the ordered set where request_id = &#63;.
	 *
	 * @param request_id the request_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching link usecase request
	 * @throws com.excilys.liferay.gatling.NoSuchLinkUsecaseRequestException if a matching link usecase request could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LinkUsecaseRequest findByRequestId_First(long request_id,
		OrderByComparator orderByComparator)
		throws NoSuchLinkUsecaseRequestException, SystemException {
		LinkUsecaseRequest linkUsecaseRequest = fetchByRequestId_First(request_id,
				orderByComparator);

		if (linkUsecaseRequest != null) {
			return linkUsecaseRequest;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("request_id=");
		msg.append(request_id);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLinkUsecaseRequestException(msg.toString());
	}

	/**
	 * Returns the first link usecase request in the ordered set where request_id = &#63;.
	 *
	 * @param request_id the request_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching link usecase request, or <code>null</code> if a matching link usecase request could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LinkUsecaseRequest fetchByRequestId_First(long request_id,
		OrderByComparator orderByComparator) throws SystemException {
		List<LinkUsecaseRequest> list = findByRequestId(request_id, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last link usecase request in the ordered set where request_id = &#63;.
	 *
	 * @param request_id the request_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching link usecase request
	 * @throws com.excilys.liferay.gatling.NoSuchLinkUsecaseRequestException if a matching link usecase request could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LinkUsecaseRequest findByRequestId_Last(long request_id,
		OrderByComparator orderByComparator)
		throws NoSuchLinkUsecaseRequestException, SystemException {
		LinkUsecaseRequest linkUsecaseRequest = fetchByRequestId_Last(request_id,
				orderByComparator);

		if (linkUsecaseRequest != null) {
			return linkUsecaseRequest;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("request_id=");
		msg.append(request_id);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLinkUsecaseRequestException(msg.toString());
	}

	/**
	 * Returns the last link usecase request in the ordered set where request_id = &#63;.
	 *
	 * @param request_id the request_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching link usecase request, or <code>null</code> if a matching link usecase request could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LinkUsecaseRequest fetchByRequestId_Last(long request_id,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByRequestId(request_id);

		if (count == 0) {
			return null;
		}

		List<LinkUsecaseRequest> list = findByRequestId(request_id, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the link usecase requests before and after the current link usecase request in the ordered set where request_id = &#63;.
	 *
	 * @param linkUsecaseRequestId the primary key of the current link usecase request
	 * @param request_id the request_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next link usecase request
	 * @throws com.excilys.liferay.gatling.NoSuchLinkUsecaseRequestException if a link usecase request with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LinkUsecaseRequest[] findByRequestId_PrevAndNext(
		long linkUsecaseRequestId, long request_id,
		OrderByComparator orderByComparator)
		throws NoSuchLinkUsecaseRequestException, SystemException {
		LinkUsecaseRequest linkUsecaseRequest = findByPrimaryKey(linkUsecaseRequestId);

		Session session = null;

		try {
			session = openSession();

			LinkUsecaseRequest[] array = new LinkUsecaseRequestImpl[3];

			array[0] = getByRequestId_PrevAndNext(session, linkUsecaseRequest,
					request_id, orderByComparator, true);

			array[1] = linkUsecaseRequest;

			array[2] = getByRequestId_PrevAndNext(session, linkUsecaseRequest,
					request_id, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected LinkUsecaseRequest getByRequestId_PrevAndNext(Session session,
		LinkUsecaseRequest linkUsecaseRequest, long request_id,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LINKUSECASEREQUEST_WHERE);

		query.append(_FINDER_COLUMN_REQUESTID_REQUEST_ID_2);

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
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
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
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(LinkUsecaseRequestModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(request_id);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(linkUsecaseRequest);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<LinkUsecaseRequest> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the link usecase requests where request_id = &#63; from the database.
	 *
	 * @param request_id the request_id
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByRequestId(long request_id) throws SystemException {
		for (LinkUsecaseRequest linkUsecaseRequest : findByRequestId(
				request_id, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(linkUsecaseRequest);
		}
	}

	/**
	 * Returns the number of link usecase requests where request_id = &#63;.
	 *
	 * @param request_id the request_id
	 * @return the number of matching link usecase requests
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByRequestId(long request_id) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_REQUESTID;

		Object[] finderArgs = new Object[] { request_id };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LINKUSECASEREQUEST_WHERE);

			query.append(_FINDER_COLUMN_REQUESTID_REQUEST_ID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(request_id);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_REQUESTID_REQUEST_ID_2 = "linkUsecaseRequest.request_id = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_RECORDID = new FinderPath(LinkUsecaseRequestModelImpl.ENTITY_CACHE_ENABLED,
			LinkUsecaseRequestModelImpl.FINDER_CACHE_ENABLED,
			LinkUsecaseRequestImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByRecordId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RECORDID =
		new FinderPath(LinkUsecaseRequestModelImpl.ENTITY_CACHE_ENABLED,
			LinkUsecaseRequestModelImpl.FINDER_CACHE_ENABLED,
			LinkUsecaseRequestImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByRecordId",
			new String[] { Long.class.getName() },
			LinkUsecaseRequestModelImpl.RECORDID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_RECORDID = new FinderPath(LinkUsecaseRequestModelImpl.ENTITY_CACHE_ENABLED,
			LinkUsecaseRequestModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByRecordId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the link usecase requests where recordId = &#63;.
	 *
	 * @param recordId the record ID
	 * @return the matching link usecase requests
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LinkUsecaseRequest> findByRecordId(long recordId)
		throws SystemException {
		return findByRecordId(recordId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the link usecase requests where recordId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.excilys.liferay.gatling.model.impl.LinkUsecaseRequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param recordId the record ID
	 * @param start the lower bound of the range of link usecase requests
	 * @param end the upper bound of the range of link usecase requests (not inclusive)
	 * @return the range of matching link usecase requests
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LinkUsecaseRequest> findByRecordId(long recordId, int start,
		int end) throws SystemException {
		return findByRecordId(recordId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the link usecase requests where recordId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.excilys.liferay.gatling.model.impl.LinkUsecaseRequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param recordId the record ID
	 * @param start the lower bound of the range of link usecase requests
	 * @param end the upper bound of the range of link usecase requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching link usecase requests
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LinkUsecaseRequest> findByRecordId(long recordId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RECORDID;
			finderArgs = new Object[] { recordId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_RECORDID;
			finderArgs = new Object[] { recordId, start, end, orderByComparator };
		}

		List<LinkUsecaseRequest> list = (List<LinkUsecaseRequest>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (LinkUsecaseRequest linkUsecaseRequest : list) {
				if ((recordId != linkUsecaseRequest.getRecordId())) {
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
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_LINKUSECASEREQUEST_WHERE);

			query.append(_FINDER_COLUMN_RECORDID_RECORDID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(LinkUsecaseRequestModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(recordId);

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
	 * Returns the first link usecase request in the ordered set where recordId = &#63;.
	 *
	 * @param recordId the record ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching link usecase request
	 * @throws com.excilys.liferay.gatling.NoSuchLinkUsecaseRequestException if a matching link usecase request could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LinkUsecaseRequest findByRecordId_First(long recordId,
		OrderByComparator orderByComparator)
		throws NoSuchLinkUsecaseRequestException, SystemException {
		LinkUsecaseRequest linkUsecaseRequest = fetchByRecordId_First(recordId,
				orderByComparator);

		if (linkUsecaseRequest != null) {
			return linkUsecaseRequest;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("recordId=");
		msg.append(recordId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLinkUsecaseRequestException(msg.toString());
	}

	/**
	 * Returns the first link usecase request in the ordered set where recordId = &#63;.
	 *
	 * @param recordId the record ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching link usecase request, or <code>null</code> if a matching link usecase request could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LinkUsecaseRequest fetchByRecordId_First(long recordId,
		OrderByComparator orderByComparator) throws SystemException {
		List<LinkUsecaseRequest> list = findByRecordId(recordId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last link usecase request in the ordered set where recordId = &#63;.
	 *
	 * @param recordId the record ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching link usecase request
	 * @throws com.excilys.liferay.gatling.NoSuchLinkUsecaseRequestException if a matching link usecase request could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LinkUsecaseRequest findByRecordId_Last(long recordId,
		OrderByComparator orderByComparator)
		throws NoSuchLinkUsecaseRequestException, SystemException {
		LinkUsecaseRequest linkUsecaseRequest = fetchByRecordId_Last(recordId,
				orderByComparator);

		if (linkUsecaseRequest != null) {
			return linkUsecaseRequest;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("recordId=");
		msg.append(recordId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLinkUsecaseRequestException(msg.toString());
	}

	/**
	 * Returns the last link usecase request in the ordered set where recordId = &#63;.
	 *
	 * @param recordId the record ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching link usecase request, or <code>null</code> if a matching link usecase request could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LinkUsecaseRequest fetchByRecordId_Last(long recordId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByRecordId(recordId);

		if (count == 0) {
			return null;
		}

		List<LinkUsecaseRequest> list = findByRecordId(recordId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the link usecase requests before and after the current link usecase request in the ordered set where recordId = &#63;.
	 *
	 * @param linkUsecaseRequestId the primary key of the current link usecase request
	 * @param recordId the record ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next link usecase request
	 * @throws com.excilys.liferay.gatling.NoSuchLinkUsecaseRequestException if a link usecase request with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LinkUsecaseRequest[] findByRecordId_PrevAndNext(
		long linkUsecaseRequestId, long recordId,
		OrderByComparator orderByComparator)
		throws NoSuchLinkUsecaseRequestException, SystemException {
		LinkUsecaseRequest linkUsecaseRequest = findByPrimaryKey(linkUsecaseRequestId);

		Session session = null;

		try {
			session = openSession();

			LinkUsecaseRequest[] array = new LinkUsecaseRequestImpl[3];

			array[0] = getByRecordId_PrevAndNext(session, linkUsecaseRequest,
					recordId, orderByComparator, true);

			array[1] = linkUsecaseRequest;

			array[2] = getByRecordId_PrevAndNext(session, linkUsecaseRequest,
					recordId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected LinkUsecaseRequest getByRecordId_PrevAndNext(Session session,
		LinkUsecaseRequest linkUsecaseRequest, long recordId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LINKUSECASEREQUEST_WHERE);

		query.append(_FINDER_COLUMN_RECORDID_RECORDID_2);

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
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
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
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(LinkUsecaseRequestModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(recordId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(linkUsecaseRequest);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<LinkUsecaseRequest> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the link usecase requests where recordId = &#63; from the database.
	 *
	 * @param recordId the record ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByRecordId(long recordId) throws SystemException {
		for (LinkUsecaseRequest linkUsecaseRequest : findByRecordId(recordId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(linkUsecaseRequest);
		}
	}

	/**
	 * Returns the number of link usecase requests where recordId = &#63;.
	 *
	 * @param recordId the record ID
	 * @return the number of matching link usecase requests
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByRecordId(long recordId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_RECORDID;

		Object[] finderArgs = new Object[] { recordId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LINKUSECASEREQUEST_WHERE);

			query.append(_FINDER_COLUMN_RECORDID_RECORDID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(recordId);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_RECORDID_RECORDID_2 = "linkUsecaseRequest.recordId = ?";

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

		LinkUsecaseRequestModelImpl linkUsecaseRequestModelImpl = (LinkUsecaseRequestModelImpl)linkUsecaseRequest;

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

		if (isNew || !LinkUsecaseRequestModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((linkUsecaseRequestModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_REQUESTID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						linkUsecaseRequestModelImpl.getOriginalRequest_id()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_REQUESTID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_REQUESTID,
					args);

				args = new Object[] { linkUsecaseRequestModelImpl.getRequest_id() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_REQUESTID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_REQUESTID,
					args);
			}

			if ((linkUsecaseRequestModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RECORDID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						linkUsecaseRequestModelImpl.getOriginalRecordId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_RECORDID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RECORDID,
					args);

				args = new Object[] { linkUsecaseRequestModelImpl.getRecordId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_RECORDID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RECORDID,
					args);
			}
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
	private static final String _SQL_SELECT_LINKUSECASEREQUEST_WHERE = "SELECT linkUsecaseRequest FROM LinkUsecaseRequest linkUsecaseRequest WHERE ";
	private static final String _SQL_COUNT_LINKUSECASEREQUEST = "SELECT COUNT(linkUsecaseRequest) FROM LinkUsecaseRequest linkUsecaseRequest";
	private static final String _SQL_COUNT_LINKUSECASEREQUEST_WHERE = "SELECT COUNT(linkUsecaseRequest) FROM LinkUsecaseRequest linkUsecaseRequest WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "linkUsecaseRequest.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LinkUsecaseRequest exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No LinkUsecaseRequest exists with the key {";
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