package com.excilys.liferay.gatling.recorder.records;

import com.excilys.liferay.gatling.model.UrlRecordType;
import com.excilys.liferay.gatling.service.FormParamLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;

//TODO: Comment Me !

public class PostMultipartURL extends RecordURL{
	
	protected String formData;
	
	public PostMultipartURL(String requestURL, String params, String formData) {
		super(UrlRecordType.MULTIPART.name(), requestURL, params);
		this.formData = formData;
	}
	
	@Override
	protected void saveData(long primaryKey) throws SystemException {
		FormParamLocalServiceUtil.save(primaryKey, formData);
	}

	@Override
	public String toString() {
		return "RecordURL [method=" + method + ", url=" + url + ", params="
				+ params + ", formData=" + formData + "]";
	}
	
	
}
