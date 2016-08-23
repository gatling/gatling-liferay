package liferay.processes

import io.gatling.core.Predef._

object Record {

  def record(feederfile : String) = {
    val records = csv(feederfile).records

    val pagesHit = records.map {
      record => record("type") match {
        case "GET"        => GetPage.basicPage(record("url"))
        case "POST"       => GetPage.postPage(record("url"), record("datafile"))
        case "MULTIPART"  => GetPage.postMultiParts(record("url"), record("datafile"))
      }
    }

    exec(pagesHit)
  }

}
