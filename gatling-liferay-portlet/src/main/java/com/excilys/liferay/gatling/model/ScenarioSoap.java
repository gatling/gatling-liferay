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
public class ScenarioSoap implements Serializable {
    private long _scenario_id;
    private String _name;
    private String _url_site;
    private long _group_id;
    private long _simulation_id;
    private long _numberOfUsers;
    private long _duration;

    public ScenarioSoap() {
    }

    public static ScenarioSoap toSoapModel(Scenario model) {
        ScenarioSoap soapModel = new ScenarioSoap();

        soapModel.setScenario_id(model.getScenario_id());
        soapModel.setName(model.getName());
        soapModel.setUrl_site(model.getUrl_site());
        soapModel.setGroup_id(model.getGroup_id());
        soapModel.setSimulation_id(model.getSimulation_id());
        soapModel.setNumberOfUsers(model.getNumberOfUsers());
        soapModel.setDuration(model.getDuration());

        return soapModel;
    }

    public static ScenarioSoap[] toSoapModels(Scenario[] models) {
        ScenarioSoap[] soapModels = new ScenarioSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static ScenarioSoap[][] toSoapModels(Scenario[][] models) {
        ScenarioSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new ScenarioSoap[models.length][models[0].length];
        } else {
            soapModels = new ScenarioSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static ScenarioSoap[] toSoapModels(List<Scenario> models) {
        List<ScenarioSoap> soapModels = new ArrayList<ScenarioSoap>(models.size());

        for (Scenario model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new ScenarioSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _scenario_id;
    }

    public void setPrimaryKey(long pk) {
        setScenario_id(pk);
    }

    public long getScenario_id() {
        return _scenario_id;
    }

    public void setScenario_id(long scenario_id) {
        _scenario_id = scenario_id;
    }

    public String getName() {
        return _name;
    }

    public void setName(String name) {
        _name = name;
    }

    public String getUrl_site() {
        return _url_site;
    }

    public void setUrl_site(String url_site) {
        _url_site = url_site;
    }

    public long getGroup_id() {
        return _group_id;
    }

    public void setGroup_id(long group_id) {
        _group_id = group_id;
    }

    public long getSimulation_id() {
        return _simulation_id;
    }

    public void setSimulation_id(long simulation_id) {
        _simulation_id = simulation_id;
    }

    public long getNumberOfUsers() {
        return _numberOfUsers;
    }

    public void setNumberOfUsers(long numberOfUsers) {
        _numberOfUsers = numberOfUsers;
    }

    public long getDuration() {
        return _duration;
    }

    public void setDuration(long duration) {
        _duration = duration;
    }
}
