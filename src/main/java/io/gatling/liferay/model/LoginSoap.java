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
public class LoginSoap implements Serializable {
    private long _userId;
    private String _name;
    private String _data;

    public LoginSoap() {
    }

    public static LoginSoap toSoapModel(Login model) {
        LoginSoap soapModel = new LoginSoap();

        soapModel.setUserId(model.getUserId());
        soapModel.setName(model.getName());
        soapModel.setData(model.getData());

        return soapModel;
    }

    public static LoginSoap[] toSoapModels(Login[] models) {
        LoginSoap[] soapModels = new LoginSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static LoginSoap[][] toSoapModels(Login[][] models) {
        LoginSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new LoginSoap[models.length][models[0].length];
        } else {
            soapModels = new LoginSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static LoginSoap[] toSoapModels(List<Login> models) {
        List<LoginSoap> soapModels = new ArrayList<LoginSoap>(models.size());

        for (Login model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new LoginSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _userId;
    }

    public void setPrimaryKey(long pk) {
        setUserId(pk);
    }

    public long getUserId() {
        return _userId;
    }

    public void setUserId(long userId) {
        _userId = userId;
    }

    public String getName() {
        return _name;
    }

    public void setName(String name) {
        _name = name;
    }

    public String getData() {
        return _data;
    }

    public void setData(String data) {
        _data = data;
    }
}
