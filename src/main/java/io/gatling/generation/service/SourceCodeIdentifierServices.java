/**
 * Copyright 2011-2016 GatlingCorp (http://gatling.io)
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
package io.gatling.generation.service;

import com.liferay.portal.kernel.util.StringUtil;

/**
 * This class contains some functionalities to compute identifier name
 * to use in the resulting generated code.
 */
public class SourceCodeIdentifierServices {
	
	/**
	 * create variable name for gatling scenario
	 * Example: "my variable_name" becomes "PrefixMyVariableName"
	 * @param prefix The prefix to insert in the begining of the returned scenario name
	 * @param name The initial name
	 * @return The modified name
	 */
	public static String createVariableName(String prefix, String name) {
		if (!name.isEmpty() && name.charAt(0)=='_') {
			//Hack if the name starts with '_' which causes an Error if not processed
			name = name.substring(1); 
		}
		
		// Create variable name
		String[] tab = name.trim().split("[_\\s]");
		StringBuffer sb = new StringBuffer(prefix);
		for (String string : tab) {
			
			/*
			 * TODO: It would be really good to remove all liferay dependencies
			 * 		inside the io.gatling.generation Package.
			 * 
			 * This would permit to seperate generation functionalities and permit
			 * to use maven multi-modules :
			 * Code generation could then be used in other dirived projects.
			 */
			
			sb.append(StringUtil.upperCaseFirstLetter(string));
		}
		return sb.toString();
	}

	/**
	 * Computes the scenario variable name by appending the 
	 * prefix "scenario".
	 * @param name The name of the variable
	 * @return The scenario variable
	 */
	public static String createScenarioVariable(String name) {
		return createVariableName("Scenario", name);
	}

	/**
	 * Computes the simulation variable name by appending the
	 * prefix "Simulation".
	 * @param name The name of the variable
	 * @return The simulation variable
	 */
	public static String createSimulationVariable(String name) {
		return createVariableName("Simulation", name);
	}
	
}
