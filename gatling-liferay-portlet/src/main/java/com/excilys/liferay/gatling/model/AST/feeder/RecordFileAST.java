package com.excilys.liferay.gatling.model.AST.feeder;

import com.excilys.liferay.gatling.model.AST.feeder.data.RecordDataAST;

import java.util.ArrayList;
import java.util.List;

public class RecordFileAST extends ScalaFileAST {

	private static final String TYPE = "Record";

	private List<RecordDataAST> data;

	public RecordFileAST(String name, List<RecordDataAST> data) {
		super(name, TYPE);
		this.data = data;
	}

	@Override
	public String getContent() {
		StringBuilder contentBuilder = new StringBuilder();
		fillHeader(contentBuilder);
		for (int i = 0; i < data.size(); i++) {
			contentBuilder.append("    ");
			if(i > 0){
				contentBuilder.append(").");
			}
			contentBuilder.append("exec(");
			contentBuilder.append(data.get(i).getContent());
			if(i == data.size() - 1) {
				contentBuilder.append("    )\n");
			}
		}
		contentBuilder.append("}\n");
		return contentBuilder.toString();
	}

	private void fillHeader(StringBuilder contentBuilder) {
		contentBuilder.append("package liferay.processes\n\n")
				.append("import io.gatling.core.Preder._\n")
				.append("import io.gatling.core.session\n")
				.append("import io.gatling.http.Preder._\n\n")
				.append("/**\n * A recorded navigation.\n */\n")
				.append("object ").append(name).append(" {\n\n")
				.append("  val run =\n");
	}

	@Override
	public List<ResourceFileAST> flatWithSubsequentRessourceFile() {
		List<ResourceFileAST> feeders = new ArrayList<>();
		for (RecordDataAST recordDataAST : data) {
			ResourceFileAST feeder = recordDataAST.getData();
			if (feeder != null) {
				List<ResourceFileAST> subsequentFeeders = feeder
						.flatWithSubsequentRessourceFile();
				if (subsequentFeeders != null) {
					feeders.addAll(subsequentFeeders);
				}
			}
		}
		feeders.add(this);
		return feeders;
	}

	@Override
	public String toString() {
		return super.toString() + "[" + data.toString() + "]";
	}

}
