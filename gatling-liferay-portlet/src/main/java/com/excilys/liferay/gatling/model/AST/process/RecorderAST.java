package com.excilys.liferay.gatling.model.AST.process;

import com.excilys.liferay.gatling.model.AST.feeder.RecordFileAST;
import com.excilys.liferay.gatling.model.AST.feeder.ResourceFileAST;

import java.util.List;

public class RecorderAST extends ProcessAST {

	RecordFileAST recordResource;
	
	public RecorderAST(RecordFileAST recordResource) {
		super("Record", "record");
		this.recordResource = recordResource;
	}
	
	@Override
	protected String computeArguments() {
		return '"' + recordResource.getName() + '"';
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
