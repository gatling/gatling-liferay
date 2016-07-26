package com.liferay.scenario

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.http.check.HttpCheck

//TODO: Document Me !

object Login {

	val validUsers = "feeders/validUsers.csv"
	val invalidUsers = "feeders/invalidUsers.csv"
  val loginFailRegex = regex("""<div class="alert alert-error"> Authentication failed.* <\/div>""");

  val successfulLogin = scenario(validUsers, loginFailRegex.notExists)
  val unsuccessfulLogin = scenario(invalidUsers, loginFailRegex.exists)

	def scenario(feederName: String, loginCheck: HttpCheck) =
		feed(csv(feederName).random)
		.exec(http("Login")
			.post("/web/guest/home?p_p_id=58&p_p_lifecycle=1&p_p_state=normal&p_p_mode=view&p_p_col_id=column-1&p_p_col_count=1&_58_struts_action=%2Flogin%2Flogin")
			.formParam("_58_login", "${name}")
			.formParam("_58_password", "${password}")
			.check(status.is(200))
		  .check(loginCheck))
		.pause(30)

}
