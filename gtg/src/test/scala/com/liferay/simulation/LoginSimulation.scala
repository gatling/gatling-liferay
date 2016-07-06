package com.liferay.simulation

import com.liferay.scenario.{GetPage, Login, Logout}
import io.gatling.core.Predef._
import io.gatling.core.scenario.Simulation
import io.gatling.http.Predef._

//TODO: Document Me !

class LoginSimulation extends Simulation {

	val httpConf = http
		.baseURL("http://localhost:8080")
		.inferHtmlResources()
		.acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
		.acceptEncodingHeader("gzip, deflate")
		.acceptLanguageHeader("en-US,en;q=0.5")
		.userAgentHeader("Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:47.0) Gecko/20100101 Firefox/47.0")

	val validUsers = scenario("Valid users login and logout").exec(GetPage.homePage, Login.successfulLogin, Logout.scenario)
	val invalidUsers = scenario("Invalid users login and logout").exec(GetPage.homePage, Login.unsuccessfulLogin)

	//TODO: Export user numbers into property files and pause

	setUp(
		validUsers.inject(atOnceUsers(10)),
		invalidUsers.inject(atOnceUsers(5))
	).protocols(httpConf)
}

