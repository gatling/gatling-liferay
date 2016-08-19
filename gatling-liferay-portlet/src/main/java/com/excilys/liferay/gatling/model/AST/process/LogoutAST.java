package com.excilys.liferay.gatling.model.AST.process;

import com.excilys.liferay.gatling.model.AST.feeder.FeederFileAST;

import java.util.List;

public class LogoutAST extends ProcessAST {

	public LogoutAST() {
		this.scalaObject = "Logout";
		this.scalaFunction = "logout";
	}
	@Override
	protected String computeArguments() {
		//No arguments
		return "";
	}

	@Override
	public List<FeederFileAST> getFeederFiles() {
		//No feederFile 
		return null;
	}

}
