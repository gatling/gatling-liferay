package com.excilys.liferay.gatling.validator;

import com.excilys.liferay.gatling.model.Record;
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
