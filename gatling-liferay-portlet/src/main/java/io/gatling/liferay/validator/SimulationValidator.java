/**
 * Copyright 2015 Altendis, Groupe Excilys (www.altendis.fr)
 */
package io.gatling.liferay.validator;



import java.util.ArrayList;
import java.util.List;

import io.gatling.liferay.model.Simulation;
import io.gatling.liferay.service.SimulationLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.Validator;

public class SimulationValidator {

	/**
	 * Validate a {@link Simulation}
	 * 
	 * @param {@link Simulation} simulation
	 * @return {@link List} errors
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

		return errors;
	}

}