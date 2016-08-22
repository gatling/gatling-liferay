package com.excilys.liferay.gatling.model.AST.feeder.data;

import com.excilys.liferay.gatling.model.AST.feeder.ResourceFileAST;

public class RecordDataAST {
	
	public static final String HEADER = "url,type,dataFile";
	
	private String url;
	private String type;
	private ResourceFileAST data;
	
	public RecordDataAST(String url, String type, ResourceFileAST data) {
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
	
	public ResourceFileAST getData() {
		return data;
	}
	
	@Override
	public String toString() {
		return "URL: " + url + ", DATA: " + (data != null ? data.toString() : "none");
	}
	
}
