package com.excilys.liferay.gatling;

import com.excilys.liferay.gatling.model.Request;
import com.excilys.liferay.gatling.model.Scenario;
import com.excilys.liferay.gatling.service.RequestLocalServiceUtil;
import com.excilys.liferay.gatling.service.ScenarioLocalServiceUtil;
import com.excilys.liferay.gatling.service.SimulationLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;

import java.util.ArrayList;
import java.util.List;

public class ScriptGeneratorMustache {

	String simuName = "avant";
	Long simulationId = 0L;

	public ScriptGeneratorMustache(Long simulationId) throws Exception{
		super();
		this.simuName = SimulationLocalServiceUtil.getSimulation(simulationId).getVariableName();
		this.simulationId = simulationId;
	}


	List<MustacheScenario> mustacheScenario() throws Exception{

		List<Scenario> listScenario = ScenarioLocalServiceUtil.findBySimulationId(simulationId);
		List<MustacheScenario> list = new ArrayList<MustacheScenario>();
		if(!listScenario.isEmpty()){
			for (Scenario sc : listScenario) {

				List<MustacheRequest> mustacheRequests = new ArrayList<MustacheRequest>();
				List<Request> listRequest = RequestLocalServiceUtil.findByScenarioId( sc.getScenario_id());
				double totalWeight = getTotalWeight(sc);
				for (Request rq : listRequest) {
					if(rq.isChecked() && (rq.getWeight() > 0)) {
						String site = sc.getUrl_site();
						if(rq.isPrivatePage()){
							//String is a f****** immutable class ;(
							site = site.replace("/web/", "/group/");
						}
						MustacheRequest mr = new MustacheRequest(rq.getName(), site + rq.getUrl(), (rq.getWeight()*100/totalWeight), ",");
						mustacheRequests.add(mr);
					}
				}
				MustacheScenario ms = new MustacheScenario(sc.getName(),sc.getUsers_per_seconds(), sc.getDuration(), ",", mustacheRequests);
				list.add(ms);
			}

			list.get(list.size()-1).removeComma();
			for (MustacheScenario mustacheScenario : list) {
				mustacheScenario.removeCommaRequest();
			}
		}
		return list;
	}


	private double getTotalWeight(Scenario scenario) throws SystemException {
		List<Request> listRequest = RequestLocalServiceUtil.findByScenarioId(scenario.getScenario_id());
		double weight = 0;
		for (Request request : listRequest) {
			if(request.isChecked()) weight += request.getWeight();
		}
		return weight;
	}



	static class MustacheScenario {
		MustacheScenario(String name,long l,long m, String virgule, List<MustacheRequest> mustacheRequests) {
			this.name = name;
			this.virgule = virgule;
			this.mustacheRequests = mustacheRequests;
			this.users = l;
			this.duration = m;
		}
		public void removeComma(){
			virgule = "";
		}public void removeCommaRequest(){
			if(!mustacheRequests.isEmpty()){
				mustacheRequests.get(mustacheRequests.size()-1).removeComma();
			}
		}


		String name, virgule;
		long users, duration;
		List<MustacheRequest> mustacheRequests;
	}

	static class MustacheRequest {
		MustacheRequest(String name, String url, double d, String virgule) {
			this.url = url;
			this.name = name;
			this.pourcentage = d;
			this.virgule = virgule;
		}
		public void removeComma(){
			virgule = "";
		}

		String name, url, virgule;
		double pourcentage;
	}



}
