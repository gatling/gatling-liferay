package com.excilys.liferay.gatling.model.AST.process;

import com.excilys.liferay.gatling.model.AST.feeder.FeederFileAST;

import java.util.List;

public class LogoutAST extends ProcessAST {
	
	//TODO: Make this final string configurable
	private static final String URL_BASE="http://localhost:8080";
	
	public LogoutAST() {
		super("Logout", "logout");
	}
	
	@Override
	protected String computeArguments() {
		return '"' + URL_BASE + '"';
	}

	@Override
	public List<FeederFileAST> getFeederFiles() {
		//No feederFile 
		return null;
	}

}
