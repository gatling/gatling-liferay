package com.excilys.liferay.gatling.service.impl;

import com.excilys.liferay.gatling.service.base.ProcessLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the process local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.excilys.liferay.gatling.service.ProcessLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.excilys.liferay.gatling.service.base.ProcessLocalServiceBaseImpl
 * @see com.excilys.liferay.gatling.service.ProcessLocalServiceUtil
 */
public class ProcessLocalServiceImpl extends ProcessLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.excilys.liferay.gatling.service.ProcessLocalServiceUtil} to access the process local service.
     */
	@Override
	public java.util.List<com.excilys.liferay.gatling.model.Process> findProcessFromScenarioId(long id) throws SystemException {
		return processPersistence.findByScenarioId(id);
	}
}
