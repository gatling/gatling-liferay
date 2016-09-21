


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


tourDefaultFirstSimu.addStep('scenarios', {
	title:"<liferay-ui:message key='tour-design-scenario-title'/>",
	text: "<liferay-ui:message key='tour-design-scenario'/>",
	attachTo: '#design-scenario top',
	scrollTo: false,
	when: {
	      show: function() {
	        console.log("HEY I JUST MET YOU!");
	      }
	    }
});


tourDefaultFirstSimu.addStep('list-simulation1', {
	title:"<liferay-ui:message key='tour-default-workflow-title' />",
	text: "<liferay-ui:message key='tour-default-workflow' />",
	attachTo: '#wf_0 top',
	scrollTo:false
});


tourDefaultFirstSimu.addStep('library', {
	title:"<liferay-ui:message key='tour-library-title'/>",
	text: "<liferay-ui:message key='tour-library'/>",
	attachTo: '.library top',
	scrollTo: false
});


tourDefaultFirstSimu.addStep('create-process', {
	title:"<liferay-ui:message key='tour-create-processes-title'/>",
	text: "<liferay-ui:message key='tour-create-processes'/>",
	attachTo: '#add-process left',
	scrollTo: false
});

tourDefaultFirstSimu.addStep('save-scenarios', {
	title:"<liferay-ui:message key='tour-create-save-scenario-title'/>",
	text: "<liferay-ui:message key='tour-create-save-scenario'/>",
	attachTo: '#save-scenarios right'
});

tourDefaultFirstSimu.addStep('list-simulation2', {
	title:"<liferay-ui:message key='tour-default-scenario-properties-title' />",
	text: "<liferay-ui:message key='tour-default-scenario-properties' />",
	attachTo: '#injectionBlock top',
});


tourDefaultFirstSimu.addStep('list-simulation1', {
	title:"<liferay-ui:message key='tour-default-feeder-title' />",
	text: "<liferay-ui:message key='tour-default-feeder' />",
	attachTo: '#FeederBlock top',
});

var last = tourDefaultFirstSimu.addStep('list-simulation3', {
	title:"<liferay-ui:message key='tour-default-export-title' />",
	text: "<liferay-ui:message key='tour-default-export' />",
	attachTo: '#exportBlock top',
	buttons:[{
	    text: "<liferay-ui:message key='tour-understood' />",
	    action: tourDefaultFirstSimu.hide
	  }]
});
