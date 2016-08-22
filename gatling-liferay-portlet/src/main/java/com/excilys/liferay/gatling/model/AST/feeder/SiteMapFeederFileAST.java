package com.excilys.liferay.gatling.model.AST.feeder;

import java.util.ArrayList;
import java.util.List;


/* TODO: Use a list of siteMapData instead of a raw content */ 
public class SiteMapFeederFileAST extends FeederFileAST{

private static final String TYPE = "SiteMap";
	
	private String content;
	
	public SiteMapFeederFileAST(String name, String content) {
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
