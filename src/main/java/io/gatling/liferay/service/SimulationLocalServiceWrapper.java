/**
 * Copyright 2011-2016 GatlingCorp (http://gatling.io)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * 		http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.gatling.liferay.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link SimulationLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see SimulationLocalService
 * @generated
 */
public class SimulationLocalServiceWrapper implements SimulationLocalService,
    ServiceWrapper<SimulationLocalService> {
    private SimulationLocalService _simulationLocalService;

    public SimulationLocalServiceWrapper(
        SimulationLocalService simulationLocalService) {
        _simulationLocalService = simulationLocalService;
    }

    /**
    * Adds the simulation to the database. Also notifies the appropriate model listeners.
    *
    * @param simulation the simulation
    * @return the simulation that was added
    * @throws SystemException if a system exception occurred
    */
    @Override
    public io.gatling.liferay.model.Simulation addSimulation(
        io.gatling.liferay.model.Simulation simulation)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _simulationLocalService.addSimulation(simulation);
    }

    /**
    * Creates a new simulation with the primary key. Does not add the simulation to the database.
    *
    * @param simulation_id the primary key for the new simulation
    * @return the new simulation
    */
    @Override
    public io.gatling.liferay.model.Simulation createSimulation(
        long simulation_id) {
        return _simulationLocalService.createSimulation(simulation_id);
    }

    /**
    * Deletes the simulation with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param simulation_id the primary key of the simulation
    * @return the simulation that was removed
    * @throws PortalException if a simulation with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public io.gatling.liferay.model.Simulation deleteSimulation(
        long simulation_id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _simulationLocalService.deleteSimulation(simulation_id);
    }

    /**
    * Deletes the simulation from the database. Also notifies the appropriate model listeners.
    *
    * @param simulation the simulation
    * @return the simulation that was removed
    * @throws SystemException if a system exception occurred
    */
    @Override
    public io.gatling.liferay.model.Simulation deleteSimulation(
        io.gatling.liferay.model.Simulation simulation)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _simulationLocalService.deleteSimulation(simulation);
    }

    @Override
    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _simulationLocalService.dynamicQuery();
    }

    /**
    * Performs a dynamic query on the database and returns the matching rows.
    *
    * @param dynamicQuery the dynamic query
    * @return the matching rows
    * @throws SystemException if a system exception occurred
    */
    @Override
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _simulationLocalService.dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link io.gatling.liferay.model.impl.SimulationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @return the range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @Override
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return _simulationLocalService.dynamicQuery(dynamicQuery, start, end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link io.gatling.liferay.model.impl.SimulationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @Override
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _simulationLocalService.dynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    @Override
    public long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _simulationLocalService.dynamicQueryCount(dynamicQuery);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @param projection the projection to apply to the query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    @Override
    public long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
        com.liferay.portal.kernel.dao.orm.Projection projection)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _simulationLocalService.dynamicQueryCount(dynamicQuery,
            projection);
    }

    @Override
    public io.gatling.liferay.model.Simulation fetchSimulation(
        long simulation_id)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _simulationLocalService.fetchSimulation(simulation_id);
    }

    /**
    * Returns the simulation with the primary key.
    *
    * @param simulation_id the primary key of the simulation
    * @return the simulation
    * @throws PortalException if a simulation with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public io.gatling.liferay.model.Simulation getSimulation(long simulation_id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _simulationLocalService.getSimulation(simulation_id);
    }

    @Override
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _simulationLocalService.getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the simulations.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link io.gatling.liferay.model.impl.SimulationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of simulations
    * @param end the upper bound of the range of simulations (not inclusive)
    * @return the range of simulations
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.util.List<io.gatling.liferay.model.Simulation> getSimulations(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _simulationLocalService.getSimulations(start, end);
    }

    /**
    * Returns the number of simulations.
    *
    * @return the number of simulations
    * @throws SystemException if a system exception occurred
    */
    @Override
    public int getSimulationsCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _simulationLocalService.getSimulationsCount();
    }

    /**
    * Updates the simulation in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param simulation the simulation
    * @return the simulation that was updated
    * @throws SystemException if a system exception occurred
    */
    @Override
    public io.gatling.liferay.model.Simulation updateSimulation(
        io.gatling.liferay.model.Simulation simulation)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _simulationLocalService.updateSimulation(simulation);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _simulationLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _simulationLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _simulationLocalService.invokeMethod(name, parameterTypes,
            arguments);
    }

    /**
    * Creates the empty default simulation, persists it and returns it.
    *
    * @return The fresh default simulation
    * @throws SystemException If an error occures in services
    */
    @Override
    public io.gatling.liferay.model.Simulation createDefaultSimulation()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _simulationLocalService.createDefaultSimulation();
    }

    @Override
    public io.gatling.liferay.model.Simulation getByName(java.lang.String name)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _simulationLocalService.getByName(name);
    }

    /**
    * Check if name is unique for {@link Simulation}
    */
    @Override
    public boolean isNameUnique(java.lang.String name)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _simulationLocalService.isNameUnique(name);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public SimulationLocalService getWrappedSimulationLocalService() {
        return _simulationLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedSimulationLocalService(
        SimulationLocalService simulationLocalService) {
        _simulationLocalService = simulationLocalService;
    }

    @Override
    public SimulationLocalService getWrappedService() {
        return _simulationLocalService;
    }

    @Override
    public void setWrappedService(SimulationLocalService simulationLocalService) {
        _simulationLocalService = simulationLocalService;
    }
}
