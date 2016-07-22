package com.excilys.liferay.gatling.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for FormParam. This utility wraps
 * {@link com.excilys.liferay.gatling.service.impl.FormParamLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see FormParamLocalService
 * @see com.excilys.liferay.gatling.service.base.FormParamLocalServiceBaseImpl
 * @see com.excilys.liferay.gatling.service.impl.FormParamLocalServiceImpl
 * @generated
 */
public class FormParamLocalServiceUtil {
    private static FormParamLocalService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link com.excilys.liferay.gatling.service.impl.FormParamLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */

    /**
    * Adds the form param to the database. Also notifies the appropriate model listeners.
    *
    * @param formParam the form param
    * @return the form param that was added
    * @throws SystemException if a system exception occurred
    */
    public static com.excilys.liferay.gatling.model.FormParam addFormParam(
        com.excilys.liferay.gatling.model.FormParam formParam)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().addFormParam(formParam);
    }

    /**
    * Creates a new form param with the primary key. Does not add the form param to the database.
    *
    * @param formParamId the primary key for the new form param
    * @return the new form param
    */
    public static com.excilys.liferay.gatling.model.FormParam createFormParam(
        long formParamId) {
        return getService().createFormParam(formParamId);
    }

    /**
    * Deletes the form param with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param formParamId the primary key of the form param
    * @return the form param that was removed
    * @throws PortalException if a form param with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.excilys.liferay.gatling.model.FormParam deleteFormParam(
        long formParamId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteFormParam(formParamId);
    }

    /**
    * Deletes the form param from the database. Also notifies the appropriate model listeners.
    *
    * @param formParam the form param
    * @return the form param that was removed
    * @throws SystemException if a system exception occurred
    */
    public static com.excilys.liferay.gatling.model.FormParam deleteFormParam(
        com.excilys.liferay.gatling.model.FormParam formParam)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteFormParam(formParam);
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
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.excilys.liferay.gatling.model.impl.FormParamModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.excilys.liferay.gatling.model.impl.FormParamModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

    public static com.excilys.liferay.gatling.model.FormParam fetchFormParam(
        long formParamId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().fetchFormParam(formParamId);
    }

    /**
    * Returns the form param with the primary key.
    *
    * @param formParamId the primary key of the form param
    * @return the form param
    * @throws PortalException if a form param with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.excilys.liferay.gatling.model.FormParam getFormParam(
        long formParamId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getFormParam(formParamId);
    }

    public static com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the form params.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.excilys.liferay.gatling.model.impl.FormParamModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of form params
    * @param end the upper bound of the range of form params (not inclusive)
    * @return the range of form params
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.excilys.liferay.gatling.model.FormParam> getFormParams(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getFormParams(start, end);
    }

    /**
    * Returns the number of form params.
    *
    * @return the number of form params
    * @throws SystemException if a system exception occurred
    */
    public static int getFormParamsCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getFormParamsCount();
    }

    /**
    * Updates the form param in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param formParam the form param
    * @return the form param that was updated
    * @throws SystemException if a system exception occurred
    */
    public static com.excilys.liferay.gatling.model.FormParam updateFormParam(
        com.excilys.liferay.gatling.model.FormParam formParam)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updateFormParam(formParam);
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

    public static void save(long urlRecordId, java.lang.String data,
        java.lang.String type)
        throws com.liferay.portal.kernel.exception.SystemException {
        getService().save(urlRecordId, data, type);
    }

    public static void clearService() {
        _service = null;
    }

    public static FormParamLocalService getService() {
        if (_service == null) {
            InvokableLocalService invokableLocalService = (InvokableLocalService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    FormParamLocalService.class.getName());

            if (invokableLocalService instanceof FormParamLocalService) {
                _service = (FormParamLocalService) invokableLocalService;
            } else {
                _service = new FormParamLocalServiceClp(invokableLocalService);
            }

            ReferenceRegistry.registerReference(FormParamLocalServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setService(FormParamLocalService service) {
    }
}
