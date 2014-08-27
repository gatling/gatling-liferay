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

package com.excilys.liferay.gatling.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link RecordPortletService}.
 *
 * @author Brian Wing Shun Chan
 * @see RecordPortletService
 * @generated
 */
public class RecordPortletServiceWrapper implements RecordPortletService,
	ServiceWrapper<RecordPortletService> {
	public RecordPortletServiceWrapper(
		RecordPortletService recordPortletService) {
		_recordPortletService = recordPortletService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _recordPortletService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_recordPortletService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _recordPortletService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public RecordPortletService getWrappedRecordPortletService() {
		return _recordPortletService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedRecordPortletService(
		RecordPortletService recordPortletService) {
		_recordPortletService = recordPortletService;
	}

	@Override
	public RecordPortletService getWrappedService() {
		return _recordPortletService;
	}

	@Override
	public void setWrappedService(RecordPortletService recordPortletService) {
		_recordPortletService = recordPortletService;
	}

	private RecordPortletService _recordPortletService;
}