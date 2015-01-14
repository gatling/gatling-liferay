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
		StringBundler sb = new StringBundler(11);

		sb.append("{linkUsecaseRequestId=");
		sb.append(linkUsecaseRequestId);
		sb.append(", requestId=");
		sb.append(requestId);
		sb.append(", recordId=");
		sb.append(recordId);
		sb.append(", weight=");
		sb.append(weight);
		sb.append(", sample=");
		sb.append(sample);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public LinkUsecaseRequest toEntityModel() {
		LinkUsecaseRequestImpl linkUsecaseRequestImpl = new LinkUsecaseRequestImpl();

		linkUsecaseRequestImpl.setLinkUsecaseRequestId(linkUsecaseRequestId);
		linkUsecaseRequestImpl.setRequestId(requestId);
		linkUsecaseRequestImpl.setRecordId(recordId);
		linkUsecaseRequestImpl.setWeight(weight);
		linkUsecaseRequestImpl.setSample(sample);

		linkUsecaseRequestImpl.resetOriginalValues();

		return linkUsecaseRequestImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		linkUsecaseRequestId = objectInput.readLong();
		requestId = objectInput.readLong();
		recordId = objectInput.readLong();
		weight = objectInput.readDouble();
		sample = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(linkUsecaseRequestId);
		objectOutput.writeLong(requestId);
		objectOutput.writeLong(recordId);
		objectOutput.writeDouble(weight);
		objectOutput.writeBoolean(sample);
	}

	public long linkUsecaseRequestId;
	public long requestId;
	public long recordId;
	public double weight;
	public boolean sample;
}