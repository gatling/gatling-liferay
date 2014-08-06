package com.excilys.liferay.gatling.mustache;

import java.util.List;

public class MustacheScenario {		

	
	
	MustacheScenario(String name,long l,long m, boolean last, List<MustacheRequest> mustacheRequests, boolean hasPrivatePage, String homeURL, String login, String password) {
		this.name = name;
		this.last = last;
		this.mustacheRequests = mustacheRequests;
		this.users = l;
		this.duration = m;
		this.hasPrivatePage = hasPrivatePage;
		this.homeURL = homeURL;
		this.login = login;
		this.password = password;
	}
	


	String name;
	long users, duration;
	List<MustacheRequest> mustacheRequests;
	boolean last;
	boolean hasPrivatePage;
	String homeURL;
	String login;
	String password;


}


