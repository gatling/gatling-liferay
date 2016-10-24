/*
 * Copyright 2011-2016 GatlingCorp (http://gatling.io)
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
/* The following code generates a JSON representing the simulation.
 * The JSON object is created by several functions (one by element level)
 * 
 * At the moment the json result is passed from the view to the controller via a hidden form input (yeah bit ugly isn't it?)
 * NOTE: some improvements can be done regarding this part:
 * 	1 -> Persist scenario is called each time a box changes (time, order, name...),
 * 		 is could only be called at actionURL/resourcesURL calls
 *  2 -> A REST implementation with web services and ajax calls would improve performances.
 */

persistScenarios();

/* Main Functions */

function persistScenarios(){
	
	var json = computesScenariosJSon();
		
	document.getElementById('JSON').value = JSON.stringify(json);
}


function computesScenariosJSon(){
	var scenarios = document.getElementsByClassName("scenario");
	var jsonScenarios = [];
	for(var i = 0; i < scenarios.length; i++){
		jsonScenarios.push(scenarioToJSon(scenarios[i]));
	}
	return jsonScenarios;
}


/* JSON Genertors */	

function scenarioToJSon(scenario) {
	var nameBlock = scenario.getElementsByClassName("scenario-name")[0];
	var name;
	
	var inputs = nameBlock.getElementsByClassName("field");
	// Distinguish first element "_default_scenario_" from other inputs
	if (inputs.length > 0) {
		name = inputs[0].value;
	}
	else {
		name =nameBlock.innerHTML.trim();
	}
	var id = scenario.id.replace("_sc", "");
	
	var blockuses = scenario.getElementsByClassName("blockus");
	var jsonWorkflow = [];
	
	//length - 1 because the last element is the #endBlock
	for(var i = 0; i < blockuses.length - 1; i++){
		jsonWorkflow.push(blockusToJSon(blockuses[i]));
	}
	
	return {"name": name, "id": id, "processes": jsonWorkflow};
}


function blockusToJSon(blockus) {
	
	var cssId = blockus.id.replace("_box", "");
	var cssClass = getClass(blockus, "_p");
	var type = getClass(blockus, "_ty");
	
	var name;
	var pause;
	if(type==="PAUSE"){
		var pauseBlock = blockus.getElementsByClassName("pause-name")[0];
		name = pauseBlock.innerHTML;
		var s = "#" + blockus.id + " input";
		pause = parseInt( $("#" + blockus.id + " input")[0].value, 10);
	}
	else {
		var process = blockus.getElementsByClassName("action")[0];
		name = process.innerHTML;
		pause = -1;
	}
	
	return {"name": name, "cssId": cssId, "cssClass": cssClass, "type": type, "pause": pause};
}

function getClass(elt, prefix) {
	var classes = elt.className.split(/\s+/);
	var res;
	$.each(classes, function() {
		if(this.includes(prefix)) {
			res = this.replace(prefix, "");
		}
	});
	return res;
}

// Add a onChanged listeners on all the time inputs (NOTE: +/- buttons are not processed here but in wan-spinner-launch.js)
$('.time-input').each(function() {
	   var elem = $(this);

	   // Save current value of element
	   elem.data('oldVal', elem.val());

	   // Look for changes in the value
	   elem.bind("propertychange change click keyup input paste", function(event){
	      // If value has changed...
	      if (elem.data('oldVal') != elem.val()) {
	       // Updated stored value
	       elem.data('oldVal', elem.val());

	       // Do action
	       persistScenarios();
	     }
	   });
});

// Add a onChanged listeners on all the time inputs (NOTE: +/- buttons are not processed here but in wan-spinner-launch.js)
$('.scenario-name').each(function() {
	   var elem = $(this).find(':input');

	   // Save current value of element
	   elem.data('oldVal', elem.val());

	   // Look for changes in the value
	   elem.bind("propertychange change click keyup input paste", function(event){
	      // If value has changed...
	      if (elem.data('oldVal') != elem.val()) {
	       // Updated stored value
	       elem.data('oldVal', elem.val());

	       // Do action
	       persistScenarios();
	     }
	   });
});

function setScenarioId(id) {
	document.getElementById('<portlet:namespace/>scenarioId').value = id;
	persistScenarios();
}




