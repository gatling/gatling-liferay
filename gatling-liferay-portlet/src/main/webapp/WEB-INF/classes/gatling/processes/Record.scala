package liferay.processes

import io.gatling.core.Predef._
import io.gatling.core.structure.ChainBuilder
import liferay.processes.GetPage

object Record {

    def record(feederfile : String) = {
      val records = csv(feederfile).records

      /* Easy Way */
      foreach(records, "record") {
        exec(flattenMapIntoAttributes("${record}"))
          .doSwitch("${type}") (
            "GET"       -> GetPage.basicPage("${url}"),
            "POST"      -> GetPage.postPage("${url}", "${datafile}"),
            "MULTIPART" -> GetPage.postMultiParts("${url}", "${datafile}")
        )
      }
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

