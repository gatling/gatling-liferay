/**
 * Copyright 2011-2015 GatlingCorp (http://gatling.io)
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

import io.gatling.liferay.NoSuchLoginException;
import io.gatling.liferay.NoSuchProcessException;
import io.gatling.liferay.NoSuchRecordException;
import io.gatling.liferay.model.Login;
import io.gatling.liferay.model.Process;
import io.gatling.liferay.model.ProcessType;
import io.gatling.liferay.service.base.LoginLocalServiceBaseImpl;
import io.gatling.liferay.service.persistence.LoginUtil;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the login local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link io.gatling.liferay.service.LoginLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see io.gatling.liferay.service.base.LoginLocalServiceBaseImpl
 * @see io.gatling.liferay.service.LoginLocalServiceUtil
 */
public class LoginLocalServiceImpl extends LoginLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link io.gatling.liferay.service.LoginLocalServiceUtil} to access the login local service.
     */
	
	public static final String DEFAULT_NAME = "_default_login_";
	
	/**
	 * Tries to return the default login if it exists in database.
	 * If not found, this function creates it, persist it and returns it
	 * @return The default Login
	 * @throws SystemException if an error occurs in services
	 */
	@Override
	public Login createDefaultLogin() throws SystemException {
		try {
			return loginPersistence.findByName(DEFAULT_NAME);
		} catch (NoSuchLoginException e) {
			Login defaultLogin = LoginUtil.create(CounterLocalServiceUtil.increment(Login.class.getName()));
			defaultLogin.setName(DEFAULT_NAME);
			defaultLogin.setData("user1@liferay.com,user1Password\nuser2@liferay.com,user2Password");
			defaultLogin.persist();
			return defaultLogin;
		}
		
	}
	
	/**
	 * Finds the Login corresponding to the given processId.
	 * @param processId The processId contained by the Login we search for
	 * @return the matching Login
	 * @throws SystemException if an error occurs in services
	 * @throws NoSuchProcessExceptino if no process was found
	 */
	@Override
	public Login findByProcessId(long processId) throws SystemException, NoSuchModelException, NoSuchProcessException {
		Process process = processPersistence.findByPrimaryKey(processId);
		Long feederId = process.getFeederId();
		if(ProcessType.valueOf(process.getType()) == ProcessType.LOGIN && feederId != null){
			return loginPersistence.findByPrimaryKey(feederId);
		}
		return null;
	}
	
	/**
	 * Finds the Login corresponding to the given name.
	 * @param name The name of Login we are searching for
	 * @return The matching Login
	 * @throws SystemException if an error occurs in services
	 * @throws NoSuchRecordException if no Record was found
	 * @throws NoSuchLoginException if no Login was found
	 */
	@Override
	public Login findByName(String name) throws NoSuchRecordException, SystemException, NoSuchLoginException {
		return loginPersistence.findByName(name);
	}
	
}
