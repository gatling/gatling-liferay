package com.excilys.liferay.gatling.dto;



public class ProcessDTO {

	private String name;
	private long id;
	private int pause;
	
	public ProcessDTO(String name, long id, int pause) {
		this.name = name;
		this.id = id;
		this.pause = pause;
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

	public int getPause() {
		return pause;
	}

	public void setPause(int pause) {
		this.pause = pause;
	}
	
	
	
	
	
}
