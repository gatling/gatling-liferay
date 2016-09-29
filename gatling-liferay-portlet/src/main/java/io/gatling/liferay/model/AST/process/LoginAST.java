package io.gatling.liferay.model.AST.process;

import io.gatling.liferay.model.AST.resource.FeederFileAST;
import io.gatling.liferay.model.AST.resource.ResourceFileAST;

import java.util.ArrayList;
import java.util.List;

/**
 * LoginAST represents a process in which a
 * user from a feeder file is randomly selected
 * and logged in the portal. 
 */
public class LoginAST extends ProcessAST{

	/**
	 * The feederfile containing user data.
	 */
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
