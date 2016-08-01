/**
 * Shepherd tour Simulation List
 */
var tourDefaultFirstSimu = new Shepherd.Tour({
	  defaults: {
	    classes: 'shepherd-theme-arrows',
	    scrollTo: true,
	    showCancelLink: true
	  }
});
tourDefaultFirstSimu.addStep('welcome', {
	title:"<liferay-ui:message key='tour-welcome-title'/>",
	text: "<liferay-ui:message key='tour-welcome'/>",
	attachTo: '#controlPanelSubNavgatling_WAR_gatlingliferayportletLink>span bottom',
});

tourDefaultFirstSimu.addStep('list-simulation', {
	title:"<liferay-ui:message key='tour-default-scenario-title' />",
	text: "<liferay-ui:message key='tour-default-scenario' />",
	attachTo: '#advancedButon  right',
});

tourDefaultFirstSimu.addStep('list-simulation1', {
	title:"<liferay-ui:message key='tour-default-workflow-title' />",
	text: "<liferay-ui:message key='tour-default-workflow' />",
	attachTo: '#scenario-flow  bottom',
});

tourDefaultFirstSimu.addStep('list-simulation2', {
	title:"<liferay-ui:message key='tour-default-scenario-properties-title' />",
	text: "<liferay-ui:message key='tour-default-scenario-properties' />",
	attachTo: '#_gatling_WAR_gatlingliferayportlet_rampUp right',
});

tourDefaultFirstSimu.addStep('list-simulation1', {
	title:"<liferay-ui:message key='tour-default-feeder-title' />",
	text: "<liferay-ui:message key='tour-default-feeder' />",
	attachTo: '#_gatling_WAR_gatlingliferayportlet_feederContent  right',
});

var last = tourDefaultFirstSimu.addStep('list-simulation3', {
	title:"<liferay-ui:message key='tour-default-export-title' />",
	text: "<liferay-ui:message key='tour-default-export' />",
	attachTo: '#exportToggle right',
	buttons:[{
	    text: "<liferay-ui:message key='tour-understood' />",
	    action: tourDefaultFirstSimu.hide
	  }]
});

last.on("show", function() {
	createCookie("tour","true",1); 
});