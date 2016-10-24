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
package liferay.processes

import io.gatling.core.Predef._
import io.gatling.http.Predef._


/**
 * Provides a scenario builder to log out the portal.
 */
object Logout {

	/**
	 * Constructs a scenario builder to log out of the portal.
	 * @param logoutPageUrl The URL of the logout page to hit
	 * @return the scenario builder to logout
	 */
	def logout() =
		exec(http("Logout").get("/c/portal/logout")
			.check(status.is(200))
		)
		.pause(2)

}
