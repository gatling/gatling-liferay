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

import io.gatling.generation.AST.resource.data.FormDataAST;

import java.util.ArrayList;
import java.util.List;

/**
 * This resource inner content represents the data of a form.
 * It is actually used as a subpart of a RecordFileAST.
 */
public class FormParamFileAST extends InnerContent {

	private static final String TYPE = "FormParam";
	private List<FormDataAST> forms;

	public FormParamFileAST(String name, String content) {
		super(name, TYPE);
		forms = new ArrayList<>();
		String[] params = content.split("\n");
		for (String param : params) {
			if (!param.isEmpty()) {
				forms.add(new FormDataAST(param));
			}
		}
	}

	@Override
	public String getContent() {
		StringBuilder sb = new StringBuilder();
		for (FormDataAST formDataAST : forms) {
			sb.append(formDataAST.getContent());
		}
		return sb.toString();
	}

}
