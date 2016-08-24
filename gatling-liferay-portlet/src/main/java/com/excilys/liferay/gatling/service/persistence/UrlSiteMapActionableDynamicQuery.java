package com.excilys.liferay.gatling.service.persistence;

import com.excilys.liferay.gatling.model.UrlSiteMap;
import com.excilys.liferay.gatling.service.UrlSiteMapLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class UrlSiteMapActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public UrlSiteMapActionableDynamicQuery() throws SystemException {
        setBaseLocalService(UrlSiteMapLocalServiceUtil.getService());
        setClass(UrlSiteMap.class);

        setClassLoader(com.excilys.liferay.gatling.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("urlSiteMapId");
    }
}
