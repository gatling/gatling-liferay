package com.excilys.liferay.gatling.model.AST.feeder;

import com.excilys.liferay.gatling.model.AST.feeder.data.SiteMapDataAST;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SiteMapFeederFileAST extends ScalaFileAST {

	private static final String TYPE = "SiteMap";

	private Map<SiteMapDataAST, Double> data;
	
	public SiteMapFeederFileAST(String name, List<SiteMapDataAST> data) {
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
