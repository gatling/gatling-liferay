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
package io.gatling.liferay.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import io.gatling.liferay.model.SiteMap;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing SiteMap in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see SiteMap
 * @generated
 */
public class SiteMapCacheModel implements CacheModel<SiteMap>, Externalizable {
    public long siteMapId;
    public String name;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(5);

        sb.append("{siteMapId=");
        sb.append(siteMapId);
        sb.append(", name=");
        sb.append(name);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public SiteMap toEntityModel() {
        SiteMapImpl siteMapImpl = new SiteMapImpl();

        siteMapImpl.setSiteMapId(siteMapId);

        if (name == null) {
            siteMapImpl.setName(StringPool.BLANK);
        } else {
            siteMapImpl.setName(name);
        }

        siteMapImpl.resetOriginalValues();

        return siteMapImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        siteMapId = objectInput.readLong();
        name = objectInput.readUTF();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(siteMapId);

        if (name == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(name);
        }
    }
}
