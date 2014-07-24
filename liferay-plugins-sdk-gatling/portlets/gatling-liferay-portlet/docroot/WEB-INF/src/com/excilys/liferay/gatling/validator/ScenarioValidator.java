package com.excilys.liferay.gatling.validator;



import com.excilys.liferay.gatling.model.Scenario;
import com.excilys.liferay.gatling.service.ScenarioLocalServiceUtil;
import com.liferay.portal.kernel.util.Validator;

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

	private static final String PREFIX = "scenario";

	public static boolean validateScenario(Scenario scenario, List<String> errors) {
		boolean valid = true;

		if (Validator.isNull(scenario.getName())) {
			errors.add("scenario-name-required");
			valid = false;
		}

		if (!ScenarioLocalServiceUtil.isNameUnique(scenario.getName(), scenario.getSimulation_id())) {
			errors.add("scenario-name-already-used");
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

		if ( Validator.isNull(scenario.getVariableName().substring(PREFIX.length()))) {
			errors.add("scenario-variable-required");
			valid = false;
		}
		else if ( ! Validator.isAlphanumericName(scenario.getVariableName())) {
			errors.add("scenario-variable-syntaxe");
			valid = false;
		}

		return valid;
	}

	public static boolean validateEditScenarioDetails(Scenario scenario, List<String> errors) {
		boolean valid = true;

		if( !Validator.isNumber(Long.toString(scenario.getDuration()))) {
			errors.add("scenario-duration-required");
			valid = false;			
		}

		if( !Validator.isNumber(Long.toString(scenario.getUsers_per_seconds()))) {
			errors.add("scenario-users_per_seconds-required");
			valid = false;			
		}

		return valid;
	}

}