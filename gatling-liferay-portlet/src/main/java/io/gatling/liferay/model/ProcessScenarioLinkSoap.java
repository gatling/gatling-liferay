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
public class ProcessScenarioLinkSoap implements Serializable {
    private long _psl_id;
    private long _process_id;
    private long _scenario_id;
    private int _order;
    private int _pause;

    public ProcessScenarioLinkSoap() {
    }

    public static ProcessScenarioLinkSoap toSoapModel(ProcessScenarioLink model) {
        ProcessScenarioLinkSoap soapModel = new ProcessScenarioLinkSoap();

        soapModel.setPsl_id(model.getPsl_id());
        soapModel.setProcess_id(model.getProcess_id());
        soapModel.setScenario_id(model.getScenario_id());
        soapModel.setOrder(model.getOrder());
        soapModel.setPause(model.getPause());

        return soapModel;
    }

    public static ProcessScenarioLinkSoap[] toSoapModels(
        ProcessScenarioLink[] models) {
        ProcessScenarioLinkSoap[] soapModels = new ProcessScenarioLinkSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static ProcessScenarioLinkSoap[][] toSoapModels(
        ProcessScenarioLink[][] models) {
        ProcessScenarioLinkSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new ProcessScenarioLinkSoap[models.length][models[0].length];
        } else {
            soapModels = new ProcessScenarioLinkSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static ProcessScenarioLinkSoap[] toSoapModels(
        List<ProcessScenarioLink> models) {
        List<ProcessScenarioLinkSoap> soapModels = new ArrayList<ProcessScenarioLinkSoap>(models.size());

        for (ProcessScenarioLink model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new ProcessScenarioLinkSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _psl_id;
    }

    public void setPrimaryKey(long pk) {
        setPsl_id(pk);
    }

    public long getPsl_id() {
        return _psl_id;
    }

    public void setPsl_id(long psl_id) {
        _psl_id = psl_id;
    }

    public long getProcess_id() {
        return _process_id;
    }

    public void setProcess_id(long process_id) {
        _process_id = process_id;
    }

    public long getScenario_id() {
        return _scenario_id;
    }

    public void setScenario_id(long scenario_id) {
        _scenario_id = scenario_id;
    }

    public int getOrder() {
        return _order;
    }

    public void setOrder(int order) {
        _order = order;
    }

    public int getPause() {
        return _pause;
    }

    public void setPause(int pause) {
        _pause = pause;
    }
}
