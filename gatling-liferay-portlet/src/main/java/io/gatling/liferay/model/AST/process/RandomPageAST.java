package io.gatling.liferay.model.AST.process;

import io.gatling.liferay.model.AST.resource.ResourceFileAST;

import java.util.ArrayList;
import java.util.List;


/*
 * TODO: It would be nice if the Random page could be
 * hit several times.
 */

/**
 * RandomPageAST represents a process in which a
 * random url from the siteMap resourceFile is 
 * requested.
 */
public class RandomPageAST extends ProcessAST {

	/**
	 * The resourceFile containing the siteMap and the
	 * percentages of chances that each page will be
	 * requested
	 */
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
