package com.excilys.liferay.gatling.recorder.records;

import com.excilys.liferay.gatling.model.UrlRecordType;


//TODO: Comment Me!

public class GetURL extends RecordURL{
	
	public GetURL(String requestURL, String params) {
		super(UrlRecordType.GET.name(), requestURL, params);
	}
	
}
