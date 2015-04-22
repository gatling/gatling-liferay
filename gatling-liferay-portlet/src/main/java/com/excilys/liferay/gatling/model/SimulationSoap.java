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
public class SimulationSoap implements Serializable {
    private long _simulation_id;
    private String _name;
    private String _feederContent;
    private boolean _isFeederAFile;

    public SimulationSoap() {
    }

    public static SimulationSoap toSoapModel(Simulation model) {
        SimulationSoap soapModel = new SimulationSoap();

        soapModel.setSimulation_id(model.getSimulation_id());
        soapModel.setName(model.getName());
        soapModel.setFeederContent(model.getFeederContent());
        soapModel.setIsFeederAFile(model.getIsFeederAFile());

        return soapModel;
    }

    public static SimulationSoap[] toSoapModels(Simulation[] models) {
        SimulationSoap[] soapModels = new SimulationSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static SimulationSoap[][] toSoapModels(Simulation[][] models) {
        SimulationSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new SimulationSoap[models.length][models[0].length];
        } else {
            soapModels = new SimulationSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static SimulationSoap[] toSoapModels(List<Simulation> models) {
        List<SimulationSoap> soapModels = new ArrayList<SimulationSoap>(models.size());

        for (Simulation model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new SimulationSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _simulation_id;
    }

    public void setPrimaryKey(long pk) {
        setSimulation_id(pk);
    }

    public long getSimulation_id() {
        return _simulation_id;
    }

    public void setSimulation_id(long simulation_id) {
        _simulation_id = simulation_id;
    }

    public String getName() {
        return _name;
    }

    public void setName(String name) {
        _name = name;
    }

    public String getFeederContent() {
        return _feederContent;
    }

    public void setFeederContent(String feederContent) {
        _feederContent = feederContent;
    }

    public boolean getIsFeederAFile() {
        return _isFeederAFile;
    }

    public boolean isIsFeederAFile() {
        return _isFeederAFile;
    }

    public void setIsFeederAFile(boolean isFeederAFile) {
        _isFeederAFile = isFeederAFile;
    }
}
