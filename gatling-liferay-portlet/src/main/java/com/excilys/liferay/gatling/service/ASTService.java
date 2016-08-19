package com.excilys.liferay.gatling.service;

import com.excilys.liferay.gatling.model.Scenario;
import com.excilys.liferay.gatling.model.Simulation;
import com.excilys.liferay.gatling.model.AST.ScenarioAST;
import com.excilys.liferay.gatling.model.AST.SimulationAST;
import com.excilys.liferay.gatling.model.AST.process.ProcessAST;
import com.excilys.liferay.gatling.service.mapper.ASTMapper;
import com.excilys.liferay.gatling.util.GatlingUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ASTService {

	public static SimulationAST generateScriptAST(long simulationId,String portalURL) throws Exception {
		Simulation simulation = SimulationLocalServiceUtil.getSimulation(simulationId);
		List<ScenarioAST> scenarios = initScenarios(simulationId);
		String simulationName = GatlingUtil.createSimulationVariable(simulation.getName());
		return  new SimulationAST(simulationName, scenarios, portalURL);
	}
	
	/* Script Generation */
	public static List<ScenarioAST> initScenarios(Long simulationId) throws SystemException, PortalException {
		List<ScenarioAST> mustacheScenarios;
		List<Scenario> listScenario = ScenarioLocalServiceUtil.findBySimulationId(simulationId);
		
		mustacheScenarios = new ArrayList<>();
		for (Scenario scenario : listScenario) {
			String name = GatlingUtil.createScenarioVariable(scenario.getName());
			List<com.excilys.liferay.gatling.model.Process> processes = ProcessLocalServiceUtil.findProcessFromScenarioId(scenario.getScenario_id());
			List<ProcessAST> processASTs = new ArrayList<>();
			for (com.excilys.liferay.gatling.model.Process process : processes) {
				processASTs.add(ASTMapper.mapProcessToAST(process));
			}
			
			//DEBUG mode for test;
			//processASTs.add(new LoginAST());
			//processASTs.add(new LogoutAST());
			ScenarioAST dms = new ScenarioAST(name, scenario.getNumberOfUsers(), scenario.getDuration(),processASTs);
			mustacheScenarios.add(dms);
		}
		return mustacheScenarios;
	}
}
