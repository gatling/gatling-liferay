/**
 * Shepherd tour Simulation List
 */
if(readCookie("tour") == "true") {
	eraseCookie("tour");
	var tourEditSimu = new Shepherd.Tour({
		defaults: {
			classes: 'shepherd-theme-arrows',
			scrollTo: true
		}
	});

	tourEditSimu.addStep('list-scenario', {
		title:"<liferay-ui:message key='tour-list-scenario-title' />",
		text: "<liferay-ui:message key='tour-list-scenario' />",
		attachTo: 'table top',
	});

	tourEditSimu.addStep('list-scenario-new-scenario', {
		title:"<liferay-ui:message key='tour-list-scenario-new-scenario-title' />",
		text: "<liferay-ui:message key='tour-list-scenario-new-scenario' />",
		attachTo: '#newScenario right'
	});

	if(document.getElementById("exportModalTemplate") != null) {
		tourEditSimu.addStep('list-scenario-export', {
			title:"<liferay-ui:message key='tour-list-scenario-export-title' />",
			text: "<liferay-ui:message key='tour-list-scenario-export' />",
			attachTo: '#exportToggle bottom',
			advanceOn : "#exportToggle click",
			buttons:[]
		});

		tourEditSimu.addStep('list-scenario-export-gatling', {
			title:"<liferay-ui:message key='tour-list-scenario-export-gatling-title' />",
			text: "<liferay-ui:message key='tour-list-scenario-export-gatling' />",
			attachTo: '#_gatling_WAR_gatlingliferayportlet_gatlingVersion right',
			buttons:[{
				text: "<liferay-ui:message key='tour-understood' />",
				action: tourEditSimu.hide
			}]
		});
	} else {
		tourEditSimu.addStep('list-scenario-export', {
			title:"<liferay-ui:message key='tour-list-scenario-export-title' />",
			text: "<liferay-ui:message key='tour-list-scenario-export' />",
			attachTo: '#exportToggle bottom',
			buttons:[{
				text: "<liferay-ui:message key='tour-understood' />",
				action: tourEditSimu.hide
			}]
		});
	}

	tourEditSimu.next();
}