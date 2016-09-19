/**
 * Copyright 2015 Altendis, Groupe Excilys (www.altendis.fr)
 */
package io.gatling.liferay.validator;



import java.util.ArrayList;
import java.util.List;

import io.gatling.liferay.model.Request;
import com.liferay.portal.kernel.util.Validator;

public class RequestValidator {

	/**
	 * Validate {@link Request} 
	 * @param {@link Request} request
	 * @return {@link List} errors
	 */
	public static List<String> validateRequest(Request request) {
		List<String> errors = new ArrayList<String>();
		
		if (Validator.isNull(request.getWeight())) {
			errors.add("request-weight-required");
		}
		
		if (Validator.isNull(request.getScenario_id())) {
			errors.add("request-scenarioid-required");
		}

		return errors;
	}

}