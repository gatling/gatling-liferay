/**
 * Copyright 2015 eBusiness Information, Groupe Excilys (www.ebusinessinformation.fr)
 */
package com.excilys.liferay.gatling.mustache;

public class MustacheScript {
	
	private String nameVariable = "";
	private double pourcentage = 0.0;
	
	public MustacheScript(String nameariable, double pourcentage) {
		this.nameVariable = nameariable;
		this.pourcentage = pourcentage;
	}

	public String getNameVariable() {
		return nameVariable;
	}

	public void setNameVariable(String nameVariable) {
		this.nameVariable = nameVariable;
	}

	public double getPourcentage() {
		return pourcentage;
	}

	public void setPourcentage(double pourcentage) {
		this.pourcentage = pourcentage;
	}

}
