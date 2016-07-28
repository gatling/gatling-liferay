package com.ebusiness.liferay.scenarios

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.http.check.HttpCheck

//TODO: Document Me !

object Login {

  	val loginFailRegex = regex("""<div class="alert alert-error"> Authentication failed.* <\/div>""");

  	def successfulLogin(loginPageUrl: String, feederName: String) =
  		scenario(loginPageUrl, feederName, loginFailRegex.notExists)

	def scenario(loginPageUrl: String, feederName: String, loginCheck: HttpCheck) =
		feed(csv(feederName).random)
		.exec(http("Login")
			.post(loginPageUrl+"?p_p_id=58&p_p_lifecycle=1&p_p_state=normal&p_p_mode=view&p_p_col_id=column-1&p_p_col_count=1&_58_struts_action=%2Flogin%2Flogin")
			.formParam("_58_login", "${name}")
			.formParam("_58_password", "${password}")
			.check(status.is(200))
		  .check(loginCheck))
		.pause(30)

}
