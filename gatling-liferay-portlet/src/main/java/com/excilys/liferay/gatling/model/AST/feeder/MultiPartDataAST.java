package com.excilys.liferay.gatling.model.AST.feeder;


public class MultiPartDataAST extends FeederFileAST {

	private static final String TYPE = "MultiPart";
	
	private String content;
	
	public MultiPartDataAST(String name, String content) {
		super(name, TYPE);
		this.content = content;
	}
	
	@Override
	public String getContent() {
		return content;
	}
	

}
