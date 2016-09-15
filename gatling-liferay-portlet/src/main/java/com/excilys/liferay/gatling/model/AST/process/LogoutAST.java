package com.excilys.liferay.gatling.model.AST.process;

import com.excilys.liferay.gatling.model.AST.feeder.ResourceFileAST;

import java.util.ArrayList;
import java.util.List;

public class LogoutAST extends ProcessAST {
	
	public LogoutAST() {
		super("Logout", "logout");
	}
	
	@Override
	protected String computeArguments() {
		return "";
	}

	@Override
	public List<ResourceFileAST> getFeederFiles() {
		//No feederFile 
		return new ArrayList<>();
	}

}
