/**
 * Copyright 2011-2016 GatlingCorp (http://gatling.io)
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
