package com.excilys.liferay.gatling.mustache.util;

public class NameUrlAndPlid {
	
	private String name, url;
	private long plid;

	public NameUrlAndPlid(String name, String url, long plid) {
		super();
		this.name = name;
		this.url = url;
		this.plid = plid;
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

	public long getPlid() {
		return plid;
	}

	public void setPlid(long plid) {
		this.plid = plid;
	}

}
