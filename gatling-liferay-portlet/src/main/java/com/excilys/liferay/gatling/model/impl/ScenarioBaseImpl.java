package com.excilys.liferay.gatling.model.impl;

import com.excilys.liferay.gatling.model.Scenario;
import com.excilys.liferay.gatling.service.ScenarioLocalServiceUtil;

import com.liferay.portal.kernel.exception.SystemException;

/**
 * The extended model base implementation for the Scenario service. Represents a row in the &quot;StressTool_Scenario&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ScenarioImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ScenarioImpl
 * @see com.excilys.liferay.gatling.model.Scenario
 * @generated
 */
public abstract class ScenarioBaseImpl extends ScenarioModelImpl
    implements Scenario {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. All methods that expect a scenario model instance should use the {@link Scenario} interface instead.
     */
    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            ScenarioLocalServiceUtil.addScenario(this);
        } else {
            ScenarioLocalServiceUtil.updateScenario(this);
        }
    }
}
