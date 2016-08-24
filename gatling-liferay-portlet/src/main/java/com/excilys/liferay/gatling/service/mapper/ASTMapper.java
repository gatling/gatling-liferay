package com.excilys.liferay.gatling.service.mapper;

import com.excilys.liferay.gatling.NoSuchFormParamException;
import com.excilys.liferay.gatling.controller.ViewController;
import com.excilys.liferay.gatling.model.FormParam;
import com.excilys.liferay.gatling.model.Process;
import com.excilys.liferay.gatling.model.ProcessType;
import com.excilys.liferay.gatling.model.Record;
import com.excilys.liferay.gatling.model.UrlRecord;
import com.excilys.liferay.gatling.model.UrlRecordType;
import com.excilys.liferay.gatling.model.AST.feeder.FormParamFeederFileAST;
import com.excilys.liferay.gatling.model.AST.feeder.HttpBodyFileAST;
import com.excilys.liferay.gatling.model.AST.feeder.RecordFeederFileAST;
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

	public static ProcessAST mapProcessToAST(Process process, String feederContent) throws PortalException, SystemException {
		ProcessAST ast = null;
		
		if (process == null) {
			return null;
		}
			
		
		switch(ProcessType.valueOf(process.getType())) {
			case RECORD:
				RecordFeederFileAST feeder = ASTService.computesRecordFeederFileAST(process.getRecordId());
				ast = new RecorderAST(feeder);
				break;
			case LOGIN:
				UserFeederFileAST userFeeder = new UserFeederFileAST("nameFeeder", feederContent);
				ast = new LoginAST(userFeeder);
				break;
			case RANDOMPAGE:
				SiteMapFeederFileAST siteMap = new SiteMapFeederFileAST("hey", ASTMapper.siteMap);
				ast = new RandomPageAST(siteMap);
				break;
			case LOGOUT:
				ast = new LogoutAST();
				break;
			default:
				ast = new LogoutAST();
				break;
		}
		
		ast.setPause(process.getPause());
		return ast;
	}
	
	public static RecordFeederFileAST mapRecordToAST(Record record) throws SystemException, NoSuchFormParamException{
		String name = record.getName();
		List<RecordDataAST> data = ASTService.computesRecordDataAST(record.getRecordId());
		return new RecordFeederFileAST(name, data);
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
