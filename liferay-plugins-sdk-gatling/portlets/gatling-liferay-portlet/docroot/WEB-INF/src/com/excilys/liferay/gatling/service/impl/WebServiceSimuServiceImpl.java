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

package com.excilys.liferay.gatling.service.impl;

import java.io.FileNotFoundException;
import java.io.FileReader;

import com.excilys.liferay.gatling.mustache.ScriptGeneratorGatling;
import com.excilys.liferay.gatling.service.base.WebServiceSimuServiceBaseImpl;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.samskivert.mustache.Mustache;
import com.samskivert.mustache.MustacheException;
import com.samskivert.mustache.Template;

/**
 * The implementation of the web service simu remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.excilys.liferay.gatling.service.WebServiceSimuService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.excilys.liferay.gatling.service.base.WebServiceSimuServiceBaseImpl
 * @see com.excilys.liferay.gatling.service.WebServiceSimuServiceUtil
 */
@JSONWebService
public class WebServiceSimuServiceImpl extends WebServiceSimuServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.excilys.liferay.gatling.service.WebServiceSimuServiceUtil} to access the web service simu remote service.
	 */
	
	public String getSimulation(long simuId, String login, String password) {

		String location = this.getClass().getResource("").getPath()+"../../../../../../../src/resources";
		String currentPath = location + "/templateGatling2.0.RC4.mustache";
		String script = "";
		Template tmpl = null;
		try {
			tmpl = Mustache.compiler().compile(new FileReader(currentPath));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		try {
			script = tmpl.execute(new ScriptGeneratorGatling(simuId)).replace("\t", "&#13;").replace("\n", "&#10;");
		} catch (MustacheException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return script;
	}
}