
import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class Login extends Simulation {

	val httpConf = http
		.baseURL("http://localhost:8080")
		.inferHtmlResources()
		.acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
		.acceptEncodingHeader("gzip, deflate")
		.acceptLanguageHeader("en-US,en;q=0.5")
		.userAgentHeader("Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:47.0) Gecko/20100101 Firefox/47.0")

	val scn = scenario("LoginAndLogout").exec(HomePage.scenario, Signin.scenario, Logout.scenario)

	setUp(scn.inject(atOnceUsers(10))).protocols(httpConf)
}

object HomePage {
	val scenario =
		exec(http("Home Page")
			.get("/web/guest/home"))
		.pause(20)
}

object Signin {

	// TODO: Use feeder to feed with users and passwords

	val feeder = csv("search.csv").random

	val name = "nraymond.blue@gmail.com"
	val password = "bla"

	// Login
	val scenario =
		exec(http("Login")
			.post("/web/guest/home?p_p_id=58&p_p_lifecycle=1&p_p_state=normal&p_p_mode=view&p_p_col_id=column-1&p_p_col_count=1&_58_struts_action=%2Flogin%2Flogin")
			.formParam("_58_login", name)
			.formParam("_58_password", password)
			.check(status.is(200)))
		.pause(30)

}

object Logout {

	val scenario =
		exec(http("Scenario")
			.get("/c/portal/logout"))

}
