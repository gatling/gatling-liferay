package com.excilys.liferay.gatling.mustache;

import com.excilys.liferay.gatling.model.Scenario;
import com.excilys.liferay.gatling.model.Simulation;
import com.excilys.liferay.gatling.model.AST.ScenarioAST;
import com.excilys.liferay.gatling.service.ScenarioLocalServiceUtil;
import com.excilys.liferay.gatling.service.SimulationLocalServiceUtil;
import com.excilys.liferay.gatling.util.GatlingUtil;
import com.liferay.portal.kernel.exception.SystemException;

import java.util.ArrayList;
import java.util.List;

public class DefaultMustachScript {

	private String simulationName;
	private List<ScenarioAST> mustacheScenarios;
	private String loginPageURL;
	private String logoutPageURL;
	
	
	public DefaultMustachScript(Long simulationId, String portalURL) throws Exception {
		Simulation simulation = SimulationLocalServiceUtil.getSimulation(simulationId);
		this.simulationName = GatlingUtil.createSimulationVariable(simulation.getName());
		initScenarios(simulationId);
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
		return mustacheScenarios;
	}

	public void setMustacheScenarios(List<ScenarioAST> scenario) {
		this.mustacheScenarios = scenario;
	}
	
	
	/* Script Generation */
	
	private void initScenarios(Long simulationId) throws SystemException {
		List<Scenario> listScenario = ScenarioLocalServiceUtil.findBySimulationId(simulationId);
		mustacheScenarios = new ArrayList<>();
		for (Scenario scenario : listScenario) {
			String name = GatlingUtil.createScenarioVariable(scenario.getName());
			ScenarioAST dms = new ScenarioAST(name, scenario.getNumberOfUsers(), scenario.getDuration());
			mustacheScenarios.add(dms);
		}
	}

}
