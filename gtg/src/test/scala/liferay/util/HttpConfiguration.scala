package liferay.util

import com.typesafe.config.ConfigFactory
import io.gatling.core.Predef._
import io.gatling.core.protocol.Protocol
import io.gatling.http.Predef._

//TODO: Document me !

object HttpConfiguration {

  private val conf = ConfigFactory.load("simulation.conf")

  //TODO: Check if all is usefull and can be externalized

  val httpConf : Protocol = http
      .baseURL(conf.getString("httpConf.baseURL"))
      .inferHtmlResources()
      .acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
      .acceptEncodingHeader("gzip, deflate")
      .acceptLanguageHeader("en-US,en;q=0.5")
      .userAgentHeader("Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:47.0) Gecko/20100101 Firefox/47.0")

}
