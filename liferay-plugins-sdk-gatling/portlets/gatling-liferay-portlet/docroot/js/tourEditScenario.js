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
 		text: 'You created your first scenario, it is the core of your script !<br/> Click next for further explanation',
 		attachTo: '.header-title>span bottom'
 	});
 	
 	tourEditScn.addStep('edit-scenario-details-users', {
 		title:"Edit details (1/2)",
 		text: "Set the scenario's number of users",
 		attachTo: '#_gatling_WAR_gatlingliferayportlet_scenarioUsers bottom'
 	});
 	
 	tourEditScn.addStep('edit-scenario-details-duration', {
 		title:"Edit details (2/2)",
 		text: "Set the scenario's duration",
 		attachTo: '#_gatling_WAR_gatlingliferayportlet_scenarioDuration bottom'
 	});
 	
 	tourEditScn.addStep('edit-scenario-sitemap', {
 		title:"Use the sitemap",
 		text: "This table represents your sitemap, every row is a page of your site or a portlet of your site.", // couleur
 		attachTo: '.table-scenario top'
 	});
 	
 	tourEditScn.addStep('edit-scenario-checkboxes', {
 		title:"Checkboxes",
 		text: "Checkboxes are used to select multiple pages at once." +
 				"<br/>Click next to see why it is useful.", //redo
 		attachTo: '#checkAll right'
 	});
 	
 	tourEditScn.addStep('edit-scenario-force-weight', {
 		title:"Force weight",
 		text: "You can force weight on differents rows at once when used with checkboxes.<br/>What is a weight you say ? Click next to figure it out",
 		attachTo: '#force right'
 	});
 	
 	tourEditScn.addStep('edit-scenario-weight', {
 		title:"Set a weight",
 		text: "A weight is a number you decide, itself it means nothing, look at the percent" +
 				"<br/>next to it to understand in what this will affect your scenario.",
 		attachTo: '#_gatling_WAR_gatlingliferayportlet_weight0 left'
 	});
 	
 	tourEditScn.addStep('edit-scenario-percent', {
 		title:"Percent",
 		text: "Here you can see the percent of change" +
 				"<br/>that a virtual user will load this page.",
 		attachTo: '.percent left'
 	});
 	
 	var portlets = document.getElementsByClassName("show-portlet");
 	if(portlets.length > 0) {
	 	var thePortletPage = portlets[0];
	 	tourEditScn.addStep('edit-scenario-show-portlet', {
	 		title:"Show page's portlets",
	 		text: "If you page contains portlets(s)" +
	 				"<br/>you can even choose which portlet will be stress-tested.<br/>Click on the button to show this page's portlet(s).",
	 		attachTo: {element: thePortletPage, on: 'left'},
	 		advanceOn: ".show-portlet click",
	 		buttons:[]
	 	});
	 	
	 	var portletLine = document.getElementsByClassName("portlet-popup")[0].parentNode.parentNode;
	 	tourEditScn.addStep('edit-scenario-edit-portlet', {
	 		title:"portlet row",
	 		text: "This new row act like a page row, but you can configure more details.",
	 		attachTo: {element: portletLine, on: 'bottom'},
	 		advanceOn: ".show-portlet click"
	 	});
	 	
	 	var last = tourEditScn.addStep('edit-scenario-edit-portlet-popup', {
	 		title:"Edit portlets",
	 		text: "Click on the portlet's name will open a popup." +
	 				"<br/>This popup will help you configure the way " +
	 				"<br/>you want to stress your portlet. " +
	 				"<br/>Click on it now.",
	 		attachTo: {element: ".portlet-popup", on: 'left'},
	 		advanceOn: ".portlet-popup click",
		 	buttons:[]
	 	});	
 	} 
 	else {
 		var last = tourEditScn.addStep('edit-scenario-no-portlet', {
	 		title:"No portlet",
	 		text: "Too bad, you have not any portlet to try.",
	 		attachTo: ".table-scenario top",
			buttons:[{
			    text: 'Hide',
			    action: tourEditScn.hide
			  }]
	 	});	
 	}
 	
 	last.on("show", function() {
 		createCookie("tour","true",1); 
 	});
 	
 	tourEditScn.next();
}
