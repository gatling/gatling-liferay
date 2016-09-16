package com.excilys.liferay.gatling.model.AST.process;

import com.excilys.liferay.gatling.model.AST.feeder.ResourceFileAST;

import java.util.ArrayList;
import java.util.List;

public class RandomPageAST extends ProcessAST {

	ResourceFileAST siteMap;
	
	public RandomPageAST(ResourceFileAST feeder) {
		super(feeder.getName(), "run");
		this.siteMap = feeder;
	}

	@Override
	protected String computeArguments() {
		return "";
	}

	@Override
	public List<ResourceFileAST> getFeederFiles() {
		 List<ResourceFileAST> feeders = new ArrayList<>();
		 feeders.add(siteMap);
		 return feeders;
	}

}
