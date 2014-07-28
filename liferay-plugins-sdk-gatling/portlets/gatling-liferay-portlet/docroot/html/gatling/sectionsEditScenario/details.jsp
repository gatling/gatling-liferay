<%@include file="/html/gatling/header.jsp"%>
<liferay-ui:error-marker key="errorSection" value="details" />
<h3>
	<liferay-ui:message key="details" />
</h3>

<aui:input label="simulation-edit-form-name-scenario" name="scenarioName" value="${scenario.name}">
	<aui:validator name="required" />
	<aui:validator name="alphanum" />
	<aui:validator name="custom" errorMessage="scenario-name-already-used">
	 		function (val, fieldNode, ruleValue) {
			var result = false;
			var list = ${listOfScenarioName};
			if (list.indexOf(val) == -1 || val == "${scenario.name}") {
				result = true;
			}
			return result;
		}
	</aui:validator>
</aui:input>
<aui:input label="" name="variableScenarioName" prefix="scenario" value="${scenario.variableName }"
	readonly="readonly">
</aui:input>

<liferay-ui:icon-help message="nbuser-info-help"/>
<aui:input label="scenario-edit-nb-users-per-second" name="scenarioUsers" value="${scenario.users_per_seconds}">
	<aui:validator name="required"/>
	<aui:validator name="number"/>
	<aui:validator name="min">1</aui:validator>
</aui:input>

<liferay-ui:icon-help message="duration-info-help"/>
<aui:input label="scenario-edit-duration" name="scenarioDuration" value="${scenario.duration}">
	<aui:validator name="required"/>
	<aui:validator name="number"/>
	<aui:validator name="min">1</aui:validator>
</aui:input>

<aui:script use="aui-base">
	A.one("#<portlet:namespace />scenarioName").on("keyup", function(e) {
		A.one("#<portlet:namespace />variableScenarioName").val(this.val().replace(/\W/g, ''));
	});
</aui:script>