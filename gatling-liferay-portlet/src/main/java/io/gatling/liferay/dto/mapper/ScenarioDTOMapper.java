package io.gatling.liferay.dto.mapper;

import io.gatling.liferay.dto.ProcessDTO;
import io.gatling.liferay.dto.ScenarioDTO;
import io.gatling.liferay.model.Process;
import io.gatling.liferay.model.ProcessScenarioLink;
import io.gatling.liferay.model.Scenario;
import io.gatling.liferay.service.ProcessLocalServiceUtil;
import io.gatling.liferay.service.ProcessScenarioLinkLocalServiceUtil;
import io.gatling.liferay.service.ScenarioLocalServiceUtil;
import io.gatling.liferay.service.persistence.ProcessScenarioLinkUtil;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

import java.util.ArrayList;
import java.util.List;

public class ScenarioDTOMapper {

	public static ScenarioDTO toDTO(Scenario scenario, int counter) throws SystemException, PortalException{
		long scenarioId = scenario.getScenario_id();
		List<Process> processes = ProcessLocalServiceUtil.findProcessFromScenarioId(scenarioId);
		int size = processes.size();
		List<ProcessDTO> processesDTO = new ArrayList<>(size);
		for(int i = 0; i < size; i++) {
			Process process = processes.get(i);
			processesDTO.add(ProcessDTOMapper.toDTO(process, String.valueOf(counter++)));
			int pause = ProcessLocalServiceUtil.findPause(scenarioId, process.getProcess_id(), i);
			if(pause > 0 && i < size - 1) {
				processesDTO.add(new ProcessDTO( "Pause", String.valueOf(counter++),"Pause", "PAUSE", pause));
			}
		}
		return new ScenarioDTO(scenario.getName(), scenario.getScenario_id(), processesDTO);
	}
	
	public static void persistData(ScenarioDTO scenarioDTO) throws SystemException, PortalException {
		Scenario scenario = ScenarioLocalServiceUtil.getScenario(scenarioDTO.getId());
		scenario.setName(scenarioDTO.getName());
		
		// Clean all rows related to the scenarios
		List<ProcessScenarioLink> links = ProcessScenarioLinkLocalServiceUtil.findByscenarioId(scenario.getScenario_id());
		for (ProcessScenarioLink processScenarioLink : links) {
			ProcessScenarioLinkLocalServiceUtil.deleteProcessScenarioLink(processScenarioLink.getPsl_id());
		}
		
		int i = 0;
		int order = 0;
		ProcessDTO nextElement;
		// Insert new links
		List<ProcessDTO> dtos = scenarioDTO.getProcesses();
		while(i < dtos.size() ) {
			ProcessDTO processDTO = dtos.get(i);
			if (!processDTO.isPause()) {
				ProcessScenarioLink link = ProcessScenarioLinkUtil.create(CounterLocalServiceUtil.increment(ProcessScenarioLink.class.getName()));
				link.setScenario_id(scenario.getScenario_id());
				link.setProcess_id(Long.parseLong(processDTO.getCssClass()));
				link.setOrder(order);
				int pauseTime = 0;
				
				// Goes through following Pauses and add their pauseTime;
				int nextIndex = i+1;
				while (nextIndex < dtos.size() && ( nextElement = dtos.get(nextIndex)).isPause()) {
					pauseTime += nextElement.getPause();
					nextIndex++;
				}
				
				link.setPause(pauseTime);
				link.persist();
				order++;
			}
			scenario.persist();
			i++;
		}
		
	}
}
