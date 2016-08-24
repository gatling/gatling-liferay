package com.excilys.liferay.gatling.service.persistence;

import com.excilys.liferay.gatling.model.SiteMap;
import com.excilys.liferay.gatling.service.SiteMapLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class SiteMapActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public SiteMapActionableDynamicQuery() throws SystemException {
        setBaseLocalService(SiteMapLocalServiceUtil.getService());
        setClass(SiteMap.class);

        setClassLoader(com.excilys.liferay.gatling.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("siteMapId");
    }
}
