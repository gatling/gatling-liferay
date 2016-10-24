/**
 * Copyright 2011-2016 GatlingCorp (http://gatling.io)
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
package io.gatling.liferay.service;

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
    public io.gatling.liferay.model.UrlSiteMap addUrlSiteMap(
        io.gatling.liferay.model.UrlSiteMap urlSiteMap)
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
    public io.gatling.liferay.model.UrlSiteMap createUrlSiteMap(
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
    public io.gatling.liferay.model.UrlSiteMap deleteUrlSiteMap(
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
    public io.gatling.liferay.model.UrlSiteMap deleteUrlSiteMap(
        io.gatling.liferay.model.UrlSiteMap urlSiteMap)
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
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link io.gatling.liferay.model.impl.UrlSiteMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link io.gatling.liferay.model.impl.UrlSiteMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
    public io.gatling.liferay.model.UrlSiteMap fetchUrlSiteMap(
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
    public io.gatling.liferay.model.UrlSiteMap getUrlSiteMap(long urlSiteMapId)
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
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link io.gatling.liferay.model.impl.UrlSiteMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of url site maps
    * @param end the upper bound of the range of url site maps (not inclusive)
    * @return the range of url site maps
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.util.List<io.gatling.liferay.model.UrlSiteMap> getUrlSiteMaps(
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
    public io.gatling.liferay.model.UrlSiteMap updateUrlSiteMap(
        io.gatling.liferay.model.UrlSiteMap urlSiteMap)
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
    public io.gatling.liferay.model.UrlSiteMap createUrlSiteMap(
        long siteMapId, java.lang.String friendlyUrl, java.lang.String group,
        java.lang.String url, int weight)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _urlSiteMapLocalService.createUrlSiteMap(siteMapId, friendlyUrl,
            group, url, weight);
    }

    @Override
    public java.util.List<io.gatling.liferay.model.UrlSiteMap> findBySiteMapId(
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
