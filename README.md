Gatling-for-Liferay
===================

## Introduction
_Gatling for Liferay_ is a plugin that helps to simply create stress tests for a Liferay portal. It provides tools for both simulating simple use cases and
recording advanced scenarios. All the generated simulations come along with
a complete file hierarchy (feeders, processes...) and can be run in any Galting Environment.

## Functionnalities
Two different functionnalities are available with the plugin:
  - The scenarios builder allows you to easily create user stories. Workflows are
  embodied by the succession of boxes, each boxe represents a process action
  (E.g: Login, RandomPage, Logout...).

  - A portal recorder, once activated, saves all the portal navigation done. Once stopped, a simulation representing the played actions is available for generation.
  It also adds custom record boxes in order for the latter to be added to the workflow in a simple way.


## Gatling exportation
  The zip hierarchy is related to the Gatling bundle file structure. Exportation Scripts based on the GATLING_HOME variable help you to move the exported files to the Gatling directory.

## Script generation
  The script generation is done by a ZipOutStream. The following elements are written into this stream:
  - The simulation and scenarios code
  - The resource files (feeders and data)
  - The complementary files such as README and scripts.

  ### Simulation code
  The scala code contained in the zip file is created from an Abstract Syntax Tree (AST). This tree  embodies the simultation structure.

### Corporation
_Gatling Corp_
### Authors
_Nicolas Raymond and Yann Mougenel_
