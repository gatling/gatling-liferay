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

