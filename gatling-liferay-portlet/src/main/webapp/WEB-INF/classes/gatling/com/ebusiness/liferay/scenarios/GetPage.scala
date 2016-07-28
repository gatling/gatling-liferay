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
   
  def basicPage(feederName : String) : ChainBuilder = 
  	//TODO getfeeder

  val homePage = basicPage("Home Page", "/web/guest/home")

}
