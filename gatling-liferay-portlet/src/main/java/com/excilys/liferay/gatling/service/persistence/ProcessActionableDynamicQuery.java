package com.excilys.liferay.gatling.service.persistence;

import com.excilys.liferay.gatling.model.Process;
import com.excilys.liferay.gatling.service.ProcessLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class ProcessActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public ProcessActionableDynamicQuery() throws SystemException {
        setBaseLocalService(ProcessLocalServiceUtil.getService());
        setClass(Process.class);

        setClassLoader(com.excilys.liferay.gatling.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("process_id");
    }
}
