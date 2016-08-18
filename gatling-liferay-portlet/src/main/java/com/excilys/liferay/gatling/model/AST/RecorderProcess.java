package com.excilys.liferay.gatling.model.AST;

import java.util.ArrayList;

public class RecorderProcess extends ProcessAST {

	public RecorderProcess(String feeder) {
		this.params = new ArrayList<>();
		params.add(feeder);
		this.scalaFunction = "record";
		this.scalaObject = "Record";
	}
	
}
