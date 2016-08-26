package com.excilys.liferay.gatling.model.AST.feeder;

public abstract class ScalaFileAST extends ResourceFileAST {

	public static final String LOCATION = "simulations/liferay/processes/";
	
	public ScalaFileAST(String name, String type) {
		super(name, type, LOCATION);
	}

	@Override
	public String getLocatedName() {
		return super.getLocatedName() + ".scala";
	}
	
}
