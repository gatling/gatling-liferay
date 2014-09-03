/**
 * Copyright 2011-2014 eBusiness Information, Groupe Excilys (www.ebusinessinformation.fr)
 */
package com.excilys.liferay.gatling.mustache;

import com.excilys.liferay.gatling.model.Request;
import com.excilys.liferay.gatling.service.RequestLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;

import java.util.ArrayList;
import java.util.List;

public class MustacheRequest {

	private String requestName, url;
	private double pourcentage;
	private boolean last, notRegular, regular;
	private long scenarioId;
	List<MustachePortlet> mustachePortlet = new ArrayList<MustachePortlet>();
	
	MustacheRequest(String name, String url, double pourcentage, boolean last, boolean regular) {
		this.url = url;
		this.requestName = name;
		this.pourcentage = pourcentage;
		this.last = last;
		this.regular = regular;
		this.notRegular = !regular;
	}
	
	public String getRequestName() {
		return requestName;
	}

	public void setRequestName(String name) {
		this.requestName = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public double getPourcentage() {
		return pourcentage;
	}

	public void setPourcentage(double pourcentage) {
		this.pourcentage = pourcentage;
	}

	public boolean isLast() {
		return last;
	}

	public MustacheRequest setWeight(Object i) {
		this.pourcentage = (Double) i;
		return this;
	}
	
	// for version 1.5 of Gatling we need Integer in the randomSwitch
	public int truncate() throws SystemException {
		List<Request> listRequest = RequestLocalServiceUtil.findByScenarioIdAndUsed( scenarioId);
		if(last){
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
	
	public MustacheRequest setLast(boolean last) {
		this.last = last;
		return this;
	}

	public boolean isNotRegular() {
		return notRegular;
	}

	public void setNotRegular(boolean notRegular) {
		this.notRegular = notRegular;
	}

	public boolean isRegular() {
		return regular;
	}

	public void setRegular(boolean regular) {
		this.regular = regular;
	}

	public List<MustachePortlet> getMustachePortlet() {
		setLastListMustachePortlet();
		return mustachePortlet;
	}

	public void setListMustachePortlet(List<MustachePortlet> listMustachePortlet) {
		this.mustachePortlet = listMustachePortlet;
	}
	
	public void addListMustachePortlet(MustachePortlet mustachePortlet) {
		this.mustachePortlet.add(mustachePortlet);
	}
	

	
	private void setLastListMustachePortlet() {
		if(!mustachePortlet.isEmpty()) {
			mustachePortlet.get(mustachePortlet.size()-1).setLast(true);
		}		
	}

	public boolean listMustachePortletEmpty() {
		return mustachePortlet.isEmpty();
	}
	

}
