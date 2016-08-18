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
public class ProcessSoap implements Serializable {
    private long _process_id;
    private String _name;
    private String _type;
    private int _order;
    private long _scenario_id;
    private Long _recordId;

    public ProcessSoap() {
    }

    public static ProcessSoap toSoapModel(Process model) {
        ProcessSoap soapModel = new ProcessSoap();

        soapModel.setProcess_id(model.getProcess_id());
        soapModel.setName(model.getName());
        soapModel.setType(model.getType());
        soapModel.setOrder(model.getOrder());
        soapModel.setScenario_id(model.getScenario_id());
        soapModel.setRecordId(model.getRecordId());

        return soapModel;
    }

    public static ProcessSoap[] toSoapModels(Process[] models) {
        ProcessSoap[] soapModels = new ProcessSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static ProcessSoap[][] toSoapModels(Process[][] models) {
        ProcessSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new ProcessSoap[models.length][models[0].length];
        } else {
            soapModels = new ProcessSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static ProcessSoap[] toSoapModels(List<Process> models) {
        List<ProcessSoap> soapModels = new ArrayList<ProcessSoap>(models.size());

        for (Process model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new ProcessSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _process_id;
    }

    public void setPrimaryKey(long pk) {
        setProcess_id(pk);
    }

    public long getProcess_id() {
        return _process_id;
    }

    public void setProcess_id(long process_id) {
        _process_id = process_id;
    }

    public String getName() {
        return _name;
    }

    public void setName(String name) {
        _name = name;
    }

    public String getType() {
        return _type;
    }

    public void setType(String type) {
        _type = type;
    }

    public int getOrder() {
        return _order;
    }

    public void setOrder(int order) {
        _order = order;
    }

    public long getScenario_id() {
        return _scenario_id;
    }

    public void setScenario_id(long scenario_id) {
        _scenario_id = scenario_id;
    }

    public Long getRecordId() {
        return _recordId;
    }

    public void setRecordId(Long recordId) {
        _recordId = recordId;
    }
}
