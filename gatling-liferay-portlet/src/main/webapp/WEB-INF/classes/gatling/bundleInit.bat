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
