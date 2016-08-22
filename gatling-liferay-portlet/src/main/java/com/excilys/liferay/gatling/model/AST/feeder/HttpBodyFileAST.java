package com.excilys.liferay.gatling.model.AST.feeder;

public abstract class HttpBodyFileAST extends ResourceFileAST {

	private static final String LOCATION = "body/";
	
	public HttpBodyFileAST(String name, String type) {
		super(name, type, LOCATION);
	}

	@Override
	public String getName() {
		return super.getName() + ".txt";
	}
	
}
