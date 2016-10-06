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
package io.gatling.liferay.generation.AST.resource;


/**
 * The representation of a Scala File that contains some data.
 * These files will be placed in the code processes part of the 
 * code source in the simulation section of the Gatling bundle.
 */
public abstract class ScalaFileAST extends ResourceFileAST {

	public static final String LOCATION = "simulations/liferay/processes/";
	
	public ScalaFileAST(String name, String type) {
		super(name, type, LOCATION);
	}

	@Override
	public String getLocatedName() {
		return super.getLocatedName() + ".scala";
	}
	
}
