package com.excilys.liferay.gatling.model.AST.feeder;

import com.excilys.liferay.gatling.model.AST.feeder.data.FormDataAST;

import java.util.ArrayList;
import java.util.List;

public class FormParamFileAST extends InnerContent {

	private static final String TYPE = "FormParam";
	private List<FormDataAST> forms;

	public FormParamFileAST(String name, String content) {
		super(name, TYPE);
		System.out.println("Content" + content);
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
