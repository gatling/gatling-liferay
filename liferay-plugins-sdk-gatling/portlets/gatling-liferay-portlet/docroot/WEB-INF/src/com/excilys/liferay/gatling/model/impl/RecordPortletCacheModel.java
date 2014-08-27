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

import com.excilys.liferay.gatling.model.RecordPortlet;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing RecordPortlet in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see RecordPortlet
 * @generated
 */
public class RecordPortletCacheModel implements CacheModel<RecordPortlet>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{recordPortletId=");
		sb.append(recordPortletId);
		sb.append(", portletId=");
		sb.append(portletId);
		sb.append(", state=");
		sb.append(state);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public RecordPortlet toEntityModel() {
		RecordPortletImpl recordPortletImpl = new RecordPortletImpl();

		recordPortletImpl.setRecordPortletId(recordPortletId);

		if (portletId == null) {
			recordPortletImpl.setPortletId(StringPool.BLANK);
		}
		else {
			recordPortletImpl.setPortletId(portletId);
		}

		if (state == null) {
			recordPortletImpl.setState(StringPool.BLANK);
		}
		else {
			recordPortletImpl.setState(state);
		}

		recordPortletImpl.resetOriginalValues();

		return recordPortletImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		recordPortletId = objectInput.readLong();
		portletId = objectInput.readUTF();
		state = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(recordPortletId);

		if (portletId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(portletId);
		}

		if (state == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(state);
		}
	}

	public long recordPortletId;
	public String portletId;
	public String state;
}