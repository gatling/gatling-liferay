package com.excilys.liferay.gatling.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for SiteMap. This utility wraps
 * {@link com.excilys.liferay.gatling.service.impl.SiteMapLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see SiteMapLocalService
 * @see com.excilys.liferay.gatling.service.base.SiteMapLocalServiceBaseImpl
 * @see com.excilys.liferay.gatling.service.impl.SiteMapLocalServiceImpl
 * @generated
 */
public class SiteMapLocalServiceUtil {
    private static SiteMapLocalService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link com.excilys.liferay.gatling.service.impl.SiteMapLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */

    /**
    * Adds the site map to the database. Also notifies the appropriate model listeners.
    *
    * @param siteMap the site map
    * @return the site map that was added
    * @throws SystemException if a system exception occurred
    */
    public static com.excilys.liferay.gatling.model.SiteMap addSiteMap(
        com.excilys.liferay.gatling.model.SiteMap siteMap)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().addSiteMap(siteMap);
    }

    /**
    * Creates a new site map with the primary key. Does not add the site map to the database.
    *
    * @param siteMapId the primary key for the new site map
    * @return the new site map
    */
    public static com.excilys.liferay.gatling.model.SiteMap createSiteMap(
        long siteMapId) {
        return getService().createSiteMap(siteMapId);
    }

    /**
    * Deletes the site map with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param siteMapId the primary key of the site map
    * @return the site map that was removed
    * @throws PortalException if a site map with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.excilys.liferay.gatling.model.SiteMap deleteSiteMap(
        long siteMapId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteSiteMap(siteMapId);
    }

    /**
    * Deletes the site map from the database. Also notifies the appropriate model listeners.
    *
    * @param siteMap the site map
    * @return the site map that was removed
    * @throws SystemException if a system exception occurred
    */
    public static com.excilys.liferay.gatling.model.SiteMap deleteSiteMap(
        com.excilys.liferay.gatling.model.SiteMap siteMap)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteSiteMap(siteMap);
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
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.excilys.liferay.gatling.model.impl.SiteMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.excilys.liferay.gatling.model.impl.SiteMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

    public static com.excilys.liferay.gatling.model.SiteMap fetchSiteMap(
        long siteMapId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().fetchSiteMap(siteMapId);
    }

    /**
    * Returns the site map with the primary key.
    *
    * @param siteMapId the primary key of the site map
    * @return the site map
    * @throws PortalException if a site map with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.excilys.liferay.gatling.model.SiteMap getSiteMap(
        long siteMapId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getSiteMap(siteMapId);
    }

    public static com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the site maps.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.excilys.liferay.gatling.model.impl.SiteMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of site maps
    * @param end the upper bound of the range of site maps (not inclusive)
    * @return the range of site maps
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.excilys.liferay.gatling.model.SiteMap> getSiteMaps(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getSiteMaps(start, end);
    }

    /**
    * Returns the number of site maps.
    *
    * @return the number of site maps
    * @throws SystemException if a system exception occurred
    */
    public static int getSiteMapsCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getSiteMapsCount();
    }

    /**
    * Updates the site map in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param siteMap the site map
    * @return the site map that was updated
    * @throws SystemException if a system exception occurred
    */
    public static com.excilys.liferay.gatling.model.SiteMap updateSiteMap(
        com.excilys.liferay.gatling.model.SiteMap siteMap)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updateSiteMap(siteMap);
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

    public static com.excilys.liferay.gatling.model.SiteMap siteMapCreation(
        com.liferay.portal.theme.ThemeDisplay themeDisplay, long groupId)
        throws com.excilys.liferay.gatling.NoSuchUrlSiteMapException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().siteMapCreation(themeDisplay, groupId);
    }

    public static com.excilys.liferay.gatling.model.SiteMap createSiteMap(
        java.lang.String name)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().createSiteMap(name);
    }

    public static com.excilys.liferay.gatling.model.SiteMap findByProcessId(
        long processId)
        throws com.excilys.liferay.gatling.NoSuchProcessException,
            com.liferay.portal.NoSuchModelException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().findByProcessId(processId);
    }

    public static com.excilys.liferay.gatling.model.SiteMap findByName(
        java.lang.String name)
        throws com.excilys.liferay.gatling.NoSuchRecordException,
            com.excilys.liferay.gatling.NoSuchSiteMapException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().findByName(name);
    }

    public static void clearService() {
        _service = null;
    }

    public static SiteMapLocalService getService() {
        if (_service == null) {
            InvokableLocalService invokableLocalService = (InvokableLocalService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    SiteMapLocalService.class.getName());

            if (invokableLocalService instanceof SiteMapLocalService) {
                _service = (SiteMapLocalService) invokableLocalService;
            } else {
                _service = new SiteMapLocalServiceClp(invokableLocalService);
            }

            ReferenceRegistry.registerReference(SiteMapLocalServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setService(SiteMapLocalService service) {
    }
}
