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
