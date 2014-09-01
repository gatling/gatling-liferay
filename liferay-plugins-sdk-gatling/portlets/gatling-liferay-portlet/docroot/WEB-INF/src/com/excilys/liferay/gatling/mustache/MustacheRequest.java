/**
 * Copyright 2011-2014 eBusiness Information, Groupe Excilys (www.ebusinessinformation.fr)
 */
package com.excilys.liferay.gatling.mustache;

import com.excilys.liferay.gatling.model.Request;
import com.excilys.liferay.gatling.mustache.util.MustachePortlet;
import com.excilys.liferay.gatling.service.RequestLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;

import java.util.ArrayList;
import java.util.List;

public class MustacheRequest {

	private String name, url;
	private double pourcentage;
	private boolean last, notRegular, regular;
	private long scenarioId;
	private List<MustachePortlet> listMustachePortlet = new ArrayList<MustachePortlet>();
	
	MustacheRequest(String name, String url, double d, boolean last, boolean regular) {
		this.url = url;
		this.name = name;
		this.pourcentage = d;
		this.last = last;
		this.regular = regular;
		this.notRegular = !regular;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public List<MustachePortlet> getExecSpecial() {
		setLastListMustachePortlet();
		return listMustachePortlet;
	}

	public void setListMustachePortlet(List<MustachePortlet> listMustachePortlet) {
		this.listMustachePortlet = listMustachePortlet;
	}
	
	public void addListMustachePortlet(MustachePortlet listMustachePortlet) {
		this.listMustachePortlet.add(listMustachePortlet);
	}
	

	
	private void setLastListMustachePortlet() {
		if(!listMustachePortlet.isEmpty()) {
			listMustachePortlet.get(listMustachePortlet.size()-1).setLast(true);
		}		
	}

	public boolean listMustachePortletEmpty() {
		return listMustachePortlet.isEmpty();
	}
	

}
