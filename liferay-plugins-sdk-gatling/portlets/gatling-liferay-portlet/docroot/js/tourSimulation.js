/**
 * Shepherd tour Simulation List
 */
var tourFirstSimu = new Shepherd.Tour({
	  defaults: {
	    classes: 'shepherd-theme-arrows',
	    scrollTo: true,
	    showCancelLink: true
	  }
});
tourFirstSimu.addStep('welcome', {
	title:"<liferay-ui:message key='tour-welcome-title'/>",
	text: "<liferay-ui:message key='tour-welcome'/>",
	attachTo: '#controlPanelSubNavgatling_WAR_gatlingliferayportletLink>span bottom',
});
tourFirstSimu.addStep('list-simulation', {
	title:"<liferay-ui:message key='tour-list-simulation-title' />",
	text: "<liferay-ui:message key='tour-list-simulation' />",
	attachTo: '#_gatling_WAR_gatlingliferayportlet_fmExport top',
});
tourFirstSimu.addStep('create-simulation', {
	title:"<liferay-ui:message key='tour-create-simulation-title' />",
	text: "<liferay-ui:message key='tour-create-simulation' />",
	attachTo: '#newSimulation right',
	advanceOn: "#newSimulation click",
	buttons:[]
});
var last = tourFirstSimu.addStep('fill-simulation', {
	title:"<liferay-ui:message key='tour-fill-simulation-title' />",
	text: "<liferay-ui:message key='tour-fill-simulation' />",
	attachTo: '#_gatling_WAR_gatlingliferayportlet_simulationName right',
	buttons:[{
	    text: "<liferay-ui:message key='tour-understood' />",
	    action: tourFirstSimu.hide
	  }]
});

last.on("show", function() {
	createCookie("tour","true",1); 
});
