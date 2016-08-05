#!/bin/bash

# Generated destination directories
simulationsDir=user-files/simulations/liferay/
actionsDir=user-files/simulations/liferay/actions
feedersDir=user-files/data/feeders

# Copies all the scala files
mkdir -p $GATLING_HOME/$simulationsDir
mkdir -p $GATLING_HOME/$actionsDir
cp $simulationsDir/*.scala $GATLING_HOME/$simulationsDir
cp $actionsDir/* $GATLING_HOME/$actionsDir

# Copies all the feeders
mkdir -p $GATLING_HOME/$feedersDir
cp $feedersDir/* $GATLING_HOME/$feedersDir

