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

import com.excilys.liferay.gatling.model.LinkUsecaseRequest;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing LinkUsecaseRequest in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see LinkUsecaseRequest
 * @generated
 */
public class LinkUsecaseRequestCacheModel implements CacheModel<LinkUsecaseRequest>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{linkUsecaseRequestId=");
		sb.append(linkUsecaseRequestId);
		sb.append(", request_id=");
		sb.append(request_id);
		sb.append(", usecaseId=");
		sb.append(usecaseId);
		sb.append(", weight=");
		sb.append(weight);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public LinkUsecaseRequest toEntityModel() {
		LinkUsecaseRequestImpl linkUsecaseRequestImpl = new LinkUsecaseRequestImpl();

		linkUsecaseRequestImpl.setLinkUsecaseRequestId(linkUsecaseRequestId);
		linkUsecaseRequestImpl.setRequest_id(request_id);
		linkUsecaseRequestImpl.setUsecaseId(usecaseId);
		linkUsecaseRequestImpl.setWeight(weight);

		linkUsecaseRequestImpl.resetOriginalValues();

		return linkUsecaseRequestImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		linkUsecaseRequestId = objectInput.readLong();
		request_id = objectInput.readLong();
		usecaseId = objectInput.readLong();
		weight = objectInput.readDouble();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(linkUsecaseRequestId);
		objectOutput.writeLong(request_id);
		objectOutput.writeLong(usecaseId);
		objectOutput.writeDouble(weight);
	}

	public long linkUsecaseRequestId;
	public long request_id;
	public long usecaseId;
	public double weight;
}