package com.excilys.liferay.gatling.model.AST.feeder;

import java.util.ArrayList;
import java.util.List;

public class UserFeederFileAST extends FeederFileAST {
	
	private static final String TYPE = "User";
	
	private String content;
	
	public UserFeederFileAST(String name, String content) {
		this.name = name;
		this.type = TYPE;
		this.content = content;
	}

	@Override
	public String getContent() {
		return content;
	}

	@Override
	public List<FeederFileAST> flatWithSubsequentFeeders() {
		List<FeederFileAST> feeders = new ArrayList<>(1);
		feeders.add(this);
		return feeders;
	}
	
}
