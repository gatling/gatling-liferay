/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 *
 *
 *
 */

package com.excilys.liferay.gatling.model.impl;

import com.excilys.liferay.gatling.model.Request;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Request in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Request
 * @generated
 */
public class RequestCacheModel implements CacheModel<Request>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{request_id=");
		sb.append(request_id);
		sb.append(", scenario_id=");
		sb.append(scenario_id);
		sb.append(", name=");
		sb.append(name);
		sb.append(", url=");
		sb.append(url);
		sb.append(", weight=");
		sb.append(weight);
		sb.append(", privatePage=");
		sb.append(privatePage);
		sb.append(", parentLayoutId=");
		sb.append(parentLayoutId);
		sb.append(", layoutId=");
		sb.append(layoutId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Request toEntityModel() {
		RequestImpl requestImpl = new RequestImpl();

		requestImpl.setRequest_id(request_id);
		requestImpl.setScenario_id(scenario_id);

		if (name == null) {
			requestImpl.setName(StringPool.BLANK);
		}
		else {
			requestImpl.setName(name);
		}

		if (url == null) {
			requestImpl.setUrl(StringPool.BLANK);
		}
		else {
			requestImpl.setUrl(url);
		}

		requestImpl.setWeight(weight);
		requestImpl.setPrivatePage(privatePage);
		requestImpl.setParentLayoutId(parentLayoutId);
		requestImpl.setLayoutId(layoutId);

		requestImpl.resetOriginalValues();

		return requestImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		request_id = objectInput.readLong();
		scenario_id = objectInput.readLong();
		name = objectInput.readUTF();
		url = objectInput.readUTF();
		weight = objectInput.readDouble();
		privatePage = objectInput.readBoolean();
		parentLayoutId = objectInput.readLong();
		layoutId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(request_id);
		objectOutput.writeLong(scenario_id);

		if (name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (url == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(url);
		}

		objectOutput.writeDouble(weight);
		objectOutput.writeBoolean(privatePage);
		objectOutput.writeLong(parentLayoutId);
		objectOutput.writeLong(layoutId);
	}

	public long request_id;
	public long scenario_id;
	public String name;
	public String url;
	public double weight;
	public boolean privatePage;
	public long parentLayoutId;
	public long layoutId;
}