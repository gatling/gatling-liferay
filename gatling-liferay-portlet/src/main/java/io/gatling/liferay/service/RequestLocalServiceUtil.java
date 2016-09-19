package io.gatling.liferay.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for Request. This utility wraps
 * {@link io.gatling.liferay.service.impl.RequestLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see RequestLocalService
 * @see io.gatling.liferay.service.base.RequestLocalServiceBaseImpl
 * @see io.gatling.liferay.service.impl.RequestLocalServiceImpl
 * @generated
 */
public class RequestLocalServiceUtil {
    private static RequestLocalService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link io.gatling.liferay.service.impl.RequestLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */

    /**
    * Adds the request to the database. Also notifies the appropriate model listeners.
    *
    * @param request the request
    * @return the request that was added
    * @throws SystemException if a system exception occurred
    */
    public static io.gatling.liferay.model.Request addRequest(
        io.gatling.liferay.model.Request request)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().addRequest(request);
    }

    /**
    * Creates a new request with the primary key. Does not add the request to the database.
    *
    * @param request_id the primary key for the new request
    * @return the new request
    */
    public static io.gatling.liferay.model.Request createRequest(
        long request_id) {
        return getService().createRequest(request_id);
    }

    /**
    * Deletes the request with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param request_id the primary key of the request
    * @return the request that was removed
    * @throws PortalException if a request with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static io.gatling.liferay.model.Request deleteRequest(
        long request_id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteRequest(request_id);
    }

    /**
    * Deletes the request from the database. Also notifies the appropriate model listeners.
    *
    * @param request the request
    * @return the request that was removed
    * @throws SystemException if a system exception occurred
    */
    public static io.gatling.liferay.model.Request deleteRequest(
        io.gatling.liferay.model.Request request)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteRequest(request);
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
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link io.gatling.liferay.model.impl.RequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link io.gatling.liferay.model.impl.RequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

    public static io.gatling.liferay.model.Request fetchRequest(long request_id)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().fetchRequest(request_id);
    }

    /**
    * Returns the request with the primary key.
    *
    * @param request_id the primary key of the request
    * @return the request
    * @throws PortalException if a request with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static io.gatling.liferay.model.Request getRequest(long request_id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getRequest(request_id);
    }

    public static com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the requests.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link io.gatling.liferay.model.impl.RequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of requests
    * @param end the upper bound of the range of requests (not inclusive)
    * @return the range of requests
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<io.gatling.liferay.model.Request> getRequests(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getRequests(start, end);
    }

    /**
    * Returns the number of requests.
    *
    * @return the number of requests
    * @throws SystemException if a system exception occurred
    */
    public static int getRequestsCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getRequestsCount();
    }

    /**
    * Updates the request in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param request the request
    * @return the request that was updated
    * @throws SystemException if a system exception occurred
    */
    public static io.gatling.liferay.model.Request updateRequest(
        io.gatling.liferay.model.Request request)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updateRequest(request);
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

    public static java.util.List<io.gatling.liferay.model.Request> findByParentPlid(
        long parentPlid)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().findByParentPlid(parentPlid);
    }

    public static int countByParentPlid(long parentPlid)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().countByParentPlid(parentPlid);
    }

    public static java.util.List<io.gatling.liferay.model.Request> findByParentPlidAndScenario(
        long parentPlid, long scenarioId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().findByParentPlidAndScenario(parentPlid, scenarioId);
    }

    public static int countByParentPlidAndScenario(long parentPlid,
        long scenarioId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().countByParentPlidAndScenario(parentPlid, scenarioId);
    }

    public static java.util.List<io.gatling.liferay.model.Request> findByParentPlidAndScenarioAndPositif(
        long parentPlid, long scenarioId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .findByParentPlidAndScenarioAndPositif(parentPlid, scenarioId);
    }

    public static int countByParentPlidAndScenarioAndPositif(long parentPlid,
        long scenarioId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .countByParentPlidAndScenarioAndPositif(parentPlid,
            scenarioId);
    }

    public static java.util.List<io.gatling.liferay.model.Request> findByScenarioId(
        long scenarioId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().findByScenarioId(scenarioId);
    }

    public static int countByScenarioId(long scenarioId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().countByScenarioId(scenarioId);
    }

    public static java.util.List<io.gatling.liferay.model.Request> findByScenarioIdAndUsed(
        long scenarioId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().findByScenarioIdAndUsed(scenarioId);
    }

    public static int countByScenarioIdAndUsed(long scenarioId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().countByScenarioIdAndUsed(scenarioId);
    }

    public static void removeByScenarioId(long scenarioId)
        throws com.liferay.portal.NoSuchModelException,
            com.liferay.portal.kernel.exception.SystemException {
        getService().removeByScenarioId(scenarioId);
    }

    public static java.util.List<io.gatling.liferay.model.Request> findByScenarioIdAndIsNotPortlet(
        long scenarioId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().findByScenarioIdAndIsNotPortlet(scenarioId);
    }

    public static int countByScenarioIdAndIsNotPortlet(long scenarioId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().countByScenarioIdAndIsNotPortlet(scenarioId);
    }

    public static java.util.List<io.gatling.liferay.model.Request> findByScenarioIdAndUsedAndIsNotPortlet(
        long scenarioId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().findByScenarioIdAndUsedAndIsNotPortlet(scenarioId);
    }

    public static int countByScenarioIdAndUsedAndIsNotPortlet(long scenarioId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().countByScenarioIdAndUsedAndIsNotPortlet(scenarioId);
    }

    /**
    * Store a {@link Request} with given values
    */
    public static void addRequestFromDisplayItem(
        java.lang.Object displayItem1, double weight, long idScenario)
        throws com.liferay.portal.kernel.exception.SystemException {
        getService().addRequestFromDisplayItem(displayItem1, weight, idScenario);
    }

    public static void clearService() {
        _service = null;
    }

    public static RequestLocalService getService() {
        if (_service == null) {
            InvokableLocalService invokableLocalService = (InvokableLocalService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    RequestLocalService.class.getName());

            if (invokableLocalService instanceof RequestLocalService) {
                _service = (RequestLocalService) invokableLocalService;
            } else {
                _service = new RequestLocalServiceClp(invokableLocalService);
            }

            ReferenceRegistry.registerReference(RequestLocalServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setService(RequestLocalService service) {
    }
}
