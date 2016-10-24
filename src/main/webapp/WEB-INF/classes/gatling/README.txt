====
    Copyright 2011-2016 GatlingCorp (http://gatling.io)

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

    		http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
====

Gatling for Liferay is a plugin made up to establish stress tests for any Liferay support.

This generated zip contains a complete file hierarchy which includes Scenario, Simulation and feeders.

It is supposed to run on all Gatling environments wich the following steps.

If you are using Gatling Bundle (zip dowloaded from gatling.io [0])
	1/ Set up a basic Gatling Bundle Environment from gatling.io[0]
	2/ Add this Environment to your system path (export GATLING_HOME="~/PATH/gatling-charts-highcharts-bundle-X.X.X")
	3/ Run the bundleInit.sh executable, it copies all the exported files to the gatling environment
	4/ Run the simulations in the gatling environent

If you are using Gatling plugins (maven[1] or sbt[2] plugins)
	1/ Set up a Galting Plugin environment 
	2/ Add this Environment to your system path (export GATLING_HOME="~/PATH/gatling-plugin-demo/")
	3/ Run the pluginInit.sh executable, it copies all the exported files to the gatling environment
	4/ Run the simulations in the gatling environent


In either case, see the Gatling documentation [0] for any additional information.

Note:
  + If you are running on a Unix based system (Linux/Mac), script permission have to be set for the execution (chmod +x bundleInit.sh).
  + Errors can occur during the simulation if a scenario try to hit a page without being logged in. Make sure that all the scenarios have a Login process if they require one. 

[0]: http://gatling.io/#/
[1]: https://github.com/gatling/gatling-maven-plugin-demo
[2]: https://github.com/gatling/gatling-sbt-plugin-demo

