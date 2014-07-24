package com.excilys.liferay.gatling.validator;



import com.liferay.portal.kernel.util.Validator;
import com.liferay.sample.model.Simulation;
import com.liferay.sample.service.SimulationLocalServiceUtil;

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
	private static final String PREFIX = "simulation";

	public static boolean validateSimulation(Simulation simulation, List<String> errors) {
		boolean valid = true;

		if (Validator.isNull(simulation.getName())) {
			errors.add("simulation-name-required");
			valid = false;
		}

		if (!SimulationLocalServiceUtil.isNameUnique(simulation.getName())) {
			errors.add("simulation-name-already-used");
			valid = false;
		}

		if ( Validator.isNull(simulation.getVariableName().substring(PREFIX.length()))) {
			errors.add("simulation-variable-required");
			valid = false;
		}
		else if ( ! Validator.isAlphanumericName(simulation.getVariableName())) {
			errors.add("simulation-variable-syntaxe");
			valid = false;
		}
		else {
			List<Simulation> listVar = SimulationLocalServiceUtil.findByVariableName(simulation.getVariableName());
			if(!listVar.isEmpty() ) {
				simulation.setVariableName(simulation.getVariableName()+listVar.size());
			}
		}
		return valid;
	}

}