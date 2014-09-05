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

package com.excilys.liferay.gatling.service.impl;

import java.util.List;

import com.excilys.liferay.gatling.dto.RequestDTO;
import com.excilys.liferay.gatling.model.Request;
import com.excilys.liferay.gatling.service.LinkUsecaseRequestLocalServiceUtil;
import com.excilys.liferay.gatling.service.base.RequestLocalServiceBaseImpl;
import com.excilys.liferay.gatling.validator.RequestValidator;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

/**
 * The implementation of the request local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.sample.service.RequestLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @see com.liferay.sample.service.base.RequestLocalServiceBaseImpl
 * @see com.liferay.sample.service.RequestLocalServiceUtil
 */
public class RequestLocalServiceImpl extends RequestLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.liferay.sample.service.RequestLocalServiceUtil} to access the request local service.
	 */
	private static final Log LOG = LogFactoryUtil.getLog(RequestLocalServiceImpl.class.getName());


	@Override
	public List<Request> findByParentPlid(long parentPlid) throws SystemException{
		return requestPersistence.findByParentPlid(parentPlid);
	}	

	@Override
	public int countByParentPlid(long parentPlid) throws SystemException{
		return requestPersistence.countByParentPlid(parentPlid);
	}

	@Override
	public List<Request> findByScenarioId(long scenarioId) throws SystemException{
		return requestPersistence.findByScenarioId(scenarioId);
	}	

	@Override
	public int countByScenarioId(long scenarioId) throws SystemException{
		return requestPersistence.countByScenarioId(scenarioId);
	}
	
	@Override
	public List<Request> findByScenarioIdAndUsed(long scenarioId) throws SystemException{
		return requestPersistence.findByScenarioIdAndUsed(scenarioId, 0);
	}
	
	@Override
	public int countByScenarioIdAndUsed(long scenarioId) throws SystemException{
		return requestPersistence.countByScenarioIdAndUsed(scenarioId, 0);
	}

	@Override
	public void removeByScenarioId(long scenarioId) throws SystemException,NoSuchModelException {
		List<Request> list = requestPersistence.findByScenarioId(scenarioId);
		for(Request r : list) {
			LinkUsecaseRequestLocalServiceUtil.removeByRequestId(r.getRequest_id());
			requestPersistence.remove(r.getRequest_id());
		}
	}
	 
	@Override
	public List<Request> findByScenarioIdAndIsNotPortlet(long scenarioId) throws SystemException{
		return requestPersistence.findByScenarioIdAndIsNotPortlet(scenarioId, false);
	}
	
	@Override
	public int countByScenarioIdAndIsNotPortlet(long scenarioId) throws SystemException{
		return requestPersistence.countByScenarioIdAndIsNotPortlet(scenarioId, false);
	}
	
	@Override
	public List<Request> findByScenarioIdAndUsedAndIsNotPortlet(long scenarioId) throws SystemException{
		return requestPersistence.findByScenarioIdAndUsedAndIsNotPortlet(scenarioId, false, 0);
	}
	
	@Override
	public int countByScenarioIdAndUsedAndIsNotPortlet(long scenarioId) throws SystemException{
		return requestPersistence.countByScenarioIdAndUsedAndIsNotPortlet(scenarioId, false, 0);
	}
	
	/**
	 * Store a {@link Request} with given values
	 */
	public void addRequestFromDisplayItem(Object displayItem1, double weight, long idScenario) throws SystemException {
		if(displayItem1 instanceof RequestDTO) {
			RequestDTO displayItem = (RequestDTO) displayItem1;
			//create request
			final long primaryKey = CounterLocalServiceUtil.increment(Request.class.getName());
			final Request newRequest = requestPersistence.create(primaryKey);
			newRequest.setPlId(displayItem.getDisplayId());
			newRequest.setName(displayItem.getName());
			newRequest.setUrl(displayItem.getUrl());
			newRequest.setWeight(weight);
			newRequest.setScenario_id(idScenario);
			newRequest.setPrivatePage(displayItem.isPrivateItem());
			newRequest.setLayoutId(displayItem.getLayoutId());
			newRequest.setParentPlId(displayItem.getParentDisplayId());
			newRequest.setPortlet(displayItem.isPortlet());
			newRequest.setPortetId(displayItem.getPortletId());
			// Saving ...
			final List<String> errors = RequestValidator.validateRequest(newRequest);
			if(errors.isEmpty()) {
				requestPersistence.update(newRequest);
			}
		}
	}
	
}