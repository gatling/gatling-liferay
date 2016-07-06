package liferay

import javax.security.auth.login.AppConfigurationEntry.LoginModuleControlFlag

import scala.concurrent.duration._
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class Navigation extends Simulation {

  val httpConf = http
    .baseURL("http://localhost:8080")
    .inferHtmlResources()
    .acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
    .acceptEncodingHeader("gzip, deflate")
    .acceptLanguageHeader("en-US,en;q=0.5")
    .userAgentHeader("Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:47.0) Gecko/20100101 Firefox/47.0")

  val scn = scenario("LoginAndLogout").exec(GetPage.scenario("/web/guest/home"), Signin.scenario(Signin.validUsers), Logout.scenario)

  setUp(scn.inject(atOnceUsers(1))).protocols(httpConf)
}


object GetPage {
  def scenario(page: String) =
    exec(http("Page"+page)
      .get(page))
      .pause(20)
}

