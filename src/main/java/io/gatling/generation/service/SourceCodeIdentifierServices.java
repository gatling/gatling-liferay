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
