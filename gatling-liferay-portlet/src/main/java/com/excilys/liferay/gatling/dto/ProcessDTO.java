package com.excilys.liferay.gatling.dto;



public class ProcessDTO implements Comparable<ProcessDTO>{

	private String name;
	private String cssId;
	private String cssClass;
	private String type;
	
	public ProcessDTO(String name, String cssId, String cssClass, String type) {
		this.name = name;
		this.cssId = cssId;
		this.cssClass = cssClass;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCssId() {
		return cssId;
	}

	public void setCssId(String cssId) {
		this.cssId = cssId;
	}
	
	public String getType() {
		return type;
	}
	
	public String getCssClass() {
		return cssClass;
	}

	public void setCssClass(String cssClass) {
		this.cssClass = cssClass;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean isPause(){
		return false;
	}
	
	public int compareTo(ProcessDTO other) {
		return this.name.compareTo(other.name);
	}

	/* Can't have a pause by default */
	public int getPause() {
		throw new IllegalStateException();
	}

}
