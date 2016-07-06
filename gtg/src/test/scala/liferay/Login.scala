
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

	val validUsers = scenario("Valid users login and logout").exec(HomePage.scenario, Signin.scenario(Signin.validUsers), Logout.scenario)
	val invalidUsers = scenario("Invalid users login and logout").exec(HomePage.scenario, Signin.scenario(Signin.invalidUsers), Logout.scenario)

	//TODO: Export user numbers into property files

	setUp(
		validUsers.inject(atOnceUsers(10)),
		invalidUsers.inject(atOnceUsers(5))
	).protocols(httpConf)
}

object HomePage {
	val scenario =
		exec(http("Home Page")
			.get("/web/guest/home"))
		.pause(20)
}

object Signin {

	val validUsers = "validUsers.csv"
	val invalidUsers = "invalidUsers.csv"

	println(status.is(200).getClass.getName)

	def scenario(feederName: String/*, loginCheck: ???*/) =
		feed(csv(feederName).random)
		.exec(http("Login")
			.post("/web/guest/home?p_p_id=58&p_p_lifecycle=1&p_p_state=normal&p_p_mode=view&p_p_col_id=column-1&p_p_col_count=1&_58_struts_action=%2Flogin%2Flogin")
			.formParam("_58_login", "${name}")
			.formParam("_58_password", "${password}")
			.check(status.is(200)))
		//	.check(loginCheck))
		.pause(30)

		//def validScenario = scenario

}

object Logout {

	val scenario =
		exec(http("Scenario")
			.get("/c/portal/logout"))

}
