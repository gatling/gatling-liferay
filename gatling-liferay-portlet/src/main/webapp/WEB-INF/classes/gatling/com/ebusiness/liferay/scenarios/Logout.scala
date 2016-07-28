package com.ebusiness.liferay.scenarios

import io.gatling.core.Predef._
import io.gatling.http.Predef._

//TODO: Document Me!

object Logout {

	val scenario(logoutPageUrl: String) =
		exec(http("Logout").get(s"""${logoutPageUrl}/c/portal/logout"""))
	  .pause(2)

}
