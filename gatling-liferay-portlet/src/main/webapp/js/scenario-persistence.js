
persistScenarios();


/* Events */

function persistScenarios(){
	console.log("Call persistScenarios()");
	
	
	var json = computesScenariosJSon();
	console.log("scenarios: " + JSON.stringify(json));
		
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
	console.log("scenarioToJSON called");
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
	console.log("blockusToJSON called");
	
	var cssId = blockus.id.replace("_box", "");
	var cssClass = getClass(blockus, "_p");
	var type = getClass(blockus, "_ty");
	
	var name;
	var pause;
	if(type==="PAUSE"){
		console.log("Pause condition");
		var pauseBlock = blockus.getElementsByClassName("pause-name")[0];
		name = pauseBlock.innerHTML;
		var s = "#" + blockus.id + " input";
		pause = parseInt( $("#" + blockus.id + " input")[0].value, 10);
	}
	else {
		console.log("else condition");
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




