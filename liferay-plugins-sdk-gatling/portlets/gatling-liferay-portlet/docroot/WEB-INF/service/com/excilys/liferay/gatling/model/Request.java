/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.excilys.liferay.gatling.model;

import com.liferay.portal.model.PersistedModel;

/**
 * One request equals one page of a Liferay site or one portlet of a page in a particular story : the probability that the user goes on the page (its weight). 
 * 
 * @generated
 */
public interface Request extends RequestModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.excilys.liferay.gatling.model.impl.RequestImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public boolean isUsed();
}