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
		title:"List of scenario",
		text: 'List scenario text ...',
		attachTo: 'table top',
	});

	tourEditSimu.addStep('list-scenario-new-scenario', {
		title:"Add a new scenario",
		text: 'Text Text ...',
		attachTo: '#newScenario bottom'
	});

	tourEditSimu.addStep('list-scenario-export', {
		title:"Export the simulation",
		text: 'Text Text ...',
		attachTo: '#exportToggle bottom',
		advanceOn : "#exportToggle click",
		buttons:[]
	});

	tourEditSimu.addStep('list-scenario-export-gatling', {
		title:"Select your gatling version",
		text: 'Text Text ...',
		attachTo: '#_gatling_WAR_gatlingliferayportlet_gatlingVersion right',
		buttons:[{
			text: 'Hide',
			action: tourEditSimu.hide
		}]
	});
	
	tourEditSimu.next();
}