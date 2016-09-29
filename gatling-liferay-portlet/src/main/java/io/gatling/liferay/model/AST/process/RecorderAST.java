package io.gatling.liferay.model.AST.process;

import io.gatling.liferay.model.AST.resource.RecordFileAST;
import io.gatling.liferay.model.AST.resource.ResourceFileAST;

import java.util.List;

/**
 * RecorderAST represents a process in which a
 * a record will be replayed.
 */
public class RecorderAST extends ProcessAST {

	/**
	 * The record that will be replayed during the simulation.
	 */
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
