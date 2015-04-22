package com.excilys.liferay.gatling.service.persistence;

import com.excilys.liferay.gatling.model.Scenario;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the scenario service. This utility wraps {@link ScenarioPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ScenarioPersistence
 * @see ScenarioPersistenceImpl
 * @generated
 */
public class ScenarioUtil {
    private static ScenarioPersistence _persistence;

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
    public static void clearCache(Scenario scenario) {
        getPersistence().clearCache(scenario);
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
    public static List<Scenario> findWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<Scenario> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<Scenario> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static Scenario update(Scenario scenario) throws SystemException {
        return getPersistence().update(scenario);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static Scenario update(Scenario scenario,
        ServiceContext serviceContext) throws SystemException {
        return getPersistence().update(scenario, serviceContext);
    }

    /**
    * Returns all the scenarios where simulation_id = &#63;.
    *
    * @param simulation_id the simulation_id
    * @return the matching scenarios
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.excilys.liferay.gatling.model.Scenario> findBySimulationId(
        long simulation_id)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findBySimulationId(simulation_id);
    }

    /**
    * Returns a range of all the scenarios where simulation_id = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.excilys.liferay.gatling.model.impl.ScenarioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param simulation_id the simulation_id
    * @param start the lower bound of the range of scenarios
    * @param end the upper bound of the range of scenarios (not inclusive)
    * @return the range of matching scenarios
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.excilys.liferay.gatling.model.Scenario> findBySimulationId(
        long simulation_id, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findBySimulationId(simulation_id, start, end);
    }

    /**
    * Returns an ordered range of all the scenarios where simulation_id = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.excilys.liferay.gatling.model.impl.ScenarioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param simulation_id the simulation_id
    * @param start the lower bound of the range of scenarios
    * @param end the upper bound of the range of scenarios (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching scenarios
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.excilys.liferay.gatling.model.Scenario> findBySimulationId(
        long simulation_id, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findBySimulationId(simulation_id, start, end,
            orderByComparator);
    }

    /**
    * Returns the first scenario in the ordered set where simulation_id = &#63;.
    *
    * @param simulation_id the simulation_id
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching scenario
    * @throws com.excilys.liferay.gatling.NoSuchScenarioException if a matching scenario could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.excilys.liferay.gatling.model.Scenario findBySimulationId_First(
        long simulation_id,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.excilys.liferay.gatling.NoSuchScenarioException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findBySimulationId_First(simulation_id, orderByComparator);
    }

    /**
    * Returns the first scenario in the ordered set where simulation_id = &#63;.
    *
    * @param simulation_id the simulation_id
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching scenario, or <code>null</code> if a matching scenario could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.excilys.liferay.gatling.model.Scenario fetchBySimulationId_First(
        long simulation_id,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchBySimulationId_First(simulation_id, orderByComparator);
    }

    /**
    * Returns the last scenario in the ordered set where simulation_id = &#63;.
    *
    * @param simulation_id the simulation_id
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching scenario
    * @throws com.excilys.liferay.gatling.NoSuchScenarioException if a matching scenario could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.excilys.liferay.gatling.model.Scenario findBySimulationId_Last(
        long simulation_id,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.excilys.liferay.gatling.NoSuchScenarioException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findBySimulationId_Last(simulation_id, orderByComparator);
    }

    /**
    * Returns the last scenario in the ordered set where simulation_id = &#63;.
    *
    * @param simulation_id the simulation_id
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching scenario, or <code>null</code> if a matching scenario could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.excilys.liferay.gatling.model.Scenario fetchBySimulationId_Last(
        long simulation_id,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchBySimulationId_Last(simulation_id, orderByComparator);
    }

    /**
    * Returns the scenarios before and after the current scenario in the ordered set where simulation_id = &#63;.
    *
    * @param scenario_id the primary key of the current scenario
    * @param simulation_id the simulation_id
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next scenario
    * @throws com.excilys.liferay.gatling.NoSuchScenarioException if a scenario with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.excilys.liferay.gatling.model.Scenario[] findBySimulationId_PrevAndNext(
        long scenario_id, long simulation_id,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.excilys.liferay.gatling.NoSuchScenarioException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findBySimulationId_PrevAndNext(scenario_id, simulation_id,
            orderByComparator);
    }

    /**
    * Removes all the scenarios where simulation_id = &#63; from the database.
    *
    * @param simulation_id the simulation_id
    * @throws SystemException if a system exception occurred
    */
    public static void removeBySimulationId(long simulation_id)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeBySimulationId(simulation_id);
    }

    /**
    * Returns the number of scenarios where simulation_id = &#63;.
    *
    * @param simulation_id the simulation_id
    * @return the number of matching scenarios
    * @throws SystemException if a system exception occurred
    */
    public static int countBySimulationId(long simulation_id)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countBySimulationId(simulation_id);
    }

    /**
    * Caches the scenario in the entity cache if it is enabled.
    *
    * @param scenario the scenario
    */
    public static void cacheResult(
        com.excilys.liferay.gatling.model.Scenario scenario) {
        getPersistence().cacheResult(scenario);
    }

    /**
    * Caches the scenarios in the entity cache if it is enabled.
    *
    * @param scenarios the scenarios
    */
    public static void cacheResult(
        java.util.List<com.excilys.liferay.gatling.model.Scenario> scenarios) {
        getPersistence().cacheResult(scenarios);
    }

    /**
    * Creates a new scenario with the primary key. Does not add the scenario to the database.
    *
    * @param scenario_id the primary key for the new scenario
    * @return the new scenario
    */
    public static com.excilys.liferay.gatling.model.Scenario create(
        long scenario_id) {
        return getPersistence().create(scenario_id);
    }

    /**
    * Removes the scenario with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param scenario_id the primary key of the scenario
    * @return the scenario that was removed
    * @throws com.excilys.liferay.gatling.NoSuchScenarioException if a scenario with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.excilys.liferay.gatling.model.Scenario remove(
        long scenario_id)
        throws com.excilys.liferay.gatling.NoSuchScenarioException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().remove(scenario_id);
    }

    public static com.excilys.liferay.gatling.model.Scenario updateImpl(
        com.excilys.liferay.gatling.model.Scenario scenario)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(scenario);
    }

    /**
    * Returns the scenario with the primary key or throws a {@link com.excilys.liferay.gatling.NoSuchScenarioException} if it could not be found.
    *
    * @param scenario_id the primary key of the scenario
    * @return the scenario
    * @throws com.excilys.liferay.gatling.NoSuchScenarioException if a scenario with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.excilys.liferay.gatling.model.Scenario findByPrimaryKey(
        long scenario_id)
        throws com.excilys.liferay.gatling.NoSuchScenarioException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByPrimaryKey(scenario_id);
    }

    /**
    * Returns the scenario with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param scenario_id the primary key of the scenario
    * @return the scenario, or <code>null</code> if a scenario with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.excilys.liferay.gatling.model.Scenario fetchByPrimaryKey(
        long scenario_id)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(scenario_id);
    }

    /**
    * Returns all the scenarios.
    *
    * @return the scenarios
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.excilys.liferay.gatling.model.Scenario> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
    }

    /**
    * Returns a range of all the scenarios.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.excilys.liferay.gatling.model.impl.ScenarioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of scenarios
    * @param end the upper bound of the range of scenarios (not inclusive)
    * @return the range of scenarios
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.excilys.liferay.gatling.model.Scenario> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the scenarios.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.excilys.liferay.gatling.model.impl.ScenarioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of scenarios
    * @param end the upper bound of the range of scenarios (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of scenarios
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.excilys.liferay.gatling.model.Scenario> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the scenarios from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of scenarios.
    *
    * @return the number of scenarios
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static ScenarioPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (ScenarioPersistence) PortletBeanLocatorUtil.locate(com.excilys.liferay.gatling.service.ClpSerializer.getServletContextName(),
                    ScenarioPersistence.class.getName());

            ReferenceRegistry.registerReference(ScenarioUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(ScenarioPersistence persistence) {
    }
}
