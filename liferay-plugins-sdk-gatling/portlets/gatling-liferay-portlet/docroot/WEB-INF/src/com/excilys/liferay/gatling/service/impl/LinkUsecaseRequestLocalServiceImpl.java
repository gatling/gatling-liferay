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

import com.excilys.liferay.gatling.model.LinkUsecaseRequest;
import com.excilys.liferay.gatling.service.LinkUsecaseRequestLocalServiceUtil;
import com.excilys.liferay.gatling.service.base.LinkUsecaseRequestLocalServiceBaseImpl;
import com.excilys.liferay.gatling.validator.LinkUsecaseRequestValidator;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.util.List;

/**
 * The implementation of the link usecase request local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.excilys.liferay.gatling.service.LinkUsecaseRequestLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.excilys.liferay.gatling.service.base.LinkUsecaseRequestLocalServiceBaseImpl
 * @see com.excilys.liferay.gatling.service.LinkUsecaseRequestLocalServiceUtil
 */
public class LinkUsecaseRequestLocalServiceImpl
	extends LinkUsecaseRequestLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.excilys.liferay.gatling.service.LinkUsecaseRequestLocalServiceUtil} to access the link usecase request local service.
	 */
	
	private static final Log LOG = LogFactoryUtil.getLog(LinkUsecaseRequestLocalServiceImpl.class.getName());
	
	public void savelinkUseCase(long requestId, long recordId, double weight, boolean isSample){
		long primaryKey;
		try {
			primaryKey = CounterLocalServiceUtil.increment(LinkUsecaseRequest.class.getName());
			final LinkUsecaseRequest newLinkUsecaseRequest = LinkUsecaseRequestLocalServiceUtil.createLinkUsecaseRequest(primaryKey);
			newLinkUsecaseRequest.setRequest_id(requestId);
			newLinkUsecaseRequest.setRecordId(recordId);
			newLinkUsecaseRequest.setWeight(weight);
			newLinkUsecaseRequest.setSample(isSample);
			final List<String> errors = LinkUsecaseRequestValidator.validateLinkUsecaseRequest(newLinkUsecaseRequest);
			if(errors.isEmpty()) {
				LinkUsecaseRequestLocalServiceUtil.addLinkUsecaseRequest(newLinkUsecaseRequest);
			}
		} catch (SystemException e) {
			if (LOG.isErrorEnabled()){
				LOG.error("unable to add new LinkUsecaseRequest");
			}
		}
		
	}
}