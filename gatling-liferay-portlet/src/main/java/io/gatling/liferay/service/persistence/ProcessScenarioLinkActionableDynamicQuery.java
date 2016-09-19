package io.gatling.liferay.service.persistence;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import io.gatling.liferay.model.ProcessScenarioLink;
import io.gatling.liferay.service.ProcessScenarioLinkLocalServiceUtil;

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

        setClassLoader(io.gatling.liferay.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("psl_id");
    }
}
