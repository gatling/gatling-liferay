package com.excilys.liferay.gatling.service.persistence;

import com.excilys.liferay.gatling.model.Process;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the process service. This utility wraps {@link ProcessPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProcessPersistence
 * @see ProcessPersistenceImpl
 * @generated
 */
public class ProcessUtil {
    private static ProcessPersistence _persistence;

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
    public static void clearCache(Process process) {
        getPersistence().clearCache(process);
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
    public static List<Process> findWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<Process> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<Process> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static Process update(Process process) throws SystemException {
        return getPersistence().update(process);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static Process update(Process process, ServiceContext serviceContext)
        throws SystemException {
        return getPersistence().update(process, serviceContext);
    }

    /**
    * Returns all the processes where scenario_id = &#63;.
    *
    * @param scenario_id the scenario_id
    * @return the matching processes
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.excilys.liferay.gatling.model.Process> findByScenarioId(
        long scenario_id)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByScenarioId(scenario_id);
    }

    /**
    * Returns a range of all the processes where scenario_id = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.excilys.liferay.gatling.model.impl.ProcessModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param scenario_id the scenario_id
    * @param start the lower bound of the range of processes
    * @param end the upper bound of the range of processes (not inclusive)
    * @return the range of matching processes
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.excilys.liferay.gatling.model.Process> findByScenarioId(
        long scenario_id, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByScenarioId(scenario_id, start, end);
    }

    /**
    * Returns an ordered range of all the processes where scenario_id = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.excilys.liferay.gatling.model.impl.ProcessModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param scenario_id the scenario_id
    * @param start the lower bound of the range of processes
    * @param end the upper bound of the range of processes (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching processes
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.excilys.liferay.gatling.model.Process> findByScenarioId(
        long scenario_id, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByScenarioId(scenario_id, start, end, orderByComparator);
    }

    /**
    * Returns the first process in the ordered set where scenario_id = &#63;.
    *
    * @param scenario_id the scenario_id
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching process
    * @throws com.excilys.liferay.gatling.NoSuchProcessException if a matching process could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.excilys.liferay.gatling.model.Process findByScenarioId_First(
        long scenario_id,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.excilys.liferay.gatling.NoSuchProcessException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByScenarioId_First(scenario_id, orderByComparator);
    }

    /**
    * Returns the first process in the ordered set where scenario_id = &#63;.
    *
    * @param scenario_id the scenario_id
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching process, or <code>null</code> if a matching process could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.excilys.liferay.gatling.model.Process fetchByScenarioId_First(
        long scenario_id,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByScenarioId_First(scenario_id, orderByComparator);
    }

    /**
    * Returns the last process in the ordered set where scenario_id = &#63;.
    *
    * @param scenario_id the scenario_id
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching process
    * @throws com.excilys.liferay.gatling.NoSuchProcessException if a matching process could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.excilys.liferay.gatling.model.Process findByScenarioId_Last(
        long scenario_id,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.excilys.liferay.gatling.NoSuchProcessException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByScenarioId_Last(scenario_id, orderByComparator);
    }

    /**
    * Returns the last process in the ordered set where scenario_id = &#63;.
    *
    * @param scenario_id the scenario_id
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching process, or <code>null</code> if a matching process could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.excilys.liferay.gatling.model.Process fetchByScenarioId_Last(
        long scenario_id,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByScenarioId_Last(scenario_id, orderByComparator);
    }

    /**
    * Returns the processes before and after the current process in the ordered set where scenario_id = &#63;.
    *
    * @param process_id the primary key of the current process
    * @param scenario_id the scenario_id
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next process
    * @throws com.excilys.liferay.gatling.NoSuchProcessException if a process with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.excilys.liferay.gatling.model.Process[] findByScenarioId_PrevAndNext(
        long process_id, long scenario_id,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.excilys.liferay.gatling.NoSuchProcessException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByScenarioId_PrevAndNext(process_id, scenario_id,
            orderByComparator);
    }

    /**
    * Removes all the processes where scenario_id = &#63; from the database.
    *
    * @param scenario_id the scenario_id
    * @throws SystemException if a system exception occurred
    */
    public static void removeByScenarioId(long scenario_id)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByScenarioId(scenario_id);
    }

    /**
    * Returns the number of processes where scenario_id = &#63;.
    *
    * @param scenario_id the scenario_id
    * @return the number of matching processes
    * @throws SystemException if a system exception occurred
    */
    public static int countByScenarioId(long scenario_id)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByScenarioId(scenario_id);
    }

    /**
    * Caches the process in the entity cache if it is enabled.
    *
    * @param process the process
    */
    public static void cacheResult(
        com.excilys.liferay.gatling.model.Process process) {
        getPersistence().cacheResult(process);
    }

    /**
    * Caches the processes in the entity cache if it is enabled.
    *
    * @param processes the processes
    */
    public static void cacheResult(
        java.util.List<com.excilys.liferay.gatling.model.Process> processes) {
        getPersistence().cacheResult(processes);
    }

    /**
    * Creates a new process with the primary key. Does not add the process to the database.
    *
    * @param process_id the primary key for the new process
    * @return the new process
    */
    public static com.excilys.liferay.gatling.model.Process create(
        long process_id) {
        return getPersistence().create(process_id);
    }

    /**
    * Removes the process with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param process_id the primary key of the process
    * @return the process that was removed
    * @throws com.excilys.liferay.gatling.NoSuchProcessException if a process with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.excilys.liferay.gatling.model.Process remove(
        long process_id)
        throws com.excilys.liferay.gatling.NoSuchProcessException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().remove(process_id);
    }

    public static com.excilys.liferay.gatling.model.Process updateImpl(
        com.excilys.liferay.gatling.model.Process process)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(process);
    }

    /**
    * Returns the process with the primary key or throws a {@link com.excilys.liferay.gatling.NoSuchProcessException} if it could not be found.
    *
    * @param process_id the primary key of the process
    * @return the process
    * @throws com.excilys.liferay.gatling.NoSuchProcessException if a process with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.excilys.liferay.gatling.model.Process findByPrimaryKey(
        long process_id)
        throws com.excilys.liferay.gatling.NoSuchProcessException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByPrimaryKey(process_id);
    }

    /**
    * Returns the process with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param process_id the primary key of the process
    * @return the process, or <code>null</code> if a process with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.excilys.liferay.gatling.model.Process fetchByPrimaryKey(
        long process_id)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(process_id);
    }

    /**
    * Returns all the processes.
    *
    * @return the processes
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.excilys.liferay.gatling.model.Process> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
    }

    /**
    * Returns a range of all the processes.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.excilys.liferay.gatling.model.impl.ProcessModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of processes
    * @param end the upper bound of the range of processes (not inclusive)
    * @return the range of processes
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.excilys.liferay.gatling.model.Process> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the processes.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.excilys.liferay.gatling.model.impl.ProcessModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of processes
    * @param end the upper bound of the range of processes (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of processes
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.excilys.liferay.gatling.model.Process> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the processes from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of processes.
    *
    * @return the number of processes
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static ProcessPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (ProcessPersistence) PortletBeanLocatorUtil.locate(com.excilys.liferay.gatling.service.ClpSerializer.getServletContextName(),
                    ProcessPersistence.class.getName());

            ReferenceRegistry.registerReference(ProcessUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(ProcessPersistence persistence) {
    }
}
