package com.excilys.liferay.gatling.model;

import com.liferay.portal.model.PersistedModel;

/**
 * The extended model interface for the Simulation service. Represents a row in the &quot;StressTool_Simulation&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see SimulationModel
 * @see com.excilys.liferay.gatling.model.impl.SimulationImpl
 * @see com.excilys.liferay.gatling.model.impl.SimulationModelImpl
 * @generated
 */
public interface Simulation extends SimulationModel, PersistedModel {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this interface directly. Add methods to {@link com.excilys.liferay.gatling.model.impl.SimulationImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
     */
    public boolean isComplete();
}
