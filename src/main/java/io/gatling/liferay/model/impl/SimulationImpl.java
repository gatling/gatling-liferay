/**
 * Copyright 2011-2016 GatlingCorp (http://gatling.io)
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
package io.gatling.liferay.model.impl;

/**
 * The extended model implementation for the Simulation service. Represents a row in the &quot;StressTool_Simulation&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link io.gatling.liferay.model.Simulation} interface.
 * </p>
 *
 * @author Brian Wing Shun Chan
 */
public class SimulationImpl extends SimulationBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. All methods that expect a simulation model instance should use the {@link io.gatling.liferay.model.Simulation} interface instead.
	 */
	public SimulationImpl() {
	}
	
	public boolean isComplete() {
		return (!this.getFeederContent().isEmpty() && !this.getName().isEmpty());
	}
}