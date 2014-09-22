/**
 * Shepherd tour : Edit Portlet
 */
if(readCookie("tour") == "true") {
	eraseCookie("tour");
	
	console.log("Creating Popup Portlet tour ...");
 	var tourPopup = new Shepherd.Tour({
 		defaults: {
 		  classes: 'shepherd-theme-arrows',
 		  scrollTo: true
 		}
 	});

 	//"<liferay-ui:message key='edit-scenario-no-portlet' />"
 	var tab = document.getElementsByClassName("tab");
 	
 	var tab1 = tourPopup.addStep('portlet-popup-usecase', {
 		title:"<liferay-ui:message key='tour-portlet-popup-usecase-title' />",
 		text: "<liferay-ui:message key='tour-portlet-popup-usecase' />",
 		attachTo: {element: ".nav-tabs", on: 'bottom'},
 		advanceOn: ".nav li:nth-child(2)>a click",
 		buttons:[]
 	});
 	var tab2 = tourPopup.addStep('portlet-popup-record', {
 		title:"<liferay-ui:message key='tour-portlet-popup-record-title' />",
 		text: "<liferay-ui:message key='tour-portlet-popup-record' />",
 		attachTo: {element: ".nav-tabs", on: 'bottom'},
 		advanceOn: ".nav li:nth-child(3)>a click",
 		buttons:[]
 	});
 	
 	var last = tourPopup.addStep('portlet-popup-configure', {
 		title:"<liferay-ui:message key='tour-portlet-popup-configure-title' />",
 		text: "<liferay-ui:message key='tour-portlet-popup-configure' />",
 		attachTo: {element:".nav-tabs", on: 'bottom'},
		buttons:[{
		    text: "<liferay-ui:message key='tour-understood' />",
		    action: tourPopup.hide
		  }]
 	});	 
 	
	
	last.on("show", function() {
		createCookie("tour","true",1); 
	});
	
 	
 	tourPopup.next();
}