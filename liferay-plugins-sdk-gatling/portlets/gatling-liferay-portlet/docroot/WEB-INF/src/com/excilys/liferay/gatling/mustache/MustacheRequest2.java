package com.excilys.liferay.gatling.mustache;

public class MustacheRequest2 implements MustacheRequest {

	MustacheRequest2(String name, String url, double d, String virgule) {
		this.url = url;
		this.name = name;
		this.pourcentage = d;
		this.virgule = virgule;
	}

	@Override
	public void setWeight(Object i) {
		this.pourcentage = (Double) i;
	}

	@Override
	public void removeComma(){
		virgule = "";
	}

	String name, url, virgule;
	double pourcentage;
}


