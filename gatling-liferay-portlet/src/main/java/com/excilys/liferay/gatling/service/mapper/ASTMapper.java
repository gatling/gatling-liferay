package com.excilys.liferay.gatling.service.mapper;

import com.excilys.liferay.gatling.NoSuchFormParamException;
import com.excilys.liferay.gatling.model.FormParam;
import com.excilys.liferay.gatling.model.Login;
import com.excilys.liferay.gatling.model.Process;
import com.excilys.liferay.gatling.model.ProcessType;
import com.excilys.liferay.gatling.model.Record;
import com.excilys.liferay.gatling.model.Scenario;
import com.excilys.liferay.gatling.model.Simulation;
import com.excilys.liferay.gatling.model.UrlRecord;
import com.excilys.liferay.gatling.model.UrlRecordType;
import com.excilys.liferay.gatling.model.AST.ScenarioAST;
import com.excilys.liferay.gatling.model.AST.SimulationAST;
import com.excilys.liferay.gatling.model.AST.feeder.FormParamFeederFileAST;
import com.excilys.liferay.gatling.model.AST.feeder.HttpBodyFileAST;
import com.excilys.liferay.gatling.model.AST.feeder.RecordFileAST;
import com.excilys.liferay.gatling.model.AST.feeder.ResourceFileAST;
import com.excilys.liferay.gatling.model.AST.feeder.SiteMapFeederFileAST;
import com.excilys.liferay.gatling.model.AST.feeder.UserFeederFileAST;
import com.excilys.liferay.gatling.model.AST.feeder.data.RecordDataAST;
import com.excilys.liferay.gatling.model.AST.process.LoginAST;
import com.excilys.liferay.gatling.model.AST.process.LogoutAST;
import com.excilys.liferay.gatling.model.AST.process.ProcessAST;
import com.excilys.liferay.gatling.model.AST.process.RandomPageAST;
import com.excilys.liferay.gatling.model.AST.process.RecorderAST;
import com.excilys.liferay.gatling.service.ASTService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.util.ArrayList;
import java.util.List;

public class ASTMapper {
	
	// TODO: initiate siteMap in db, shouldnt be static arg
	public static String siteMap;
	
	private static final Log LOG = LogFactoryUtil.getLog(ASTMapper.class);

	public static SimulationAST mapSimulationToAST(Simulation simulation, String portalURL) throws SystemException, PortalException {
		List<ScenarioAST> scenarios = ASTService.computesScenariosAST(simulation.getSimulation_id(), portalURL);
		return new SimulationAST(simulation.getName(), scenarios, portalURL);
	}

	public static List<ScenarioAST> mapScenariosToAST(List<Scenario> scenarios, String portalURL) throws SystemException, PortalException {
		List<ScenarioAST> scenariosAST = new ArrayList<>(scenarios.size());
		for (Scenario scenario : scenarios) {
			ScenarioAST scenarioAST = mapScenarioToAST(scenario, portalURL);
			scenariosAST.add(scenarioAST);
		}
		return scenariosAST;
	}
	
	public static ScenarioAST mapScenarioToAST(Scenario scenario, String portalURL) throws SystemException, PortalException{
		List<ProcessAST> processList = ASTService.computesProcessesAST(scenario.getScenario_id(), portalURL);
		return new ScenarioAST(scenario.getName(), scenario.getNumberOfUsers(), scenario.getDuration(), processList);
	}
	
	public static List<ProcessAST> mapProcessesToAST(List<Process> processes, String portalURL) throws PortalException, SystemException {
		List<ProcessAST> processesAST = new ArrayList<ProcessAST>(processes.size());
		for (Process process : processes) {
			
			ProcessAST processAST = mapProcessToAST(process, portalURL);
			processesAST.add(processAST);
		}
		return processesAST;
	}
	
	public static ProcessAST mapProcessToAST(Process process, String portalURL) throws PortalException, SystemException {
		ProcessAST ast = null;
		
		switch(ProcessType.valueOf(process.getType())) {
			case RECORD:
				RecordFileAST feeder = ASTService.computesRecordFeederFileAST(process.getProcess_id());
				ast = new RecorderAST(feeder);
				break;
			case LOGIN:
				UserFeederFileAST userFeeder = ASTService.computesUserFeederFileAST(process.getProcess_id());
				ast = new LoginAST(userFeeder, portalURL);
				break;
			case RANDOMPAGE:
				SiteMapFeederFileAST siteMap = new SiteMapFeederFileAST("hey", ASTMapper.siteMap);
				ast = new RandomPageAST(siteMap);
				break;
			case LOGOUT:
				ast = new LogoutAST(portalURL);
				break;
			default:
				ast = new LogoutAST(portalURL);
				break;
		}
		
		ast.setPause(process.getPause());
		return ast;
	}
	
	public static UserFeederFileAST mapLoginToAST(Login login) {
		return new UserFeederFileAST(login.getName(), login.getData());
	}
	
	public static RecordFileAST mapRecordToAST(Record record) throws SystemException, NoSuchFormParamException{
		String name = record.getName();
		List<RecordDataAST> data = ASTService.computesRecordDataAST(record.getRecordId());
		return new RecordFileAST(name, data);
	}

	public static List<RecordDataAST> mapUrlRecordsToAST(List<UrlRecord> urlRecords) throws NoSuchFormParamException, SystemException {
		List<RecordDataAST> dataList = new ArrayList<>();
		for (UrlRecord urlRecord : urlRecords) {
			
			ResourceFileAST formResource = null;
			switch(UrlRecordType.valueOf(urlRecord.getType())){
				case POST:
					formResource = ASTService.computesFormParamFeederFileAST(urlRecord.getUrlRecordId());
					break;
				case MULTIPART:
					formResource = ASTService.computesHttpBodyFileAST(urlRecord.getUrlRecordId());
					break;
				default:
					break;
			}
			
			RecordDataAST data = new RecordDataAST(urlRecord.getUrl(), urlRecord.getType(), formResource);
			dataList.add(data);
		}
		return dataList;
	}

	public static HttpBodyFileAST mapMultiPartFormParamToAST(FormParam params, String name){
		return new HttpBodyFileAST(name, params.getData());
	}
	
	public static ResourceFileAST mapFormParamToAST(FormParam params, String name) {
		return new FormParamFeederFileAST(name, params.getData());
	}

	


	
	
	
}
