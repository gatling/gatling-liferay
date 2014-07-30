package com.excilys.liferay.gatling.mustache;

import com.excilys.liferay.gatling.model.Request;
import com.excilys.liferay.gatling.model.Scenario;
import com.excilys.liferay.gatling.service.RequestLocalServiceUtil;
import com.excilys.liferay.gatling.service.ScenarioLocalServiceUtil;
import com.excilys.liferay.gatling.service.SimulationLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;

import java.util.ArrayList;
import java.util.List;

public class ScriptGeneratorGatling1_5 implements ScriptGeneratorGatling {

	String simuName = "avant";
	Long simulationId = 0L;

	public ScriptGeneratorGatling1_5() {
		super();
	}

	public ScriptGeneratorGatling1_5(Long simulationId) throws Exception{
		super();
		this.simuName = SimulationLocalServiceUtil.getSimulation(simulationId).getVariableName();
		this.simulationId = simulationId;
	}


	public List<MustacheScenario> mustacheScenario() throws Exception{

		List<Scenario> listScenario = ScenarioLocalServiceUtil.findBySimulationId(simulationId);
		List<MustacheScenario> list = new ArrayList<MustacheScenario>();
		if(!listScenario.isEmpty()){
			for (Scenario sc : listScenario) {

				List<MustacheRequest> mustacheRequests = new ArrayList<MustacheRequest>();
				List<Request> listRequest = RequestLocalServiceUtil.findByScenarioId( sc.getScenario_id());
				int totalWeight = (int) getTotalWeight(sc);
				int currentSumWeight = 0;
				int weight = 0;
				for (Request rq : listRequest) {
					if(rq.getWeight() > 0) {
						String site = sc.getUrl_site();
						if(rq.isPrivatePage()){
							site = site.replace("/web/", "/group/");
						}
						weight =  ((int)((int) rq.getWeight()*10000/totalWeight))/100;
						currentSumWeight += weight;
						MustacheRequest mr = new MustacheRequest1_5(rq.getName(), site + rq.getUrl(), weight , ",");
						mustacheRequests.add(mr);
					}
				}
				mustacheRequests.get(mustacheRequests.size()-1).setWeight(100-(currentSumWeight-weight));
				MustacheScenario ms = new MustacheScenario1_5(sc.getVariableName(),sc.getUsers_per_seconds(), sc.getDuration(), ",", mustacheRequests);
				list.add(ms);
			}

			list.get(list.size()-1).removeComma();
			for (MustacheScenario mustacheScenario : list) {
				mustacheScenario.removeCommaRequest();
			}
		}
		return list;
	}


	private int getTotalWeight(Scenario scenario) throws SystemException {
		List<Request> listRequest = RequestLocalServiceUtil.findByScenarioId(scenario.getScenario_id());
		int weight = 0;
		for (Request request : listRequest) {
			if(request.getWeight() > 0) weight += request.getWeight();
		}
		return weight;
	}


	@Override
	public void setId(long id) throws Exception{
		this.simulationId = id;
		this.simuName = SimulationLocalServiceUtil.getSimulation(id).getVariableName();
		
	}


}
