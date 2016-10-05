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

