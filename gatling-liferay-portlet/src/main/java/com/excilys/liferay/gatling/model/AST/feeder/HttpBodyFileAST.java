package com.excilys.liferay.gatling.model.AST.feeder;

public abstract class HttpBodyFileAST extends ResourceFileAST {

	public HttpBodyFileAST(String name, String type) {
		super(name, type);
	}

	@Override
	public String getName() {
		return type + name + ".txt";
	}
	
}
