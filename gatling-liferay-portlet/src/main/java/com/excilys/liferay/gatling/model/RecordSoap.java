package com.excilys.liferay.gatling.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class RecordSoap implements Serializable {
    private long _recordId;
    private String _portletId;
    private String _versionPortlet;
    private String _name;

    public RecordSoap() {
    }

    public static RecordSoap toSoapModel(Record model) {
        RecordSoap soapModel = new RecordSoap();

        soapModel.setRecordId(model.getRecordId());
        soapModel.setPortletId(model.getPortletId());
        soapModel.setVersionPortlet(model.getVersionPortlet());
        soapModel.setName(model.getName());

        return soapModel;
    }

    public static RecordSoap[] toSoapModels(Record[] models) {
        RecordSoap[] soapModels = new RecordSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static RecordSoap[][] toSoapModels(Record[][] models) {
        RecordSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new RecordSoap[models.length][models[0].length];
        } else {
            soapModels = new RecordSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static RecordSoap[] toSoapModels(List<Record> models) {
        List<RecordSoap> soapModels = new ArrayList<RecordSoap>(models.size());

        for (Record model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new RecordSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _recordId;
    }

    public void setPrimaryKey(long pk) {
        setRecordId(pk);
    }

    public long getRecordId() {
        return _recordId;
    }

    public void setRecordId(long recordId) {
        _recordId = recordId;
    }

    public String getPortletId() {
        return _portletId;
    }

    public void setPortletId(String portletId) {
        _portletId = portletId;
    }

    public String getVersionPortlet() {
        return _versionPortlet;
    }

    public void setVersionPortlet(String versionPortlet) {
        _versionPortlet = versionPortlet;
    }

    public String getName() {
        return _name;
    }

    public void setName(String name) {
        _name = name;
    }
}
