package liferay.actions

import io.gatling.core.Predef._
import io.gatling.core.structure.ChainBuilder
import io.gatling.http.Predef._


/**
 * Regroups different scenario builders to hit some specific web pages.
 */
object GetPage {

  /**
   * Constructs a scenario builder to hit a page.
   * @param title The title of the page that will be displayed in the test
   * @param page The URL of the page to hit
   * @return the scenario builder to hit a page
   */
  def basicPage(title: String, page: String) : ChainBuilder =
    exec(http(title).get(page))
      .pause(5)

  /**
   * Constructs a scenario builder to hit a page.
   * @param page The URL of the page to hit
   * @return the scenario builder to hit a page
   */
  def basicPage(page: String) : ChainBuilder =
    basicPage("Page " + page, page)

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
      .pause(3)

  /**
   * A scenario builder to hit the home page oh the liferay portal.
   */
  val homePage = basicPage("Home Page", "/web/guest/home")

}
