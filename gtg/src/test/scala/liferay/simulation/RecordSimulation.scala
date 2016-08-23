package liferay.simulation

import com.typesafe.config.ConfigFactory
import io.gatling.core.Predef._
import io.gatling.core.scenario.Simulation
import liferay.processes.Record
import liferay.util.HttpConfiguration


/**
	* This test simulates the login-logout process.
  * It simulates two population of users, valid and invalid (ie : A valid has a valid name and password),
  * that will be simulated in the same time.
  *
  * Valid users hit the homepage. Then, it login with randomly valid username and password before logout.
  * Invalid users hit the homepage. It tries then to login and raise an error page.
  */
class RecordSimulation extends Simulation {

  private val conf = ConfigFactory.load("simulation.conf")

	val myScenario = scenario("Record").exec(Record.record("feeders/RecordYeah.csv"))

	setUp(
		myScenario.inject(atOnceUsers(10))
	).protocols(HttpConfiguration.httpConf)
}

