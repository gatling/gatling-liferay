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

import com.excilys.liferay.gatling.model.Scenario;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Scenario in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Scenario
 * @generated
 */
public class ScenarioCacheModel implements CacheModel<Scenario>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{scenario_id=");
		sb.append(scenario_id);
		sb.append(", name=");
		sb.append(name);
		sb.append(", url_site=");
		sb.append(url_site);
		sb.append(", group_id=");
		sb.append(group_id);
		sb.append(", simulation_id=");
		sb.append(simulation_id);
		sb.append(", numberOfUsers=");
		sb.append(numberOfUsers);
		sb.append(", duration=");
		sb.append(duration);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Scenario toEntityModel() {
		ScenarioImpl scenarioImpl = new ScenarioImpl();

		scenarioImpl.setScenario_id(scenario_id);

		if (name == null) {
			scenarioImpl.setName(StringPool.BLANK);
		}
		else {
			scenarioImpl.setName(name);
		}

		if (url_site == null) {
			scenarioImpl.setUrl_site(StringPool.BLANK);
		}
		else {
			scenarioImpl.setUrl_site(url_site);
		}

		scenarioImpl.setGroup_id(group_id);
		scenarioImpl.setSimulation_id(simulation_id);
		scenarioImpl.setNumberOfUsers(numberOfUsers);
		scenarioImpl.setDuration(duration);

		scenarioImpl.resetOriginalValues();

		return scenarioImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		scenario_id = objectInput.readLong();
		name = objectInput.readUTF();
		url_site = objectInput.readUTF();
		group_id = objectInput.readLong();
		simulation_id = objectInput.readLong();
		numberOfUsers = objectInput.readLong();
		duration = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(scenario_id);

		if (name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (url_site == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(url_site);
		}

		objectOutput.writeLong(group_id);
		objectOutput.writeLong(simulation_id);
		objectOutput.writeLong(numberOfUsers);
		objectOutput.writeLong(duration);
	}

	public long scenario_id;
	public String name;
	public String url_site;
	public long group_id;
	public long simulation_id;
	public long numberOfUsers;
	public long duration;
}