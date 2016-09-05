package com.excilys.liferay.gatling.dto;



public class ProcessDTO implements Comparable<ProcessDTO>{

	private String name;
	private long id;
	private String type;
	
	public ProcessDTO(String name, long id, String type) {
		this.name = name;
		this.id = id;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public String getType() {
		return type;
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

}
