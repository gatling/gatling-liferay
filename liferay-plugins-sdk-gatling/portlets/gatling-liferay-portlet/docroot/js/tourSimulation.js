/**
 * Shepherd tour Simulation List
 */
var tourFirstSimu = new Shepherd.Tour({
	  defaults: {
	    classes: 'shepherd-theme-arrows',
	    scrollTo: true
	  }
});

tourFirstSimu.addStep('list-simulation', {
	title:"List of simulations",
	text: 'List simulation text ...',
	attachTo: '#_gatling_WAR_gatlingliferayportlet_fmExport top',
});
tourFirstSimu.addStep('create-simulation', {
	title:"New simulation",
	text: 'Create a new simulation ...',
	attachTo: '#newSimulation right',
	advanceOn: "#newSimulation click",
	buttons:[]
});
var last = tourFirstSimu.addStep('fill-simulation', {
	title:"Fill simulation",
	text: 'Create a new simulation ...',
	attachTo: '#_gatling_WAR_gatlingliferayportlet_simulationName left',
	buttons:[{
	    text: 'Hide',
	    action: tourFirstSimu.hide
	  }]
});

last.on("show", function() {
	createCookie("tour","true",1); 
});
