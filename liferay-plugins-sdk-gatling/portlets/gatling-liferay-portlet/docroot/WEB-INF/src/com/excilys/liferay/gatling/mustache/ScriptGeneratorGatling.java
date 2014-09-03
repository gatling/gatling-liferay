/**
 * Copyright 2011-2014 eBusiness Information, Groupe Excilys (www.ebusinessinformation.fr)
 */
package com.excilys.liferay.gatling.mustache;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.excilys.liferay.gatling.model.LinkUsecaseRequest;
import com.excilys.liferay.gatling.model.Request;
import com.excilys.liferay.gatling.model.Scenario;
import com.excilys.liferay.gatling.mustache.util.AssetPublisher;
import com.excilys.liferay.gatling.mustache.util.MessageBoard;
import com.excilys.liferay.gatling.mustache.util.NameAndUrl;
import com.excilys.liferay.gatling.mustache.util.NameUrlAndPlid;
import com.excilys.liferay.gatling.mustache.util.WikiDisplay;
import com.excilys.liferay.gatling.service.LinkUsecaseRequestLocalServiceUtil;
import com.excilys.liferay.gatling.service.RequestLocalServiceUtil;
import com.excilys.liferay.gatling.service.ScenarioLocalServiceUtil;
import com.excilys.liferay.gatling.service.SimulationLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;

public class ScriptGeneratorGatling {

	private String simuName = "avant";
	private Long simulationId = 0L; 
	private List<MustacheScenario> mustacheScenario;
	private Set<MessageBoard> setMessageBoard = new HashSet<MessageBoard>();
	private Set<AssetPublisher> setAssetPublisher = new HashSet<AssetPublisher>();
	private Set<WikiDisplay> setWikiDisplay = new HashSet<WikiDisplay>();

	public ScriptGeneratorGatling(Long simulationId) throws Exception{
		this.simuName = SimulationLocalServiceUtil.getSimulation(simulationId).getVariableName();
		this.simulationId = simulationId;
	}
	
	public void initiate() throws Exception{
		mustacheScenario = new ArrayList<MustacheScenario>();
		initiateMustacheScenario();
	}

	private void initiateMustacheScenario() throws Exception{

		final List<Scenario> listScenario = ScenarioLocalServiceUtil.findBySimulationId(simulationId);
		final List<MustacheScenario> listMustacheScenario = new ArrayList<MustacheScenario>();
		for (int i = 0; i < listScenario.size(); i++) {
			listMustacheScenario.add(generateMustacheScenario(listScenario.get(i), i, listScenario.size()));
		}
		mustacheScenario.addAll(listMustacheScenario);
	}

	//give the total weight for a request of the portlets
	private int getTotalWeight(List<Request> listPortlet) {
		int totalWeight = 0; 
		for (Request request : listPortlet) {
			totalWeight += request.getWeight(); 
		}
		return totalWeight;
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

	//give the total weight for a scenario of the requests (excude the portlets)
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

	private MustacheScenario generateMustacheScenario(Scenario sc, int i, int size) throws Exception {
		final List<MustacheRequest> listMustacheRequest = new ArrayList<MustacheRequest>();
		final List<Request> listRequest = RequestLocalServiceUtil.findByScenarioId( sc.getScenario_id());
		double totalWeight = getTotalWeight(sc);
		double currentSumWeight = 0;
		double weight = 0;

		//loop for the request
		for (int j = 0; j < listRequest.size(); j++) {
			final Request rq = listRequest.get(j);
			if(rq.getWeight() > 0) {		
				if( !rq.isPortlet()) {					
					String site = sc.getUrl_site();
					weight = (double) ((int)((int) rq.getWeight()*10000/totalWeight))/100;
					currentSumWeight += weight;
					if(rq.isPrivatePage()) {
						site = site.replace("/web/", "/group/");
					}

					int numberOfPortlets = RequestLocalServiceUtil.countByParentPlid(rq.getPlId());						
					MustacheRequest mustacheRequest = new MustacheRequest(rq.getName(), site + rq.getUrl(), weight , false, numberOfPortlets == 0);
					if( numberOfPortlets != 0) {
						List<Request> listPortlets = RequestLocalServiceUtil.findByParentPlid(rq.getPlId());
						final double totalWeightPortlet = getTotalWeight(listPortlets);
						double currentSumWeightPortlet = 0;	
						double weightPortlet = 0;

						//loop for the Portlets
						for (Request portlet : listPortlets) {
							if (LinkUsecaseRequestLocalServiceUtil.countByRequestIdAndUsed(portlet.getRequest_id()) > 0){
								weightPortlet = (double) ((int)((int) portlet.getWeight()*10000/totalWeightPortlet))/100;
								currentSumWeightPortlet += weightPortlet;
								MustachePortlet mustachePortlet = new MustachePortlet(portlet.getName(), site + portlet.getUrl(), weightPortlet, false);

								List<LinkUsecaseRequest> listUseCaseRequest = LinkUsecaseRequestLocalServiceUtil.findByRequestIdAndUsed(rq.getRequest_id());
								//loop for the scripts
								for (LinkUsecaseRequest linkUsecaseRequest : listUseCaseRequest) {
									if(linkUsecaseRequest.isSample() && linkUsecaseRequest.getRecordId() == 1) {
										if("Wiki Display".equals(portlet.getName())) {
											mustachePortlet.addWikiDisplaySimple(new NameUrlAndPlid(portlet.getName(), rq.getUrl(), portlet.getPlId()));
										} else if("Asset Publisher".equals(portlet.getName())) {
											mustachePortlet.addAssetPublisherSimple(new NameAndUrl(portlet.getName(), rq.getUrl()));
										} else if("Message Boards".equals(portlet.getName())) {
											mustachePortlet.addMessageBoardSimple(new NameAndUrl(portlet.getName(), rq.getUrl()));
										} 
									}
								}
								mustacheRequest.addListMustachePortlet(mustachePortlet);
							}
						}
						final double lastWeightPortlet = (double) (int)( (100-currentSumWeightPortlet+weightPortlet)*100)/100;
						if( !mustacheRequest.mustachePortlet.isEmpty()) {
							mustacheRequest.getMustachePortlet().get(mustacheRequest.mustachePortlet.size()-1).setPourcentage(lastWeightPortlet).setLast(true);
						}
					}
					listMustacheRequest.add(mustacheRequest);
				}
			}
		}
		final double lastWeight = (double) (int)( (100-currentSumWeight+weight)*100)/100;
		if( !listMustacheRequest.isEmpty()) {
			listMustacheRequest.get(listMustacheRequest.size()-1).setWeight(lastWeight).setLast(true).setScenarioId(sc.getScenario_id());
		}
		return new MustacheScenario(sc.getVariableName(),sc.getUsers_per_seconds(), sc.getDuration(), (i+1) == size ? true : false, listMustacheRequest);
	}

	public Long getSimulationId() {
		return simulationId;
	}

	public void setSimulationId(Long simulationId) {
		this.simulationId = simulationId;
	}

	public List<MustacheScenario> mustacheScenario() {
		return mustacheScenario;
	}

	public void setMustacheScenario(List<MustacheScenario> mustacheScenario) {
		this.mustacheScenario = mustacheScenario;
	}

	public Set<MessageBoard> getSetMessageBoard() {
		return setMessageBoard;
	}

	public void setSetMessageBoard(Set<MessageBoard> setMessageBoard) {
		this.setMessageBoard = setMessageBoard;
	}

	public Set<AssetPublisher> getSetAssetPublisher() {
		return setAssetPublisher;
	}

	public void setSetAssetPublisher(Set<AssetPublisher> setAssetPublisher) {
		this.setAssetPublisher = setAssetPublisher;
	}

	public Set<WikiDisplay> getSetWikiDisplay() {
		return setWikiDisplay;
	}

	public void setSetWikiDisplay(Set<WikiDisplay> setWikiDisplay) {
		this.setWikiDisplay = setWikiDisplay;
	}

	public void setSimuName(String simuName) {
		this.simuName = simuName;
	}

}
