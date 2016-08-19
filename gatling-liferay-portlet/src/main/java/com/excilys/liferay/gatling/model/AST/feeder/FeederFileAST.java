package com.excilys.liferay.gatling.model.AST.feeder;

import java.util.List;

/**
 * The representation of a Feeder file and his content.
 */
public abstract class FeederFileAST {
	
	/** The name of the feederFile */
	protected String name = "";
	
	/** The type of the feederFile */
	protected String type = "";
	
	/**
	 * Computes the name of the feeder file
	 * @return the feeder file name
	 */
	public String getName() {
		return type + name + ".csv";
	}
	
	/**
	 * Computes the Feeder file content.
	 * @return the content of the feeder file
	 */
	public abstract String getContent();
	
	/**
	 * Returns this feeder plus the feeders that this feeder depends on.
	 * @return the referenced feeders
	 */
	public abstract List<FeederFileAST> flatWithSubsequentFeeders();
	
}
