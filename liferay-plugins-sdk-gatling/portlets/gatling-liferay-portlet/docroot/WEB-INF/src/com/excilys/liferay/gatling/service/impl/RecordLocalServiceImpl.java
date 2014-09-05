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

import com.excilys.liferay.gatling.model.Record;
import com.excilys.liferay.gatling.service.base.RecordLocalServiceBaseImpl;
import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the record local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.excilys.liferay.gatling.service.RecordLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.excilys.liferay.gatling.service.base.RecordLocalServiceBaseImpl
 * @see com.excilys.liferay.gatling.service.RecordLocalServiceUtil
 */
public class RecordLocalServiceImpl extends RecordLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.excilys.liferay.gatling.service.RecordLocalServiceUtil} to access the record local service.
	 */

	@Override
	public List<Record> findByPortletId(String portletId) throws SystemException{
		return recordPersistence.findByPortletId(portletId);
	}
	
	@Override
	public int countByPortletId(String portletId) throws SystemException{
		return recordPersistence.countByPortletId(portletId);
	}
	
	@Override
	public void update(long recordId, String name) throws SystemException, NoSuchModelException{
		Record record = recordPersistence.findByPrimaryKey(recordId);
		record.setName(name);
		recordPersistence.update(record);
	}
}