package com.excilys.liferay.gatling.model;

import com.liferay.portal.model.PersistedModel;

/**
 * The extended model interface for the Scenario service. Represents a row in the &quot;StressTool_Scenario&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see ScenarioModel
 * @see com.excilys.liferay.gatling.model.impl.ScenarioImpl
 * @see com.excilys.liferay.gatling.model.impl.ScenarioModelImpl
 * @generated
 */
public interface Scenario extends ScenarioModel, PersistedModel {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this interface directly. Add methods to {@link com.excilys.liferay.gatling.model.impl.ScenarioImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
     */
    public boolean isComplete();
}
