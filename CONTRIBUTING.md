## How to contribute?
Gatling for Liferay is a recent project,, quite likely to behave in unpredicted ways for specific usages. Therefore there is plenty of rooms for both bug fixes and general improvements.

### Git steps
  - Fork the repository
  - Work on you local version, branches and commits have to fit the following structure:
      - branch: "brancheType-name" (ex: feature-myfeature or bugFix-scenarioCreation)
      - commit: "[AreaConcerned] quick details: advanced description" (ex: [View] feature: add panels for each steps of the simulation creation)
  - Submit a pull request

## Project details

### Web interface
Different views are used for the simulation creation:

#### The simulation building
This page allows the user to easily creates a simulation by manipulating boxes. Each box represents a scala process. What with scenarios, injection profile and feeders, a simulation can be custumazed for all the use cases.

Since rest web services are not used, all the parameters transmited from the view to the controlers are based on forms and link. It implies some tricky hidden form field manipulated by js functions. For example a JSON field is set each time boxes are manipulated, it contains all the information regarding the simulation structure.

### The recorder
This page record a portal navigation thought an iFrame. All the actions done inside this iFrame are recorded, such as requests'parameters and pause times. A filter is used, since
the iframe use our portlet group id, all actions done with this id during a record are persisted.

The filter code migth be a little bit messy, two different recorder used to cohexist, requiring the use of conditionnal instructions to distinguish one from another. It has not been cleaned properly and is more likely to contain old instructions no longer used.

### Services
![database structure](images/database.uml.png)
### Code generation

The scala code contained in the zip file is created from an Abstract Syntax Tree (AST). This tree  embodies the simultation structure.
