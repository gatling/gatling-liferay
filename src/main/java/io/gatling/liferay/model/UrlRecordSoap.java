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
public class UrlRecordSoap implements Serializable {
    private long _urlRecordId;
    private long _recordId;
    private String _url;
    private String _type;
    private int _order;
    private int _pauseTime;

    public UrlRecordSoap() {
    }

    public static UrlRecordSoap toSoapModel(UrlRecord model) {
        UrlRecordSoap soapModel = new UrlRecordSoap();

        soapModel.setUrlRecordId(model.getUrlRecordId());
        soapModel.setRecordId(model.getRecordId());
        soapModel.setUrl(model.getUrl());
        soapModel.setType(model.getType());
        soapModel.setOrder(model.getOrder());
        soapModel.setPauseTime(model.getPauseTime());

        return soapModel;
    }

    public static UrlRecordSoap[] toSoapModels(UrlRecord[] models) {
        UrlRecordSoap[] soapModels = new UrlRecordSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static UrlRecordSoap[][] toSoapModels(UrlRecord[][] models) {
        UrlRecordSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new UrlRecordSoap[models.length][models[0].length];
        } else {
            soapModels = new UrlRecordSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static UrlRecordSoap[] toSoapModels(List<UrlRecord> models) {
        List<UrlRecordSoap> soapModels = new ArrayList<UrlRecordSoap>(models.size());

        for (UrlRecord model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new UrlRecordSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _urlRecordId;
    }

    public void setPrimaryKey(long pk) {
        setUrlRecordId(pk);
    }

    public long getUrlRecordId() {
        return _urlRecordId;
    }

    public void setUrlRecordId(long urlRecordId) {
        _urlRecordId = urlRecordId;
    }

    public long getRecordId() {
        return _recordId;
    }

    public void setRecordId(long recordId) {
        _recordId = recordId;
    }

    public String getUrl() {
        return _url;
    }

    public void setUrl(String url) {
        _url = url;
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

    public int getPauseTime() {
        return _pauseTime;
    }

    public void setPauseTime(int pauseTime) {
        _pauseTime = pauseTime;
    }
}
