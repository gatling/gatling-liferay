package io.gatling.liferay.service.mapper;

import io.gatling.liferay.NoSuchFormParamException;
import io.gatling.liferay.model.FormParam;
import io.gatling.liferay.model.Login;
import io.gatling.liferay.model.Process;
import io.gatling.liferay.model.ProcessType;
import io.gatling.liferay.model.Record;
import io.gatling.liferay.model.Scenario;
import io.gatling.liferay.model.Simulation;
import io.gatling.liferay.model.SiteMap;
import io.gatling.liferay.model.UrlRecord;
import io.gatling.liferay.model.UrlRecordType;
import io.gatling.liferay.model.UrlSiteMap;
import io.gatling.liferay.model.AST.ScenarioAST;
import io.gatling.liferay.model.AST.SimulationAST;
import io.gatling.liferay.model.AST.process.LoginAST;
import io.gatling.liferay.model.AST.process.LogoutAST;
import io.gatling.liferay.model.AST.process.ProcessAST;
import io.gatling.liferay.model.AST.process.RandomPageAST;
import io.gatling.liferay.model.AST.process.RecorderAST;
import io.gatling.liferay.model.AST.resource.FormParamFileAST;
import io.gatling.liferay.model.AST.resource.HttpBodyFileAST;
import io.gatling.liferay.model.AST.resource.RecordFileAST;
import io.gatling.liferay.model.AST.resource.ResourceFileAST;
import io.gatling.liferay.model.AST.resource.SiteMapFeederFileAST;
import io.gatling.liferay.model.AST.resource.UserFeederFileAST;
import io.gatling.liferay.model.AST.resource.data.RecordDataAST;
import io.gatling.liferay.model.AST.resource.data.SiteMapDataAST;
import io.gatling.liferay.service.ASTService;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

import java.util.ArrayList;
import java.util.List;

public class ASTMapper {
	
	
	public static SimulationAST mapSimulationToAST(Simulation simulation, String portalURL) throws SystemException, PortalException {
		List<ScenarioAST> scenarios = ASTService.computesScenariosAST(simulation.getSimulation_id());
		return new SimulationAST(simulation.getName(), scenarios, portalURL);
	}

	public static List<ScenarioAST> mapScenariosToAST(List<Scenario> scenarios) throws SystemException, PortalException {
		List<ScenarioAST> scenariosAST = new ArrayList<>(scenarios.size());
		for (Scenario scenario : scenarios) {
			ScenarioAST scenarioAST = mapScenarioToAST(scenario);
			scenariosAST.add(scenarioAST);
		}
		return scenariosAST;
	}
	
	public static ScenarioAST mapScenarioToAST(Scenario scenario) throws SystemException, PortalException{
		List<ProcessAST> processList = ASTService.computesProcessesAST(scenario.getScenario_id());
		return new ScenarioAST(scenario.getName(), scenario.getNumberOfUsers(), scenario.getInjection(), scenario.getDuration(), processList);
	}
	
	public static List<ProcessAST> mapProcessesToAST(List<Process> processes, List<Integer> pauses) throws PortalException, SystemException {
		List<ProcessAST> processesAST = new ArrayList<ProcessAST>(processes.size());
		for(int i = 0; i < processes.size(); i++) {
			ProcessAST processAST = mapProcessToAST(processes.get(i), pauses.get(i));
			processesAST.add(processAST);
		}
		return processesAST;
	}
	
	public static ProcessAST mapProcessToAST(Process process, int pause) throws PortalException, SystemException {
		ProcessAST ast = null;
		
		switch(ProcessType.valueOf(process.getType())) {
			case RECORD:
				RecordFileAST feeder = ASTService.computesRecordFeederFileAST(process.getProcess_id());
				ast = new RecorderAST(feeder);
				break;
			case LOGIN:
				UserFeederFileAST userFeeder = ASTService.computesUserFeederFileAST(process.getProcess_id());
				ast = new LoginAST(userFeeder);
				break;
			case RANDOMPAGE:
				SiteMapFeederFileAST siteMap = ASTService.computesSiteMapFeederFileAST(process.getProcess_id());
				ast = new RandomPageAST(siteMap);
				break;
			case LOGOUT:
				ast = new LogoutAST();
				break;
			default:
				throw new IllegalArgumentException();
		}
		
		ast.setPause(pause);
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
			
			RecordDataAST data = new RecordDataAST(urlRecord.getUrl(), urlRecord.getType(), formResource, urlRecord.getPauseTime());
			dataList.add(data);
		}
		return dataList;
	}

	public static HttpBodyFileAST mapMultiPartFormParamToAST(FormParam params, String name){
		return new HttpBodyFileAST(name, params.getData());
	}
	
	public static ResourceFileAST mapFormParamToAST(FormParam params, String name) {
		return new FormParamFileAST(name, params.getData());
	}

	public static SiteMapFeederFileAST mapSiteMapToAST(SiteMap siteMap) throws SystemException {
		List<SiteMapDataAST> data = ASTService.computesSiteMapDataASTList(siteMap.getSiteMapId());
		return new SiteMapFeederFileAST(siteMap.getName(), data);
	}

	public static List<SiteMapDataAST> mapUrlsitesToAST(List<UrlSiteMap> data) {
		List<SiteMapDataAST> dataAST = new ArrayList<>(data.size());
		for (UrlSiteMap urlSiteMap : data) {
			dataAST.add(new SiteMapDataAST(urlSiteMap.getFriendlyUrl(), urlSiteMap.getUrl(), urlSiteMap.getWeight()));
		}
		return dataAST;
	}
	

}
