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

import com.excilys.liferay.gatling.model.Usecase;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Usecase in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Usecase
 * @generated
 */
public class UsecaseCacheModel implements CacheModel<Usecase>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{usecaseId=");
		sb.append(usecaseId);
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
	public Usecase toEntityModel() {
		UsecaseImpl usecaseImpl = new UsecaseImpl();

		usecaseImpl.setUsecaseId(usecaseId);
		usecaseImpl.setPortletId(portletId);
		usecaseImpl.setVersionPortlet(versionPortlet);

		if (name == null) {
			usecaseImpl.setName(StringPool.BLANK);
		}
		else {
			usecaseImpl.setName(name);
		}

		usecaseImpl.resetOriginalValues();

		return usecaseImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		usecaseId = objectInput.readLong();
		portletId = objectInput.readLong();
		versionPortlet = objectInput.readLong();
		name = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(usecaseId);
		objectOutput.writeLong(portletId);
		objectOutput.writeLong(versionPortlet);

		if (name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(name);
		}
	}

	public long usecaseId;
	public long portletId;
	public long versionPortlet;
	public String name;
}