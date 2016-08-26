package com.excilys.liferay.gatling.recorder.records;

import com.excilys.liferay.gatling.service.UrlRecordLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;

//TODO: Comment Me !

public abstract class RecordURL {
	protected String method;
	protected String url;
	protected String params;
	protected int pauseTime;
	
	

	protected RecordURL(String method, String requestURL, String params) {
		this.method = method;
		this.url = requestURL;
		this.params = params;
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

	public int getPauseTime() {
		return pauseTime;
	}
	
	public void setPauseTime(int pauseTime) {
		this.pauseTime = pauseTime;
	}

	@Override
	public String toString() {
		return "RecordURL [method=" + method + ", url=" + url + ", params="
				+ params + "]";
	}

	public final void saveURL(int order, long recordId, int pauseTime) throws SystemException {
		long primaryKey = UrlRecordLocalServiceUtil.save(url, method, order, recordId, pauseTime);
		saveData(primaryKey);
	}
	
	protected void saveData(long primaryKey) throws SystemException{
		//DOES nothing, custom behaviour has to be implemented in child classes
	}
}

