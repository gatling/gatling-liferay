/**
 * Shepherd Tour : First scenario
 */


console.log("Creating First Scenario tour ...");
var tourFirstScn = new Shepherd.Tour({
	defaults: {
		classes: 'shepherd-theme-arrows',
		scrollTo: true,
		showCancelLink: true
	}
});

tourFirstScn.addStep('first-scenario-name', {
	title:"<liferay-ui:message key='tour-first-scenario-name-title' />",
	text: "<liferay-ui:message key='tour-first-scenario-name' />",
	attachTo: '#_gatling_WAR_gatlingliferayportlet_scenarioName right',
	advanceOn: "#_gatling_WAR_gatlingliferayportlet_sites click"
});

var last = tourFirstScn.addStep('first-scenario-site', {
	title:"<liferay-ui:message key='tour-first-scenario-site-title' />",
	text: "<liferay-ui:message key='tour-first-scenario-site' />",
	attachTo: '#_gatling_WAR_gatlingliferayportlet_sites right',
	buttons:[{
		text: "<liferay-ui:message key='tour-understood' />",
		action: tourFirstScn.hide
	}]
});

last.on("show", function() {
	createCookie("tour","true",1); 
});

if(readCookie("tour") == "true") {
	eraseCookie("tour");	
	tourFirstScn.next();
}