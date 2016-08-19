package com.excilys.liferay.gatling.model.AST.process;

import com.excilys.liferay.gatling.model.AST.feeder.FeederFileAST;

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
	public List<FeederFileAST> getFeederFiles() {
		return recordFeeder.flatWithSubsequentFeeders();
	}

}
