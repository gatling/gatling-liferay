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
package io.gatling.liferay.model.AST.resource;

import io.gatling.liferay.model.AST.resource.data.SiteMapDataAST;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The representation of a scala file containing
 * the urls of all the siteMap page and the percentage
 * of chance to be hit during a	simulation.
 * 
 * This class handles the generation of the scala code
 * that will run the process of randomly select the
 * page that will be requested.
 */
public class SiteMapFileAST extends ScalaFileAST {

	private static final String TYPE = "SiteMap";

	private Map<SiteMapDataAST, Double> data;
	
	public SiteMapFileAST(String name, List<SiteMapDataAST> data) {
		super(name, TYPE);
		this.data = computePercents(data);
	}

	@Override
	public String getContent() {
		StringBuilder contentBuilder = new StringBuilder();
		fillHeader(contentBuilder);
		
		boolean first = true;
		
		contentBuilder.append("    randomSwitch(\n");
		for (SiteMapDataAST smdata : data.keySet()) {
			
			if(first) {
				first = false;
			}
			else {
				contentBuilder.append(",\n");
			}
			
			contentBuilder.append("      ")
				.append(data.get(smdata))
				.append(" -> exec(http(\"Random page: ")
				.append(smdata.getFriendlyUrl())
				.append("\").get(\"")
				.append(smdata.getUrl())
				.append("\"))");
			
		}
		contentBuilder.append("\n    )\n\n}");

		return contentBuilder.toString();
	}
	
	/**
	 * Computes the percentages of each siteMapDataAST.
	 * @return A map linking each siteMapDataAST to his percentage
	 * 		of chance to be chosen.
	 */
	private Map<SiteMapDataAST, Double> computePercents(List<SiteMapDataAST> sdata){
		
		//Computes the sum
		int sum = 0;
		for (SiteMapDataAST siteMapDataAST : sdata) {
			sum += siteMapDataAST.getWeight();
		}
		
		Map<SiteMapDataAST, Double> map = new HashMap<>();
		
		for (SiteMapDataAST siteMapDataAST : sdata) {
			map.put(siteMapDataAST, siteMapDataAST.getWeight() * 100. / sum);
		}
		
		return map;
	}
	
	
	/*
	 * Handles the scala file header (package definition, imports...)
	 */
	private void fillHeader(StringBuilder contentBuilder) {
		contentBuilder.append("package liferay.processes\n\n")
				.append("import io.gatling.core.Predef._\n")
				.append("import io.gatling.core.session\n")
				.append("import io.gatling.http.Predef._\n\n")
				.append("/**\n * A random navigation.\n */\n")
				.append("object ").append(getName()).append(" {\n\n")
				.append("  def run() =\n");
	}
	
	
}
