package com.excilys.liferay.gatling.service.persistence;

import com.excilys.liferay.gatling.model.Process;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the process service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProcessPersistenceImpl
 * @see ProcessUtil
 * @generated
 */
public interface ProcessPersistence extends BasePersistence<Process> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link ProcessUtil} to access the process persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Returns all the processes where scenario_id = &#63;.
    *
    * @param scenario_id the scenario_id
    * @return the matching processes
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.excilys.liferay.gatling.model.Process> findByScenarioId(
        long scenario_id)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.excilys.liferay.gatling.model.Process> findByScenarioId(
        long scenario_id, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.excilys.liferay.gatling.model.Process> findByScenarioId(
        long scenario_id, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first process in the ordered set where scenario_id = &#63;.
    *
    * @param scenario_id the scenario_id
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching process
    * @throws com.excilys.liferay.gatling.NoSuchProcessException if a matching process could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.excilys.liferay.gatling.model.Process findByScenarioId_First(
        long scenario_id,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.excilys.liferay.gatling.NoSuchProcessException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first process in the ordered set where scenario_id = &#63;.
    *
    * @param scenario_id the scenario_id
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching process, or <code>null</code> if a matching process could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.excilys.liferay.gatling.model.Process fetchByScenarioId_First(
        long scenario_id,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last process in the ordered set where scenario_id = &#63;.
    *
    * @param scenario_id the scenario_id
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching process
    * @throws com.excilys.liferay.gatling.NoSuchProcessException if a matching process could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.excilys.liferay.gatling.model.Process findByScenarioId_Last(
        long scenario_id,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.excilys.liferay.gatling.NoSuchProcessException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last process in the ordered set where scenario_id = &#63;.
    *
    * @param scenario_id the scenario_id
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching process, or <code>null</code> if a matching process could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.excilys.liferay.gatling.model.Process fetchByScenarioId_Last(
        long scenario_id,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.excilys.liferay.gatling.model.Process[] findByScenarioId_PrevAndNext(
        long process_id, long scenario_id,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.excilys.liferay.gatling.NoSuchProcessException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the processes where scenario_id = &#63; from the database.
    *
    * @param scenario_id the scenario_id
    * @throws SystemException if a system exception occurred
    */
    public void removeByScenarioId(long scenario_id)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of processes where scenario_id = &#63;.
    *
    * @param scenario_id the scenario_id
    * @return the number of matching processes
    * @throws SystemException if a system exception occurred
    */
    public int countByScenarioId(long scenario_id)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Caches the process in the entity cache if it is enabled.
    *
    * @param process the process
    */
    public void cacheResult(com.excilys.liferay.gatling.model.Process process);

    /**
    * Caches the processes in the entity cache if it is enabled.
    *
    * @param processes the processes
    */
    public void cacheResult(
        java.util.List<com.excilys.liferay.gatling.model.Process> processes);

    /**
    * Creates a new process with the primary key. Does not add the process to the database.
    *
    * @param process_id the primary key for the new process
    * @return the new process
    */
    public com.excilys.liferay.gatling.model.Process create(long process_id);

    /**
    * Removes the process with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param process_id the primary key of the process
    * @return the process that was removed
    * @throws com.excilys.liferay.gatling.NoSuchProcessException if a process with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.excilys.liferay.gatling.model.Process remove(long process_id)
        throws com.excilys.liferay.gatling.NoSuchProcessException,
            com.liferay.portal.kernel.exception.SystemException;

    public com.excilys.liferay.gatling.model.Process updateImpl(
        com.excilys.liferay.gatling.model.Process process)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the process with the primary key or throws a {@link com.excilys.liferay.gatling.NoSuchProcessException} if it could not be found.
    *
    * @param process_id the primary key of the process
    * @return the process
    * @throws com.excilys.liferay.gatling.NoSuchProcessException if a process with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.excilys.liferay.gatling.model.Process findByPrimaryKey(
        long process_id)
        throws com.excilys.liferay.gatling.NoSuchProcessException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the process with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param process_id the primary key of the process
    * @return the process, or <code>null</code> if a process with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.excilys.liferay.gatling.model.Process fetchByPrimaryKey(
        long process_id)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the processes.
    *
    * @return the processes
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.excilys.liferay.gatling.model.Process> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.excilys.liferay.gatling.model.Process> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.excilys.liferay.gatling.model.Process> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the processes from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of processes.
    *
    * @return the number of processes
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
