package com.liferay.simulation

import com.liferay.scenario.{GetPage, Login, Logout}
import io.gatling.core.Predef._
import io.gatling.http.Predef._

//TODO: Document Me !

class NavigationSimulation extends Simulation {

  val httpConf = http
    .baseURL("http://localhost:8080")
    .inferHtmlResources()
    .acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
    .acceptEncodingHeader("gzip, deflate")
    .acceptLanguageHeader("en-US,en;q=0.5")
    .userAgentHeader("Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:47.0) Gecko/20100101 Firefox/47.0")

  val scn = scenario("Login and Logout").exec(GetPage.homePage, Login.successfulLogin, Logout.scenario)

  setUp(scn.inject(atOnceUsers(1))).protocols(httpConf)
}




