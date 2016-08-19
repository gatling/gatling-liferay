package com.excilys.liferay.gatling.service;

import com.excilys.liferay.gatling.model.Simulation;
import com.excilys.liferay.gatling.model.AST.SimulationAST;
import com.excilys.liferay.gatling.model.AST.MapperAST;
import com.excilys.liferay.gatling.model.AST.ScenarioAST;

import java.util.List;

public class ASTService {

	public static SimulationAST generateScriptAST(long simulationId,String portalURL) throws Exception {
		Simulation simulation = SimulationLocalServiceUtil.getSimulation(simulationId);
		List<ScenarioAST> scenarios = MapperAST.initScenarios(simulationId);
		return  new SimulationAST(simulation.getName(), scenarios, portalURL);
	}
}
