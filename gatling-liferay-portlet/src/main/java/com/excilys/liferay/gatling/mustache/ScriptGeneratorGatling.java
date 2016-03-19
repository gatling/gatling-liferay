/**
 * Copyright 2015 Altendis, Groupe Excilys (www.altendis.fr)
 */
package com.excilys.liferay.gatling.mustache;

import com.excilys.liferay.gatling.model.LinkUsecaseRequest;
import com.excilys.liferay.gatling.model.Request;
import com.excilys.liferay.gatling.model.Scenario;
import com.excilys.liferay.gatling.model.Simulation;
import com.excilys.liferay.gatling.service.LinkUsecaseRequestLocalServiceUtil;
import com.excilys.liferay.gatling.service.RecordLocalServiceUtil;
import com.excilys.liferay.gatling.service.RequestLocalServiceUtil;
import com.excilys.liferay.gatling.service.ScenarioLocalServiceUtil;
import com.excilys.liferay.gatling.service.SimulationLocalServiceUtil;
import com.excilys.liferay.gatling.util.GatlingUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.model.Layout;
import com.liferay.portal.model.Portlet;
import com.liferay.portal.model.PortletPreferences;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.portal.service.PortletLocalServiceUtil;
import com.liferay.portal.service.PortletPreferencesLocalServiceUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * This class handles the generation of the script.
 * @author pif
 *
 */

public class ScriptGeneratorGatling {
	/**
	 * logging.
	 */
	private static final Log LOG = LogFactoryUtil.getLog(ScriptGeneratorGatling.class);

	private String simuName = "avant";
	private Long simulationId = 0L; 
	private List<MustacheScenario> mustacheScenario;
	private boolean feederFile;
	private String feederContent;
	private List<Map<String,String>> feedMap;
	private final String portalURL;

	public ScriptGeneratorGatling(Long simulationId, String portalURL) throws Exception{
		Simulation simulation = SimulationLocalServiceUtil.getSimulation(simulationId);
		this.simuName = GatlingUtil.createSimulationVariable(simulation.getName());
		this.simulationId = simulationId;
		this.feederFile = simulation.getIsFeederAFile();
		this.feederContent = simulation.getFeederContent();
		this.portalURL = portalURL;
		if(!this.feederFile) {
			this.feedMap = new ArrayList<Map<String, String>>();
			Scanner scanner=new Scanner(feederContent);
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();

				String[] tab = line.split(",");
				Map<String, String> map = new HashMap<String, String>();
				map.put("login",tab[0]);
				map.put("password", tab[1]);
				feedMap.add(map);
			}

			scanner.close();
		}
	}

	public String initiate() throws Exception{
		mustacheScenario = new ArrayList<MustacheScenario>();
		initiateMustacheScenario();
		return "";
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
		String name = SimulationLocalServiceUtil.getSimulation(simulationId).getName();
		this.simuName = GatlingUtil.createSimulationVariable(name);

	}

	private MustacheScenario generateMustacheScenario(Scenario sc, int i, int size) throws Exception {
		final List<MustacheRequest> listMustacheRequest = new ArrayList<MustacheRequest>();
		final List<Request> listRequest = RequestLocalServiceUtil.findByScenarioId( sc.getScenario_id());
		double totalWeight = getTotalWeight(sc);
		double currentSumWeight = 0;
		double weight = 0;
		String site = sc.getUrl_site();

		boolean hasPrivatePage =false;
		//on veut juste le host
		String loginPageURL= portalURL;

		//solution temporaire pour trouver l'url d'une page contenant une portlet de login, sinon enregistrer en base ??
		for ( PortletPreferences pp : PortletPreferencesLocalServiceUtil.getPortletPreferences() ){
			if(pp.getPortletId().equals("58")){
				Layout page = LayoutLocalServiceUtil.getLayout(pp.getPlid());
				loginPageURL += page.getFriendlyURL();
				System.out.println("path= "+loginPageURL);
				break;
			}
		}

		//loop for the request
		for (int j = 0; j < listRequest.size(); j++) {
			final Request rq = listRequest.get(j);
			if(rq.getWeight() > 0) {		
				if( !rq.isPortlet()) {					

					weight = (double) ((int)((int) rq.getWeight()*10000/totalWeight))/100;
					currentSumWeight += weight;
					if(rq.isPrivatePage()) {
						site = site.replace("/web/", "/group/");
						hasPrivatePage =true;
					}
					int numberOfPortlets = RequestLocalServiceUtil.countByParentPlidAndScenario(rq.getPlId(), sc.getScenario_id());
					
					Layout layout = LayoutLocalServiceUtil.getLayout(rq.getPlId());
					String layoutName = layout.getName(LocaleUtil.getDefault());
					
					MustacheRequest mustacheRequest = new MustacheRequest(layoutName, site + layout.getFriendlyURL(), weight);
					if( numberOfPortlets != 0) {
						final List<Request> listPortlets = RequestLocalServiceUtil.findByParentPlidAndScenarioAndPositif(rq.getPlId(), sc.getScenario_id());
						double totalWeightPortlet = getTotalWeight(listPortlets);

						for(Request portlet : listPortlets) {
							if (! (LinkUsecaseRequestLocalServiceUtil.countByRequestIdAndUsed(portlet.getRequest_id()) > 0)){
								totalWeightPortlet -= portlet.getWeight();
							}
						}
						double currentSumWeightPortlet = 0;	
						double weightPortlet = 0;

						//loop for the Portlets
						for (Request portletRequest : listPortlets) {
							if (LinkUsecaseRequestLocalServiceUtil.countByRequestIdAndUsed(portletRequest.getRequest_id()) > 0){
								
								Portlet portlet = PortletLocalServiceUtil.getPortletById(portletRequest.getPortletId());
								
								mustacheRequest.setRegular(false);
								MustachePortlet mustachePortlet = new MustachePortlet(portlet.getDisplayName().replace(" ", "")+portletRequest.getRequest_id(), site + layout.getFriendlyURL(),portletRequest.getPortletId(), weightPortlet, false);
								List<LinkUsecaseRequest> listUseCaseRequest = LinkUsecaseRequestLocalServiceUtil.findByRequestIdAndUsed(portletRequest.getRequest_id());
								//loop for the scripts
								for (LinkUsecaseRequest linkUsecaseRequest : listUseCaseRequest) {
									if (!linkUsecaseRequest.isSample()){
										mustachePortlet.addRecorder(RecordLocalServiceUtil.getRecord(linkUsecaseRequest.getRecordId()), linkUsecaseRequest.getWeight(), sc.getUrl_site()+layout.getFriendlyURL());
									} else if(linkUsecaseRequest.isSample()) {
										if("Wiki Display".equals(portlet.getDisplayName())) {
											mustachePortlet.setWikiDisplaySimple(portlet.getDisplayName().replace(" ", "")+"Simple"+portletRequest.getRequest_id(), sc.getUrl_site()+layout.getFriendlyURL(), portletRequest.getPlId(), linkUsecaseRequest.getWeight());
										} else if("Asset Publisher".equals(portlet.getDisplayName())) {
											mustachePortlet.setAssetPublisherSimple(portlet.getDisplayName().replace(" ", "")+"Simple"+portletRequest.getRequest_id(), sc.getUrl_site()+layout.getFriendlyURL(), linkUsecaseRequest.getWeight());
										} else if("Message Boards".equals(portlet.getDisplayName())) {
											if(linkUsecaseRequest.getRecordId() == 1) {
												mustachePortlet.setMessageBoardSimple(portlet.getDisplayName().replace(" ", "")+"Simple"+portletRequest.getRequest_id(), sc.getUrl_site()+layout.getFriendlyURL(), linkUsecaseRequest.getWeight());
											} else if(linkUsecaseRequest.getRecordId() == 2) {
												mustachePortlet.setMessageBoardPost(portlet.getDisplayName().replace(" ", "")+"Post"+portletRequest.getRequest_id(), sc.getUrl_site()+layout.getFriendlyURL(), linkUsecaseRequest.getWeight());
											}
										} 
									}
								}
								if( ! mustachePortlet.getScripts().isEmpty()) {
									mustachePortlet.setLastScript();
								}
								if( ! mustachePortlet.getRecorderGet().isEmpty()) {
									mustacheRequest.addListMustachePortlet(mustachePortlet);
									weightPortlet = (double) ((int)((int) portletRequest.getWeight()*10000/totalWeightPortlet))/100;
									currentSumWeightPortlet += weightPortlet;
								}
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
		String variableName = GatlingUtil.createScenarioVariable(sc.getName());

		return new MustacheScenario(variableName,sc.getNumberOfUsers(), sc.getDuration(), listMustacheRequest,  hasPrivatePage, loginPageURL, portalURL);
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

	public String getSimuName() {
		return simuName;
	}

	public void setSimuName(String simuName) {
		this.simuName = simuName;
	}

}
