package com.excilys.liferay.gatling.service.base;

import com.excilys.liferay.gatling.model.UrlRecord;
import com.excilys.liferay.gatling.service.UrlRecordLocalService;
import com.excilys.liferay.gatling.service.persistence.LinkUsecaseRequestPersistence;
import com.excilys.liferay.gatling.service.persistence.RecordPersistence;
import com.excilys.liferay.gatling.service.persistence.RequestPersistence;
import com.excilys.liferay.gatling.service.persistence.ScenarioPersistence;
import com.excilys.liferay.gatling.service.persistence.SimulationPersistence;
import com.excilys.liferay.gatling.service.persistence.UrlRecordPersistence;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.PersistedModel;
import com.liferay.portal.service.BaseLocalServiceImpl;
import com.liferay.portal.service.PersistedModelLocalServiceRegistryUtil;
import com.liferay.portal.service.persistence.UserPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the url record local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.excilys.liferay.gatling.service.impl.UrlRecordLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.excilys.liferay.gatling.service.impl.UrlRecordLocalServiceImpl
 * @see com.excilys.liferay.gatling.service.UrlRecordLocalServiceUtil
 * @generated
 */
public abstract class UrlRecordLocalServiceBaseImpl extends BaseLocalServiceImpl
    implements UrlRecordLocalService, IdentifiableBean {
    @BeanReference(type = com.excilys.liferay.gatling.service.LinkUsecaseRequestLocalService.class)
    protected com.excilys.liferay.gatling.service.LinkUsecaseRequestLocalService linkUsecaseRequestLocalService;
    @BeanReference(type = LinkUsecaseRequestPersistence.class)
    protected LinkUsecaseRequestPersistence linkUsecaseRequestPersistence;
    @BeanReference(type = com.excilys.liferay.gatling.service.RecordLocalService.class)
    protected com.excilys.liferay.gatling.service.RecordLocalService recordLocalService;
    @BeanReference(type = RecordPersistence.class)
    protected RecordPersistence recordPersistence;
    @BeanReference(type = com.excilys.liferay.gatling.service.RequestLocalService.class)
    protected com.excilys.liferay.gatling.service.RequestLocalService requestLocalService;
    @BeanReference(type = RequestPersistence.class)
    protected RequestPersistence requestPersistence;
    @BeanReference(type = com.excilys.liferay.gatling.service.ScenarioLocalService.class)
    protected com.excilys.liferay.gatling.service.ScenarioLocalService scenarioLocalService;
    @BeanReference(type = ScenarioPersistence.class)
    protected ScenarioPersistence scenarioPersistence;
    @BeanReference(type = com.excilys.liferay.gatling.service.SimulationLocalService.class)
    protected com.excilys.liferay.gatling.service.SimulationLocalService simulationLocalService;
    @BeanReference(type = SimulationPersistence.class)
    protected SimulationPersistence simulationPersistence;
    @BeanReference(type = com.excilys.liferay.gatling.service.UrlRecordLocalService.class)
    protected com.excilys.liferay.gatling.service.UrlRecordLocalService urlRecordLocalService;
    @BeanReference(type = UrlRecordPersistence.class)
    protected UrlRecordPersistence urlRecordPersistence;
    @BeanReference(type = com.liferay.counter.service.CounterLocalService.class)
    protected com.liferay.counter.service.CounterLocalService counterLocalService;
    @BeanReference(type = com.liferay.portal.service.ResourceLocalService.class)
    protected com.liferay.portal.service.ResourceLocalService resourceLocalService;
    @BeanReference(type = com.liferay.portal.service.UserLocalService.class)
    protected com.liferay.portal.service.UserLocalService userLocalService;
    @BeanReference(type = com.liferay.portal.service.UserService.class)
    protected com.liferay.portal.service.UserService userService;
    @BeanReference(type = UserPersistence.class)
    protected UserPersistence userPersistence;
    private String _beanIdentifier;
    private ClassLoader _classLoader;
    private UrlRecordLocalServiceClpInvoker _clpInvoker = new UrlRecordLocalServiceClpInvoker();

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link com.excilys.liferay.gatling.service.UrlRecordLocalServiceUtil} to access the url record local service.
     */

    /**
     * Adds the url record to the database. Also notifies the appropriate model listeners.
     *
     * @param urlRecord the url record
     * @return the url record that was added
     * @throws SystemException if a system exception occurred
     */
    @Indexable(type = IndexableType.REINDEX)
    @Override
    public UrlRecord addUrlRecord(UrlRecord urlRecord)
        throws SystemException {
        urlRecord.setNew(true);

        return urlRecordPersistence.update(urlRecord);
    }

    /**
     * Creates a new url record with the primary key. Does not add the url record to the database.
     *
     * @param urlRecordId the primary key for the new url record
     * @return the new url record
     */
    @Override
    public UrlRecord createUrlRecord(long urlRecordId) {
        return urlRecordPersistence.create(urlRecordId);
    }

    /**
     * Deletes the url record with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param urlRecordId the primary key of the url record
     * @return the url record that was removed
     * @throws PortalException if a url record with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Indexable(type = IndexableType.DELETE)
    @Override
    public UrlRecord deleteUrlRecord(long urlRecordId)
        throws PortalException, SystemException {
        return urlRecordPersistence.remove(urlRecordId);
    }

    /**
     * Deletes the url record from the database. Also notifies the appropriate model listeners.
     *
     * @param urlRecord the url record
     * @return the url record that was removed
     * @throws SystemException if a system exception occurred
     */
    @Indexable(type = IndexableType.DELETE)
    @Override
    public UrlRecord deleteUrlRecord(UrlRecord urlRecord)
        throws SystemException {
        return urlRecordPersistence.remove(urlRecord);
    }

    @Override
    public DynamicQuery dynamicQuery() {
        Class<?> clazz = getClass();

        return DynamicQueryFactoryUtil.forClass(UrlRecord.class,
            clazz.getClassLoader());
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
    public List dynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return urlRecordPersistence.findWithDynamicQuery(dynamicQuery);
    }

    /**
     * Performs a dynamic query on the database and returns a range of the matching rows.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.excilys.liferay.gatling.model.impl.UrlRecordModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
    public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return urlRecordPersistence.findWithDynamicQuery(dynamicQuery, start,
            end);
    }

    /**
     * Performs a dynamic query on the database and returns an ordered range of the matching rows.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.excilys.liferay.gatling.model.impl.UrlRecordModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
    public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return urlRecordPersistence.findWithDynamicQuery(dynamicQuery, start,
            end, orderByComparator);
    }

    /**
     * Returns the number of rows that match the dynamic query.
     *
     * @param dynamicQuery the dynamic query
     * @return the number of rows that match the dynamic query
     * @throws SystemException if a system exception occurred
     */
    @Override
    public long dynamicQueryCount(DynamicQuery dynamicQuery)
        throws SystemException {
        return urlRecordPersistence.countWithDynamicQuery(dynamicQuery);
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
    public long dynamicQueryCount(DynamicQuery dynamicQuery,
        Projection projection) throws SystemException {
        return urlRecordPersistence.countWithDynamicQuery(dynamicQuery,
            projection);
    }

    @Override
    public UrlRecord fetchUrlRecord(long urlRecordId) throws SystemException {
        return urlRecordPersistence.fetchByPrimaryKey(urlRecordId);
    }

    /**
     * Returns the url record with the primary key.
     *
     * @param urlRecordId the primary key of the url record
     * @return the url record
     * @throws PortalException if a url record with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public UrlRecord getUrlRecord(long urlRecordId)
        throws PortalException, SystemException {
        return urlRecordPersistence.findByPrimaryKey(urlRecordId);
    }

    @Override
    public PersistedModel getPersistedModel(Serializable primaryKeyObj)
        throws PortalException, SystemException {
        return urlRecordPersistence.findByPrimaryKey(primaryKeyObj);
    }

    /**
     * Returns a range of all the url records.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.excilys.liferay.gatling.model.impl.UrlRecordModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of url records
     * @param end the upper bound of the range of url records (not inclusive)
     * @return the range of url records
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<UrlRecord> getUrlRecords(int start, int end)
        throws SystemException {
        return urlRecordPersistence.findAll(start, end);
    }

    /**
     * Returns the number of url records.
     *
     * @return the number of url records
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int getUrlRecordsCount() throws SystemException {
        return urlRecordPersistence.countAll();
    }

    /**
     * Updates the url record in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
     *
     * @param urlRecord the url record
     * @return the url record that was updated
     * @throws SystemException if a system exception occurred
     */
    @Indexable(type = IndexableType.REINDEX)
    @Override
    public UrlRecord updateUrlRecord(UrlRecord urlRecord)
        throws SystemException {
        return urlRecordPersistence.update(urlRecord);
    }

    /**
     * Returns the link usecase request local service.
     *
     * @return the link usecase request local service
     */
    public com.excilys.liferay.gatling.service.LinkUsecaseRequestLocalService getLinkUsecaseRequestLocalService() {
        return linkUsecaseRequestLocalService;
    }

    /**
     * Sets the link usecase request local service.
     *
     * @param linkUsecaseRequestLocalService the link usecase request local service
     */
    public void setLinkUsecaseRequestLocalService(
        com.excilys.liferay.gatling.service.LinkUsecaseRequestLocalService linkUsecaseRequestLocalService) {
        this.linkUsecaseRequestLocalService = linkUsecaseRequestLocalService;
    }

    /**
     * Returns the link usecase request persistence.
     *
     * @return the link usecase request persistence
     */
    public LinkUsecaseRequestPersistence getLinkUsecaseRequestPersistence() {
        return linkUsecaseRequestPersistence;
    }

    /**
     * Sets the link usecase request persistence.
     *
     * @param linkUsecaseRequestPersistence the link usecase request persistence
     */
    public void setLinkUsecaseRequestPersistence(
        LinkUsecaseRequestPersistence linkUsecaseRequestPersistence) {
        this.linkUsecaseRequestPersistence = linkUsecaseRequestPersistence;
    }

    /**
     * Returns the record local service.
     *
     * @return the record local service
     */
    public com.excilys.liferay.gatling.service.RecordLocalService getRecordLocalService() {
        return recordLocalService;
    }

    /**
     * Sets the record local service.
     *
     * @param recordLocalService the record local service
     */
    public void setRecordLocalService(
        com.excilys.liferay.gatling.service.RecordLocalService recordLocalService) {
        this.recordLocalService = recordLocalService;
    }

    /**
     * Returns the record persistence.
     *
     * @return the record persistence
     */
    public RecordPersistence getRecordPersistence() {
        return recordPersistence;
    }

    /**
     * Sets the record persistence.
     *
     * @param recordPersistence the record persistence
     */
    public void setRecordPersistence(RecordPersistence recordPersistence) {
        this.recordPersistence = recordPersistence;
    }

    /**
     * Returns the request local service.
     *
     * @return the request local service
     */
    public com.excilys.liferay.gatling.service.RequestLocalService getRequestLocalService() {
        return requestLocalService;
    }

    /**
     * Sets the request local service.
     *
     * @param requestLocalService the request local service
     */
    public void setRequestLocalService(
        com.excilys.liferay.gatling.service.RequestLocalService requestLocalService) {
        this.requestLocalService = requestLocalService;
    }

    /**
     * Returns the request persistence.
     *
     * @return the request persistence
     */
    public RequestPersistence getRequestPersistence() {
        return requestPersistence;
    }

    /**
     * Sets the request persistence.
     *
     * @param requestPersistence the request persistence
     */
    public void setRequestPersistence(RequestPersistence requestPersistence) {
        this.requestPersistence = requestPersistence;
    }

    /**
     * Returns the scenario local service.
     *
     * @return the scenario local service
     */
    public com.excilys.liferay.gatling.service.ScenarioLocalService getScenarioLocalService() {
        return scenarioLocalService;
    }

    /**
     * Sets the scenario local service.
     *
     * @param scenarioLocalService the scenario local service
     */
    public void setScenarioLocalService(
        com.excilys.liferay.gatling.service.ScenarioLocalService scenarioLocalService) {
        this.scenarioLocalService = scenarioLocalService;
    }

    /**
     * Returns the scenario persistence.
     *
     * @return the scenario persistence
     */
    public ScenarioPersistence getScenarioPersistence() {
        return scenarioPersistence;
    }

    /**
     * Sets the scenario persistence.
     *
     * @param scenarioPersistence the scenario persistence
     */
    public void setScenarioPersistence(ScenarioPersistence scenarioPersistence) {
        this.scenarioPersistence = scenarioPersistence;
    }

    /**
     * Returns the simulation local service.
     *
     * @return the simulation local service
     */
    public com.excilys.liferay.gatling.service.SimulationLocalService getSimulationLocalService() {
        return simulationLocalService;
    }

    /**
     * Sets the simulation local service.
     *
     * @param simulationLocalService the simulation local service
     */
    public void setSimulationLocalService(
        com.excilys.liferay.gatling.service.SimulationLocalService simulationLocalService) {
        this.simulationLocalService = simulationLocalService;
    }

    /**
     * Returns the simulation persistence.
     *
     * @return the simulation persistence
     */
    public SimulationPersistence getSimulationPersistence() {
        return simulationPersistence;
    }

    /**
     * Sets the simulation persistence.
     *
     * @param simulationPersistence the simulation persistence
     */
    public void setSimulationPersistence(
        SimulationPersistence simulationPersistence) {
        this.simulationPersistence = simulationPersistence;
    }

    /**
     * Returns the url record local service.
     *
     * @return the url record local service
     */
    public com.excilys.liferay.gatling.service.UrlRecordLocalService getUrlRecordLocalService() {
        return urlRecordLocalService;
    }

    /**
     * Sets the url record local service.
     *
     * @param urlRecordLocalService the url record local service
     */
    public void setUrlRecordLocalService(
        com.excilys.liferay.gatling.service.UrlRecordLocalService urlRecordLocalService) {
        this.urlRecordLocalService = urlRecordLocalService;
    }

    /**
     * Returns the url record persistence.
     *
     * @return the url record persistence
     */
    public UrlRecordPersistence getUrlRecordPersistence() {
        return urlRecordPersistence;
    }

    /**
     * Sets the url record persistence.
     *
     * @param urlRecordPersistence the url record persistence
     */
    public void setUrlRecordPersistence(
        UrlRecordPersistence urlRecordPersistence) {
        this.urlRecordPersistence = urlRecordPersistence;
    }

    /**
     * Returns the counter local service.
     *
     * @return the counter local service
     */
    public com.liferay.counter.service.CounterLocalService getCounterLocalService() {
        return counterLocalService;
    }

    /**
     * Sets the counter local service.
     *
     * @param counterLocalService the counter local service
     */
    public void setCounterLocalService(
        com.liferay.counter.service.CounterLocalService counterLocalService) {
        this.counterLocalService = counterLocalService;
    }

    /**
     * Returns the resource local service.
     *
     * @return the resource local service
     */
    public com.liferay.portal.service.ResourceLocalService getResourceLocalService() {
        return resourceLocalService;
    }

    /**
     * Sets the resource local service.
     *
     * @param resourceLocalService the resource local service
     */
    public void setResourceLocalService(
        com.liferay.portal.service.ResourceLocalService resourceLocalService) {
        this.resourceLocalService = resourceLocalService;
    }

    /**
     * Returns the user local service.
     *
     * @return the user local service
     */
    public com.liferay.portal.service.UserLocalService getUserLocalService() {
        return userLocalService;
    }

    /**
     * Sets the user local service.
     *
     * @param userLocalService the user local service
     */
    public void setUserLocalService(
        com.liferay.portal.service.UserLocalService userLocalService) {
        this.userLocalService = userLocalService;
    }

    /**
     * Returns the user remote service.
     *
     * @return the user remote service
     */
    public com.liferay.portal.service.UserService getUserService() {
        return userService;
    }

    /**
     * Sets the user remote service.
     *
     * @param userService the user remote service
     */
    public void setUserService(
        com.liferay.portal.service.UserService userService) {
        this.userService = userService;
    }

    /**
     * Returns the user persistence.
     *
     * @return the user persistence
     */
    public UserPersistence getUserPersistence() {
        return userPersistence;
    }

    /**
     * Sets the user persistence.
     *
     * @param userPersistence the user persistence
     */
    public void setUserPersistence(UserPersistence userPersistence) {
        this.userPersistence = userPersistence;
    }

    public void afterPropertiesSet() {
        Class<?> clazz = getClass();

        _classLoader = clazz.getClassLoader();

        PersistedModelLocalServiceRegistryUtil.register("com.excilys.liferay.gatling.model.UrlRecord",
            urlRecordLocalService);
    }

    public void destroy() {
        PersistedModelLocalServiceRegistryUtil.unregister(
            "com.excilys.liferay.gatling.model.UrlRecord");
    }

    /**
     * Returns the Spring bean ID for this bean.
     *
     * @return the Spring bean ID for this bean
     */
    @Override
    public String getBeanIdentifier() {
        return _beanIdentifier;
    }

    /**
     * Sets the Spring bean ID for this bean.
     *
     * @param beanIdentifier the Spring bean ID for this bean
     */
    @Override
    public void setBeanIdentifier(String beanIdentifier) {
        _beanIdentifier = beanIdentifier;
    }

    @Override
    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        Thread currentThread = Thread.currentThread();

        ClassLoader contextClassLoader = currentThread.getContextClassLoader();

        if (contextClassLoader != _classLoader) {
            currentThread.setContextClassLoader(_classLoader);
        }

        try {
            return _clpInvoker.invokeMethod(name, parameterTypes, arguments);
        } finally {
            if (contextClassLoader != _classLoader) {
                currentThread.setContextClassLoader(contextClassLoader);
            }
        }
    }

    protected Class<?> getModelClass() {
        return UrlRecord.class;
    }

    protected String getModelClassName() {
        return UrlRecord.class.getName();
    }

    /**
     * Performs an SQL query.
     *
     * @param sql the sql query
     */
    protected void runSQL(String sql) throws SystemException {
        try {
            DataSource dataSource = urlRecordPersistence.getDataSource();

            SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
                    sql, new int[0]);

            sqlUpdate.update();
        } catch (Exception e) {
            throw new SystemException(e);
        }
    }
}
