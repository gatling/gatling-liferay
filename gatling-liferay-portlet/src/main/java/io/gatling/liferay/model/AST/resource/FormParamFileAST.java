package io.gatling.liferay.model.AST.resource;

import io.gatling.liferay.model.AST.resource.data.FormDataAST;

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
