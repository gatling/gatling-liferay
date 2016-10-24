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

import io.gatling.generation.AST.resource.RecordFileAST;
import io.gatling.generation.AST.resource.ResourceFileAST;

import java.util.List;

/**
 * RecorderAST represents a process in which a
 * a record will be replayed.
 */
public class RecorderAST extends ProcessAST {

	/**
	 * The record that will be replayed during the simulation.
	 */
	RecordFileAST recordResource;
	
	public RecorderAST(RecordFileAST recordResource) {
		super(recordResource.getName(), "run");
		this.recordResource = recordResource;
	} 

	@Override
	protected String computeArguments() {
		return "";
	}
	
	@Override
	public List<ResourceFileAST> getResourceFiles() {
		return recordResource.flatWithSubsequentRessourceFile();
	}

	@Override
	public String toString() {
		return "Object: " + scalaObject + "\tFunction: " + scalaFunction + "\tFeeder: " + recordResource;
	}
	
}
