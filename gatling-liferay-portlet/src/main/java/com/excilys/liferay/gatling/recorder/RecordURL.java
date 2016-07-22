package com.excilys.liferay.gatling.recorder;

import com.excilys.liferay.gatling.service.UrlRecordLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;

public abstract class RecordURL {
	protected String method;
	protected String url;
	protected String type;
	protected String params;
	
	protected RecordURL(String method, String requestURL, String params, String type) {
		this.method = method;
		this.url = requestURL;
		this.params = params;
		this.type = type;
	}

	public String getMethod() {
		return method;
	}

	public String getUrl() {
		return url;
	}

	public String getParams() {
		return params;
	}

	
	@Override
	public String toString() {
		return "RecordURL [method=" + method + ", url=" + url + ", params="
				+ params + ", type="+type+"]";
	}

	
	public final void saveURL(int order, long recordId) throws SystemException {
		//long primaryKey = UrlRecordLocalServiceUtil.save(url, method, order, recordId);
		//persistData(primaryKey);
	}
	
	protected void persistData(long primaryKey) throws SystemException{
		//DOES nothing, custom behaviour has to be implemented in child classes
	}
}

