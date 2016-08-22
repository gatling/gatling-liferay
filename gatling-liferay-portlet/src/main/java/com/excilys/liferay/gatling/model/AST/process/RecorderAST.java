package com.excilys.liferay.gatling.model.AST.process;

import com.excilys.liferay.gatling.model.AST.feeder.FeederFileAST;
import com.excilys.liferay.gatling.model.AST.feeder.ResourceFileAST;

import java.util.List;

public class RecorderAST extends ProcessAST {

	FeederFileAST recordFeeder;
	
	public RecorderAST(FeederFileAST recordFeeder) {
		super("Record", "record");
		this.recordFeeder = recordFeeder;
	}
	
	@Override
	protected String computeArguments() {
		return '"' + recordFeeder.getName() + '"';
	}
	
	@Override
	public List<ResourceFileAST> getFeederFiles() {
		return recordFeeder.flatWithSubsequentRessourceFile();
	}

}
