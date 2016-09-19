package io.gatling.liferay.model.AST.feeder.data;

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
