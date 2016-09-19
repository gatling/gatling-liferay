package io.gatling.liferay.service.persistence;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import io.gatling.liferay.model.SiteMap;
import io.gatling.liferay.service.SiteMapLocalServiceUtil;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class SiteMapActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public SiteMapActionableDynamicQuery() throws SystemException {
        setBaseLocalService(SiteMapLocalServiceUtil.getService());
        setClass(SiteMap.class);

        setClassLoader(io.gatling.liferay.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("siteMapId");
    }
}
