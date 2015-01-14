/**
 * Shepherd tour : Edit Scenario
 */

console.log("Creating Edit Scenario tour ...");
var tourEditScn = new Shepherd.Tour({
	defaults: {
		classes: 'shepherd-theme-arrows',
		scrollTo: true,
		showCancelLink:true
	}
});

tourEditScn.addStep('edit-scenario', {
	title:"<liferay-ui:message key='tour-edit-scenario-title' />",
	text: "<liferay-ui:message key='tour-edit-scenario' />",
	attachTo: '.header-title>span bottom'
});

tourEditScn.addStep('edit-scenario-details-users', {
	title:"<liferay-ui:message key='tour-edit-scenario-details-users-title' />",
	text: "<liferay-ui:message key='tour-edit-scenario-details-users' />",
	attachTo: '#_gatling_WAR_gatlingliferayportlet_scenarioUsers bottom'
});

tourEditScn.addStep('edit-scenario-details-duration', {
	title:"<liferay-ui:message key='tour-edit-scenario-details-duration-title' />",
	text: "<liferay-ui:message key='tour-edit-scenario-details-duration' />",
	attachTo: '#_gatling_WAR_gatlingliferayportlet_scenarioDuration bottom'
});

tourEditScn.addStep('edit-scenario-sitemap', {
	title:"Use the sitemap",
	text: "<liferay-ui:message key='tour-edit-scenario-sitemap' />" +
	"<br/><liferay-ui:message key='help-use-scenario-colors' />" +
	"<ul><li><liferay-ui:message key='help-use-scenario-empty' />" +
	"<li><liferay-ui:message key='help-use-scenario-green' /></li>" +
	"<li><liferay-ui:message key='help-use-scenario-red' /></li></ul>",
	attachTo: '.table-scenario top'
});

tourEditScn.addStep('edit-scenario-checkboxes', {
	title:"<liferay-ui:message key='tour-edit-scenario-checkboxes-title' />",
	text: "<liferay-ui:message key='tour-edit-scenario-checkboxes' />", //redo
	attachTo: '#checkAll right'
});

tourEditScn.addStep('edit-scenario-force-weight', {
	title:"<liferay-ui:message key='tour-edit-scenario-force-weight-title' />",
	text: "<liferay-ui:message key='tour-edit-scenario-force-weight' />",
	attachTo: '#force right'
});

tourEditScn.addStep('edit-scenario-weight', {
	title:"<liferay-ui:message key='tour-edit-scenario-weight-title' />",
	text: "<liferay-ui:message key='tour-edit-scenario-weight' />",
	attachTo: '#_gatling_WAR_gatlingliferayportlet_weight0 left'
});

tourEditScn.addStep('edit-scenario-percent', {
	title:"<liferay-ui:message key='tour-edit-scenario-percent-title' />",
	text: "<liferay-ui:message key='tour-edit-scenario-percent' />",
	attachTo: '.percent left'
});

var portlets = document.getElementsByClassName("show-portlet");
if(portlets.length > 0) {
	var thePortletPage = portlets[0];
	tourEditScn.addStep('edit-scenario-show-portlet', {
		title:"<liferay-ui:message key='tour-edit-scenario-show-portlet-title' />",
		text: "<liferay-ui:message key='tour-edit-scenario-show-portlet' />",
		attachTo: {element: thePortletPage, on: 'left'},
		advanceOn: ".show-portlet click",
		buttons:[]
	});

	var portletLine = document.getElementsByClassName("portlet-popup")[0].parentNode.parentNode;
	tourEditScn.addStep('edit-scenario-edit-portlet', {
		title:"<liferay-ui:message key='tour-edit-scenario-edit-portlet-title' />",
		text: "<liferay-ui:message key='tour-edit-scenario-edit-portlet' />",
		attachTo: {element: portletLine, on: 'bottom'},
		advanceOn: ".show-portlet click"
	});

	var last = tourEditScn.addStep('edit-scenario-edit-portlet-popup', {
		title:"<liferay-ui:message key='tour-edit-scenario-edit-portlet-popup-title' />",
		text: "<liferay-ui:message key='tour-edit-scenario-edit-portlet-popup' />",
		attachTo: {element: ".portlet-popup", on: 'left'},
		advanceOn: ".portlet-popup click",
		buttons:[]
	});	
} 
else {
	var last = tourEditScn.addStep('edit-scenario-no-portlet', {
		title:"<liferay-ui:message key='tour-edit-scenario-no-portlet-title' />",
		text: "<liferay-ui:message key='tour-edit-scenario-no-portlet' />",
		attachTo: ".table-scenario top",
		buttons:[{
			text: "<liferay-ui:message key='tour-understood' />",
			action: tourEditScn.hide
		}]
	});	
}

last.on("show", function() {
	createCookie("tour","true",1); 
});

if(readCookie("tour") == "true") {
	eraseCookie("tour");
	tourEditScn.next();
}
