/**
 * Shepherd tour : Edit Scenario
 */
if(readCookie("tour") == "true") {
	eraseCookie("tour");
	
	console.log("Creating Edit Scenario tour ...");
 	var tourEditScn = new Shepherd.Tour({
 		defaults: {
 		  classes: 'shepherd-theme-arrows',
 		  scrollTo: true
 		}
 	});
 	
 	tourEditScn.addStep('edit-scenario-details-users', {
 		title:"Edit details",
 		text: 'Set the number of users for this scenario',
 		attachTo: '#_gatling_WAR_gatlingliferayportlet_scenarioUsers bottom'
 	});
 	
 	tourEditScn.addStep('edit-scenario-details-duration', {
 		title:"Edit details",
 		text: "Set the scenario's duration",
 		attachTo: '#_gatling_WAR_gatlingliferayportlet_scenarioDuration bottom'
 	});
 	
 	tourEditScn.next();
}