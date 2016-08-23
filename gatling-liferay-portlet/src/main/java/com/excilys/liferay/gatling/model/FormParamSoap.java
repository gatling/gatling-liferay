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
public class FormParamSoap implements Serializable {
    private long _formParamId;
    private long _urlRecordId;
    private String _data;

    public FormParamSoap() {
    }

    public static FormParamSoap toSoapModel(FormParam model) {
        FormParamSoap soapModel = new FormParamSoap();

        soapModel.setFormParamId(model.getFormParamId());
        soapModel.setUrlRecordId(model.getUrlRecordId());
        soapModel.setData(model.getData());

        return soapModel;
    }

    public static FormParamSoap[] toSoapModels(FormParam[] models) {
        FormParamSoap[] soapModels = new FormParamSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static FormParamSoap[][] toSoapModels(FormParam[][] models) {
        FormParamSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new FormParamSoap[models.length][models[0].length];
        } else {
            soapModels = new FormParamSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static FormParamSoap[] toSoapModels(List<FormParam> models) {
        List<FormParamSoap> soapModels = new ArrayList<FormParamSoap>(models.size());

        for (FormParam model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new FormParamSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _formParamId;
    }

    public void setPrimaryKey(long pk) {
        setFormParamId(pk);
    }

    public long getFormParamId() {
        return _formParamId;
    }

    public void setFormParamId(long formParamId) {
        _formParamId = formParamId;
    }

    public long getUrlRecordId() {
        return _urlRecordId;
    }

    public void setUrlRecordId(long urlRecordId) {
        _urlRecordId = urlRecordId;
    }

    public String getData() {
        return _data;
    }

    public void setData(String data) {
        _data = data;
    }
}
