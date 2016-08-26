package com.excilys.liferay.gatling.model.AST.process;

import com.excilys.liferay.gatling.model.AST.feeder.FeederFileAST;
import com.excilys.liferay.gatling.model.AST.feeder.ResourceFileAST;

import java.util.ArrayList;
import java.util.List;

public class LoginAST extends ProcessAST{

	FeederFileAST loginFeeder;
	private String portalURL;
	
	public LoginAST(FeederFileAST feeder, String url) {
		super("Login","successfulLogin");
		this.loginFeeder = feeder;
		this.portalURL = url +"/home";
	}
	
	@Override
	protected String computeArguments() {
		return '"' + portalURL + "\", \""  + loginFeeder.getLocatedName() + '"';
	}
	
	@Override
	public List<ResourceFileAST> getFeederFiles() {
		 List<ResourceFileAST> feeders = new ArrayList<>();
		 feeders.add(loginFeeder);
		 return feeders;
	}

}
