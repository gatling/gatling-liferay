/**
 * Copyright 2011-2016 GatlingCorp (http://gatling.io)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * 		http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
