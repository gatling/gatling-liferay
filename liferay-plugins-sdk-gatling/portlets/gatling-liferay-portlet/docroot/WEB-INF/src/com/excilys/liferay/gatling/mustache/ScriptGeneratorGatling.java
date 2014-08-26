/**
 * Copyright 2011-2014 eBusiness Information, Groupe Excilys (www.ebusinessinformation.fr)
 */
package com.excilys.liferay.gatling.mustache;

import com.excilys.liferay.gatling.model.Request;
import com.excilys.liferay.gatling.model.Scenario;
import com.excilys.liferay.gatling.mustache.util.AssetPublisher;
import com.excilys.liferay.gatling.mustache.util.ExecSpecial;
import com.excilys.liferay.gatling.mustache.util.MessageBoard;
import com.excilys.liferay.gatling.mustache.util.WikiDisplay;
import com.excilys.liferay.gatling.service.RequestLocalServiceUtil;
import com.excilys.liferay.gatling.service.ScenarioLocalServiceUtil;
import com.excilys.liferay.gatling.service.SimulationLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.Layout;
import com.liferay.portal.model.PortletPreferences;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.portal.service.PortletPreferencesLocalServiceUtil;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ScriptGeneratorGatling {

	private String simuName = "avant";
	private Long simulationId = 0L; 
	private Set<MessageBoard> setMessageBoard = new HashSet<MessageBoard>();
	private Set<AssetPublisher> setAssetPublisher = new HashSet<AssetPublisher>();
	private Set<WikiDisplay> setWikiDisplay = new HashSet<WikiDisplay>();
	private List<MustacheScenario> mustacheScenario = new ArrayList<MustacheScenario>();

	public ScriptGeneratorGatling() {
	}

	public ScriptGeneratorGatling(Long simulationId) throws Exception{
		this.simuName = SimulationLocalServiceUtil.getSimulation(simulationId).getVariableName();
		this.simulationId = simulationId;
	}

	public void initiate() throws Exception{
		generateMustacheScenario();
	}


	public void generateMustacheScenario() throws Exception{

		final List<Scenario> listScenario = ScenarioLocalServiceUtil.findBySimulationId(simulationId);
		final List<MustacheScenario> list = new ArrayList<MustacheScenario>();
		for (int i = 0; i < listScenario.size(); i++) {

			final Scenario sc = listScenario.get(i);
			final List<MustacheRequest> mustacheRequests = new ArrayList<MustacheRequest>();
			final List<Request> listRequest = RequestLocalServiceUtil.findByScenarioId( sc.getScenario_id());
			double totalWeight = getTotalWeight(sc);
			double currentSumWeight = 0;
			double weight = 0;
			for (int j = 0; j < listRequest.size(); j++) {
				final Request rq = listRequest.get(j);
				if(rq.getWeight() > 0) {						
					String site = sc.getUrl_site();
					weight = (double) ((int)((int) rq.getWeight()*10000/totalWeight))/100;
					currentSumWeight += weight;
					MustacheRequest mr = null;
					mr = new MustacheRequest(rq.getName(), site + rq.getUrl(), weight , false);

					fillPortlets(sc.getGroup_id(), rq.getPrivatePage(), rq.getLayoutId(), mr);
					mustacheRequests.add(mr);
				}
			}
			final double lastWeight = (double) (int)( (100-currentSumWeight+weight)*100)/100;
			mustacheRequests.get(mustacheRequests.size()-1).setWeight(lastWeight).setLast(true).setScenarioId(sc.getScenario_id());
			final MustacheScenario ms = new MustacheScenario(sc.getVariableName(),sc.getUsers_per_seconds(), sc.getDuration(), (i+1) == listScenario.size() ? true : false, mustacheRequests);
			list.add(ms);
		}

		mustacheScenario.addAll(list);
	}

	/*TO IMPROVE*/
	private void fillPortlets(long group_id, boolean privatePage, long layoutId, MustacheRequest mr) throws Exception{

		Layout layout = LayoutLocalServiceUtil.getLayout(group_id, privatePage, layoutId);


		Pattern p = Pattern.compile("column-\\d=([0-9a-zA-Z,_])+\\n");
		Matcher m =p.matcher(layout.getTypeSettings());
		while(m.find()){
			String[] portletIds = m.group().substring(9).split(",");
		}		

		List<PortletPreferences> pp = PortletPreferencesLocalServiceUtil.getPortletPreferencesByPlid(layout.getPlid());
		for (PortletPreferences portletPreferences : pp) {
			final String portletId = portletPreferences.getPortletId();
			System.out.println(portletId);

			  // 19 Message Boards
			if( new String("19").equals(portletId)) {
				this.setMessageBoard.add( new MessageBoard(mr.getUrl(), mr.getName()));
				mr.addListExecSpecial(new ExecSpecial("MessageBoard", mr.getName()));

			} // 101 Asset Publisher
			else if( new String("101").equals(portletId)) {
				this.setAssetPublisher.add(new AssetPublisher(mr.getUrl(), mr.getName()));
				mr.addListExecSpecial(new ExecSpecial("AssetPublisher", mr.getName()));	

			} // 54 Wiki Display
			else if( new String("54").equals(portletId.split("_")[0])) {
				this.setWikiDisplay.add(new WikiDisplay(mr.getUrl(), mr.getName(), portletId, m.group().substring(0, 8)));
				mr.addListExecSpecial(new ExecSpecial("WikiDisplay", mr.getName()));				
			} // 71 Navigation
			else if( new String("71").equals(portletId.split("_")[0])) {				
			} 
		}
		System.out.println("--------------");
		if(!mr.listExecSpecialEmpty()) {
			mr.setNotRegular(true);
			mr.setRegular(false);			
		}
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

	public List<MustacheScenario> getMustacheScenario() {
		return mustacheScenario;
	}

	public void setMustacheScenario(List<MustacheScenario> mustacheScenario) {
		this.mustacheScenario = mustacheScenario;
	}



}
