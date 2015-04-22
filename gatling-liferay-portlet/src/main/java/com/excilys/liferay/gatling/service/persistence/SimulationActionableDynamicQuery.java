package com.excilys.liferay.gatling.service.persistence;

import com.excilys.liferay.gatling.model.Simulation;
import com.excilys.liferay.gatling.service.SimulationLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class SimulationActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public SimulationActionableDynamicQuery() throws SystemException {
        setBaseLocalService(SimulationLocalServiceUtil.getService());
        setClass(Simulation.class);

        setClassLoader(com.excilys.liferay.gatling.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("simulation_id");
    }
}
