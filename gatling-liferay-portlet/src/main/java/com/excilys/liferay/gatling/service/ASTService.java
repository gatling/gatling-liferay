package com.excilys.liferay.gatling.service;

import com.excilys.liferay.gatling.NoSuchFormParamException;
import com.excilys.liferay.gatling.model.FormParam;
import com.excilys.liferay.gatling.model.Record;
import com.excilys.liferay.gatling.model.Scenario;
import com.excilys.liferay.gatling.model.Simulation;
import com.excilys.liferay.gatling.model.UrlRecord;
import com.excilys.liferay.gatling.model.AST.ScenarioAST;
import com.excilys.liferay.gatling.model.AST.SimulationAST;
import com.excilys.liferay.gatling.model.AST.feeder.HttpBodyFileAST;
import com.excilys.liferay.gatling.model.AST.feeder.RecordFeederFileAST;
import com.excilys.liferay.gatling.model.AST.feeder.ResourceFileAST;
import com.excilys.liferay.gatling.model.AST.feeder.data.RecordDataAST;
import com.excilys.liferay.gatling.model.AST.process.ProcessAST;
import com.excilys.liferay.gatling.service.mapper.ASTMapper;
import com.excilys.liferay.gatling.util.GatlingUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

import java.util.ArrayList;
import java.util.List;

public class ASTService {

	public static SimulationAST computesSimulationAST(long simulationId, String portalURL) throws Exception {
		Simulation simulation = SimulationLocalServiceUtil.getSimulation(simulationId);
		List<ScenarioAST> scenarios = initScenarios(simulationId);
		String simulationName = GatlingUtil.createSimulationVariable(simulation.getName());
		return  new SimulationAST(simulationName, scenarios, portalURL);
	}
	
	public static RecordFeederFileAST computesRecordFeederFileAST(long recordId) throws PortalException, SystemException{
		Record record = RecordLocalServiceUtil.getRecord(recordId);
		return ASTMapper.mapRecordToAST(record);
	}
	
	public static List<RecordDataAST> computesRecordDataAST(long recordId) throws SystemException, NoSuchFormParamException {
		List<UrlRecord> urlRecords = UrlRecordLocalServiceUtil.findByRecordId(recordId);
		return ASTMapper.mapUrlRecordsToAST(urlRecords);
	}
	
	public static HttpBodyFileAST computesHttpBodyFileAST(long urlRecordId) throws NoSuchFormParamException, SystemException {
		FormParam params = FormParamLocalServiceUtil.findByUrlRecordId(urlRecordId);
		return ASTMapper.mapMultiPartFormParamToAST(params, String.valueOf(urlRecordId));
	}
	
	public static ResourceFileAST computesFormParamFeederFileAST(long urlRecordId) throws NoSuchFormParamException, SystemException {
		FormParam params = FormParamLocalServiceUtil.findByUrlRecordId(urlRecordId);
		return ASTMapper.mapFormParamToAST(params, String.valueOf(urlRecordId));
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
