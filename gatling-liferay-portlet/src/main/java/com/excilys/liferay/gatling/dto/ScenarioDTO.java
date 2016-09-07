package com.excilys.liferay.gatling.dto;

import java.util.List;

public class ScenarioDTO {
	
	private String name;
	private long id;
	private List<ProcessDTO> processes;

	public ScenarioDTO() {}
	
	public ScenarioDTO(String name, long l, List<ProcessDTO> processes) {
		this.name = name;
		this.id = l;
		this.processes = processes;
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

	public List<ProcessDTO> getProcesses() {
		return processes;
	}

	public void setProcesses(List<ProcessDTO> processes) {
		this.processes = processes;
	}
	
	@Override
	public String toString() {
		return "ScenarioDTO [name=" + name + ", id=" + id + ", processes="
				+ processes + "]";
	}
}
