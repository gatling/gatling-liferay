package com.excilys.liferay.gatling.mustache;

public class MustacheScript {
	
	private String nameVariable = "";
	private double pourcentage = 0.0;
	private boolean last;
	
	public MustacheScript(String nameariable, double pourcentage) {
		this.nameVariable = nameariable;
		this.last  = false;
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

	public boolean isLast() {
		return last;
	}

	public void setLast(boolean last) {
		this.last = last;
	}
	
	

}
