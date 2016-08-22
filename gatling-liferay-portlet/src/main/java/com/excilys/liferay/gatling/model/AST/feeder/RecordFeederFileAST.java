package com.excilys.liferay.gatling.model.AST.feeder;

import com.excilys.liferay.gatling.model.AST.feeder.data.RecordDataAST;

import java.util.ArrayList;
import java.util.List;

public class RecordFeederFileAST extends FeederFileAST {

	private static final String TYPE = "Record";
	
	private List<RecordDataAST> data;
	
	public RecordFeederFileAST(String name, List<RecordDataAST> data) {
		super(name, TYPE);
		this.data = data;
	}
	
	@Override
	public String getContent() {
		StringBuilder contentBuilder = new StringBuilder(RecordDataAST.HEADER).append("\n");
		for (RecordDataAST recordDataAST : data) {
			contentBuilder.append(recordDataAST.getUrl()).append(",")
				.append(recordDataAST.getType()).append(",");
			
			ResourceFileAST resource = recordDataAST.getData();
			String resourceName = resource != null ? resource.getName() : "null";
			contentBuilder.append(resourceName);
			contentBuilder.append("\n");
			
		}
		return contentBuilder.toString();
	}

	@Override
	public List<ResourceFileAST> flatWithSubsequentRessourceFile() {
		List<ResourceFileAST> feeders = new ArrayList<>();
		for (RecordDataAST recordDataAST: data) {
			ResourceFileAST feeder = recordDataAST.getData();
			if(feeder != null){
				List<ResourceFileAST> subsequentFeeders = feeder.flatWithSubsequentRessourceFile();
				if(subsequentFeeders != null) {
					feeders.addAll(subsequentFeeders);
				}
				feeders.add(feeder);
			}
		}
		feeders.add(this);
		return feeders;
	}

	
	
}
