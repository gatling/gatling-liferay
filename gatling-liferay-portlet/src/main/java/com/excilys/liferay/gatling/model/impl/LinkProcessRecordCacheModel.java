package com.excilys.liferay.gatling.model.impl;

import com.excilys.liferay.gatling.model.LinkProcessRecord;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing LinkProcessRecord in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see LinkProcessRecord
 * @generated
 */
public class LinkProcessRecordCacheModel implements CacheModel<LinkProcessRecord>,
    Externalizable {
    public long link_process_record_id;
    public long process_id;
    public long recordId;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(7);

        sb.append("{link_process_record_id=");
        sb.append(link_process_record_id);
        sb.append(", process_id=");
        sb.append(process_id);
        sb.append(", recordId=");
        sb.append(recordId);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public LinkProcessRecord toEntityModel() {
        LinkProcessRecordImpl linkProcessRecordImpl = new LinkProcessRecordImpl();

        linkProcessRecordImpl.setLink_process_record_id(link_process_record_id);
        linkProcessRecordImpl.setProcess_id(process_id);
        linkProcessRecordImpl.setRecordId(recordId);

        linkProcessRecordImpl.resetOriginalValues();

        return linkProcessRecordImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        link_process_record_id = objectInput.readLong();
        process_id = objectInput.readLong();
        recordId = objectInput.readLong();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(link_process_record_id);
        objectOutput.writeLong(process_id);
        objectOutput.writeLong(recordId);
    }
}
