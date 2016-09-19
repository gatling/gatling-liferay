package io.gatling.liferay.service.persistence;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import io.gatling.liferay.model.UrlRecord;
import io.gatling.liferay.service.UrlRecordLocalServiceUtil;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class UrlRecordActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public UrlRecordActionableDynamicQuery() throws SystemException {
        setBaseLocalService(UrlRecordLocalServiceUtil.getService());
        setClass(UrlRecord.class);

        setClassLoader(io.gatling.liferay.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("urlRecordId");
    }
}
