/**
 * Copyright 2011-2015 GatlingCorp (http://gatling.io)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * 		http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
