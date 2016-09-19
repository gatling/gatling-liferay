package io.gatling.liferay.model.AST.process;

import io.gatling.liferay.model.AST.feeder.ResourceFileAST;

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
