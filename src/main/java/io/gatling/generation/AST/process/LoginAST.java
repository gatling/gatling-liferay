/**
 * Copyright 2011-2015 GatlingCorp (http://gatling.io)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * 		http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.gatling.generation.AST.process;

import io.gatling.generation.AST.resource.FeederFileAST;
import io.gatling.generation.AST.resource.ResourceFileAST;

import java.util.ArrayList;
import java.util.List;

/**
 * LoginAST represents a process in which a
 * user from a feeder file is randomly selected
 * and logged in the portal. 
 */
public class LoginAST extends ProcessAST{

	/**
	 * The feederfile containing user data.
	 */
	FeederFileAST loginFeeder;
	
	private String url;
	
	public LoginAST(FeederFileAST feeder) {
		super("Login","successfulLogin");
		this.loginFeeder = feeder;
		this.url = "/home";
	}
	
	@Override
	protected String computeArguments() {
		return '"' + url + "\", \""  + loginFeeder.getLocatedName() + '"';
	}
	
	@Override
	public List<ResourceFileAST> getResourceFiles() {
		 List<ResourceFileAST> feeders = new ArrayList<>();
		 feeders.add(loginFeeder);
		 return feeders;
	}

}
