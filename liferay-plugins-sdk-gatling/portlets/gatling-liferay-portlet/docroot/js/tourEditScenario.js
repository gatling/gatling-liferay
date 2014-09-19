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
 	
 	tourEditScn.addStep('edit-scenario-sitemap', {
 		title:"Use the sitemap",
 		text: "General explation of this table",
 		attachTo: '.table-scenario top'
 	});
 	
 	tourEditScn.addStep('edit-scenario-checkboxes', {
 		title:"Checkboxes",
 		text: "Checkboxes explanation",
 		attachTo: '#checkAll right'
 	});
 	
 	tourEditScn.addStep('edit-scenario-force-weight', {
 		title:"Force weight",
 		text: "Force weight explanation",
 		attachTo: '#force right'
 	});
 	
 	tourEditScn.addStep('edit-scenario-weight', {
 		title:"Set a weight",
 		text: "weight explanation",
 		attachTo: '#_gatling_WAR_gatlingliferayportlet_weight0 left'
 	});
 	
 	tourEditScn.addStep('edit-scenario-percent', {
 		title:"Percent",
 		text: "Percent explanation",
 		attachTo: '.percent left'
 	});
 	
 	var portlets = document.getElementsByClassName("show-portlet");
 	console.log(portlets[0]);
 	tourEditScn.addStep('edit-scenario-show-portlet', {
 		title:"Show page's portlets",
 		text: "Explanation",
 		attachTo: {element: portlets[0], on: 'left'},
 		advanceOn: {selector: portlets[0], event: 'click'},
 	});
 	
 	tourEditScn.next();
}