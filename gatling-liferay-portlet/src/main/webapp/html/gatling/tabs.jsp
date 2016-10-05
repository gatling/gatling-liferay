<%--

    Copyright 2011-2015 GatlingCorp (http://gatling.io)

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

    		http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.

--%>
<%@include file="/html/gatling/header.jsp"%>

<portlet:renderURL var="renderView">
	<portlet:param name="render" value="renderView" />
</portlet:renderURL>

<liferay-ui:tabs names="Scenario Builder,Recorder" value="Recorder" refresh="false" url0="${renderView}">

	<liferay-ui:section>
	</liferay-ui:section>

	<liferay-ui:section>
		<%@ include file="recorderView.jsp"%>
	</liferay-ui:section>

</liferay-ui:tabs>

