package com.excilys.liferay.gatling.validator;



import com.liferay.portal.kernel.util.Validator;
import com.liferay.sample.model.Scenario;

import java.util.List;

public class ScenarioValidator {

	/**
	 * Validate Scenario
	 * 
	 * @param simulation
	 *            to be validated
	 * @param errors
	 *            to populate with any errors
	 */

	public static boolean validateScenario(Scenario scenario, List<String> errors) {
		boolean valid = true;

		if (Validator.isNull(scenario.getName())) {
			errors.add("scenario-name-required");
			valid = false;
		}

		if(Validator.isNull(scenario.getGroup_id())) {
			errors.add("scenario-groupid-missing");
			valid = false;
		}
		if(Validator.isNull(scenario.getSimulation_id())) {
			errors.add("scenario-simulationid-missing");
			valid = false;
		}
		
		
		return valid;
	}

}