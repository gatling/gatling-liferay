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

import com.excilys.liferay.gatling.model.UrlUsecase;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing UrlUsecase in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see UrlUsecase
 * @generated
 */
public class UrlUsecaseCacheModel implements CacheModel<UrlUsecase>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{urlUsecaseId=");
		sb.append(urlUsecaseId);
		sb.append(", usecaseId=");
		sb.append(usecaseId);
		sb.append(", url=");
		sb.append(url);
		sb.append(", order=");
		sb.append(order);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public UrlUsecase toEntityModel() {
		UrlUsecaseImpl urlUsecaseImpl = new UrlUsecaseImpl();

		urlUsecaseImpl.setUrlUsecaseId(urlUsecaseId);
		urlUsecaseImpl.setUsecaseId(usecaseId);

		if (url == null) {
			urlUsecaseImpl.setUrl(StringPool.BLANK);
		}
		else {
			urlUsecaseImpl.setUrl(url);
		}

		urlUsecaseImpl.setOrder(order);

		urlUsecaseImpl.resetOriginalValues();

		return urlUsecaseImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		urlUsecaseId = objectInput.readLong();
		usecaseId = objectInput.readLong();
		url = objectInput.readUTF();
		order = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(urlUsecaseId);
		objectOutput.writeLong(usecaseId);

		if (url == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(url);
		}

		objectOutput.writeInt(order);
	}

	public long urlUsecaseId;
	public long usecaseId;
	public String url;
	public int order;
}