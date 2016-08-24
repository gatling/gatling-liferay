Gatling-for-Liferay
===================

## Introduction
_Gatling for Liferay_ is a plugin that helps to simply create stress tests for a Liferay portal. It provides tools for both simulating simple use cases and
recording advanced scenarios. All the generated simulations come along with
a complete file hierarchy (feeders, processes...) and can be run in any Galting Environment.

## Functionnalities
Two different functionnalities are available with the plugin:
  - Smooth Test Loading allows you to easily create user stories. Workflows are
  embodied by the succession of boxes, each boxe represents a process action
  (E.g: Login, RandomPage, Logout...). A portal recorders generates custom boxes that can be added to the workflow in a simple way.
  - Advanced recorder: this part is focused on a weigth based generation. All site
  pages and portlets can be weighed in order to represent the user distribution over the portal. A portlet recorder is used to specify a portlet behaviour.

## Gatling exportation
  
### Authors
_Nicolas Raymond and Yann Mougenel_
