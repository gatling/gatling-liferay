/**
 * Copyright 2011-2015 GatlingCorp (http://gatling.io)
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
package io.gatling.liferay.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import io.gatling.liferay.model.Scenario;

/**
 * The persistence interface for the scenario service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ScenarioPersistenceImpl
 * @see ScenarioUtil
 * @generated
 */
public interface ScenarioPersistence extends BasePersistence<Scenario> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link ScenarioUtil} to access the scenario persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Returns all the scenarios where simulation_id = &#63;.
    *
    * @param simulation_id the simulation_id
    * @return the matching scenarios
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<io.gatling.liferay.model.Scenario> findBySimulationId(
        long simulation_id)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the scenarios where simulation_id = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link io.gatling.liferay.model.impl.ScenarioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param simulation_id the simulation_id
    * @param start the lower bound of the range of scenarios
    * @param end the upper bound of the range of scenarios (not inclusive)
    * @return the range of matching scenarios
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<io.gatling.liferay.model.Scenario> findBySimulationId(
        long simulation_id, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the scenarios where simulation_id = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link io.gatling.liferay.model.impl.ScenarioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param simulation_id the simulation_id
    * @param start the lower bound of the range of scenarios
    * @param end the upper bound of the range of scenarios (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching scenarios
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<io.gatling.liferay.model.Scenario> findBySimulationId(
        long simulation_id, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first scenario in the ordered set where simulation_id = &#63;.
    *
    * @param simulation_id the simulation_id
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching scenario
    * @throws io.gatling.liferay.NoSuchScenarioException if a matching scenario could not be found
    * @throws SystemException if a system exception occurred
    */
    public io.gatling.liferay.model.Scenario findBySimulationId_First(
        long simulation_id,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            io.gatling.liferay.NoSuchScenarioException;

    /**
    * Returns the first scenario in the ordered set where simulation_id = &#63;.
    *
    * @param simulation_id the simulation_id
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching scenario, or <code>null</code> if a matching scenario could not be found
    * @throws SystemException if a system exception occurred
    */
    public io.gatling.liferay.model.Scenario fetchBySimulationId_First(
        long simulation_id,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last scenario in the ordered set where simulation_id = &#63;.
    *
    * @param simulation_id the simulation_id
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching scenario
    * @throws io.gatling.liferay.NoSuchScenarioException if a matching scenario could not be found
    * @throws SystemException if a system exception occurred
    */
    public io.gatling.liferay.model.Scenario findBySimulationId_Last(
        long simulation_id,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            io.gatling.liferay.NoSuchScenarioException;

    /**
    * Returns the last scenario in the ordered set where simulation_id = &#63;.
    *
    * @param simulation_id the simulation_id
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching scenario, or <code>null</code> if a matching scenario could not be found
    * @throws SystemException if a system exception occurred
    */
    public io.gatling.liferay.model.Scenario fetchBySimulationId_Last(
        long simulation_id,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the scenarios before and after the current scenario in the ordered set where simulation_id = &#63;.
    *
    * @param scenario_id the primary key of the current scenario
    * @param simulation_id the simulation_id
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next scenario
    * @throws io.gatling.liferay.NoSuchScenarioException if a scenario with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public io.gatling.liferay.model.Scenario[] findBySimulationId_PrevAndNext(
        long scenario_id, long simulation_id,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            io.gatling.liferay.NoSuchScenarioException;

    /**
    * Removes all the scenarios where simulation_id = &#63; from the database.
    *
    * @param simulation_id the simulation_id
    * @throws SystemException if a system exception occurred
    */
    public void removeBySimulationId(long simulation_id)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of scenarios where simulation_id = &#63;.
    *
    * @param simulation_id the simulation_id
    * @return the number of matching scenarios
    * @throws SystemException if a system exception occurred
    */
    public int countBySimulationId(long simulation_id)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the scenario where name = &#63; or throws a {@link io.gatling.liferay.NoSuchScenarioException} if it could not be found.
    *
    * @param name the name
    * @return the matching scenario
    * @throws io.gatling.liferay.NoSuchScenarioException if a matching scenario could not be found
    * @throws SystemException if a system exception occurred
    */
    public io.gatling.liferay.model.Scenario findByName(java.lang.String name)
        throws com.liferay.portal.kernel.exception.SystemException,
            io.gatling.liferay.NoSuchScenarioException;

    /**
    * Returns the scenario where name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param name the name
    * @return the matching scenario, or <code>null</code> if a matching scenario could not be found
    * @throws SystemException if a system exception occurred
    */
    public io.gatling.liferay.model.Scenario fetchByName(java.lang.String name)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the scenario where name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param name the name
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching scenario, or <code>null</code> if a matching scenario could not be found
    * @throws SystemException if a system exception occurred
    */
    public io.gatling.liferay.model.Scenario fetchByName(
        java.lang.String name, boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes the scenario where name = &#63; from the database.
    *
    * @param name the name
    * @return the scenario that was removed
    * @throws SystemException if a system exception occurred
    */
    public io.gatling.liferay.model.Scenario removeByName(java.lang.String name)
        throws com.liferay.portal.kernel.exception.SystemException,
            io.gatling.liferay.NoSuchScenarioException;

    /**
    * Returns the number of scenarios where name = &#63;.
    *
    * @param name the name
    * @return the number of matching scenarios
    * @throws SystemException if a system exception occurred
    */
    public int countByName(java.lang.String name)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Caches the scenario in the entity cache if it is enabled.
    *
    * @param scenario the scenario
    */
    public void cacheResult(io.gatling.liferay.model.Scenario scenario);

    /**
    * Caches the scenarios in the entity cache if it is enabled.
    *
    * @param scenarios the scenarios
    */
    public void cacheResult(
        java.util.List<io.gatling.liferay.model.Scenario> scenarios);

    /**
    * Creates a new scenario with the primary key. Does not add the scenario to the database.
    *
    * @param scenario_id the primary key for the new scenario
    * @return the new scenario
    */
    public io.gatling.liferay.model.Scenario create(long scenario_id);

    /**
    * Removes the scenario with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param scenario_id the primary key of the scenario
    * @return the scenario that was removed
    * @throws io.gatling.liferay.NoSuchScenarioException if a scenario with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public io.gatling.liferay.model.Scenario remove(long scenario_id)
        throws com.liferay.portal.kernel.exception.SystemException,
            io.gatling.liferay.NoSuchScenarioException;

    public io.gatling.liferay.model.Scenario updateImpl(
        io.gatling.liferay.model.Scenario scenario)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the scenario with the primary key or throws a {@link io.gatling.liferay.NoSuchScenarioException} if it could not be found.
    *
    * @param scenario_id the primary key of the scenario
    * @return the scenario
    * @throws io.gatling.liferay.NoSuchScenarioException if a scenario with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public io.gatling.liferay.model.Scenario findByPrimaryKey(long scenario_id)
        throws com.liferay.portal.kernel.exception.SystemException,
            io.gatling.liferay.NoSuchScenarioException;

    /**
    * Returns the scenario with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param scenario_id the primary key of the scenario
    * @return the scenario, or <code>null</code> if a scenario with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public io.gatling.liferay.model.Scenario fetchByPrimaryKey(long scenario_id)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the scenarios.
    *
    * @return the scenarios
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<io.gatling.liferay.model.Scenario> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the scenarios.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link io.gatling.liferay.model.impl.ScenarioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of scenarios
    * @param end the upper bound of the range of scenarios (not inclusive)
    * @return the range of scenarios
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<io.gatling.liferay.model.Scenario> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the scenarios.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link io.gatling.liferay.model.impl.ScenarioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of scenarios
    * @param end the upper bound of the range of scenarios (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of scenarios
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<io.gatling.liferay.model.Scenario> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the scenarios from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of scenarios.
    *
    * @return the number of scenarios
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
