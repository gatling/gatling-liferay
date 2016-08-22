package com.excilys.liferay.gatling.recorder.records;

import com.excilys.liferay.gatling.model.FormParamType;
import com.excilys.liferay.gatling.service.FormParamLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;

import java.util.Map;

//TODO: Comment Me!

public class PostURL extends RecordURL {
	
	protected String formType;
	
	Map<String, String> formParams;
	
	public PostURL(String requestURL, String params, Map<String, String> formParams) {
		super("POST", requestURL, params);
		this.formParams = formParams;
		this.formType = FormParamType.NORMAL.name();
	}

	@Override
	protected void saveData(long primaryKey) throws SystemException {
		FormParamLocalServiceUtil.save(primaryKey, computesFormData(), formType);
	}

	private String computesFormData(){
		StringBuilder dataBuilder = new StringBuilder();
		for (String key : formParams.keySet()) {
			dataBuilder.append(key).append(",").append(formParams.get(key)).append("\n");
		}
		return dataBuilder.toString();
	}
	
	@Override
	public String toString() {
		return "RecordURL [method=" + method + ", url=" + url + ", params="
				+ params + ", formType=" + formType + ", formData=" + computesFormData() + "]";
	}
	
}
