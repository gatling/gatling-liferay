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
package io.gatling.liferay.model.AST.resource.data;

public class SiteMapDataAST {
	
	private String friendlyURL;
	private String url;
	private int weight;
	
	public SiteMapDataAST(String friendlyUrl, String url, int weight) {
		this.friendlyURL = friendlyUrl;
		this.url = url;
		this.weight = weight;
	}

	public String getFriendlyUrl() {
		return friendlyURL;
	}

	public String getUrl() {
		return url;
	}

	public int getWeight() {
		return weight;
	}

	@Override
	public String toString() {
		return "SiteMapDataAST friendlyUrl=" + friendlyURL + ", url=" + url + ", weight="
				+ weight + "]";
	}

	@Override
	public int hashCode() {
		return url.hashCode() + friendlyURL.hashCode() * 31;
	}
	
}
