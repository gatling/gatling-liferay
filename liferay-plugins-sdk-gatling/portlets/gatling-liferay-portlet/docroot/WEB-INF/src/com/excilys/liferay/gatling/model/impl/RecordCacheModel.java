/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.excilys.liferay.gatling.model.impl;

import com.excilys.liferay.gatling.model.Record;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

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
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{recordId=");
		sb.append(recordId);
		sb.append(", portletId=");
		sb.append(portletId);
		sb.append(", versionLiferay=");
		sb.append(versionLiferay);
		sb.append(", name=");
		sb.append(name);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Record toEntityModel() {
		RecordImpl recordImpl = new RecordImpl();

		recordImpl.setRecordId(recordId);
		recordImpl.setPortletId(portletId);
		recordImpl.setVersionLiferay(versionLiferay);

		if (name == null) {
			recordImpl.setName(StringPool.BLANK);
		}
		else {
			recordImpl.setName(name);
		}

		recordImpl.resetOriginalValues();

		return recordImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		recordId = objectInput.readLong();
		portletId = objectInput.readLong();
		versionLiferay = objectInput.readLong();
		name = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(recordId);
		objectOutput.writeLong(portletId);
		objectOutput.writeLong(versionLiferay);

		if (name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(name);
		}
	}

	public long recordId;
	public long portletId;
	public long versionLiferay;
	public String name;
}