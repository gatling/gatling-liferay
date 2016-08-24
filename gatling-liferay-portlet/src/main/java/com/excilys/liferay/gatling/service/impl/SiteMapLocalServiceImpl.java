package com.excilys.liferay.gatling.service.impl;

import com.excilys.liferay.gatling.NoSuchProcessException;
import com.excilys.liferay.gatling.NoSuchRecordException;
import com.excilys.liferay.gatling.NoSuchSiteMapException;
import com.excilys.liferay.gatling.model.Login;
import com.excilys.liferay.gatling.model.Process;
import com.excilys.liferay.gatling.model.ProcessType;
import com.excilys.liferay.gatling.model.SiteMap;
import com.excilys.liferay.gatling.service.base.SiteMapLocalServiceBaseImpl;
import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the site map local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.excilys.liferay.gatling.service.SiteMapLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.excilys.liferay.gatling.service.base.SiteMapLocalServiceBaseImpl
 * @see com.excilys.liferay.gatling.service.SiteMapLocalServiceUtil
 */
public class SiteMapLocalServiceImpl extends SiteMapLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.excilys.liferay.gatling.service.SiteMapLocalServiceUtil} to access the site map local service.
     */
	
	@Override
	public SiteMap findByProcessId(long processId) throws SystemException, NoSuchModelException, NoSuchProcessException {
		Process process = processPersistence.findByPrimaryKey(processId);
		Long feederId = process.getFeederId();
		if(ProcessType.valueOf(process.getType()) == ProcessType.RANDOMPAGE && feederId != null){
			return siteMapPersistence.findByPrimaryKey(feederId);
		}
		return null;
	}
	
	@Override
	public SiteMap findByName(String name) throws NoSuchRecordException, SystemException, NoSuchSiteMapException {
		return siteMapPersistence.findByName(name);
	}
	
}
