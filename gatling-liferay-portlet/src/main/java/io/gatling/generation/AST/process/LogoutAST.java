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

import io.gatling.generation.AST.resource.ResourceFileAST;

import java.util.ArrayList;
import java.util.List;

/**
 * LogoutAST represents a process in which the
 * current virtual user in the simulation logs out.
 */
public class LogoutAST extends ProcessAST {
	
	public LogoutAST() {
		super("Logout", "logout");
	}
	
	@Override
	protected String computeArguments() {
		return "";
	}

	@Override
	public List<ResourceFileAST> getFeederFiles() {
		//No feederFile 
		return new ArrayList<>();
	}

}
