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
package io.gatling.liferay.validator;

import io.gatling.liferay.model.UrlRecord;
import com.liferay.portal.kernel.util.Validator;

import java.util.ArrayList;
import java.util.List;

public class UrlRecordValidator {

	/**
	 * Validate {@urlRecord} 
	 * @param {@urlRecord} urlRecord
	 * @return {@link List} errors
	 */
	public static List<String> validateUrlRecord(UrlRecord urlRecord) {
		List<String> errors = new ArrayList<String>();
		
		if (Validator.isNull(urlRecord.getRecordId())) {
			errors.add("urlRecord-recordid-missing");
		}
		
		if (Validator.isNull(urlRecord.getUrl())) {
			errors.add("urlRecord-url-required");
		}
		
		if (Validator.isNull(urlRecord.getType())) {
			errors.add("urlRecord-type-required");
		}
		
		if (Validator.isNull(urlRecord.getOrder())) {
			errors.add("urlRecord-order-required");
		}

		return errors;
	}
}
