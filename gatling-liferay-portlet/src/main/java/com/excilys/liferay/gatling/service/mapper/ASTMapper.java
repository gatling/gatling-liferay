package com.excilys.liferay.gatling.service.mapper;

import com.excilys.liferay.gatling.model.ProcessType;
import com.excilys.liferay.gatling.model.Record;
import com.excilys.liferay.gatling.model.UrlRecord;
import com.excilys.liferay.gatling.model.AST.feeder.RecordFeederFileAST;
import com.excilys.liferay.gatling.model.AST.feeder.data.RecordDataAST;
import com.excilys.liferay.gatling.model.AST.process.LoginAST;
import com.excilys.liferay.gatling.model.AST.process.LogoutAST;
import com.excilys.liferay.gatling.model.AST.process.ProcessAST;
import com.excilys.liferay.gatling.model.AST.process.RandomPageAST;
import com.excilys.liferay.gatling.model.AST.process.RecorderAST;
import com.excilys.liferay.gatling.service.ASTService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

import java.util.ArrayList;
import java.util.List;

public class ASTMapper {

	public static ProcessAST mapProcessToAST(com.excilys.liferay.gatling.model.Process process) throws PortalException, SystemException {
		ProcessAST ast = null;
		
		if (process == null)
			return null;
		
		switch(ProcessType.valueOf(process.getType())) {
			case RECORD:
				RecordFeederFileAST feeder = ASTService.computesRecordFeederFileAST(process.getRecordId());
				ast = new RecorderAST(feeder);
				break;
			case LOGIN:
				//TODO handle feeder
				ast = new LoginAST();
				break;
			case RANDOMPAGE:
				//TODO handle feeder
				ast = new RandomPageAST();
				break;
			default:
				ast = new LogoutAST();
				break;
		}
		return ast;
	}
	
	public static RecordFeederFileAST mapRecordToAST(Record record) throws SystemException{
		String name = record.getName();
		List<RecordDataAST> data = ASTService.computesRecordDataAST(record.getRecordId());
		return new RecordFeederFileAST(name, data);
	}

	public static List<RecordDataAST> mapUrlRecordsToAST(List<UrlRecord> urlRecords) {
		List<RecordDataAST> dataList = new ArrayList<>();
		for (UrlRecord urlRecord : urlRecords) {
			//TODO: Add a feeder when necessary !!!
			RecordDataAST data = new RecordDataAST(urlRecord.getUrl(), urlRecord.getType(), null);
			dataList.add(data);
		}
		return dataList;
	}
	
	
}
