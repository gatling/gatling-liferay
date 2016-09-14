package com.excilys.liferay.gatling.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link UrlSiteMapLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see UrlSiteMapLocalService
 * @generated
 */
public class UrlSiteMapLocalServiceWrapper implements UrlSiteMapLocalService,
    ServiceWrapper<UrlSiteMapLocalService> {
    private UrlSiteMapLocalService _urlSiteMapLocalService;

    public UrlSiteMapLocalServiceWrapper(
        UrlSiteMapLocalService urlSiteMapLocalService) {
        _urlSiteMapLocalService = urlSiteMapLocalService;
    }

    /**
    * Adds the url site map to the database. Also notifies the appropriate model listeners.
    *
    * @param urlSiteMap the url site map
    * @return the url site map that was added
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.excilys.liferay.gatling.model.UrlSiteMap addUrlSiteMap(
        com.excilys.liferay.gatling.model.UrlSiteMap urlSiteMap)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _urlSiteMapLocalService.addUrlSiteMap(urlSiteMap);
    }

    /**
    * Creates a new url site map with the primary key. Does not add the url site map to the database.
    *
    * @param urlSiteMapId the primary key for the new url site map
    * @return the new url site map
    */
    @Override
    public com.excilys.liferay.gatling.model.UrlSiteMap createUrlSiteMap(
        long urlSiteMapId) {
        return _urlSiteMapLocalService.createUrlSiteMap(urlSiteMapId);
    }

    /**
    * Deletes the url site map with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param urlSiteMapId the primary key of the url site map
    * @return the url site map that was removed
    * @throws PortalException if a url site map with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.excilys.liferay.gatling.model.UrlSiteMap deleteUrlSiteMap(
        long urlSiteMapId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _urlSiteMapLocalService.deleteUrlSiteMap(urlSiteMapId);
    }

    /**
    * Deletes the url site map from the database. Also notifies the appropriate model listeners.
    *
    * @param urlSiteMap the url site map
    * @return the url site map that was removed
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.excilys.liferay.gatling.model.UrlSiteMap deleteUrlSiteMap(
        com.excilys.liferay.gatling.model.UrlSiteMap urlSiteMap)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _urlSiteMapLocalService.deleteUrlSiteMap(urlSiteMap);
    }

    @Override
    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _urlSiteMapLocalService.dynamicQuery();
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
        return _urlSiteMapLocalService.dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.excilys.liferay.gatling.model.impl.UrlSiteMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _urlSiteMapLocalService.dynamicQuery(dynamicQuery, start, end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.excilys.liferay.gatling.model.impl.UrlSiteMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _urlSiteMapLocalService.dynamicQuery(dynamicQuery, start, end,
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
        return _urlSiteMapLocalService.dynamicQueryCount(dynamicQuery);
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
        return _urlSiteMapLocalService.dynamicQueryCount(dynamicQuery,
            projection);
    }

    @Override
    public com.excilys.liferay.gatling.model.UrlSiteMap fetchUrlSiteMap(
        long urlSiteMapId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _urlSiteMapLocalService.fetchUrlSiteMap(urlSiteMapId);
    }

    /**
    * Returns the url site map with the primary key.
    *
    * @param urlSiteMapId the primary key of the url site map
    * @return the url site map
    * @throws PortalException if a url site map with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.excilys.liferay.gatling.model.UrlSiteMap getUrlSiteMap(
        long urlSiteMapId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _urlSiteMapLocalService.getUrlSiteMap(urlSiteMapId);
    }

    @Override
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _urlSiteMapLocalService.getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the url site maps.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.excilys.liferay.gatling.model.impl.UrlSiteMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of url site maps
    * @param end the upper bound of the range of url site maps (not inclusive)
    * @return the range of url site maps
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.util.List<com.excilys.liferay.gatling.model.UrlSiteMap> getUrlSiteMaps(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _urlSiteMapLocalService.getUrlSiteMaps(start, end);
    }

    /**
    * Returns the number of url site maps.
    *
    * @return the number of url site maps
    * @throws SystemException if a system exception occurred
    */
    @Override
    public int getUrlSiteMapsCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _urlSiteMapLocalService.getUrlSiteMapsCount();
    }

    /**
    * Updates the url site map in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param urlSiteMap the url site map
    * @return the url site map that was updated
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.excilys.liferay.gatling.model.UrlSiteMap updateUrlSiteMap(
        com.excilys.liferay.gatling.model.UrlSiteMap urlSiteMap)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _urlSiteMapLocalService.updateUrlSiteMap(urlSiteMap);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _urlSiteMapLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _urlSiteMapLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _urlSiteMapLocalService.invokeMethod(name, parameterTypes,
            arguments);
    }

    @Override
    public com.excilys.liferay.gatling.model.UrlSiteMap createUrlSiteMap(
        long siteMapId, java.lang.String friendlyUrl, java.lang.String url,
        int weight) throws com.liferay.portal.kernel.exception.SystemException {
        return _urlSiteMapLocalService.createUrlSiteMap(siteMapId, friendlyUrl,
            url, weight);
    }

    @Override
    public java.util.List<com.excilys.liferay.gatling.model.UrlSiteMap> findBySiteMapId(
        long siteMapId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _urlSiteMapLocalService.findBySiteMapId(siteMapId);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public UrlSiteMapLocalService getWrappedUrlSiteMapLocalService() {
        return _urlSiteMapLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedUrlSiteMapLocalService(
        UrlSiteMapLocalService urlSiteMapLocalService) {
        _urlSiteMapLocalService = urlSiteMapLocalService;
    }

    @Override
    public UrlSiteMapLocalService getWrappedService() {
        return _urlSiteMapLocalService;
    }

    @Override
    public void setWrappedService(UrlSiteMapLocalService urlSiteMapLocalService) {
        _urlSiteMapLocalService = urlSiteMapLocalService;
    }
}
