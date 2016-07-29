#!/bin/bash

# Copies all the scala files
mkdir -p $GATLING_ENV/src/test/scala/liferay/simulations
mkdir -p $GATLING_ENV/src/test/scala/liferay/scenarios
cp com/ebusiness/liferay/simulations/* $GATLING_ENV/src/test/scala/liferay/simulations
cp com/ebusiness/liferay/scenarios/* $GATLING_ENV/src/test/scala/liferay/scenarios

# Copies all the feeders
mkdir -p $GATLING_ENV/src/test/resources/feeders
cp com/ebusiness/liferay/feeders/* $GATLING_ENV/src/test/resources/feeders

