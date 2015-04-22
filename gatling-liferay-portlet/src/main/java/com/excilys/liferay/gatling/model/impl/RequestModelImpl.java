package com.excilys.liferay.gatling.model.impl;

import com.excilys.liferay.gatling.model.Request;
import com.excilys.liferay.gatling.model.RequestModel;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import java.io.Serializable;

import java.sql.Types;

import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the Request service. Represents a row in the &quot;StressTool_Request&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.excilys.liferay.gatling.model.RequestModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link RequestImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RequestImpl
 * @see com.excilys.liferay.gatling.model.Request
 * @see com.excilys.liferay.gatling.model.RequestModel
 * @generated
 */
public class RequestModelImpl extends BaseModelImpl<Request>
    implements RequestModel {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. All methods that expect a request model instance should use the {@link com.excilys.liferay.gatling.model.Request} interface instead.
     */
    public static final String TABLE_NAME = "StressTool_Request";
    public static final Object[][] TABLE_COLUMNS = {
            { "request_id", Types.BIGINT },
            { "scenario_id", Types.BIGINT },
            { "name", Types.VARCHAR },
            { "url", Types.VARCHAR },
            { "weight", Types.DOUBLE },
            { "privatePage", Types.BOOLEAN },
            { "parentPlId", Types.BIGINT },
            { "layoutId", Types.BIGINT },
            { "plId", Types.BIGINT },
            { "portlet", Types.BOOLEAN },
            { "portetId", Types.VARCHAR }
        };
    public static final String TABLE_SQL_CREATE = "create table StressTool_Request (request_id LONG not null primary key,scenario_id LONG,name VARCHAR(75) null,url VARCHAR(75) null,weight DOUBLE,privatePage BOOLEAN,parentPlId LONG,layoutId LONG,plId LONG,portlet BOOLEAN,portetId VARCHAR(75) null)";
    public static final String TABLE_SQL_DROP = "drop table StressTool_Request";
    public static final String ORDER_BY_JPQL = " ORDER BY request.request_id ASC";
    public static final String ORDER_BY_SQL = " ORDER BY StressTool_Request.request_id ASC";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.entity.cache.enabled.com.excilys.liferay.gatling.model.Request"),
            true);
    public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.finder.cache.enabled.com.excilys.liferay.gatling.model.Request"),
            true);
    public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.column.bitmask.enabled.com.excilys.liferay.gatling.model.Request"),
            true);
    public static long PARENTPLID_COLUMN_BITMASK = 1L;
    public static long PORTLET_COLUMN_BITMASK = 2L;
    public static long SCENARIO_ID_COLUMN_BITMASK = 4L;
    public static long WEIGHT_COLUMN_BITMASK = 8L;
    public static long REQUEST_ID_COLUMN_BITMASK = 16L;
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
                "lock.expiration.time.com.excilys.liferay.gatling.model.Request"));
    private static ClassLoader _classLoader = Request.class.getClassLoader();
    private static Class<?>[] _escapedModelInterfaces = new Class[] {
            Request.class
        };
    private long _request_id;
    private long _scenario_id;
    private long _originalScenario_id;
    private boolean _setOriginalScenario_id;
    private String _name;
    private String _url;
    private double _weight;
    private double _originalWeight;
    private boolean _setOriginalWeight;
    private boolean _privatePage;
    private long _parentPlId;
    private long _originalParentPlId;
    private boolean _setOriginalParentPlId;
    private long _layoutId;
    private long _plId;
    private boolean _portlet;
    private boolean _originalPortlet;
    private boolean _setOriginalPortlet;
    private String _portetId;
    private long _columnBitmask;
    private Request _escapedModel;

    public RequestModelImpl() {
    }

    @Override
    public long getPrimaryKey() {
        return _request_id;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {
        setRequest_id(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _request_id;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    @Override
    public Class<?> getModelClass() {
        return Request.class;
    }

    @Override
    public String getModelClassName() {
        return Request.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("request_id", getRequest_id());
        attributes.put("scenario_id", getScenario_id());
        attributes.put("name", getName());
        attributes.put("url", getUrl());
        attributes.put("weight", getWeight());
        attributes.put("privatePage", getPrivatePage());
        attributes.put("parentPlId", getParentPlId());
        attributes.put("layoutId", getLayoutId());
        attributes.put("plId", getPlId());
        attributes.put("portlet", getPortlet());
        attributes.put("portetId", getPortetId());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long request_id = (Long) attributes.get("request_id");

        if (request_id != null) {
            setRequest_id(request_id);
        }

        Long scenario_id = (Long) attributes.get("scenario_id");

        if (scenario_id != null) {
            setScenario_id(scenario_id);
        }

        String name = (String) attributes.get("name");

        if (name != null) {
            setName(name);
        }

        String url = (String) attributes.get("url");

        if (url != null) {
            setUrl(url);
        }

        Double weight = (Double) attributes.get("weight");

        if (weight != null) {
            setWeight(weight);
        }

        Boolean privatePage = (Boolean) attributes.get("privatePage");

        if (privatePage != null) {
            setPrivatePage(privatePage);
        }

        Long parentPlId = (Long) attributes.get("parentPlId");

        if (parentPlId != null) {
            setParentPlId(parentPlId);
        }

        Long layoutId = (Long) attributes.get("layoutId");

        if (layoutId != null) {
            setLayoutId(layoutId);
        }

        Long plId = (Long) attributes.get("plId");

        if (plId != null) {
            setPlId(plId);
        }

        Boolean portlet = (Boolean) attributes.get("portlet");

        if (portlet != null) {
            setPortlet(portlet);
        }

        String portetId = (String) attributes.get("portetId");

        if (portetId != null) {
            setPortetId(portetId);
        }
    }

    @Override
    public long getRequest_id() {
        return _request_id;
    }

    @Override
    public void setRequest_id(long request_id) {
        _request_id = request_id;
    }

    @Override
    public long getScenario_id() {
        return _scenario_id;
    }

    @Override
    public void setScenario_id(long scenario_id) {
        _columnBitmask |= SCENARIO_ID_COLUMN_BITMASK;

        if (!_setOriginalScenario_id) {
            _setOriginalScenario_id = true;

            _originalScenario_id = _scenario_id;
        }

        _scenario_id = scenario_id;
    }

    public long getOriginalScenario_id() {
        return _originalScenario_id;
    }

    @Override
    public String getName() {
        if (_name == null) {
            return StringPool.BLANK;
        } else {
            return _name;
        }
    }

    @Override
    public void setName(String name) {
        _name = name;
    }

    @Override
    public String getUrl() {
        if (_url == null) {
            return StringPool.BLANK;
        } else {
            return _url;
        }
    }

    @Override
    public void setUrl(String url) {
        _url = url;
    }

    @Override
    public double getWeight() {
        return _weight;
    }

    @Override
    public void setWeight(double weight) {
        _columnBitmask |= WEIGHT_COLUMN_BITMASK;

        if (!_setOriginalWeight) {
            _setOriginalWeight = true;

            _originalWeight = _weight;
        }

        _weight = weight;
    }

    public double getOriginalWeight() {
        return _originalWeight;
    }

    @Override
    public boolean getPrivatePage() {
        return _privatePage;
    }

    @Override
    public boolean isPrivatePage() {
        return _privatePage;
    }

    @Override
    public void setPrivatePage(boolean privatePage) {
        _privatePage = privatePage;
    }

    @Override
    public long getParentPlId() {
        return _parentPlId;
    }

    @Override
    public void setParentPlId(long parentPlId) {
        _columnBitmask |= PARENTPLID_COLUMN_BITMASK;

        if (!_setOriginalParentPlId) {
            _setOriginalParentPlId = true;

            _originalParentPlId = _parentPlId;
        }

        _parentPlId = parentPlId;
    }

    public long getOriginalParentPlId() {
        return _originalParentPlId;
    }

    @Override
    public long getLayoutId() {
        return _layoutId;
    }

    @Override
    public void setLayoutId(long layoutId) {
        _layoutId = layoutId;
    }

    @Override
    public long getPlId() {
        return _plId;
    }

    @Override
    public void setPlId(long plId) {
        _plId = plId;
    }

    @Override
    public boolean getPortlet() {
        return _portlet;
    }

    @Override
    public boolean isPortlet() {
        return _portlet;
    }

    @Override
    public void setPortlet(boolean portlet) {
        _columnBitmask |= PORTLET_COLUMN_BITMASK;

        if (!_setOriginalPortlet) {
            _setOriginalPortlet = true;

            _originalPortlet = _portlet;
        }

        _portlet = portlet;
    }

    public boolean getOriginalPortlet() {
        return _originalPortlet;
    }

    @Override
    public String getPortetId() {
        if (_portetId == null) {
            return StringPool.BLANK;
        } else {
            return _portetId;
        }
    }

    @Override
    public void setPortetId(String portetId) {
        _portetId = portetId;
    }

    public long getColumnBitmask() {
        return _columnBitmask;
    }

    @Override
    public ExpandoBridge getExpandoBridge() {
        return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
            Request.class.getName(), getPrimaryKey());
    }

    @Override
    public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
        ExpandoBridge expandoBridge = getExpandoBridge();

        expandoBridge.setAttributes(serviceContext);
    }

    @Override
    public Request toEscapedModel() {
        if (_escapedModel == null) {
            _escapedModel = (Request) ProxyUtil.newProxyInstance(_classLoader,
                    _escapedModelInterfaces, new AutoEscapeBeanHandler(this));
        }

        return _escapedModel;
    }

    @Override
    public Object clone() {
        RequestImpl requestImpl = new RequestImpl();

        requestImpl.setRequest_id(getRequest_id());
        requestImpl.setScenario_id(getScenario_id());
        requestImpl.setName(getName());
        requestImpl.setUrl(getUrl());
        requestImpl.setWeight(getWeight());
        requestImpl.setPrivatePage(getPrivatePage());
        requestImpl.setParentPlId(getParentPlId());
        requestImpl.setLayoutId(getLayoutId());
        requestImpl.setPlId(getPlId());
        requestImpl.setPortlet(getPortlet());
        requestImpl.setPortetId(getPortetId());

        requestImpl.resetOriginalValues();

        return requestImpl;
    }

    @Override
    public int compareTo(Request request) {
        long primaryKey = request.getPrimaryKey();

        if (getPrimaryKey() < primaryKey) {
            return -1;
        } else if (getPrimaryKey() > primaryKey) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Request)) {
            return false;
        }

        Request request = (Request) obj;

        long primaryKey = request.getPrimaryKey();

        if (getPrimaryKey() == primaryKey) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return (int) getPrimaryKey();
    }

    @Override
    public void resetOriginalValues() {
        RequestModelImpl requestModelImpl = this;

        requestModelImpl._originalScenario_id = requestModelImpl._scenario_id;

        requestModelImpl._setOriginalScenario_id = false;

        requestModelImpl._originalWeight = requestModelImpl._weight;

        requestModelImpl._setOriginalWeight = false;

        requestModelImpl._originalParentPlId = requestModelImpl._parentPlId;

        requestModelImpl._setOriginalParentPlId = false;

        requestModelImpl._originalPortlet = requestModelImpl._portlet;

        requestModelImpl._setOriginalPortlet = false;

        requestModelImpl._columnBitmask = 0;
    }

    @Override
    public CacheModel<Request> toCacheModel() {
        RequestCacheModel requestCacheModel = new RequestCacheModel();

        requestCacheModel.request_id = getRequest_id();

        requestCacheModel.scenario_id = getScenario_id();

        requestCacheModel.name = getName();

        String name = requestCacheModel.name;

        if ((name != null) && (name.length() == 0)) {
            requestCacheModel.name = null;
        }

        requestCacheModel.url = getUrl();

        String url = requestCacheModel.url;

        if ((url != null) && (url.length() == 0)) {
            requestCacheModel.url = null;
        }

        requestCacheModel.weight = getWeight();

        requestCacheModel.privatePage = getPrivatePage();

        requestCacheModel.parentPlId = getParentPlId();

        requestCacheModel.layoutId = getLayoutId();

        requestCacheModel.plId = getPlId();

        requestCacheModel.portlet = getPortlet();

        requestCacheModel.portetId = getPortetId();

        String portetId = requestCacheModel.portetId;

        if ((portetId != null) && (portetId.length() == 0)) {
            requestCacheModel.portetId = null;
        }

        return requestCacheModel;
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(23);

        sb.append("{request_id=");
        sb.append(getRequest_id());
        sb.append(", scenario_id=");
        sb.append(getScenario_id());
        sb.append(", name=");
        sb.append(getName());
        sb.append(", url=");
        sb.append(getUrl());
        sb.append(", weight=");
        sb.append(getWeight());
        sb.append(", privatePage=");
        sb.append(getPrivatePage());
        sb.append(", parentPlId=");
        sb.append(getParentPlId());
        sb.append(", layoutId=");
        sb.append(getLayoutId());
        sb.append(", plId=");
        sb.append(getPlId());
        sb.append(", portlet=");
        sb.append(getPortlet());
        sb.append(", portetId=");
        sb.append(getPortetId());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(37);

        sb.append("<model><model-name>");
        sb.append("com.excilys.liferay.gatling.model.Request");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>request_id</column-name><column-value><![CDATA[");
        sb.append(getRequest_id());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>scenario_id</column-name><column-value><![CDATA[");
        sb.append(getScenario_id());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>name</column-name><column-value><![CDATA[");
        sb.append(getName());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>url</column-name><column-value><![CDATA[");
        sb.append(getUrl());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>weight</column-name><column-value><![CDATA[");
        sb.append(getWeight());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>privatePage</column-name><column-value><![CDATA[");
        sb.append(getPrivatePage());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>parentPlId</column-name><column-value><![CDATA[");
        sb.append(getParentPlId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>layoutId</column-name><column-value><![CDATA[");
        sb.append(getLayoutId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>plId</column-name><column-value><![CDATA[");
        sb.append(getPlId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>portlet</column-name><column-value><![CDATA[");
        sb.append(getPortlet());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>portetId</column-name><column-value><![CDATA[");
        sb.append(getPortetId());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
