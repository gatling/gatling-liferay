package io.gatling.liferay.dto.mapper;

import io.gatling.liferay.dto.ProcessDTO;
import io.gatling.liferay.model.Process;

public class ProcessDTOMapper {

	public static ProcessDTO toDTO(Process process, String cssId) {
		return new ProcessDTO(process.getName(), cssId, String.valueOf(process.getProcess_id()), process.getType());
	}

}
