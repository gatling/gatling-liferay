package com.excilys.liferay.gatling.model.AST;

import com.excilys.liferay.gatling.model.ProcessType;
import com.excilys.liferay.gatling.model.Scenario;
import com.excilys.liferay.gatling.model.AST.process.ProcessAST;
import com.excilys.liferay.gatling.model.AST.process.RecorderAST;
import com.excilys.liferay.gatling.service.ProcessLocalServiceUtil;
import com.excilys.liferay.gatling.service.ScenarioLocalServiceUtil;
import com.excilys.liferay.gatling.util.GatlingUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

import java.util.ArrayList;
import java.util.List;

public class MapperAST {

	public static ProcessAST mapProcessToAST(com.excilys.liferay.gatling.model.Process process) {
		ProcessAST ast= null;
		
		if (process == null)
			return null;
		
		switch(ProcessType.valueOf(process.getType())) {
			case RECORD:
				ast = new RecorderAST("myFeederMF.csv");
				break;
			default:
				//TODO change default, value = null
				ast = new RecorderAST("myDefaultFeederMF.csv");
				break;
		}
		return ast;
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
				processASTs.add(mapProcessToAST(process));
			}
			//DEBUG mode for test;
			processASTs.add(new RecorderAST("debugggggg.csv"));
			ScenarioAST dms = new ScenarioAST(name, scenario.getNumberOfUsers(), scenario.getDuration(),processASTs);
			
			mustacheScenarios.add(dms);
		}
		return mustacheScenarios;
	}
}
