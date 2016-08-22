package com.excilys.liferay.gatling.service.persistence;

import com.excilys.liferay.gatling.model.FormParam;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the form param service. This utility wraps {@link FormParamPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FormParamPersistence
 * @see FormParamPersistenceImpl
 * @generated
 */
public class FormParamUtil {
    private static FormParamPersistence _persistence;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
     */
    public static void clearCache() {
        getPersistence().clearCache();
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
     */
    public static void clearCache(FormParam formParam) {
        getPersistence().clearCache(formParam);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
     */
    public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().countWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
     */
    public static List<FormParam> findWithDynamicQuery(
        DynamicQuery dynamicQuery) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<FormParam> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<FormParam> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static FormParam update(FormParam formParam)
        throws SystemException {
        return getPersistence().update(formParam);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static FormParam update(FormParam formParam,
        ServiceContext serviceContext) throws SystemException {
        return getPersistence().update(formParam, serviceContext);
    }

    /**
    * Returns the form param where urlRecordId = &#63; or throws a {@link com.excilys.liferay.gatling.NoSuchFormParamException} if it could not be found.
    *
    * @param urlRecordId the url record ID
    * @return the matching form param
    * @throws com.excilys.liferay.gatling.NoSuchFormParamException if a matching form param could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.excilys.liferay.gatling.model.FormParam findByUrlRecordId(
        long urlRecordId)
        throws com.excilys.liferay.gatling.NoSuchFormParamException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUrlRecordId(urlRecordId);
    }

    /**
    * Returns the form param where urlRecordId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param urlRecordId the url record ID
    * @return the matching form param, or <code>null</code> if a matching form param could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.excilys.liferay.gatling.model.FormParam fetchByUrlRecordId(
        long urlRecordId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByUrlRecordId(urlRecordId);
    }

    /**
    * Returns the form param where urlRecordId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param urlRecordId the url record ID
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching form param, or <code>null</code> if a matching form param could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.excilys.liferay.gatling.model.FormParam fetchByUrlRecordId(
        long urlRecordId, boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByUrlRecordId(urlRecordId, retrieveFromCache);
    }

    /**
    * Removes the form param where urlRecordId = &#63; from the database.
    *
    * @param urlRecordId the url record ID
    * @return the form param that was removed
    * @throws SystemException if a system exception occurred
    */
    public static com.excilys.liferay.gatling.model.FormParam removeByUrlRecordId(
        long urlRecordId)
        throws com.excilys.liferay.gatling.NoSuchFormParamException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().removeByUrlRecordId(urlRecordId);
    }

    /**
    * Returns the number of form params where urlRecordId = &#63;.
    *
    * @param urlRecordId the url record ID
    * @return the number of matching form params
    * @throws SystemException if a system exception occurred
    */
    public static int countByUrlRecordId(long urlRecordId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByUrlRecordId(urlRecordId);
    }

    /**
    * Caches the form param in the entity cache if it is enabled.
    *
    * @param formParam the form param
    */
    public static void cacheResult(
        com.excilys.liferay.gatling.model.FormParam formParam) {
        getPersistence().cacheResult(formParam);
    }

    /**
    * Caches the form params in the entity cache if it is enabled.
    *
    * @param formParams the form params
    */
    public static void cacheResult(
        java.util.List<com.excilys.liferay.gatling.model.FormParam> formParams) {
        getPersistence().cacheResult(formParams);
    }

    /**
    * Creates a new form param with the primary key. Does not add the form param to the database.
    *
    * @param formParamId the primary key for the new form param
    * @return the new form param
    */
    public static com.excilys.liferay.gatling.model.FormParam create(
        long formParamId) {
        return getPersistence().create(formParamId);
    }

    /**
    * Removes the form param with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param formParamId the primary key of the form param
    * @return the form param that was removed
    * @throws com.excilys.liferay.gatling.NoSuchFormParamException if a form param with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.excilys.liferay.gatling.model.FormParam remove(
        long formParamId)
        throws com.excilys.liferay.gatling.NoSuchFormParamException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().remove(formParamId);
    }

    public static com.excilys.liferay.gatling.model.FormParam updateImpl(
        com.excilys.liferay.gatling.model.FormParam formParam)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(formParam);
    }

    /**
    * Returns the form param with the primary key or throws a {@link com.excilys.liferay.gatling.NoSuchFormParamException} if it could not be found.
    *
    * @param formParamId the primary key of the form param
    * @return the form param
    * @throws com.excilys.liferay.gatling.NoSuchFormParamException if a form param with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.excilys.liferay.gatling.model.FormParam findByPrimaryKey(
        long formParamId)
        throws com.excilys.liferay.gatling.NoSuchFormParamException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByPrimaryKey(formParamId);
    }

    /**
    * Returns the form param with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param formParamId the primary key of the form param
    * @return the form param, or <code>null</code> if a form param with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.excilys.liferay.gatling.model.FormParam fetchByPrimaryKey(
        long formParamId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(formParamId);
    }

    /**
    * Returns all the form params.
    *
    * @return the form params
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.excilys.liferay.gatling.model.FormParam> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
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
    public static java.util.List<com.excilys.liferay.gatling.model.FormParam> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the form params.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.excilys.liferay.gatling.model.impl.FormParamModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of form params
    * @param end the upper bound of the range of form params (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of form params
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.excilys.liferay.gatling.model.FormParam> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the form params from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of form params.
    *
    * @return the number of form params
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static FormParamPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (FormParamPersistence) PortletBeanLocatorUtil.locate(com.excilys.liferay.gatling.service.ClpSerializer.getServletContextName(),
                    FormParamPersistence.class.getName());

            ReferenceRegistry.registerReference(FormParamUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(FormParamPersistence persistence) {
    }
}
