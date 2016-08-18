package com.excilys.liferay.gatling.service.persistence;

import com.excilys.liferay.gatling.model.Request;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the request service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RequestPersistenceImpl
 * @see RequestUtil
 * @generated
 */
public interface RequestPersistence extends BasePersistence<Request> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link RequestUtil} to access the request persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Returns all the requests where parentPlId = &#63;.
    *
    * @param parentPlId the parent pl ID
    * @return the matching requests
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.excilys.liferay.gatling.model.Request> findByParentPlid(
        long parentPlId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the requests where parentPlId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.excilys.liferay.gatling.model.impl.RequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param parentPlId the parent pl ID
    * @param start the lower bound of the range of requests
    * @param end the upper bound of the range of requests (not inclusive)
    * @return the range of matching requests
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.excilys.liferay.gatling.model.Request> findByParentPlid(
        long parentPlId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the requests where parentPlId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.excilys.liferay.gatling.model.impl.RequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param parentPlId the parent pl ID
    * @param start the lower bound of the range of requests
    * @param end the upper bound of the range of requests (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching requests
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.excilys.liferay.gatling.model.Request> findByParentPlid(
        long parentPlId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first request in the ordered set where parentPlId = &#63;.
    *
    * @param parentPlId the parent pl ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching request
    * @throws com.excilys.liferay.gatling.NoSuchRequestException if a matching request could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.excilys.liferay.gatling.model.Request findByParentPlid_First(
        long parentPlId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.excilys.liferay.gatling.NoSuchRequestException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first request in the ordered set where parentPlId = &#63;.
    *
    * @param parentPlId the parent pl ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching request, or <code>null</code> if a matching request could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.excilys.liferay.gatling.model.Request fetchByParentPlid_First(
        long parentPlId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last request in the ordered set where parentPlId = &#63;.
    *
    * @param parentPlId the parent pl ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching request
    * @throws com.excilys.liferay.gatling.NoSuchRequestException if a matching request could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.excilys.liferay.gatling.model.Request findByParentPlid_Last(
        long parentPlId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.excilys.liferay.gatling.NoSuchRequestException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last request in the ordered set where parentPlId = &#63;.
    *
    * @param parentPlId the parent pl ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching request, or <code>null</code> if a matching request could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.excilys.liferay.gatling.model.Request fetchByParentPlid_Last(
        long parentPlId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the requests before and after the current request in the ordered set where parentPlId = &#63;.
    *
    * @param request_id the primary key of the current request
    * @param parentPlId the parent pl ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next request
    * @throws com.excilys.liferay.gatling.NoSuchRequestException if a request with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.excilys.liferay.gatling.model.Request[] findByParentPlid_PrevAndNext(
        long request_id, long parentPlId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.excilys.liferay.gatling.NoSuchRequestException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the requests where parentPlId = &#63; from the database.
    *
    * @param parentPlId the parent pl ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByParentPlid(long parentPlId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of requests where parentPlId = &#63;.
    *
    * @param parentPlId the parent pl ID
    * @return the number of matching requests
    * @throws SystemException if a system exception occurred
    */
    public int countByParentPlid(long parentPlId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the requests where parentPlId = &#63; and scenario_id = &#63;.
    *
    * @param parentPlId the parent pl ID
    * @param scenario_id the scenario_id
    * @return the matching requests
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.excilys.liferay.gatling.model.Request> findByParentPlidAndScenario(
        long parentPlId, long scenario_id)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the requests where parentPlId = &#63; and scenario_id = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.excilys.liferay.gatling.model.impl.RequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param parentPlId the parent pl ID
    * @param scenario_id the scenario_id
    * @param start the lower bound of the range of requests
    * @param end the upper bound of the range of requests (not inclusive)
    * @return the range of matching requests
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.excilys.liferay.gatling.model.Request> findByParentPlidAndScenario(
        long parentPlId, long scenario_id, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the requests where parentPlId = &#63; and scenario_id = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.excilys.liferay.gatling.model.impl.RequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param parentPlId the parent pl ID
    * @param scenario_id the scenario_id
    * @param start the lower bound of the range of requests
    * @param end the upper bound of the range of requests (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching requests
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.excilys.liferay.gatling.model.Request> findByParentPlidAndScenario(
        long parentPlId, long scenario_id, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first request in the ordered set where parentPlId = &#63; and scenario_id = &#63;.
    *
    * @param parentPlId the parent pl ID
    * @param scenario_id the scenario_id
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching request
    * @throws com.excilys.liferay.gatling.NoSuchRequestException if a matching request could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.excilys.liferay.gatling.model.Request findByParentPlidAndScenario_First(
        long parentPlId, long scenario_id,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.excilys.liferay.gatling.NoSuchRequestException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first request in the ordered set where parentPlId = &#63; and scenario_id = &#63;.
    *
    * @param parentPlId the parent pl ID
    * @param scenario_id the scenario_id
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching request, or <code>null</code> if a matching request could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.excilys.liferay.gatling.model.Request fetchByParentPlidAndScenario_First(
        long parentPlId, long scenario_id,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last request in the ordered set where parentPlId = &#63; and scenario_id = &#63;.
    *
    * @param parentPlId the parent pl ID
    * @param scenario_id the scenario_id
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching request
    * @throws com.excilys.liferay.gatling.NoSuchRequestException if a matching request could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.excilys.liferay.gatling.model.Request findByParentPlidAndScenario_Last(
        long parentPlId, long scenario_id,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.excilys.liferay.gatling.NoSuchRequestException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last request in the ordered set where parentPlId = &#63; and scenario_id = &#63;.
    *
    * @param parentPlId the parent pl ID
    * @param scenario_id the scenario_id
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching request, or <code>null</code> if a matching request could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.excilys.liferay.gatling.model.Request fetchByParentPlidAndScenario_Last(
        long parentPlId, long scenario_id,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the requests before and after the current request in the ordered set where parentPlId = &#63; and scenario_id = &#63;.
    *
    * @param request_id the primary key of the current request
    * @param parentPlId the parent pl ID
    * @param scenario_id the scenario_id
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next request
    * @throws com.excilys.liferay.gatling.NoSuchRequestException if a request with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.excilys.liferay.gatling.model.Request[] findByParentPlidAndScenario_PrevAndNext(
        long request_id, long parentPlId, long scenario_id,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.excilys.liferay.gatling.NoSuchRequestException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the requests where parentPlId = &#63; and scenario_id = &#63; from the database.
    *
    * @param parentPlId the parent pl ID
    * @param scenario_id the scenario_id
    * @throws SystemException if a system exception occurred
    */
    public void removeByParentPlidAndScenario(long parentPlId, long scenario_id)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of requests where parentPlId = &#63; and scenario_id = &#63;.
    *
    * @param parentPlId the parent pl ID
    * @param scenario_id the scenario_id
    * @return the number of matching requests
    * @throws SystemException if a system exception occurred
    */
    public int countByParentPlidAndScenario(long parentPlId, long scenario_id)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the requests where parentPlId = &#63; and scenario_id = &#63; and weight &ne; &#63;.
    *
    * @param parentPlId the parent pl ID
    * @param scenario_id the scenario_id
    * @param weight the weight
    * @return the matching requests
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.excilys.liferay.gatling.model.Request> findByParentPlidAndScenarioAndPositif(
        long parentPlId, long scenario_id, double weight)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the requests where parentPlId = &#63; and scenario_id = &#63; and weight &ne; &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.excilys.liferay.gatling.model.impl.RequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param parentPlId the parent pl ID
    * @param scenario_id the scenario_id
    * @param weight the weight
    * @param start the lower bound of the range of requests
    * @param end the upper bound of the range of requests (not inclusive)
    * @return the range of matching requests
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.excilys.liferay.gatling.model.Request> findByParentPlidAndScenarioAndPositif(
        long parentPlId, long scenario_id, double weight, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the requests where parentPlId = &#63; and scenario_id = &#63; and weight &ne; &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.excilys.liferay.gatling.model.impl.RequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param parentPlId the parent pl ID
    * @param scenario_id the scenario_id
    * @param weight the weight
    * @param start the lower bound of the range of requests
    * @param end the upper bound of the range of requests (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching requests
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.excilys.liferay.gatling.model.Request> findByParentPlidAndScenarioAndPositif(
        long parentPlId, long scenario_id, double weight, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first request in the ordered set where parentPlId = &#63; and scenario_id = &#63; and weight &ne; &#63;.
    *
    * @param parentPlId the parent pl ID
    * @param scenario_id the scenario_id
    * @param weight the weight
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching request
    * @throws com.excilys.liferay.gatling.NoSuchRequestException if a matching request could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.excilys.liferay.gatling.model.Request findByParentPlidAndScenarioAndPositif_First(
        long parentPlId, long scenario_id, double weight,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.excilys.liferay.gatling.NoSuchRequestException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first request in the ordered set where parentPlId = &#63; and scenario_id = &#63; and weight &ne; &#63;.
    *
    * @param parentPlId the parent pl ID
    * @param scenario_id the scenario_id
    * @param weight the weight
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching request, or <code>null</code> if a matching request could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.excilys.liferay.gatling.model.Request fetchByParentPlidAndScenarioAndPositif_First(
        long parentPlId, long scenario_id, double weight,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last request in the ordered set where parentPlId = &#63; and scenario_id = &#63; and weight &ne; &#63;.
    *
    * @param parentPlId the parent pl ID
    * @param scenario_id the scenario_id
    * @param weight the weight
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching request
    * @throws com.excilys.liferay.gatling.NoSuchRequestException if a matching request could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.excilys.liferay.gatling.model.Request findByParentPlidAndScenarioAndPositif_Last(
        long parentPlId, long scenario_id, double weight,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.excilys.liferay.gatling.NoSuchRequestException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last request in the ordered set where parentPlId = &#63; and scenario_id = &#63; and weight &ne; &#63;.
    *
    * @param parentPlId the parent pl ID
    * @param scenario_id the scenario_id
    * @param weight the weight
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching request, or <code>null</code> if a matching request could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.excilys.liferay.gatling.model.Request fetchByParentPlidAndScenarioAndPositif_Last(
        long parentPlId, long scenario_id, double weight,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the requests before and after the current request in the ordered set where parentPlId = &#63; and scenario_id = &#63; and weight &ne; &#63;.
    *
    * @param request_id the primary key of the current request
    * @param parentPlId the parent pl ID
    * @param scenario_id the scenario_id
    * @param weight the weight
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next request
    * @throws com.excilys.liferay.gatling.NoSuchRequestException if a request with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.excilys.liferay.gatling.model.Request[] findByParentPlidAndScenarioAndPositif_PrevAndNext(
        long request_id, long parentPlId, long scenario_id, double weight,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.excilys.liferay.gatling.NoSuchRequestException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the requests where parentPlId = &#63; and scenario_id = &#63; and weight &ne; &#63; from the database.
    *
    * @param parentPlId the parent pl ID
    * @param scenario_id the scenario_id
    * @param weight the weight
    * @throws SystemException if a system exception occurred
    */
    public void removeByParentPlidAndScenarioAndPositif(long parentPlId,
        long scenario_id, double weight)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of requests where parentPlId = &#63; and scenario_id = &#63; and weight &ne; &#63;.
    *
    * @param parentPlId the parent pl ID
    * @param scenario_id the scenario_id
    * @param weight the weight
    * @return the number of matching requests
    * @throws SystemException if a system exception occurred
    */
    public int countByParentPlidAndScenarioAndPositif(long parentPlId,
        long scenario_id, double weight)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the requests where scenario_id = &#63;.
    *
    * @param scenario_id the scenario_id
    * @return the matching requests
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.excilys.liferay.gatling.model.Request> findByScenarioId(
        long scenario_id)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the requests where scenario_id = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.excilys.liferay.gatling.model.impl.RequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param scenario_id the scenario_id
    * @param start the lower bound of the range of requests
    * @param end the upper bound of the range of requests (not inclusive)
    * @return the range of matching requests
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.excilys.liferay.gatling.model.Request> findByScenarioId(
        long scenario_id, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the requests where scenario_id = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.excilys.liferay.gatling.model.impl.RequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param scenario_id the scenario_id
    * @param start the lower bound of the range of requests
    * @param end the upper bound of the range of requests (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching requests
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.excilys.liferay.gatling.model.Request> findByScenarioId(
        long scenario_id, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first request in the ordered set where scenario_id = &#63;.
    *
    * @param scenario_id the scenario_id
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching request
    * @throws com.excilys.liferay.gatling.NoSuchRequestException if a matching request could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.excilys.liferay.gatling.model.Request findByScenarioId_First(
        long scenario_id,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.excilys.liferay.gatling.NoSuchRequestException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first request in the ordered set where scenario_id = &#63;.
    *
    * @param scenario_id the scenario_id
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching request, or <code>null</code> if a matching request could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.excilys.liferay.gatling.model.Request fetchByScenarioId_First(
        long scenario_id,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last request in the ordered set where scenario_id = &#63;.
    *
    * @param scenario_id the scenario_id
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching request
    * @throws com.excilys.liferay.gatling.NoSuchRequestException if a matching request could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.excilys.liferay.gatling.model.Request findByScenarioId_Last(
        long scenario_id,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.excilys.liferay.gatling.NoSuchRequestException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last request in the ordered set where scenario_id = &#63;.
    *
    * @param scenario_id the scenario_id
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching request, or <code>null</code> if a matching request could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.excilys.liferay.gatling.model.Request fetchByScenarioId_Last(
        long scenario_id,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the requests before and after the current request in the ordered set where scenario_id = &#63;.
    *
    * @param request_id the primary key of the current request
    * @param scenario_id the scenario_id
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next request
    * @throws com.excilys.liferay.gatling.NoSuchRequestException if a request with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.excilys.liferay.gatling.model.Request[] findByScenarioId_PrevAndNext(
        long request_id, long scenario_id,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.excilys.liferay.gatling.NoSuchRequestException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the requests where scenario_id = &#63; from the database.
    *
    * @param scenario_id the scenario_id
    * @throws SystemException if a system exception occurred
    */
    public void removeByScenarioId(long scenario_id)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of requests where scenario_id = &#63;.
    *
    * @param scenario_id the scenario_id
    * @return the number of matching requests
    * @throws SystemException if a system exception occurred
    */
    public int countByScenarioId(long scenario_id)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the requests where scenario_id = &#63; and weight &ne; &#63;.
    *
    * @param scenario_id the scenario_id
    * @param weight the weight
    * @return the matching requests
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.excilys.liferay.gatling.model.Request> findByScenarioIdAndUsed(
        long scenario_id, double weight)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the requests where scenario_id = &#63; and weight &ne; &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.excilys.liferay.gatling.model.impl.RequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param scenario_id the scenario_id
    * @param weight the weight
    * @param start the lower bound of the range of requests
    * @param end the upper bound of the range of requests (not inclusive)
    * @return the range of matching requests
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.excilys.liferay.gatling.model.Request> findByScenarioIdAndUsed(
        long scenario_id, double weight, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the requests where scenario_id = &#63; and weight &ne; &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.excilys.liferay.gatling.model.impl.RequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param scenario_id the scenario_id
    * @param weight the weight
    * @param start the lower bound of the range of requests
    * @param end the upper bound of the range of requests (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching requests
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.excilys.liferay.gatling.model.Request> findByScenarioIdAndUsed(
        long scenario_id, double weight, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first request in the ordered set where scenario_id = &#63; and weight &ne; &#63;.
    *
    * @param scenario_id the scenario_id
    * @param weight the weight
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching request
    * @throws com.excilys.liferay.gatling.NoSuchRequestException if a matching request could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.excilys.liferay.gatling.model.Request findByScenarioIdAndUsed_First(
        long scenario_id, double weight,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.excilys.liferay.gatling.NoSuchRequestException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first request in the ordered set where scenario_id = &#63; and weight &ne; &#63;.
    *
    * @param scenario_id the scenario_id
    * @param weight the weight
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching request, or <code>null</code> if a matching request could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.excilys.liferay.gatling.model.Request fetchByScenarioIdAndUsed_First(
        long scenario_id, double weight,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last request in the ordered set where scenario_id = &#63; and weight &ne; &#63;.
    *
    * @param scenario_id the scenario_id
    * @param weight the weight
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching request
    * @throws com.excilys.liferay.gatling.NoSuchRequestException if a matching request could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.excilys.liferay.gatling.model.Request findByScenarioIdAndUsed_Last(
        long scenario_id, double weight,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.excilys.liferay.gatling.NoSuchRequestException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last request in the ordered set where scenario_id = &#63; and weight &ne; &#63;.
    *
    * @param scenario_id the scenario_id
    * @param weight the weight
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching request, or <code>null</code> if a matching request could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.excilys.liferay.gatling.model.Request fetchByScenarioIdAndUsed_Last(
        long scenario_id, double weight,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the requests before and after the current request in the ordered set where scenario_id = &#63; and weight &ne; &#63;.
    *
    * @param request_id the primary key of the current request
    * @param scenario_id the scenario_id
    * @param weight the weight
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next request
    * @throws com.excilys.liferay.gatling.NoSuchRequestException if a request with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.excilys.liferay.gatling.model.Request[] findByScenarioIdAndUsed_PrevAndNext(
        long request_id, long scenario_id, double weight,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.excilys.liferay.gatling.NoSuchRequestException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the requests where scenario_id = &#63; and weight &ne; &#63; from the database.
    *
    * @param scenario_id the scenario_id
    * @param weight the weight
    * @throws SystemException if a system exception occurred
    */
    public void removeByScenarioIdAndUsed(long scenario_id, double weight)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of requests where scenario_id = &#63; and weight &ne; &#63;.
    *
    * @param scenario_id the scenario_id
    * @param weight the weight
    * @return the number of matching requests
    * @throws SystemException if a system exception occurred
    */
    public int countByScenarioIdAndUsed(long scenario_id, double weight)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the requests where scenario_id = &#63; and portlet = &#63;.
    *
    * @param scenario_id the scenario_id
    * @param portlet the portlet
    * @return the matching requests
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.excilys.liferay.gatling.model.Request> findByScenarioIdAndIsNotPortlet(
        long scenario_id, boolean portlet)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the requests where scenario_id = &#63; and portlet = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.excilys.liferay.gatling.model.impl.RequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param scenario_id the scenario_id
    * @param portlet the portlet
    * @param start the lower bound of the range of requests
    * @param end the upper bound of the range of requests (not inclusive)
    * @return the range of matching requests
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.excilys.liferay.gatling.model.Request> findByScenarioIdAndIsNotPortlet(
        long scenario_id, boolean portlet, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the requests where scenario_id = &#63; and portlet = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.excilys.liferay.gatling.model.impl.RequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param scenario_id the scenario_id
    * @param portlet the portlet
    * @param start the lower bound of the range of requests
    * @param end the upper bound of the range of requests (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching requests
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.excilys.liferay.gatling.model.Request> findByScenarioIdAndIsNotPortlet(
        long scenario_id, boolean portlet, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first request in the ordered set where scenario_id = &#63; and portlet = &#63;.
    *
    * @param scenario_id the scenario_id
    * @param portlet the portlet
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching request
    * @throws com.excilys.liferay.gatling.NoSuchRequestException if a matching request could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.excilys.liferay.gatling.model.Request findByScenarioIdAndIsNotPortlet_First(
        long scenario_id, boolean portlet,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.excilys.liferay.gatling.NoSuchRequestException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first request in the ordered set where scenario_id = &#63; and portlet = &#63;.
    *
    * @param scenario_id the scenario_id
    * @param portlet the portlet
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching request, or <code>null</code> if a matching request could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.excilys.liferay.gatling.model.Request fetchByScenarioIdAndIsNotPortlet_First(
        long scenario_id, boolean portlet,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last request in the ordered set where scenario_id = &#63; and portlet = &#63;.
    *
    * @param scenario_id the scenario_id
    * @param portlet the portlet
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching request
    * @throws com.excilys.liferay.gatling.NoSuchRequestException if a matching request could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.excilys.liferay.gatling.model.Request findByScenarioIdAndIsNotPortlet_Last(
        long scenario_id, boolean portlet,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.excilys.liferay.gatling.NoSuchRequestException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last request in the ordered set where scenario_id = &#63; and portlet = &#63;.
    *
    * @param scenario_id the scenario_id
    * @param portlet the portlet
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching request, or <code>null</code> if a matching request could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.excilys.liferay.gatling.model.Request fetchByScenarioIdAndIsNotPortlet_Last(
        long scenario_id, boolean portlet,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the requests before and after the current request in the ordered set where scenario_id = &#63; and portlet = &#63;.
    *
    * @param request_id the primary key of the current request
    * @param scenario_id the scenario_id
    * @param portlet the portlet
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next request
    * @throws com.excilys.liferay.gatling.NoSuchRequestException if a request with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.excilys.liferay.gatling.model.Request[] findByScenarioIdAndIsNotPortlet_PrevAndNext(
        long request_id, long scenario_id, boolean portlet,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.excilys.liferay.gatling.NoSuchRequestException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the requests where scenario_id = &#63; and portlet = &#63; from the database.
    *
    * @param scenario_id the scenario_id
    * @param portlet the portlet
    * @throws SystemException if a system exception occurred
    */
    public void removeByScenarioIdAndIsNotPortlet(long scenario_id,
        boolean portlet)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of requests where scenario_id = &#63; and portlet = &#63;.
    *
    * @param scenario_id the scenario_id
    * @param portlet the portlet
    * @return the number of matching requests
    * @throws SystemException if a system exception occurred
    */
    public int countByScenarioIdAndIsNotPortlet(long scenario_id,
        boolean portlet)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the requests where scenario_id = &#63; and portlet = &#63; and weight &ne; &#63;.
    *
    * @param scenario_id the scenario_id
    * @param portlet the portlet
    * @param weight the weight
    * @return the matching requests
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.excilys.liferay.gatling.model.Request> findByScenarioIdAndUsedAndIsNotPortlet(
        long scenario_id, boolean portlet, double weight)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the requests where scenario_id = &#63; and portlet = &#63; and weight &ne; &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.excilys.liferay.gatling.model.impl.RequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param scenario_id the scenario_id
    * @param portlet the portlet
    * @param weight the weight
    * @param start the lower bound of the range of requests
    * @param end the upper bound of the range of requests (not inclusive)
    * @return the range of matching requests
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.excilys.liferay.gatling.model.Request> findByScenarioIdAndUsedAndIsNotPortlet(
        long scenario_id, boolean portlet, double weight, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the requests where scenario_id = &#63; and portlet = &#63; and weight &ne; &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.excilys.liferay.gatling.model.impl.RequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param scenario_id the scenario_id
    * @param portlet the portlet
    * @param weight the weight
    * @param start the lower bound of the range of requests
    * @param end the upper bound of the range of requests (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching requests
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.excilys.liferay.gatling.model.Request> findByScenarioIdAndUsedAndIsNotPortlet(
        long scenario_id, boolean portlet, double weight, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first request in the ordered set where scenario_id = &#63; and portlet = &#63; and weight &ne; &#63;.
    *
    * @param scenario_id the scenario_id
    * @param portlet the portlet
    * @param weight the weight
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching request
    * @throws com.excilys.liferay.gatling.NoSuchRequestException if a matching request could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.excilys.liferay.gatling.model.Request findByScenarioIdAndUsedAndIsNotPortlet_First(
        long scenario_id, boolean portlet, double weight,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.excilys.liferay.gatling.NoSuchRequestException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first request in the ordered set where scenario_id = &#63; and portlet = &#63; and weight &ne; &#63;.
    *
    * @param scenario_id the scenario_id
    * @param portlet the portlet
    * @param weight the weight
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching request, or <code>null</code> if a matching request could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.excilys.liferay.gatling.model.Request fetchByScenarioIdAndUsedAndIsNotPortlet_First(
        long scenario_id, boolean portlet, double weight,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last request in the ordered set where scenario_id = &#63; and portlet = &#63; and weight &ne; &#63;.
    *
    * @param scenario_id the scenario_id
    * @param portlet the portlet
    * @param weight the weight
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching request
    * @throws com.excilys.liferay.gatling.NoSuchRequestException if a matching request could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.excilys.liferay.gatling.model.Request findByScenarioIdAndUsedAndIsNotPortlet_Last(
        long scenario_id, boolean portlet, double weight,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.excilys.liferay.gatling.NoSuchRequestException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last request in the ordered set where scenario_id = &#63; and portlet = &#63; and weight &ne; &#63;.
    *
    * @param scenario_id the scenario_id
    * @param portlet the portlet
    * @param weight the weight
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching request, or <code>null</code> if a matching request could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.excilys.liferay.gatling.model.Request fetchByScenarioIdAndUsedAndIsNotPortlet_Last(
        long scenario_id, boolean portlet, double weight,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the requests before and after the current request in the ordered set where scenario_id = &#63; and portlet = &#63; and weight &ne; &#63;.
    *
    * @param request_id the primary key of the current request
    * @param scenario_id the scenario_id
    * @param portlet the portlet
    * @param weight the weight
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next request
    * @throws com.excilys.liferay.gatling.NoSuchRequestException if a request with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.excilys.liferay.gatling.model.Request[] findByScenarioIdAndUsedAndIsNotPortlet_PrevAndNext(
        long request_id, long scenario_id, boolean portlet, double weight,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.excilys.liferay.gatling.NoSuchRequestException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the requests where scenario_id = &#63; and portlet = &#63; and weight &ne; &#63; from the database.
    *
    * @param scenario_id the scenario_id
    * @param portlet the portlet
    * @param weight the weight
    * @throws SystemException if a system exception occurred
    */
    public void removeByScenarioIdAndUsedAndIsNotPortlet(long scenario_id,
        boolean portlet, double weight)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of requests where scenario_id = &#63; and portlet = &#63; and weight &ne; &#63;.
    *
    * @param scenario_id the scenario_id
    * @param portlet the portlet
    * @param weight the weight
    * @return the number of matching requests
    * @throws SystemException if a system exception occurred
    */
    public int countByScenarioIdAndUsedAndIsNotPortlet(long scenario_id,
        boolean portlet, double weight)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the requests where portletId = &#63;.
    *
    * @param portletId the portlet ID
    * @return the matching requests
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.excilys.liferay.gatling.model.Request> findByportletId(
        java.lang.String portletId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the requests where portletId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.excilys.liferay.gatling.model.impl.RequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param portletId the portlet ID
    * @param start the lower bound of the range of requests
    * @param end the upper bound of the range of requests (not inclusive)
    * @return the range of matching requests
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.excilys.liferay.gatling.model.Request> findByportletId(
        java.lang.String portletId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the requests where portletId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.excilys.liferay.gatling.model.impl.RequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param portletId the portlet ID
    * @param start the lower bound of the range of requests
    * @param end the upper bound of the range of requests (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching requests
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.excilys.liferay.gatling.model.Request> findByportletId(
        java.lang.String portletId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first request in the ordered set where portletId = &#63;.
    *
    * @param portletId the portlet ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching request
    * @throws com.excilys.liferay.gatling.NoSuchRequestException if a matching request could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.excilys.liferay.gatling.model.Request findByportletId_First(
        java.lang.String portletId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.excilys.liferay.gatling.NoSuchRequestException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first request in the ordered set where portletId = &#63;.
    *
    * @param portletId the portlet ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching request, or <code>null</code> if a matching request could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.excilys.liferay.gatling.model.Request fetchByportletId_First(
        java.lang.String portletId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last request in the ordered set where portletId = &#63;.
    *
    * @param portletId the portlet ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching request
    * @throws com.excilys.liferay.gatling.NoSuchRequestException if a matching request could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.excilys.liferay.gatling.model.Request findByportletId_Last(
        java.lang.String portletId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.excilys.liferay.gatling.NoSuchRequestException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last request in the ordered set where portletId = &#63;.
    *
    * @param portletId the portlet ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching request, or <code>null</code> if a matching request could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.excilys.liferay.gatling.model.Request fetchByportletId_Last(
        java.lang.String portletId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the requests before and after the current request in the ordered set where portletId = &#63;.
    *
    * @param request_id the primary key of the current request
    * @param portletId the portlet ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next request
    * @throws com.excilys.liferay.gatling.NoSuchRequestException if a request with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.excilys.liferay.gatling.model.Request[] findByportletId_PrevAndNext(
        long request_id, java.lang.String portletId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.excilys.liferay.gatling.NoSuchRequestException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the requests where portletId = &#63; from the database.
    *
    * @param portletId the portlet ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByportletId(java.lang.String portletId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of requests where portletId = &#63;.
    *
    * @param portletId the portlet ID
    * @return the number of matching requests
    * @throws SystemException if a system exception occurred
    */
    public int countByportletId(java.lang.String portletId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Caches the request in the entity cache if it is enabled.
    *
    * @param request the request
    */
    public void cacheResult(com.excilys.liferay.gatling.model.Request request);

    /**
    * Caches the requests in the entity cache if it is enabled.
    *
    * @param requests the requests
    */
    public void cacheResult(
        java.util.List<com.excilys.liferay.gatling.model.Request> requests);

    /**
    * Creates a new request with the primary key. Does not add the request to the database.
    *
    * @param request_id the primary key for the new request
    * @return the new request
    */
    public com.excilys.liferay.gatling.model.Request create(long request_id);

    /**
    * Removes the request with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param request_id the primary key of the request
    * @return the request that was removed
    * @throws com.excilys.liferay.gatling.NoSuchRequestException if a request with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.excilys.liferay.gatling.model.Request remove(long request_id)
        throws com.excilys.liferay.gatling.NoSuchRequestException,
            com.liferay.portal.kernel.exception.SystemException;

    public com.excilys.liferay.gatling.model.Request updateImpl(
        com.excilys.liferay.gatling.model.Request request)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the request with the primary key or throws a {@link com.excilys.liferay.gatling.NoSuchRequestException} if it could not be found.
    *
    * @param request_id the primary key of the request
    * @return the request
    * @throws com.excilys.liferay.gatling.NoSuchRequestException if a request with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.excilys.liferay.gatling.model.Request findByPrimaryKey(
        long request_id)
        throws com.excilys.liferay.gatling.NoSuchRequestException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the request with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param request_id the primary key of the request
    * @return the request, or <code>null</code> if a request with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.excilys.liferay.gatling.model.Request fetchByPrimaryKey(
        long request_id)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the requests.
    *
    * @return the requests
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.excilys.liferay.gatling.model.Request> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the requests.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.excilys.liferay.gatling.model.impl.RequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of requests
    * @param end the upper bound of the range of requests (not inclusive)
    * @return the range of requests
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.excilys.liferay.gatling.model.Request> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the requests.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.excilys.liferay.gatling.model.impl.RequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of requests
    * @param end the upper bound of the range of requests (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of requests
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.excilys.liferay.gatling.model.Request> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the requests from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of requests.
    *
    * @return the number of requests
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
