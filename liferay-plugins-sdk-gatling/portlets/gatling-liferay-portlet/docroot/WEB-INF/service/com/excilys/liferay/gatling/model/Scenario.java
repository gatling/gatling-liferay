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
 * One scenario is the story of many users on a Liferay site. It describes the number of users, the duration of the stress and the stressed pages. 
 * It contains different requests in the database. 
 * @generated
 */
public interface Scenario extends ScenarioModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.excilys.liferay.gatling.model.impl.ScenarioImpl} and rerun ServiceBuilder 
	 * to automatically copy the method declarations to this interface.
	 */
	public boolean isComplete();
}