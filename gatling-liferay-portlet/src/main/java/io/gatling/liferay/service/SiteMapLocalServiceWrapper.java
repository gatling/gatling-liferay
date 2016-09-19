package io.gatling.liferay.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link SiteMapLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see SiteMapLocalService
 * @generated
 */
public class SiteMapLocalServiceWrapper implements SiteMapLocalService,
    ServiceWrapper<SiteMapLocalService> {
    private SiteMapLocalService _siteMapLocalService;

    public SiteMapLocalServiceWrapper(SiteMapLocalService siteMapLocalService) {
        _siteMapLocalService = siteMapLocalService;
    }

    /**
    * Adds the site map to the database. Also notifies the appropriate model listeners.
    *
    * @param siteMap the site map
    * @return the site map that was added
    * @throws SystemException if a system exception occurred
    */
    @Override
    public io.gatling.liferay.model.SiteMap addSiteMap(
        io.gatling.liferay.model.SiteMap siteMap)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _siteMapLocalService.addSiteMap(siteMap);
    }

    /**
    * Creates a new site map with the primary key. Does not add the site map to the database.
    *
    * @param siteMapId the primary key for the new site map
    * @return the new site map
    */
    @Override
    public io.gatling.liferay.model.SiteMap createSiteMap(long siteMapId) {
        return _siteMapLocalService.createSiteMap(siteMapId);
    }

    /**
    * Deletes the site map with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param siteMapId the primary key of the site map
    * @return the site map that was removed
    * @throws PortalException if a site map with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public io.gatling.liferay.model.SiteMap deleteSiteMap(long siteMapId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _siteMapLocalService.deleteSiteMap(siteMapId);
    }

    /**
    * Deletes the site map from the database. Also notifies the appropriate model listeners.
    *
    * @param siteMap the site map
    * @return the site map that was removed
    * @throws SystemException if a system exception occurred
    */
    @Override
    public io.gatling.liferay.model.SiteMap deleteSiteMap(
        io.gatling.liferay.model.SiteMap siteMap)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _siteMapLocalService.deleteSiteMap(siteMap);
    }

    @Override
    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _siteMapLocalService.dynamicQuery();
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
        return _siteMapLocalService.dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link io.gatling.liferay.model.impl.SiteMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _siteMapLocalService.dynamicQuery(dynamicQuery, start, end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link io.gatling.liferay.model.impl.SiteMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _siteMapLocalService.dynamicQuery(dynamicQuery, start, end,
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
        return _siteMapLocalService.dynamicQueryCount(dynamicQuery);
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
        return _siteMapLocalService.dynamicQueryCount(dynamicQuery, projection);
    }

    @Override
    public io.gatling.liferay.model.SiteMap fetchSiteMap(long siteMapId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _siteMapLocalService.fetchSiteMap(siteMapId);
    }

    /**
    * Returns the site map with the primary key.
    *
    * @param siteMapId the primary key of the site map
    * @return the site map
    * @throws PortalException if a site map with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public io.gatling.liferay.model.SiteMap getSiteMap(long siteMapId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _siteMapLocalService.getSiteMap(siteMapId);
    }

    @Override
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _siteMapLocalService.getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the site maps.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link io.gatling.liferay.model.impl.SiteMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of site maps
    * @param end the upper bound of the range of site maps (not inclusive)
    * @return the range of site maps
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.util.List<io.gatling.liferay.model.SiteMap> getSiteMaps(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _siteMapLocalService.getSiteMaps(start, end);
    }

    /**
    * Returns the number of site maps.
    *
    * @return the number of site maps
    * @throws SystemException if a system exception occurred
    */
    @Override
    public int getSiteMapsCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _siteMapLocalService.getSiteMapsCount();
    }

    /**
    * Updates the site map in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param siteMap the site map
    * @return the site map that was updated
    * @throws SystemException if a system exception occurred
    */
    @Override
    public io.gatling.liferay.model.SiteMap updateSiteMap(
        io.gatling.liferay.model.SiteMap siteMap)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _siteMapLocalService.updateSiteMap(siteMap);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _siteMapLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _siteMapLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _siteMapLocalService.invokeMethod(name, parameterTypes, arguments);
    }

    @Override
    public io.gatling.liferay.model.SiteMap siteMapCreation(
        com.liferay.portal.theme.ThemeDisplay themeDisplay, long groupId,
        java.lang.String portalUrl)
        throws com.liferay.portal.kernel.exception.SystemException,
            io.gatling.liferay.NoSuchUrlSiteMapException {
        return _siteMapLocalService.siteMapCreation(themeDisplay, groupId,
            portalUrl);
    }

    @Override
    public io.gatling.liferay.model.SiteMap createSiteMap(java.lang.String name)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _siteMapLocalService.createSiteMap(name);
    }

    @Override
    public io.gatling.liferay.model.SiteMap findByProcessId(long processId)
        throws com.liferay.portal.NoSuchModelException,
            com.liferay.portal.kernel.exception.SystemException,
            io.gatling.liferay.NoSuchProcessException {
        return _siteMapLocalService.findByProcessId(processId);
    }

    @Override
    public io.gatling.liferay.model.SiteMap findByName(java.lang.String name)
        throws com.liferay.portal.kernel.exception.SystemException,
            io.gatling.liferay.NoSuchRecordException,
            io.gatling.liferay.NoSuchSiteMapException {
        return _siteMapLocalService.findByName(name);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public SiteMapLocalService getWrappedSiteMapLocalService() {
        return _siteMapLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedSiteMapLocalService(
        SiteMapLocalService siteMapLocalService) {
        _siteMapLocalService = siteMapLocalService;
    }

    @Override
    public SiteMapLocalService getWrappedService() {
        return _siteMapLocalService;
    }

    @Override
    public void setWrappedService(SiteMapLocalService siteMapLocalService) {
        _siteMapLocalService = siteMapLocalService;
    }
}
