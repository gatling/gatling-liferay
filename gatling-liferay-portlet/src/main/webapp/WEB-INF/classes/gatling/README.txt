Gatling for Liferay is a plugin made up to establish stress tests for any Liferay support.

This generated zip contains a complete file hierarchy which includes Scenario, Simulation and feeders.

It is supposed to run on all Gatling environments wich the following steps.

If you are using Gatling Bundle (zip dowloaded from gatling.io [0])
	1/ Set up a basic Gatling Bundle Environment from gatling.io[0]
	2/ Add this Environment to your system path (export GATLING_HOME="~/PATH/gatling-charts-highcharts-bundle-X.X.X")
	3/ Run the initBundle.sh executable, it copies all the exported files to the gatling environment
	4/ Run the simulations in the gatling environent

If you are using Gatling plugins (maven[1] or sbt[2] plugins)
	1/ Set up a Galting Plugin environment 
	2/ Add this Environment to your system path (export GATLING_HOME="~/PATH/gatling-plugin-demo/")
	3/ Run the initPlugin.sh executable, it copies all the exported files to the gatling environment
	4/ Run the simulations in the gatling environent


In either case, see the Gatling documentation [0] for any additional information

[0]: http://gatling.io/#/
[1]: https://github.com/gatling/gatling-maven-plugin-demo
[2]: https://github.com/gatling/gatling-sbt-plugin-demo

