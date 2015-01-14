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

import com.excilys.liferay.gatling.NoSuchRecordException;
import com.excilys.liferay.gatling.model.Record;
import com.excilys.liferay.gatling.model.impl.RecordImpl;
import com.excilys.liferay.gatling.model.impl.RecordModelImpl;

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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the record service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RecordPersistence
 * @see RecordUtil
 * @generated
 */
public class RecordPersistenceImpl extends BasePersistenceImpl<Record>
	implements RecordPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link RecordUtil} to access the record persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = RecordImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(RecordModelImpl.ENTITY_CACHE_ENABLED,
			RecordModelImpl.FINDER_CACHE_ENABLED, RecordImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(RecordModelImpl.ENTITY_CACHE_ENABLED,
			RecordModelImpl.FINDER_CACHE_ENABLED, RecordImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(RecordModelImpl.ENTITY_CACHE_ENABLED,
			RecordModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PORTLETID =
		new FinderPath(RecordModelImpl.ENTITY_CACHE_ENABLED,
			RecordModelImpl.FINDER_CACHE_ENABLED, RecordImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByPortletId",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PORTLETID =
		new FinderPath(RecordModelImpl.ENTITY_CACHE_ENABLED,
			RecordModelImpl.FINDER_CACHE_ENABLED, RecordImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByPortletId",
			new String[] { String.class.getName() },
			RecordModelImpl.PORTLETID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PORTLETID = new FinderPath(RecordModelImpl.ENTITY_CACHE_ENABLED,
			RecordModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByPortletId",
			new String[] { String.class.getName() });

	/**
	 * Returns all the records where portletId = &#63;.
	 *
	 * @param portletId the portlet ID
	 * @return the matching records
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Record> findByPortletId(String portletId)
		throws SystemException {
		return findByPortletId(portletId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the records where portletId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.excilys.liferay.gatling.model.impl.RecordModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param portletId the portlet ID
	 * @param start the lower bound of the range of records
	 * @param end the upper bound of the range of records (not inclusive)
	 * @return the range of matching records
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Record> findByPortletId(String portletId, int start, int end)
		throws SystemException {
		return findByPortletId(portletId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the records where portletId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.excilys.liferay.gatling.model.impl.RecordModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param portletId the portlet ID
	 * @param start the lower bound of the range of records
	 * @param end the upper bound of the range of records (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching records
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Record> findByPortletId(String portletId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PORTLETID;
			finderArgs = new Object[] { portletId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PORTLETID;
			finderArgs = new Object[] { portletId, start, end, orderByComparator };
		}

		List<Record> list = (List<Record>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Record record : list) {
				if (!Validator.equals(portletId, record.getPortletId())) {
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

			query.append(_SQL_SELECT_RECORD_WHERE);

			boolean bindPortletId = false;

			if (portletId == null) {
				query.append(_FINDER_COLUMN_PORTLETID_PORTLETID_1);
			}
			else if (portletId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PORTLETID_PORTLETID_3);
			}
			else {
				bindPortletId = true;

				query.append(_FINDER_COLUMN_PORTLETID_PORTLETID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(RecordModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindPortletId) {
					qPos.add(portletId);
				}

				if (!pagination) {
					list = (List<Record>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Record>(list);
				}
				else {
					list = (List<Record>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Returns the first record in the ordered set where portletId = &#63;.
	 *
	 * @param portletId the portlet ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching record
	 * @throws com.excilys.liferay.gatling.NoSuchRecordException if a matching record could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Record findByPortletId_First(String portletId,
		OrderByComparator orderByComparator)
		throws NoSuchRecordException, SystemException {
		Record record = fetchByPortletId_First(portletId, orderByComparator);

		if (record != null) {
			return record;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("portletId=");
		msg.append(portletId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRecordException(msg.toString());
	}

	/**
	 * Returns the first record in the ordered set where portletId = &#63;.
	 *
	 * @param portletId the portlet ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching record, or <code>null</code> if a matching record could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Record fetchByPortletId_First(String portletId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Record> list = findByPortletId(portletId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last record in the ordered set where portletId = &#63;.
	 *
	 * @param portletId the portlet ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching record
	 * @throws com.excilys.liferay.gatling.NoSuchRecordException if a matching record could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Record findByPortletId_Last(String portletId,
		OrderByComparator orderByComparator)
		throws NoSuchRecordException, SystemException {
		Record record = fetchByPortletId_Last(portletId, orderByComparator);

		if (record != null) {
			return record;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("portletId=");
		msg.append(portletId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRecordException(msg.toString());
	}

	/**
	 * Returns the last record in the ordered set where portletId = &#63;.
	 *
	 * @param portletId the portlet ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching record, or <code>null</code> if a matching record could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Record fetchByPortletId_Last(String portletId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByPortletId(portletId);

		if (count == 0) {
			return null;
		}

		List<Record> list = findByPortletId(portletId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the records before and after the current record in the ordered set where portletId = &#63;.
	 *
	 * @param recordId the primary key of the current record
	 * @param portletId the portlet ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next record
	 * @throws com.excilys.liferay.gatling.NoSuchRecordException if a record with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Record[] findByPortletId_PrevAndNext(long recordId,
		String portletId, OrderByComparator orderByComparator)
		throws NoSuchRecordException, SystemException {
		Record record = findByPrimaryKey(recordId);

		Session session = null;

		try {
			session = openSession();

			Record[] array = new RecordImpl[3];

			array[0] = getByPortletId_PrevAndNext(session, record, portletId,
					orderByComparator, true);

			array[1] = record;

			array[2] = getByPortletId_PrevAndNext(session, record, portletId,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Record getByPortletId_PrevAndNext(Session session, Record record,
		String portletId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_RECORD_WHERE);

		boolean bindPortletId = false;

		if (portletId == null) {
			query.append(_FINDER_COLUMN_PORTLETID_PORTLETID_1);
		}
		else if (portletId.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_PORTLETID_PORTLETID_3);
		}
		else {
			bindPortletId = true;

			query.append(_FINDER_COLUMN_PORTLETID_PORTLETID_2);
		}

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
			query.append(RecordModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindPortletId) {
			qPos.add(portletId);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(record);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Record> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the records where portletId = &#63; from the database.
	 *
	 * @param portletId the portlet ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByPortletId(String portletId) throws SystemException {
		for (Record record : findByPortletId(portletId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(record);
		}
	}

	/**
	 * Returns the number of records where portletId = &#63;.
	 *
	 * @param portletId the portlet ID
	 * @return the number of matching records
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByPortletId(String portletId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PORTLETID;

		Object[] finderArgs = new Object[] { portletId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_RECORD_WHERE);

			boolean bindPortletId = false;

			if (portletId == null) {
				query.append(_FINDER_COLUMN_PORTLETID_PORTLETID_1);
			}
			else if (portletId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PORTLETID_PORTLETID_3);
			}
			else {
				bindPortletId = true;

				query.append(_FINDER_COLUMN_PORTLETID_PORTLETID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindPortletId) {
					qPos.add(portletId);
				}

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

	private static final String _FINDER_COLUMN_PORTLETID_PORTLETID_1 = "record.portletId IS NULL";
	private static final String _FINDER_COLUMN_PORTLETID_PORTLETID_2 = "record.portletId = ?";
	private static final String _FINDER_COLUMN_PORTLETID_PORTLETID_3 = "(record.portletId IS NULL OR record.portletId = '')";

	public RecordPersistenceImpl() {
		setModelClass(Record.class);
	}

	/**
	 * Caches the record in the entity cache if it is enabled.
	 *
	 * @param record the record
	 */
	@Override
	public void cacheResult(Record record) {
		EntityCacheUtil.putResult(RecordModelImpl.ENTITY_CACHE_ENABLED,
			RecordImpl.class, record.getPrimaryKey(), record);

		record.resetOriginalValues();
	}

	/**
	 * Caches the records in the entity cache if it is enabled.
	 *
	 * @param records the records
	 */
	@Override
	public void cacheResult(List<Record> records) {
		for (Record record : records) {
			if (EntityCacheUtil.getResult(
						RecordModelImpl.ENTITY_CACHE_ENABLED, RecordImpl.class,
						record.getPrimaryKey()) == null) {
				cacheResult(record);
			}
			else {
				record.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all records.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(RecordImpl.class.getName());
		}

		EntityCacheUtil.clearCache(RecordImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the record.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Record record) {
		EntityCacheUtil.removeResult(RecordModelImpl.ENTITY_CACHE_ENABLED,
			RecordImpl.class, record.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Record> records) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Record record : records) {
			EntityCacheUtil.removeResult(RecordModelImpl.ENTITY_CACHE_ENABLED,
				RecordImpl.class, record.getPrimaryKey());
		}
	}

	/**
	 * Creates a new record with the primary key. Does not add the record to the database.
	 *
	 * @param recordId the primary key for the new record
	 * @return the new record
	 */
	@Override
	public Record create(long recordId) {
		Record record = new RecordImpl();

		record.setNew(true);
		record.setPrimaryKey(recordId);

		return record;
	}

	/**
	 * Removes the record with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param recordId the primary key of the record
	 * @return the record that was removed
	 * @throws com.excilys.liferay.gatling.NoSuchRecordException if a record with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Record remove(long recordId)
		throws NoSuchRecordException, SystemException {
		return remove((Serializable)recordId);
	}

	/**
	 * Removes the record with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the record
	 * @return the record that was removed
	 * @throws com.excilys.liferay.gatling.NoSuchRecordException if a record with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Record remove(Serializable primaryKey)
		throws NoSuchRecordException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Record record = (Record)session.get(RecordImpl.class, primaryKey);

			if (record == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchRecordException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(record);
		}
		catch (NoSuchRecordException nsee) {
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
	protected Record removeImpl(Record record) throws SystemException {
		record = toUnwrappedModel(record);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(record)) {
				record = (Record)session.get(RecordImpl.class,
						record.getPrimaryKeyObj());
			}

			if (record != null) {
				session.delete(record);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (record != null) {
			clearCache(record);
		}

		return record;
	}

	@Override
	public Record updateImpl(com.excilys.liferay.gatling.model.Record record)
		throws SystemException {
		record = toUnwrappedModel(record);

		boolean isNew = record.isNew();

		RecordModelImpl recordModelImpl = (RecordModelImpl)record;

		Session session = null;

		try {
			session = openSession();

			if (record.isNew()) {
				session.save(record);

				record.setNew(false);
			}
			else {
				session.merge(record);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !RecordModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((recordModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PORTLETID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						recordModelImpl.getOriginalPortletId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PORTLETID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PORTLETID,
					args);

				args = new Object[] { recordModelImpl.getPortletId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PORTLETID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PORTLETID,
					args);
			}
		}

		EntityCacheUtil.putResult(RecordModelImpl.ENTITY_CACHE_ENABLED,
			RecordImpl.class, record.getPrimaryKey(), record);

		return record;
	}

	protected Record toUnwrappedModel(Record record) {
		if (record instanceof RecordImpl) {
			return record;
		}

		RecordImpl recordImpl = new RecordImpl();

		recordImpl.setNew(record.isNew());
		recordImpl.setPrimaryKey(record.getPrimaryKey());

		recordImpl.setRecordId(record.getRecordId());
		recordImpl.setPortletId(record.getPortletId());
		recordImpl.setVersionPortlet(record.getVersionPortlet());
		recordImpl.setName(record.getName());

		return recordImpl;
	}

	/**
	 * Returns the record with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the record
	 * @return the record
	 * @throws com.excilys.liferay.gatling.NoSuchRecordException if a record with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Record findByPrimaryKey(Serializable primaryKey)
		throws NoSuchRecordException, SystemException {
		Record record = fetchByPrimaryKey(primaryKey);

		if (record == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchRecordException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return record;
	}

	/**
	 * Returns the record with the primary key or throws a {@link com.excilys.liferay.gatling.NoSuchRecordException} if it could not be found.
	 *
	 * @param recordId the primary key of the record
	 * @return the record
	 * @throws com.excilys.liferay.gatling.NoSuchRecordException if a record with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Record findByPrimaryKey(long recordId)
		throws NoSuchRecordException, SystemException {
		return findByPrimaryKey((Serializable)recordId);
	}

	/**
	 * Returns the record with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the record
	 * @return the record, or <code>null</code> if a record with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Record fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Record record = (Record)EntityCacheUtil.getResult(RecordModelImpl.ENTITY_CACHE_ENABLED,
				RecordImpl.class, primaryKey);

		if (record == _nullRecord) {
			return null;
		}

		if (record == null) {
			Session session = null;

			try {
				session = openSession();

				record = (Record)session.get(RecordImpl.class, primaryKey);

				if (record != null) {
					cacheResult(record);
				}
				else {
					EntityCacheUtil.putResult(RecordModelImpl.ENTITY_CACHE_ENABLED,
						RecordImpl.class, primaryKey, _nullRecord);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(RecordModelImpl.ENTITY_CACHE_ENABLED,
					RecordImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return record;
	}

	/**
	 * Returns the record with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param recordId the primary key of the record
	 * @return the record, or <code>null</code> if a record with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Record fetchByPrimaryKey(long recordId) throws SystemException {
		return fetchByPrimaryKey((Serializable)recordId);
	}

	/**
	 * Returns all the records.
	 *
	 * @return the records
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Record> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the records.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.excilys.liferay.gatling.model.impl.RecordModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of records
	 * @param end the upper bound of the range of records (not inclusive)
	 * @return the range of records
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Record> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the records.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.excilys.liferay.gatling.model.impl.RecordModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of records
	 * @param end the upper bound of the range of records (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of records
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Record> findAll(int start, int end,
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

		List<Record> list = (List<Record>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_RECORD);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_RECORD;

				if (pagination) {
					sql = sql.concat(RecordModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Record>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Record>(list);
				}
				else {
					list = (List<Record>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Removes all the records from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Record record : findAll()) {
			remove(record);
		}
	}

	/**
	 * Returns the number of records.
	 *
	 * @return the number of records
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

				Query q = session.createQuery(_SQL_COUNT_RECORD);

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
	 * Initializes the record persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.excilys.liferay.gatling.model.Record")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Record>> listenersList = new ArrayList<ModelListener<Record>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Record>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(RecordImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_RECORD = "SELECT record FROM Record record";
	private static final String _SQL_SELECT_RECORD_WHERE = "SELECT record FROM Record record WHERE ";
	private static final String _SQL_COUNT_RECORD = "SELECT COUNT(record) FROM Record record";
	private static final String _SQL_COUNT_RECORD_WHERE = "SELECT COUNT(record) FROM Record record WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "record.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Record exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Record exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(RecordPersistenceImpl.class);
	private static Record _nullRecord = new RecordImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Record> toCacheModel() {
				return _nullRecordCacheModel;
			}
		};

	private static CacheModel<Record> _nullRecordCacheModel = new CacheModel<Record>() {
			@Override
			public Record toEntityModel() {
				return _nullRecord;
			}
		};
}