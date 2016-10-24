/**
 * Copyright 2011-2016 GatlingCorp (http://gatling.io)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * 		http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
