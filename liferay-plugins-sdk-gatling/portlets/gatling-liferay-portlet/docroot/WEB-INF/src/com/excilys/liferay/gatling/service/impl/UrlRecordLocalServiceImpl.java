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

package com.excilys.liferay.gatling.service.impl;

import java.util.List;

import com.excilys.liferay.gatling.model.UrlRecord;
import com.excilys.liferay.gatling.service.base.UrlRecordLocalServiceBaseImpl;
import com.excilys.liferay.gatling.validator.UrlRecordValidator;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the url record local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.excilys.liferay.gatling.service.UrlRecordLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.excilys.liferay.gatling.service.base.UrlRecordLocalServiceBaseImpl
 * @see com.excilys.liferay.gatling.service.UrlRecordLocalServiceUtil
 */
public class UrlRecordLocalServiceImpl extends UrlRecordLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.excilys.liferay.gatling.service.UrlRecordLocalServiceUtil} to access the url record local service.
	 */

	@Override
	public List<UrlRecord> findByRecordId(long recordId) throws SystemException {
		return urlRecordPersistence.findByRecordId(recordId);
	}
	
	@Override
	public void removeByRecordId(long recordId) throws SystemException {
		urlRecordPersistence.removeByRecordId(recordId);
	}
	
	@Override
	public int countByRecordId(long recordId) throws SystemException {
		return urlRecordPersistence.countByRecordId(recordId);
	}
	
	@Override
	public void save(String url, String type, int order, long recordId) throws SystemException {
		long primaryKeyUrl = CounterLocalServiceUtil.increment(UrlRecord.class.getName());
		UrlRecord urlRecord = urlRecordPersistence.create(primaryKeyUrl);
		urlRecord.setUrl(url);
		urlRecord.setType(type);
		urlRecord.setOrder(order);
		urlRecord.setRecordId(recordId);
		final List<String> errors = UrlRecordValidator.validateUrlRecord(urlRecord);
		if(errors.isEmpty()) {
			urlRecord.persist();
		}
	}
}