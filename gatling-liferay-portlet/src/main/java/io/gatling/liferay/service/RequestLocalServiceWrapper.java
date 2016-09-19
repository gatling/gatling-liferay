package io.gatling.liferay.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link RequestLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see RequestLocalService
 * @generated
 */
public class RequestLocalServiceWrapper implements RequestLocalService,
    ServiceWrapper<RequestLocalService> {
    private RequestLocalService _requestLocalService;

    public RequestLocalServiceWrapper(RequestLocalService requestLocalService) {
        _requestLocalService = requestLocalService;
    }

    /**
    * Adds the request to the database. Also notifies the appropriate model listeners.
    *
    * @param request the request
    * @return the request that was added
    * @throws SystemException if a system exception occurred
    */
    @Override
    public io.gatling.liferay.model.Request addRequest(
        io.gatling.liferay.model.Request request)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _requestLocalService.addRequest(request);
    }

    /**
    * Creates a new request with the primary key. Does not add the request to the database.
    *
    * @param request_id the primary key for the new request
    * @return the new request
    */
    @Override
    public io.gatling.liferay.model.Request createRequest(long request_id) {
        return _requestLocalService.createRequest(request_id);
    }

    /**
    * Deletes the request with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param request_id the primary key of the request
    * @return the request that was removed
    * @throws PortalException if a request with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public io.gatling.liferay.model.Request deleteRequest(long request_id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _requestLocalService.deleteRequest(request_id);
    }

    /**
    * Deletes the request from the database. Also notifies the appropriate model listeners.
    *
    * @param request the request
    * @return the request that was removed
    * @throws SystemException if a system exception occurred
    */
    @Override
    public io.gatling.liferay.model.Request deleteRequest(
        io.gatling.liferay.model.Request request)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _requestLocalService.deleteRequest(request);
    }

    @Override
    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _requestLocalService.dynamicQuery();
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
        return _requestLocalService.dynamicQuery(dynamicQuery);
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
    @Override
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return _requestLocalService.dynamicQuery(dynamicQuery, start, end);
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
    @Override
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _requestLocalService.dynamicQuery(dynamicQuery, start, end,
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
        return _requestLocalService.dynamicQueryCount(dynamicQuery);
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
        return _requestLocalService.dynamicQueryCount(dynamicQuery, projection);
    }

    @Override
    public io.gatling.liferay.model.Request fetchRequest(long request_id)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _requestLocalService.fetchRequest(request_id);
    }

    /**
    * Returns the request with the primary key.
    *
    * @param request_id the primary key of the request
    * @return the request
    * @throws PortalException if a request with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public io.gatling.liferay.model.Request getRequest(long request_id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _requestLocalService.getRequest(request_id);
    }

    @Override
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _requestLocalService.getPersistedModel(primaryKeyObj);
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
    @Override
    public java.util.List<io.gatling.liferay.model.Request> getRequests(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _requestLocalService.getRequests(start, end);
    }

    /**
    * Returns the number of requests.
    *
    * @return the number of requests
    * @throws SystemException if a system exception occurred
    */
    @Override
    public int getRequestsCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _requestLocalService.getRequestsCount();
    }

    /**
    * Updates the request in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param request the request
    * @return the request that was updated
    * @throws SystemException if a system exception occurred
    */
    @Override
    public io.gatling.liferay.model.Request updateRequest(
        io.gatling.liferay.model.Request request)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _requestLocalService.updateRequest(request);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _requestLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _requestLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _requestLocalService.invokeMethod(name, parameterTypes, arguments);
    }

    @Override
    public java.util.List<io.gatling.liferay.model.Request> findByParentPlid(
        long parentPlid)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _requestLocalService.findByParentPlid(parentPlid);
    }

    @Override
    public int countByParentPlid(long parentPlid)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _requestLocalService.countByParentPlid(parentPlid);
    }

    @Override
    public java.util.List<io.gatling.liferay.model.Request> findByParentPlidAndScenario(
        long parentPlid, long scenarioId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _requestLocalService.findByParentPlidAndScenario(parentPlid,
            scenarioId);
    }

    @Override
    public int countByParentPlidAndScenario(long parentPlid, long scenarioId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _requestLocalService.countByParentPlidAndScenario(parentPlid,
            scenarioId);
    }

    @Override
    public java.util.List<io.gatling.liferay.model.Request> findByParentPlidAndScenarioAndPositif(
        long parentPlid, long scenarioId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _requestLocalService.findByParentPlidAndScenarioAndPositif(parentPlid,
            scenarioId);
    }

    @Override
    public int countByParentPlidAndScenarioAndPositif(long parentPlid,
        long scenarioId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _requestLocalService.countByParentPlidAndScenarioAndPositif(parentPlid,
            scenarioId);
    }

    @Override
    public java.util.List<io.gatling.liferay.model.Request> findByScenarioId(
        long scenarioId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _requestLocalService.findByScenarioId(scenarioId);
    }

    @Override
    public int countByScenarioId(long scenarioId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _requestLocalService.countByScenarioId(scenarioId);
    }

    @Override
    public java.util.List<io.gatling.liferay.model.Request> findByScenarioIdAndUsed(
        long scenarioId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _requestLocalService.findByScenarioIdAndUsed(scenarioId);
    }

    @Override
    public int countByScenarioIdAndUsed(long scenarioId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _requestLocalService.countByScenarioIdAndUsed(scenarioId);
    }

    @Override
    public void removeByScenarioId(long scenarioId)
        throws com.liferay.portal.NoSuchModelException,
            com.liferay.portal.kernel.exception.SystemException {
        _requestLocalService.removeByScenarioId(scenarioId);
    }

    @Override
    public java.util.List<io.gatling.liferay.model.Request> findByScenarioIdAndIsNotPortlet(
        long scenarioId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _requestLocalService.findByScenarioIdAndIsNotPortlet(scenarioId);
    }

    @Override
    public int countByScenarioIdAndIsNotPortlet(long scenarioId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _requestLocalService.countByScenarioIdAndIsNotPortlet(scenarioId);
    }

    @Override
    public java.util.List<io.gatling.liferay.model.Request> findByScenarioIdAndUsedAndIsNotPortlet(
        long scenarioId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _requestLocalService.findByScenarioIdAndUsedAndIsNotPortlet(scenarioId);
    }

    @Override
    public int countByScenarioIdAndUsedAndIsNotPortlet(long scenarioId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _requestLocalService.countByScenarioIdAndUsedAndIsNotPortlet(scenarioId);
    }

    /**
    * Store a {@link Request} with given values
    */
    @Override
    public void addRequestFromDisplayItem(java.lang.Object displayItem1,
        double weight, long idScenario)
        throws com.liferay.portal.kernel.exception.SystemException {
        _requestLocalService.addRequestFromDisplayItem(displayItem1, weight,
            idScenario);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public RequestLocalService getWrappedRequestLocalService() {
        return _requestLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedRequestLocalService(
        RequestLocalService requestLocalService) {
        _requestLocalService = requestLocalService;
    }

    @Override
    public RequestLocalService getWrappedService() {
        return _requestLocalService;
    }

    @Override
    public void setWrappedService(RequestLocalService requestLocalService) {
        _requestLocalService = requestLocalService;
    }
}
