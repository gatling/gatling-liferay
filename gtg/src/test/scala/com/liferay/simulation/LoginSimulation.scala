package com.liferay.simulation

import com.liferay.scenario.{GetPage, Login, Logout}
import com.liferay.util.HttpConfiguration
import io.gatling.core.Predef._
import io.gatling.core.scenario.Simulation


/**
	* This test simulates the login-logout process.
  * It simulates two population of users, valid and invalid (ie : A valid has a valid name and password),
  * that will be simulated in the same time.
  *
  * Valid users hit the homepage. Then, it login with randomly valid username and password before logout.
  * Invalid users hit the homepage. It tries then to login and raise an error page.
  */
class LoginSimulation extends Simulation {

	val validUsers = scenario("Valid users login and logout").exec(GetPage.homePage, Login.successfulLogin, Logout.scenario)
	val invalidUsers = scenario("Invalid users login and logout").exec(GetPage.homePage, Login.unsuccessfulLogin)

	//TODO: Export user numbers into property files and pause

	setUp(
		validUsers.inject(atOnceUsers(10)),
		invalidUsers.inject(atOnceUsers(5))
	).protocols(HttpConfiguration.httpConf)
}

