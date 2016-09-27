
var takeATour = new Shepherd.Tour({
	  defaults: {
	    classes: 'shepherd-theme-arrows',
	    scrollTo: true,
	    showCancelLink: true
	  }
});

takeATour.addStep('random', {
	title:"<liferay-ui:message key='random-help-title'/>",
	text: "<liferay-ui:message key='random-help'/>",
	attachTo: '.header-title span right'
});

takeATour.addStep('random1', {
	title:"<liferay-ui:message key='random-help1-title'/>",
	text: "<liferay-ui:message key='random-help1'/>",
	attachTo: '#page-header right'
});

var last = takeATour.addStep('random2', {
	title:"<liferay-ui:message key='random-help2-title'/>",
	text: "<liferay-ui:message key='random-help2'/>",
	attachTo: '#weight-header top',
	buttons:[{
		text: "<liferay-ui:message key='tour-understood' />",
		action: takeATour.hide
	}]
});
