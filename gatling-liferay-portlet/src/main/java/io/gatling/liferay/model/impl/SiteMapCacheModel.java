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
