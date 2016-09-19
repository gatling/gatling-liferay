/**
 * Copyright 2016 Gatling Corp (www.gatling.io)
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
