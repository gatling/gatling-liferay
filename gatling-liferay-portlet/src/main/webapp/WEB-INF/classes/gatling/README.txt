Gatling for Liferay is a plugin made up to establish stress tests for any Liferay support.

This generated zip contains a complete file hierarchy which includes Scenario, Simulation and feeders.

It is supposed to run on all Gatling environments wich the following steps.

1/ Set up a basic Gatling Environment (either with maven[1] or sbt[2] plugins)
2/ Add this Environment to your system path (export GATLING_HOME="~/PATH/gatling-plugin-demo/")
3/ Run the init.sh executable, it copies all the exported files to the gatling environment
4/ Run the simulations in the gatling environent by either sbt or maven

See the Gatling documentation [0] for any additional information

[0]: http://gatling.io/#/
[1]: https://github.com/gatling/gatling-maven-plugin-demo
[2]: https://github.com/gatling/gatling-sbt-plugin-demo

