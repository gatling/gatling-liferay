/**
 * Shepherd Tour : First scenario
 */
if(readCookie("tour") == "true") {
	eraseCookie("tour");
	
	console.log("Creating First Scenario tour ...");
	var tourFirstScn = new Shepherd.Tour({
		defaults: {
		  classes: 'shepherd-theme-arrows',
		  scrollTo: true
		}
	});
	
	tourFirstScn.addStep('first-scenario-name', {
		title:"Name of scenario",
		text: 'Name ...',
		attachTo: '#_gatling_WAR_gatlingliferayportlet_scenarioName right',
		advanceOn: "#_gatling_WAR_gatlingliferayportlet_sites click"
	});
	
	var last = tourFirstScn.addStep('first-scenario-site', {
		title:"Which site",
		text: 'choose a site ...',
		attachTo: '#_gatling_WAR_gatlingliferayportlet_sites right',
		buttons:[{
		    text: 'Hide',
		    action: tourFirstScn.hide
		  }]
	});
	
	last.on("show", function() {
		createCookie("tour","true",1); 
	});
	
	tourFirstScn.next();
}