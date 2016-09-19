package io.gatling.liferay.model.AST.process;

import io.gatling.liferay.model.AST.feeder.RecordFileAST;
import io.gatling.liferay.model.AST.feeder.ResourceFileAST;

import java.util.List;

public class RecorderAST extends ProcessAST {

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
	public List<ResourceFileAST> getFeederFiles() {
		return recordResource.flatWithSubsequentRessourceFile();
	}

	@Override
	public String toString() {
		return "Object: " + scalaObject + "\tFunction: " + scalaFunction + "\tFeeder: " + recordResource;
	}
	
}
