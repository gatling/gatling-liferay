<%@include file="/html/gatling/header.jsp"%>

<%--
	session errors 
--%>
<liferay-ui:error key="scenario-name-required" message="scenario-name-required" />
<liferay-ui:error key="scenario-name-already-used" message="scenario-name-already-used"/>
<liferay-ui:error key="scenario-groupid-missing" message="scenario-groupid-missing" />
<liferay-ui:error key="scenario-simulationid-missing" message="scenario-simulationid-missing" />
<liferay-ui:error key="scenario-variable-required" message="scenario-variable-required" />
<%--
	header
--%>
<portlet:renderURL var="backURL">
	<portlet:param name="page" value="/html/gatling/view.jsp" />
</portlet:renderURL>

<c:set var="entete">
	<liferay-ui:message key="simulation-edit-header" arguments="${simulation.name}" />
</c:set>
<liferay-ui:header title="${entete}" backURL="${backURL}" />

<%--
	lien vers la FAQ 
--%>
<div class="well well-small">
	<a target="blank" href="https://github.com/excilys/gatling/wiki/Getting-Started">
		<span class="label label-warning"><liferay-ui:message key="help-faq-gatling"/></span>
	</a>
	<a target="blank" href="#">
	<span class="label"><liferay-ui:message key="help-how-to-use-portlet"/></span>
	</a>
	<a target="blank" href="#">
	<span class="label label-info"><liferay-ui:message key="help-what-scenario"/></span>
	</a>
	<hr/>
	<!-- Affichage du message d'info -->
	<p><liferay-ui:icon-help message="About this page" ><liferay-ui:message key="simulation-edit-help" /></liferay-ui:icon-help><p>

</div>

<%--
	Contenu page 

 --%>
<div>
	<%--Search container (tableau) --%>
	<liferay-ui:search-container emptyResultsMessage="scenario-list-empty">
		<%--Liste sur laquelle on travail --%>
		<liferay-ui:search-container-results results="${listScenario }" total="${listScenario.size() }" />
		<%--itération des colonnes --%>
		<liferay-ui:search-container-row className="com.liferay.sample.model.Scenario" keyProperty="scenario_id" modelVar="scenario">
			<portlet:renderURL var="editScenarioURL">
				<portlet:param name="page" value="/html/gatling/editScenario.jsp" />
				<portlet:param name="scenarioId" value="${scenario.scenario_id }" />
			</portlet:renderURL>
			<%--un champs texte --%>
			<liferay-ui:search-container-column-text name="simulation-edit-table-header-name" 
				value="${scenario.name } (${MapScenario.get(scenario)[0] != null ? MapScenario.get(scenario)[0] : 0 }/${MapScenario.get(scenario)[1]} requests, duration: ${MapScenario.get(scenario)[2] != null ? MapScenario.get(scenario)[2] : 0} secondes, ${MapScenario.get(scenario)[3] != null ? MapScenario.get(scenario)[3] : 0} users/s)"
				href="${editScenarioURL}" />
			<%--menu action --%>
			<liferay-ui:search-container-column-jsp align="right" path="/html/gatling/scenario_actions.jsp" />
		</liferay-ui:search-container-row>
		<%--itere et affiche la liste --%>
		<liferay-ui:search-iterator />
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
	<div class="well well-small">
		<p><liferay-ui:icon-help message="About this page" ><liferay-ui:message key="create-scenario-help" /></liferay-ui:icon-help></p>
	</div>
	<aui:form action="${addScenarioURL}" name="scenario_fm" id="scenario_fm">
		<aui:input label="simulation-edit-form-nom-scenario" name="scenarioName" id="scenarioName">
			<aui:validator name="required"></aui:validator>
		</aui:input>
		<aui:input label="simulation-list-form-variable-name" name="variableName" id="variableName" prefix="scenario" readonly="readonly">
			<aui:validator name="required"></aui:validator>
		</aui:input>
		<aui:fieldset>
			<aui:select label="simulation-edit-form-sites" name="sites" showEmptyOption="true">
				<c:forEach var="group" items="${listGroup}">
					<aui:option label="${group.name}" value="${group.groupId}" />
				</c:forEach>
			</aui:select>
		</aui:fieldset>

		<aui:button name="ajouter-scenario" type="submit"></aui:button>
	</aui:form>
</div>



<script type="text/javascript">
YUI().use(
  'aui-modal',
  function(Y) {
    var modal = new Y.Modal(
      {
        bodyContent: AUI().one("#newFormScenario").html(),
        centered: true,
        headerContent: '<h3><liferay-ui:message key="simulation-edit-form-header" /></h3>',
        modal: true,
        resizable: false,
        visible: false,
        zIndex: 100
      }
    ).render();
    
    Y.one('#newScenario').on(
      'click',
      function() {
        modal.show();
      }
    );
  }
);

AUI().use(
		'aui-base',
		'event',
		function(A) {
			A.one("#<portlet:namespace />scenarioName").on("keyup", function(e) {
				A.one("#<portlet:namespace />variableName").val(this.val().replace(/\W/g, ''));
			});
		}
	);
</script>
