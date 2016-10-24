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
package io.gatling.liferay.model.impl;

/**
 * The extended model implementation for the Scenario service. Represents a row in the &quot;StressTool_Scenario&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link io.gatling.liferay.model.Scenario} interface.
 * </p>
 *
 * @author Brian Wing Shun Chan
 */
public class ScenarioImpl extends ScenarioBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. All methods that expect a scenario model instance should use the {@link io.gatling.liferay.model.Scenario} interface instead.
	 */
	public ScenarioImpl() {
	}
	
	public boolean isComplete() {
		return (!this.getName().isEmpty() && this.getNumberOfUsers()>0 && this.getDuration()>0);
	}
}