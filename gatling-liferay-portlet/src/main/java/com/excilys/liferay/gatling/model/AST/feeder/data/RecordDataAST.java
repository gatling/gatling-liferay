package com.excilys.liferay.gatling.model.AST.feeder.data;

import com.excilys.liferay.gatling.model.UrlRecordType;
import com.excilys.liferay.gatling.model.AST.InvalidAST;
import com.excilys.liferay.gatling.model.AST.feeder.ResourceFileAST;

public class RecordDataAST {

	public static final String HEADER = "url,type,datafile";

	public static final String BODIES = "bodies/";
	
	private String url;
	private String type;
	private ResourceFileAST data;

	public RecordDataAST(String url, String type, ResourceFileAST data) {
		this.url = url;
		this.type = type;
		this.data = data;
	}

	public String getUrl() {
		return url;
	}

	public String getType() {
		return type;
	}

	public ResourceFileAST getData() {
		return data;
	}

	public String getContent() {
		StringBuilder contentBuilder = new StringBuilder("http(\"Page ")
				.append(url)
				.append("\")\n      ");
		
		switch(UrlRecordType.valueOf(type)){
			case GET:
				contentBuilder.append(".get(\"")
						.append(url)
						.append("\")\n");
				break;
				
			case MULTIPART:
				contentBuilder.append(".post(\"")
						.append(url)
						.append("\")\n");
				if(data != null){
					String fileName = data.getName();
					if(fileName.startsWith(BODIES)) {
						fileName = fileName.substring(BODIES.length());
					}
					contentBuilder.append("      .bodyPart(RawFileBodyPart(\"")
							.append(fileName)
							.append("\"))\n");
				}
				else {
					throw new InvalidAST();
				}
				break;
				
			case POST:
				contentBuilder.append(".post(\"")
				.append(url)
				.append("\")\n");
				if(data != null){
					contentBuilder.append(data.getContent());
				}
				else {
					throw new InvalidAST();
				}
				break;
		}
		return contentBuilder.toString();
	}

	@Override
	public String toString() {
		return "URL: " + url + ", DATA: "
				+ (data != null ? data.toString() : "none");
	}

}
