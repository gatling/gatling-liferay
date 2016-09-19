package io.gatling.liferay.recorder.records;

import io.gatling.liferay.model.UrlRecordType;


//TODO: Comment Me!

public class GetURL extends RecordURL{
	
	public GetURL(String requestURL, String params) {
		super(UrlRecordType.GET.name(), requestURL, params);
	}
	
}
