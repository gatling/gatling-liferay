/**
 * Copyright 2015 Altendis, Groupe Excilys (www.altendis.fr)
 */
package com.excilys.liferay.gatling.util;

import java.util.List;

import com.excilys.liferay.gatling.model.Scenario;
import com.excilys.liferay.gatling.model.Simulation;
import com.excilys.liferay.gatling.service.RequestLocalServiceUtil;
import com.excilys.liferay.gatling.service.ScenarioLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

public class ControllerUtil {

	private static final Log LOG = LogFactoryUtil.getLog(ControllerUtil.class);
	
	/**
	 * Get the simulation state in order to display the correct icon.
	 * @param simulation
	 * @return 0(means empty), 1(incomplete) or 2 (complete)
	 */
	public static int simulationState(final Simulation simulation) {
		try {
			final List<Scenario> scenariosList = ScenarioLocalServiceUtil.findBySimulationId(simulation.getSimulation_id());
			int checkNumberCompleted = 0;
			for (final Scenario scenario : scenariosList) {
				if (scenarioState(scenario) == 2) {
					checkNumberCompleted++;
				}
			}
			if (checkNumberCompleted == 0 || scenariosList.size() == 0) {
				//if no one scenario is completed = simulation empty
				return 0;
			} else if (checkNumberCompleted == scenariosList.size() && simulation.isComplete()) {
				//if all scenario completed = simulation completed
				return 2;
			} else {
				//other case = simulation uncompleted
				return 1;
			}
		} catch (final SystemException e) {
			if (LOG.isErrorEnabled()) {
				LOG.error("enable to determine Simulation state " + e.getMessage());
			}
			return 0;
		}
	}

	/**
	 * Get the scenario state in order to display the correct icon.
	 * @param scenario
	 * @return 0 (means empty), 1(incomplete) or 2(complete) 
	 */
	public static int scenarioState(final Scenario scenario) throws SystemException {
		final int count = RequestLocalServiceUtil.countByScenarioIdAndUsedAndIsNotPortlet(scenario.getScenario_id());
		if (count != 0 && scenario.isComplete()) {
			// completed scenario = case if all minimal information are
			// completed
			return 2;
		} else if (count != 0 && !scenario.isComplete()) {
			// incomplete scenario = case if one or more information detail of
			// scenario are not completed but there is request selected
			return 1;
		}
		// case if not request selected to that scenario = empty scenario
		return 0;
	}
}
