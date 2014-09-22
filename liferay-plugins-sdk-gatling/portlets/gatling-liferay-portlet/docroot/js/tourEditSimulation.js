/**
 * Shepherd tour Simulation List
 */
if(readCookie("tour") == "true") {
	eraseCookie("tour");
	var tourEditSimu = new Shepherd.Tour({
		defaults: {
			classes: 'shepherd-theme-arrows',
			scrollTo: true
		}
	});

	tourEditSimu.addStep('list-scenario', {
		title:"List of scenarios",
		text: 'Here, we have all the scenarios recorded for this simulation.'+
		'<br/>Each row contains basics informations about the scenario.',
		attachTo: 'table top',
	});

	tourEditSimu.addStep('list-scenario-new-scenario', {
		title:"Add a new scenario",
		text: 'You can add a new scenario here ...',
		attachTo: '#newScenario right'
	});

	if(document.getElementById("exportModalTemplate") != null) {
		tourEditSimu.addStep('list-scenario-export', {
			title:"Export the simulation",
			text: 'or you can export your simulation once all scenarios are completed',
			attachTo: '#exportToggle bottom',
			advanceOn : "#exportToggle click",
			buttons:[]
		});

		tourEditSimu.addStep('list-scenario-export-gatling', {
			title:"Select your gatling version",
			text: 'Select your version of Gatling.'+
				'<br/>If you do not have any, select the lastest version'+
				'<br/>and download the lastest Gatling tool too.',
			attachTo: '#_gatling_WAR_gatlingliferayportlet_gatlingVersion right',
			buttons:[{
				text: 'Hide',
				action: tourEditSimu.hide
			}]
		});
	} else {
		tourEditSimu.addStep('list-scenario-export', {
			title:"Export the simulation",
			text: 'or you can export your simulation once all scenarios are completed',
			attachTo: '#exportToggle bottom',
		});
	}

	tourEditSimu.next();
}