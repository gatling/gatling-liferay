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

import io.gatling.liferay.model.Record;
import com.liferay.portal.kernel.util.Validator;

import java.util.ArrayList;
import java.util.List;

public class RecordValidator {

	/**
	 * Validate {@Record} 
	 * @param {@Record} record
	 * @return {@link List} errors
	 */
	public static List<String> validateRecord(Record record) {
		List<String> errors = new ArrayList<String>();
		
		if (Validator.isNull(record.getRecordId())) {
			errors.add("record-id-missing");
		}
		
		if (Validator.isNull(record.getPortletId())) {
			errors.add("record-portletId-required");
		}
		
		if (Validator.isNull(record.getName())) {
			errors.add("record-name-required");
		}
		
		if (Validator.isNull(record.getVersionPortlet())) {
			errors.add("record-version-required");
		}

		return errors;
	}

}
