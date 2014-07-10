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

import com.liferay.sample.model.Scenario;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Scenario in entity cache.
 *
 * @author sana
 * @see Scenario
 * @generated
 */
public class ScenarioCacheModel implements CacheModel<Scenario>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{scenario_id=");
		sb.append(scenario_id);
		sb.append(", name=");
		sb.append(name);
		sb.append(", simulation_id=");
		sb.append(simulation_id);
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

		scenarioImpl.setSimulation_id(simulation_id);

		scenarioImpl.resetOriginalValues();

		return scenarioImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		scenario_id = objectInput.readLong();
		name = objectInput.readUTF();
		simulation_id = objectInput.readLong();
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

		objectOutput.writeLong(simulation_id);
	}

	public long scenario_id;
	public String name;
	public long simulation_id;
}