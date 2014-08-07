<%-- 
	Copyright 2011-2014 eBusiness Information, Groupe Excilys (www.ebusinessinformation.fr)
--%>
<%@include file="/html/gatling/header.jsp"%>

<aui:fieldset label="details">
	<aui:input label="simulation-edit-form-name-scenario" name="scenarioName" value="${scenario.name}" inlineField="true">
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
	
	<aui:input label="scenario-edit-nb-users-per-second" name="scenarioUsers" 
			value="${scenario.users_per_seconds}" inlineField="true" helpMessage="nbuser-info-help">
		<aui:validator name="required"/>
		<aui:validator name="number"/>
		<aui:validator name="min">1</aui:validator>
	</aui:input>
	
	<aui:input label="scenario-edit-duration" name="scenarioDuration" 
			value="${scenario.duration}" inlineField="true" helpMessage="duration-info-help">
		<aui:validator name="required"/>
		<aui:validator name="number"/>
		<aui:validator name="min">1</aui:validator>
	</aui:input>
</aui:fieldset>