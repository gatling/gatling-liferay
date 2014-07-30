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

import com.excilys.liferay.gatling.model.Simulation;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Simulation in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Simulation
 * @generated
 */
public class SimulationCacheModel implements CacheModel<Simulation>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{simulation_id=");
		sb.append(simulation_id);
		sb.append(", name=");
		sb.append(name);
		sb.append(", variableName=");
		sb.append(variableName);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Simulation toEntityModel() {
		SimulationImpl simulationImpl = new SimulationImpl();

		simulationImpl.setSimulation_id(simulation_id);

		if (name == null) {
			simulationImpl.setName(StringPool.BLANK);
		}
		else {
			simulationImpl.setName(name);
		}

		if (variableName == null) {
			simulationImpl.setVariableName(StringPool.BLANK);
		}
		else {
			simulationImpl.setVariableName(variableName);
		}

		simulationImpl.resetOriginalValues();

		return simulationImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		simulation_id = objectInput.readLong();
		name = objectInput.readUTF();
		variableName = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(simulation_id);

		if (name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (variableName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(variableName);
		}
	}

	public long simulation_id;
	public String name;
	public String variableName;
}