package io.gatling.liferay.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for Simulation. This utility wraps
 * {@link io.gatling.liferay.service.impl.SimulationLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see SimulationLocalService
 * @see io.gatling.liferay.service.base.SimulationLocalServiceBaseImpl
 * @see io.gatling.liferay.service.impl.SimulationLocalServiceImpl
 * @generated
 */
public class SimulationLocalServiceUtil {
    private static SimulationLocalService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link io.gatling.liferay.service.impl.SimulationLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */

    /**
    * Adds the simulation to the database. Also notifies the appropriate model listeners.
    *
    * @param simulation the simulation
    * @return the simulation that was added
    * @throws SystemException if a system exception occurred
    */
    public static io.gatling.liferay.model.Simulation addSimulation(
        io.gatling.liferay.model.Simulation simulation)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().addSimulation(simulation);
    }

    /**
    * Creates a new simulation with the primary key. Does not add the simulation to the database.
    *
    * @param simulation_id the primary key for the new simulation
    * @return the new simulation
    */
    public static io.gatling.liferay.model.Simulation createSimulation(
        long simulation_id) {
        return getService().createSimulation(simulation_id);
    }

    /**
    * Deletes the simulation with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param simulation_id the primary key of the simulation
    * @return the simulation that was removed
    * @throws PortalException if a simulation with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static io.gatling.liferay.model.Simulation deleteSimulation(
        long simulation_id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteSimulation(simulation_id);
    }

    /**
    * Deletes the simulation from the database. Also notifies the appropriate model listeners.
    *
    * @param simulation the simulation
    * @return the simulation that was removed
    * @throws SystemException if a system exception occurred
    */
    public static io.gatling.liferay.model.Simulation deleteSimulation(
        io.gatling.liferay.model.Simulation simulation)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteSimulation(simulation);
    }

    public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return getService().dynamicQuery();
    }

    /**
    * Performs a dynamic query on the database and returns the matching rows.
    *
    * @param dynamicQuery the dynamic query
    * @return the matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQuery(dynamicQuery);
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
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQuery(dynamicQuery, start, end);
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
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public static long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQueryCount(dynamicQuery);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @param projection the projection to apply to the query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public static long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
        com.liferay.portal.kernel.dao.orm.Projection projection)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQueryCount(dynamicQuery, projection);
    }

    public static io.gatling.liferay.model.Simulation fetchSimulation(
        long simulation_id)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().fetchSimulation(simulation_id);
    }

    /**
    * Returns the simulation with the primary key.
    *
    * @param simulation_id the primary key of the simulation
    * @return the simulation
    * @throws PortalException if a simulation with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static io.gatling.liferay.model.Simulation getSimulation(
        long simulation_id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getSimulation(simulation_id);
    }

    public static com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getPersistedModel(primaryKeyObj);
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
    public static java.util.List<io.gatling.liferay.model.Simulation> getSimulations(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getSimulations(start, end);
    }

    /**
    * Returns the number of simulations.
    *
    * @return the number of simulations
    * @throws SystemException if a system exception occurred
    */
    public static int getSimulationsCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getSimulationsCount();
    }

    /**
    * Updates the simulation in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param simulation the simulation
    * @return the simulation that was updated
    * @throws SystemException if a system exception occurred
    */
    public static io.gatling.liferay.model.Simulation updateSimulation(
        io.gatling.liferay.model.Simulation simulation)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updateSimulation(simulation);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public static java.lang.String getBeanIdentifier() {
        return getService().getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public static void setBeanIdentifier(java.lang.String beanIdentifier) {
        getService().setBeanIdentifier(beanIdentifier);
    }

    public static java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return getService().invokeMethod(name, parameterTypes, arguments);
    }

    /**
    * Creates the empty default simulation, persists it and returns it.
    *
    * @return The fresh default simulation
    * @throws SystemException If an error occures in services
    */
    public static io.gatling.liferay.model.Simulation createDefaultSimulation()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().createDefaultSimulation();
    }

    /**
    * remove all {@link Scenario} linked to a simulationId and the simulation
    */
    public static void removeSimulationCascade(java.lang.Long simulationId)
        throws com.liferay.portal.NoSuchModelException,
            com.liferay.portal.kernel.exception.SystemException {
        getService().removeSimulationCascade(simulationId);
    }

    public static io.gatling.liferay.model.Simulation getByName(
        java.lang.String name)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getByName(name);
    }

    /**
    * Check if name is unique for {@link Simulation}
    */
    public static boolean isNameUnique(java.lang.String name)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().isNameUnique(name);
    }

    /**
    * Add a {@link Simulation} from an {@link ActionRequest}
    *
    * @param {@link ActionRequest} request
    * @return {@link Simulation} if added, else null
    * @throws SystemException
    */
    public static io.gatling.liferay.model.Simulation addSimulationFromRequest(
        javax.portlet.ActionRequest request)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().addSimulationFromRequest(request);
    }

    public static boolean containsPrivatePage(long simulationId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().containsPrivatePage(simulationId);
    }

    public static void clearService() {
        _service = null;
    }

    public static SimulationLocalService getService() {
        if (_service == null) {
            InvokableLocalService invokableLocalService = (InvokableLocalService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    SimulationLocalService.class.getName());

            if (invokableLocalService instanceof SimulationLocalService) {
                _service = (SimulationLocalService) invokableLocalService;
            } else {
                _service = new SimulationLocalServiceClp(invokableLocalService);
            }

            ReferenceRegistry.registerReference(SimulationLocalServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setService(SimulationLocalService service) {
    }
}
