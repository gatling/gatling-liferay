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
	 * Constructs a chain builder to hit a page.
	 * @param title The title of the page that will be displayed in the test
	 * @param page The URL of the page to hit
	 * @return the chain builder to hit a page
	 */
	def basicPage(title: String, page:String) : ChainBuilder = {
		exec(http(title).get(page))
			.pause(5)
	}

	/**
	 * Constructs a chain builder to hit a page.
	 * @param page The URL of the page to hit
	 * @return the chain builder to hit a page
	 */
	def basicPage(page: String) : ChainBuilder =
		basicPage(s"Page $page", page)

  /**
    * Constructs a chain builder to hit a page as post request with parameters.
    * @param title The title of the page that will be displayed in the test
    * @param page The URL of the page to hit
    * @param feederName The name of the feeder containing the form data
    * @return the chain builder to hit a page
    */
  def postPage(title: String, page: String, feederName: String) : ChainBuilder = {
    val data = csv(feederName).records

    val map = (HashMap[String, String]() /: data) (
      (m, elt) => m + (elt("key") -> elt("value"))
    )

    exec(http(s"Page $title").post(page).formParamMap(map))
  }

  /**
    * Constructs a chain builder to hit a page as post request with parameters.
    * @param page The URL of the page to hit
    * @param feederName The name of the feeder containing the form data
    * @return the chain builder to hit a page
    */
  def postPage(page: String, feederName: String) : ChainBuilder =
    postPage(page, page, feederName)

  /**
    * Constructs a chain builder to hit a page as post request with multipart form.
    * @param title The title of the page that will be displayed in the test
    * @param page The URL of the page to hit
    * @param fileName The name of the feeder containing the form data
    * @return the chain builder to hit a page
    */
  def postMultiParts(title: String, page: String, fileName: String) : ChainBuilder =
    exec(http(s"Page $title").post(page).bodyPart(RawFileBodyPart(fileName)))

  /**
    * Constructs a chain builder to hit a page as post request with multipart form.
    * @param page The URL of the page to hit
    * @param fileName The name of the feeder containing the form data
    * @return the chain builder to hit a page
    */
  def postMultiParts(page: String, fileName: String) : ChainBuilder =
    postMultiParts(page, page, fileName)

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
