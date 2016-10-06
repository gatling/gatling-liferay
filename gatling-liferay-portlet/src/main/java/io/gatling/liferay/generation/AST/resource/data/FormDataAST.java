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
package io.gatling.liferay.generation.AST.resource.data;

public class FormDataAST {
	private String key;
	private String value;
	
	public FormDataAST(String content) {
		int limit = content.indexOf(',');
		key = content.substring(0, limit);
		value = content.substring(limit+1,content.length());
	}
	
	public String getContent() {
		StringBuilder sb = new StringBuilder();
		sb.append("      .formParam(\"")
		.append(key)
		.append("\", \"")
		.append(value)
		.append("\")\n");
		return sb.toString();
	}
}
