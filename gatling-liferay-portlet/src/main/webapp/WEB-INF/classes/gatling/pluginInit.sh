#!/bin/bash

# Generated destination directories
simulationsDir=src/test/scala/liferay
processesDir=src/test/scala/liferay/processes
feedersDir=src/test/resources/data/feeders
dataDir=src/test/resources/data/liferay


sourceSimulationsDir=user-files/simulations/liferay
sourceprocessesDir=user-files/simulations/liferay/processes
sourceFeedersDir=user-files/data/feeders
sourceDataDir=user-files/bodies/liferay

# Copies all the scala files
mkdir -p $GATLING_HOME/$simulationsDir
mkdir -p $GATLING_HOME/$processesDir
cp $sourceSimulationsDir/*.scala $GATLING_HOME/$simulationsDir
cp $sourceprocessesDir/* $GATLING_HOME/$processesDir

# Copies all the http bodies
 if [ ! -d  $GATLING_HOME/src/test/resources/data ]; then
   mkdir -p $GATLING_HOME/src/test/resources/data;
   mkdir -p $GATLING_HOME/$dataDir;
 fi
cp $sourceDataDir/* $GATLING_HOME/$dataDir
 
 # Copies all the feeders
 if [ ! -d $feedersDir ]; then
   mkdir -p $GATLING_HOME/$feedersDir
 fi
cp $sourceFeedersDir/* $GATLING_HOME/$feedersDir
 

