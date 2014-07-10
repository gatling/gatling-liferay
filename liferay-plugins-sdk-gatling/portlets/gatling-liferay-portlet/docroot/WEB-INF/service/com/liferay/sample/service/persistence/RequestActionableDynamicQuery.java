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

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import com.liferay.sample.model.Request;
import com.liferay.sample.service.RequestLocalServiceUtil;

/**
 * @author sana
 * @generated
 */
public abstract class RequestActionableDynamicQuery
	extends BaseActionableDynamicQuery {
	public RequestActionableDynamicQuery() throws SystemException {
		setBaseLocalService(RequestLocalServiceUtil.getService());
		setClass(Request.class);

		setClassLoader(com.liferay.sample.service.ClpSerializer.class.getClassLoader());

		setPrimaryKeyPropertyName("request_id");
	}
}