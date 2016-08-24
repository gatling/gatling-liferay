package com.excilys.liferay.gatling.service;

import com.excilys.liferay.gatling.model.Process;
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
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.model.Layout;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;

import java.util.ArrayList;
import java.util.List;

public class ASTService {


	private static final Log LOG = LogFactoryUtil.getLog(ASTService.class);
	
	public static SimulationAST computesSimulationAST(long simulationId, String portalURL) throws Exception {
		LOG.debug("-------------------------------------"+portalURL);
		Simulation simulation = SimulationLocalServiceUtil.getSimulation(simulationId);
		//return ASTMapper.mapSimulationToAST(simulation, portalURL);
		
		List<ScenarioAST> scenarios = initScenarios(simulationId, portalURL);
		String simulationName = GatlingUtil.createSimulationVariable(simulation.getName());
		return new SimulationAST(simulationName, scenarios, portalURL);
	}
	
	public static List<ScenarioAST> computesScenariosAST(long simulationId, String portalURL) throws SystemException, PortalException {
		List<Scenario> scenarios = ScenarioLocalServiceUtil.findBySimulationId(simulationId);
		return ASTMapper.mapScenariosToAST(scenarios, portalURL);
	}
	
	public static List<ProcessAST> computesProcessesAST(long scenario_id, String portalURL) throws SystemException, PortalException {
		List<Process> processes = ProcessLocalServiceUtil.findProcessFromScenarioId(scenario_id);
		return ASTMapper.mapProcessesToAST(processes, portalURL);
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
	public static List<ScenarioAST> initScenarios(Long simulationId, String portalURL) throws SystemException, PortalException {
		List<ScenarioAST> mustacheScenarios;
		List<Scenario> listScenario = ScenarioLocalServiceUtil.findBySimulationId(simulationId);
		
		Simulation simulation = SimulationLocalServiceUtil.fetchSimulation(simulationId);
		String contentFeeder = simulation.getFeederContent();
		
		mustacheScenarios = new ArrayList<>(listScenario.size());
		for (Scenario scenario : listScenario) {
			String name = GatlingUtil.createScenarioVariable(scenario.getName());
			List<com.excilys.liferay.gatling.model.Process> processes = ProcessLocalServiceUtil.findProcessFromScenarioId(scenario.getScenario_id());
			List<ProcessAST> processASTs = new ArrayList<>(processes.size());
			for (com.excilys.liferay.gatling.model.Process process : processes) {
				processASTs.add(ASTMapper.mapProcessToAST(process,contentFeeder, portalURL));
			}
			
			//DEBUG mode for test;
			//processASTs.add(new LoginAST());
			//processASTs.add(new LogoutAST());
			ScenarioAST dms = new ScenarioAST(name, scenario.getNumberOfUsers(), scenario.getDuration(),processASTs);
			mustacheScenarios.add(dms);
		}
		return mustacheScenarios;
	}

	public static String siteMapCreation(ThemeDisplay themeDisplay, long groupId) throws SystemException {
		StringBuilder sb  = new StringBuilder();
		for (Layout layout : GatlingUtil.getSiteMap(groupId)) {
			sb.append(layout.getFriendlyURL().substring(1));
			sb.append(",");
			
			String currentFriendlyURL = GroupLocalServiceUtil.fetchGroup(layout.getGroupId()).getIconURL(themeDisplay);
			sb.append(currentFriendlyURL.split("/")[0]);
			sb.append("//").append(currentFriendlyURL.split("/")[2]).append("/web").append(GroupLocalServiceUtil.fetchGroup(layout.getGroupId()).getFriendlyURL()).append(layout.getFriendlyURL());
			sb.append("\n");
		//zipOutputStream.write((layout.getFriendlyURL().substring(1)+","+sb.toString()+"\n").getBytes());
		}
		return sb.toString();
	}

	

	
	
}
