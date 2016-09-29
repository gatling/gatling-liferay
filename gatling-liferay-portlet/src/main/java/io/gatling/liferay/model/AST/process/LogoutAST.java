package io.gatling.liferay.model.AST.process;

import io.gatling.liferay.model.AST.resource.ResourceFileAST;

import java.util.ArrayList;
import java.util.List;

/**
 * LogoutAST represents a process in which the
 * current virtual user in the simulation logs out.
 */
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
