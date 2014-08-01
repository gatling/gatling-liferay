package com.excilys.liferay.gatling.mustache;

import com.excilys.liferay.gatling.model.Request;
import com.excilys.liferay.gatling.service.RequestLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;

import java.util.List;

public class MustacheRequest {
	


	String name, url;
	double pourcentage;
	boolean last;
	long scenarioId;
	
	MustacheRequest(String name, String url, double d, boolean last) {
		this.url = url;
		this.name = name;
		this.pourcentage = d;
		this.last = last;
	}

	public void setWeight(Object i) {
		this.pourcentage = (Double) i;
	}
	
	public int truncate() throws SystemException {
		if(last){
			List<Request> listRequest = RequestLocalServiceUtil.findByScenarioId( scenarioId);
			int sum = 0;
			int total = 0;
			for (int j = 0; j < listRequest.size(); j++) {
				total += listRequest.get(j).getWeight();
			}
			for (int j = 0; j < listRequest.size()-1; j++) {
				sum += listRequest.get(j).getWeight()*100/total;				
			}
			pourcentage = 100-sum;
		}
		return (int) pourcentage;
	}
	
	public long getScenarioId() {
		return scenarioId;
	}

	public void setScenarioId(long l) {
		this.scenarioId = l;
	}

}
