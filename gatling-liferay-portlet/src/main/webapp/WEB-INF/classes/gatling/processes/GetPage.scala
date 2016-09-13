package liferay.processes

import io.gatling.core.Predef._
import io.gatling.core.session
import io.gatling.core.structure.ChainBuilder
import io.gatling.http.Predef._

import scala.collection.immutable.HashMap


/**
 * Regroups different scenario builders to hit some specific web pages.
 */
object GetPage {

  /**
    * Constructs a scenario builder to hit a random page from a set of pages
    * registered into a feeder file.
    * @param feederName The name of the feeder file. It must be a csv file with to columns :
    * 	site and URL
    * @return the scenario builder to hit a random page
  */
  def randomPage(feederName : String) : ChainBuilder =
    feed(csv(feederName).random)
      .exec(http("Random page : ${site}")
	.get("${URL}")
      )
      .pause(1)

}
