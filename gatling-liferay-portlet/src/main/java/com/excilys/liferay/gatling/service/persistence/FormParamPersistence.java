package com.excilys.liferay.gatling.service.persistence;

import com.excilys.liferay.gatling.model.FormParam;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the form param service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FormParamPersistenceImpl
 * @see FormParamUtil
 * @generated
 */
public interface FormParamPersistence extends BasePersistence<FormParam> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link FormParamUtil} to access the form param persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Returns the form param where urlRecordId = &#63; or throws a {@link com.excilys.liferay.gatling.NoSuchFormParamException} if it could not be found.
    *
    * @param urlRecordId the url record ID
    * @return the matching form param
    * @throws com.excilys.liferay.gatling.NoSuchFormParamException if a matching form param could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.excilys.liferay.gatling.model.FormParam findByUrlRecordId(
        long urlRecordId)
        throws com.excilys.liferay.gatling.NoSuchFormParamException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the form param where urlRecordId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param urlRecordId the url record ID
    * @return the matching form param, or <code>null</code> if a matching form param could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.excilys.liferay.gatling.model.FormParam fetchByUrlRecordId(
        long urlRecordId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the form param where urlRecordId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param urlRecordId the url record ID
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching form param, or <code>null</code> if a matching form param could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.excilys.liferay.gatling.model.FormParam fetchByUrlRecordId(
        long urlRecordId, boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes the form param where urlRecordId = &#63; from the database.
    *
    * @param urlRecordId the url record ID
    * @return the form param that was removed
    * @throws SystemException if a system exception occurred
    */
    public com.excilys.liferay.gatling.model.FormParam removeByUrlRecordId(
        long urlRecordId)
        throws com.excilys.liferay.gatling.NoSuchFormParamException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of form params where urlRecordId = &#63;.
    *
    * @param urlRecordId the url record ID
    * @return the number of matching form params
    * @throws SystemException if a system exception occurred
    */
    public int countByUrlRecordId(long urlRecordId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Caches the form param in the entity cache if it is enabled.
    *
    * @param formParam the form param
    */
    public void cacheResult(
        com.excilys.liferay.gatling.model.FormParam formParam);

    /**
    * Caches the form params in the entity cache if it is enabled.
    *
    * @param formParams the form params
    */
    public void cacheResult(
        java.util.List<com.excilys.liferay.gatling.model.FormParam> formParams);

    /**
    * Creates a new form param with the primary key. Does not add the form param to the database.
    *
    * @param formParamId the primary key for the new form param
    * @return the new form param
    */
    public com.excilys.liferay.gatling.model.FormParam create(long formParamId);

    /**
    * Removes the form param with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param formParamId the primary key of the form param
    * @return the form param that was removed
    * @throws com.excilys.liferay.gatling.NoSuchFormParamException if a form param with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.excilys.liferay.gatling.model.FormParam remove(long formParamId)
        throws com.excilys.liferay.gatling.NoSuchFormParamException,
            com.liferay.portal.kernel.exception.SystemException;

    public com.excilys.liferay.gatling.model.FormParam updateImpl(
        com.excilys.liferay.gatling.model.FormParam formParam)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the form param with the primary key or throws a {@link com.excilys.liferay.gatling.NoSuchFormParamException} if it could not be found.
    *
    * @param formParamId the primary key of the form param
    * @return the form param
    * @throws com.excilys.liferay.gatling.NoSuchFormParamException if a form param with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.excilys.liferay.gatling.model.FormParam findByPrimaryKey(
        long formParamId)
        throws com.excilys.liferay.gatling.NoSuchFormParamException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the form param with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param formParamId the primary key of the form param
    * @return the form param, or <code>null</code> if a form param with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.excilys.liferay.gatling.model.FormParam fetchByPrimaryKey(
        long formParamId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the form params.
    *
    * @return the form params
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.excilys.liferay.gatling.model.FormParam> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.excilys.liferay.gatling.model.FormParam> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.excilys.liferay.gatling.model.FormParam> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the form params from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of form params.
    *
    * @return the number of form params
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
