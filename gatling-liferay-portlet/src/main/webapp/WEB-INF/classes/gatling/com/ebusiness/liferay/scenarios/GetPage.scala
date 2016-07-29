package com.ebusiness.liferay.scenarios

import io.gatling.core.Predef._
import io.gatling.core.structure.ChainBuilder
import io.gatling.http.Predef._

//TODO: Document Me!

object GetPage {

  def basicPage(title: String, page: String) : ChainBuilder =
    exec(http(title).get(page))
      .pause(5)


  def basicPage(page: String) : ChainBuilder =
    basicPage("Page " + page, page)
   
  def randomPage(feederName : String) : ChainBuilder =
    feed(csv(feederName).random)
      .exec(http("Random page : ${site}")
          .get("${URL}")
      )
      .pause(3)

  val homePage = basicPage("Home Page", "/web/guest/home")

}
