package io.gatling.liferay.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import io.gatling.liferay.model.SiteMap;

/**
 * The persistence interface for the site map service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SiteMapPersistenceImpl
 * @see SiteMapUtil
 * @generated
 */
public interface SiteMapPersistence extends BasePersistence<SiteMap> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link SiteMapUtil} to access the site map persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Returns the site map where name = &#63; or throws a {@link io.gatling.liferay.NoSuchSiteMapException} if it could not be found.
    *
    * @param name the name
    * @return the matching site map
    * @throws io.gatling.liferay.NoSuchSiteMapException if a matching site map could not be found
    * @throws SystemException if a system exception occurred
    */
    public io.gatling.liferay.model.SiteMap findByName(java.lang.String name)
        throws com.liferay.portal.kernel.exception.SystemException,
            io.gatling.liferay.NoSuchSiteMapException;

    /**
    * Returns the site map where name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param name the name
    * @return the matching site map, or <code>null</code> if a matching site map could not be found
    * @throws SystemException if a system exception occurred
    */
    public io.gatling.liferay.model.SiteMap fetchByName(java.lang.String name)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the site map where name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param name the name
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching site map, or <code>null</code> if a matching site map could not be found
    * @throws SystemException if a system exception occurred
    */
    public io.gatling.liferay.model.SiteMap fetchByName(java.lang.String name,
        boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes the site map where name = &#63; from the database.
    *
    * @param name the name
    * @return the site map that was removed
    * @throws SystemException if a system exception occurred
    */
    public io.gatling.liferay.model.SiteMap removeByName(java.lang.String name)
        throws com.liferay.portal.kernel.exception.SystemException,
            io.gatling.liferay.NoSuchSiteMapException;

    /**
    * Returns the number of site maps where name = &#63;.
    *
    * @param name the name
    * @return the number of matching site maps
    * @throws SystemException if a system exception occurred
    */
    public int countByName(java.lang.String name)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Caches the site map in the entity cache if it is enabled.
    *
    * @param siteMap the site map
    */
    public void cacheResult(io.gatling.liferay.model.SiteMap siteMap);

    /**
    * Caches the site maps in the entity cache if it is enabled.
    *
    * @param siteMaps the site maps
    */
    public void cacheResult(
        java.util.List<io.gatling.liferay.model.SiteMap> siteMaps);

    /**
    * Creates a new site map with the primary key. Does not add the site map to the database.
    *
    * @param siteMapId the primary key for the new site map
    * @return the new site map
    */
    public io.gatling.liferay.model.SiteMap create(long siteMapId);

    /**
    * Removes the site map with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param siteMapId the primary key of the site map
    * @return the site map that was removed
    * @throws io.gatling.liferay.NoSuchSiteMapException if a site map with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public io.gatling.liferay.model.SiteMap remove(long siteMapId)
        throws com.liferay.portal.kernel.exception.SystemException,
            io.gatling.liferay.NoSuchSiteMapException;

    public io.gatling.liferay.model.SiteMap updateImpl(
        io.gatling.liferay.model.SiteMap siteMap)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the site map with the primary key or throws a {@link io.gatling.liferay.NoSuchSiteMapException} if it could not be found.
    *
    * @param siteMapId the primary key of the site map
    * @return the site map
    * @throws io.gatling.liferay.NoSuchSiteMapException if a site map with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public io.gatling.liferay.model.SiteMap findByPrimaryKey(long siteMapId)
        throws com.liferay.portal.kernel.exception.SystemException,
            io.gatling.liferay.NoSuchSiteMapException;

    /**
    * Returns the site map with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param siteMapId the primary key of the site map
    * @return the site map, or <code>null</code> if a site map with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public io.gatling.liferay.model.SiteMap fetchByPrimaryKey(long siteMapId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the site maps.
    *
    * @return the site maps
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<io.gatling.liferay.model.SiteMap> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<io.gatling.liferay.model.SiteMap> findAll(int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the site maps.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link io.gatling.liferay.model.impl.SiteMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of site maps
    * @param end the upper bound of the range of site maps (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of site maps
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<io.gatling.liferay.model.SiteMap> findAll(int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the site maps from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of site maps.
    *
    * @return the number of site maps
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
