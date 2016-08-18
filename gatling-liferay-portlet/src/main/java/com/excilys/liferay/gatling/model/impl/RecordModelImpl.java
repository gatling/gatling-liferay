package com.excilys.liferay.gatling.model.impl;

import com.excilys.liferay.gatling.model.Record;
import com.excilys.liferay.gatling.model.RecordModel;

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
 * The base model implementation for the Record service. Represents a row in the &quot;StressTool_Record&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.excilys.liferay.gatling.model.RecordModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link RecordImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RecordImpl
 * @see com.excilys.liferay.gatling.model.Record
 * @see com.excilys.liferay.gatling.model.RecordModel
 * @generated
 */
public class RecordModelImpl extends BaseModelImpl<Record>
    implements RecordModel {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. All methods that expect a record model instance should use the {@link com.excilys.liferay.gatling.model.Record} interface instead.
     */
    public static final String TABLE_NAME = "StressTool_Record";
    public static final Object[][] TABLE_COLUMNS = {
            { "recordId", Types.BIGINT },
            { "portletId", Types.VARCHAR },
            { "versionPortlet", Types.VARCHAR },
            { "name", Types.VARCHAR }
        };
    public static final String TABLE_SQL_CREATE = "create table StressTool_Record (recordId LONG not null primary key,portletId VARCHAR(75) null,versionPortlet VARCHAR(75) null,name VARCHAR(75) null)";
    public static final String TABLE_SQL_DROP = "drop table StressTool_Record";
    public static final String ORDER_BY_JPQL = " ORDER BY record.recordId ASC";
    public static final String ORDER_BY_SQL = " ORDER BY StressTool_Record.recordId ASC";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.entity.cache.enabled.com.excilys.liferay.gatling.model.Record"),
            true);
    public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.finder.cache.enabled.com.excilys.liferay.gatling.model.Record"),
            true);
    public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.column.bitmask.enabled.com.excilys.liferay.gatling.model.Record"),
            true);
    public static long NAME_COLUMN_BITMASK = 1L;
    public static long PORTLETID_COLUMN_BITMASK = 2L;
    public static long RECORDID_COLUMN_BITMASK = 4L;
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
                "lock.expiration.time.com.excilys.liferay.gatling.model.Record"));
    private static ClassLoader _classLoader = Record.class.getClassLoader();
    private static Class<?>[] _escapedModelInterfaces = new Class[] { Record.class };
    private long _recordId;
    private String _portletId;
    private String _originalPortletId;
    private String _versionPortlet;
    private String _name;
    private String _originalName;
    private long _columnBitmask;
    private Record _escapedModel;

    public RecordModelImpl() {
    }

    @Override
    public long getPrimaryKey() {
        return _recordId;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {
        setRecordId(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _recordId;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    @Override
    public Class<?> getModelClass() {
        return Record.class;
    }

    @Override
    public String getModelClassName() {
        return Record.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("recordId", getRecordId());
        attributes.put("portletId", getPortletId());
        attributes.put("versionPortlet", getVersionPortlet());
        attributes.put("name", getName());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long recordId = (Long) attributes.get("recordId");

        if (recordId != null) {
            setRecordId(recordId);
        }

        String portletId = (String) attributes.get("portletId");

        if (portletId != null) {
            setPortletId(portletId);
        }

        String versionPortlet = (String) attributes.get("versionPortlet");

        if (versionPortlet != null) {
            setVersionPortlet(versionPortlet);
        }

        String name = (String) attributes.get("name");

        if (name != null) {
            setName(name);
        }
    }

    @Override
    public long getRecordId() {
        return _recordId;
    }

    @Override
    public void setRecordId(long recordId) {
        _recordId = recordId;
    }

    @Override
    public String getPortletId() {
        if (_portletId == null) {
            return StringPool.BLANK;
        } else {
            return _portletId;
        }
    }

    @Override
    public void setPortletId(String portletId) {
        _columnBitmask |= PORTLETID_COLUMN_BITMASK;

        if (_originalPortletId == null) {
            _originalPortletId = _portletId;
        }

        _portletId = portletId;
    }

    public String getOriginalPortletId() {
        return GetterUtil.getString(_originalPortletId);
    }

    @Override
    public String getVersionPortlet() {
        if (_versionPortlet == null) {
            return StringPool.BLANK;
        } else {
            return _versionPortlet;
        }
    }

    @Override
    public void setVersionPortlet(String versionPortlet) {
        _versionPortlet = versionPortlet;
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
        _columnBitmask |= NAME_COLUMN_BITMASK;

        if (_originalName == null) {
            _originalName = _name;
        }

        _name = name;
    }

    public String getOriginalName() {
        return GetterUtil.getString(_originalName);
    }

    public long getColumnBitmask() {
        return _columnBitmask;
    }

    @Override
    public ExpandoBridge getExpandoBridge() {
        return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
            Record.class.getName(), getPrimaryKey());
    }

    @Override
    public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
        ExpandoBridge expandoBridge = getExpandoBridge();

        expandoBridge.setAttributes(serviceContext);
    }

    @Override
    public Record toEscapedModel() {
        if (_escapedModel == null) {
            _escapedModel = (Record) ProxyUtil.newProxyInstance(_classLoader,
                    _escapedModelInterfaces, new AutoEscapeBeanHandler(this));
        }

        return _escapedModel;
    }

    @Override
    public Object clone() {
        RecordImpl recordImpl = new RecordImpl();

        recordImpl.setRecordId(getRecordId());
        recordImpl.setPortletId(getPortletId());
        recordImpl.setVersionPortlet(getVersionPortlet());
        recordImpl.setName(getName());

        recordImpl.resetOriginalValues();

        return recordImpl;
    }

    @Override
    public int compareTo(Record record) {
        long primaryKey = record.getPrimaryKey();

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

        if (!(obj instanceof Record)) {
            return false;
        }

        Record record = (Record) obj;

        long primaryKey = record.getPrimaryKey();

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
        RecordModelImpl recordModelImpl = this;

        recordModelImpl._originalPortletId = recordModelImpl._portletId;

        recordModelImpl._originalName = recordModelImpl._name;

        recordModelImpl._columnBitmask = 0;
    }

    @Override
    public CacheModel<Record> toCacheModel() {
        RecordCacheModel recordCacheModel = new RecordCacheModel();

        recordCacheModel.recordId = getRecordId();

        recordCacheModel.portletId = getPortletId();

        String portletId = recordCacheModel.portletId;

        if ((portletId != null) && (portletId.length() == 0)) {
            recordCacheModel.portletId = null;
        }

        recordCacheModel.versionPortlet = getVersionPortlet();

        String versionPortlet = recordCacheModel.versionPortlet;

        if ((versionPortlet != null) && (versionPortlet.length() == 0)) {
            recordCacheModel.versionPortlet = null;
        }

        recordCacheModel.name = getName();

        String name = recordCacheModel.name;

        if ((name != null) && (name.length() == 0)) {
            recordCacheModel.name = null;
        }

        return recordCacheModel;
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(9);

        sb.append("{recordId=");
        sb.append(getRecordId());
        sb.append(", portletId=");
        sb.append(getPortletId());
        sb.append(", versionPortlet=");
        sb.append(getVersionPortlet());
        sb.append(", name=");
        sb.append(getName());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(16);

        sb.append("<model><model-name>");
        sb.append("com.excilys.liferay.gatling.model.Record");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>recordId</column-name><column-value><![CDATA[");
        sb.append(getRecordId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>portletId</column-name><column-value><![CDATA[");
        sb.append(getPortletId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>versionPortlet</column-name><column-value><![CDATA[");
        sb.append(getVersionPortlet());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>name</column-name><column-value><![CDATA[");
        sb.append(getName());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
