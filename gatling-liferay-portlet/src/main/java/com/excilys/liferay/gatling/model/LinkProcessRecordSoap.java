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
public class LinkProcessRecordSoap implements Serializable {
    private long _link_process_record_id;
    private long _process_id;
    private long _recordId;

    public LinkProcessRecordSoap() {
    }

    public static LinkProcessRecordSoap toSoapModel(LinkProcessRecord model) {
        LinkProcessRecordSoap soapModel = new LinkProcessRecordSoap();

        soapModel.setLink_process_record_id(model.getLink_process_record_id());
        soapModel.setProcess_id(model.getProcess_id());
        soapModel.setRecordId(model.getRecordId());

        return soapModel;
    }

    public static LinkProcessRecordSoap[] toSoapModels(
        LinkProcessRecord[] models) {
        LinkProcessRecordSoap[] soapModels = new LinkProcessRecordSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static LinkProcessRecordSoap[][] toSoapModels(
        LinkProcessRecord[][] models) {
        LinkProcessRecordSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new LinkProcessRecordSoap[models.length][models[0].length];
        } else {
            soapModels = new LinkProcessRecordSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static LinkProcessRecordSoap[] toSoapModels(
        List<LinkProcessRecord> models) {
        List<LinkProcessRecordSoap> soapModels = new ArrayList<LinkProcessRecordSoap>(models.size());

        for (LinkProcessRecord model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new LinkProcessRecordSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _link_process_record_id;
    }

    public void setPrimaryKey(long pk) {
        setLink_process_record_id(pk);
    }

    public long getLink_process_record_id() {
        return _link_process_record_id;
    }

    public void setLink_process_record_id(long link_process_record_id) {
        _link_process_record_id = link_process_record_id;
    }

    public long getProcess_id() {
        return _process_id;
    }

    public void setProcess_id(long process_id) {
        _process_id = process_id;
    }

    public long getRecordId() {
        return _recordId;
    }

    public void setRecordId(long recordId) {
        _recordId = recordId;
    }
}
