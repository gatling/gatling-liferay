package io.gatling.liferay.model.AST.resource;


/**
 * The representation of a Feeder file and his content.
 */
public abstract class FeederFileAST extends ResourceFileAST {
	
	private static final String LOCATION = "data/feeders/";
	
	protected FeederFileAST(String name, String type) {
		super(name, type, LOCATION);
	}

	@Override
	public String getLocatedName() {
		return super.getLocatedName() + ".csv";
	}
	
}
