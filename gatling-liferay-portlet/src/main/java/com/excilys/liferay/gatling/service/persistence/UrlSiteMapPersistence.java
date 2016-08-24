package com.excilys.liferay.gatling.service.persistence;

import com.excilys.liferay.gatling.model.UrlSiteMap;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the url site map service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UrlSiteMapPersistenceImpl
 * @see UrlSiteMapUtil
 * @generated
 */
public interface UrlSiteMapPersistence extends BasePersistence<UrlSiteMap> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link UrlSiteMapUtil} to access the url site map persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Returns all the url site maps where siteMapId = &#63;.
    *
    * @param siteMapId the site map ID
    * @return the matching url site maps
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.excilys.liferay.gatling.model.UrlSiteMap> findBySiteMapId(
        long siteMapId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the url site maps where siteMapId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.excilys.liferay.gatling.model.impl.UrlSiteMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param siteMapId the site map ID
    * @param start the lower bound of the range of url site maps
    * @param end the upper bound of the range of url site maps (not inclusive)
    * @return the range of matching url site maps
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.excilys.liferay.gatling.model.UrlSiteMap> findBySiteMapId(
        long siteMapId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the url site maps where siteMapId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.excilys.liferay.gatling.model.impl.UrlSiteMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param siteMapId the site map ID
    * @param start the lower bound of the range of url site maps
    * @param end the upper bound of the range of url site maps (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching url site maps
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.excilys.liferay.gatling.model.UrlSiteMap> findBySiteMapId(
        long siteMapId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first url site map in the ordered set where siteMapId = &#63;.
    *
    * @param siteMapId the site map ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching url site map
    * @throws com.excilys.liferay.gatling.NoSuchUrlSiteMapException if a matching url site map could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.excilys.liferay.gatling.model.UrlSiteMap findBySiteMapId_First(
        long siteMapId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.excilys.liferay.gatling.NoSuchUrlSiteMapException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first url site map in the ordered set where siteMapId = &#63;.
    *
    * @param siteMapId the site map ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching url site map, or <code>null</code> if a matching url site map could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.excilys.liferay.gatling.model.UrlSiteMap fetchBySiteMapId_First(
        long siteMapId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last url site map in the ordered set where siteMapId = &#63;.
    *
    * @param siteMapId the site map ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching url site map
    * @throws com.excilys.liferay.gatling.NoSuchUrlSiteMapException if a matching url site map could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.excilys.liferay.gatling.model.UrlSiteMap findBySiteMapId_Last(
        long siteMapId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.excilys.liferay.gatling.NoSuchUrlSiteMapException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last url site map in the ordered set where siteMapId = &#63;.
    *
    * @param siteMapId the site map ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching url site map, or <code>null</code> if a matching url site map could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.excilys.liferay.gatling.model.UrlSiteMap fetchBySiteMapId_Last(
        long siteMapId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the url site maps before and after the current url site map in the ordered set where siteMapId = &#63;.
    *
    * @param urlSiteMapId the primary key of the current url site map
    * @param siteMapId the site map ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next url site map
    * @throws com.excilys.liferay.gatling.NoSuchUrlSiteMapException if a url site map with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.excilys.liferay.gatling.model.UrlSiteMap[] findBySiteMapId_PrevAndNext(
        long urlSiteMapId, long siteMapId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.excilys.liferay.gatling.NoSuchUrlSiteMapException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the url site maps where siteMapId = &#63; from the database.
    *
    * @param siteMapId the site map ID
    * @throws SystemException if a system exception occurred
    */
    public void removeBySiteMapId(long siteMapId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of url site maps where siteMapId = &#63;.
    *
    * @param siteMapId the site map ID
    * @return the number of matching url site maps
    * @throws SystemException if a system exception occurred
    */
    public int countBySiteMapId(long siteMapId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Caches the url site map in the entity cache if it is enabled.
    *
    * @param urlSiteMap the url site map
    */
    public void cacheResult(
        com.excilys.liferay.gatling.model.UrlSiteMap urlSiteMap);

    /**
    * Caches the url site maps in the entity cache if it is enabled.
    *
    * @param urlSiteMaps the url site maps
    */
    public void cacheResult(
        java.util.List<com.excilys.liferay.gatling.model.UrlSiteMap> urlSiteMaps);

    /**
    * Creates a new url site map with the primary key. Does not add the url site map to the database.
    *
    * @param urlSiteMapId the primary key for the new url site map
    * @return the new url site map
    */
    public com.excilys.liferay.gatling.model.UrlSiteMap create(
        long urlSiteMapId);

    /**
    * Removes the url site map with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param urlSiteMapId the primary key of the url site map
    * @return the url site map that was removed
    * @throws com.excilys.liferay.gatling.NoSuchUrlSiteMapException if a url site map with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.excilys.liferay.gatling.model.UrlSiteMap remove(
        long urlSiteMapId)
        throws com.excilys.liferay.gatling.NoSuchUrlSiteMapException,
            com.liferay.portal.kernel.exception.SystemException;

    public com.excilys.liferay.gatling.model.UrlSiteMap updateImpl(
        com.excilys.liferay.gatling.model.UrlSiteMap urlSiteMap)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the url site map with the primary key or throws a {@link com.excilys.liferay.gatling.NoSuchUrlSiteMapException} if it could not be found.
    *
    * @param urlSiteMapId the primary key of the url site map
    * @return the url site map
    * @throws com.excilys.liferay.gatling.NoSuchUrlSiteMapException if a url site map with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.excilys.liferay.gatling.model.UrlSiteMap findByPrimaryKey(
        long urlSiteMapId)
        throws com.excilys.liferay.gatling.NoSuchUrlSiteMapException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the url site map with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param urlSiteMapId the primary key of the url site map
    * @return the url site map, or <code>null</code> if a url site map with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.excilys.liferay.gatling.model.UrlSiteMap fetchByPrimaryKey(
        long urlSiteMapId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the url site maps.
    *
    * @return the url site maps
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.excilys.liferay.gatling.model.UrlSiteMap> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.excilys.liferay.gatling.model.UrlSiteMap> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the url site maps.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.excilys.liferay.gatling.model.impl.UrlSiteMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of url site maps
    * @param end the upper bound of the range of url site maps (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of url site maps
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.excilys.liferay.gatling.model.UrlSiteMap> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the url site maps from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of url site maps.
    *
    * @return the number of url site maps
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
