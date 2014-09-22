/**
 * Shepherd tour : Edit Scenario
 */
if(readCookie("tour") == "true") {
	eraseCookie("tour");
	
	console.log("Creating Edit Scenario tour ...");
 	var tourEditScn = new Shepherd.Tour({
 		defaults: {
 		  classes: 'shepherd-theme-arrows',
 		  scrollTo: true,
 		  showCancelLink:true
 		}
 	});
 	
 	
 	tourEditScn.addStep('edit-scenario', {
 		title:"General explanation",
 		text: 'Explanation',
 		attachTo: '.header-title>span bottom'
 	});
 	
 	tourEditScn.addStep('edit-scenario-details-users', {
 		title:"Edit details",
 		text: "Set the scenario's number of users",
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
 	if(portlets.length > 0) {
	 	var thePortletPage = portlets[0];
	 	tourEditScn.addStep('edit-scenario-show-portlet', {
	 		title:"Show page's portlets",
	 		text: "Explanation",
	 		attachTo: {element: thePortletPage, on: 'left'},
	 		advanceOn: ".show-portlet click",
	 		buttons:[]
	 	});
	 	
	 	var portletLine = document.getElementsByClassName("portlet-popup")[0].parentNode.parentNode;
	 	tourEditScn.addStep('edit-scenario-edit-portlet', {
	 		title:"Edit portlets",
	 		text: "Explanation edit",
	 		attachTo: {element: portletLine, on: 'bottom'},
	 		advanceOn: ".show-portlet click"
	 	});
	 	
	 	var last = tourEditScn.addStep('edit-scenario-edit-portlet-popup', {
	 		title:"Edit portlets",
	 		text: "Explanation edit",
	 		attachTo: {element: ".portlet-popup", on: 'left'},
	 		advanceOn: ".portlet-popup click",
		 	buttons:[]
	 	});	
 	} 
 	
 	last.on("show", function() {
 		createCookie("tour","true",1); 
 	});
 	
 	tourEditScn.next();
}
