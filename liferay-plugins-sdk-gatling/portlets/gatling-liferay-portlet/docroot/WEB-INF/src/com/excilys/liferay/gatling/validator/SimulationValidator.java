package com.excilys.liferay.gatling.validator;



import com.liferay.portal.kernel.util.Validator;
import com.liferay.sample.model.Simulation;

import java.util.List;

public class SimulationValidator {

	/**
	 * Validate Simulation
	 * 
	 * @param simulation
	 *            to be validated
	 * @param errors
	 *            to populate with any errors
	 */

	public static boolean validateSimulation(Simulation simulation, List<String> errors) {
		boolean valid = true;

		if (Validator.isNull(simulation.getName())) {
			errors.add("simulation-name-required");
			valid = false;
		}
		return valid;
	}

}