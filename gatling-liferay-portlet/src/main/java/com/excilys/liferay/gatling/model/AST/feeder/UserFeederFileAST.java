package com.excilys.liferay.gatling.model.AST.feeder;

import java.util.ArrayList;
import java.util.List;

public class UserFeederFileAST extends FeederFileAST {
	
	private static final String TYPE = "User";
	
	private String content;
	
	public UserFeederFileAST(String name, String content) {
		super(name, TYPE);
		this.content = content;
	}

	@Override
	public String getContent() {
		return content;
	}

	@Override
	public List<ResourceFileAST> flatWithSubsequentRessourceFile() {
		List<ResourceFileAST> feeders = new ArrayList<>(1);
		feeders.add(this);
		return feeders;
	}
	
}
