/**
 * Copyright 2011-2015 GatlingCorp (http://gatling.io)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * 		http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
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