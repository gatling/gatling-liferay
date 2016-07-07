package com.liferay.simulation

import com.liferay.util.HttpConfiguration
import com.liferay.scenario.{GetPage, Login, Logout, Navigate}
import com.typesafe.config.ConfigFactory
import io.gatling.core.Predef._

//TODO: Document Me  and externalize pages array!

class NavigationSimulation extends Simulation {

  private val conf = ConfigFactory.load("simulation.conf")
  
  val scn = scenario("Navigate through pages").exec(GetPage.homePage, Login.successfulLogin, Navigate.scenario(5), Logout.scenario)

  setUp(scn.inject(atOnceUsers(conf.getInt("navigationSimulation.usersNumber")))).protocols(HttpConfiguration.httpConf)
}





