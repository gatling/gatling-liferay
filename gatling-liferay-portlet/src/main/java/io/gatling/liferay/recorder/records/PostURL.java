package io.gatling.liferay.recorder.records;

import io.gatling.liferay.model.UrlRecordType;
import io.gatling.liferay.service.FormParamLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;

import java.util.Map;

//TODO: Comment Me!

public class PostURL extends RecordURL {
	
	Map<String, String> formParams;
	
	public PostURL(String requestURL, String params, Map<String, String> formParams) {
		super(UrlRecordType.POST.name(), requestURL, params);
		this.formParams = formParams;
	}

	@Override
	protected void saveData(long primaryKey) throws SystemException {
		FormParamLocalServiceUtil.save(primaryKey, computesFormData());
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
				+ params + ", formData=" + computesFormData() + "]";
	}
	
}
