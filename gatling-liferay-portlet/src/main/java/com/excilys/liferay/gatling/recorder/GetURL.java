package com.excilys.liferay.gatling.recorder;

public class GetURL extends RecordURL{
	
	public GetURL(String method, String requestURL, String params) {
		super(method,requestURL,params,"GET");
	}

}
