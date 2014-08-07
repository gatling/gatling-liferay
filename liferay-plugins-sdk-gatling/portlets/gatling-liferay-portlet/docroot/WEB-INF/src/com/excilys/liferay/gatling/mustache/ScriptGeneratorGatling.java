package com.excilys.liferay.gatling.mustache;

import com.excilys.liferay.gatling.model.Request;
import com.excilys.liferay.gatling.model.Scenario;
import com.excilys.liferay.gatling.service.RequestLocalServiceUtil;
import com.excilys.liferay.gatling.service.ScenarioLocalServiceUtil;
import com.excilys.liferay.gatling.service.SimulationLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.User;

import java.util.ArrayList;
import java.util.List;

public class ScriptGeneratorGatling {

	private String simuName = "avant";
	private Long simulationId = 0L; 
	private User user;


	public ScriptGeneratorGatling() {
	}

	public ScriptGeneratorGatling(Long simulationId, User user) throws Exception{
		this.simuName = SimulationLocalServiceUtil.getSimulation(simulationId).getVariableName();
		System.out.println("simuName "+simuName);
		this.simulationId = simulationId;
		this.user = user;
	}


	public List<MustacheScenario> mustacheScenario() throws Exception{

		final List<Scenario> listScenario = ScenarioLocalServiceUtil.findBySimulationId(simulationId);
		final List<MustacheScenario> list = new ArrayList<MustacheScenario>();
		for (int i = 0; i < listScenario.size(); i++) {

			final Scenario sc = listScenario.get(i);
			final List<MustacheRequest> mustacheRequests = new ArrayList<MustacheRequest>();
			final List<Request> listRequest = RequestLocalServiceUtil.findByScenarioId( sc.getScenario_id());
			double totalWeight = getTotalWeight(sc);
			double currentSumWeight = 0;
			double weight = 0;
			boolean hasPrivatePage = false;
			String homeURL = sc.getUrl_site()+"/home?p_p_id=58&p_p_lifecycle=1&p_p_state=exclusive&p_p_mode=view&_58_struts_action=%2Flogin%2Flogin";
			String userLogin = user.getLogin();
			String userPassword = user.getPassword();
			for (int j = 0; j < listRequest.size(); j++) {
				final Request rq = listRequest.get(j);
				if(rq.getWeight() > 0) {
					String site = sc.getUrl_site();
					if(rq.isPrivatePage()){
						site = site.replace("/web/", "/group/");
						hasPrivatePage=true;
					}
					weight = (double) ((int)((int) rq.getWeight()*10000/totalWeight))/100;
					currentSumWeight += weight;
					MustacheRequest mr = null;
					mr = new MustacheRequest(rq.getName(), site + rq.getUrl(), weight , false);
					mustacheRequests.add(mr);
				}
			}
			final double lastWeight = (double) (int)( (100-currentSumWeight+weight)*100)/100;
			mustacheRequests.get(mustacheRequests.size()-1).setWeight(lastWeight).setLast(true).setScenarioId(sc.getScenario_id());
			final MustacheScenario ms = new MustacheScenario(sc.getVariableName(),sc.getUsers_per_seconds(), sc.getDuration(), (i+1) == listScenario.size() ? true : false, mustacheRequests, hasPrivatePage, homeURL, userLogin, userPassword);
			list.add(ms);
		}

		return list;
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
