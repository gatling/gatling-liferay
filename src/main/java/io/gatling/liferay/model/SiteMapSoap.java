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
public class SiteMapSoap implements Serializable {
    private long _siteMapId;
    private String _name;

    public SiteMapSoap() {
    }

    public static SiteMapSoap toSoapModel(SiteMap model) {
        SiteMapSoap soapModel = new SiteMapSoap();

        soapModel.setSiteMapId(model.getSiteMapId());
        soapModel.setName(model.getName());

        return soapModel;
    }

    public static SiteMapSoap[] toSoapModels(SiteMap[] models) {
        SiteMapSoap[] soapModels = new SiteMapSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static SiteMapSoap[][] toSoapModels(SiteMap[][] models) {
        SiteMapSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new SiteMapSoap[models.length][models[0].length];
        } else {
            soapModels = new SiteMapSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static SiteMapSoap[] toSoapModels(List<SiteMap> models) {
        List<SiteMapSoap> soapModels = new ArrayList<SiteMapSoap>(models.size());

        for (SiteMap model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new SiteMapSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _siteMapId;
    }

    public void setPrimaryKey(long pk) {
        setSiteMapId(pk);
    }

    public long getSiteMapId() {
        return _siteMapId;
    }

    public void setSiteMapId(long siteMapId) {
        _siteMapId = siteMapId;
    }

    public String getName() {
        return _name;
    }

    public void setName(String name) {
        _name = name;
    }
}
