package com.excilys.liferay.gatling.validator;



import com.excilys.liferay.gatling.model.Simulation;
import com.excilys.liferay.gatling.service.SimulationLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.Validator;

import java.util.ArrayList;
import java.util.List;

public class SimulationValidator {

	
	private static final String PREFIX = "simulation";
	/**
	 * 
	 * @param simulation
	 * @return error list
	 * @throws SystemException
	 */
	public static List<String> validateSimulation(Simulation simulation) throws SystemException {
		List<String> errors = new ArrayList<String>();

		if (Validator.isNull(simulation.getName())) {
			errors.add("simulation-name-required");
		}

		if (!SimulationLocalServiceUtil.isNameUnique(simulation.getName())) {
			errors.add("simulation-name-already-used");
		}

		if ( Validator.isNull(simulation.getVariableName().substring(PREFIX.length()))) {
			errors.add("simulation-variable-required");
		}
		else if ( ! Validator.isAlphanumericName(simulation.getVariableName())) {
			errors.add("simulation-variable-syntaxe");
		}
		return errors;
	}

}