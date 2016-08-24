package com.excilys.liferay.gatling.model.AST.feeder;


public class UserFeederFileAST extends FeederFileAST {
	
	private static final String TYPE = "User";
	private String content;
	private static final String HEADER = "user,password\n";
	
	public UserFeederFileAST(String name, String content) {
		super(name, TYPE);
		this.content = content;
	}

	@Override
	public String getContent() {
		return HEADER + content;
	}
	
}
