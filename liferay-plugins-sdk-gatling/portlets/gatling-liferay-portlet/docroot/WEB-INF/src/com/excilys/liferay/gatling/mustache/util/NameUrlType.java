package com.excilys.liferay.gatling.mustache.util;

public class NameUrlType {
	final private String nameN, url, typeRequest, namespace;
	private boolean form, version;
	
	public NameUrlType(String name,String url,String typeRequest, String namespace) {
		this.nameN = name;
		this.url = url;
		this.typeRequest = typeRequest;
		this.namespace = "_"+namespace+"_";
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

	public boolean isForm() {
		return form;
	}

	public void setForm(boolean form) {
		this.form = form;
	}

	public String getNamespace() {
		return namespace;
	}

	public boolean isVersion() {
		return version;
	}

	public void setVersion(boolean version) {
		this.version = version;
	}
	
}