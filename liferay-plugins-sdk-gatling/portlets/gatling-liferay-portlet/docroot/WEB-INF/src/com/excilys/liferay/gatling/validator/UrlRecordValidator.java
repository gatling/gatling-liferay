package com.excilys.liferay.gatling.validator;

import com.excilys.liferay.gatling.model.UrlRecord;
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
