/**
 * Copyright 2011-2014 eBusiness Information, Groupe Excilys (www.ebusinessinformation.fr)
 */
package com.excilys.liferay.gatling.mustache;

import java.util.List;

public class MustacheScenario {		

	MustacheScenario(String name,long l,long m, boolean last, List<MustacheRequest> mustacheRequests) {
		this.scenarioName = name;
		this.last = last;
		this.mustacheRequests = mustacheRequests;
		this.users = l;
		this.duration = m;
	}
	
	private String scenarioName;
	private long users, duration;
	private List<MustacheRequest> mustacheRequests;
	private boolean last;
	
	public String getScenarioName() {
		return scenarioName;
	}
	public void setScenarioName(String name) {
		this.scenarioName = name;
	}
	public long getUsers() {
		return users;
	}
	public void setUsers(long users) {
		this.users = users;
	}
	public long getDuration() {
		return duration;
	}
	public void setDuration(long duration) {
		this.duration = duration;
	}
	public List<MustacheRequest> getMustacheRequests() {
		return mustacheRequests;
	}
	public void setMustacheRequests(List<MustacheRequest> mustacheRequests) {
		this.mustacheRequests = mustacheRequests;
	}
	public boolean isLast() {
		return last;
	}
	public void setLast(boolean last) {
		this.last = last;
	}
	
}


