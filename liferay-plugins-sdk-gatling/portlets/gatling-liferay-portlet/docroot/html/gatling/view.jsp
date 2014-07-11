<%@include file="/html/gatling/header.jsp"%>

<div>
	<h3>Liste des scénarios enregistrés (${listSimulation.size()})</h3>
	<c:choose>
		<c:when test="${empty listSimulation}">
			<p>Il n'y a pas de simulations d'enregistrés !</p>
		</c:when>
		<c:otherwise>
			<c:forEach items="${listSimulation}" var="simulation">
				<ul>
					<li>
						<portlet:renderURL var="editSimulationURL">
							<portlet:param name="mvcPath" value="/html/gatling/editSimulation.jsp"/>
							<portlet:param name="simulationId" value="${simulation.simulation_id }"/>						
						</portlet:renderURL>
						<c:out value="${simulation.name}"></c:out> 
						<a href="${editSimulationURL}"><i class="icon-wrench"></i></a>
						<%--<a href="#"><i class="icon-trash"></i></a>--%>
					</li>
				</ul>
			</c:forEach>
		</c:otherwise>
	</c:choose>
</div>
<hr>
<aui:button id="newSimulation" value="Ajouter Simulation"></aui:button>

<%--redirect to addSimulation --%>
<portlet:actionURL name="addSimulation" var="addSimulationURL" windowState="normal"/>
<%--Formulaire d'ajout --%>
<div id="newFormSimulation" hidden="true">
	<aui:form action="${addSimulationURL}" name="simulation_fm" id="simulation_fm" >
		<aui:input label="nom-simulation" name="simulationName">
			<aui:validator name="required"></aui:validator>
		</aui:input>
		<aui:button name="ajouter-simulation" type="submit"></aui:button>
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
        headerContent: '<h3>Créer nouvelle simulation</h3>',
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
