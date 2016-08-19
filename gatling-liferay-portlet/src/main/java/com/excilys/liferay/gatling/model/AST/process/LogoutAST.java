package com.excilys.liferay.gatling.model.AST.process;

import com.excilys.liferay.gatling.model.AST.feeder.FeederFileAST;

import java.util.List;

public class LogoutAST extends ProcessAST {

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
