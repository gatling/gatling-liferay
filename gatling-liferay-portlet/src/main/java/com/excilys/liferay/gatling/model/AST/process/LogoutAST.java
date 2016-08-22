package com.excilys.liferay.gatling.model.AST.process;

import com.excilys.liferay.gatling.model.AST.feeder.ResourceFileAST;

import java.util.ArrayList;
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
	public List<ResourceFileAST> getFeederFiles() {
		//No feederFile 
		return new ArrayList<>();
	}

}
