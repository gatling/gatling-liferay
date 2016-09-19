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
	
	
	@Override
	public Login findByProcessId(long processId) throws SystemException, NoSuchModelException, NoSuchProcessException {
		Process process = processPersistence.findByPrimaryKey(processId);
		Long feederId = process.getFeederId();
		if(ProcessType.valueOf(process.getType()) == ProcessType.LOGIN && feederId != null){
			return loginPersistence.findByPrimaryKey(feederId);
		}
		return null;
	}
	
	@Override
	public Login findByName(String name) throws NoSuchRecordException, SystemException, NoSuchLoginException {
		return loginPersistence.findByName(name);
	}
	
}
