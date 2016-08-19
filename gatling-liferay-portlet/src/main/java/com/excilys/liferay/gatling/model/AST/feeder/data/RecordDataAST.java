package com.excilys.liferay.gatling.model.AST.feeder.data;

import com.excilys.liferay.gatling.model.AST.feeder.FeederFileAST;

public class RecordDataAST {
	
	public static final String HEADER = "url,type,dataFile";
	
	private String url;
	private String type;
	private FeederFileAST data;
	
	public RecordDataAST(String url, String type, FeederFileAST data) {
		this.url = url;
		this.type = type;
		this.data = data;
	}

	public String getUrl() {
		return url;
	}
	
	public String getType() {
		return type;
	}
	
	public FeederFileAST getData() {
		return data;
	}
	
}
