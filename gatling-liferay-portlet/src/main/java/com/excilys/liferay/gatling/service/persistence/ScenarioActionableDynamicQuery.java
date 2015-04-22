package com.excilys.liferay.gatling.service.persistence;

import com.excilys.liferay.gatling.model.Scenario;
import com.excilys.liferay.gatling.service.ScenarioLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class ScenarioActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public ScenarioActionableDynamicQuery() throws SystemException {
        setBaseLocalService(ScenarioLocalServiceUtil.getService());
        setClass(Scenario.class);

        setClassLoader(com.excilys.liferay.gatling.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("scenario_id");
    }
}
