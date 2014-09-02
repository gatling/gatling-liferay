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
import com.excilys.liferay.gatling.model.Scenario;
import com.excilys.liferay.gatling.service.LinkUsecaseRequestLocalServiceUtil;
import com.excilys.liferay.gatling.service.base.LinkUsecaseRequestLocalServiceBaseImpl;
import com.excilys.liferay.gatling.validator.LinkUsecaseRequestValidator;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
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
			
			List<LinkUsecaseRequest> existantLinkUsecaseRequest = findByRecordAndRequest(requestId, recordId);
			final LinkUsecaseRequest newLinkUsecaseRequest;
			if(existantLinkUsecaseRequest.isEmpty()){
				//Create new LinkUsecaseRequest 
				primaryKey = CounterLocalServiceUtil.increment(LinkUsecaseRequest.class.getName());
				newLinkUsecaseRequest = LinkUsecaseRequestLocalServiceUtil.createLinkUsecaseRequest(primaryKey);
				newLinkUsecaseRequest.setRequest_id(requestId);
				newLinkUsecaseRequest.setRecordId(recordId);
				newLinkUsecaseRequest.setWeight(weight);
				newLinkUsecaseRequest.setSample(isSample);
				final List<String> errors = LinkUsecaseRequestValidator.validateLinkUsecaseRequest(newLinkUsecaseRequest);
				if(errors.isEmpty()) {
					LinkUsecaseRequestLocalServiceUtil.addLinkUsecaseRequest(newLinkUsecaseRequest);
				}
			}
			else{
				//Update LinkUsecaseRequest
				newLinkUsecaseRequest = existantLinkUsecaseRequest.get(0);
				if(weight != newLinkUsecaseRequest.getWeight()){
					newLinkUsecaseRequest.setWeight(weight);
					LinkUsecaseRequest linkUsecaseRequest = LinkUsecaseRequestLocalServiceUtil.updateLinkUsecaseRequest(newLinkUsecaseRequest);
				}
			}
		} catch (SystemException e) {
			if (LOG.isErrorEnabled()){
				LOG.error("unable to add or update new LinkUsecaseRequest: "+e.getMessage());
			}
		}
	}
	
	/**
	 * get {@link LinkUsecaseRequest} have this requestId
	 */
	public List<LinkUsecaseRequest> findByRecordAndRequest(long requestId, long recordId)  throws SystemException {
		DynamicQuery dq = DynamicQueryFactoryUtil.forClass(LinkUsecaseRequest.class)
				.add(PropertyFactoryUtil.forName("recordId").eq(recordId))
				.add(PropertyFactoryUtil.forName("request_id").eq(requestId));

		return linkUsecaseRequestPersistence.findWithDynamicQuery(dq);
	}

	
	@Override
	public List<LinkUsecaseRequest> findByRequestIdAndUsed(long requestId) throws SystemException{
		return linkUsecaseRequestPersistence.findByRequestIdAndUsed(requestId, 0);
	}
	
	@Override
	public int countByRequestIdAndUsed(long requestId) throws SystemException{
		return linkUsecaseRequestPersistence.countByRequestIdAndUsed(requestId, 0);
	}
	
	

}