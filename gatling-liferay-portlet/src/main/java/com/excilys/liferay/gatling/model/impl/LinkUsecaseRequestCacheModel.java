package com.excilys.liferay.gatling.model.impl;

import com.excilys.liferay.gatling.model.LinkUsecaseRequest;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing LinkUsecaseRequest in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see LinkUsecaseRequest
 * @generated
 */
public class LinkUsecaseRequestCacheModel implements CacheModel<LinkUsecaseRequest>,
    Externalizable {
    public long linkUsecaseRequestId;
    public long request_id;
    public long recordId;
    public double weight;
    public boolean sample;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(11);

        sb.append("{linkUsecaseRequestId=");
        sb.append(linkUsecaseRequestId);
        sb.append(", request_id=");
        sb.append(request_id);
        sb.append(", recordId=");
        sb.append(recordId);
        sb.append(", weight=");
        sb.append(weight);
        sb.append(", sample=");
        sb.append(sample);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public LinkUsecaseRequest toEntityModel() {
        LinkUsecaseRequestImpl linkUsecaseRequestImpl = new LinkUsecaseRequestImpl();

        linkUsecaseRequestImpl.setLinkUsecaseRequestId(linkUsecaseRequestId);
        linkUsecaseRequestImpl.setRequest_id(request_id);
        linkUsecaseRequestImpl.setRecordId(recordId);
        linkUsecaseRequestImpl.setWeight(weight);
        linkUsecaseRequestImpl.setSample(sample);

        linkUsecaseRequestImpl.resetOriginalValues();

        return linkUsecaseRequestImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        linkUsecaseRequestId = objectInput.readLong();
        request_id = objectInput.readLong();
        recordId = objectInput.readLong();
        weight = objectInput.readDouble();
        sample = objectInput.readBoolean();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(linkUsecaseRequestId);
        objectOutput.writeLong(request_id);
        objectOutput.writeLong(recordId);
        objectOutput.writeDouble(weight);
        objectOutput.writeBoolean(sample);
    }
}
