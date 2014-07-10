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

package com.liferay.sample.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.liferay.sample.model.Request;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Request in entity cache.
 *
 * @author sana
 * @see Request
 * @generated
 */
public class RequestCacheModel implements CacheModel<Request>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{request_id=");
		sb.append(request_id);
		sb.append(", scenario_id=");
		sb.append(scenario_id);
		sb.append(", url=");
		sb.append(url);
		sb.append(", rate=");
		sb.append(rate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Request toEntityModel() {
		RequestImpl requestImpl = new RequestImpl();

		requestImpl.setRequest_id(request_id);
		requestImpl.setScenario_id(scenario_id);

		if (url == null) {
			requestImpl.setUrl(StringPool.BLANK);
		}
		else {
			requestImpl.setUrl(url);
		}

		requestImpl.setRate(rate);

		requestImpl.resetOriginalValues();

		return requestImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		request_id = objectInput.readLong();
		scenario_id = objectInput.readLong();
		url = objectInput.readUTF();
		rate = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(request_id);
		objectOutput.writeLong(scenario_id);

		if (url == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(url);
		}

		objectOutput.writeInt(rate);
	}

	public long request_id;
	public long scenario_id;
	public String url;
	public int rate;
}