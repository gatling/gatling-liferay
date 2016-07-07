package com.liferay.simulation

import com.liferay.scenario.{GetPage, Login, Logout}
import com.liferay.util.HttpConfiguration
import io.gatling.core.Predef._
import io.gatling.core.scenario.Simulation

//TODO: Document Me !

class LoginSimulation extends Simulation {

	val validUsers = scenario("Valid users login and logout").exec(GetPage.homePage, Login.successfulLogin, Logout.scenario)
	val invalidUsers = scenario("Invalid users login and logout").exec(GetPage.homePage, Login.unsuccessfulLogin)

	//TODO: Export user numbers into property files and pause

	setUp(
		validUsers.inject(atOnceUsers(10)),
		invalidUsers.inject(atOnceUsers(5))
	).protocols(HttpConfiguration.httpConf)
}

