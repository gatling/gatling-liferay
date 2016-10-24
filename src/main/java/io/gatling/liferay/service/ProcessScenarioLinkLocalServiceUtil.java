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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for ProcessScenarioLink. This utility wraps
 * {@link io.gatling.liferay.service.impl.ProcessScenarioLinkLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see ProcessScenarioLinkLocalService
 * @see io.gatling.liferay.service.base.ProcessScenarioLinkLocalServiceBaseImpl
 * @see io.gatling.liferay.service.impl.ProcessScenarioLinkLocalServiceImpl
 * @generated
 */
public class ProcessScenarioLinkLocalServiceUtil {
    private static ProcessScenarioLinkLocalService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link io.gatling.liferay.service.impl.ProcessScenarioLinkLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */

    /**
    * Adds the process scenario link to the database. Also notifies the appropriate model listeners.
    *
    * @param processScenarioLink the process scenario link
    * @return the process scenario link that was added
    * @throws SystemException if a system exception occurred
    */
    public static io.gatling.liferay.model.ProcessScenarioLink addProcessScenarioLink(
        io.gatling.liferay.model.ProcessScenarioLink processScenarioLink)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().addProcessScenarioLink(processScenarioLink);
    }

    /**
    * Creates a new process scenario link with the primary key. Does not add the process scenario link to the database.
    *
    * @param psl_id the primary key for the new process scenario link
    * @return the new process scenario link
    */
    public static io.gatling.liferay.model.ProcessScenarioLink createProcessScenarioLink(
        long psl_id) {
        return getService().createProcessScenarioLink(psl_id);
    }

    /**
    * Deletes the process scenario link with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param psl_id the primary key of the process scenario link
    * @return the process scenario link that was removed
    * @throws PortalException if a process scenario link with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static io.gatling.liferay.model.ProcessScenarioLink deleteProcessScenarioLink(
        long psl_id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteProcessScenarioLink(psl_id);
    }

    /**
    * Deletes the process scenario link from the database. Also notifies the appropriate model listeners.
    *
    * @param processScenarioLink the process scenario link
    * @return the process scenario link that was removed
    * @throws SystemException if a system exception occurred
    */
    public static io.gatling.liferay.model.ProcessScenarioLink deleteProcessScenarioLink(
        io.gatling.liferay.model.ProcessScenarioLink processScenarioLink)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteProcessScenarioLink(processScenarioLink);
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
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link io.gatling.liferay.model.impl.ProcessScenarioLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link io.gatling.liferay.model.impl.ProcessScenarioLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

    public static io.gatling.liferay.model.ProcessScenarioLink fetchProcessScenarioLink(
        long psl_id) throws com.liferay.portal.kernel.exception.SystemException {
        return getService().fetchProcessScenarioLink(psl_id);
    }

    /**
    * Returns the process scenario link with the primary key.
    *
    * @param psl_id the primary key of the process scenario link
    * @return the process scenario link
    * @throws PortalException if a process scenario link with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static io.gatling.liferay.model.ProcessScenarioLink getProcessScenarioLink(
        long psl_id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getProcessScenarioLink(psl_id);
    }

    public static com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the process scenario links.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link io.gatling.liferay.model.impl.ProcessScenarioLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of process scenario links
    * @param end the upper bound of the range of process scenario links (not inclusive)
    * @return the range of process scenario links
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<io.gatling.liferay.model.ProcessScenarioLink> getProcessScenarioLinks(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getProcessScenarioLinks(start, end);
    }

    /**
    * Returns the number of process scenario links.
    *
    * @return the number of process scenario links
    * @throws SystemException if a system exception occurred
    */
    public static int getProcessScenarioLinksCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getProcessScenarioLinksCount();
    }

    /**
    * Updates the process scenario link in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param processScenarioLink the process scenario link
    * @return the process scenario link that was updated
    * @throws SystemException if a system exception occurred
    */
    public static io.gatling.liferay.model.ProcessScenarioLink updateProcessScenarioLink(
        io.gatling.liferay.model.ProcessScenarioLink processScenarioLink)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updateProcessScenarioLink(processScenarioLink);
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

    public static io.gatling.liferay.model.ProcessScenarioLink createLink(
        long scenarioId, long processId, int order, int pause)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().createLink(scenarioId, processId, order, pause);
    }

    public static java.util.List<io.gatling.liferay.model.ProcessScenarioLink> findByscenarioId(
        long scenarioId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().findByscenarioId(scenarioId);
    }

    public static void clearService() {
        _service = null;
    }

    public static ProcessScenarioLinkLocalService getService() {
        if (_service == null) {
            InvokableLocalService invokableLocalService = (InvokableLocalService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    ProcessScenarioLinkLocalService.class.getName());

            if (invokableLocalService instanceof ProcessScenarioLinkLocalService) {
                _service = (ProcessScenarioLinkLocalService) invokableLocalService;
            } else {
                _service = new ProcessScenarioLinkLocalServiceClp(invokableLocalService);
            }

            ReferenceRegistry.registerReference(ProcessScenarioLinkLocalServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setService(ProcessScenarioLinkLocalService service) {
    }
}
