/**
 * Copyright 2015 Altendis, Groupe Excilys (www.altendis.fr)
 */
package io.gatling.liferay.validator;



import java.util.ArrayList;
import java.util.List;

import io.gatling.liferay.model.LinkUsecaseRequest;
import io.gatling.liferay.model.Request;
import com.liferay.portal.kernel.util.Validator;

public class LinkUsecaseRequestValidator {

	/**
	 * Validate {@link Request} 
	 * @param {@link Request} request
	 * @return {@link List} errors
	 */
	public static List<String> validateLinkUsecaseRequest(LinkUsecaseRequest linkUsecaseRequest) {
		List<String> errors = new ArrayList<String>();
		
		if (Validator.isNull(linkUsecaseRequest.getRecordId())) {
			errors.add("link-recordid-missing");
		}
		
		if (Validator.isNull(linkUsecaseRequest.getWeight())) {
			errors.add("link-weight-required");
		}
		
		if (Validator.isNull(linkUsecaseRequest.getRequest_id())) {
			errors.add("link-requestid-missing");
		}

		return errors;
	}

}