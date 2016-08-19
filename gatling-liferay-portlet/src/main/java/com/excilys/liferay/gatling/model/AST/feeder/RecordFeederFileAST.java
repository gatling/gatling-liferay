package com.excilys.liferay.gatling.model.AST.feeder;

import com.excilys.liferay.gatling.model.AST.feeder.data.RecordDataAST;

import java.util.ArrayList;
import java.util.List;

public class RecordFeederFileAST extends FeederFileAST {

	private static final String TYPE = "Record";
	
	private List<RecordDataAST> data;
	
	public RecordFeederFileAST(String name, List<RecordDataAST> data) {
		this.name = name;
		this.type = TYPE;
		this.data = data;
	}
	
	@Override
	public String getContent() {
		StringBuilder contentBuilder = new StringBuilder(RecordDataAST.HEADER).append("\n");
		for (RecordDataAST recordDataAST : data) {
			contentBuilder.append(recordDataAST.getUrl()).append(",")
				.append(recordDataAST.getType()).append(",");
			
			FeederFileAST feeder = recordDataAST.getData();
			String feederContent = feeder != null ? feeder.getContent() : "null";
			contentBuilder.append(feederContent);
			contentBuilder.append("\n");
			
		}
		return contentBuilder.toString();
	}

	@Override
	public List<FeederFileAST> flatSubsequentFeeders() {
		List<FeederFileAST> feeders = new ArrayList<>();
		for (RecordDataAST recordDataAST: data) {
			FeederFileAST feeder = recordDataAST.getData();
			if(feeder != null){
				List<FeederFileAST> subsequentFeeders = feeder.flatSubsequentFeeders();
				if(subsequentFeeders != null) {
					feeders.addAll(subsequentFeeders);
				}
				feeders.add(feeder);
			}
		}
		return feeders;
	}

	
	
}
