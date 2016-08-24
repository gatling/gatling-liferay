package com.excilys.liferay.gatling.model.AST.process;

import com.excilys.liferay.gatling.model.AST.feeder.FeederFileAST;
import com.excilys.liferay.gatling.model.AST.feeder.ResourceFileAST;

import java.util.ArrayList;
import java.util.List;

public class LoginAST extends ProcessAST{

	FeederFileAST loginFeeder;
	
	public LoginAST(FeederFileAST feeder) {
		super("Login","successfulLogin");
		this.loginFeeder = feeder;
	}
	
	@Override
	protected String computeArguments() {
		//TODO remove hardcoded arg
		return "\"http://localhost:8080/home\","+ '"' + loginFeeder.getName() + '"';
	}
	
	@Override
	public List<ResourceFileAST> getFeederFiles() {
		 List<ResourceFileAST> feeders = new ArrayList<>();
		 feeders.add(loginFeeder);
		 return feeders;
	}

}
