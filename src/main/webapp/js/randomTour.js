/*
 * Copyright 2011-2016 GatlingCorp (http://gatling.io)
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
