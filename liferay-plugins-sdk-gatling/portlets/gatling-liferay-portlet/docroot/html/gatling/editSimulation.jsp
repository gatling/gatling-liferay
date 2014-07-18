<%@include file="/html/gatling/header.jsp"%>

<portlet:renderURL var="backURL">
	<portlet:param name="page" value="/html/gatling/view.jsp" />
</portlet:renderURL>
<%--entete --%>
<c:set var="entete">
	<liferay-ui:message key="simulation-edit-header" arguments="${simulation.name}" />
</c:set>
<%--session errors --%>
<liferay-ui:error key="scenario-name-required" message="scenario-name-required"/>
<liferay-ui:error key="simulation-duration-required" message="simulation-duration-required"/>
<liferay-ui:error key="simulation-users_per_seconds-required" message="simulation-users_per_seconds-required"/>
<liferay-ui:header title="${entete}" backURL="${backURL}"/>

<div id="myTab">
	<%--Tabs --%>
	<ul class="nav nav-tabs">
		<li class="active"><a href="#tab-1">Scenarios</a></li>
		<li><a href="#tab-2">Details</a></li>
	</ul>
	<%--
	
	=== Tab scenario ===
	
	--%>
	<div class="tab-content">
		<div id="tab-1" class="tab-pane">
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
						<liferay-ui:search-container-column-text name="simulation-edit-table-header-name" value="${scenario.name } (${MapScenario.get(scenario) } requests)"
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
				<aui:form action="${addScenarioURL}" name="scenario_fm" id="scenario_fm">
					<aui:input label="simulation-edit-form-nom-scenario" name="scenarioName">
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
		</div>
		<%--
		
		=== Tab details ===
		
		 --%>
		<div id="tab-2">
			<%--redirect to addSimulation --%>
			<portlet:actionURL name="editSimulation" var="editSimulationURL">
				<portlet:param name="simulationId" value="${simulation.simulation_id}" />
			</portlet:actionURL>
			<div id="details">
			<aui:form action="${editSimulationURL}" name="simulation_details" id="simulation_details">
				<h3>
					<liferay-ui:message key="simulation-edit-details" />
				</h3>
				
				<aui:input label="simulation-edit-nb-users-per-second" name="simulationUsers" value="${simulation.users_per_seconds}">
					<aui:validator name="number"></aui:validator>
				</aui:input>
				
				<aui:input label="simulation-edit-duration" name="simulationDuration" value="${simulation.duration}">
					<aui:validator name="number"></aui:validator>
				</aui:input>
				
				<aui:button name="details-simulation" type="submit"></aui:button>
			</aui:form>
			</div>
		</div>
	</div>

</div>


<aui:script>
YUI().use(
  'aui-tabview',
  function(Y) {
    new Y.TabView(
      {
        srcNode: '#myTab'
      }
    ).render();
  }
);
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
