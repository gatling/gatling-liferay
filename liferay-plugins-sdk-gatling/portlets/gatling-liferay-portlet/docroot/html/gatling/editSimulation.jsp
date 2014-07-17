<%@include file="/html/gatling/header.jsp"%>
 
<portlet:renderURL var="backURL">
	<portlet:param name="page" value="/html/gatling/view.jsp"/>
</portlet:renderURL>
<%--entete --%>
<c:set var="entete"><liferay-ui:message key="simulation-edit-header" arguments="${simulation.name}" /></c:set>
<liferay-ui:header title="${entete}" backURL="${backURL}"/>
<div>
	<%--Search container (tableau) --%>
	<liferay-ui:search-container emptyResultsMessage="scenario-list-empty" >
		<%--Liste sur laquelle on travail --%>
		<liferay-ui:search-container-results results="${listScenario }" total="${listScenario.size() }" />
		<%--it�ration des colonnes --%>
		<liferay-ui:search-container-row className="com.liferay.sample.model.Scenario"
										keyProperty="scenario_id"
										modelVar="scenario">
			<portlet:renderURL var="editScenarioURL">
				<portlet:param name="page" value="/html/gatling/editScenario.jsp" />
				<portlet:param name="scenarioId" value="${scenario.scenario_id }" />
			</portlet:renderURL> 	
			<portlet:actionURL var="removeScenarioURL" name="removeScenario">
				<portlet:param name="scenarioId" value="${scenario.scenario_id }" />
				<portlet:param name="simulationId" value="${scenario.simulation_id }" />
			</portlet:actionURL> 						
			<%--un champs texte --%>
			<liferay-ui:search-container-column-text name="simulation-edit-table-header-name" value="${scenario.name } (${MapScenario.get(scenario) } requests)" href="${editScenarioURL}" />
			<%--lien edition --%>
			<liferay-ui:search-container-column-text>
				<a href="${editScenarioURL}"><liferay-ui:icon image="edit" /><liferay-ui:message key="edit-message"/></a>
			</liferay-ui:search-container-column-text>
			<%-- lien suppression --%>
			<liferay-ui:search-container-column-text> 
				<a href="${removeScenarioURL}"><liferay-ui:icon image="delete" /><liferay-ui:message key="delete-message"/></a>
			</liferay-ui:search-container-column-text>
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
	<aui:form action="${addScenarioURL}" name="scenario_fm" id="scenario_fm">
	<aui:input label="simulation-edit-form-nom-scenario" name="scenarioName">
		<aui:validator name="required"></aui:validator>
	</aui:input>
	<aui:fieldset>
		<aui:select label="simulation-edit-form-sites" name="sites" showEmptyOption="true" >
			<c:forEach var="group" items="${listGroup}">
				<aui:option label="${group.name}" value="${group.groupId}" />
			</c:forEach>
		</aui:select>
	</aui:fieldset>

	<aui:button name="ajouter-scenario" type="submit"></aui:button>
</aui:form>
</div>

<aui:script>
YUI().use(
  'aui-modal',
  function(Y) {
    var modal = new Y.Modal(
      {
        bodyContent: AUI().one("#newFormScenario").html(),
        centered: true,
        headerContent: '<h3><liferay-ui:message key="simulation-edit-form-header"/></h3>',
        modal: true,
        resizable: false,
        visible: false,
        width: 450
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
</aui:script>