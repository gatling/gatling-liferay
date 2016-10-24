/*
 * Copyright 2011-2015 GatlingCorp (http://gatling.io)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * 		http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


/**
 * Shepherd tour Simulation List
 */
var takeATour = new Shepherd.Tour({
	  defaults: {
	    classes: 'shepherd-theme-arrows',
	    scrollTo: true,
	    showCancelLink: true
	  }
});

takeATour.addStep('welcome', {
	title:"<liferay-ui:message key='tour-welcome-title'/>",
	text: "<liferay-ui:message key='tour-welcome'/>",
	attachTo: '#controlPanelSubNavgatling_WAR_gatlingliferayportletLink>span bottom',
});


takeATour.addStep('scenarios', {
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


takeATour.addStep('list-simulation1', {
	title:"<liferay-ui:message key='tour-default-workflow-title' />",
	text: "<liferay-ui:message key='tour-default-workflow' />",
	attachTo: '#wf_0 top',
	scrollTo:false
});


takeATour.addStep('library', {
	title:"<liferay-ui:message key='tour-library-title'/>",
	text: "<liferay-ui:message key='tour-library'/>",
	attachTo: '.library top',
	scrollTo: false
});


takeATour.addStep('create-process', {
	title:"<liferay-ui:message key='tour-create-processes-title'/>",
	text: "<liferay-ui:message key='tour-create-processes'/>",
	attachTo: '#add-process left',
	scrollTo: false
});

takeATour.addStep('save-scenarios', {
	title:"<liferay-ui:message key='tour-create-save-scenario-title'/>",
	text: "<liferay-ui:message key='tour-create-save-scenario'/>",
	attachTo: '#save-scenarios right'
});

takeATour.addStep('list-simulation2', {
	title:"<liferay-ui:message key='tour-default-scenario-properties-title' />",
	text: "<liferay-ui:message key='tour-default-scenario-properties' />",
	attachTo: '#injectionBlock top',
});


takeATour.addStep('list-simulation1', {
	title:"<liferay-ui:message key='tour-default-feeder-title' />",
	text: "<liferay-ui:message key='tour-default-feeder' />",
	attachTo: '#FeederBlock top',
});

var last = takeATour.addStep('list-simulation3', {
	title:"<liferay-ui:message key='tour-default-export-title' />",
	text: "<liferay-ui:message key='tour-default-export' />",
	attachTo: '#exportBlock top',
	buttons:[{
	    text: "<liferay-ui:message key='tour-understood' />",
	    action: takeATour.hide
	  }]
});
