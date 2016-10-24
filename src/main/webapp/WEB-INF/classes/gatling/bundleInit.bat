@REM
@REM Copyright 2011-2016 GatlingCorp (http://gatling.io)
@REM
@REM Licensed under the Apache License, Version 2.0 (the "License");
@REM you may not use this file except in compliance with the License.
@REM You may obtain a copy of the License at
@REM
@REM 		http://www.apache.org/licenses/LICENSE-2.0
@REM
@REM Unless required by applicable law or agreed to in writing, software
@REM distributed under the License is distributed on an "AS IS" BASIS,
@REM WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
@REM See the License for the specific language governing permissions and
@REM limitations under the License.
@REM

echo GATLING_HOME is set to %GATLING_HOME%

@REM Generated destination directories
set simulationsDir=user-files\simulations\liferay\
set processesDir=user-files\simulations\liferay\processes
set feedersDir=user-files\data\feeders
set dataDir=user-files\bodies\liferay

@REM Copies all the scala files
mkdir  %GATLING_HOME%\%simulationsDir%
mkdir  %GATLING_HOME%\%processesDir%
copy %simulationsDir%\*.scala %GATLING_HOME%\%simulationsDir%
copy %processesDir%\* %GATLING_HOME%\%processesDir%

@REM Copies all the http bodies
@mkdir  %GATLING_HOME%\%dataDir%

copy %dataDir%\* %GATLING_HOME%\%dataDir%


@REM Copies all the feeders
@mkdir  %GATLING_HOME%\%feedersDir%

copy %feedersDir%\* %GATLING_HOME%\%feedersDir%
