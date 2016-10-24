/**
 * Copyright 2011-2016 GatlingCorp (http://gatling.io)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * 		http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.gatling.liferay.service.impl;

import java.util.List;

import io.gatling.liferay.model.UrlRecord;
import io.gatling.liferay.service.base.UrlRecordLocalServiceBaseImpl;
import io.gatling.liferay.validator.UrlRecordValidator;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

/**
 * The implementation of the url record local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link io.gatling.liferay.service.UrlRecordLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see io.gatling.liferay.service.base.UrlRecordLocalServiceBaseImpl
 * @see io.gatling.liferay.service.UrlRecordLocalServiceUtil
 */
public class UrlRecordLocalServiceImpl extends UrlRecordLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link io.gatling.liferay.service.UrlRecordLocalServiceUtil} to access the url record local service.
	 */

	private static final Log LOG = LogFactoryUtil.getLog(UrlRecordLocalServiceImpl.class);
	
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
	public long save(String url, String type, int order, long recordId, int pauseTime) throws SystemException {
		long primaryKeyUrl = CounterLocalServiceUtil.increment(UrlRecord.class.getName());
		UrlRecord urlRecord = urlRecordPersistence.create(primaryKeyUrl);
		urlRecord.setUrl(url);
		urlRecord.setType(type);
		urlRecord.setOrder(order);
		urlRecord.setRecordId(recordId);
		urlRecord.setPauseTime(pauseTime);
		final List<String> errors = UrlRecordValidator.validateUrlRecord(urlRecord);
		if(errors.isEmpty()) {
			urlRecord.persist();
		}
		else {
			LOG.error("Invalid UrlRecord : The UrlRecord could not be saved");
		}
		return primaryKeyUrl;
	}
}