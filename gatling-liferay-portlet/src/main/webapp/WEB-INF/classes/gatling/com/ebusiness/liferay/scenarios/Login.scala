package com.ebusiness.liferay.scenarios

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.http.check.HttpCheck

//TODO: Document Me !

object Login {

	val loginFailRegex = regex("""<div class="alert alert-error"> Authentication failed.* <\/div>""");

	def successfulLogin(loginPageUrl: String, feederName: String) =
		scenario(loginPageUrl, feederName, loginFailRegex.notExists)

	def scenario(loginPageUrl: String, feederName: String, loginCheck: HttpCheck) = {

		val postUrl = loginPageUrl + "?p_p_id=58&p_p_lifecycle=1&p_p_state=normal&p_p_mode=view&p_p_col_id=column-1&p_p_col_count=1&_58_struts_action=%2Flogin%2Flogin"

		feed(csv(feederName).random)
			.exec(http("Login ${user}")
				.post(postUrl)
				.formParam("_58_login", "${user}")
				.formParam("_58_password", "${password}")
				.formParam("_58_redirect", "false")
				.formParam("_58_saveLastPath", "false")
				.formParam("_58_rememberMe", "false")
				.formParam("_58_doActionAfterLogin", "false")
				.check(status.is(200))
				//.check(loginCheck))
			)
			.pause(2)
	}


}
