package com.excilys.liferay.gatling.model.AST;

import com.excilys.liferay.gatling.model.ProcessType;
import com.excilys.liferay.gatling.model.Record;
import com.excilys.liferay.gatling.model.Scenario;
import com.excilys.liferay.gatling.model.AST.feeder.RecordFeederFileAST;
import com.excilys.liferay.gatling.model.AST.feeder.data.RecordDataAST;
import com.excilys.liferay.gatling.model.AST.process.LoginAST;
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
			case LOGIN:
				//TODO handle feeder
				ast = new LoginAST();
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
}
