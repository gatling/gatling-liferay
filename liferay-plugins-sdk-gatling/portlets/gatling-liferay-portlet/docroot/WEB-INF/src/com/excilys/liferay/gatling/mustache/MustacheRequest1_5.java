package com.excilys.liferay.gatling.mustache;

public class MustacheRequest1_5 implements MustacheRequest {

	
	MustacheRequest1_5(String name, String url, int d, String virgule) {
		this.url = url;
		this.name = name;
		this.pourcentage = d;
		this.virgule = virgule;
	}

	@Override
	public void setWeight(Object i) {
		this.pourcentage = (Integer) i;
	}

	@Override
	public void removeComma(){
		virgule = "";
	}

	String name, url, virgule;
	int pourcentage;


}
