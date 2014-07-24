<%@include file="/html/gatling/header.jsp"%>
<liferay-ui:error-marker key="errorSection" value="scenario-edit-details" />
<h3>
	<liferay-ui:message key="scenario-edit-details" />
</h3>

<liferay-ui:icon-help message="nbuser-info-help"/><aui:input label="scenario-edit-nb-users-per-second" name="scenarioUsers" value="${scenario.users_per_seconds}">
	<aui:validator name="number"></aui:validator>
</aui:input>

<liferay-ui:icon-help message="duration-info-help"/><aui:input label="scenario-edit-duration" name="scenarioDuration" value="${scenario.duration}">
	<aui:validator name="number"></aui:validator>
</aui:input>