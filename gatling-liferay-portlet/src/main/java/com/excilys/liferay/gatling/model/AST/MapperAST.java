package com.excilys.liferay.gatling.model.AST;

import com.excilys.liferay.gatling.model.ProcessType;
import com.excilys.liferay.gatling.model.Record;
import com.excilys.liferay.gatling.model.Scenario;
import com.excilys.liferay.gatling.model.AST.feeder.RecordFeederFileAST;
import com.excilys.liferay.gatling.model.AST.feeder.data.RecordDataAST;
import com.excilys.liferay.gatling.model.AST.process.LogoutAST;
import com.excilys.liferay.gatling.model.AST.process.ProcessAST;
import com.excilys.liferay.gatling.model.AST.process.RecorderAST;
import com.excilys.liferay.gatling.service.ProcessLocalServiceUtil;
import com.excilys.liferay.gatling.service.RecordLocalServiceUtil;
import com.excilys.liferay.gatling.service.ScenarioLocalServiceUtil;
import com.excilys.liferay.gatling.util.GatlingUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

import java.util.ArrayList;
import java.util.List;

public class MapperAST {

	public static ProcessAST mapProcessToAST(com.excilys.liferay.gatling.model.Process process) throws PortalException, SystemException {
		ProcessAST ast = null;
		
		if (process == null)
			return null;
		
		switch(ProcessType.valueOf(process.getType())) {
			case RECORD:
				
				//TODO: Move the service Call in ServiceAST (Not the job of the mapper)
				Record record = RecordLocalServiceUtil.getRecord(process.getRecordId());
				
				RecordFeederFileAST feeder = mapRecordToAST(record);
				ast = new RecorderAST(feeder);
				break;
			default:
				ast = new LogoutAST();
				break;
		}
		return ast;
	}
	
	public static RecordFeederFileAST mapRecordToAST(Record record){
		String name = record.getName();
		
		//TODO: Compute the data
		List<RecordDataAST> data = new ArrayList<>();
		
		return new RecordFeederFileAST(name, data);
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
			processASTs.add(new LogoutAST());
			ScenarioAST dms = new ScenarioAST(name, scenario.getNumberOfUsers(), scenario.getDuration(),processASTs);
			mustacheScenarios.add(dms);
		}
		return mustacheScenarios;
	}
}
