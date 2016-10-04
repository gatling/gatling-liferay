Contribute to Gatling For Liferay
=================================

Gatling for Liferay is a recent project, quite likely to behave in unpredicted ways for specific usages. Therefore there is plenty of rooms for both bug fixes and general improvements.

## About Github's issue tracker

We use Github's issue tracker as a TODO list or, and as far as you are concerned, for filing bug reports and asking for new features.

If you need help or simply want to ask a question, please DON'T use this issue tracker!
Search [Gatling's Google Group](https://groups.google.com/forum/#!forum/gatling). For more visibility, since this Google Group is both used by the [Gatling projet](https://github.com/gatling/gatling) and this project, don't forget to distinctly mention the fact your question is about _**Gatling For Lifray**_ in the title of your topic.You can then post your questions there if they haven't been asked and answered previously.

## Preliminaries

* If you want to contribute to the project, please read our [Wiki](https://github.com/e-biz/gatling-liferay/wiki) to get more informations.
* Uses version 2.2.* of Gatling.
* Search [Issues](https://github.com/gatling/gatling/issues) beforehand, your bug may have been already reported by another user.
* Open one issue for each problem.

## Filing bug reports

In order to get the bugs fixed as fast as possible, we need a few things from you first:

* The environment
* The steps
* The problem

### The environnement

In order to narrow down the search, we need to know first:

* The Gatling's version you're using
* The Liferay's version you're using
* Which OS you're running both your Liferay Portal and your Gatling on
* Which navigator you used
* Your method of running Gatling (Bundle, plugins, Jenkins, etc...)


### The steps

We'll also need to know **exactly** what you were doing.
To do so, please provide a complete description of what you were trying to achieve,
with screenshots of the portlet, and generated code samples, or even better: provide a [Gist](https://gist.github.com/) (or anything similar) of your generated simulation.

### The problem

Finally, describe the problem you're facing: the more information you give, the better.
If there is any error message or stacktrace available, include it in your bug report.


## Git steps

* Fork the repository
* Work on your local version,
* Submit a pull request

### Requirements

Before you submit a pull request, make sure that:

1. New features or API changes are properly documented and follows
2. You provided tests for the code changes you made
3. Branches and commits have to fit the following structure:
  - Branch: "_brancheType-name_"

    Example: ```feature-myfeature``` or ```bugFix-scenarioCreation```

  - Commit: "_[AreaConcerned] Type: Short description_"

    Example: ```[Recorder] Fix: Now remove default records when saving, close #63```

  The commit message must be explicit and states what the commit changes. It must also references the Github issue it's closing.

4. Source files have the appropriate copyright header license :

	```
	/**
 	 * Copyright 2011-2014 eBusiness Information (www.ebusinessinformation.fr)
 	 *
	 * Licensed under the Apache License, Version 2.0 (the "License");
	 * you may not use this file except in compliance with the License.
	 * You may obtain a copy of the License at
 	 *
	 * 		http://www.apache.org/licenses/LICENSE-2.0
 	 *
 	 * Unless required by applicable law or agreed to in writing, software
	 * distributed under the License is distributed on an "AS IS" BASIS,
	 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
	 * See the License for the specific language governing permissions and
	 * limitations under the License.
	 */
 	```

Pull requests are automatically validated by Travis CI and pull requests resulting in a build failure won't obviously be merged.
