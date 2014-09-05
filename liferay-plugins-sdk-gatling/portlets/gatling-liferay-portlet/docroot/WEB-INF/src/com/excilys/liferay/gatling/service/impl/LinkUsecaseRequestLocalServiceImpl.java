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

import com.excilys.liferay.gatling.model.LinkUsecaseRequest;
import com.excilys.liferay.gatling.service.base.LinkUsecaseRequestLocalServiceBaseImpl;
import com.excilys.liferay.gatling.validator.LinkUsecaseRequestValidator;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

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

	
	public void saveLinkUseCase(long linkUsecaseRequestId, long requestId, long recordId, double weight, boolean isSample) throws SystemException, PortalException {
		long primaryKey;
		final LinkUsecaseRequest newLinkUsecaseRequest;
		if(linkUsecaseRequestId == 0){
			//Create new LinkUsecaseRequest 
			primaryKey = CounterLocalServiceUtil.increment(LinkUsecaseRequest.class.getName());
			newLinkUsecaseRequest = linkUsecaseRequestPersistence.create(primaryKey);
			newLinkUsecaseRequest.setRequest_id(requestId);
			newLinkUsecaseRequest.setRecordId(recordId);
			newLinkUsecaseRequest.setWeight(weight);
			newLinkUsecaseRequest.setSample(isSample);
			final List<String> errors = LinkUsecaseRequestValidator.validateLinkUsecaseRequest(newLinkUsecaseRequest);
			if(errors.isEmpty()) {
				linkUsecaseRequestPersistence.update(newLinkUsecaseRequest);
			}
		}
		else{
			//Update LinkUsecaseRequest
			final LinkUsecaseRequest existantLinkUsecaseRequest = linkUsecaseRequestPersistence.findByPrimaryKey(linkUsecaseRequestId);
			if(weight != existantLinkUsecaseRequest.getWeight()){
				System.out.println("ancien "+existantLinkUsecaseRequest.getWeight()+" nouveau "+weight );
				existantLinkUsecaseRequest.setWeight(weight);
				linkUsecaseRequestPersistence.update(existantLinkUsecaseRequest);
			}
		}
	}
	
	/**
	 * get {@link LinkUsecaseRequest} have this requestId
	 */
	public List<LinkUsecaseRequest> findByRecordAndRequest(long requestId, long recordId)  throws SystemException {
		return linkUsecaseRequestPersistence.findByRequestIdAndrecordId(requestId, recordId);
	}
	
	/* --- byRequestIdAndUsed (weight>0) --- */
	
	@Override
	public int countByRequestIdAndUsed(long requestId) throws SystemException{
		return linkUsecaseRequestPersistence.countByRequestIdAndUsed(requestId, 0);
	}
	
	@Override
	public List<LinkUsecaseRequest> findByRequestIdAndUsed(long requestId) throws SystemException{
		return linkUsecaseRequestPersistence.findByRequestIdAndUsed(requestId, 0);
	}
	
	/* --- byRequestId --- */
	
	@Override
	public int countByRequestId(long requestId) throws SystemException{
		return linkUsecaseRequestPersistence.countByRequestId(requestId);
	}
	
	public List<LinkUsecaseRequest> findByRequestId(long requestId) throws SystemException {
		return linkUsecaseRequestPersistence.findByRequestId(requestId);
	}
	
	public void removeByRequestId(long requestId) throws SystemException {
		linkUsecaseRequestPersistence.removeByRequestId(requestId);
	}
	
	public void removeByRecordId(long recordId) throws SystemException {
		linkUsecaseRequestPersistence.removeByRecordId(recordId);
	}

}