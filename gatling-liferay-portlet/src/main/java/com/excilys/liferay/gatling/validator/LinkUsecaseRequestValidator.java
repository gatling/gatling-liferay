/**
 * Copyright 2015 eBusiness Information, Groupe Excilys (www.ebusinessinformation.fr)
 */
package com.excilys.liferay.gatling.validator;



import java.util.ArrayList;
import java.util.List;

import com.excilys.liferay.gatling.model.LinkUsecaseRequest;
import com.excilys.liferay.gatling.model.Request;
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