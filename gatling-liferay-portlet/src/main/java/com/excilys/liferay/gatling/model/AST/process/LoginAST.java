package com.excilys.liferay.gatling.model.AST.process;

import com.excilys.liferay.gatling.model.AST.feeder.FeederFileAST;
import com.excilys.liferay.gatling.model.AST.feeder.ResourceFileAST;

import java.util.ArrayList;
import java.util.List;

public class LoginAST extends ProcessAST{

	FeederFileAST loginFeeder;
	private String url;
	
	public LoginAST(FeederFileAST feeder) {
		super("Login","successfulLogin");
		this.loginFeeder = feeder;
		this.url = "/home";
	}
	
	@Override
	protected String computeArguments() {
		return '"' + url + "\", \""  + loginFeeder.getLocatedName() + '"';
	}
	
	@Override
	public List<ResourceFileAST> getFeederFiles() {
		 List<ResourceFileAST> feeders = new ArrayList<>();
		 feeders.add(loginFeeder);
		 return feeders;
	}

}
