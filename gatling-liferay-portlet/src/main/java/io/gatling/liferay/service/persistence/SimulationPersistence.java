package io.gatling.liferay.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import io.gatling.liferay.model.Simulation;

/**
 * The persistence interface for the simulation service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SimulationPersistenceImpl
 * @see SimulationUtil
 * @generated
 */
public interface SimulationPersistence extends BasePersistence<Simulation> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link SimulationUtil} to access the simulation persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Caches the simulation in the entity cache if it is enabled.
    *
    * @param simulation the simulation
    */
    public void cacheResult(io.gatling.liferay.model.Simulation simulation);

    /**
    * Caches the simulations in the entity cache if it is enabled.
    *
    * @param simulations the simulations
    */
    public void cacheResult(
        java.util.List<io.gatling.liferay.model.Simulation> simulations);

    /**
    * Creates a new simulation with the primary key. Does not add the simulation to the database.
    *
    * @param simulation_id the primary key for the new simulation
    * @return the new simulation
    */
    public io.gatling.liferay.model.Simulation create(long simulation_id);

    /**
    * Removes the simulation with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param simulation_id the primary key of the simulation
    * @return the simulation that was removed
    * @throws io.gatling.liferay.NoSuchSimulationException if a simulation with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public io.gatling.liferay.model.Simulation remove(long simulation_id)
        throws com.liferay.portal.kernel.exception.SystemException,
            io.gatling.liferay.NoSuchSimulationException;

    public io.gatling.liferay.model.Simulation updateImpl(
        io.gatling.liferay.model.Simulation simulation)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the simulation with the primary key or throws a {@link io.gatling.liferay.NoSuchSimulationException} if it could not be found.
    *
    * @param simulation_id the primary key of the simulation
    * @return the simulation
    * @throws io.gatling.liferay.NoSuchSimulationException if a simulation with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public io.gatling.liferay.model.Simulation findByPrimaryKey(
        long simulation_id)
        throws com.liferay.portal.kernel.exception.SystemException,
            io.gatling.liferay.NoSuchSimulationException;

    /**
    * Returns the simulation with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param simulation_id the primary key of the simulation
    * @return the simulation, or <code>null</code> if a simulation with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public io.gatling.liferay.model.Simulation fetchByPrimaryKey(
        long simulation_id)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the simulations.
    *
    * @return the simulations
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<io.gatling.liferay.model.Simulation> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<io.gatling.liferay.model.Simulation> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the simulations.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link io.gatling.liferay.model.impl.SimulationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of simulations
    * @param end the upper bound of the range of simulations (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of simulations
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<io.gatling.liferay.model.Simulation> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the simulations from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of simulations.
    *
    * @return the number of simulations
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
