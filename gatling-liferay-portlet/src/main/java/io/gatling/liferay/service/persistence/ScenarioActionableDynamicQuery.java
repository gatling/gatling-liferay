package io.gatling.liferay.service.persistence;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import io.gatling.liferay.model.Scenario;
import io.gatling.liferay.service.ScenarioLocalServiceUtil;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class ScenarioActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public ScenarioActionableDynamicQuery() throws SystemException {
        setBaseLocalService(ScenarioLocalServiceUtil.getService());
        setClass(Scenario.class);

        setClassLoader(io.gatling.liferay.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("scenario_id");
    }
}
