/**
 * Copyright 2011-2014 eBusiness Information, Groupe Excilys (www.ebusinessinformation.fr)
 */
package com.excilys.liferay.gatling.mustache;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.excilys.liferay.gatling.model.Request;
import com.excilys.liferay.gatling.model.Scenario;
import com.excilys.liferay.gatling.mustache.util.AssetPublisher;
import com.excilys.liferay.gatling.mustache.util.MessageBoard;
import com.excilys.liferay.gatling.mustache.util.WikiDisplay;
import com.excilys.liferay.gatling.service.RequestLocalServiceUtil;
import com.excilys.liferay.gatling.service.ScenarioLocalServiceUtil;
import com.excilys.liferay.gatling.service.SimulationLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;

public class ScriptGeneratorGatling {

	private String simuName = "avant";
	private Long simulationId = 0L; 
	private Set<MessageBoard> setMessageBoard = new HashSet<MessageBoard>();
	private Set<AssetPublisher> setAssetPublisher = new HashSet<AssetPublisher>();
	private Set<WikiDisplay> setWikiDisplay = new HashSet<WikiDisplay>();

	public ScriptGeneratorGatling() {
	}

	public ScriptGeneratorGatling(Long simulationId) throws Exception{
		this.simuName = SimulationLocalServiceUtil.getSimulation(simulationId).getVariableName();
		this.simulationId = simulationId;
	}

	public List<MustacheScenario> mustacheScenario() throws Exception{

		final List<Scenario> listScenario = ScenarioLocalServiceUtil.findBySimulationId(simulationId);
		final List<MustacheScenario> listMustacheScenario = new ArrayList<MustacheScenario>();
		for (int i = 0; i < listScenario.size(); i++) {

			final Scenario sc = listScenario.get(i);
			final List<MustacheRequest> listMustacheRequest = new ArrayList<MustacheRequest>();
			final List<Request> listRequest = RequestLocalServiceUtil.findByScenarioId( sc.getScenario_id());
			double totalWeight = getTotalWeight(sc);
			double currentSumWeight = 0;
			double weight = 0;
			for (int j = 0; j < listRequest.size(); j++) {
				final Request rq = listRequest.get(j);
				if(rq.getWeight() > 0) {			

					if(! rq.isPortlet()){
						String site = sc.getUrl_site();
						weight = (double) ((int)((int) rq.getWeight()*10000/totalWeight))/100;
						currentSumWeight += weight;
						//private url
						if(rq.isPrivatePage()) {
							site = site.replace("/web/", "/group/");
						}
						
						//has portlets for the script to stress
						int size = RequestLocalServiceUtil.countByParentPlid(rq.getPlId());
						System.out.println("size: " + size);
						MustacheRequest mustacheRequest = new MustacheRequest(rq.getName(), site + rq.getUrl(), weight , false, size == 0);
						listMustacheRequest.add(mustacheRequest);
//					} else if (LinkUsecaseRequestLocalServiceUtil.countByRequestIdAndUsed(rq.getRequest_id()) > 0){
//						List<LinkUsecaseRequest> listPortlet = LinkUsecaseRequestLocalServiceUtil.findByRequestIdAndUsed(rq.getRequest_id());
//						// field the listPortlet
//						for (LinkUsecaseRequest linkUsecaseRequest : listPortlet) {
//							
//						}
//						
					}
				}
			}
			final double lastWeight = (double) (int)( (100-currentSumWeight+weight)*100)/100;
			listMustacheRequest.get(listMustacheRequest.size()-1).setWeight(lastWeight).setLast(true).setScenarioId(sc.getScenario_id());
			final MustacheScenario mustacheScenario = new MustacheScenario(sc.getVariableName(),sc.getUsers_per_seconds(), sc.getDuration(), (i+1) == listScenario.size() ? true : false, listMustacheRequest);
			listMustacheScenario.add(mustacheScenario);
		}

		return listMustacheScenario;
	}


	public Set<WikiDisplay> wikiDisplay() {
		return this.setWikiDisplay;
	}

	public Set<AssetPublisher> assetPublisher() {
		return this.setAssetPublisher;
	}

	public Set<MessageBoard> messageBoard() {
		return this.setMessageBoard;
	}


	private double getTotalWeight(final Scenario scenario) throws SystemException {
		final List<Request> listRequest = RequestLocalServiceUtil.findByScenarioId(scenario.getScenario_id());
		double weight = 0;
		for (final Request request : listRequest) {
			if(request.getWeight() > 0) {
				weight += request.getWeight();
			}
		}
		return weight;
	}


	public void setId(final long id) throws Exception {
		this.simulationId = id;
		this.simuName = SimulationLocalServiceUtil.getSimulation(id).getVariableName();		

	}

	public String getSimuName() {
		return simuName;
	}


}
