<%@include file="/html/gatling/header.jsp"%>

<h3>Scenarios Of ${simulation} :</h3>

<div>
	<h3>Liste des scénarios enregistrés (${listScenarios.size()})</h3>
	<c:choose>
		<c:when test="${empty listscenario}">
			<p>Il n'y a pas de scenario d'enregistrés !</p>
		</c:when>
		<c:otherwise>
			<ul>
				<c:forEach items="${listscenario}" var="scenario">

					<li><portlet:renderURL var="editScenarioURL">
							<portlet:param name="page" value="/html/gatling/editScenario.jsp" />
							<portlet:param name="scenarioId"
								value="${simulation.scenario_id }" />
						</portlet:renderURL> <c:out value="${scenario.name}"></c:out> <a
						href="${editScenarioURL}"><i class="icon-wrench"></i></a> <%--<a href="#"><i class="icon-trash"></i></a>--%>
					</li>

				</c:forEach>
			</ul>
		</c:otherwise>
	</c:choose>
</div>

<aui:button id="newScenario" value="Ajouter Scenario"></aui:button>

<%--redirect to addSimulation --%>
<portlet:renderURL var="editSimulationURL">
	<portlet:param name="page" value="/html/gatling/editSimulation.jsp" />
</portlet:renderURL>
<%--Formulaire d'ajout --%>
<div id="newFormScenario" hidden="true">
	<aui:form action="${addScenarioURL}" name="scenario_fm"
		id="scenario_fm">
		<aui:input label="nom-scenario" name="scenarioName">
			<aui:validator name="required"></aui:validator>
		</aui:input>
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
        headerContent: '<h3>Créer nouvelle scenario</h3>',
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