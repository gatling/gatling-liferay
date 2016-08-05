package com.excilys.liferay.gatling.mustache;

public class DefaultMustachScenario {
	
	private String scenarioName;
	private long users;
	private long rampUp;

	public DefaultMustachScenario(String scenarioName, long users, long rampUp) {
		super();
		this.scenarioName = scenarioName;
		this.users = users;
		this.rampUp = rampUp;
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

}
