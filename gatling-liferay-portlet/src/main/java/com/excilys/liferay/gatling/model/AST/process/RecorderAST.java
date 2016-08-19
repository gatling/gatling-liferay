package com.excilys.liferay.gatling.model.AST.process;

import com.excilys.liferay.gatling.model.AST.feeder.FeederFileAST;

import java.util.ArrayList;
import java.util.List;

public class RecorderAST extends ProcessAST {

	FeederFileAST recordFeeder;
	
	public RecorderAST(String feeder) {
		this.params = new ArrayList<>();
		params.add(feeder);
		this.scalaFunction = "record";
		this.scalaObject = "Record";
	}

	@Override
	public List<FeederFileAST> getFeederFiles() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
