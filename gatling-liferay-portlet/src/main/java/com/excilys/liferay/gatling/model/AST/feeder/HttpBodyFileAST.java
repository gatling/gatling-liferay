package com.excilys.liferay.gatling.model.AST.feeder;


public class HttpBodyFileAST extends ResourceFileAST {

	private static final String LOCATION = "bodies/liferay/";
	private static final String TYPE = "HttpBody";
	
	private String content;
	
	
	public HttpBodyFileAST(String name, String content) {
		super(name, TYPE, LOCATION);
		this.content = content;
	}

	@Override
	public String getName() {
		return super.getName() + ".txt";
	}

	@Override
	public String getContent() {
		return content;
	}

	
	
}
