package io.gatling.liferay.model.AST.feeder;

import java.util.ArrayList;
import java.util.List;

/**
 * InnerContent represents some file Content 
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
