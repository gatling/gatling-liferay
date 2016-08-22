package com.excilys.liferay.gatling.model.AST.feeder;


/**
 * The representation of a Feeder file and his content.
 */
public abstract class FeederFileAST extends ResourceFileAST {
	
	protected FeederFileAST(String name, String type) {
		super(name, type);
	}

	@Override
	public String getName() {
		return type + name + ".csv";
	}
	
}
