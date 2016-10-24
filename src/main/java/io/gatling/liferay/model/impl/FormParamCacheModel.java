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

import io.gatling.liferay.model.FormParam;

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
    public String data;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(7);

        sb.append("{formParamId=");
        sb.append(formParamId);
        sb.append(", urlRecordId=");
        sb.append(urlRecordId);
        sb.append(", data=");
        sb.append(data);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public FormParam toEntityModel() {
        FormParamImpl formParamImpl = new FormParamImpl();

        formParamImpl.setFormParamId(formParamId);
        formParamImpl.setUrlRecordId(urlRecordId);

        if (data == null) {
            formParamImpl.setData(StringPool.BLANK);
        } else {
            formParamImpl.setData(data);
        }

        formParamImpl.resetOriginalValues();

        return formParamImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        formParamId = objectInput.readLong();
        urlRecordId = objectInput.readLong();
        data = objectInput.readUTF();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(formParamId);
        objectOutput.writeLong(urlRecordId);

        if (data == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(data);
        }
    }
}
