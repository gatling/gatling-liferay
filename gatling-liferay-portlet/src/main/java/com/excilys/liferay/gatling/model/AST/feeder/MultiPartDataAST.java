package com.excilys.liferay.gatling.model.AST.feeder;

import java.util.ArrayList;
import java.util.List;

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

	@Override
	public List<ResourceFileAST> flatWithSubsequentRessourceFile() {
		List<ResourceFileAST> feeders = new ArrayList<>();
		feeders.add(this);
		return feeders;
	}
	
	

}
