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
package io.gatling.generation.AST.resource;

/**
 * HttpBodyFileAST represents a resource file that will
 * store data contained in the payload of a multipart POST
 * HTTP request.
 * These resource files are stored as txt files in the bodies
 * subdirectory of the Gatling Bundle.
 */
public class HttpBodyFileAST extends ResourceFileAST {

	private static final String LOCATION = "bodies/liferay/";
	private static final String TYPE = "HttpBody";
	
	private String content;
	
	
	public HttpBodyFileAST(String name, String content) {
		super(name, TYPE, LOCATION);
		this.content = content;
	}

	@Override
	public String getLocatedName() {
		return super.getLocatedName() + ".txt";
	}

	@Override
	public String getContent() {
		return content;
	}

	
	
}
