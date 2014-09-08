package com.excilys.liferay.gatling.mustache.util;

public class NameAndUrl {
	
	private String nameN, url;
	private boolean beginning = false;

	public NameAndUrl(String name, String url) {
		this.nameN = name;
		this.url = url;
	}

	public String getName() {
		return nameN;
	}

	public void setName(String name) {
		this.nameN = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getNameN() {
		return nameN;
	}

	public void setNameN(String nameN) {
		this.nameN = nameN;
	}

	public boolean isBeginning() {
		return beginning;
	}

	public void setBeginning(boolean point) {
		this.beginning = point;
	}

}
