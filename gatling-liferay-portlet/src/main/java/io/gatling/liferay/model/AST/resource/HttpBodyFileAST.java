package io.gatling.liferay.model.AST.resource;

/**
 * HttpBodyFileAST represents a resource file that will
 * store data contained in the payload of a multipart POST
 * HTTP request.
 * These resource files are stored as txt files in the bodies
 * subdirectory of the Gatling Bundle.
 */
public class HttpBodyFileAST extends ResourceFileAST {

	private static final String LOCATION = "bodies/liferay/";
	private static final String TYPE = "HttpBody";
	
	private String content;
	
	
	public HttpBodyFileAST(String name, String content) {
		super(name, TYPE, LOCATION);
		this.content = content;
	}

	@Override
	public String getLocatedName() {
		return super.getLocatedName() + ".txt";
	}

	@Override
	public String getContent() {
		return content;
	}

	
	
}
