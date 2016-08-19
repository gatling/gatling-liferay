package com.excilys.liferay.gatling.model.AST.process;

import com.excilys.liferay.gatling.model.AST.feeder.FeederFileAST;

import java.util.ArrayList;
import java.util.List;

public class RandomPageAST extends ProcessAST {

	public RandomPageAST() {
		super("GetPage", "randomPage");
	}

	@Override
	protected String computeArguments() {
		// TODO handdle feeder
		return "\"feeders/siteMapPage.csv\"";
	}

	@Override
	public List<FeederFileAST> getFeederFiles() {
		return new ArrayList<>();
	}

}
