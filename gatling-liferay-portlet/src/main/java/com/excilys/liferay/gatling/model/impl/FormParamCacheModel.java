package com.excilys.liferay.gatling.model.impl;

import com.excilys.liferay.gatling.model.FormParam;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing FormParam in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see FormParam
 * @generated
 */
public class FormParamCacheModel implements CacheModel<FormParam>,
    Externalizable {
    public long formParamId;
    public long urlRecordId;
    public String key;
    public String value;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(9);

        sb.append("{formParamId=");
        sb.append(formParamId);
        sb.append(", urlRecordId=");
        sb.append(urlRecordId);
        sb.append(", key=");
        sb.append(key);
        sb.append(", value=");
        sb.append(value);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public FormParam toEntityModel() {
        FormParamImpl formParamImpl = new FormParamImpl();

        formParamImpl.setFormParamId(formParamId);
        formParamImpl.setUrlRecordId(urlRecordId);

        if (key == null) {
            formParamImpl.setKey(StringPool.BLANK);
        } else {
            formParamImpl.setKey(key);
        }

        if (value == null) {
            formParamImpl.setValue(StringPool.BLANK);
        } else {
            formParamImpl.setValue(value);
        }

        formParamImpl.resetOriginalValues();

        return formParamImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        formParamId = objectInput.readLong();
        urlRecordId = objectInput.readLong();
        key = objectInput.readUTF();
        value = objectInput.readUTF();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(formParamId);
        objectOutput.writeLong(urlRecordId);

        if (key == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(key);
        }

        if (value == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(value);
        }
    }
}
