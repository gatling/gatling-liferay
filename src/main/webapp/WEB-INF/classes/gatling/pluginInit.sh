#!/bin/bash
#
# Copyright 2011-2016 GatlingCorp (http://gatling.io)
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
# 		http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.
#


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
 

