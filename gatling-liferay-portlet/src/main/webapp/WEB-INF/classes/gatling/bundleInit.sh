#!/bin/bash

# Generated destination directories
simulationsDir=user-files/simulations/liferay/
processesDir=user-files/simulations/liferay/processes
feedersDir=user-files/data/feeders
dataDir=user-files/bodies/liferay

# Copies all the scala files
mkdir -p $GATLING_HOME/$simulationsDir
mkdir -p $GATLING_HOME/$processesDir
cp $simulationsDir/*.scala $GATLING_HOME/$simulationsDir
cp $processesDir/* $GATLING_HOME/$processesDir

# Copies all the http bodies
if [ -e $dataDir ]; then
  mkdir -p $GATLING_HOME/$dataDir
  cp $dataDir/* $GATLING_HOME/$dataDir
fi

# Copies all the feeders
if [ -e $feedersDir ]; then
  mkdir -p $GATLING_HOME/$feedersDir
  cp $feedersDir/* $GATLING_HOME/$feedersDir
fi

