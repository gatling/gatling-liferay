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

 	var tab = document.getElementsByClassName("tab");
 	
 	var tab1 = tourPopup.addStep('portlet-popup-usecase', {
 		title:"Select an use case",
 		text: "On the first tab, you can add usecases. Again it comes with a weight and percent." +
 				"<br/>If you can't find a usecase that suit your needs, create your own !" +
 				"<br/>Click now on Record my use case tab to see how.",
 		attachTo: {element: ".nav-tabs", on: 'bottom'},
 		advanceOn: ".nav li:nth-child(2)>a click",
 		buttons:[]
 	});
 	var tab2 = tourPopup.addStep('portlet-popup-record', {
 		title:"Record an use case",
 		text: "Here you can create a usecase. Name it and start recording, navigate throught the portlet and once you are done, stop it." +
 				"<br/> You made a mistake ? You can erase it. " +
 				"<br/>Click now on the last tab to see how.",
 		attachTo: {element: ".nav-tabs", on: 'bottom'},
 		advanceOn: ".nav li:nth-child(3)>a click",
 		buttons:[]
 	});
 	
 	var last = tourPopup.addStep('portlet-popup-configure', {
 		title:"Configure an use case",
 		text: "Here you can remove and change details on a usecase," +
 				"<br/> feel free to change the name of any existing usecase you recorded.",
 		attachTo: {element:".nav-tabs", on: 'bottom'},
		buttons:[{
		    text: 'Hide',
		    action: tourPopup.hide
		  }]
 	});	 
 	
	
	last.on("show", function() {
		createCookie("tour","true",1); 
	});
	
 	
 	tourPopup.next();
}