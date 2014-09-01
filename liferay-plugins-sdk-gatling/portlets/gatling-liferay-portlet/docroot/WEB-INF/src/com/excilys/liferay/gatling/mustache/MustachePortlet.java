package com.excilys.liferay.gatling.mustache;

public class MustachePortlet {
	
	private String name, url;
	private int pourcentage;
	private boolean last;
	
	public MustachePortlet(String name, String url, int pourcentage, boolean last) {
		this.name = name;
		this.url = url;
		this.pourcentage = pourcentage;
		this.last = last;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getPourcentage() {
		return pourcentage;
	}

	public void setPourcentage(int pourcentage) {
		this.pourcentage = pourcentage;
	}

	public boolean isLast() {
		return last;
	}

	public void setLast(boolean last) {
		this.last = last;
	}	
	
}
