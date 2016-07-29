/**
 * Copyright 2015 Altendis, Groupe Excilys (www.altendis.fr)
 */
package com.excilys.liferay.gatling.mustache;

import java.util.List;

public class MustacheScenario {		

	MustacheScenario(String name,long l,long m, List<MustacheRequest> mustacheRequests, boolean hasPrivatePage, String loginPageURL, String siteURL, String logoutPageURL) {
		this.scenarioName = name;
		this.mustacheRequests = mustacheRequests;
		this.users = l;
		this.duration = m;
		this.hasPrivatePage = hasPrivatePage;
		this.loginPageURL = loginPageURL;
		this.siteURL = siteURL;
		this.logoutPageURL = logoutPageURL;
	}
	
	private String scenarioName;
	private long users, duration;
	private List<MustacheRequest> mustacheRequests;
	private boolean hasPrivatePage;
	private String loginPageURL;
	private String logoutPageURL;
	private String siteURL;
	
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
	public boolean isHasPrivatePage() {
		return hasPrivatePage;
	}
	public void setHasPrivatePage(boolean hasPrivatePage) {
		this.hasPrivatePage = hasPrivatePage;
	}
	public String getLoginPageURL() {
		return loginPageURL;
	}
	public void setLoginPageURL(String loginPageURL) {
		this.loginPageURL = loginPageURL;
	}
	public String getSiteURL() {
		return siteURL;
	}
	public void setSiteURL(String siteURL) {
		this.siteURL = siteURL;
	}
	public String getLogoutPageURL() {
		return logoutPageURL;
	}
	public void setLogoutPageURL(String logoutPageURL) {
		this.logoutPageURL = logoutPageURL;
	}
	
}


