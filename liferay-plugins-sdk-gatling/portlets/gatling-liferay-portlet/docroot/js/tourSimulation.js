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
	text: 'Here you can see the list of the existing simulation.<br/>Of course if it is the first time you run this app it will be empty.',
	attachTo: '#_gatling_WAR_gatlingliferayportlet_fmExport top',
});
tourFirstSimu.addStep('create-simulation', {
	title:"New simulation",
	text: "Well, let's start with creating a new simulation ...",
	attachTo: '#newSimulation right',
	advanceOn: "#newSimulation click",
	buttons:[]
});
var last = tourFirstSimu.addStep('fill-simulation', {
	title:"Your simulation",
	text: 'This is the name of your new simulation.<br/>Please use only alphanumerics charaters and spaces',
	attachTo: '#_gatling_WAR_gatlingliferayportlet_simulationName right',
	buttons:[{
	    text: 'Hide',
	    action: tourFirstSimu.hide
	  }]
});

last.on("show", function() {
	createCookie("tour","true",1); 
});
