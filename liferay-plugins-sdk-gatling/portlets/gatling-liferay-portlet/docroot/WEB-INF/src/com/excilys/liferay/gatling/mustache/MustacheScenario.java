/**
 * Copyright 2011-2014 eBusiness Information, Groupe Excilys (www.ebusinessinformation.fr)
 */
package com.excilys.liferay.gatling.mustache;

import java.util.List;

public class MustacheScenario {		

	MustacheScenario(String name,long l,long m, List<MustacheRequest> mustacheRequests, boolean hasPrivatePage, String login, String password, String loginPageURL, String siteURL) {
		this.scenarioName = name;
		this.mustacheRequests = mustacheRequests;
		this.users = l;
		this.duration = m;
		this.hasPrivatePage = hasPrivatePage;
		this.login = login;
		this.password = password;
		this.loginPageURL = loginPageURL;
		this.siteURL = siteURL;
		
	}
	
	private String scenarioName;
	private long users, duration;
	private List<MustacheRequest> mustacheRequests;
	private boolean hasPrivatePage;
	private String login;
	private String password;
	private String loginPageURL;
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
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
}


