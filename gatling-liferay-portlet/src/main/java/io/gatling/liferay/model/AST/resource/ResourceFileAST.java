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
package io.gatling.liferay.model.AST.resource;

import java.util.ArrayList;
import java.util.List;

/**
 * ResourceFileAST represents all the data related to processes.
 *
 * It includes feeders, bodies and scala files that will be generated at execution.
 * All the resource files knows how to be handled (name, location and content).
 * Since the content depends on the resource type, each child implements getContent his own way.
 */
public abstract class ResourceFileAST {
	
	/** The name of the resource File */
	protected String name;
	
	/** The type of the resource File */
	protected String type;
	
	/** The folder where the resource File is */
	protected String location;
	
	protected ResourceFileAST(String name, String type, String location) {
		this.name = name;
		this.type = type;
		this.location = location;
	}
	
	/**
	 * Computes the name of the resource file with his location
	 * @return the resource file name
	 */
	public String getLocatedName() {
		return location + getName();
	}
	
	/**
	 * Computes the name of the resource file
	 * @return the resource file name
	 */
	public String getName() {
		return type + name;
	}
	
	/**
	 * Computes the Resource file content.
	 * @return the content of the feeder file
	 */
	public abstract String getContent();
	
	/**
	 * Returns this resource file plus the resource files that this one depends on.
	 * The default behaviour is to return a list containing this resource file
	 * @return the referenced resource files
	 */
	public List<ResourceFileAST> flatWithSubsequentRessourceFile() {
		List<ResourceFileAST> resource = new ArrayList<>(1);
		resource.add(this);
		return resource;
	}
	
	@Override
	public String toString() {
		return this.getLocatedName();
	}
	
}
