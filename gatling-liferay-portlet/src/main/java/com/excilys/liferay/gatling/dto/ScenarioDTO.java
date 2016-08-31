package com.excilys.liferay.gatling.dto;

import java.util.List;

public class ScenarioDTO {
	
	private String name;
	private List<ProcessDTO> processes;

	public ScenarioDTO(String name, List<ProcessDTO> processes) {
		this.name = name;
		this.processes = processes;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<ProcessDTO> getProcesses() {
		return processes;
	}

	public void setProcesses(List<ProcessDTO> processes) {
		this.processes = processes;
	}
	
	
	
}
