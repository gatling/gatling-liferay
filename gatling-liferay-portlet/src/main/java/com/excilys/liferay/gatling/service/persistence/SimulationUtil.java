package com.excilys.liferay.gatling.service.persistence;

import com.excilys.liferay.gatling.model.Simulation;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the simulation service. This utility wraps {@link SimulationPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SimulationPersistence
 * @see SimulationPersistenceImpl
 * @generated
 */
public class SimulationUtil {
    private static SimulationPersistence _persistence;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
     */
    public static void clearCache() {
        getPersistence().clearCache();
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
     */
    public static void clearCache(Simulation simulation) {
        getPersistence().clearCache(simulation);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
     */
    public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().countWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
     */
    public static List<Simulation> findWithDynamicQuery(
        DynamicQuery dynamicQuery) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<Simulation> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<Simulation> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static Simulation update(Simulation simulation)
        throws SystemException {
        return getPersistence().update(simulation);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static Simulation update(Simulation simulation,
        ServiceContext serviceContext) throws SystemException {
        return getPersistence().update(simulation, serviceContext);
    }

    /**
    * Caches the simulation in the entity cache if it is enabled.
    *
    * @param simulation the simulation
    */
    public static void cacheResult(
        com.excilys.liferay.gatling.model.Simulation simulation) {
        getPersistence().cacheResult(simulation);
    }

    /**
    * Caches the simulations in the entity cache if it is enabled.
    *
    * @param simulations the simulations
    */
    public static void cacheResult(
        java.util.List<com.excilys.liferay.gatling.model.Simulation> simulations) {
        getPersistence().cacheResult(simulations);
    }

    /**
    * Creates a new simulation with the primary key. Does not add the simulation to the database.
    *
    * @param simulation_id the primary key for the new simulation
    * @return the new simulation
    */
    public static com.excilys.liferay.gatling.model.Simulation create(
        long simulation_id) {
        return getPersistence().create(simulation_id);
    }

    /**
    * Removes the simulation with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param simulation_id the primary key of the simulation
    * @return the simulation that was removed
    * @throws com.excilys.liferay.gatling.NoSuchSimulationException if a simulation with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.excilys.liferay.gatling.model.Simulation remove(
        long simulation_id)
        throws com.excilys.liferay.gatling.NoSuchSimulationException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().remove(simulation_id);
    }

    public static com.excilys.liferay.gatling.model.Simulation updateImpl(
        com.excilys.liferay.gatling.model.Simulation simulation)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(simulation);
    }

    /**
    * Returns the simulation with the primary key or throws a {@link com.excilys.liferay.gatling.NoSuchSimulationException} if it could not be found.
    *
    * @param simulation_id the primary key of the simulation
    * @return the simulation
    * @throws com.excilys.liferay.gatling.NoSuchSimulationException if a simulation with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.excilys.liferay.gatling.model.Simulation findByPrimaryKey(
        long simulation_id)
        throws com.excilys.liferay.gatling.NoSuchSimulationException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByPrimaryKey(simulation_id);
    }

    /**
    * Returns the simulation with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param simulation_id the primary key of the simulation
    * @return the simulation, or <code>null</code> if a simulation with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.excilys.liferay.gatling.model.Simulation fetchByPrimaryKey(
        long simulation_id)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(simulation_id);
    }

    /**
    * Returns all the simulations.
    *
    * @return the simulations
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.excilys.liferay.gatling.model.Simulation> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
    }

    /**
    * Returns a range of all the simulations.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.excilys.liferay.gatling.model.impl.SimulationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of simulations
    * @param end the upper bound of the range of simulations (not inclusive)
    * @return the range of simulations
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.excilys.liferay.gatling.model.Simulation> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the simulations.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.excilys.liferay.gatling.model.impl.SimulationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of simulations
    * @param end the upper bound of the range of simulations (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of simulations
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.excilys.liferay.gatling.model.Simulation> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the simulations from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of simulations.
    *
    * @return the number of simulations
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static SimulationPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (SimulationPersistence) PortletBeanLocatorUtil.locate(com.excilys.liferay.gatling.service.ClpSerializer.getServletContextName(),
                    SimulationPersistence.class.getName());

            ReferenceRegistry.registerReference(SimulationUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(SimulationPersistence persistence) {
    }
}
