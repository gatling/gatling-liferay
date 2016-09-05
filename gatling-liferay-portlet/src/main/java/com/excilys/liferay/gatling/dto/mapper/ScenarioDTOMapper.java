package com.excilys.liferay.gatling.dto.mapper;

import com.excilys.liferay.gatling.model.Process;
import com.excilys.liferay.gatling.dto.PauseProcessDTO;
import com.excilys.liferay.gatling.dto.ProcessDTO;
import com.excilys.liferay.gatling.dto.ScenarioDTO;
import com.excilys.liferay.gatling.model.Scenario;
import com.excilys.liferay.gatling.service.ProcessLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

import java.util.ArrayList;
import java.util.List;

public class ScenarioDTOMapper {

	public static ScenarioDTO toDTO(Scenario scenario) throws SystemException, PortalException{
		long scenarioId = scenario.getScenario_id();
		List<Process> processes = ProcessLocalServiceUtil.findProcessFromScenarioId(scenarioId);
		int size = processes.size();
		List<ProcessDTO> processesDTO = new ArrayList<>(size);
		for(int i = 0; i < size; i++) {
			Process process = processes.get(i);
			processesDTO.add(ProcessDTOMapper.toDTO(process));
			int pause = ProcessLocalServiceUtil.findPause(scenarioId, process.getProcess_id(), i);
			processesDTO.add(new PauseProcessDTO(pause));
		}
		return new ScenarioDTO(scenario.getName(), processesDTO);
	}
	
}
