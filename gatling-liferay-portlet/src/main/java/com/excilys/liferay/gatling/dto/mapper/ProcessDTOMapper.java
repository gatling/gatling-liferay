package com.excilys.liferay.gatling.dto.mapper;

import com.excilys.liferay.gatling.dto.ProcessDTO;
import com.excilys.liferay.gatling.model.Process;

public class ProcessDTOMapper {

	public static ProcessDTO toDTO(Process process, String cssId) {
		return new ProcessDTO(process.getName(), cssId, String.valueOf(process.getProcess_id()), process.getType());
	}
	
}