package io.gatling.liferay.service.impl;

import io.gatling.liferay.NoSuchProcessException;
import io.gatling.liferay.NoSuchRecordException;
import io.gatling.liferay.NoSuchSiteMapException;
import io.gatling.liferay.NoSuchUrlSiteMapException;
import io.gatling.liferay.model.Process;
import io.gatling.liferay.model.ProcessType;
import io.gatling.liferay.model.SiteMap;
import io.gatling.liferay.model.UrlSiteMap;
import io.gatling.liferay.service.UrlSiteMapLocalServiceUtil;
import io.gatling.liferay.service.base.SiteMapLocalServiceBaseImpl;
import io.gatling.liferay.service.persistence.SiteMapUtil;
import io.gatling.liferay.util.GatlingUtil;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.Layout;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;

import java.util.List;

/**
 * The implementation of the site map local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link io.gatling.liferay.service.SiteMapLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see io.gatling.liferay.service.base.SiteMapLocalServiceBaseImpl
 * @see io.gatling.liferay.service.SiteMapLocalServiceUtil
 */
public class SiteMapLocalServiceImpl extends SiteMapLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link io.gatling.liferay.service.SiteMapLocalServiceUtil} to access the site map local service.
     */
	
	public static final String DEFAULT_NAME = "_default_sitemap_";
	
	@Override
	public SiteMap siteMapCreation(ThemeDisplay themeDisplay, long groupId, String portalUrl) throws SystemException, NoSuchUrlSiteMapException {
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
	    	String url = GatlingUtil.getGroupFriendlyURL(themeDisplay, layout).replaceAll(portalUrl, "");
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
