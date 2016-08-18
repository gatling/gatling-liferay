package com.liferay.scenario

import io.gatling.core.Predef._
import io.gatling.core.structure.ChainBuilder

object Record {

    def record(feederfile : String) = {
      val records = csv(feederfile).records

      /* Easy Way */
      foreach(records, "record") {
        exec(flattenMapIntoAttributes("${record}"))
          .doSwitch("${type}") (
            "GET"   -> exec(GetPage.basicPage("${url}")),
            "POST"  -> exec(post("${url}", "${datafile}"))
        )
      }
    }

    def post(url: String, feederfile: String) = {
      exec {session => session}
    }

}


/* Hard way */
/* foreach(records, "record") {
   exec { session =>
     for {
       index <- session("index").validate[Int]
     } yield session.setAll(records(index).toSeq)
   }.exec(GetPage.basicPage("${name}"))
 }*/

