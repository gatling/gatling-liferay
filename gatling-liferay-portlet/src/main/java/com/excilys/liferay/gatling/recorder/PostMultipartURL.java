package com.excilys.liferay.gatling.recorder;

import com.liferay.portal.kernel.exception.SystemException;

public class PostMultipartURL extends RecordURL{
	protected String formData;
	
	public PostMultipartURL(String method, String requestURL, String params, String formData) {
		super(method,requestURL,params,"POSTMULTIPART");
		this.formData = formData;
	}
	
	@Override
	protected void persistData(long primaryKey) throws SystemException {
		//FormParamLocalServiceUtil.save(primaryKey, formData, type);
	}
}
