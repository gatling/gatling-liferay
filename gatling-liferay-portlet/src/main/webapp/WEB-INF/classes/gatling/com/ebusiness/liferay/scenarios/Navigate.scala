package com.liferay.scenario

import io.gatling.core.Predef._
import io.gatling.core.structure.ChainBuilder
import io.gatling.http.Predef._
import io.gatling.http.request.builder.HttpRequestBuilder

// Navigates through the pages
object Navigate {


  val pageFeeder: IndexedSeq[String] = csv("feeders/pages.csv").records.map(_("page"))

  def scenario(count: Int) = {

    import GetPage._

    val requests: IndexedSeq[ChainBuilder] = pageFeeder.take(count)
      .map { page =>
        basicPage(page)
      }

    exec(requests)
  }



  def scenario2 (pages : Seq[String] ) =
    pages.foldLeft(new ChainBuilder(Nil)) (
      (cb: ChainBuilder, page:String) =>
        cb.exec(GetPage.basicPage(page))
    )

}