package com.excilys.liferay.gatling.model.AST;

import com.excilys.liferay.gatling.model.AST.process.ProcessAST;

import java.util.ArrayList;
import java.util.List;

public class ScenarioAST {
	
	private String scenarioName;
	private long users;
	private long rampUp;
	private List<ProcessAST> processes;

	public ScenarioAST(String scenarioName, long users, long rampUp, List<ProcessAST> processList) {
		this.scenarioName = scenarioName;
		this.users = users;
		this.rampUp = rampUp;
		this.processes = processList;
	}

	public ScenarioAST(String scenarioName, long users, long rampUp) {
		this(scenarioName, users, rampUp, new ArrayList<ProcessAST>());
	}
	
	public String getScenarioName() {
		return scenarioName;
	}

	public void setScenarioName(String scenarioName) {
		this.scenarioName = scenarioName;
	}

	public long getUsers() {
		return users;
	}

	public void setUsers(long users) {
		this.users = users;
	}

	public long getRampUp() {
		return rampUp;
	}

	public void setRamUp(long rampup) {
		this.rampUp = rampup;
	}

	public List<ProcessAST> getProcesses() {
		return processes;
	}

	public void setProcesses(List<ProcessAST> processes) {
		this.processes = processes;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Scenario name: ");
		sb.append(this.scenarioName);
		sb.append("Processes: \n[");
		for(ProcessAST process : processes) {
			sb.append(process.toString());
			sb.append(",\t");
		}
		sb.append("\n]");
		
		//TODO append other properties: ramp up 
		//NOTE rampUp or not Rampup, that is the question (attribute related to scenarios or simulations?)
		return sb.toString();
	}
	
	public String printCode(){
		StringBuilder sb = new StringBuilder();
		final String spaceIndent = "      ";
		int i =0;
		for (ProcessAST process : processes) {
			sb.append(process.printCode());
			if(i+1 != processes.size()) {
				if (process.getPause()!=0) {
					sb.append(",\n").append(spaceIndent);
					sb.append("pause(").append(process.getPause()).append(")");
				}
				sb.append(",\n").append(spaceIndent);
			}
			i++;
		}
		return sb.toString();
	}
}
