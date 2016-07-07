package com.liferay.simulation

import com.liferay.scenario.{GetPage, Login, Logout}
import com.liferay.util.HttpConfiguration
import io.gatling.core.Predef._

//TODO: Document Me !

class NavigationSimulation extends Simulation {

  val scn = scenario("Login and Logout").exec(GetPage.homePage, Login.successfulLogin, Logout.scenario)

  setUp(scn.inject(atOnceUsers(1))).protocols(HttpConfiguration.httpConf)
}




