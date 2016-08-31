package com.excilys.liferay.gatling.dto.mapper;

import com.excilys.liferay.gatling.model.Process;
import com.excilys.liferay.gatling.dto.ProcessDTO;
import com.excilys.liferay.gatling.dto.ScenarioDTO;
import com.excilys.liferay.gatling.model.Scenario;
import com.excilys.liferay.gatling.service.ProcessLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;

import java.util.ArrayList;
import java.util.List;

public class ScenarioDTOMapper {

	public static ScenarioDTO toDTO(Scenario scenario) throws SystemException{
		List<Process> processes = ProcessLocalServiceUtil.findProcessFromScenarioId(scenario.getScenario_id());		
		List<ProcessDTO> processesDTO = new ArrayList<>(processes.size());
		for (Process process : processes) {
			processesDTO.add(ProcessDTOMapper.toDTO(process));
		}
		return new ScenarioDTO(scenario.getName(), processesDTO);
	}
	
}
