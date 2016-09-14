package com.excilys.liferay.gatling.service.impl;

import com.excilys.liferay.gatling.model.UrlSiteMap;
import com.excilys.liferay.gatling.service.base.UrlSiteMapLocalServiceBaseImpl;
import com.excilys.liferay.gatling.service.persistence.UrlSiteMapUtil;
import com.excilys.liferay.gatling.util.GatlingUtil;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;

import java.util.List;

/**
 * The implementation of the url site map local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.excilys.liferay.gatling.service.UrlSiteMapLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.excilys.liferay.gatling.service.base.UrlSiteMapLocalServiceBaseImpl
 * @see com.excilys.liferay.gatling.service.UrlSiteMapLocalServiceUtil
 */
public class UrlSiteMapLocalServiceImpl extends UrlSiteMapLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.excilys.liferay.gatling.service.UrlSiteMapLocalServiceUtil} to access the url site map local service.
     */
	
	@Override
	public UrlSiteMap createUrlSiteMap(long siteMapId, String friendlyUrl, String url, int weight) throws SystemException {
		UrlSiteMap urlSm = UrlSiteMapUtil.create(CounterLocalServiceUtil.increment(UrlSiteMap.class.getName()));
	    urlSm.setFriendlyUrl(friendlyUrl);
	    urlSm.setSiteMapId(siteMapId);
	    urlSm.setUrl(url);
	    urlSm.setWeight(weight);
	    urlSm.persist();
	    return urlSm;
	}
	
	@Override
	public List<UrlSiteMap> findBySiteMapId(long siteMapId) throws SystemException {
		return urlSiteMapPersistence.findBySiteMapId(siteMapId);
	}
	
}
