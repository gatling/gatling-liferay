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

import io.gatling.liferay.model.UrlSiteMap;
import io.gatling.liferay.service.base.UrlSiteMapLocalServiceBaseImpl;
import io.gatling.liferay.service.persistence.UrlSiteMapUtil;
import io.gatling.liferay.util.GatlingUtil;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;

import java.util.List;

/**
 * The implementation of the url site map local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link io.gatling.liferay.service.UrlSiteMapLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see io.gatling.liferay.service.base.UrlSiteMapLocalServiceBaseImpl
 * @see io.gatling.liferay.service.UrlSiteMapLocalServiceUtil
 */
public class UrlSiteMapLocalServiceImpl extends UrlSiteMapLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link io.gatling.liferay.service.UrlSiteMapLocalServiceUtil} to access the url site map local service.
     */
	
	@Override
	public UrlSiteMap createUrlSiteMap(long siteMapId, String friendlyUrl, String group, String url, int weight) throws SystemException {
		UrlSiteMap urlSm = UrlSiteMapUtil.create(CounterLocalServiceUtil.increment(UrlSiteMap.class.getName()));
	    urlSm.setFriendlyUrl(friendlyUrl);
	    urlSm.setSiteMapId(siteMapId);
	    urlSm.setUrl(url);
	    urlSm.setGroup(group);
	    urlSm.setWeight(weight);
	    urlSm.persist();
	    return urlSm;
	}
	
	@Override
	public List<UrlSiteMap> findBySiteMapId(long siteMapId) throws SystemException {
		return urlSiteMapPersistence.findBySiteMapId(siteMapId);
	}
	
}
