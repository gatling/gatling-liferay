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
package io.gatling.liferay.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import io.gatling.liferay.model.Record;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Record in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Record
 * @generated
 */
public class RecordCacheModel implements CacheModel<Record>, Externalizable {
    public long recordId;
    public String portletId;
    public String versionPortlet;
    public String name;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(9);

        sb.append("{recordId=");
        sb.append(recordId);
        sb.append(", portletId=");
        sb.append(portletId);
        sb.append(", versionPortlet=");
        sb.append(versionPortlet);
        sb.append(", name=");
        sb.append(name);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public Record toEntityModel() {
        RecordImpl recordImpl = new RecordImpl();

        recordImpl.setRecordId(recordId);

        if (portletId == null) {
            recordImpl.setPortletId(StringPool.BLANK);
        } else {
            recordImpl.setPortletId(portletId);
        }

        if (versionPortlet == null) {
            recordImpl.setVersionPortlet(StringPool.BLANK);
        } else {
            recordImpl.setVersionPortlet(versionPortlet);
        }

        if (name == null) {
            recordImpl.setName(StringPool.BLANK);
        } else {
            recordImpl.setName(name);
        }

        recordImpl.resetOriginalValues();

        return recordImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        recordId = objectInput.readLong();
        portletId = objectInput.readUTF();
        versionPortlet = objectInput.readUTF();
        name = objectInput.readUTF();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(recordId);

        if (portletId == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(portletId);
        }

        if (versionPortlet == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(versionPortlet);
        }

        if (name == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(name);
        }
    }
}
