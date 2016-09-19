package io.gatling.liferay.model.AST;

import io.gatling.liferay.util.GatlingUtil;

import java.util.List;

public class SimulationAST {

	private String simulationName;
	private List<ScenarioAST> scenariosAST;
	private String portalURL;
	
	
	public SimulationAST(String simulationName, List<ScenarioAST> scenarios, String portalURL) {
		this.simulationName = GatlingUtil.createVariableName("", simulationName);
		scenariosAST = scenarios;
		this.portalURL = portalURL;
	}

	/* Getters and Setters */
	
	public String getSimulationName() {
		return simulationName;
	}

	public void setSimulationName(String simulationName) {
		this.simulationName = simulationName;
	}
	
	public String getPortalURL() {
		return portalURL;
	}

	public void setPortalURL(String portalURL) {
		this.portalURL = portalURL;
	}

	public List<ScenarioAST> getScenarios() {
		return scenariosAST;
	}

	public void setMustacheScenarios(List<ScenarioAST> scenario) {
		this.scenariosAST = scenario;
	}
	
	/**
	 * GetInjection code computes the scala code related to te injection
	 * 
	 * It goes through all the scenarios in order to generate the scala injection section
	 * NOTE: at the moment all the scenarios injections are the same (a single profile is set in the view),
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
