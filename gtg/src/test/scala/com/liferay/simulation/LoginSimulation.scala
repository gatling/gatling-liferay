package com.liferay.simulation

import com.liferay.scenario.{GetPage, Login, Logout}
import com.liferay.util.HttpConfiguration
import com.typesafe.config.ConfigFactory
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

  private val conf = ConfigFactory.load("simulation.conf")

	val validUsers = scenario("Valid users login and logout").exec(GetPage.homePage, Login.successfulLogin, Logout.scenario)
	val invalidUsers = scenario("Invalid users login and logout").exec(GetPage.homePage, Login.unsuccessfulLogin)

	setUp(
		validUsers.inject(atOnceUsers(conf.getInt("loginSimulation.validUsersNumber"))),
		invalidUsers.inject(atOnceUsers(conf.getInt("loginSimulation.invalidUsersNumber")))
	).protocols(HttpConfiguration.httpConf)
}

