/**
 * Shepherd tour : Edit Portlet
 */
if(readCookie("tour") == "true") {
	eraseCookie("tour");
	
	console.log("Creating Popup Portlet tour ...");
 	var tourPopup = new Shepherd.Tour({
 		defaults: {
 		  classes: 'shepherd-theme-arrows',
 		  scrollTo: true,
 		  showCancelLink:true
 		}
 	});

 	var tab = document.getElementsByClassName("tab");
 	
 	var tab1 = tourPopup.addStep('portlet-popup-usecase', {
 		title:"Select an use case ",
 		text: "Explanation",
 		attachTo: {element: ".nav-tabs", on: 'bottom'},
 		advanceOn: ".nav li:nth-child(2)>a click",
 		buttons:[]
 	});
 	var tab2 = tourPopup.addStep('portlet-popup-record', {
 		title:"Record an use case",
 		text: "Explanation",
 		attachTo: {element: ".nav-tabs", on: 'bottom'},
 		advanceOn: ".nav li:nth-child(3)>a click",
 		buttons:[]
 	});
 	
 	tourPopup.addStep('portlet-popup-configure', {
 		title:"Configure an use case",
 		text: "Explanation",
 		attachTo: {element:".nav-tabs", on: 'bottom'},
		buttons:[{
		    text: 'Hide',
		    action: tourPopup.hide
		  }]
 	});	 
 	
 	tourPopup.next();
}