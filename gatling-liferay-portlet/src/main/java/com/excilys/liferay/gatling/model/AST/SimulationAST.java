package com.excilys.liferay.gatling.model.AST;

import com.excilys.liferay.gatling.model.Simulation;
import com.excilys.liferay.gatling.util.GatlingUtil;

import java.util.List;

public class SimulationAST {

	private String simulationName;
	private List<ScenarioAST> scenariosAST;
	private String loginPageURL;
	private String logoutPageURL;
	
	
	public SimulationAST(Simulation simulation, List<ScenarioAST> scenarios, String portalURL) throws Exception {
		this.simulationName = GatlingUtil.createSimulationVariable(simulation.getName());
		scenariosAST = scenarios;
		this.loginPageURL = new StringBuilder(portalURL).append("/home").toString();
		this.logoutPageURL = portalURL;
	}

	/* Getters and Setters */
	
	public String getSimulationName() {
		return simulationName;
	}

	public void setSimulationName(String simulationName) {
		this.simulationName = simulationName;
	}
	
	public String getLoginPageURL() {
		return loginPageURL;
	}

	public void setLoginPageURL(String loginPageURL) {
		this.loginPageURL = loginPageURL;
	}

	public String getLogoutPageURL() {
		return logoutPageURL;
	}

	public void setLogoutPageURL(String logoutPageURL) {
		this.logoutPageURL = logoutPageURL;
	}

	public List<ScenarioAST> getMustacheScenarios() {
		return scenariosAST;
	}

	public void setMustacheScenarios(List<ScenarioAST> scenario) {
		this.scenariosAST = scenario;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Simulation name: ");
		sb.append(this.simulationName);
		sb.append("Scenarios: \n[");
		for(ScenarioAST scenarioAST : scenariosAST) {
			sb.append(scenarioAST.toString());
			sb.append(",\t");
		}
		sb.append("\n]");
		sb.append("LoginPage: ");
		sb.append(this.loginPageURL);
		sb.append("LogoutPage: ");
		sb.append(this.logoutPageURL);
		return sb.toString();
	}
	

}
