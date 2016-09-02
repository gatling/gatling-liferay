package com.excilys.liferay.gatling.service.persistence;

import com.excilys.liferay.gatling.model.ProcessScenarioLink;
import com.excilys.liferay.gatling.service.ProcessScenarioLinkLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class ProcessScenarioLinkActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public ProcessScenarioLinkActionableDynamicQuery()
        throws SystemException {
        setBaseLocalService(ProcessScenarioLinkLocalServiceUtil.getService());
        setClass(ProcessScenarioLink.class);

        setClassLoader(com.excilys.liferay.gatling.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("psl_id");
    }
}
