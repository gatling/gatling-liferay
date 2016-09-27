

var takeATour = new Shepherd.Tour({
	  defaults: {
	    classes: 'shepherd-theme-arrows',
	    scrollTo: true,
	    showCancelLink: true
	  }
});

takeATour.addStep('record', {
	title:"<liferay-ui:message key='record-help-title'/>",
	text: "<liferay-ui:message key='record-help'/>",
	attachTo: '.header-title span right'
});

takeATour.addStep('record1', {
	title:"<liferay-ui:message key='record-help1-title'/>",
	text: "<liferay-ui:message key='record-help1'/>",
	attachTo: '#portletRecordFrame top'
});

var last = takeATour.addStep('record2', {
	title:"<liferay-ui:message key='record-help2-title'/>",
	text: "<liferay-ui:message key='record-help2'/>",
	attachTo: '#exportToggle left',
	buttons:[{
		text: "<liferay-ui:message key='tour-understood' />",
		action: takeATour.hide
	}]
});

