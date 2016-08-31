package com.excilys.liferay.gatling.dto.mapper;

import com.excilys.liferay.gatling.dto.ProcessDTO;
import com.excilys.liferay.gatling.model.Process;

public class ProcessDTOMapper {

	public static ProcessDTO toDTO(Process process) {
		return new ProcessDTO(process.getName(), process.getFeederId());
	}
	
}
