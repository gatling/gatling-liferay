package com.excilys.liferay.gatling.mustache;

import java.util.List;

public class MustacheScenario {		

	MustacheScenario(String name,long l,long m, boolean last, List<MustacheRequest> mustacheRequests) {
		this.name = name;
		this.last = last;
		this.mustacheRequests = mustacheRequests;
		this.users = l;
		this.duration = m;
	}
	
	String name;
	long users, duration;
	List<MustacheRequest> mustacheRequests;
	boolean last;


}


