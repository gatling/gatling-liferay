package com.excilys.liferay.gatling.mustache;

import java.util.List;

public class MustacheScenario1_5 implements MustacheScenario {

	
	MustacheScenario1_5(String name,long l,long m, String virgule, List<MustacheRequest> mustacheRequests) {
		this.name = name;
		this.virgule = virgule;
		this.mustacheRequests = mustacheRequests;
		this.users = l;
		this.duration = m;
	}
	
	@Override
	public void removeComma(){
		virgule = "";
	}
	
	@Override
	public void removeCommaRequest(){
		if(!mustacheRequests.isEmpty()){
			mustacheRequests.get(mustacheRequests.size()-1).removeComma();
		}
	}


	String name, virgule;
	long users, duration;
	List<MustacheRequest> mustacheRequests;
}
