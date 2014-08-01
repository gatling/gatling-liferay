package com.excilys.liferay.gatling.validator;



import com.excilys.liferay.gatling.model.Scenario;
import com.excilys.liferay.gatling.service.ScenarioLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.Validator;

import java.util.ArrayList;
import java.util.List;

public class ScenarioValidator {

	private static final String PREFIX = "scenario";

	/**
	 * Validate a {@link Scenario}
	 * @param {@link Scenario} scenario 
	 * @return {@link List} errors
	 * @throws SystemException
	 */
	public static List<String> validateScenario(Scenario scenario) throws SystemException {
		List<String> errors = new ArrayList<String>();

		if (Validator.isNull(scenario.getName())) {
			errors.add("scenario-name-required");
		}

		if (!ScenarioLocalServiceUtil.isNameUnique(scenario.getName(), scenario.getSimulation_id())) {
			errors.add("scenario-name-already-used");
		}
		
		if( !Validator.isNumber(Long.toString(scenario.getDuration()))) {
			errors.add("scenario-duration-required");
		}

		if( !Validator.isNumber(Long.toString(scenario.getUsers_per_seconds()))) {
			errors.add("scenario-users_per_seconds-required");
		}

		if(Validator.isNull(scenario.getGroup_id())) {
			errors.add("scenario-groupid-missing");
		}
		
		if(Validator.isNull(scenario.getSimulation_id())) {
			errors.add("scenario-simulationid-missing");
		}

		if ( Validator.isNull(scenario.getVariableName().substring(PREFIX.length()))) {
			errors.add("scenario-variable-required");
		}
		
		else if ( ! Validator.isAlphanumericName(scenario.getVariableName())) {
			errors.add("scenario-variable-syntaxe");
		}

		return errors;
	}

}