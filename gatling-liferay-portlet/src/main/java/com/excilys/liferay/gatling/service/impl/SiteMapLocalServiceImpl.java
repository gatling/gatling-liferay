package com.excilys.liferay.gatling.service.impl;

import com.excilys.liferay.gatling.NoSuchProcessException;
import com.excilys.liferay.gatling.NoSuchRecordException;
import com.excilys.liferay.gatling.NoSuchSiteMapException;
import com.excilys.liferay.gatling.NoSuchUrlSiteMapException;
import com.excilys.liferay.gatling.model.Process;
import com.excilys.liferay.gatling.model.ProcessType;
import com.excilys.liferay.gatling.model.SiteMap;
import com.excilys.liferay.gatling.model.UrlSiteMap;
import com.excilys.liferay.gatling.service.UrlSiteMapLocalServiceUtil;
import com.excilys.liferay.gatling.service.base.SiteMapLocalServiceBaseImpl;
import com.excilys.liferay.gatling.service.persistence.SiteMapUtil;
import com.excilys.liferay.gatling.util.GatlingUtil;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.Layout;
import com.liferay.portal.theme.ThemeDisplay;

import java.util.List;

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
	
	public static final String DEFAULT_NAME = "_default_sitemap_";
	
	@Override
	public SiteMap siteMapCreation(ThemeDisplay themeDisplay, long groupId) throws SystemException, NoSuchUrlSiteMapException {
		//Remove existing siteMap
		try {
			SiteMap s = siteMapPersistence.findByName(DEFAULT_NAME);
			List<UrlSiteMap> urls = UrlSiteMapLocalServiceUtil.findBySiteMapId(s.getSiteMapId());
			for (UrlSiteMap urlSiteMap : urls) {
				urlSiteMapPersistence.remove(urlSiteMap.getUrlSiteMapId());
			}
			siteMapPersistence.remove(s.getSiteMapId());
			
		} catch (NoSuchSiteMapException e) {}
		
		SiteMap siteMap = createSiteMap(DEFAULT_NAME);
	    for (Layout layout : GatlingUtil.getSiteMap(groupId)) {
	    	long siteMapId = siteMap.getSiteMapId();
	    	String friendlyUrl = layout.getFriendlyURL().substring(1);
	    	String url = GatlingUtil.getGroupFriendlyURL(themeDisplay, layout);
	    	UrlSiteMapLocalServiceUtil.createUrlSiteMap(siteMapId, friendlyUrl, url, 1);
	    }
	    return siteMap;
    }
	
	@Override
	public SiteMap createSiteMap(String name) throws SystemException{
		 SiteMap siteMap = SiteMapUtil.create(CounterLocalServiceUtil.increment(SiteMap.class.getName()));
		 siteMap.setName(name);
		 siteMap.persist();
		 return siteMap;
	}
	
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
