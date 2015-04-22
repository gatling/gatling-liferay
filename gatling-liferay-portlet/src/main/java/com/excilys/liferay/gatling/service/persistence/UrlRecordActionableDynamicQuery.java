package com.excilys.liferay.gatling.service.persistence;

import com.excilys.liferay.gatling.model.UrlRecord;
import com.excilys.liferay.gatling.service.UrlRecordLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class UrlRecordActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public UrlRecordActionableDynamicQuery() throws SystemException {
        setBaseLocalService(UrlRecordLocalServiceUtil.getService());
        setClass(UrlRecord.class);

        setClassLoader(com.excilys.liferay.gatling.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("urlRecordId");
    }
}
