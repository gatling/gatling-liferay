package com.excilys.liferay.gatling.model.AST.process;

import com.excilys.liferay.gatling.model.AST.feeder.ResourceFileAST;

import java.util.ArrayList;
import java.util.List;

public class LogoutAST extends ProcessAST {
	
	private String portalURL;;
	
	public LogoutAST(String url) {
		super("Logout", "logout");
		this.portalURL = url;
	}
	
	@Override
	protected String computeArguments() {
		return '"' + portalURL + '"';
	}

	@Override
	public List<ResourceFileAST> getFeederFiles() {
		//No feederFile 
		return new ArrayList<>();
	}

}
