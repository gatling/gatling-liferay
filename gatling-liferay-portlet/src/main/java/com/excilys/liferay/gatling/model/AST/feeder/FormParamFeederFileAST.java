package com.excilys.liferay.gatling.model.AST.feeder;

import java.util.ArrayList;
import java.util.List;

public class FormParamFeederFileAST extends FeederFileAST {

	private static final String TYPE = "FormParam";
	
	public FormParamFeederFileAST(String name) {
		super(name, TYPE);
	}
	
	@Override
	public String getContent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FeederFileAST> flatWithSubsequentRessourceFile() {
		List<FeederFileAST> feeders = new ArrayList<>();
		feeders.add(this);
		return feeders;
	}
	
	

}
