package io.gatling.liferay.model.AST.resource;

import java.util.ArrayList;
import java.util.List;

/**
 * InnerContent represents resource data that must be
 * included into some other file.
 * Thus, it isn't really a plain file. 
 */
public abstract class InnerContent extends ResourceFileAST{

	private static final String LOCATION = "data/feeders/";
	
	protected InnerContent(String name, String type) {
		super(name, type, LOCATION);
	}

	@Override
	public List<ResourceFileAST> flatWithSubsequentRessourceFile() {
		return new ArrayList<>(0);
	}
}
