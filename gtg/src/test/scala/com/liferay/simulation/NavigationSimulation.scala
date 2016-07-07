package com.liferay.simulation

import com.liferay.util.HttpConfiguration
import com.liferay.scenario.{GetPage, Login, Logout, Navigate}
import io.gatling.core.Predef._

//TODO: Document Me  and externalize pages array!

class NavigationSimulation extends Simulation {


  val pages = Array("/web/guest/home", "/web/guest/about-us", "/web/guest/parts")

  val scn = scenario("Navigate through pages").exec(GetPage.homePage, Login.successfulLogin, Navigate.scenario(pages), Logout.scenario)


  setUp(scn.inject(atOnceUsers(1))).protocols(HttpConfiguration.httpConf)
}





