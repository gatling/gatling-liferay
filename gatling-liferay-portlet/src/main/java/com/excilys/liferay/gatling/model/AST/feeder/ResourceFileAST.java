package com.excilys.liferay.gatling.model.AST.feeder;

import java.util.List;

public abstract class ResourceFileAST {
	
	/** The name of the resource File */
	protected String name;
	
	/** The type of the resource File */
	protected String type;
	
	protected ResourceFileAST(String name, String type) {
		this.name = name;
		this.type = type;
	}
	
	/**
	 * Computes the name of the resource file
	 * @return the resource file name
	 */
	public abstract String getName();
	
	/**
	 * Computes the Resource file content.
	 * @return the content of the feeder file
	 */
	public abstract String getContent();
	
	/**
	 * Returns this resource file plus the resource files that this one depends on.
	 * @return the referenced resource files
	 */
	public abstract List<FeederFileAST> flatWithSubsequentRessourceFile();
	
	
}
