package com.excilys.liferay.gatling.service;

import com.excilys.liferay.gatling.NoSuchFormParamException;
import com.excilys.liferay.gatling.NoSuchProcessException;
import com.excilys.liferay.gatling.model.FormParam;
import com.excilys.liferay.gatling.model.Login;
import com.excilys.liferay.gatling.model.Process;
import com.excilys.liferay.gatling.model.Record;
import com.excilys.liferay.gatling.model.Scenario;
import com.excilys.liferay.gatling.model.Simulation;
import com.excilys.liferay.gatling.model.SiteMap;
import com.excilys.liferay.gatling.model.UrlRecord;
import com.excilys.liferay.gatling.model.UrlSiteMap;
import com.excilys.liferay.gatling.model.AST.ScenarioAST;
import com.excilys.liferay.gatling.model.AST.SimulationAST;
import com.excilys.liferay.gatling.model.AST.feeder.HttpBodyFileAST;
import com.excilys.liferay.gatling.model.AST.feeder.RecordFileAST;
import com.excilys.liferay.gatling.model.AST.feeder.ResourceFileAST;
import com.excilys.liferay.gatling.model.AST.feeder.SiteMapFeederFileAST;
import com.excilys.liferay.gatling.model.AST.feeder.UserFeederFileAST;
import com.excilys.liferay.gatling.model.AST.feeder.data.RecordDataAST;
import com.excilys.liferay.gatling.model.AST.feeder.data.SiteMapDataAST;
import com.excilys.liferay.gatling.model.AST.process.ProcessAST;
import com.excilys.liferay.gatling.service.mapper.ASTMapper;
import com.excilys.liferay.gatling.service.persistence.ProcessUtil;
import com.excilys.liferay.gatling.service.persistence.SiteMapUtil;
import com.excilys.liferay.gatling.service.persistence.UrlSiteMapUtil;
import com.excilys.liferay.gatling.util.GatlingUtil;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.NoSuchModelException;
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
		Simulation simulation = SimulationLocalServiceUtil.getSimulation(simulationId);
		return ASTMapper.mapSimulationToAST(simulation, portalURL);
	}
	
	public static List<ScenarioAST> computesScenariosAST(long simulationId, String portalURL) throws SystemException, PortalException {
		List<Scenario> scenarios = ScenarioLocalServiceUtil.findBySimulationId(simulationId);
		return ASTMapper.mapScenariosToAST(scenarios, portalURL);
	}
	
	public static List<ProcessAST> computesProcessesAST(long scenario_id, String portalURL) throws SystemException, PortalException {
		List<Process> processes = ProcessLocalServiceUtil.findProcessFromScenarioId(scenario_id);
		return ASTMapper.mapProcessesToAST(processes, portalURL);
	}
	
	public static UserFeederFileAST computesUserFeederFileAST(long processId) throws NoSuchProcessException, NoSuchModelException, SystemException {
		Login login = LoginLocalServiceUtil.findByProcessId(processId);
		if(login == null){
			LOG.debug("ARTUNGH");
			//TODO: Raise a custom exception
		}
		return ASTMapper.mapLoginToAST(login);
	}
	
	public static RecordFileAST computesRecordFeederFileAST(long processId) throws PortalException, SystemException{
		Record record = RecordLocalServiceUtil.findByProcessId(processId);
		if(record == null){
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
	
	public static SiteMapFeederFileAST computesSiteMapFeederFileAST(long processId) throws SystemException, NoSuchProcessException, NoSuchModelException {
		SiteMap siteMap = SiteMapLocalServiceUtil.findByProcessId(processId);
		return ASTMapper.mapSiteMapToAST(siteMap);
	}

	public static List<SiteMapDataAST> computesSiteMapDataASTList(long siteMapId) throws SystemException {
		List<UrlSiteMap> data = UrlSiteMapLocalServiceUtil.findBySiteMapId(siteMapId);
		return ASTMapper.mapUrlsitesToAST(data);
	}

	
	public static long siteMapCreation(ThemeDisplay themeDisplay, long groupId) throws SystemException {
		StringBuilder sb  = null;
        UrlSiteMap urlSm = null;
        LOG.debug("------------------------- called ----------------------------");
        SiteMap siteMap = SiteMapUtil.create(CounterLocalServiceUtil.increment(SiteMap.class.getName()));
        siteMap.setName("_default_sitemap_");
        siteMap.persist();
        
        for (Layout layout : GatlingUtil.getSiteMap(groupId)) {
        	
        	urlSm = UrlSiteMapUtil.create(CounterLocalServiceUtil.increment(UrlSiteMap.class.getName()));
        	urlSm.setFriendlyUrl(layout.getFriendlyURL().substring(1));
        	urlSm.setSiteMapId(siteMap.getSiteMapId());
        	sb  = new StringBuilder();
        	String currentFriendlyURL = GroupLocalServiceUtil.fetchGroup(layout.getGroupId()).getIconURL(themeDisplay);
            sb.append(currentFriendlyURL.split("/")[0]);
            sb.append("//").append(currentFriendlyURL.split("/")[2]).append("/web").append(GroupLocalServiceUtil.fetchGroup(layout.getGroupId()).getFriendlyURL()).append(layout.getFriendlyURL());
            
            urlSm.setUrl(sb.toString());
            
            urlSm.setWeight(1);
            urlSm.persist();
        }
        
        LOG.debug(siteMap.getPrimaryKey());
        return siteMap.getSiteMapId();
    }
	

	

	

	
	
}
