package io.gatling.liferay.service.persistence;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import io.gatling.liferay.model.Simulation;
import io.gatling.liferay.service.SimulationLocalServiceUtil;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class SimulationActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public SimulationActionableDynamicQuery() throws SystemException {
        setBaseLocalService(SimulationLocalServiceUtil.getService());
        setClass(Simulation.class);

        setClassLoader(io.gatling.liferay.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("simulation_id");
    }
}
