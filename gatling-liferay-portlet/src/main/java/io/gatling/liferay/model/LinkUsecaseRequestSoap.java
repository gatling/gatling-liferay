package io.gatling.liferay.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class LinkUsecaseRequestSoap implements Serializable {
    private long _linkUsecaseRequestId;
    private long _request_id;
    private long _recordId;
    private double _weight;
    private boolean _sample;

    public LinkUsecaseRequestSoap() {
    }

    public static LinkUsecaseRequestSoap toSoapModel(LinkUsecaseRequest model) {
        LinkUsecaseRequestSoap soapModel = new LinkUsecaseRequestSoap();

        soapModel.setLinkUsecaseRequestId(model.getLinkUsecaseRequestId());
        soapModel.setRequest_id(model.getRequest_id());
        soapModel.setRecordId(model.getRecordId());
        soapModel.setWeight(model.getWeight());
        soapModel.setSample(model.getSample());

        return soapModel;
    }

    public static LinkUsecaseRequestSoap[] toSoapModels(
        LinkUsecaseRequest[] models) {
        LinkUsecaseRequestSoap[] soapModels = new LinkUsecaseRequestSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static LinkUsecaseRequestSoap[][] toSoapModels(
        LinkUsecaseRequest[][] models) {
        LinkUsecaseRequestSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new LinkUsecaseRequestSoap[models.length][models[0].length];
        } else {
            soapModels = new LinkUsecaseRequestSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static LinkUsecaseRequestSoap[] toSoapModels(
        List<LinkUsecaseRequest> models) {
        List<LinkUsecaseRequestSoap> soapModels = new ArrayList<LinkUsecaseRequestSoap>(models.size());

        for (LinkUsecaseRequest model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new LinkUsecaseRequestSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _linkUsecaseRequestId;
    }

    public void setPrimaryKey(long pk) {
        setLinkUsecaseRequestId(pk);
    }

    public long getLinkUsecaseRequestId() {
        return _linkUsecaseRequestId;
    }

    public void setLinkUsecaseRequestId(long linkUsecaseRequestId) {
        _linkUsecaseRequestId = linkUsecaseRequestId;
    }

    public long getRequest_id() {
        return _request_id;
    }

    public void setRequest_id(long request_id) {
        _request_id = request_id;
    }

    public long getRecordId() {
        return _recordId;
    }

    public void setRecordId(long recordId) {
        _recordId = recordId;
    }

    public double getWeight() {
        return _weight;
    }

    public void setWeight(double weight) {
        _weight = weight;
    }

    public boolean getSample() {
        return _sample;
    }

    public boolean isSample() {
        return _sample;
    }

    public void setSample(boolean sample) {
        _sample = sample;
    }
}
