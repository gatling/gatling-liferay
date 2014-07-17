<%@include file="/html/gatling/header.jsp"%>

<div>
	<liferay-ui:header title="simulation-list-header" ></liferay-ui:header>
	<%--Search container (tableau) --%>
	<liferay-ui:search-container emptyResultsMessage="simulation-list-empty" >
		<%--Liste sur laquelle on travail --%>
		<liferay-ui:search-container-results results="${listSimulation }" total="${listSimulation.size() }" />
		<%--itération des colonnes --%>
		<liferay-ui:search-container-row className="com.liferay.sample.model.Simulation"
										keyProperty="simulation_id"
										modelVar="simulation">
			<portlet:renderURL var="editSimulationURL">
				<portlet:param name="page" value="/html/gatling/editSimulation.jsp"/>
				<portlet:param name="simulationId" value="${simulation.simulation_id }"/>						
			</portlet:renderURL>
			<portlet:actionURL var="deleteSimulationURL" name="removeSimulation">
				<portlet:param name="page" value="/html/gatling/editSimulation.jsp"/>
				<portlet:param name="simulationId" value="${simulation.simulation_id }"/>						
			</portlet:actionURL>						
			<%--un champs texte --%>
			<liferay-ui:search-container-column-text name="simulation-list-table-header-name" value="${simulation.name }" href="${editSimulationURL}"/>
			<%--menu action --%>
			<liferay-ui:search-container-column-jsp align="right" path="/html/gatling/simulation_actions.jsp"/>
		</liferay-ui:search-container-row>
		<%--itere et affiche la liste --%>
		<liferay-ui:search-iterator />		
	</liferay-ui:search-container>
</div>

<aui:button id="newSimulation" value="simulation-list-btn-add-simulation"></aui:button>

<%--submit to addSimulation --%>
<portlet:actionURL name="addSimulation" var="addSimulationURL" windowState="normal"/>
<%--Formulaire d'ajout --%>
<div id="newFormSimulation" hidden="true">
	<aui:form action="${addSimulationURL}" name="simulation_fm" id="simulation_fm" >
		<aui:input label="simulation-list-form-nom-simulation" name="simulationName">
			<aui:validator name="required"></aui:validator>
		</aui:input>
		<aui:button  type="submit"></aui:button>
	</aui:form>
</div>

<aui:script>
YUI().use(
  'aui-modal',
  function(Y) {
    var modal = new Y.Modal(
      {
        bodyContent: AUI().one("#newFormSimulation").html(),
        centered: true,
        headerContent: '<h3><liferay-ui:message key="simulation-list-form-header" /></h3>',
        modal: true,
        resizable: false,
        visible: false,
        width: 450
      }
    ).render();
    
    Y.one('#newSimulation').on(
      'click',
      function() {
        modal.show();
      }
    );
  }
);
</aui:script>
