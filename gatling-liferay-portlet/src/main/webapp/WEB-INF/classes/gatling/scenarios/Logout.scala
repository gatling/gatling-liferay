package com.liferay.scenario

import io.gatling.core.Predef._
import io.gatling.http.Predef._

//TODO: Document Me !

object Logout {

	val scenario =
		exec(http("Logout").get("/c/portal/logout"))
	  .pause(20)

}
