<aui:form action="${addScenarioURL}" name="fm" id="fm">
	<div class="well well-small">
		<p>
			<liferay-ui:icon-help message="About this page">
				<liferay-ui:message key="create-scenario-help" />
			</liferay-ui:icon-help>
		</p>
	</div>
	<aui:fieldset>
		<aui:input label="simulation-edit-form-name-scenario"
			name="scenarioName">
			<aui:validator name="required" />
			<aui:validator name="alphanum" />
			<aui:validator name="custom"
				errorMessage="simulation-name-already-used">
			 		function (val, fieldNode, ruleValue) {
						var result = false;
						var list = ${listOfScenarioName};
						if (list.indexOf(val) == -1) {
							result = true;
						}
						return result;
					}
				</aui:validator>
		</aui:input>
		<aui:input label="simulation-list-form-variable-name"
			name="variableScenarioName" prefix="scenario" readonly="readonly">
		</aui:input>
		<aui:select label="simulation-edit-form-sites" name="sites"
			required="true">
			<c:forEach var="group" items="${listGroup}">
				<aui:option label="${group.name}" value="${group.groupId}" />
			</c:forEach>
		</aui:select>
	</aui:fieldset>

	<aui:button name="ajouter-scenario" type="submit"></aui:button>
</aui:form>