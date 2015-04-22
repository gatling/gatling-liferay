package com.excilys.liferay.gatling.service.persistence;

import com.excilys.liferay.gatling.model.Record;
import com.excilys.liferay.gatling.service.RecordLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class RecordActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public RecordActionableDynamicQuery() throws SystemException {
        setBaseLocalService(RecordLocalServiceUtil.getService());
        setClass(Record.class);

        setClassLoader(com.excilys.liferay.gatling.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("recordId");
    }
}
