/**
 * Copyright 2011-2015 GatlingCorp (http://gatling.io)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * 		http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.gatling.generation.service;

import io.gatling.generation.AST.ScenarioAST;
import io.gatling.generation.AST.SimulationAST;
import io.gatling.generation.AST.process.ProcessAST;
import io.gatling.generation.AST.resource.HttpBodyFileAST;
import io.gatling.generation.AST.resource.RecordFileAST;
import io.gatling.generation.AST.resource.ResourceFileAST;
import io.gatling.generation.AST.resource.SiteMapFileAST;
import io.gatling.generation.AST.resource.UserFileAST;
import io.gatling.generation.AST.resource.data.RecordDataAST;
import io.gatling.generation.AST.resource.data.SiteMapDataAST;
import io.gatling.generation.mapper.ASTMapper;
import io.gatling.liferay.NoSuchFormParamException;
import io.gatling.liferay.NoSuchProcessException;
import io.gatling.liferay.model.FormParam;
import io.gatling.liferay.model.Login;
import io.gatling.liferay.model.Process;
import io.gatling.liferay.model.Record;
import io.gatling.liferay.model.Scenario;
import io.gatling.liferay.model.Simulation;
import io.gatling.liferay.model.SiteMap;
import io.gatling.liferay.model.UrlRecord;
import io.gatling.liferay.model.UrlSiteMap;
import io.gatling.liferay.service.FormParamLocalServiceUtil;
import io.gatling.liferay.service.LoginLocalServiceUtil;
import io.gatling.liferay.service.ProcessLocalServiceUtil;
import io.gatling.liferay.service.RecordLocalServiceUtil;
import io.gatling.liferay.service.ScenarioLocalServiceUtil;
import io.gatling.liferay.service.SimulationLocalServiceUtil;
import io.gatling.liferay.service.SiteMapLocalServiceUtil;
import io.gatling.liferay.service.UrlRecordLocalServiceUtil;
import io.gatling.liferay.service.UrlSiteMapLocalServiceUtil;

import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.util.ArrayList;
import java.util.List;

public class ASTService {


	private static final Log LOG = LogFactoryUtil.getLog(ASTService.class);
	
	public static SimulationAST computesSimulationAST(long simulationId, String portalURL) throws Exception {
		Simulation simulation = SimulationLocalServiceUtil.getSimulation(simulationId);
		return ASTMapper.mapSimulationToAST(simulation, portalURL);
	}
	
	public static List<ScenarioAST> computesScenariosAST(long simulationId) throws SystemException, PortalException {
		List<Scenario> scenarios = ScenarioLocalServiceUtil.findBySimulationId(simulationId);
		return ASTMapper.mapScenariosToAST(scenarios);
	}
	
	public static List<ProcessAST> computesProcessesAST(long scenario_id) throws SystemException, PortalException {
		List<Process> processes = ProcessLocalServiceUtil.findProcessFromScenarioId(scenario_id);
		List<Integer> pauses = new ArrayList<>(processes.size());
		for(int i=0; i < processes.size(); i++){
			pauses.add(ProcessLocalServiceUtil.findPause(scenario_id, processes.get(i).getProcess_id(), i));
		}
		return ASTMapper.mapProcessesToAST(processes, pauses);
	}
	
	public static UserFileAST computesUserFeederFileAST(long processId) throws NoSuchProcessException, NoSuchModelException, SystemException {
		Login login = LoginLocalServiceUtil.findByProcessId(processId);
		if(login == null){
			LOG.debug("ACHTUNG");
			//TODO: Raise a custom exception
		}
		return ASTMapper.mapLoginToAST(login);
	}
	
	public static RecordFileAST computesRecordFeederFileAST(long processId) throws PortalException, SystemException{
		Record record = RecordLocalServiceUtil.findByProcessId(processId);
		if(record == null){
			LOG.debug("ACHTUNG ! Es ist ein kartoffel !");
			//TODO: Raise a custom exception
		}
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
	
	public static SiteMapFileAST computesSiteMapFeederFileAST(long processId) throws SystemException, NoSuchProcessException, NoSuchModelException {
		SiteMap siteMap = SiteMapLocalServiceUtil.findByProcessId(processId);
		return ASTMapper.mapSiteMapToAST(siteMap);
	}

	public static List<SiteMapDataAST> computesSiteMapDataASTList(long siteMapId) throws SystemException {
		List<UrlSiteMap> data = UrlSiteMapLocalServiceUtil.findBySiteMapId(siteMapId);
		return ASTMapper.mapUrlsitesToAST(data);
	}

	
}
