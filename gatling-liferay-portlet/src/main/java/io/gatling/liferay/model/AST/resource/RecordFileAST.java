package io.gatling.liferay.model.AST.resource;

import io.gatling.liferay.model.AST.resource.data.RecordDataAST;

import java.util.ArrayList;
import java.util.List;

/**
 * RecordFileAST contains all the data related to one record
 * 
 * It handles multiple RecordDatas, and processes them during the generation:
 *
 */
public class RecordFileAST extends ScalaFileAST {

	private static final String TYPE = "Record";

	private List<RecordDataAST> data;

	public RecordFileAST(String name, List<RecordDataAST> data) {
		super(name, TYPE);
		this.data = data;
	}

	/*
	 * The following code generates a Record scala file with all the chainBuilder execution.
	 * Since Mustach is logicless, we used polymorphisme instead.
	 * 
	 */
	@Override
	public String getContent() {
		final String space = "    ";
		StringBuilder contentBuilder = new StringBuilder();
		fillHeader(contentBuilder);
		
		for (int i = 0; i < data.size(); i++) {
			
			if (i == 0) { // Indent first line
				contentBuilder.append(space);
			}
			
			contentBuilder.append("exec(")
			.append(data.get(i).getContent())
			.append(space)
			.append(")\n")
			.append(space)
			.append(".pause(")
			.append(data.get(i).getPauseTime())
			.append(")\n");
			
			if(i != data.size() - 1) {
				contentBuilder.append(space)
				.append(".");
			}
		}
		contentBuilder.append("}\n");
		return contentBuilder.toString();
		
	}

	/*
	 * Handles the scala file header generation (package definition, imports...)
	 */
	private void fillHeader(StringBuilder contentBuilder) {
		contentBuilder.append("package liferay.processes\n\n")
				.append("import io.gatling.core.Predef._\n")
				.append("import io.gatling.core.session\n")
				.append("import io.gatling.http.Predef._\n\n")
				.append("/**\n * A recorded navigation.\n */\n")
				.append("object ").append(getName()).append(" {\n\n")
				.append("  def run() =\n");
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
