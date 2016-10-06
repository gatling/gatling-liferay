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
package io.gatling.liferay.generation.AST.process;

import io.gatling.liferay.generation.AST.resource.ResourceFileAST;

import java.util.ArrayList;
import java.util.List;


/*
 * TODO: It would be nice if the Random page could be
 * hit several times.
 */

/**
 * RandomPageAST represents a process in which a
 * random url from the siteMap resourceFile is 
 * requested.
 */
public class RandomPageAST extends ProcessAST {

	/**
	 * The resourceFile containing the siteMap and the
	 * percentages of chances that each page will be
	 * requested
	 */
	ResourceFileAST siteMap;
	
	public RandomPageAST(ResourceFileAST feeder) {
		super(feeder.getName(), "run");
		this.siteMap = feeder;
	}

	@Override
	protected String computeArguments() {
		return "";
	}

	@Override
	public List<ResourceFileAST> getFeederFiles() {
		 List<ResourceFileAST> feeders = new ArrayList<>();
		 feeders.add(siteMap);
		 return feeders;
	}

}
