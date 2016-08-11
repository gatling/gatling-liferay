#!/bin/bash

# Generated destination directories
simulationsDir=user-files/simulations/liferay/
processesDir=user-files/simulations/liferay/processes
feedersDir=user-files/data/feeders

# Copies all the scala files
mkdir -p $GATLING_HOME/$simulationsDir
mkdir -p $GATLING_HOME/$processesDir
cp $simulationsDir/*.scala $GATLING_HOME/$simulationsDir
cp $processesDir/* $GATLING_HOME/$processesDir

# Copies all the feeders
mkdir -p $GATLING_HOME/$feedersDir
cp $feedersDir/* $GATLING_HOME/$feedersDir

