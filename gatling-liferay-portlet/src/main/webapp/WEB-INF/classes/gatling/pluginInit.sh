#!/bin/bash

# Generated destination directories
simulationsDir=src/test/scala/liferay/simulationss
actions=src/test/scala/liferay/scenarios
feedersDir=src/test/resources/feederss

sourceSimulationsDir=user-files/simulationss/liferay/
sourceActionsDir=user-files/simulationss/liferay/actions
sourceFeedersDir=user-files/data/feederss

# Copies all the scala files
mkdir -p $GATLING_HOME/$simulationssDir
mkdir -p $GATLING_HOME/$actionsDir
cp $sourceSimulationsDir/*.scala $GATLING_HOME/$simulationssDir
cp $sourceActionsDir/* $GATLING_HOME/$actionsDir

# Copies all the feederss
mkdir -p $GATLING_HOME/$feederssDir
cp $sourceFeedersDir/* $GATLING_HOME/$feederssDir

