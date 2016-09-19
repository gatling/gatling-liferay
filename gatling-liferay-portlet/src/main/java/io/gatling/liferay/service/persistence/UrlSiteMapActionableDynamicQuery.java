package io.gatling.liferay.service.persistence;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import io.gatling.liferay.model.UrlSiteMap;
import io.gatling.liferay.service.UrlSiteMapLocalServiceUtil;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class UrlSiteMapActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public UrlSiteMapActionableDynamicQuery() throws SystemException {
        setBaseLocalService(UrlSiteMapLocalServiceUtil.getService());
        setClass(UrlSiteMap.class);

        setClassLoader(io.gatling.liferay.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("urlSiteMapId");
    }
}
