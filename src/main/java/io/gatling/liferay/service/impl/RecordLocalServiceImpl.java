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

import io.gatling.liferay.model.Process;
import io.gatling.liferay.model.ProcessType;
import io.gatling.liferay.NoSuchProcessException;
import io.gatling.liferay.NoSuchRecordException;
import io.gatling.liferay.model.Record;
import io.gatling.liferay.service.base.RecordLocalServiceBaseImpl;
import io.gatling.liferay.validator.RecordValidator;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.exception.SystemException;

import java.util.List;

/**
 * The implementation of the record local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link io.gatling.liferay.service.RecordLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see io.gatling.liferay.service.base.RecordLocalServiceBaseImpl
 * @see io.gatling.liferay.service.RecordLocalServiceUtil
 */
public class RecordLocalServiceImpl extends RecordLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link io.gatling.liferay.service.RecordLocalServiceUtil} to access the record local service.
	 */

	@Override
	public Record findByProcessId(long processId) throws SystemException, NoSuchModelException, NoSuchProcessException {
		Process process = processPersistence.findByPrimaryKey(processId);
		Long feederId = process.getFeederId();
		if(ProcessType.valueOf(process.getType()) == ProcessType.RECORD && feederId != null){
			return recordPersistence.findByPrimaryKey(feederId);
		}
		return null;
	}
	
	@Override
	public List<Record> findByPortletId(String portletId) throws SystemException{
		return recordPersistence.findByPortletId(portletId);
	}
	
	@Override
	public Record findByName(String name) throws NoSuchRecordException, SystemException {
		return recordPersistence.findByName(name);
	}
	
	@Override
	public int countByPortletId(String portletId) throws SystemException{
		return recordPersistence.countByPortletId(portletId);
	}
	
	@Override
	public void update(long recordId, String name) throws SystemException, NoSuchModelException{
		Record record = recordPersistence.findByPrimaryKey(recordId);
		record.setName(name);
		record.persist();
	}
	
	@Override
	public Record save(String name, String portletId, String version) throws SystemException{
		long primaryKeyRecord = CounterLocalServiceUtil.increment(Record.class.getName());
		Record record = recordPersistence.create(primaryKeyRecord);
		record.setName(name);
		record.setPortletId(portletId);
		record.setVersionPortlet(version);
		
		List<String> errors = RecordValidator.validateRecord(record);
		if(errors.isEmpty()) {
			record.persist();
			return record;
		}
		return null;
	}
}