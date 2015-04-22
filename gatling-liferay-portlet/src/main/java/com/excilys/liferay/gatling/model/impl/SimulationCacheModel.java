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
    public long simulation_id;
    public String name;
    public String feederContent;
    public boolean isFeederAFile;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(9);

        sb.append("{simulation_id=");
        sb.append(simulation_id);
        sb.append(", name=");
        sb.append(name);
        sb.append(", feederContent=");
        sb.append(feederContent);
        sb.append(", isFeederAFile=");
        sb.append(isFeederAFile);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public Simulation toEntityModel() {
        SimulationImpl simulationImpl = new SimulationImpl();

        simulationImpl.setSimulation_id(simulation_id);

        if (name == null) {
            simulationImpl.setName(StringPool.BLANK);
        } else {
            simulationImpl.setName(name);
        }

        if (feederContent == null) {
            simulationImpl.setFeederContent(StringPool.BLANK);
        } else {
            simulationImpl.setFeederContent(feederContent);
        }

        simulationImpl.setIsFeederAFile(isFeederAFile);

        simulationImpl.resetOriginalValues();

        return simulationImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        simulation_id = objectInput.readLong();
        name = objectInput.readUTF();
        feederContent = objectInput.readUTF();
        isFeederAFile = objectInput.readBoolean();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(simulation_id);

        if (name == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(name);
        }

        if (feederContent == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(feederContent);
        }

        objectOutput.writeBoolean(isFeederAFile);
    }
}
