Gatling-for-Liferay
===================

![Project Logo](images/gatling_for_liferay_logo.jpg)

## Introduction
_Gatling for Liferay_ is a plugin that helps to simply create Gatling stress tests for a Liferay portal. It provides tools for both simulating simple use cases and
recording advanced scenarios. All the generated simulations come along with
a complete file hierarchy (feeders, processes...) and can be run in any Galting Environment.

The script will be based on your site map, and you can define which pages will be accessed by the simulated users - and even specify which ones will be more requested than the others to be more accurate.

This year, benefit from Liferay-Gatling's exclusive partnership! For every Liferay's customer: get a 1-year licence for our enterprise extension Gatling FrontLine for free. Contact us now: liferay@gatling.io

### versions

* **Liferay**:
  - _6.2 CE GA1+_ &rArr; _6.2 CE GA6+_
  - _6.2 EE GA1+_
* **Gatling**:
  - _2.2.*_

### Functionnalities
Two different functionnalities are available with the plugin:
  - The scenarios builder allows you to easily create user stories. Workflows are
  embodied by a succession of boxes, each boxe represents a process action
  (E.g: Login, RandomPage, Logout...).

  - A portal recorder, once activated, saves all the portal navigation. Once stopped, a simulation representing the played actions is available for generation.
  It also adds custom record boxes in order for the latter to be added to the workflow in a simple way.

### Gatling exportation
  The zip hierarchy is related to the Gatling bundle file structure. Exportation Scripts based on the GATLING_HOME variable help you to move the exported files to the Gatling directory.

## Installation
The plugin can be download from the liferay marketplace [here](https://web.liferay.com/fr/marketplace), it works on Liferay 6.2+ versions.

  The code source can also be found on our github and imported in a Liferay Developer Studio environment. It used the following tools:
  - Maven as a build manager.
  - Git for the versioning.
  - Mustache as a Template motor, it creates scala files from a predefined Simulation structure.

## Contribution
Gatling for Liferay is meant to be an open-source project, it therefore welcome everyone aboard. It can be done in many ways:

### Issues
Issues can be created in the github project in order to report any bugs or ask for futur functionnalities. See our [contribution guidelines](CONTRIBUTING.md) !

### Communication
In case of question or recommandation, a [mailing list](https://groups.google.com/forum/#!forum/gatling) allows you to join us.

### Code Contribution
Code contribution can be done via pull requests.

Before any contribution, please check our [contribution guide](CONTRIBUTING.md).

## About us

### Licence
Incomming...
### Corporation
[_Gatling Corp_](http://gatling.io/#/)
### Authors
_Nicolas Raymond and Yann Mougenel_
