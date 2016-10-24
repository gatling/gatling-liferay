/**
 * Copyright 2011-2015 GatlingCorp (http://gatling.io)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * 		http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.gatling.liferay.dto;

import java.util.List;


/**
 * ScenarioDTO regroups all the data needed to to draw
 * a scenario in the builder scenario view.
 */
public class ScenarioDTO {
	
	/**
	 * The scenario's name
	 */
	private String name;
	
	/**
	 * The scenario's id
	 */
	private long id;
	
	/**
	 * The list of data used to draw process boxes in the scenario
	 */
	private List<ProcessDTO> processes;

	
	
	
	public ScenarioDTO() {}
	
	public ScenarioDTO(String name, long l, List<ProcessDTO> processes) {
		this.name = name;
		this.id = l;
		this.processes = processes;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<ProcessDTO> getProcesses() {
		return processes;
	}

	public void setProcesses(List<ProcessDTO> processes) {
		this.processes = processes;
	}
	
	@Override
	public String toString() {
		return "ScenarioDTO [name=" + name + ", id=" + id + ", processes="
				+ processes + "]";
	}
}
