package io.gatling.liferay.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;

import io.gatling.liferay.model.ProcessScenarioLink;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing ProcessScenarioLink in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see ProcessScenarioLink
 * @generated
 */
public class ProcessScenarioLinkCacheModel implements CacheModel<ProcessScenarioLink>,
    Externalizable {
    public long psl_id;
    public long process_id;
    public long scenario_id;
    public int order;
    public int pause;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(11);

        sb.append("{psl_id=");
        sb.append(psl_id);
        sb.append(", process_id=");
        sb.append(process_id);
        sb.append(", scenario_id=");
        sb.append(scenario_id);
        sb.append(", order=");
        sb.append(order);
        sb.append(", pause=");
        sb.append(pause);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public ProcessScenarioLink toEntityModel() {
        ProcessScenarioLinkImpl processScenarioLinkImpl = new ProcessScenarioLinkImpl();

        processScenarioLinkImpl.setPsl_id(psl_id);
        processScenarioLinkImpl.setProcess_id(process_id);
        processScenarioLinkImpl.setScenario_id(scenario_id);
        processScenarioLinkImpl.setOrder(order);
        processScenarioLinkImpl.setPause(pause);

        processScenarioLinkImpl.resetOriginalValues();

        return processScenarioLinkImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        psl_id = objectInput.readLong();
        process_id = objectInput.readLong();
        scenario_id = objectInput.readLong();
        order = objectInput.readInt();
        pause = objectInput.readInt();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(psl_id);
        objectOutput.writeLong(process_id);
        objectOutput.writeLong(scenario_id);
        objectOutput.writeInt(order);
        objectOutput.writeInt(pause);
    }
}
