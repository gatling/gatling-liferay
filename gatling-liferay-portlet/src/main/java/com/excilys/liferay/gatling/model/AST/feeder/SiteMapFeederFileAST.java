package com.excilys.liferay.gatling.model.AST.feeder;



/* TODO: Use a list of siteMapData instead of a raw content */ 
public class SiteMapFeederFileAST extends FeederFileAST{

	private static final String TYPE = "SiteMap";

	
	private String content;
	private static final String HEADER = "site,URL\n";
	
	public SiteMapFeederFileAST(String name, String content) {
		super(name, TYPE);
		this.content = content;
	}

	@Override
	public String getContent() {
		return HEADER + content;
	}
	
}
