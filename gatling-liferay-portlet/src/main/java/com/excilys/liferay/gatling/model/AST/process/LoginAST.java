package com.excilys.liferay.gatling.model.AST.process;

import com.excilys.liferay.gatling.model.AST.feeder.FeederFileAST;

import java.util.ArrayList;
import java.util.List;

public class LoginAST extends ProcessAST{

	public LoginAST() {
		super("Login","successfulLogin");
	}
	
	@Override
	protected String computeArguments() {
		//TODO remove hardcoded arg and get it from feeder and page
		return "\"http://localhost:8080/home\", \"feeders/login.csv\"";
	}

	@Override
	public List<FeederFileAST> getFeederFiles() {
		//TODO add Loginfeeder
		return new ArrayList<FeederFileAST>();
	}

}
