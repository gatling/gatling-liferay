package com.ebusiness.liferay.scenarios

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
	def logout(logoutPageUrl: String) =
		exec(http("Logout").get(s"${logoutPageUrl}/c/portal/logout")
          .check(status.is(200))
        )
	  .pause(2)

}
