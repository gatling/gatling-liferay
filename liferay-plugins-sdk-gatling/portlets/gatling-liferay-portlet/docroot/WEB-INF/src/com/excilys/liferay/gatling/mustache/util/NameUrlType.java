package com.excilys.liferay.gatling.mustache.util;

public class NameUrlType {
	final private String nameN, url, typeRequest;
	
	public NameUrlType(String name,String url,String typeRequest) {
		this.nameN = name;
		this.url = url;
		this.typeRequest = typeRequest;
	}

	public String getNameN() {
		return nameN;
	}

	public String getUrl() {
		return url;
	}

	public String getTypeRequest() {
		return typeRequest;
	}
	
}