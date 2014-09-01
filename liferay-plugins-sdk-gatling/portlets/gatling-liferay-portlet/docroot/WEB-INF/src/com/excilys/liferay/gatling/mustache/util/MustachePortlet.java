package com.excilys.liferay.gatling.mustache.util;

public class MustachePortlet {

	private String object = null;
	private String variable = null;
	private boolean last = false;
	
	public MustachePortlet(String object, String variable) {
		this.object = object;
		this.variable = variable;
	}
	
	public String getObject() {
		return object;
	}
	public void setObject(String object) {
		this.object = object;
	}
	
	public String getVariable() {
		return variable;
	}
	public void setVariable(String variable) {
		this.variable = variable;
	}

	public boolean isLast() {
		return last;
	}

	public void setLast(boolean last) {
		this.last = last;
	}

}
