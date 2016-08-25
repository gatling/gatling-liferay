package com.excilys.liferay.gatling.model.AST.feeder;

import com.excilys.liferay.gatling.model.AST.feeder.data.SiteMapDataAST;

import java.util.List;

public class SiteMapFeederFileAST extends FeederFileAST{

	private static final String TYPE = "SiteMap";

	private List<SiteMapDataAST> data;
	
	
	public SiteMapFeederFileAST(String name, List<SiteMapDataAST> data) {
		super(name, TYPE);
		this.data = data;
	}

	@Override
	public String getContent() {
		StringBuilder contentBuilder = new StringBuilder(SiteMapDataAST.HEADER).append("\n");
		for (SiteMapDataAST siteMapDataAST : data) {
			contentBuilder.append(siteMapDataAST.getFriendlyUrl())
				.append(",")
				.append(siteMapDataAST.getUrl())
				.append(",")
				.append(siteMapDataAST.getWeight())
				.append("\n");
		}
		return contentBuilder.toString();
	}
	
}
