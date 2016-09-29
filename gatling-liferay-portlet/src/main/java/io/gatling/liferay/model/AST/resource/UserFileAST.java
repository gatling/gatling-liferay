package io.gatling.liferay.model.AST.resource;

/**
 * Represents an user feeder file, used for the login profile.
 */
public class UserFileAST extends FeederFileAST {
	
	private static final String TYPE = "User";
	private String content;
	private static final String HEADER = "user,password\n";
	
	public UserFileAST(String name, String content) {
		super(name, TYPE);
		this.content = content;
	}

	@Override
	public String getContent() {
		return HEADER + content;
	}
	
}
