package com.excilys.liferay.gatling.validator;



import com.liferay.portal.kernel.util.Validator;
import com.liferay.sample.model.Request;

import java.util.List;

public class RequestValidator {

	/**
	 * Validate Scenario
	 * 
	 * @param simulation
	 *            to be validated
	 * @param errors
	 *            to populate with any errors
	 */

	public static boolean validateRequest(Request request, List<String> errors) {
		boolean valid = true;

		if (Validator.isNull(request.getUrl())) {
			errors.add("request-url-missing");
			valid = false;
		}
		
		if (Validator.isNull(request.getWeight())) {
			errors.add("request-weight-required");
			valid = false;
		}
		
		if (Validator.isNull(request.getScenario_id())) {
			errors.add("request-scenarioid-required");
			valid = false;
		}

		return valid;
	}

}