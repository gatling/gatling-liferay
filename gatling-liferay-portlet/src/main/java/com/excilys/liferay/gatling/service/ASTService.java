package com.excilys.liferay.gatling.service;

import com.excilys.liferay.gatling.model.Simulation;
import com.excilys.liferay.gatling.model.AST.SimulationAST;
import com.excilys.liferay.gatling.model.AST.MapperAST;
import com.excilys.liferay.gatling.model.AST.ScenarioAST;
import com.excilys.liferay.gatling.util.GatlingUtil;

import java.util.List;

public class ASTService {

	public static SimulationAST generateScriptAST(long simulationId,String portalURL) throws Exception {
		Simulation simulation = SimulationLocalServiceUtil.getSimulation(simulationId);
		List<ScenarioAST> scenarios = MapperAST.initScenarios(simulationId);
		String simulationName = GatlingUtil.createSimulationVariable(simulation.getName());
		return  new SimulationAST(simulationName, scenarios, portalURL);
	}
}
