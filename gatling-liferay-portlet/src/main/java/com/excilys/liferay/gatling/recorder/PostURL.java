package com.excilys.liferay.gatling.recorder;

public class PostURL extends RecordURL {
	
	public PostURL(String method, String requestURL, String params) {
		super(method,requestURL,params,"POST");
	}

}
