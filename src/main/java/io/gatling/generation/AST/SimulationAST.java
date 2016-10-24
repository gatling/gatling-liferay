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
package io.gatling.generation.AST;

import io.gatling.generation.service.SourceCodeIdentifierServices;
import io.gatling.liferay.util.LiferayUtil;

import java.util.List;


/*
 * TODO: In a future design, The mustache template should maybe
 * desapear and the class should handles itself the generation.
 */

/**
 * A Simulation AST defines the structure of a simulation.
 * This class is used to generate the source code that must be
 * run in Gatling.
 * The generation will use a Mustache template.
 */
public class SimulationAST {

	private String simulationName;
	private List<ScenarioAST> scenariosAST;
	private String portalURL;
	
	
	public SimulationAST(String simulationName, List<ScenarioAST> scenarios, String portalURL) {
		this.simulationName = SourceCodeIdentifierServices.createVariableName("", simulationName);
		scenariosAST = scenarios;
		this.portalURL = portalURL;
	}

	/* Getters and Setters */
	
	/**
	 * Gets the simulation's name.
	 * @return The simulation's name
	 */
	public String getSimulationName() {
		return simulationName;
	}

	/**
	 * Sets the simulation's name.
	 * @param simulationName The simulation's name
	 */
	public void setSimulationName(String simulationName) {
		this.simulationName = simulationName;
	}
	
	/**
	 * Gets the portal's URL of this simulation.
	 * @return the portal's URL of this simulation
	 */
	public String getPortalURL() {
		return portalURL;
	}

	/**
	 * Sets the portal's URL of this simulation.
	 * @param portalURL the portal's URL of this simulation
	 */
	public void setPortalURL(String portalURL) {
		this.portalURL = portalURL;
	}

	/**
	 * Returns the scenarios contained in this simulation.
	 * @return the simulation's scenarios
	 */
	public List<ScenarioAST> getScenarios() {
		return scenariosAST;
	}

	/**
	 * Sets the scenarios AST
	 * @param scenarios The scenarios AST
	 */
	public void setScenarios(List<ScenarioAST> scenarios) {
		this.scenariosAST = scenarios;
	}
	
	/**
	 * GetInjection code computes the scala code related to te injection
	 * 
	 * It goes through all the scenarios in order to generate the scala injection section
	 * NOTE: at this moment all the scenarios injections are the same (a single profile is set in the view),
	 *
	 * @return the injection code
	 */
	public String getInjectionCode() {
		StringBuilder sb = new StringBuilder();
		int i = 0;
		for (ScenarioAST scenarioAST : scenariosAST) {
			sb.append(scenarioAST.getScenarioName())
				.append(".inject(")
				.append(scenarioAST.getInjectionCode())
				.append(")");
			i++;
			if (i != scenariosAST.size()) {
				sb.append(",\n    ");
			}
		}
		
		return sb.toString();
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("\n");
		sb.append("Simulation name: ");
		sb.append(this.simulationName);
		sb.append("Scenarios: \n[");
		for(ScenarioAST scenarioAST : scenariosAST) {
			sb.append(scenarioAST.toString());
			sb.append(",\t");
		}
		sb.append("\n]");
		sb.append("portalURL: ");
		sb.append(this.portalURL);
		return sb.toString();
	}
	


}
