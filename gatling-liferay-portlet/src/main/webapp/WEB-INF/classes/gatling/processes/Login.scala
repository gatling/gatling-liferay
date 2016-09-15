package liferay.processes

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.http.check.HttpCheck

/**
 * Regroups different scenario builders to log in liferay portal.
 */
object Login {

	val loginFailRegex = css("section#portlet_58 div.alert");

	/**
	 * Constructs a scenario builder to login the portal with a random user.
	 * This user is choosen from a feeder file. The scenario check that the authentification
	 * is successful and the test will fail if not.
	 * @param loginPageUrl The URL of the login page to hit
	 * @param feederName The name of the feeder file. It must be a csv file with to columns :
	 * 	user (which must be the mail of the user) and password
	 * @return the scenario builder to log
	 */
	def successfulLogin(loginPageUrl: String, feederName: String) =
		login(loginPageUrl, feederName, loginFailRegex.notExists)

	def login(loginPageUrl: String, feederName: String, loginCheck: HttpCheck) = {

		feed(csv(feederName).random)
		.exec(http("Home Page")
			.get("/web/guest/home")
			.check(status.is(200))
		)
		.exec(http("Login ${user}")
			.post(loginPageUrl)

			.queryParam("p_p_id","58")
			.queryParam("p_p_lifecycle","1")
			.queryParam("p_p_state","normal")
			.queryParam("p_p_mode","view")
			.queryParam("p_p_col_id","column-1")
			.queryParam("p_p_col_count","1")
			.queryParam("_58_struts_action","/login/login")

			.formParam("_58_login", "${user}")
			.formParam("_58_password", "${password}")
			.formParam("_58_redirect", "")
			.formParam("_58_saveLastPath", "false")
			.formParam("_58_rememberMe", "false")
			.formParam("_58_doActionAfterLogin", "false")
			.check(status.is(200))
			.check(loginCheck)
		)
		.pause(2)
	}

}
