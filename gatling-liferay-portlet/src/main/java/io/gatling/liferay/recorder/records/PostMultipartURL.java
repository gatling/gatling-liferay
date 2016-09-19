package io.gatling.liferay.recorder.records;

import io.gatling.liferay.model.UrlRecordType;
import io.gatling.liferay.service.FormParamLocalServiceUtil;
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
