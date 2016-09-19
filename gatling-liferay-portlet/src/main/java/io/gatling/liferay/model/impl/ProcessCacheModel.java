package io.gatling.liferay.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import io.gatling.liferay.model.Process;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Process in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Process
 * @generated
 */
public class ProcessCacheModel implements CacheModel<Process>, Externalizable {
    public long process_id;
    public String name;
    public String type;
    public Long feederId;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(9);

        sb.append("{process_id=");
        sb.append(process_id);
        sb.append(", name=");
        sb.append(name);
        sb.append(", type=");
        sb.append(type);
        sb.append(", feederId=");
        sb.append(feederId);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public Process toEntityModel() {
        ProcessImpl processImpl = new ProcessImpl();

        processImpl.setProcess_id(process_id);

        if (name == null) {
            processImpl.setName(StringPool.BLANK);
        } else {
            processImpl.setName(name);
        }

        if (type == null) {
            processImpl.setType(StringPool.BLANK);
        } else {
            processImpl.setType(type);
        }

        processImpl.setFeederId(feederId);

        processImpl.resetOriginalValues();

        return processImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        process_id = objectInput.readLong();
        name = objectInput.readUTF();
        type = objectInput.readUTF();
        feederId = objectInput.readLong();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(process_id);

        if (name == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(name);
        }

        if (type == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(type);
        }

        objectOutput.writeLong(feederId);
    }
}
