package com.excilys.liferay.gatling.model.impl;

import com.excilys.liferay.gatling.model.Request;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Request in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Request
 * @generated
 */
public class RequestCacheModel implements CacheModel<Request>, Externalizable {
    public long request_id;
    public long scenario_id;
    public String name;
    public String url;
    public double weight;
    public boolean privatePage;
    public long parentPlId;
    public long layoutId;
    public long plId;
    public boolean portlet;
    public String portetId;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(23);

        sb.append("{request_id=");
        sb.append(request_id);
        sb.append(", scenario_id=");
        sb.append(scenario_id);
        sb.append(", name=");
        sb.append(name);
        sb.append(", url=");
        sb.append(url);
        sb.append(", weight=");
        sb.append(weight);
        sb.append(", privatePage=");
        sb.append(privatePage);
        sb.append(", parentPlId=");
        sb.append(parentPlId);
        sb.append(", layoutId=");
        sb.append(layoutId);
        sb.append(", plId=");
        sb.append(plId);
        sb.append(", portlet=");
        sb.append(portlet);
        sb.append(", portetId=");
        sb.append(portetId);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public Request toEntityModel() {
        RequestImpl requestImpl = new RequestImpl();

        requestImpl.setRequest_id(request_id);
        requestImpl.setScenario_id(scenario_id);

        if (name == null) {
            requestImpl.setName(StringPool.BLANK);
        } else {
            requestImpl.setName(name);
        }

        if (url == null) {
            requestImpl.setUrl(StringPool.BLANK);
        } else {
            requestImpl.setUrl(url);
        }

        requestImpl.setWeight(weight);
        requestImpl.setPrivatePage(privatePage);
        requestImpl.setParentPlId(parentPlId);
        requestImpl.setLayoutId(layoutId);
        requestImpl.setPlId(plId);
        requestImpl.setPortlet(portlet);

        if (portetId == null) {
            requestImpl.setPortetId(StringPool.BLANK);
        } else {
            requestImpl.setPortetId(portetId);
        }

        requestImpl.resetOriginalValues();

        return requestImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        request_id = objectInput.readLong();
        scenario_id = objectInput.readLong();
        name = objectInput.readUTF();
        url = objectInput.readUTF();
        weight = objectInput.readDouble();
        privatePage = objectInput.readBoolean();
        parentPlId = objectInput.readLong();
        layoutId = objectInput.readLong();
        plId = objectInput.readLong();
        portlet = objectInput.readBoolean();
        portetId = objectInput.readUTF();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(request_id);
        objectOutput.writeLong(scenario_id);

        if (name == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(name);
        }

        if (url == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(url);
        }

        objectOutput.writeDouble(weight);
        objectOutput.writeBoolean(privatePage);
        objectOutput.writeLong(parentPlId);
        objectOutput.writeLong(layoutId);
        objectOutput.writeLong(plId);
        objectOutput.writeBoolean(portlet);

        if (portetId == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(portetId);
        }
    }
}
