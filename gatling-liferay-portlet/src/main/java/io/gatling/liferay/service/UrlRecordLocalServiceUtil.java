package io.gatling.liferay.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for UrlRecord. This utility wraps
 * {@link io.gatling.liferay.service.impl.UrlRecordLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see UrlRecordLocalService
 * @see io.gatling.liferay.service.base.UrlRecordLocalServiceBaseImpl
 * @see io.gatling.liferay.service.impl.UrlRecordLocalServiceImpl
 * @generated
 */
public class UrlRecordLocalServiceUtil {
    private static UrlRecordLocalService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link io.gatling.liferay.service.impl.UrlRecordLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */

    /**
    * Adds the url record to the database. Also notifies the appropriate model listeners.
    *
    * @param urlRecord the url record
    * @return the url record that was added
    * @throws SystemException if a system exception occurred
    */
    public static io.gatling.liferay.model.UrlRecord addUrlRecord(
        io.gatling.liferay.model.UrlRecord urlRecord)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().addUrlRecord(urlRecord);
    }

    /**
    * Creates a new url record with the primary key. Does not add the url record to the database.
    *
    * @param urlRecordId the primary key for the new url record
    * @return the new url record
    */
    public static io.gatling.liferay.model.UrlRecord createUrlRecord(
        long urlRecordId) {
        return getService().createUrlRecord(urlRecordId);
    }

    /**
    * Deletes the url record with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param urlRecordId the primary key of the url record
    * @return the url record that was removed
    * @throws PortalException if a url record with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static io.gatling.liferay.model.UrlRecord deleteUrlRecord(
        long urlRecordId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteUrlRecord(urlRecordId);
    }

    /**
    * Deletes the url record from the database. Also notifies the appropriate model listeners.
    *
    * @param urlRecord the url record
    * @return the url record that was removed
    * @throws SystemException if a system exception occurred
    */
    public static io.gatling.liferay.model.UrlRecord deleteUrlRecord(
        io.gatling.liferay.model.UrlRecord urlRecord)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteUrlRecord(urlRecord);
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
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link io.gatling.liferay.model.impl.UrlRecordModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link io.gatling.liferay.model.impl.UrlRecordModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

    public static io.gatling.liferay.model.UrlRecord fetchUrlRecord(
        long urlRecordId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().fetchUrlRecord(urlRecordId);
    }

    /**
    * Returns the url record with the primary key.
    *
    * @param urlRecordId the primary key of the url record
    * @return the url record
    * @throws PortalException if a url record with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static io.gatling.liferay.model.UrlRecord getUrlRecord(
        long urlRecordId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getUrlRecord(urlRecordId);
    }

    public static com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the url records.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link io.gatling.liferay.model.impl.UrlRecordModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of url records
    * @param end the upper bound of the range of url records (not inclusive)
    * @return the range of url records
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<io.gatling.liferay.model.UrlRecord> getUrlRecords(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getUrlRecords(start, end);
    }

    /**
    * Returns the number of url records.
    *
    * @return the number of url records
    * @throws SystemException if a system exception occurred
    */
    public static int getUrlRecordsCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getUrlRecordsCount();
    }

    /**
    * Updates the url record in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param urlRecord the url record
    * @return the url record that was updated
    * @throws SystemException if a system exception occurred
    */
    public static io.gatling.liferay.model.UrlRecord updateUrlRecord(
        io.gatling.liferay.model.UrlRecord urlRecord)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updateUrlRecord(urlRecord);
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

    public static java.util.List<io.gatling.liferay.model.UrlRecord> findByRecordId(
        long recordId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().findByRecordId(recordId);
    }

    public static void removeByRecordId(long recordId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getService().removeByRecordId(recordId);
    }

    public static int countByRecordId(long recordId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().countByRecordId(recordId);
    }

    public static long save(java.lang.String url, java.lang.String type,
        int order, long recordId, int pauseTime)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().save(url, type, order, recordId, pauseTime);
    }

    public static void clearService() {
        _service = null;
    }

    public static UrlRecordLocalService getService() {
        if (_service == null) {
            InvokableLocalService invokableLocalService = (InvokableLocalService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    UrlRecordLocalService.class.getName());

            if (invokableLocalService instanceof UrlRecordLocalService) {
                _service = (UrlRecordLocalService) invokableLocalService;
            } else {
                _service = new UrlRecordLocalServiceClp(invokableLocalService);
            }

            ReferenceRegistry.registerReference(UrlRecordLocalServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setService(UrlRecordLocalService service) {
    }
}
