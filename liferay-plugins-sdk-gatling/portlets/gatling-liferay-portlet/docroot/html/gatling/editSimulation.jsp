<%@include file="/html/gatling/header.jsp"%>

<%-- <% --%>
<!-- // 	boolean hasAddPermission = permissionChecker.hasPermission( -->
<!-- // 	scopeGroupId, "com.excilys.liferay.gatling.model.Scenario", -->
<!-- // 	scopeGroupId, "ADD_SCENARIO"); -->
<!-- // 		boolean hasConfigurePermission = permissionChecker.hasPermission( -->
<!-- // 	scopeGroupId, "com.excilys.liferay.gatling.model.Scenario", scopeGroupId, -->
<!-- // 	ActionKeys.PERMISSIONS); -->
<%-- %> --%>

<%--
	session errors 
--%>
<liferay-ui:error key="scenario-name-required"
	message="scenario-name-required" />
<liferay-ui:error key="scenario-name-already-used"
	message="scenario-name-already-used" />
<liferay-ui:error key="scenario-groupid-missing"
	message="scenario-groupid-missing" />
<liferay-ui:error key="scenario-simulationid-missing"
	message="scenario-simulationid-missing" />
<liferay-ui:error key="scenario-variable-required"
	message="scenario-variable-required" />
<%--
	header
--%>

<portlet:renderURL var="backURL">
	<portlet:param name="page" value="/html/gatling/view.jsp" />
</portlet:renderURL>

<c:set var="entete">
	<liferay-ui:message key="simulation-edit-header"
		arguments="${simulation.name}" />
</c:set>
<liferay-ui:header title="${entete}" backURL="${backURL}" />

<%--
	 FAQ link
--%>
<portlet:renderURL var="helpURL">
	<portlet:param name="page" value="/html/gatling/help.jsp" />
</portlet:renderURL>
<div class="well well-small">
	<a target="blank"
		href="https://github.com/excilys/gatling/wiki/Getting-Started"> <span
		class="label label-warning"><liferay-ui:message
				key="help-faq-gatling" /></span>
	</a> <a href="${helpURL}"> <span class="label"><liferay-ui:message
				key="help-how-to-use-portlet" /></span>
	</a> <a href="#" class="toggle" data-content="help-scenario"> <span
		class="label label-info"><liferay-ui:message
				key="help-what-scenario" /></span>
	</a>
</div>

<div id="help-scenario"
	class="alert alert-info help-text help-content-hidden">
	<liferay-ui:message key="scenario-explanation" />
</div>

<%--
	Page content
 --%>
<%--Simulation Name --%>
<portlet:actionURL var="editSimulationURL" name="editSimulation" />
<aui:form action="${editSimulationURL}" name="fm_simulation">
	<aui:input name="simulationId" type="hidden"
		value="${simulation.simulation_id }" />
	<aui:input label="simulation-edit-name-simulation"
		name="simulationName" inlineLabel="true" inlineField="true"
		value="${simulation.name }">
		<aui:validator name="alphanum" />
		<aui:validator name="custom"
			errorMessage="simulation-name-already-used">
		 		function (val, fieldNode, ruleValue) {
				var result = false;
				var list = ${listOfSimulationName};
				if (list.indexOf(val) == -1 || val == "${simulation.name}") {
					result = true;
				}
				return result;
			}
		</aui:validator>
	</aui:input>
	<aui:input label="" inlineField="true" inlineLabel="true"
		name="variableSimulationName" prefix="simulation" readonly="readonly">
	</aui:input>
	<aui:button type="submit" />
</aui:form>

<%--Search container (table) --%>
<liferay-ui:search-container emptyResultsMessage="scenario-list-empty">
	<%--Liste of data to display --%>
	<liferay-ui:search-container-results results="${listScenario }"
		total="${listScenario.size() }" />
	<%--for each column --%>
	<liferay-ui:search-container-row
		className="com.excilys.liferay.gatling.model.Scenario"
		keyProperty="scenario_id" modelVar="scenario">
		<portlet:renderURL var="editScenarioURL">
			<portlet:param name="page" value="/html/gatling/editScenario.jsp" />
			<portlet:param name="scenarioId" value="${scenario.scenario_id }" />
		</portlet:renderURL>
		<c:set var="scenarioRequestInfo">
			<liferay-ui:message key="simulation-edit-table-header-requests"
				arguments="${MapScenario.get(scenario)}" />
		</c:set>
		<liferay-ui:search-container-column-text
			name="simulation-edit-table-header-name" value="${scenario.name}"
			href="${editScenarioURL}" />
		<liferay-ui:search-container-column-text
			name="simulation-edit-table-header-requests"
			value="${MapScenario.get(scenario)[0]}/${MapScenario.get(scenario)[1]}" />
		<liferay-ui:search-container-column-text
			name="simulation-edit-table-header-duration"
			value="${scenario.duration }" />
		<liferay-ui:search-container-column-text
			name="simulation-edit-table-header-users"
			value="${scenario.getUsers_per_seconds() }" />
		<liferay-ui:search-container-column-text
			name="simulation-edit-table-header-state">
			<c:choose>
				<c:when test="${MapScenario.get(scenario)[2] == 2}">
					<span class="label label-success"> <liferay-ui:message
							key="message-success-state-scenario" /></span>
					<liferay-ui:icon-help
						message="message-help-info-state-scenario-success" />
				</c:when>
				<c:when test="${MapScenario.get(scenario)[2] == 1}">
					<span class="label label-warning"><liferay-ui:message
							key="message-warning-state-scenario" /></span>
					<liferay-ui:icon-help
						message="message-help-info-state-scenario-warning" />
				</c:when>
				<c:otherwise>
					<span class="label label-important"><liferay-ui:message
							key="message-important-state-scenario" /></span>
					<liferay-ui:icon-help
						message="message-help-info-state-scenario-important" />
				</c:otherwise>
			</c:choose>

		</liferay-ui:search-container-column-text>
		<%--action menu --%>
		<liferay-ui:search-container-column-jsp align="right"
			path="/html/gatling/scenario_actions.jsp" />
	</liferay-ui:search-container-row>
	<%--iterate and show list of data --%>
	<liferay-ui:search-iterator paginate="false" />
</liferay-ui:search-container>

<aui:button id="newScenario" value="simulation-edit-btn-add-scenario"></aui:button>

<%--redirect to addSimulation --%>
<portlet:actionURL name="addScenario" var="addScenarioURL">
	<portlet:param name="page" value="/html/gatling/editSimulation.jsp" />
	<portlet:param name="simulationId" value="${simulation.simulation_id}" />
</portlet:actionURL>
<%-- Add Form --%>
<div id="newFormScenario" hidden="true">
	<%@include file="/html/gatling/template/formNewScenario.jsp"%>
</div>



<script type="text/javascript">
	AUI().use('aui-base','event','aui-modal', function(A) {
 		var modal = new A.Modal({
			bodyContent : A.one("#newFormScenario").html(),
			centered : true,
			headerContent : "<h3><liferay-ui:message key="simulation-edit-form-header" /></h3>",
			modal : true,
			resizable : false,
			visible : false,
			zIndex : 100
		}).render();
		//Remove the form template (no duplication otherwise it will never validate the pop-up)
		A.one("#newFormScenario").empty();
		// Put variableName 
		A.one("#<portlet:namespace />variableSimulationName").val(A.one("#<portlet:namespace />simulationName").val().replace(/\W/g, ''));

		A.one('#newScenario').on('click', function() {
			modal.show();
		});
		A.one("#<portlet:namespace />scenarioName").on("keyup", function(e) {
			A.one("#<portlet:namespace />variableScenarioName").val(this.val().replace(/\W/g, ''));
		});
		
		A.one("#<portlet:namespace />simulationName").on("keyup", function(e) {
			A.one("#<portlet:namespace />variableSimulationName").val(this.val().replace(/\W/g, ''));
		});

		A.all(".toggle").each(function() {
			this.on('click', function(event) {
				var contentId = this.getData("content");
				var texts = A.all(".help-content-display");
				texts.replaceClass("help-content-display", "help-content-hidden");
				var helpText = A.one("#" + contentId);
				if (this.hasClass('help-content-selected')) {
					helpText.replaceClass("help-content-display", "help-content-hidden");
					this.removeClass("help-content-selected");
				} else {
					helpText.replaceClass("help-content-hidden", "help-content-display");
					this.addClass("help-content-selected");
				}
			});
		});
	});
</script>
