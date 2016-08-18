package com.excilys.liferay.gatling.service.persistence;

import com.excilys.liferay.gatling.model.LinkProcessRecord;
import com.excilys.liferay.gatling.service.LinkProcessRecordLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class LinkProcessRecordActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public LinkProcessRecordActionableDynamicQuery() throws SystemException {
        setBaseLocalService(LinkProcessRecordLocalServiceUtil.getService());
        setClass(LinkProcessRecord.class);

        setClassLoader(com.excilys.liferay.gatling.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("link_process_record_id");
    }
}
