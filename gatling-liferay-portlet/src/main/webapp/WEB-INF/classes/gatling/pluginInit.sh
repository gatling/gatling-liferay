#!/bin/bash

# Generated destination directories
simulationsDir=src/test/scala/liferay/simulationss
processes=src/test/scala/liferay/scenarios
feedersDir=src/test/resources/feederss

sourceSimulationsDir=user-files/simulationss/liferay/
sourceprocessesDir=user-files/simulationss/liferay/processes
sourceFeedersDir=user-files/data/feederss

# Copies all the scala files
mkdir -p $GATLING_HOME/$simulationssDir
mkdir -p $GATLING_HOME/$processesDir
cp $sourceSimulationsDir/*.scala $GATLING_HOME/$simulationssDir
cp $sourceprocessesDir/* $GATLING_HOME/$processesDir

# Copies all the feederss
mkdir -p $GATLING_HOME/$feederssDir
cp $sourceFeedersDir/* $GATLING_HOME/$feederssDir

