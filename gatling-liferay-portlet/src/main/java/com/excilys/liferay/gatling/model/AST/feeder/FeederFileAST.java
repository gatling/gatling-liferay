package com.excilys.liferay.gatling.model.AST.feeder;


/**
 * The representation of a Feeder file and his content.
 */
public abstract class FeederFileAST extends ResourceFileAST {
	
	private static final String LOCATION = "data/feeders/";
	
	protected FeederFileAST(String name, String type) {
		super(name, type, LOCATION);
	}

	@Override
	public String getName() {
		return super.getName() + ".csv";
	}
	
}
