/**
 * Copyright 2011-2015 GatlingCorp (http://gatling.io)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * 		http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.gatling.generation.AST.resource.data;

import io.gatling.generation.AST.InvalidAST;
import io.gatling.generation.AST.resource.ResourceFileAST;
import io.gatling.liferay.model.UrlRecordType;

public class RecordDataAST {

	public static final String BODIES = "bodies/";

	private String url;
	private String type;
	private ResourceFileAST data;
	private int pauseTime;

	public RecordDataAST(String url, String type, ResourceFileAST data,
			int pause) {
		this.url = url;
		this.type = type;
		this.data = data;
		this.pauseTime = pause;
	}

	public String getUrl() {
		return url;
	}

	public String getType() {
		return type;
	}

	public int getPauseTime() {
		return pauseTime;
	}

	public ResourceFileAST getData() {
		return data;
	}

	public String getContent() {
		StringBuilder contentBuilder = new StringBuilder("http(\"Page ")
				.append(url).append("\")\n      ");

		switch (UrlRecordType.valueOf(type)) {
		case GET:
			contentBuilder.append(".get(\"").append(url).append("\")\n");
			break;

		case MULTIPART:
			contentBuilder.append(".post(\"").append(url).append("\")\n");
			if (data != null) {
				String fileName = data.getLocatedName();
				if (fileName.startsWith(BODIES)) {
					fileName = fileName.substring(BODIES.length());
				}
				contentBuilder.append("      .bodyPart(RawFileBodyPart(\"")
						.append(fileName).append("\"))\n");
			} else {
				throw new InvalidAST();
			}
			break;

		case POST:
			contentBuilder.append(".post(\"").append(url).append("\")\n");
			if (data != null) {
				contentBuilder.append(data.getContent());
			} else {
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
