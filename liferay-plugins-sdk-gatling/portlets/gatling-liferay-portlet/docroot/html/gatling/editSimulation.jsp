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
	lien vers la FAQ 
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
	Contenu page 

 --%>
<div>
	<%--Search container (tableau) --%>
	<liferay-ui:search-container emptyResultsMessage="scenario-list-empty">
		<%--Liste sur laquelle on travail --%>
		<liferay-ui:search-container-results results="${listScenario }"
			total="${listScenario.size() }" />
		<%--itération des colonnes --%>
		<liferay-ui:search-container-row
			className="com.excilys.liferay.gatling.model.Scenario"
			keyProperty="scenario_id" modelVar="scenario">
			<portlet:renderURL var="editScenarioURL">
				<portlet:param name="page" value="/html/gatling/editScenario.jsp" />
				<portlet:param name="scenarioId" value="${scenario.scenario_id }" />
			</portlet:renderURL>
			<%--un champs texte --%>
			<c:set var="scenarioName">
				<liferay-ui:message key="simulation-edit-table-scenario-details"
					arguments="${MapScenario.get(scenario)}" />
			</c:set>
			<liferay-ui:search-container-column-text
				name="simulation-edit-table-header-name"
				value="${scenario.name } ${scenarioName}" href="${editScenarioURL}" />
			<%--menu action --%>
			<liferay-ui:search-container-column-jsp align="right"
				path="/html/gatling/scenario_actions.jsp" />
		</liferay-ui:search-container-row>
		<%--itere et affiche la liste --%>
		<liferay-ui:search-iterator paginate="false" />
	</liferay-ui:search-container>
</div>

<aui:button id="newScenario" value="simulation-edit-btn-add-scenario"></aui:button>

<%--redirect to addSimulation --%>
<portlet:actionURL name="addScenario" var="addScenarioURL">
	<portlet:param name="page" value="/html/gatling/editSimulation.jsp" />
	<portlet:param name="simulationId" value="${simulation.simulation_id}" />
</portlet:actionURL>
<%--Formulaire d'ajout --%>
<div id="newFormScenario" hidden="true">
	<aui:form action="${addScenarioURL}" name="fm" id="fm">
		<div class="well well-small">
			<p>
				<liferay-ui:icon-help message="About this page">
					<liferay-ui:message key="create-scenario-help" />
				</liferay-ui:icon-help>
			</p>
		</div>
		<aui:fieldset>
			<aui:input label="simulation-edit-form-name-scenario" name="scenarioName" id="scenarioName">
				<aui:validator name="required" />
				<aui:validator name="alphanum" />
				<aui:validator name="custom" errorMessage="simulation-name-used">
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
				name="variableName" id="variableName" prefix="scenario"
				readonly="readonly">
			</aui:input>
			<aui:select label="simulation-edit-form-sites" name="sites"
				showEmptyOption="true" showRequiredLabel="true">
				<c:forEach var="group" items="${listGroup}">
					<aui:option label="${group.name}" value="${group.groupId}" />
				</c:forEach>
			</aui:select>
		</aui:fieldset>

		<aui:button name="ajouter-scenario" type="submit"></aui:button>
	</aui:form>
</div>



<script type="text/javascript">
	AUI().use('aui-base', 'event', 'aui-modal', function(A) {
		var modal = new A.Modal({
			bodyContent : A.one("#newFormScenario").html(),
			centered : true,
			headerContent : '<h3><liferay-ui:message key="simulation-edit-form-header" /></h3>',
			modal : true,
			resizable : false,
			visible : false,
			zIndex : 100
		}).render();
		//Remove the form template (no duplication otherwise it will never validate the pop-up)
		A.one("#newFormScenario").empty();

		A.one('#newScenario').on('click', function() {
			modal.show();
		});
		A.one("#<portlet:namespace />scenarioName").on("keyup", function(e) {
			A.one("#<portlet:namespace />variableName").val(this.val().replace(/\W/g, ''));
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
