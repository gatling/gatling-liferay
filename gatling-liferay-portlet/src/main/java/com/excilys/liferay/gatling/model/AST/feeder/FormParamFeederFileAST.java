package com.excilys.liferay.gatling.model.AST.feeder;

public class FormParamFeederFileAST extends FeederFileAST {

	private static final String TYPE = "FormParam";
	private static final String HEADER = "key,value\n";
	private String content;
	
	public FormParamFeederFileAST(String name) {
		super(name, TYPE);
	}
	
	@Override
	public String getContent() {
		return HEADER+content;
	}
	

}
