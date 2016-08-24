package com.excilys.liferay.gatling.model.AST.process;

import com.excilys.liferay.gatling.model.AST.feeder.FeederFileAST;
import com.excilys.liferay.gatling.model.AST.feeder.ResourceFileAST;

import java.util.ArrayList;
import java.util.List;

public class RandomPageAST extends ProcessAST {

	FeederFileAST siteMap;
	
	public RandomPageAST(FeederFileAST feeder) {
		super("GetPage", "randomPage");
		this.siteMap = feeder;
	}

	@Override
	protected String computeArguments() {
		return '"' + siteMap.getName() + '"';
	}

	@Override
	public List<ResourceFileAST> getFeederFiles() {
		 List<ResourceFileAST> feeders = new ArrayList<>();
		 feeders.add(siteMap);
		 return feeders;
	}

}
