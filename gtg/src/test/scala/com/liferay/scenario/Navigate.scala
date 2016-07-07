package com.liferay.scenario

import io.gatling.core.Predef._
import io.gatling.core.structure.ChainBuilder

// Navigates through the pages
object Navigate {

  val pageFeeder = "feeders/pages.csv"

  def scenario (feeder: String, count: Int) = {
    val cb : ChainBuilder  = new ChainBuilder(Nil)
    val page = csv(feeder).random
      repeat(count) {
        feed(page)
        cb.exec(GetPage.basicPage("${page}"))
      }
  }



  def scenario (pages : Seq[String] ) =
    pages.foldLeft(new ChainBuilder(Nil)) (
      (cb: ChainBuilder, page:String) =>
        cb.exec(GetPage.basicPage(page))
    )

}