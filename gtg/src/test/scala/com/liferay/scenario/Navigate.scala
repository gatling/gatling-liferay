package com.liferay.scenario

import io.gatling.core.structure.ChainBuilder

// Navigates through the pages
object Navigate {
  var i = 1
  def scenario (pages : Seq[String] ) =
    pages.foldLeft(new ChainBuilder(Nil)) (
      (cb: ChainBuilder, page:String) =>
        cb.exec(GetPage.basicPage(page))
    )

}