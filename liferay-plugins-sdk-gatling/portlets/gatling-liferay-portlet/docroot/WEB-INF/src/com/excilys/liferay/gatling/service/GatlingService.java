package com.excilys.liferay.gatling.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.sample.model.Scenario;
import com.liferay.sample.service.RequestLocalServiceUtil;
import com.liferay.sample.service.ScenarioLocalServiceUtil;
import com.liferay.sample.service.SimulationLocalServiceUtil;

import java.util.List;

public enum GatlingService {
	INSTANCE;

	public void removeSimulation(Long simulationId) {
		//Scénarios
		removeScenarioBySimulation(simulationId);
		try {
			SimulationLocalServiceUtil.deleteSimulation(simulationId);
		} catch (PortalException | SystemException e) {
			e.printStackTrace();
		}
	}

	public void removeScenarioBySimulation(Long simulationId) {
		//Suppression de ses requests
		try {
			List<Scenario> listRequests = ScenarioLocalServiceUtil.findBySimulationId(simulationId);
			// Suppressions des requests
			for(Scenario scenario : listRequests) {
				removeRequestByScenario(scenario.getScenario_id());
			}
		} catch (SystemException e) {
			e.printStackTrace();
		}
		
		try {
			//Suppression des scénarios
			ScenarioLocalServiceUtil.removeBySimulationId(simulationId);
		} catch (SystemException e) {
			e.printStackTrace();
		}
	}

	public void removeRequestByScenario(Long scenarioId) {
		//Suppression des requêtes
		try {
			RequestLocalServiceUtil.removeByScenarioId(scenarioId);
		} catch (SystemException e) {
			e.printStackTrace();
		}
	}

}
