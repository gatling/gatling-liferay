/**
 * Copyright 2011-2014 eBusiness Information, Groupe Excilys (www.ebusinessinformation.fr)
 */
package com.excilys.liferay.gatling.validator;



import com.excilys.liferay.gatling.model.Request;
import com.liferay.portal.kernel.util.Validator;

import java.util.ArrayList;
import java.util.List;

public class RequestValidator {

	/**
	 * Validate {@link Request} 
	 * @param {@link Request} request
	 * @return {@link List} errors
	 */
	public static List<String> validateRequest(Request request) {
		List<String> errors = new ArrayList<String>();
		
		if (Validator.isNull(request.getUrl())) {
			errors.add("request-url-missing");
		}
		
		if (Validator.isNull(request.getWeight())) {
			errors.add("request-weight-required");
		}
		
		if (Validator.isNull(request.getScenario_id())) {
			errors.add("request-scenarioid-required");
		}

		return errors;
	}

}