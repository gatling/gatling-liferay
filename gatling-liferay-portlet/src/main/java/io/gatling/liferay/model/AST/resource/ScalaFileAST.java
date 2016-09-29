package io.gatling.liferay.model.AST.resource;


/**
 * The representation of a Scala File that contains some data.
 * These files will be placed in the code processes part of the 
 * code source in the simulation section of the Gatling bundle.
 */
public abstract class ScalaFileAST extends ResourceFileAST {

	public static final String LOCATION = "simulations/liferay/processes/";
	
	public ScalaFileAST(String name, String type) {
		super(name, type, LOCATION);
	}

	@Override
	public String getLocatedName() {
		return super.getLocatedName() + ".scala";
	}
	
}
